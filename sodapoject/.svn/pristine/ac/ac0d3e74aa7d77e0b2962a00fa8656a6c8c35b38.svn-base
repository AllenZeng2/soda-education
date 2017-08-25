<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="../../../css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="../../../js/main.js"></script>
<script type="text/javascript">
	function goBack() {
		if (confirm("您填写的信息还未提交，确认返回？")) {
			history.back();
		} else {
			return false;
		}
	}
	
	
	//提交表单验证
	function check(){
	   
	    var title = document.getElementById("iy_title").value;
	    var state = document.getElementById("iy_state").value;
	    var content = document.getElementById("iy_content").value;
	    
	    if (title == null || title.length == 0) {
				alert("请填写标题");
				return false;
			}
		 if (content == null || content.length == 0) {
			    alert("请填写内容");
			    return false;
		}

		 if(title.length>100){
			alert("标题过长超出范围");
			return false;
		}
		 if(content.length>255){
			alert("内容过长超出范围");
			return false;
		}
		if (!confirm("是否提交？")) {
				return false;
			}else{
			   alert("添加成功");
			   return true;
			}	
	}
	
</script>
</head>
<body>
		<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="addTable">
			<tr>
				<td style="height: 25px; background-color: #f3f3f3; font-weight: bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： 
					<img src="../../../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
					<img src="../../../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="../../../images/arrow.gif" align="absmiddle">&nbsp;&nbsp;行业介绍
				</td>
			</tr>
			<tr>
				<td
					style="height: 34px; background-image: url(../../../images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="addTable2">
						<tr>
							<td width="20" height="34"><img
								src="../../../images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color: #90c8e8;"><img
								src="../../../images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp; <strong><a
									href="#">行业介绍添加
							</strong>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
					
					<form action="${pageContext.request.contextPath }/IndustryServlet?gansha=add" method="post" name="hyaddform" onsubmit="return check()"  >
						<!-- <form action="IndustryServlet?method=add&iy_userId=${user.ur_id}" method="post" name="hyaddform" onsubmit="return check()"  > -->
							<table width="100%" border="0" cellpadding="3" cellspacing="1"
								class="table1" name="addTable3">
								<tr>
									<td style="text-align: right" style="width:300px">标题</td>
									<td><input type="text" name="iy_title" value="" id="iy_title">
									</td>
								</tr>
								<tr>
									<td style="text-align: right" style="width:300px">作者</td>
									<td><input type="text" name="iy_userId">
									</td>
								</tr>
								<tr>
									<td style="text-align: right">是否推荐</td>
									<td><input type="radio" name="iy_state" id="iy_state" value="1" >是&nbsp;&nbsp;&nbsp;&nbsp;
									<input id="iy_state" type="radio" name="iy_state" checked="checked" value="0" >否</td>
								</tr>
								<tr>
									<td style="text-align: right">内容</td>
									<td><textarea rows="15" cols="42" name="iy_content" id="iy_content"></textarea>
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
						
					</div>
				</td>
			</tr>
		</table>
</body>
</html>