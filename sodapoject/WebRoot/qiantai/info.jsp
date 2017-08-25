﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>
<link href="qiantai/css/style.css" type="text/css" rel="stylesheet" />
<link href="qiantai/css/single.css" type="text/css" rel="stylesheet" />
<script type="qiantai/text/javascript" src="js/banner1.js"></script>
</head>

<body>
<iframe style="width:100%;height:236px" scrolling="no" frameborder="0" src="qiantai/header.jsp" name="kangjiaIframe"></iframe>

<div class="content">
   
   <div class="clear"></div>
   <div class="buyDiv">
   
   	<div class="buyHeader">
   		<h1>${aa }</h1>
   		<div class="innerDiv" onclick="history.back();"  >返回</div>
   	</div>
   <%
    	int newsNum=0;
    	if(application.getAttribute("newsNum")!=null){
    		
    		newsNum=Integer.parseInt(application.getAttribute("newsNum")+"");
    		newsNum++;
    		
    	}
    	
    	application.setAttribute("newsNum", newsNum);
     %>
     	
   
   	<div class="buyBody">
    	<fieldset class="registField">
        	<legend style="color:#DE3237;" align="left">${aa }</legend>
               <form name=" Infoform">
               <table class="registTable" name="Infotable" >
               <tr>
               	<td align="right" style="width:30%;">标题</td>
                <td></td>
                <td align="left">${title}</td>
               </tr>
               <tr>
               	<td align="right">作者</td>
                <td></td>
                <td align="left">${author }</td>
               </tr>
               <tr>
               	<td align="right"></td>
                <td></td>
                <td align="left"></td>
               </tr>
               <tr>
               	<td align="right">详情</td>
                <td></td>
                <td align="left">${content }</td>
               </tr>
               </table>
               </form>
         </fieldset>
    </div>
   </div>
   <div class="clear"></div><!--清除浮动-->
</div><!--content end-->



<div class="footer">
   <ul>
     
       
       <li class="li_left">地址：${sessionScope.contact.ct_content }</li>
       <li class="li_right">联系电话：${sessionScope.contact.ct_phone }<li>
   </ul>
</div><!--footer end-->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>