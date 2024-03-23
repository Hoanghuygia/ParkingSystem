<%-- 
    Document   : home
    Created on : Mar 9, 2024, 2:53:02 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
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

        <div>
            <p>Current parked transportation</p>
            <table style="border-collapse: collapse; width: 100%;">
                <tr style="background-color: #f2f2f2;"> <!-- Header row background color -->
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Code</th>
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Spot</th>
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Start Time</th>
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Type Transportation</th>
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;"></th>
                </tr>
                <c:forEach var="parking" items="${requestScope.Parking}">
                

                    <tr style="background-color: #ffffff;"> <!-- Alternate row background color -->
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${parking.getCode()}</td>
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${parking.getSpot()}</td>
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${parking.getStartTime()}</td>
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${parking.getTypeTransportation()}</td>

                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">
                            <form action="TakeTransportation" method="post">
                                <input type="hidden" name="code" value="${parking.getCode()}">
                                <input type="hidden" name="typeTransporation" value="${parking.getTypeTransportation()}">
                                <!--<button type="submit" name="departButton" value="">Depart</button> using button to submit value-->
                                <button type="submit">Depart</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table> 
            
        </div>    
    </body>
</html>
