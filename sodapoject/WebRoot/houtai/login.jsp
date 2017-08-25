<%@page import="com.soda.entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<base href="<%=basePath%>">
<title>soda教育后台管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link href="houtai/css/style.css" rel="stylesheet" type="text/css">
<script src="houtai/js/main.js" type="text/javascript"></script>
<script type="text/javascript">
	
		function ckname(){
		//获得输入的用户名
				var vuname = document.getElementById("loginName").value;
				//判断用户名是否为空
				document.getElementById("spLoginName").style.color="red";
				if (vuname == null || vuname.length == 0) {
					document.getElementById("spLoginName").innerHTML="用户名不能为空";
					return false;
				}
					return true;
	
			}
			

		function ckPwd(){
		//获得输入的用户名
				var vuname = document.getElementById("pwd").value;
				//判断用户名是否为空
				document.getElementById("spPwd").style.color="red";
				if (vuname == null || vuname.length == 0) {
					document.getElementById("spPwd").innerHTML="密码不能为空";
					return false;
				}
					return true;
			}
	function ckform(){
		return ckname()&&ckPwd();
	}
	var xhr;
	function login(){
	var name=document.getElementById("loginName").value;
	var pwd=document.getElementById("pwd").value;
	xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function (){
		if(xhr.readyState==4){
			if(xhr.responseText=="true"){
				location.href="houtai/main.jsp";
			}else{
			document.getElementById("spcc").innerHTML=xhr.responseText;
			}
		}
	
	};
	xhr.open("get", "LoginServlet?param=login&ur_loginName="+name+"&ur_password="+pwd,true);
	xhr.send(null);
	}
	

	
	
</script>

<style type="text/css">
#spcc{
position: absolute;
}
</style>
</head>


<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" scroll="no">

<span style="color: red">
<div id="spcc"></div>
 </span>
 
<form name="myform" action="${pageContext.request.contextPath }/LoginServlet" method="post" onsubmit="return ckform()">
<input type="hidden" name="param" value="login" />
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0" name="loginTable" >
  <tr>
    <td height="100%" align="center" bgcolor="#e3efff">

    <table width="762" height="435" border="0" cellpadding="0" cellspacing="0"
     background="houtai/images/loginBg.gif" name="loginTable2">

      <tr>
        <td><table border="0" align="center" cellpadding="0" 
        cellspacing="7" name="loginTable3">
          <tr>
          
            <td>用户名：</td>

            <td><input id="loginName" name="ur_loginName" onblur="ckname()" 
            type="text" class="inputbox" 
            style="width:160px;hight:20px" >
            <span id="spLoginName"></span>
            </td>

            </tr>
          <tr>
            <td>密　码：</td>

            <td><input onblur="ckPwd()" name="ur_password" type="text" class="inputbox" 
            id="pwd"
            style="width:160px;hight:20px"><span id="spPwd"></span></td>

            </tr>
            
          <tr>

            <td height="100" colspan="2" valign="top"><table border="0" 
            align="center" cellpadding="0" cellspacing="5">

              <tr>

                <td align="center"><BUTTON style="HEIGHT:25px" type="button"
                onClick="login();return false;" name="submit"><img 
                src="houtai/images/login_enter.gif" width="16" height="16" align="absmiddle"> 
                	登录</BUTTON></td>
                <td align="center"><BUTTON style="HEIGHT:25px" type="reset" 
                name="reset"><img src="houtai/images/login_cancel.gif" width="16" height="16"
                 align="absmiddle" > 重置</BUTTON></td>

                </tr>
            </table></td>
            </tr>
          </table></td>
        </tr>
    </table></td>
  </tr>
</table>

</form>

</body>
</html>