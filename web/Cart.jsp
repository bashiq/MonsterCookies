<%-- 
    Document   : Cart
    Created on : Oct 10, 2017, 6:17:32 PM
    Author     : Bilal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page import = "bean.DBBean" %>
<jsp:useBean id = "dbBean" scope = "session" class = "bean.DBBean" />
<jsp:useBean id="cart" scope="session" class="bean.CartBean" />
<html>
    <head>
        <title>Cart</title>
        <link href="main.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <div id="head"><img src="images/toptop.png" alt="Monster Cookies" style="width:100%;height:150px;"></div>
        <br/>

        <div id="links">
            <ul>
                <li><a href="./Home.html">Home</a></li>
                <li><a href="./Products.jsp">Products</a></li>
                <li><a href="./Cart.jsp">Cart</a></li>
                <li><a href="./OrderHistory.jsp">OrderHistory</a></li>
            </ul>
        </div>
        <br/>
        <div><img src="images/thumbs.jpg" alt="Confirmation" style="width:100%;height:300px;"></div>
        <h2>Shopping Cart</h2>
        <!-- What ever the customer decides to get will show up on this checkout page-->

        <% if (cart.getTotalCartCount() == 0) {%>
        <p>Cart is Empty</p> <%} else {
            int i = 0;%>

        <table>

            <tr>
                <th>Name</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th> Total price</th>
            </tr>
            <c:forEach items="${cart.cartItemsArr}" var="value">
                 <form method="post" action="CartController">
                    <tr>

                        <td><b>${value.getCookieType()}</b><br />
                            ${value.getDescription()}
                        </td>
                        <td>
                            <input type="hidden" name="itemIndex" value="<%=i++%>" >
                            <input type="number" min="0" max="20" name="quantity" value="${value.getQuantity()}" size='2'> 
                            <input type="submit" name="action" value="update">
                            <br/><input type="submit" method= "post" name="action" value="delete">

                        </td>
                        <td>${value.getUnitCost()}</td>
                        <td>${value.getItemTotalCost()}</td>
                    </tr>
                </form>
            </c:forEach>
             <tr>
                <td colspan="2"> </td>
                <td> </td>
                <td>Subtotal: $<c:out value="${cart.getCartOrderTotal()}"/></td>
            </tr>
        </table>
        <br />
    <center> <form method="post" action="CheckoutController">
            <input type="submit" name = "action" value = "pickup" >
            <input type="submit" name = "action" value = "delivery" >
        </form>
    </center>

    <%}%>
</body>
</html>

