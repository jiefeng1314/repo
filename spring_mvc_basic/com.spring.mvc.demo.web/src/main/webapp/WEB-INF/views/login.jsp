<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>spring mvc basic</title>
<meta name="author" content="" />
<meta name="keywords" content="" />
<meta name="description" content="" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery/jquery-1.9.1.js"></script>
</head>
<body>
	<form action="j_spring_security_check" method="POST" >
		<input type="text" name="j_username"  placeholder="请输入账号..."  value="liuxiangfei"><br>
		<input type="password" name="j_password"  placeholder="密码..." value="123456" ><br>
		<div>
			<input type="submit" value="登  录" name="userbtn" class="userbtn png">
			<input type="button" value="返  回" onclick="cancel1()" class="userbtn png">
		</div>
	</form>
</body>
</html>
