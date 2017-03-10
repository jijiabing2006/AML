<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="com.lzsoft.aml.web.login.*,com.lzsoft.aml.web.*,org.apache.commons.lang3.ArrayUtils"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    This is my JSP page. <br>
    <%
	String auth = request.getHeader("Authorization");
	if (auth == null) {
		response.setStatus(response.SC_UNAUTHORIZED);
		response.setHeader("WWW-Authenticate", "NTLM");
		response.flushBuffer();
		return;
	}
	if (auth.startsWith("NTLM ")) {
		byte[] msg = new sun.misc.BASE64Decoder().decodeBuffer(auth.substring(5));
		out.println("msg:" + new String(msg )+ "<BR>");
		out.println("auth:" + new String(auth )+ "<BR>");
		int off = 0, length, offset;
		if (msg[8] == 1) {
			byte z = 0;
			byte[] msg1 = { (byte) 'N', (byte) 'T', (byte) 'L', (byte) 'M', (byte) 'S', (byte) 'S', (byte) 'P',
					z, (byte) 2, z, z, z, z, z, z, z, (byte) 40, z, z, z, (byte) 1, (byte) 130, z, z, z,
					(byte) 2, (byte) 2, (byte) 2, z, z, z, z, z, z, z, z, z, z, z, z };
			response.setHeader("WWW-Authenticate", "NTLM " + new sun.misc.BASE64Encoder().encodeBuffer(msg1));
			response.sendError(response.SC_UNAUTHORIZED);
			return;
		} else if (msg[8] == 3) {
			off = 30;

			length = msg[off + 17] * 256 + msg[off + 16];
			out.println(new String(msg)+ "<BR>");
			offset = msg[off + 19] * 256 + msg[off + 18];
			String remoteHost = new String(msg, offset, length);

			length = msg[off + 1] * 256 + msg[off];
			offset = msg[off + 3] * 256 + msg[off + 2];
			String domain = new String(msg, offset, length);

			length = msg[off + 9] * 256 + msg[off + 8];
			offset = msg[off + 11] * 256 + msg[off + 10];
			String username = new String(msg, offset, length);
			out.println("Username:" + username + "<BR>");
			out.println("Username:" + username.length() + "<BR>");
			out.println("RemoteHost:" + remoteHost + "<BR>");
			out.println("Domain:" + domain + "<BR>");
		


			
		}
	}
%>
  </body>
</html>
