
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
            <input type="password" name="passsord" require > 
            
            <button class="btn">Login</button>
        </form>
    </body>
</html>