<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>


<script type="text/javascript">
	function ckform(){
		return ckpwd()&&ckloginname()&&ckname()&&ckidcard()&&ckaddress()&&ckemail()&&ckphone();
	}
	function ckpwd(){
		var vpwd=document.getElementById("textfield3").value;
		document.getElementById("spPwd").style.color="red";
		if(vpwd==null||vpwd.length==0){
			document.getElementById("spPwd").innerHTML="密码不能为空";
			return false;
		}
		if (vpwd.length < 6) {
					document.getElementById("spPwd").innerHTML="密码不能短于6位";
					return false;
				}
		document.getElementById("spPwd").style.color="green";
		document.getElementById("spPwd").innerHTML="√";
		return true;
	}
	
	function ckloginname(){
		//获得输入的用户名

				var vuname = document.getElementById("loginName").value;
				//判断用户名是否为空
				document.getElementById("spLoginName").style.color="red";
				if (vuname == null || vuname.length == 0) {
					document.getElementById("spLoginName").innerHTML="用户名不能为空";
					return false;
				}
				//判断用户名是否够长
				if (vuname.length < 3) {
					document.getElementById("spLoginName").innerHTML="用户名不能短于3位";
					return false;
				}
 	 			if(!sameName){
					document.getElementById("spLoginName").innerHTML="用户名已存在";
					return false;
				} 
				//验证通过
				document.getElementById("spLoginName").style.color="green";
				document.getElementById("spLoginName").innerHTML="√";
				return true;
				
	}
	
	function ckname(){
		//获得输入的用户名
				var vuname = document.getElementById("textfield15").value;
				
				//判断用户名是否为空
				document.getElementById("spName").style.color="red";
				if (vuname == null || vuname.length == 0) {
					document.getElementById("spName").innerHTML="用户名不能为空";
					return false;
				}
				
				//判断用户名是否够长
				if (vuname.length < 3) {
					document.getElementById("spName").innerHTML="用户名不能短于3位";
					return false;
				}
				
				//验证通过
				document.getElementById("spName").style.color="green";
				document.getElementById("spName").innerHTML="√";
				return true;
	}
	
				var xhr;
		function sameName2(){
				var vuname = document.getElementById("loginName").value;
				xhr=new XMLHttpRequest();
				xhr.onreadystatechange=resName;
				xhr.open("get", "UserServlet?param=sameName&name="+vuname,true);
				xhr.send(null);
				
				}	
		function resName(){
				sameName=true;
			if(xhr.readyState==4&&xhr.status==200){
				var txt=xhr.responseText;
				var tt="same";
				if(txt==tt){
				//document.getElementById("spLoginName").innerHTML="用户名已存在";
					sameName=false;
				}
			}			
		}
	
	
	function ckidcard(){
	var vid=document.getElementById("idcard").value;
	document.getElementById("spIdcard").style.color="red";
	var reg=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|12]\d)|3[0-1])\d{3}([0-9]|X)$/;
	if(vid==null||vid.length==0){
		document.getElementById("spIdcard").innerHTML="身份证号码不能为空";
		return false;
	}
	if(!reg.test(vid)){
		document.getElementById("spIdcard").innerHTML="请输入正确的身份证号码";
		return false;
	}
	document.getElementById("spIdcard").style.color="green";
	document.getElementById("spIdcard").innerHTML="√";
	ajx();
		return true;
	
	
	
	}
	function ckphone(){
	//移动号码
	var reg = /^1[34578]\d{9}$/;
	var phone=document.getElementById("textfield2").value;
	document.getElementById("spPhone").style.color="red";
	if(phone==null||phone.length==0){
		document.getElementById("spPhone").innerHTML="手机号不能为空";
		return false;
	}
	if(!reg.test(phone)){
		document.getElementById("spPhone").innerHTML="号码输入有误";
		return false;
	}
	document.getElementById("spPhone").style.color="green";
	document.getElementById("spPhone").innerHTML="√";
	return true;
	
	}
	function ckaddress(){
				var vud = document.getElementById("textfield6").value;

				document.getElementById("spAddress").style.color="red";
				if (vud == null || vud.length == 0) {
					document.getElementById("spAddress").innerHTML="地址不能为空";
					return false;
				}
				//判断地址是否够长
				if (vud.length < 6) {
					document.getElementById("spAddress").innerHTML="地址不能短于6位";
					return false;
				}
				//验证通过
				document.getElementById("spAddress").style.color="green";
				document.getElementById("spAddress").innerHTML="√";
				return true;
	}
	function ckemail(){
		var reg = /^\w+@\w+[\.][a-zA-Z]{2,3}([\.][a-zA-Z]{2,3})?$/;
				var vemail = document.getElementById("textfield").value;
				document.getElementById("spEmail").style.color="red";
				if (!reg.test(vemail)) {
					document.getElementById("spEmail").innerHTML="电子邮箱格式不正确";
					return false;
				}
				document.getElementById("spEmail").style.color="green";
				document.getElementById("spEmail").innerHTML="√";
				return true;
	}
	
	var xhr3;
	function ajx(){
		var idcard=document.getElementById("idcard").value;
		xhr3=new XMLHttpRequest();
		xhr3.onreadystatechange=gender;
		xhr3.open("get","UserServlet?param=gender&idcard="+idcard,true);
		xhr3.send(null);
	}
	function gender(){
		if(xhr3.readyState==4&&xhr3.status==200){
		
			if(xhr3.responseText=="1")
			document.getElementById("male").checked="checked";
			else
			document.getElementById("female").checked="checked";
		}
	}

