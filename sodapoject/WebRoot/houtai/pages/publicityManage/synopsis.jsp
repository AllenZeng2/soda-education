<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>

<script type="text/javascript">
  
   function check(){
     var vsy_content = document.getElementById("sy_content").value;
     if(vsy_content==null || vsy_content.length==0){
        alert("内容不能为空");
        return false;
     }else if(vsy_content.length>=255){
        alert("内容过长");
        return false;
     }else{
         if(confirm("确认提交？")){
            alert("提交成功");
            return true;
         }
     }    
   }
  
</script>

</head>
<body>
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="3" name="surveyTable">
		<tr>
			<td
				style="height: 25px; background-color: #f3f3f3; font-weight: bold"
				valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
				src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;新闻管理
			</td>
		</tr>
		<tr>
			<td
				style="height: 34px; background-image: url(houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					name="surveyTable2">
					<tr>
						<td width="20" height="34"><img
							src="houtai/images/main_headerL.gif" width="20" height="34"></td>
						<td style="color: #90c8e8;"><img
							src="houtai/images/icon_card.gif" width="16" height="16"
							align="absmiddle">&nbsp;&nbsp; <strong>soda概况管理</strong></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td height="100%" valign="top">
				<div style="overflow: auto; height: 100%; width: 100%">
					<form action="SynopsisServlet?gansha=update" method="post" name="surveyForm" onsubmit="return check()">
						<input type="hidden" name="sy_id" value="${synopsis.sy_id }" />
						<input type="hidden" name="sy_type" value="${synopsis.sy_type }" />
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="surveyTable3">
							<tr>
								<td style="text-align: right">标题</td>
								<td>${synopsis.sy_title }</td>
							</tr>
							<tr>
								<td style="text-align: right">内容</td>
								<td><textarea rows="15" cols="52 " name="sy_content" id="sy_content">${synopsis.sy_content}</textarea></td>
							</tr>
							<tr>
								<td style="text-align: right"></td>
								<td><input type="submit" value="提交" name="submit">
								<input type="button" value="返回" onClick="history.back();"
									name="homePageButton" /></td>
							</tr>
						</table>
					</form>
				</div>
			</td>
		</tr>
	</table>
</body>
</html>