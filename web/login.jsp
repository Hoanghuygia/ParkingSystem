<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>login</title>

        <link rel="icon" href="" type="image/x-icon" />
        <link rel="stylesheet" href="css/login.css">
        <!-- box icon -->
        <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <section class="login-container">
            <div class="login-box">
                <h2>Login</h2>


                <form action="login" method="post">
                    <label class="username" for="username">Username</label>
                    <div class="input-box">
                        <i for="username" class='bx bx-user icon-form'></i>
                        <input type="text" name="username" placeholder="Type your username" require > 
                    </div>

                    <label class="password" for="password">Password</label>
                    <div class="input-box">
                        <i for="password" class='bx bx-lock icon-form' ></i>
                        <input type="password" name="password" placeholder="Type your password" require > 
                    </div>
                    <% String error = (String) session.getAttribute("InvalidUser");
                if (error != null && !error.isEmpty()){
                    session.removeAttribute("InvalidUser");
                    %>
                    <p style="color: red;"> <%= error %> </p>
                    <%
                        }
                    %>
                    <p>Forgot password?</p>

                    <button class="btn">Login</button>
                </form>

                <p>Or Sign Up Using</p>
                <div class="icon-box">
                    <a href=""><i class='icon-social bx bxl-gmail'></i></a>
                    <a href=""><i class='icon-social bx bxl-facebook'></i></a>
                    <a href=""><i class='icon-social bx bxl-instagram-alt' ></i></a>
                </div>

                <p>Or Sign Up Using</p>
                <a href="register">SIGN UP</a>
            </div>
        </section>
    </body>
</html>
