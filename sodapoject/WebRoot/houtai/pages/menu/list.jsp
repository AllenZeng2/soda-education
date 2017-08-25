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

		//复选框
		function checkif(ck){
		var alls=document.getElementsByName("checkbox2");
		var conterCheck=document.getElementById("checkbox");
		for(var i=0;i<alls.length;i++){
			
			if(conterCheck.checked){
				alls[i].checked=true;
			}else{
				alls[i].checked=false;
			}
		}
	}
	
	function cancel(){
		  var alls;
		  var conterCheck;
				conterCheck=document.getElementById("checkbox");
				alls=document.getElementsByName("checkbox2");
			for(var i=0;i<alls.length;i++){
				if(alls[i].checked)
					return;		
			}
			conterCheck.checked=false;
	}
	//多选删除
 	function checkeDel(){
 	document.getElementById("num").value="2";
 	document.getElementById("param").value="mutipleDel";
 	var del=false;
 		var alls=document.getElementsByName("checkbox2");
 			for(var i=0;i<alls.length;i++){
 				if(alls[i].checked){
 					del=true;
 					break;
 				}
			}
 		if(del)
 			if(confirm("确定删除?"))
 				document.myform.submit();
 			else
 				return;
 		}


	//查询
	function select(){
		document.getElementById("param").value="select";
		document.myform.submit();
	
	}
	
	//跳页
	function changePage(pages,num){
		
		var c=parseInt(pages);
		if(isNaN(pages)||c!=pages){
			alert("请输入整数");
			return;
		}
		if(pages<1||num<pages){
			alert("您输入的页面超出范围");
			return;
		}		
		document.getElementById("page").value=pages;
		
	//	var loginName = document.getElementById("textfield").value;
	//	var realName = document.getElementById("textfield2").value;
	//	var state = document.getElementById("select2").value;
		document.getElementById("param").value="select";
		document.myform.submit();
	}
	//删除和禁用
	var xhr;
	function updateState(uid,num) {
				if(num==1||num==0){
			if(num==1){
				if (!confirm("是否禁用？"))
				return;
				num=0;
			}else{
				if (!confirm("是否启用？"))
					return;
					num=1;
			}
		}
		if(num==2)
			if (!confirm("是否删除？"))
				return;
				
		
		xhr = new XMLHttpRequest();
		xhr.open("get","${pageContext.request.contextPath}/MenuServlet?param=updateState&mu_id="+uid+"&num="+num, true);
	
		xhr.send(null);
			location.reload();
		
		}
	
	//详情
	function detail(id){
		document.getElementById("param").value="single";
		document.getElementById("mu_id").value=id;
		document.getElementById("num").value=1;
		document.myform.submit();	
	}
	
	//编辑
	function edit(id){
		document.getElementById("param").value="single";
		document.getElementById("mu_id").value=id;
		document.getElementById("num").value=2;
		document.myform.submit();	
	}
	

</script>

