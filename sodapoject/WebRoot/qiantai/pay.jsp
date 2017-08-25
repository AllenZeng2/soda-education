﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>
<link href="qiantai/css/style.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/banner1.js"></script>
<link href="qiantai/css/single.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
	function tijiao(num) {
		document.getElementsByName("page").value = num;
		window.location.href = "NoSettlementServlet?page=" + num;

	}

	function allcheck() {
		var alls = document.getElementsByName("checkbox2");
		var conterCheck = document.getElementById("checkbox1");
		for ( var i = 0; i < alls.length; i++) {
			if (conterCheck.checked) {
				alls[i].checked = true;
			} else {
				alls[i].checked = false;
			}
		}
	}
</script>

</head>

<body>
	<iframe style="width: 100%; height: 236px" scrolling="no"
		frameborder="0" src="qiantai/header.jsp"></iframe>
	<div class="content">

		<div class="clear"></div>
		<div class="buyDiv">

			<div class="buyHeader">
				<h1>课程结算</h1>
				<div class="innerDiv" onclick="history.back();">返 回</div>
				<div class="innerDiv"
					onclick="if(confirm('余额不足，是否现在充值？')) location.href='chongzh.jsp';">结
					算</div>
				<div class="innerDiv" onclick="alert('取消成功!');">取 消</div>
			</div>


			<div class="buyBody">
				<table class="buyTable" cellpadding="0" cellspacing="0"
					name="payttable">

					<tr>
						<th><input type="checkbox" name="checkbox" id="checkbox1"
							onchange=allcheck() /></th>
						<th>课程名称</th>
						<th>课程讲师</th>
						<th>课程类型</th>
						<th>课程价格</th>
						<th>课程简介</th>
					</tr>
					<c:forEach items="${shopcar }" var="shopcar">
					<tr>
						<td><input type="checkbox" name="checkbox2"
								value=${shopcar.sr_id } /></td>
						<td>${shopcar.sr_coursename }</td>
						<td>${shopcar.sr_courseteacher }</td>
						<td>${shopcar.sr_coursetype }</td>
						<td>${shopcar.sr_courseabstract }</td>
						<td><p>${shopcar.sr_courseprice }</p></td>
					</tr>
					</c:forEach>

				</table>
			</div>

			<div class="buyFoot">
				<div class="pageDiv">
					<c:if test="${pi.pageNum<=1 }">
						首页</c:if>
					<c:if test="${pi.pageNum>1 }">
						<a href="javascript:tijiao(1)" name="pageFirst">首页</a>
					</c:if>
					&nbsp;&nbsp;
					<c:if test="${pi.pageNum==1 }">
						上一页&nbsp;&nbsp;
					</c:if>
					<c:if test="${pi.pageNum>1 }">
						<a href="xianchangServlet?page=${pi.pageNum-1 }" name="pageUp">上一页</a>&nbsp;&nbsp;
					</c:if>
					<c:if test="${pi.pageNum>=pi.totalPage }">
						下一页&nbsp;&nbsp;	
					</c:if>
					<c:if test="${pi.pageNum<pi.totalPage }">
						<a href="xianchangServlet?page=${pi.pageNum+1 }" name="pageNext">下一页</a>&nbsp;&nbsp;	
					</c:if>
					<c:if test="${pi.pageNum>=pi.totalPage }">
						尾页
					</c:if>
					<c:if test="${pi.pageNum<pi.totalPage }">
						<a href="xianchangServlet?page=${pi.totalPage }" name="pageEnd">尾页</a>
					</c:if>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						共${pi.totalCount }条数据 &nbsp;&nbsp; 当前第&nbsp;&nbsp;${pi.pageNum
						}&nbsp;&nbsp;页 共&nbsp;${pi.totalPage }&nbsp;页</span>
				</div>
			</div>

		</div>
		<div class="clear"></div>
		<!--清除浮动-->
	</div>
	<!--content end-->
	<div class="footer">
		<ul>
			<li class="li_left">地址：${sessionScope.contact.ct_content }</li>
			<li class="li_right">联系电话：${sessionScope.contact.ct_phone }</li>
		</ul>
	</div>
	<!--footer end-->
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>