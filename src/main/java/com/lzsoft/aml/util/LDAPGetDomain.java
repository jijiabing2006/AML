package com.lzsoft.aml.util;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.apache.commons.lang.StringUtils;

public class LDAPGetDomain {

	public static String getFormatOU(String ou) {
		String[] splt = ou.split(",");
		String realFormat = "";
		for (int i = splt.length - 1; i >= 0; i--) {
			realFormat = realFormat + "OU=" + splt[i] + ",";
		}
		if (',' == realFormat.charAt(realFormat.length() - 1)) {
			realFormat = realFormat.substring(0, realFormat.length() - 1);
		}
		return realFormat;
	}

	public static String getFormatDoamin(String domainName) {
		String[] splt = StringUtils.split(domainName, ".");
		String realFormat = "";
		for (int i = 0; i < splt.length; i++) {
			if (!"".equals(splt[i]))
				realFormat += "DC=" + splt[i] + ",";
		}
		if (',' == realFormat.charAt(realFormat.length() - 1)) {
			realFormat = realFormat.substring(0, realFormat.length() - 1);
		}
		return realFormat;
	}

	public static String GetRemoteDomainUser(LdapContext ctx, String ou,
			String domainName) throws NamingException {
		String xml = "";
		SearchControls searchCtls = new SearchControls();
		searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
		String searchFilter = "objectClass=User";
		String searchBase = "";
		searchBase = ou + "," + getFormatDoamin(domainName);
		String returnedAtts[] = { "name", "telephoneNumber", "mobile", "mail" };
		searchCtls.setReturningAttributes(returnedAtts);

		NamingEnumeration answer = ctx.search(searchBase, searchFilter,
				searchCtls);

		while (answer.hasMoreElements()) {
			SearchResult sr = (SearchResult) answer.next();
			int oulenth = 0;
			Attributes Attrs = sr.getAttributes();
			if (Attrs != null) {
				try {
					xml += "<User ";
					for (NamingEnumeration ne = Attrs.getAll(); ne.hasMore();) {
						Attribute Attr = (Attribute) ne.next();

						if ("name".equals(Attr.getID())) {
							xml += "name=";
						}
						if ("telephoneNumber".equals(Attr.getID())) {
							xml += "tel=";
						}
						if ("mobile".equals(Attr.getID())) {
							xml += "mobile=";
						}
						if ("mail".equals(Attr.getID())) {
							xml += "email=";
						}
						Enumeration values = Attr.getAll();
						if (values != null) {
							while (values.hasMoreElements()) {
								xml += "\"" + values.nextElement() + "\" ";
								oulenth = oulenth + 1;
							}
						}
					}
					xml += "/>";
				} catch (NamingException e) {
					System.err.println("Throw Exception : " + e);
				}
			}
		}
		return xml;
	}

	public String GetRemoteDomainGroupDie(LdapContext ctx, String ou,
			String domainName) throws NamingException {
		String xml = "";
		SearchControls searchCtls = new SearchControls();
		searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
		String searchFilter = "objectClass=organizationalUnit";
		String searchBase = "";
		searchBase = ou + "," + getFormatDoamin(domainName);
		String returnedAtts[] = { "name" };

		searchCtls.setReturningAttributes(returnedAtts);

		NamingEnumeration answer = ctx.search(searchBase, searchFilter,
				searchCtls);
		while (answer.hasMoreElements()) {
			SearchResult sr = (SearchResult) answer.next();
			String ouName = sr.getName();
			// System.out.println(ouName);
			if (ouName != null && !"".equals(ouName)) {

				Attributes Attrs = sr.getAttributes();
				if (Attrs != null) {
					try {
						for (NamingEnumeration ne = Attrs.getAll(); ne
								.hasMore();) {
							Attribute Attr = (Attribute) ne.next();
							if ("name".equals(Attr.getID())) {
								Enumeration values = Attr.getAll();
								if (values != null) { // 迭代
									while (values.hasMoreElements()) {
										String v = (String) values
												.nextElement();
										xml += "<Group name=\"" + v + "\">";
										xml += GetRemoteDomainUser(ctx, "OU="
												+ v + "," + ou, domainName);
										xml += GetRemoteDomainGroupDie(ctx,
												"OU=" + v + "," + ou,
												domainName);
										xml += "</Group>";
									}
								}

							}

						}

					} catch (NamingException e) {
						e.printStackTrace();
					}
				}
			} else {
				xml += GetRemoteDomainUser(ctx, getFormatOU(ou), domainName);
			}

		}
		return xml;
	}

	public String GetRemoteDomainGroup(String ip, String port,
			String adminName, String adminPassword, String domainName, String ou) {
		String xml = "<?xml version=\"1.0\" encoding=\"gbk\" ?>";
		Hashtable<String, String> HashEnv = new Hashtable<String, String>();
		String rport = port;
		if (port == null || "".equals(port))
			rport = "389";
		String LDAP_URL = "ldap://" + ip + ":" + rport;
		adminName = adminName + "@" + domainName;
		HashEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		HashEnv.put(Context.SECURITY_PRINCIPAL, adminName);
		HashEnv.put(Context.SECURITY_CREDENTIALS, adminPassword);
		// Password
		HashEnv.put(Context.INITIAL_CONTEXT_FACTORY,
				"com.sun.jndi.ldap.LdapCtxFactory");
		HashEnv.put(Context.PROVIDER_URL, LDAP_URL);

		try {
			LdapContext ctx = new InitialLdapContext(HashEnv, null);
			SearchControls searchCtls = new SearchControls();
			searchCtls.setSearchScope(SearchControls.ONELEVEL_SCOPE);
			String searchFilter = "objectClass=organizationalUnit";
			String searchBase = "";
			searchBase = getFormatOU(ou) + "," + getFormatDoamin(domainName);
			String returnedAtts[] = { "name" };

			searchCtls.setReturningAttributes(returnedAtts);

			NamingEnumeration answer = ctx.search(searchBase, searchFilter,
					searchCtls);
			int oulenth = 0;
			String[] splt = ou.split(",");
			for (int j = 0; j < splt.length; j++) {
				if (!"".equals(splt[j])) {
					xml = xml + "<Group name=\"" + splt[j] + "\">";
					oulenth = oulenth + 1;
				}
			}
			xml += GetRemoteDomainUser(ctx, getFormatOU(ou), domainName);
			xml += GetRemoteDomainGroupDie(ctx, getFormatOU(ou), domainName);
			for (int i = 0; i < oulenth; i++) {
				xml += "</Group>";
			}
			ctx.close();
		}

		catch (NamingException e) {
			e.printStackTrace();
		}
		return xml;
	}

	public static void main(String args[]) {
		LDAPGetDomain ad = new LDAPGetDomain();
		System.out.println(ad.GetRemoteDomainGroup("10.128.1.30", "389",
				"sysmanager", "CathaybkCN2010", "CUBCN.INTRA.UWCCB", "USER-ID_ROOT"));
		
		
		
		
	}
}