</head>
<body>
<form name="myform" action="${pageContext.request.contextPath }/MenuServlet" method="post">
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="listTable">
 <!--隐藏param  -->
							<input type="hidden" name="param" id="param" />
							<input type="hidden" name="page" id="page"/>
							<input type="hidden" name="mu_id" id="mu_id"/>
							<input type="hidden" name="num" id="num"/>
							<!--隐藏param  -->
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;菜单管理
    </td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="listTable2">
        <tr>
          <td width="20" height="34"><img src="houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;<strong>菜单管理</strong></td>
          <td align="right" class="white" style="padding-right:20px">
          
          <a class="barBtn" 
          onClick="location.href='${pageContext.request.contextPath }/MenuServlet?param=selectRoles'" name="add">
          <img src="houtai/images/5.png" align="absmiddle"> 新增
          
          </a>
           <a href="#" class="barBtn" onClick="javascript:history.go(-1);" 
          name="retreat" ><img src="houtai/images/btn_left.gif" align="absmiddle"> 后退</a>
          
           <a href="#" class="barBtn" onClick="javascript:history.go(+1);"
            name="advance"><img src="houtai/images/btn_right.gif" align="absmiddle"> 前进</a>
          
           <a href="Javascript:location.reload();" class="barBtn" name="flush" ><img src="houtai/images/btn_refresh.gif" 
           align="absmiddle" > 刷新</a>
           
		  <a href="Javascript:checkeDel()" class="barBtn" name="batchDelete">
		  <img src="houtai/images/6.png" width="16" height="16" align="absmiddle" > 删除</a></td>
		  
        </tr>
    </table></td>
  </tr>
 							
							
  <tr>
    <td style="height:30px; background-color:#bddbff; border-bottom:1px solid #cfd8e0;">
    <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1" name="listTable3">
   
   
     <!--      111111111111111111111111                           -->
      <TR>
        <th width="10%" align="center">菜单名</th>
        
        <td width="20%" class="BGCgray"><input value="${info.loginName }" type="text" name="mu_name" id="textfield"></td>
        
        <th width="10%" align="center"><STRONG>状态</STRONG></th>
        <td width="20%" class="BGCgray"><select name="mu_state" id="select2">
          <option value="">全部</option>
		  <option value=1 <c:if test="${info.state==1 }">selected="selected"</c:if>>启用</option>
		  <option value=0 <c:if test="${info.state==0 }">selected="selected"</c:if>>禁用</option>
							</select>
							
							
        <th width="10%" align="center"><BUTTON style="HEIGHT:25px" onClick="select()" name="dimSelect"><img src="houtai/images/btn_search.gif" width="16" height="16" align="absmiddle"> 查询</BUTTON></th>
        </TR>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1" name="cdlisttable"  name="listTable4">
        <TR>
          <th align="center"><input type="checkbox" 
          onclick="checkif(this.checked)" 
          name="checkbox" id="checkbox">
          </th>
          
          <th align="center">菜单名</th>
          <th align="center">状态</th>
          <th align="center">url路径</th>
          <th align="center">备注</th>
          <th width="200" align="center">操作</th>
          </TR>
          
     <c:forEach items="${menus }" var="menu">
          
        <TR>
          <TD align="center">
          <input type="checkbox"
          	 onclick="cancel()"
          	 value="${menu.mu_id }"
          	 name="checkbox2" id="checkbox2">
           </TD>
          <TD align="center">${menu.mu_name }</TD>
          <TD align="center">
          		<c:if test="${menu.mu_state==1 }">启用</c:if>
				<c:if test="${menu.mu_state==0 }">禁用</c:if>
          
          </TD>
          <TD align="center">${menu.mu_url }</TD>
          <TD align="center">${menu.mu_remark }</TD>
          <TD width="200" align="center">
          
        	  <BUTTON style="height:21px; font-size:12px"
          			onClick="javascript:detail(${menu.mu_id })">查看 </BUTTON>
          			
              <BUTTON style="height:21px; font-size:12px" 
           			onClick="edit(${menu.mu_id })">编辑</BUTTON> 
           			
          	 <BUTTON style="height:21px; font-size:12px" 
          	 onClick="updateState(${menu.mu_id },${menu.mu_state }); return false;">
				<c:if test="${menu.mu_state==0 }">启用</c:if>
				<c:if test="${menu.mu_state==1 }">禁用</c:if>
				</BUTTON>
          	 
          	  <BUTTON style="height:21px; font-size:12px"
          	   onClick="updateState(${menu.mu_id },2); return false;">删除</BUTTON>
          </TD>
        </TR>
        
  </c:forEach>
  	<th colspan="6">
  		<c:if test="${menus==null }">查询结果为空</c:if>
  	</th>
      </table>
     
      
      <table width="100%" border="0" cellspacing="0" cellpadding="0" name="listTable5">
        <tr>
          <td width="20%" height="25"><table border="0" cellspacing="0" cellpadding="3">
            	<tr>
					<td>
					  <c:if test="${info.currentPage!=1&&menus!=null }">
					<a href="javascript:changePage(1)"
					 style="color:black;" name="pageEnd"><span style="color: blue">首页</span></a>
					 </c:if>
					 <c:if test="${info.currentPage==1||menus==null }">
						首页
					 </c:if>
					</td>
					<td >
					<c:if test="${info.currentPage>1 }">
					<a href="javascript:changePage(${info.currentPage-1 })" 
					style="color:black;" name="pageUp" ><span style="color: blue">上一页</span></a>
					</c:if>
					<c:if test="${info.currentPage==1||menus==null }">
					上一页
					</c:if>
					</td>
					<td>
					<c:if test="${info.currentPage<info.totalPages }">
						<a href="javascript:changePage(${info.currentPage+1 })"
					 	style="color:black;" name="pageNext">
					 	<span style="color: blue">下一页</span></a>
					 </c:if>
					 
					 <c:if test="${info.currentPage==info.totalPages }">
					下一页
					</c:if>
					
					</td>
					<td>
					 <c:if test="${info.currentPage!=info.totalPages }">
					<a href="javascript:changePage(${info.totalPages })"
					 style="color:black;" name="pageEnd"><span style="color: blue">尾页</span></a>
					 </c:if>
					 <c:if test="${info.currentPage==info.totalPages }">
						尾页
					 </c:if>
					</td>
					</tr>
					</table></td>
					<td width="20%" align="center">
						<table border="0" cellspacing="0" cellpadding="3"
										name="listTable6">
							<tr>
								<td><a  href="javascript:changePage(document.getElementById('pageText').value,${info.totalPages })" style="color:black;" name="pageGo">GO</a>
								</td>
								<td><input name="pageText" type="text" size="3" id="pageText"
										style="width:25;height:18"> /页</td>
							</tr>
          </table></td>
         <td width="20%" align="right">共${info.totalCount }条记录显示到${info.currentPage}/${info.totalPages }</td>
        </tr>
      </table>
   	
    </div>
  </td>
  </tr>
</table>
</form>
</body>
</html>