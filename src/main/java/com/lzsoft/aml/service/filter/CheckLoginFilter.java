package com.lzsoft.aml.service.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;

import com.lzsoft.aml.common.Constants;

/**
 * 用于检测用户是否登陆的过滤器，如果未登录，则重定向到指的登录页面
 * <p>
 * 配置参数
 * <p>
 * checkSessionKey 需检查的在 Session 中保存的关键字 <br/>
 * redirectURL 如果用户未登录，则重定向到指定的页面，URL不包括 ContextPath <br/>
 * notCheckURLList 不做检查的URL列表，以分号分开，并且 URL 中不包括 ContextPath <br/>
 */
public class CheckLoginFilter implements Filter {
	protected FilterConfig filterConfig = null;
	@SuppressWarnings("unused")
	private String redirectURL = null;
	private List<String> notCheckURLList = new ArrayList<String>();
	private String sessionKey = null;
	private String checkDomainUserKey = null;

	@Override
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();
		response.addHeader("Cache-Control", "no-cache");
		response.addHeader("Pragma", "no-cache");
		response.addHeader("Cache-Control", "no-store");
		response.addHeader("Cache-Control", "must-revalidate");

		response.setDateHeader("Expires", -1);
		if (null == sessionKey) {
			filterChain.doFilter(request, response);
			return;
		}
		boolean flag = checkRequestURIIntNotFilterList(request);
		if ((!flag) && null == session.getAttribute(sessionKey)) {

			String auth = request.getHeader("Authorization");
			if (auth == null) {
				response.setStatus(response.SC_UNAUTHORIZED);
				response.setHeader("WWW-Authenticate", "NTLM");
				response.flushBuffer();
				return;
			}
			if (auth.startsWith("NTLM ")) {
				byte[] m = new sun.misc.BASE64Decoder().decodeBuffer(auth
						.substring(5));
				byte[] msg = Base64.decodeBase64(auth.substring(5));

				int off = 0, length, offset;
				if (msg[8] == 1) {
					byte z = 0;
					byte[] msg1 = { (byte) 'N', (byte) 'T', (byte) 'L',
							(byte) 'M', (byte) 'S', (byte) 'S', (byte) 'P', z,
							(byte) 2, z, z, z, z, z, z, z, (byte) 40, z, z, z,
							(byte) 1, (byte) 130, z, z, z, (byte) 2, (byte) 2,
							(byte) 2, z, z, z, z, z, z, z, z, z, z, z, z };
					response.setHeader("WWW-Authenticate", "NTLM "
							+ new sun.misc.BASE64Encoder().encode(msg1));
					response.sendError(response.SC_UNAUTHORIZED);
					return;
				} else if (msg[8] == 3) {
					off = 30;

					length = msg[off + 17] * 256 + msg[off + 16];
					offset = msg[off + 19] * 256 + msg[off + 18];

					String remoteHost = getInfo(msg, length, offset);

					length = msg[off + 1] * 256 + msg[off];
					offset = msg[off + 3] * 256 + msg[off + 2];
					String domain = getInfo(msg, length, offset);

					length = msg[off + 9] * 256 + msg[off + 8];
					offset = msg[off + 11] * 256 + msg[off + 10];
					String username = getInfo(msg, length, offset);

					// System.out.println(username);
					// System.out.println(domain);
					// System.out.println(remoteHost);
					session.setAttribute("domainuser", username);
					session.setAttribute("domainname", domain);

				}
			}
//			if (null != session.getAttribute("domainname")) {
//				response.sendRedirect(request.getContextPath()
//						+ Constants.AUTO_LOGIN);
//			} else {
				response.sendRedirect(request.getContextPath()
						+ Constants.LOGIN);
//			}
		} else {
			filterChain.doFilter(servletRequest, servletResponse);
		}
	}

	private String getInfo(byte[] msg, int length, int offset) {
		byte[] d = new byte[length];
		System.arraycopy(msg, offset, d, 0, length);
		String space = new String(new byte[] { 0x00 });
		return new String(d).replaceAll(space, "");

		// d=getCommonsBytes(d);
		// return null!=d?new String(d):"";
	}

	public static String removeAllBlank(String s) {
		String result = "";
		if (null != s && !"".equals(s)) {
			result = s.replaceAll("[　*| *| *|//s*]*", "");
		}
		return result;

	}

	public byte[] getCommonsBytes(byte[] bs) {

		byte[] tb = new byte[bs.length];
		int j = -1;
		for (int i = 0; i < bs.length; i++) {
			byte b = bs[i];
			if (Integer.parseInt(Byte.toString(b)) > 31
					&& Integer.parseInt(Byte.toString(b)) < 127) {
				j++;
				tb[j] = b;

			}
		}
		if (j > 0) {
			byte[] nb = new byte[j + 1];
			System.arraycopy(tb, 0, nb, 0, j + 1);
			System.out.println(nb.length);
			return nb;
		}

		return null;
	}

	@Override
	public void destroy() {
		notCheckURLList.clear();
	}

	private boolean checkRequestURIIntNotFilterList(HttpServletRequest request) {
		String uri = request.getServletPath()
				+ (request.getPathInfo() == null ? "" : request.getPathInfo());
		return notCheckURLList.contains(uri);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		redirectURL = filterConfig.getInitParameter("redirectURL");
		sessionKey = filterConfig.getInitParameter("checkSessionKey");
		checkDomainUserKey = filterConfig
				.getInitParameter("checkDomainUserKey");

		String notCheckURLListStr = filterConfig
				.getInitParameter("notCheckURLList");

		if (notCheckURLListStr != null) {
			StringTokenizer st = new StringTokenizer(notCheckURLListStr, ";");
			notCheckURLList.clear();
			while (st.hasMoreTokens()) {
				notCheckURLList.add(st.nextToken());
			}
		}
	}
}