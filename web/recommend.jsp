<%-- 
    Document   : recommend
    Created on : Mar 15, 2024, 10:10:21 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recommend</title>
    </head>
    <body>
        <h1>Our recommend here</h1>
        <p>${sessionScope.ParkingSpot} is empty</p>
        <%
        String parkingSpot = (String) session.getAttribute("ParkingSpot");

        if (parkingSpot != null && parkingSpot.charAt(0) == 'R') {
            session.setAttribute("Marker", "R");
        }
        else{
            session.setAttribute("Marker", "G");
        }
        %>
        
        <form action="recommend" method="post">
            <button>Submit</button>
        </form>
        
        <form action="ChooseNewSpot" method="post">
            <button>Choose a new spot</button>
        </form>
        
        <div>
            <% 
            String message = (String) session.getAttribute("ParikingSuccess");
            if (message != null && !message.isEmpty()){
                session.removeAttribute("ParikingSuccess");
            %>
            <p style="color: #3096d5;"> <%= message %> </p>
            
            <form action="BackToHome" method="post">
                <p>Back to Home</p>
                <button>Yes</button>
            </form>
            <%
                }
            %>  
        </div>
        
    </body>
</html>
