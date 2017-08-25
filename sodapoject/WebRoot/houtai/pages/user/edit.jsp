<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		return ckpwd()&&ckname()&&ckidcard()&&ckaddress()&&ckemail()&&ckphone();
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
					document.getElementById("spName").innerHTML="用户名不能短于6位";
					return false;
				}
				//验证通过
				document.getElementById("spName").style.color="green";
				document.getElementById("spName").innerHTML="√";
				return true;
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
	<form name="formboss"
		action="${pageContext.request.contextPath}/UserServlet?param=edit&id=${user.ur_id }"
		method="post" onsubmit="return ckform()">
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3" name="editTable">
			<tr>
				<td style="height:25px; background-color:#f3f3f3; font-weight:bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
					<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;用户管理
				</td>
			</tr>
			<tr>
				<td
					style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="editTable2">
						<tr>
							<td width="20" height="34"><img
								src="houtai/images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color:#90c8e8;"><img
								src="houtai/images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>修改用户信息</strong></td>
							<td align="right" class="white" style="padding-right:20px">
								<a href="javascript:history.go(-1);" class="barBtn"
								onClick="javascript:history.go(-1);" name="retreat"><img
									src="houtai/images/btn_left.gif" align="absmiddle"> 后退</a> <a
								href="javascript:history.go(+1);" class="barBtn"
								onClick="javascript:history.go(+1);" name="advance"><img
									src="houtai/images/btn_right.gif" align="absmiddle"> 前进</a> <a
								href="javascript:location.reload();" class="barBtn" name="flush"><img
									src="houtai/images/btn_refresh.gif" align="absmiddle"> 刷新</a>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow:auto;height:100%; width:100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="editTable3">
							<TR>
								<th width="20%" align="center">用户登录名</th>
								
								<TD class="BGCgray"><input type="text"
									
									value="${user.ur_loginName }" name="ur_loginName"
									readonly="readonly" /></TD>
							</TR>
							<TR>
								<th align="center">密码</th>
								<TD width="80%" class="BGCgray"><input type="text"
									onblur="ckpwd()"
									id="textfield3" value="${user.ur_password }" name="ur_password"> <span id="spPwd"></span>
								</TD>
							</TR>
							<TR>
								<th align="center"><span class="BGCgray">真实姓名</span></th>
								<TD class="BGCgray">
								<input name="ur_name" type="text"
									onblur="ckname()"
									id="textfield15" value="${user.ur_name }" /> 
									<span id="spName"></span>

								</TD>
							</TR>
							<TR>
								<th align="center"><span class="BGCgray">身份证</span></th>
								<TD class="BGCgray">
								<input name="ur_idcard" type="text"
									onblur="ckidcard()"
									id="idcard" value="${user.ur_idcard }" />
									 <span
									id="spIdcard"></span>
          
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
          <TD class="BGCgray">
          <input 
          onblur="ckphone()"
           name="ur_phone" type="text" id="textfield2" value="${user.ur_phone }"/>
          
           <span id="spPhone"></span>
          
          </TD>
        </TR>
        <TR>
          <th align="center">地址</th> 
          <TD class="BGCgray">
          <input name="ur_adress" 
          onblur="ckaddress()"
          type="text" id="textfield6" value="${user.ur_address }"/>
          
           <span id="spAddress"></span>
          
          </TD>
        </TR>
        <TR>
          <th align="center">邮箱</th>
          <TD class="BGCgray">
          <input name="ur_email" 
          onblur=ckemail()
          type="text" id="textfield" value="${user.ur_email }">
          
           <span id="spEmail"></span>
          
          </TD>
        </TR>
	<TR>
		
          <th align="center">角色</th>
          <TD class="BGCgray">
         <select name="ur_roleId" >
		
		<option value=1 <c:if test="${user.role.re_id==1 }">selected="selected"</c:if>>超级管理员</option>
		<option value=2 <c:if test="${user.role.re_id==2 }">selected="selected"</c:if>>管理员</option>
		<option value=3 <c:if test="${user.role.re_id==3 }">selected="selected"</c:if>>页面管理员</option>
		<option value=4 <c:if test="${user.role.re_id==4 }">selected="selected"</c:if>>讲师</option>
			
	</select>
       </TD>
        </TR>
        <TR>
          <th align="center">状态</th>
          <TD class="BGCgray"><select name="ur_state" id="select">
          	
         	<option value=1 <c:if test="${user.ur_state==1 }">selected="selected"</c:if>>启用</option>
			<option value=0 <c:if test="${user.ur_state==0 }">selected="selected"</c:if>>禁用</option>
          </select></TD>
        </TR>
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('保存信息？')) document.formboss.submit();else return false;" name="submit"><img src="houtai/images/btn_edit.gif" width="16" height="16" align="absmiddle"> 保存</BUTTON>
        <BUTTON style="HEIGHT:25px" onClick="javascript:if (confirm('您填写的信息还未保存，确认返回么？')) history.go(-1);else return false;" name="back"><img src="houtai/images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回</BUTTON>
      </div>
    </div>
  </td>
  </tr>
</table>
</form>
</body>
</html>