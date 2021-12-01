<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <form action="SignupCreateServlet" method="post">
            <div class="title">Sign Up</div>
            <div class="input-box underline">
                <input type="text" placeholder="Enter Your User" required name="id">
                <div class="underline"></div>
            </div>
            <div class="input-box">
                <input type="password" placeholder="Enter Your Password" required name = "pw">
                <div class="underline"></div>
            </div>
            <div class="input-box button">
                <input type="submit" name="" value="Sign Up">
            </div>
        </form>
    </div>
</body>
</html>