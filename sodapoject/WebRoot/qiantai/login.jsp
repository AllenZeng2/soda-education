﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>

<link href="qiantai/css/style.css" type="text/css" rel="stylesheet" />
<link href="qiantai/css/single.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="qiantai/js/banner1.js"></script>
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

</script>

</head>

<body>
<form name="myform" action="${pageContext.request.contextPath }/LoginServlet" method="post" onsubmit="return ckform()">
	<input type="hidden" name="param" value="frontlogin" />
	<iframe style="width: 100%; height: 236px" scrolling="no"
		frameborder="0" src="qiantai/header.jsp" name="kangjiaIframe"></iframe>

	<div class="content">

		<div class="clear"></div>
		<div class="buyDiv">

			<div class="buyHeader">
				<h1 style="cursor: pointer"
					onclick="javascript:location.href='qiantai/regist.jsp'">注册</h1>
				<!--<div class="innerDiv">返回</div>-->
				<div class="innerDiv"
					onclick="javascript:document.myform.submit();">登录</div>

			</div>


			<div class="loginBody">
				<fieldset class="registField">
					<legend style="color: #DE3237;" align="left">登录</legend>
				
						<table class="registTable" name="logintable">
							<tr>
								<td align="right" style="width: 30%;">用户名</td>
								<td></td>
								<td align="left"><input
								onblur="ckname()" id="loginName"
								 type="text" name="st_loginName" />  <span id="spLoginName"></span></td>
							</tr>
							<tr>
								<td align="right">密码</td>
								<td></td>
								<td align="left"><input onblur="ckPwd()" type="password"
								  id="pwd" name="st_password" /><span id="spPwd"></span></td>
							</tr>
							<!--  
							<tr>
								<td align="right">验证码</td>
								<td><img src="" /></td>
								<td align="left"><input type="text" /></td>
							</tr>
							-->
						</table>

				</fieldset>
			</div>
		</div>
		<div class="clear"></div>
		<!--清除浮动-->
	</div>
	<!--content end-->



	<div class="footer">
		<ul>


			<li class="li_left">地址：北京海淀区成府路**号</li>
			<li class="li_right">联系电话：010-82365636</li>
		</ul>
	</div>
	<!--footer end-->
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</form>
</body>
</html>