<%-- 
    Document   : scan
    Created on : Mar 15, 2024, 2:23:53 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scan</title>
    </head>
    <body>
        <h1>Scan here</h1>
        <form action="scan" method="post">
            <label for="licencePlate">License Plate</label>
            <input type="text" name="licensePlate" required>
            <br>
            
            <input type="radio" name="typeTransportation" value="motorcycle" required>
            <label for="typeTransportation">Motorcycle</label><br>
            <input type="radio" name="typeTransportation"value="car">
            <label for="typeTransportation">Car</label><br>
            
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
