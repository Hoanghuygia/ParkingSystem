<%-- 
    Document   : registerInfor
    Created on : Mar 9, 2024, 2:00:35 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Information</title>
    </head>
    <body>
        <h1>Register Information Here</h1>
        <form action="registerInfor" method="post">
            <label for="firstName">First Name:</label>
            <input type="text" name="firstName" placeholder="First Name" required>
            <br>
            
            <label for="lastName">Last Name:</label>
            <input type="text" name="lastName" placeholder="Last Name" required>
            <br>
            
            <label for="creditCard">Credit Card Number: </label>
            <input type="text" name="creditCard" placeholder="Credit Card Number" required>
            <br>
            
            <label for="phoneNumber">Name:</label>
            <input type="text" name="phoneNumber" placeholder="Phone Number" required>
            <br>
            
            <button type="submit">Register</button>
            <!--<button class="btn">Login</button>-->
        </form>
    </body>
</html>
