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
        <p>Coin: ${sessionScope.User.coin}</p>
        <p>Vehicle Number: ${sessionScope.User.vehicleNumber}</p>
        
        <form action="Logout" method="post">
            <button type="submit">Logout</button>
        </form>
        
        <form action="history" method="get">
            <button type="submit" >History</button>
        </form>
        
        <form action="profile" method="get">
            <button type="submit" >Profile</button>
        </form>
        
        <form action="scan" method="get">
            <button>Scan</button>
        </form>
        
        
    </body>
</html>
