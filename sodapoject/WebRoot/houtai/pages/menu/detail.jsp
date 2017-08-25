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
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="detailTable">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;菜单管理
    </td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="detailTable2">
        <tr>
          <td width="20" height="34"><img src="houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>菜单详情</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          <a href="javascript:history.go(-1);" class="barBtn" onClick="javascript:history.go(-1);" name="retreat" ><img src="houtai/images/btn_left.gif" align="absmiddle"> 后退</a>
          <a href="javascript:history.go(+1);" class="barBtn" onClick="javascript:history.go(+1);" name="advance"><img src="houtai/images/btn_right.gif" align="absmiddle"> 前进</a>
          <a href="Javascript:location.reload();" class="barBtn" name="flush"><img src="houtai/images/btn_refresh.gif" align="absmiddle" name="cddetailflush"> 刷新</a>
          </td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1" name="detailTable3">
        <TR>
          <th width="20%" align="center">菜单名</th>
          <TD class="BGCgray">${menu.mu_name }</TD>
        </TR>
       <TR>
          <th align="center">对应路径</th>
          <TD class="BGCgray">
			${menu.mu_url }
          </TD>
        </TR>
        <TR>
          <th width="20%" align="center">父级菜单</th>
          <TD class="BGCgray">
          
          
          	<select>
          	    <c:forEach items="${fms }" var="fm">
          		<option	value="${fm.fmen_id}" 
            	<c:if test="${menu.mu_pid==fm.fmen_id}">selected="selected"</c:if>
            >${fm.fme_name}</option>
          	
          	</c:forEach>
          	
          	
        <%--     <option
            	<c:if test="${menu.mu_pid==1}">selected="selected"</c:if>
            >系统管理</option>
            <option
            	<c:if test="${menu.mu_pid==2 }">selected="selected"</c:if>
            >用户管理</option>
            <option
            	<c:if test="${menu.mu_pid==3 }">selected="selected"</c:if>
            >角色管理</option> --%>
            </select>
          </TD>
        </TR>
         <TR>
          <th align="center">启用状态</th>
          <TD class="BGCgray">
      		  <c:if test="${menu.mu_state==1 }">启用</c:if>
			  <c:if test="${menu.mu_state==0 }">禁用</c:if>
          </TD>
        </TR>
        <TR>
          <th align="center"><span class="BGCgray">备注</span></th>
          <TD class="BGCgray">
          	${menu.mu_remark }
          </TD>
        </TR>
      </table>
      <div style="width:100%; text-align:center; padding:5px">
        <BUTTON style="HEIGHT:25px" onClick="history.go(-1);" name="back"><img src="houtai/images/btn_back.gif" width="16" height="16" align="absmiddle"> 返回</BUTTON>
      </div>
    </div>
  </td>
  </tr>
</table>
</body>
</html>