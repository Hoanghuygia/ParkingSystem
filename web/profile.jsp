<%-- 
    Document   : profile
    Created on : Mar 12, 2024, 3:23:48 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <p>First Name: ${sessionScope.User.vehicleNumber}</p>
            <form action="ActiveAddVehecleModal" method="post">
                <p>Add/Remove your transportation</p>
                <button>Add</button>
            </form>
             
            <% 
            String activeAddVehicleModal = (String) session.getAttribute("ActiveAddVehicleModal");
            
            if(activeAddVehicleModal != null){
                if(activeAddVehicleModal.equals("1")){
            %>
            <div>
            <form action="AddVehileToDatabase" method="post">
                <label for="username">User Name</label>
                <input type="text" name="username" require > 

                <label for="code">Liscece Plate</label>
                <input type="text" name="code" require > 
                    
                <label for="code">Type Transportation</label>
                <input type="text" name="type_transportation" require > 
                    
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
