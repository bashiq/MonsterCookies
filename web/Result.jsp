<%-- 
    Document   : Result
    Created on : Oct 15, 2017, 10:56:45 PM
    Author     : Bilal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result</title>
    </head>
    <body>
        <% if(session.getAttribute("ErrorMessage") != null){ 
        session.removeAttribute("ErrorMessage"); %>
        
    <center> <h2>Error: Please try ordering again</h2>
       
    <%}else{%>
        <center><h1>Congratulations!</h1>
            <img src="images/congrat.png" alt="Monster Cookies" style="width: 400;height:400px;"> <br />
            <p>${success} until then enjoy some CookieMonster</p>
    <%session.removeAttribute("success");%>
    <%}%>
    </center>
    <center><form action="./Home.html">
    <input type="submit" value="Home" />
        </form></center>
        
    </body>
</html>
