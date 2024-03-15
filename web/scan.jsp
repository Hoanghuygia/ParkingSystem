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
            <input type="text" name="licensePlate" required><br>
            
            <input type="radio" name="typeMotorecycle" value="motorcycle" required>
            <label for="typeMotorecycle">Motorcycle</label><br>
            <input type="radio" name="typeMotorecycle"value="motor">
            <label for="typeMotorecycle">Motor</label><br>
            <input type="radio" name="typeMotorecycle" value="other">
            <label for="typeMotorecycle">Other</label>
            
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
