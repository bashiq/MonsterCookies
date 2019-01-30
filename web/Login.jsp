<%-- 
    Document   : Login
    Created on : Oct 14, 2017, 10:21:50 PM
    Author     : Bilal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Continue as guest</h3>
        <form action ="LoginController" method ="post">
            <input type="hidden" name="action" value="guest">
            <input type = "submit" name = "guest" value = "Guest Mode">
        </form>

        <br /> <br />
        <h3>Enter your login information</h3>
        <font color = red> ${loginMessage}</p></font>
<c:remove var="loginMessage" scope="session" /> 
<form action ="LoginController" method ="post">
    Email <input type = "email" name ="id" required><br />
    <br />
    Password <INPUT type = "password" NAME="password" required>
    <input type="hidden" name="action" value="signin">
    <input type="hidden" name="vieworder" value="v">
    <input type="hidden" name="ohj" value="o">
    <input type = "submit" name = "signin" value = "Sign In">
</form>

<br /><br />
<h3>Sign up for an account</h3>
<h4>All fields are required</h4>
<font color = red> ${signupMessage}</p></font>
<c:remove var="signupMessage" scope="session" /> 
<c:remove var="signupMessage" scope="session" /> 
<form action ="LoginController" method ="post">
    Email <input type ="email" name ="id" required><br />
    Password <input type = "password" name="password" required ><br />
    Confirm Password <input type = "password" name = "confirm" required><br />
    FirstName <input type ="text" name ="firstname" required >&nbsp;
    lastName <input type ="text" name ="lastname" required ><br />
    Phone number <input type ="number" min="1" maxlength =10 name ="phonenumber" required ><br /><br />
    <input type ="hidden" name="action" value ="signup">
    <input type = "submit" name = "signup" value = "Signup">
</form>


</body>
</html>
