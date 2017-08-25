<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>soda教育</title>
<link href="css/style.css" type="text/css" rel="stylesheet" />
<link href="css/single.css" type="text/css" rel="stylesheet" />
<script type="text/javascript" src="js/banner1.js"></script>
</head>

<body>
	<iframe style="width: 100%; height: 236px" scrolling="no"
		frameborder="0" src="header.jsp" name="kangjiaIframe"></iframe>

	<div class="content">

		<div class="clear"></div>
		<div class="buyDiv">

			<div class="buyHeader">
				<h1>资料修改</h1>
				<div class="innerDiv" onclick="history.back();">返 回</div>
				<div class="innerDiv" onclick="alert('修改成功！');">修 改</div>
			</div>


			<div class="buyBody">
				<fieldset class="registField">
					<legend style="color: #DE3237;" align="left">资料修改</legend>
					<form name="msgUpdateform">
						<table class="registTable" name="msgUpdatetable">
							<tr>
								<td align="right" style="width: 30%;">用户名</td>
								<td></td>
								<td align="left">liuhaiyang</td>
							</tr>
							<tr>
								<td align="right">密码</td>
								<td></td>
								<td align="left">******</td>
							</tr>
							<tr>
								<td align="right">真实姓名</td>
								<td></td>
								<td align="left">刘海洋</td>
							</tr>
							<tr>
								<td align="right">身份证</td>
								<td></td>
								<td align="left">130696199203051258</td>
							</tr>
							<tr>
								<td align="right">性别</td>
								<td></td>
								<td align="left"><input type="radio" name="st_sex"
									checked="checked" />男 <input type="radio" name="st_sex" />女</td>
							</tr>
							<tr>
								<td align="right">联系电话</td>
								<td></td>
								<td align="left"><input type="text" name="st_phone" /></td>
							</tr>
							<tr>
								<td align="right">地址</td>
								<td></td>
								<td align="left"><input type="text" name="st_address" /></td>
							</tr>
							<tr>
								<td align="right">邮箱</td>
								<td></td>
								<td align="left"><input type="text" name="st_email" /></td>
							</tr>
							<tr>
								<td align="right">学校</td>
								<td></td>
								<td align="left"><input type="text" name="st_school" /></td>
							</tr>
							<tr>
								<td align="right">专业</td>
								<td></td>
								<td align="left"><input type="text" name="st_major" /></td>
							</tr>
							<tr>
								<td align="right">备注</td>
								<td></td>
								<td align="left"><textarea cols="30" rows="4"
										style="resize: none;" name="st_remark">
                    </textarea></td>
							</tr>
						</table>
					</form>
				</fieldset>
			</div>
		</div>
		<div class="clear"></div>
		<!--清除浮动-->
	</div>
	<!--content end-->



	<div class="footer">
		<ul>


			<li class="li_left">地址：北京海淀区成府路**号</li>
			<li class="li_right">联系电话：010-82365636</li>
		</ul>
	</div>
	<!--footer end-->
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
	</div>
</body>
</html>