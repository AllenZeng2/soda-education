<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="houtai/js/main.js"></script>
<script type="text/javascript">
	function goBack() {
		if(confirm("您填写的信息还未提交，确认返回？")){
    		history.back();
	    }else{
	        return false;
	    }
	}
	
	//修改内容非空验证
	function check(){
	    
	    var viy_content = document.getElementById("iy_content").value; 
	    if(viy_content==null || viy_content.length==0){
	       alert("请填写内容");
	       return false;
	    }else{
	       if(confirm("确认提交？")){
	          alert("修改成功");
	          return true;
	       }else{
	          return false;
	       }
	    }
	    
	}
	
</script>
</head>
<body>
	<table width="100%" height="100%" border="0" cellspacing="0"
		cellpadding="3" name="editTable">
		<tr>
			<td
				style="height: 25px; background-color: #f3f3f3; font-weight: bold"
				valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
				src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
				<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;行业介绍
			</td>
		</tr>
		<tr>
			<td style="height: 34px; background-image: url(houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					name="editTable2">
					<tr>
						<td width="20" height="34"><img
							src="houtai/images/main_headerL.gif" width="20" height="34">
						</td>
						<td style="color: #90c8e8;"><img
							src="houtai/images/icon_card.gif" width="16" height="16"
							align="absmiddle">&nbsp;&nbsp; <strong><a
								href="#">行业介绍编辑
						</strong>
						</td>
					</tr>
				</table></td>
		</tr>
		<tr>
			<td height="100%" valign="top">
				<div style="overflow: auto; height: 100%; width: 100%">
				
					<form action="IndustryServlet?gansha=updateIndu&iy_id=${industry.iy_id}" method="post" name="editForm" onsubmit="return check()">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="editTable3">
							<tr>
								<td style="text-align: right">标题</td>
								<td><input type="text" name="iy_title"
									value="${industry.iy_title}" disabled="disabled"
									style="width: 300px">
								</td>
							</tr>
							<tr>
								<td style="text-align: right">作者</td>
								<td><input type="text" name="iy_userId"
									value="${industry.iy_other1 }" disabled="disabled"
									style="width: 300px">
								</td>
							</tr>
							<tr>
								<td style="text-align: right">是否推荐</td>
								<td><input type="radio" name="iy_state" value="1"
									<c:if test="${industry.iy_state==1}">checked="checked"</c:if>>是&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="iy_state" value="0"
									<c:if test="${industry.iy_state==0}">checked="checked"</c:if>>否</td>
							</tr>
							<tr>
								<td style="text-align: right">内容</td>
								<td><textarea rows="10" cols="42" id="iy_content" name="iy_content">${industry.iy_content}</textarea>
								</td>
							</tr>
							<tr>
								<td style="text-align: right"></td>
								<td><input type="submit" value="提交" name="submit">
									<input type="button" value="返回" onClick="Javascript:goBack()"
									name="back">
								</td>
							</tr>
						</table>
					</form>
				</div></td>
		</tr>
	</table>
</body>
</html>