<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>cstnet任务管理平台-登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link type="text/css" href="themes/css/v3/reset.css" rel="stylesheet">
<link type="text/css" href="themes/css/v3/public.css" rel="stylesheet">
<link type="text/css" href="themes/css/v3/register.css" rel="stylesheet">
<link rel="shortcut icon" href="themes/images/cstnet/favicon.ico" />
<script src="themes/js/jquery.min.js" type="text/javascript"></script>
<script src="themes/js/jquery.form.js" type="text/javascript"></script>
<script src="themes/js/json.parse.js" type="text/javascript"></script>
<style>
.loginad {
	width: 580px;
	height: 595px;
	position: absolute;
}

.loginad .loginadtitle {
	width: 100%;
	text-align: center;
	line-height: 60px;
	font-size: 32px;
	font-family: "幼圆", Microsoft Yahei;
	margin-top: 70px;
	color: #FFF;
}

.loginad .loginaddes {
	line-height: 30px;
	color: #FFF;
	font-family: Microsoft Yahei;
	font-size: 16px;
	text-align: center
}

.loginad .loginadimg {
	width: 100%;
	height: 320px;
	margin-top: 10px;
}

.loginad .loginadbtn {
	width: 100%;
	height: 40px;
	margin-top: 30px;
}

.loginad .loginadbtn a {
	display: block;
	width: 190px;
	height: 40px;
	margin: 0 auto;
	text-align: center;
	line-height: 40px;
	font-size: 16px;
	color: #009fe3;
	font-weight: bold;
	background: url(themes/images/v3/btn.png) center center no-repeat;
	-moz-border-radius: 6px;
	-khtml-border-radius: 6px;
	-webkit-border-radius: 6px;
	border-radius: 6px;
}
</style>
</head>
<body>
	<div id="header">
		<div class="header">
			<h1 class="png_bg">中国科技网</h1>
			<a href="#">返回主页</a>
		</div>
	</div>

	<div class="login_bg">
		<div class="form">
			<div class="loginad">
				<div class="loginadtitle">cstnet任务管理平台-登录</div>
				<div class="loginaddes">docker on yarn模式轻松提交管理任务，保障集群高校运行</div>
				<div class="loginadimg"
					style="background: url('themes/images/docker.jpg') center center no-repeat"></div>
			</div>

			<form id="login_form">
				<h2>登录平台</h2>
				<div class="div_user">
					<span></span><input name="username" class="username" type="text"
						placeholder="用户名" />
				</div>
				<div class="div_pw">
					<span></span><input class="pw" name="userpwd" type="password"
						placeholder="密码" />
				</div>
				<div class="div_box">
					<label><input type="checkbox" class="" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;下次自动登录</label>
				</div>
				<div>
					<input class="login_btn" id="loginBtn" type="button" value="登录" />
				</div>
				<div style="line-height: 30px; text-indent: 5px; color: #F30"
					id="loginTips">&nbsp;</div>
			</form>
		</div>
	</div>


	<!-- footer start -->
	<div id="footer" class="clear">
		<!-- <h1 class="png_bg">中国科技网</h1> -->
		<div class="friendLink clear">
			<a href="#" target="_blank" title="隐私政策" rel="nofollow">隐私政策</a> <a
				href="#" target="_blank" rel="nofollow">服务条款</a> <a href="#"
				target="_blank" rel="nofollow">关于我们</a> <a href="#" target="_blank"
				rel="nofollow">人员招聘</a> <a href="#" target="_blank" rel="nofollow">联系我们</a>
			<a href="#" target="_blank" rel="nofollow">友情链接</a>
		</div>
		<p>Copyright © 中国科技网网络中心1995-2015 京ICP备09112257号
			京公网安备11010802017084</p>
		<div class="weixin">
			<img src="themes/images/cstnet/mobileRcode.png" alt="" />
			<h3>团队文档库下载</h3>
		</div>
	</div>
	<!-- footer end -->
	<script type="text/javascript">
	var refer='';
	$(document).ready(function(){
		$("#loginBtn").click(function(){
			$("#loginBtn").val('登录中...').attr("disabled","disabled");
			var username = $(".username").val();
			var userpass = $(".pw").val();
				username = $.trim(username);
				userpass = $.trim(userpass);
			$("#loginTips").css({display:"none"});	
			
			if(username.length <5){
				$("#loginTips").html("请输入正确的用户名!").fadeIn();
				$("#loginBtn").val('登录').removeAttr('disabled');
				return false;
			}
			if(userpass == ''){
				$("#loginTips").html("请输入正确的密码!").fadeIn();
				$("#loginBtn").val('登录').removeAttr('disabled');
				return false;
			}
			
			$.ajax({
				type:"POST",
				url:"admin/user/login",
				data:{username:username,userpwd:userpass},
				success:function(msg) {
					if (msg == 1) {
						$("#loginBtn").val('登录').removeAttr('disabled');
						window.location="<%=request.getContextPath() %>/TotalView";
					} else {
						$("#loginTips").html("登录失败").fadeIn();
						$("#loginBtn").val('登录').removeAttr('disabled');
						return false;
					}					
				},
				error:function(msg) {
					$("#loginTips").html("errors occured, please contact manager!").fadeIn();
					$("#loginBtn").val('登录').removeAttr('disabled');
					return false;
				}
			});
		})		
	});
</script>
</body>
</html>
















