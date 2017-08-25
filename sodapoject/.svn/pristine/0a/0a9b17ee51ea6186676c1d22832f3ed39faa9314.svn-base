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
</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="editTable">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">
    &nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda个人信息管理</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="editTable2">
        <tr>
          <td width="20" height="34"><img src="houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>修改用户信息</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          <a href="javascript:history.go(-1);" class="barBtn" onClick="javascript:history.go(-1);" name="retreat" ><img src="houtai/images/btn_left.gif" align="absmiddle"> 后退</a>
          <a href="javascript:history.go(+1);" class="barBtn" onClick="javascript:history.go(+1);" name="advance"><img src="houtai/images/btn_right.gif" align="absmiddle"> 前进</a>
          <a href="javascript:location.reload();" class="barBtn" name="flush"   >
          <img src="houtai/images/btn_refresh.gif" align="absmiddle"> 刷新</a>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1" name="editTable3">
        <TR>
          <th width="20%" align="center">用户登录名</th>
          <TD class="BGCgray"><input type="text" value="${user.ur_loginName }" name="ur_loginName" /></TD>
          </TR>
        <TR>
          <th align="center"><span class="BGCgray">真实姓名</span></th>
          <TD class="BGCgray"><input name="ur_name" type="text" id="textfield15" value="张三"/></TD>
        </TR>
		<TR>
          <th align="center">身份证号</th>
          <TD class="BGCgray"><input name="ur_idcard" type="text" id="textfield15" value="${user.ur_idcard }"/></TD>
        </TR>
        <TR>
          <th align="center">性别</th>
          <TD class="BGCgray"> 
          <input type="radio" name="ur_sex" value="1" checked="checked"/>男<input type="radio" name="ur_sex" value="2"/>女
          </TD>
        </TR>
        <TR>
          <th align="center">联系电话</th>
          <TD class="BGCgray"><input name="ur_phone" type="text" id="textfield2" value="13880123123"/></TD>
        </TR>
        <TR>
          <th align="center">地址</th> 
          <TD class="BGCgray"><input name="ur_adress" type="text" id="textfield6" value="成都市金牛区沙湾路21号"/></TD>
        </TR>
        <TR>
          <th align="center">邮箱</th>
          <TD class="BGCgray"><input name="ur_email" type="text" id="textfield" value="zhangsan@163.com"></TD>
        </TR>
        
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="updateNewsFileHref()" name="submit"><img src="houtai/images/btn_edit.gif" width="16" height="16" align="absmiddle"> 保存</BUTTON>
        <BUTTON style="HEIGHT:25px" onClick="javascript:history.go(-1);" name="back"><img src="houtai/images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回</BUTTON>
      </div>
    </div>
  </td>
  </tr>
</table>
</body>
</html>