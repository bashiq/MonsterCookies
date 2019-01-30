<%-- 
    Document   : Confirmation
    Created on : Oct 15, 2017, 7:58:57 PM
    Author     : Bilal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page import = "bean.DBBean" %>
<jsp:useBean id="userInfo" scope="session" class="bean.UserInfo" />
<jsp:useBean id="dbBean" scope="session" class="bean.DBBean" />
<jsp:useBean id="cart" scope="session" class="bean.CartBean" />

<html>
    <head>
        <link href="main.css" rel="stylesheet" type="text/css" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Confirmation Page</h2>
        <h3>Customer information</h3>
        <p> Name: ${userInfo.firstName} ${userInfo.lastName} &nbsp; Telephone: ${userInfo.phoneNumber}</p>
        <%if (userInfo.isDelivery()) {%>
        <p> Address: ${userInfo.street} ${userInfo.city} ${userInfo.state} ${userInfo.zipcode}
            <% } %>
        <h3> Order details</h3>
        ${userInfo.paytype}

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
                <tr>

                    <td><b>${value.getCookieType()}</b><br />
                        ${value.getDescription()}
                    </td>
                    <td>
                        ${value.getQuantity()}                          
                    </td>
                    <td>${value.getUnitCost()}</td>
                    <td>${value.getItemTotalCost()}</td>
                </tr>
            </c:forEach>
             <tr>
                <td colspan="2"> </td>
                <td> </td>
                <td>Subtotal: $<c:out value="${cart.getCartOrderTotal()}"/></td>
            </tr>
        </table>
        <br />
    <center> <form method="post" action="CheckoutController">
            <input type="submit" name = "action" value = "submit" >
        </form>
    </center>

    <%}%>



</body>
</html>