</script>


</head>
<body>
<form name="myform" action="${pageContext.request.contextPath}/UserServlet?param=add" method="post" onsubmit="return ckform()">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="addTable">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;用户管理
    </td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="addTable2">
        <tr>
          <td width="20" height="34"><img src="houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>添加用户</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          <a href="javascript:history.go(-1);" class="barBtn" onClick="javascript:history.go(-1);" name="retreat"><img src="houtai/images/btn_left.gif" align="absmiddle"> 后退</a>
          <a href="javascript:history.go(+1);" class="barBtn" onClick="javascript:history.go(+1);"name="advance"><img src="houtai/images/btn_right.gif" align="absmiddle"> 前进</a>
          <a href="Javascript:location.reload();" class="barBtn" name="flush"><img src="houtai/images/btn_refresh.gif" align="absmiddle"> 刷新</a>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1" name="addTable3">
        <TR>
          <th width="20%" align="center">用户登录名</th>
          <TD class="BGCgray"><input type="text" 
          name="ur_loginName" id="loginName" onblur="ckloginname()" onmouseout="sameName2()"/>
          
          <span id="spLoginName"></span>
          
          </TD>
          </TR>
        <TR>
          <th align="center">密码</th>
          <TD width="80%" class="BGCgray"><input type="text" id="textfield3" name="ur_password" onblur="ckpwd()">
          <span id="spPwd"></span>
          </TD>
          </TR>
        <TR>
          <th align="center"><span class="BGCgray">真实姓名</span></th>
          <TD class="BGCgray"><input  type="text" id="textfield15" onblur="ckname()" name="ur_name">
          <span id="spName"></span>
          
          </TD>
        </TR>
		 <TR>
          <th align="center"><span class="BGCgray">身份证</span></th>
          <TD class="BGCgray">
          <input name="textfield15" type="text" id="idcard"
           onblur="ckidcard()" name="ur_idcard">
          
          <span id="spIdcard"></span>
          </TD>
        </TR>
        <TR>
          <th align="center">性别</th>
          <TD class="BGCgray">
         <input type="radio" name="ur_sex" id="male" value="1" checked="checked"/>男
          <input type="radio" id="female" name="ur_sex" value="2"/>女
          </TD>
        </TR>
        <TR>
          <th align="center">联系电话</th>
          <TD class="BGCgray"><input name="ur_phone" type="text" id="textfield2" onblur="ckphone()">
          <span id="spPhone"></span>
          
          </TD>
        </TR>
        <TR>
          <th align="center">地址</th>
          <TD class="BGCgray"><input name="ur_adress" type="text" id="textfield6" onblur="ckaddress()">
           <span id="spAddress"></span>
           
          </TD>
        </TR>
        <TR>
          <th align="center">邮箱</th>
          <TD class="BGCgray"><input name="ur_email" type="text" id="textfield" onblur="ckemail()">
          <span id="spEmail"></span>
          </TD>
        </TR>
	<TR>
          <th align="center">角色</th>
          <TD class="BGCgray"><select name="ur_roleId">
		
		<option value=1 >超级管理员</option>
		<option value=2 >管理员</option>
		<option value=3 >页面管理员</option>
		<option value=4 >讲师</option>
	</select></TD>
        </TR>
        <TR>
          <th align="center">状态</th>
          <TD class="BGCgray"><select name="ur_state" id="select">
            <option value=1>启用</option>
            <option value=0>禁用</option>
          </select></TD>
        </TR>
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('保存信息？')) document.myform.submit();else return false;" name="submit"><img src="houtai/images/btn_save.gif" width="16" height="16" align="absmiddle"> 保存</BUTTON>
        <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('您填写的信息还未保存，确认返回么？')) history.go(-1);return false;" name="back"><img src="houtai/images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回</BUTTON>
      </div>
    </div>
  </td>
  </tr>
</table>
</form>
</body>
</html>