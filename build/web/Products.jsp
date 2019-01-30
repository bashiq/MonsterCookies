<%-- 
    Document   : Products
    Created on : Oct 13, 2017, 2:32:43 AM
    Author     : Bilal
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="dbBean" scope="session" class="bean.DBBean" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Products</title>
        <link href="main.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div id="head"><img src="images/toptop.png" alt="Monster Cookies" style="width:100%;height:150px;"></div>

        <div id="links">
            <ul>
                <li><a href="./Home.html">Home</a></li>
                <li><a href="./Products.jsp">Products</a></li>
                <li><a href="./Cart.jsp">Cart</a></li>
                <li><a href="./OrderHistory.jsp">OrderHistory</a></li>
            </ul>
        </div>
        <br/>
    <center><h1> Monsters Selection</h1></center>
    <center><h3> All our cookies come with complementary cold milk</h3></center>
    <hr />

    <font color = red> ${message}</p></font><!-- to tell user item has been added to cart-->
    <c:remove var="message" scope="session" /> 

<div><!--- First product -->
    <form action ="CartController" method = "post">
        <h2 style="color:blue"> Chocolate Chip</h2> <input type="hidden" name="cookieType" value="Chocolate Chip"> <input type ="hidden" name ="itemNumber" value = "100">
        <img src ="images/chocChip.jpg" alt ="Chocolate Chip" style="width: 400px; height: 300px;">
        <p>Try Monster's favorite cookie. You can never go wrong with our classic chocolate chip cookie</p> <input type="hidden" name="description" value="Our favorite, Chocolate Chip">
        Price: $1.99 <input type="hidden" name="price" value="1.99">
        <%if (dbBean.IsSoldOut(100) > 0) {%>
        <br /> quantity <input type="number" name="quantity" min="0" max="20" size = 3 value ="1">
        <input type="hidden" name="action" value="add">
        <input type="submit" name="cart" value="Add to Cart">
        <%} else {%>
        <h2>SOLD OUT</h2><%}%>
    </form></div>

<hr />


<div><!--Next product-->
    <form action="CartController" method = "post"><input type="hidden" name="cookieType" value="M&N"> <input type ="hidden" name ="itemNumber" value = "200">
        <h2 style="color:blue"> M&N Cookie</h2>
        <img src ="images/mmCook.jpg" alt ="M&M cookie" style="width: 400px; height: 300px;">
        <p>Cookies and M&Ms that's a recipe for... well deliciousness</p> <input type="hidden" name="description" value="the guy who is a rapper">
        Price: $1.99 <input type="hidden" name="price" value="1.99">
        <%if (dbBean.IsSoldOut(200) > 0) {%>
        <br /> quantity <input type="number" name="quantity" min="0" max="20" size = 3 value ="1">
        <input type="hidden" name="action" value="add">
        <input type="submit" name="cart" value="Add to Cart">
        <%} else {%>
        <h2>SOLD OUT</h2><%}%>
    </form>
    <hr />
</div>

<div><!--Next product-->
    <form action="CartController" method = "post"><input type="hidden" name="cookieType" value="oat"> <input type ="hidden" name ="itemNumber" value = "300">
        <h2 style="color:blue"> Oatmeal Raisin</h2>
        <img src ="images/oatmeal.jpg" alt ="oatmeal" style="width: 400px; height: 300px;">
        <p>The underated cookie</p> <input type="hidden" name="description" value="the underated cookie">
        Price: $1.99 <input type="hidden" name="price" value="1.99">
        <%if (dbBean.IsSoldOut(300) > 0) {%>
        <br /> quantity <input type="number" name="quantity" min="0" max="20" size = 3 value ="1">
        <input type="hidden" name="action" value="add">
        <input type="submit" name="cart" value="Add to Cart">
        <%} else {%>
        <h2>SOLD OUT</h2><%}%>
    </form>
    <hr />
</div>

<br>
<center> <form action = "./Cart.jsp">
        <input type="submit" value = "Cart" />
    </form></center>

</body>
</html>

