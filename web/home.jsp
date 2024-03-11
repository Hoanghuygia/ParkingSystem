<%-- 
    Document   : home
    Created on : Mar 9, 2024, 2:53:02 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Hello ${sessionScope.User.username}</h1>
        <form action="home" method="post">
            <button>Log out</button>
        </form>
        
    </body>
</html>
