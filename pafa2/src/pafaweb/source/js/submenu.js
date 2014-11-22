function aa(Dir)
{tt.doScroll(Dir);Timer=setTimeout('aa("'+Dir+'")',100)}//??100?????
function StopScroll(){if(Timer!=null)clearTimeout(Timer)}
function exitbbs(){
str=location.href;
hrefNum= str.indexOf("?");
//alert ( str.charAt(hrefNum+1) );
var exit_href;
	if (str.charAt(hrefNum+1) == '1') {
		exit_href = "news";
		if (str.charAt(hrefNum+2) == '0') {
			exit_href = "health";
		}
		else if (str.charAt(hrefNum+2) == '1') {
			exit_href = "auto";
		}
		else if (str.charAt(hrefNum+2) == '2') {
			exit_href = "mobile";
		}
		else if (str.charAt(hrefNum+2) == '3') {
			exit_href = "buy";
		}
		else if (str.charAt(hrefNum+2) == '4') {
			exit_href = "gz";
		}
		else if (str.charAt(hrefNum+2) == '5') {
			exit_href = "sh";
		}
	}
	else if (str.charAt(hrefNum+1) == '2') {
		exit_href = "eurocup";
	}
	else if (str.charAt(hrefNum+1) == '3') {
		exit_href = "stock";	
	}
	else if (str.charAt(hrefNum+1) == '4') {
		exit_href = "tech";	
	}
	else if (str.charAt(hrefNum+1) == '5'){
		exit_href = "biz";	
	}
	else if (str.charAt(hrefNum+1) == '6') {
		exit_href = "life";	
	}
	else if (str.charAt(hrefNum+1) == '7'){
		exit_href = "home";	
	}
	else if (str.charAt(hrefNum+1) == '8'){
		exit_href = "house";	
	}
	else if (str.charAt(hrefNum+1) == '9') {
		exit_href = "travel";	
	}
	top.location.href = "http://" + exit_href + ".163.com";
}
function initIt(){
divColl=document.all.tags("DIV");
for(i=0; i<divColl.length; i++) {
whichEl=divColl(i);
if(whichEl.className=="child")whichEl.style.display="none";}
}
function expands(el) {
whichEl1=document.getElementById(el+"Child");
if (whichEl1.style.display=="none"){
initIt();
whichEl1.style.display="block";
}else{whichEl1.style.display="none";}
}
var tree= 0;
function loadThreadFollow(){
if (tree==0){
document.frames["hiddenframe"].location.replace("LeftTree.asp");
tree=1
}
}
function showsubmenu(sid)
{
	try
	{
		var whichEl = document.getElementById("submenu" + sid);
		var imgmenu = document.getElementById("imgmenu" + sid);
		if (whichEl.style.display == "none")
		{
			for( i=1;i<=17;i++)
			{
				whichEl = document.getElementById("submenu" + i);
				imgmenu = document.getElementById("imgmenu" + i);
				if(whichEl.style.display == "")
				{
					document.getElementById("submenu" + i).style.display="none";
					imgmenu.background="/images/menudown.gif";
				}
			}
			document.getElementById("submenu" + sid).style.display="";
			//imgmenu.background="/images/menuup.gif";
		}
		else
		{
			document.getElementById("submenu" + sid).style.display="none";
			imgmenu.background="/images/menudown.gif";
		}
	}
	catch(e)
	{}
}

