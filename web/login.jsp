
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>
    </head>
    <body>
        <form action="login" method="post">
            <label for="username">User Name</label>
            <input type="text" name="username" require > 
            
            <label for="password">Password</label>
            <input type="password" name="password" require > 
            
            <button class="btn">Login</button>
            
            <br>
        </form>
        
        <p>Don't have an account?</p>
        <a href="register">Register here</a>
    </body>
</html>
