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

/* function updatePass(){
	document.getElementById("num").value=2;
	document.getElementById("param").value="edit";
	} */
</script>
</head>


<body>
<form name="myform" action="${pageContext.request.contextPath}/UserServlet" method="post">
<input type="hidden" id="uid" value="${user.ur_id }"/>
<input type="hidden" id="num" value="2"/>
<input type="hidden" id="param" value="edit"/>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="updatepsTable">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">
    &nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;密码修改</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="updatepsTable2">
        <tr>
          <td width="20" height="34"><img src="houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>修改个人密码</strong></td>
       
        </tr>
    </table></td>
  </tr>
  <tr>
    <td style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;"><table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1"  name="updatepsTable3">
      <TR>
        
	   </TR>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
	<form action="" method="post" name="updatepsForm">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1"  name="updatepsTable4">
        <tr>
			<td style="text-align:right">请输入旧密码：</td><td><input type="ur_password" name="oldpassword"></td>
		</tr>
		 <tr>
			<td style="text-align:right">请输入新密码：</td><td><input type="newpassword" name="newpassword"></td>
		</tr>
		 <tr>
			<td style="text-align:right">请输入重复密码：</td><td><input type="qrpassword" name="cfpassword"></td>
		</tr>
		<tr>
			<td style="text-align:right"></td><td >
			<input type="submit" value="提交" onClick="updatePass()" 
			name="homePageSave">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="button" value="返回" onClick="" name="back" ></td>
		</tr>
      </table>
    </form>  
    </div>
  </td>
  </tr>
</table>
</form>
</body>
</html>