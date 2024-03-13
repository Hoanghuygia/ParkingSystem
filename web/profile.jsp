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
            <form action="ChangeFirstName" method="post">
                <p>Enter your new first name</p>
                <input type="text" name="firstName" placeholder="First Name" require > 
                <button type="submit">Submit</button>
            </form>
        </div>
            
        <div>
            <p>Last Name: ${sessionScope.User.lastName}</p>
            <form action="ChangeLastName" method="post">
                <p>Enter your new last name</p>
                <input type="text" name="lastname" placeholder="Last Name" require > 
                <button type="submit">Submit</button>
            </form>
        </div>
        
        <div>
            <p>Coin ${sessionScope.User.coin}</p>
            <form action="ChargeCoin" method="post">
                <p>Charge here</p>
                <input type="text" name="chargecoin" placeholder="Number coin charge" require > 
                <button type="submit">Submit</button>
            </form>
        </div>
            
        <div>
            <p>Credit Number: ${sessionScope.User.creditNumber}</p>
            <form action="ChangeCreditCardNumber" method="post">
                <p>Enter your new credit card number</p>
                <input type="text" name="creditcard" placeholder="Credit Card Number" require > 
                <button type="submit">Submit</button>
            </form>
        </div>
        
        <div>
            <p>First Name: ${sessionScope.User.phoneNumber}</p>
            <form action="ChangePhoneNumber" method="post">
                <p>Enter your new phone number</p>
                <input type="text" name="phonenumber" placeholder="Phone Number" require > 
                <button type="submit">Submit</button>
            </form>
        </div>
            
        <div>
            <p>First Name: ${sessionScope.User.vehicleNumber}</p>
            <form action="AddOrRomoveVehicle" method="post">
                <p>Add/Remove your transportation</p>
                <input type="text" name="vehiclenumber" placeholder="Vehicle Number" require > 
                <button type="submit">Submit</button>
            </form>
        </div>
    </body>
</html>
