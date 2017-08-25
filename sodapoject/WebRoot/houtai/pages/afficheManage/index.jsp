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
	//单个删除
	function delButton(id) {
		if (confirm("你确定要删除吗？")) {
			alert("删除成功！");
			
			location.href="NoticeServlet?param=2&ne_id="+id;
		}

	}
	//批量删除
	function checkeDel() {
		var count = 0;
		var dd=[];
		var j=0;
		var alls = document.getElementsByName("checkbox2");
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				count++;
			}
		}
		if (count > 0) {
			if (confirm("确认要删除吗?")) {
				for ( var i = 0; i < alls.length; i++) {
					if (alls[i].checked) {
						//var ids=document.getElementsByName("checkbox2").value;
						alert(alls[i].value);
						dd[j++]=alls[i].value;
						
					}
				}
				window.location.href="NoticeServlet?param=8&dd="+dd;	
				alert("删除成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
	//导出excel
	function expolExcel() {
		var count = 0;
		var dd=[];
		var j=0;
		var alls = document.getElementsByName("checkbox2");
		for ( var i = 0; i < alls.length; i++) {
			if (alls[i].checked) {
				count++;
			}
		}
		if (count > 0) {
			if (confirm("确认要导出吗?")) {
				for ( var i = 0; i < alls.length; i++) {
					if (alls[i].checked) {
						//var ids=document.getElementsByName("checkbox2").value;		
						dd[j++]=alls[i].value;
					}
				}
			
				window.location.href="NoticeServlet?param=9&dd="+dd;	
				alert("成功!");
			}
		} else {
			alert("请选中要操作的项");
		}
	}
	//全选和全不选
	function allCheck() {
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
	//跳转相对应的页面
	function tiao(pageText){
		window.location.href="${pageContext.request.contextPath }/NoticeServlet?param=1&page="+pageText;
		document.myform.submit;
	}
	function tijiao(num){
		document.getElementById("page").value=num;
		document.myform.submit();
	}
		function tia(){
		var pa=document.getElementById("pageText").value;
		var totalPage=document.getElementById("totalPage").value;
		if(isNaN(pa)){
			alert("请输入数字!");
			location.href="NoticeServlet";
		}else if(pa*1>totalPage*1){
			alert("输入的数字超出范围!");	
			location.href="NoticeServlet";
		}
		else{
			
			window.location.href="javascript:tiao(document.getElementById('pageText').value)";
			
		}	
	
	}
</script>
</head>
<body>
	<form name="myform" action="NoticeServlet" method="post">
	<input type="hidden" name="page" id="page" />
		<input type="hidden" name="totalPage" id="totalPage" value="${pi.totalPage }" />
		<table width="100%" height="100%" border="0" cellspacing="0"
			cellpadding="3" name="indexTable">
			<tr>
				<td
					style="height: 25px; background-color: #f3f3f3; font-weight: bold"
					valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置： <img
					src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
					<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
					<img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda公告管理
				</td>
			</tr>
			<tr>
				<td
					style="height: 34px; background-image: url(houtai/images/main_header.gif); border-bottom: 1px solid #cfd8e0; padding: 0px">
					<table width="100%" border="0" cellspacing="0" cellpadding="0"
						name="indexTable2">
						<tr>
							<td width="20" height="34"><img
								src="houtai/images/main_headerL.gif" width="20" height="34">
							</td>
							<td style="color: #90c8e8;"><img
								src="houtai/images/icon_card.gif" width="16" height="16"
								align="absmiddle">&nbsp;&nbsp;<strong>soda公告管理</strong>
							</td>
							<td align="right" class="white" style="padding-right: 20px"><a
								onclick="expolExcel()" class="barBtn"
								name="ggindexexcel"><img src="houtai/images/1.png"
									width="16" height="16" align="absmiddle" name="export">
									导出</a> <a href="houtai/pages/afficheManage/add.jsp" class="barBtn" name="add"><img
									src="houtai/images/5.png" width="16" height="16"
									align="absmiddle"> 添加</a> <a onclick="checkeDel()"
								class="barBtn" name="batchDelete"><img
									src="houtai/images/6.png" width="16" height="16"
									align="absmiddle"> 删除</a>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td
					style="height: 30px; background-color: #bddbff; border-bottom: 1px solid #cfd8e0;">
					<table
						width="100%" border="0" cellpadding="3" cellspacing="1"
						class="table1" name="indexTable3">
						<TR>
							<th width="10%" align="center">标题</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="ne_title" id="textfield" value="${param.ne_title }">
							</td>
							<th width="10%" align="center">更新时间</th>
							<td width="20%" class="BGCgray"><input type="text"
								name="ne_updatetime" id="textfield" value="${param.ne_updatetime }" >
							</td>
							<th width="10%" align="center">公告级别</th>
							<td width="20%" class="BGCgray">
							<select name="ne_states" id="select2">
							<option value="4" >全部</option>
								<c:forEach begin="1" end="3" var="state">
								
									
									<option
										<c:if test="${param.ne_states==state }" >
											selected="selected"
										</c:if>value="${state }">
										<c:if test="${state==1 }">一般</c:if>
										<c:if test="${state==2 }">紧急</c:if>
										<c:if test="${state==3 }">非常紧急</c:if>
									</option>
							</c:forEach>
							<!--  
								<option value="4">全部</option>
								<option value="1">一般</option>
								<option value="2">紧急</option>
								<option value="3">非常紧急</option>
							-->
							</select></td>
							<th width="10%" align="center"><BUTTON type="submit" style="HEIGHT: 25px"
								 name="dimSelect">
									<img src="houtai/images/btn_search.gif" width="16" height="16"
										align="absmiddle"> 查询
								</BUTTON>
							</th>
						</TR>
					</table>
				</td>
			</tr>
			<tr>
				<td height="100%" valign="top">
					<div style="overflow: auto; height: 100%; width: 100%">
						<table width="100%" border="0" cellpadding="3" cellspacing="1"
							class="table1" name="indexTable4">
							<TR>
								<th align="center"><input type="checkbox" name="checkbox"
									id="checkbox1" onChange="allCheck()">
								</th>
								<th align="center">ID</th>
								<th align="center">标题</th>
								<th align="center">更新日期</th>
								<th align="center">公告级别</th>
								<th width="180" align="center">操作</th>
							</TR>


							<c:forEach items="${list }" var="n">
								<TR>
									<TD align="center"><input type="checkbox" name="checkbox2" value="${n.ne_id  }" id="check">
									</TD>
									<TD align="center">${n.ne_id}</TD>
									<TD align="left"><a href="NoticeServlet?param=4&ne_id=${n.ne_id }"
										style="color: black;">${n.ne_title}</a>
									</TD>
									<TD align="center">${n.ne_updatetime}</TD>
									<TD align="center">
									
									<c:if test="${n.ne_level==1 }">一般</c:if>
									<c:if test="${n.ne_level==2 }">紧急</c:if>
									<c:if test="${n.ne_level==3 }">非常紧急</c:if>
								
									</TD>
									<TD width="180" align="center">
										<BUTTON type="button" style="height: 21px; font-size: 12px"
											onClick="javascript:location.href='NoticeServlet?param=4&ne_id=${n.ne_id }'">查看</BUTTON>
										<BUTTON type="button" style="height: 21px; font-size: 12px"
											onClick="javascript:location.href='NoticeServlet?param=5&ne_id=${n.ne_id }'">编辑</BUTTON>
										<BUTTON type="button" style="height: 21px; font-size: 12px"
											onClick="delButton(${n.ne_id })">删除</BUTTON>
									</TD>
								</TR>
							</c:forEach>




						</table>
						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							name="indexTable5">
							<tr>
								<td width="20%" height="25"><table border="0"
										cellspacing="0" cellpadding="3">
										<tr>
											<td style="width: 60px"></td>
											<td style="width: 60px"><a
												href="${pageContext.request.contextPath }/NoticeServlet?page=1"
												name="pageFirst"><span style="color: #000;">首页</span>
											</a>
											</td>
											<td style="width: 60px"><a href="${pageContext.request.contextPath }/NoticeServlet?page=${pi.pageNum-1 }" name="pageUp"><span
													style="color: #000;">上一页</span>
											</a>
											</td>
											
											<td width="80px"><c:forEach begin="1"
													end="${pi.totalPage }" var="p">
													<c:if test="${p-pi.pageNum>-5 &&  p-pi.pageNum<5}">
														<c:if test="${p-pi.pageNum>-3 &&  p-pi.pageNum<3}">

															<c:if test="${p!=pi.pageNum }">
																<a
																	href="${pageContext.request.contextPath }/NoticeServlet?page=${p }"
																	style="color: black;'">${p }</a>
															</c:if>

															<c:if test="${p==pi.pageNum }">
															${p }
														</c:if>

														</c:if>
														<c:if test="${p-pi.pageNum<-3 ||  p-pi.pageNum>3}">
														.
														</c:if>
													</c:if>
												</c:forEach></td>
											
											
											<td style="width: 60px"><a href="javascript:tijiao(${pi.pageNum+1 })" name="pageNext"><span
													style="color: #000;">下一页</span>
											</a>
											</td>
											<td style="width: 60px"><a href="${pageContext.request.contextPath }/NoticeServlet?page=${pi.totalPage }" name="pageEnd"><span
													style="color: #000;">尾页</span>></a>
											</td>
										</tr>
									</table>
								</td>
								<td width="20%" align="center"><table border="0"
										cellspacing="0" cellpadding="3" name="listTable6">
										<tr>
											<td><a onclick="tia()"
												name="pageGo"><img src="houtai/images/next.gif"
													width="16" height="16" border="0"> </a>
											</td>
											<td><input id="pageText" name="pageText" type="text"
												size="3" style="width: 25; height: 18"> /页</td>

										</tr>
									</table>
								</td>
								<td width="20%" align="right">共${pi.totalCount
									}条记录显示到${pi.pageNum }/${pi.totalPage }</td>
							</tr>
						</table>
					</div></td>
			</tr>
		</table>
	</form>
</body>
</html>