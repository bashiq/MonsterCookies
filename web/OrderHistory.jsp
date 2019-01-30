<%-- 
    Document   : OrderHistory
    Created on : Oct 19, 2017, 11:50:38 PM
    Author     : Bilal
--%>

<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="userInfo" scope="session" class="bean.UserInfo" />
<jsp:useBean id="dbBean" scope="session" class="bean.DBBean" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="main.css" rel="stylesheet" type="text/css" />
        <title>Order History</title>
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

        <div><br /><br /><br />

            <%if (!userInfo.isUserLogggedIn()) { %>
            <center><h3>Enter your login information</h3>
                <font color = red> ${loginMessage}</p></font>
                <c:remove var="loginMessage" scope="session" /> 
                <form action ="LoginController" method ="post">
                    Email <input type = "email" name ="id" required><br />
                    <br />
                    Password <INPUT type = "password" NAME="password" required>
                    <input type="hidden" name="action" value="signin">
                    <input type="hidden" name="vieworder" value="vieworder">
                    <input type="hidden" name="ohj" value="ohj">
                    <input type = "submit" name = "signin" value = "Sign In">
                    </center>
                </form>
                <% } else { %>
                <br /><br /><center>
                    <table border="1" cellpadding="5">
                                    <caption><h2>Past Orders</h2></caption>
                                    <tr>
                                            <th>Order Id</th>
                                            <th>delivery type</th>
                                            <th>order date</th>
                                            <th>Payment Method</th>
                            <th>total Amount</th>
                                        </tr>
                            <% ResultSet rs = dbBean.OrderNumberView(userInfo.getUserId());
                                while (rs.next()) {
                                    String var = "pickup";
                                    if (rs.getInt("isdelivery") == 1) {
                                        var = "delivery";
                                    }
                            %>
                        <tr>

                            <td><%=rs.getInt("orderId")%></td>
                            <td><%=var%></td>
                            <td><%=rs.getString("orderdate")%></td>
                            <td><%=rs.getString("paymentmethod")%></td>
                            <td><%=rs.getDouble("totalAmount")%></td>
                        </tr>

                                    <%}%>
                    </table>


                </center>
                <br />
                <form action = "LoginController" method ="post">
                    <input type ="hidden" name ="action" value ="logout">
                    <input type="submit" value = "Logout" />
                </form></center>
                <% }%>

        </div>
    </body>
</html>
