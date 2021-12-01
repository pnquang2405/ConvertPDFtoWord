<%@page import="Model.Bean.Account"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
  
    <link rel="stylesheet" href="LoginServer.css" />
    <link rel="stylesheet" href="reset.css">
    
</head>

<body>
    <%
Account a=(Account)request.getSession().getAttribute("accountuser");
	if(a!=null){
		response.sendRedirect("MainServer.jsp");
	}
%>
    <div class="Login">
        <h1 class="Login__Heading">Login</h1>
        <form  action="CheckLoginServlet" method="post">
            <div class="Login__content">
                <input type="text" id="username" class="Login__input" placeholder="Username" name="id" required autocomplete="off">
            </div>
            <div class="Login__content">
                <input type="password" id="password" class="Login__input" placeholder="Password" name="pw" required autocomplete="off">
            </div>
            <div>
                <input type="submit" class="Login__submit" value="Login">
            </div>
            
        </form>
         <form action="#" method="post">
            <div style="text-align: center;">
                <br><br><br><br><br>
                <label style="margin-right: 50px;">Don't have an account?</label><a href="SignupSevlet">Sign Up</a>
            </div>
        </form>
    </div>
</body>
</html>