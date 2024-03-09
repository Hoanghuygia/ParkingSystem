<%-- 
    Document   : register
    Created on : Mar 8, 2024, 2:34:03 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <h1>Sign up</h1>
        <p>It's quick and easy</p>
        
        <% String error = (String) session.getAttribute("ExistedUser");
        if (error != null && !error.isEmpty()){
            session.removeAttribute("ExistedUser");
        %>
        <p style="color: red;"> <%= error %> </p>
        <%
            }
        %>
        
        <form action="register" method="post">
            <label for="username">Username: </label> 
            <input type="text" name="username" required >
            
            <label for="password">Password: </label> 
            <input type="password" name="password" required >
            
            <button>Next</button>
        </form>
        
        <p>Already have account?</p>
        <a href="login">Login here</a>
    </body>
</html>
