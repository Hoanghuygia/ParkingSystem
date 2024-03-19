<%-- 
    Document   : profile
    Created on : Mar 12, 2024, 3:23:48 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <h1>Profile</h1>

        <div>
            <p>First Name: ${sessionScope.User.firstName}</p>
            <form action="ChangeUserInformation" method="post">
                <p>Enter your new first name</p>
                <input type="text" name="firstname" placeholder="First Name" require > 
                <button type="submit">Save</button>
            </form>
        </div>

        <div>
            <p>Last Name: ${sessionScope.User.lastName}</p>
            <form action="ChangeUserInformation" method="post">
                <p>Enter your new last name</p>
                <input type="text" name="lastname" placeholder="Last Name" require > 
                <button type="submit">Save</button>
            </form>
        </div>

        <div>
            <p>Coin ${sessionScope.User.coin}</p>
            <form action="ChangeUserInformation" method="post">
                <p>Charge here</p>
                <input type="text" name="chargedcoin" placeholder="Number coin charge" require > 
                <button type="submit">Charge</button>
            </form>
        </div>

        <div>
            <p>Credit Number: ${sessionScope.User.creditNumber}</p>
            <form action="ChangeUserInformation" method="post">
                <p>Enter your new credit card number</p>
                <input type="text" name="creditcard" placeholder="Credit Card Number" require > 
                <button type="submit">Save</button>
            </form>
        </div>

        <div>
            <p>First Name: ${sessionScope.User.phoneNumber}</p>
            <form action="ChangeUserInformation" method="post">
                <p>Enter your new phone number</p>
                <input type="text" name="phonenumber" placeholder="Phone Number" require > 
                <button type="submit">Save</button>
            </form>
        </div>

        <div>
            <p>Current registered transportation</p>
            <table style="border-collapse: collapse; width: 100%;">
                <tr style="background-color: #f2f2f2;"> <!-- Header row background color -->
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Code</th>
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Type</th>
                    <th style="border: 1px solid #dddddd; padding: 8px; text-align: left;">Date Contract</th>
                </tr>
                <c:forEach var="contract" items="${requestScope.Contracts}">
                
                    <tr style="background-color: #ffffff;"> <!-- Alternate row background color -->
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${contract.getCode()}</td>
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${contract.getTypeTransportation()}</td>
                        <td style="border: 1px solid #dddddd; padding: 8px; text-align: left;">${contract.getDate()}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>


        <div>
            <p>Vehicle Number: ${sessionScope.User.vehicleNumber}</p>
            <form action="ActiveAddVehecleModal" method="post">
                <p>Add/Remove your transportation</p>
                <button>Add</button>
            </form>

            <% 
            String activeAddVehicleModal = (String) session.getAttribute("ActiveAddVehicleModal");
            
            
            if(activeAddVehicleModal != null){
                session.removeAttribute("ActiveAddVehicleModal");
                if(activeAddVehicleModal.equals("1")){
            %>
            <div>
                <form action="AddVehileToDatabase" method="post">
                    <label for="code">Licence Plate</label>
                    <input type="text" name="code" require > <br>

                    <label for="code">Type Transportation</label> <br>
                    <input type="radio" name="typeTransportation" value="motorcycle" required>
                    <label for="typeTransportation">Motorcycle</label><br>
                    <input type="radio" name="typeTransportation"value="car">
                    <label for="typeTransportation">Car</label><br>

                    <button type="submit">Submit</button>
                </form>
            </div>
            <%
                }
            }

            %>               
        </div>
    </body>
</html>
