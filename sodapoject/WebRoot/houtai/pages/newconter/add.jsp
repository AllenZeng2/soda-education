<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="${pageContext.request.contextPath}/houtai/css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/houtai/js/main.js"></script>
<script type="text/javascript">


	function goBack(){
			location.href="${pageContext.request.contextPath}/SelectNewsServlet";
		}
	function tijiao(){
		var vcontent=document.getElementsByName("ns_content").value;
		
	 	if(confirm("确认提交？")){
			alert("提交成功");
		
			return true;
		} else {
			return false;
		}
	}
</script>
</head>
<body>
<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="3" name="addTable">
  <tr>
    <td style="height:25px; background-color:#f3f3f3; font-weight:bold" valign="top">
    &nbsp;&nbsp;&nbsp;&nbsp;当前位置：
    <img src="${pageContext.request.contextPath}/houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;soda创业教育平台&nbsp;&nbsp;
    <img src="${pageContext.request.contextPath}/houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;后台管理&nbsp;&nbsp;
    <img src="${pageContext.request.contextPath}/houtai/images/arrow.gif" align="absmiddle">&nbsp;&nbsp;新闻管理</td>
  </tr>
  <tr>
    <td style="height:34px; background-image:url(${pageContext.request.contextPath}/houtai/images/main_header.gif); border-bottom:1px solid #cfd8e0; padding:0px">
      <table width="100%" border="0" cellspacing="0" cellpadding="0"  name="addTable2">
        <tr>
          <td width="20" height="34"><img src="${pageContext.request.contextPath}/houtai/images/main_headerL.gif" width="20" height="34"></td>
          <td style="color:#90c8e8;"><img src="${pageContext.request.contextPath}/houtai/images/icon_card.gif" width="16" height="16" align="absmiddle">&nbsp;&nbsp;
          <strong>新闻管理 &nbsp;&nbsp;》》》	添加新闻</strong></td>
        </tr>
    </table></td>
  </tr>
  <tr>
    <td height="100%" valign="top">
    <div style="overflow:auto;height:100%; width:100%">
    <form action="${pageContext.request.contextPath }/AddNewsServlet" method="post" name="addForm" >
      <table width="100%" border="0" cellpadding="3" cellspacing="1" class="table1"  name="addTable3">
        <tr>
        	<td style="text-align:right" style="width:300px">标题</td>
            <td><input type="text" name="ns_title"></td>
        </tr>
        <tr>
        	<td style="text-align:right" style="width:300px">作者</td>
            <td><input type="text" name="ns_userId"></td>
        </tr>
        <tr>
        	<td style="text-align:right" style="width:300px">访问量</td>
            <td><input type="text" name="ns_number"></td>
        </tr>
        <tr>
        	<td style="text-align:right">是否推荐</td>
            <td><input type="radio" name="ns_state" checked="checked" value="0"> 是&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="ns_state" value="1">否</td>
        </tr>
        <tr>
        	<td style="text-align:right">内容</td>
            <td><textarea rows="10" cols="42"  name="ns_content"></textarea></td>
        </tr>
        <tr>
        	<td style="text-align:right"></td>
            <td><input type="submit" value="提交" name="submit" onclick="return tijiao()"> <input type="button" value="返回" onClick="Javascript:goBack()" name="back" ></td>
        </tr>
      </table>
      </form>
    </div>
  </td>
  </tr>
</table>
</body>
</html>