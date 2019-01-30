<%-- 
    Document   : Checkout
    Created on : Oct 14, 2017, 11:38:35 PM
    Author     : Bilal
--%>

<%@page import="bean.Address"%>
<%@page import="bean.UserInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="userInfo" scope="session" class="bean.UserInfo" />
<jsp:useBean id="dbBean" scope="session" class="bean.DBBean" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Checkout</title>
    </head>
    <body>
        <div><img src="images/registerCookie.jpg" alt="Checkout" style="width:100%;height:300px;"></div>
        <br />
        Enter your Information so we can process your order correctly address&nbsp;


        <%
            if(userInfo.isDelivery()){
        %>
        <h2>Delivery</h2>
        <% if(userInfo.getUserId() != -1) { %>


        <% Address[] ad = dbBean.getAddresses(userInfo.getUserId());
            for (int i = 0; i < ad.length; i++) {%> <h5>Address <%=i + 1%>
            <form action ="CheckoutController" method ="post">
                <%=ad[i]%><br /> 
                Cash or credit<br /><input type="radio" name="payment" value="cash"required> cash<br />
                <input type="radio" name="payment" value="credit"required> credit<br />
                <input type="submit" name="Submit" value="Submit">
                <input type="hidden" name="storeId" value="<%=ad[i].getId()%>">
                <input type="hidden" name="action" value="checkdelivery">
                <input type="hidden" name="useaddress" value="yes">
            </form>
            <br /><%}%>
            <br /><br />
            Complete all fields
            <form action ="CheckoutController" method ="post">
                <p>Street <input type="text" name="street" size="50" required pattern=".*\S+.*" title="Enter valid text" required></p>
                <p>City <input type="text" name="city" size="23" required pattern="\S+" title="Enter valid text" required>&nbsp;
                    State <select size="1" name="state" required>
                        <option value="MD">Maryland-MD</option>
                        <option value="DC">Washington-DC</option>
                        <option value="VA">Virginia-VA</option>
                    </select>&nbsp;
                    Zip<input type="number" name ="zip" min = "10000" max="99999" maxlength=5></p>
                Cash or credit<br /><input type="radio" name="payment" value="cash" required> cash<br>
                <input type="radio" name="payment" value="credit"required> credit<br>

                <p><input type="submit" name="Submit" value="Submit">
                    <input type="reset" value="Reset"></p>
                <input type="hidden" name="action" value="checkdelivery">
                <input type="hidden" name="useaddress" value="no">
            </form>



            <% } else { %>
            Complete all fields
            <form action ="CheckoutController" method ="post">  

                <p>First Name <input type="text" name="firstName" required pattern="\S+" title="Enter valid text" required>&nbsp;
                    Last Name <input type="text" name="lastName" required pattern="\S+" title="Enter valid text" required>&nbsp;
                <p>Telephone <input type="number" name="telephone" size="20" title="Enter valid text" required>&nbsp;
                <p>Street <input type="text" name="street" size="50" required pattern=".*\S+.*" title="Enter valid text" required></p>
                <p>City <input type="text" name="city" size="23" required pattern="\S+" title="Enter valid text" required>&nbsp;
                    State <select size="1" name="state" required>
                        <option value="MD">Maryland-MD</option>
                        <option value="DC">Washington-DC</option>
                        <option value="VA">Virginia-VA</option>
                    </select>&nbsp;
                    Zip <input type="number" name ="zip" min = "10000" max="99999" maxlength=5></p>
                Cash or credit <br /><input type="radio" name="payment" value="cash"required> cash<br>
                <input type="radio" name="payment" value="credit" required> credit<br>

                <p><input type="submit" name="Submit" value="Submit">
                    <input type="reset" value="Reset"></p>
                <input type="hidden" name="action" value="checkdelivery">
                <input type="hidden" name="useaddress" value="no">
            </form>



            <% }
        } else {%>
            <h2>Pickup</h2>
            <% if (userInfo.getUserId() != -1) { %>
            <form action ="CheckoutController" method ="post">
                <h3>Use existing information</h3><br /> Name: ${userInfo.firstName} ${userInfo.lastName}   &nbsp; PhoneNumber: ${userInfo.phoneNumber}<br /><br />

                Cash or credit<br /><input type="radio" name="payment" value="cash" required> cash<br>
                <input type="radio" name="payment" value="credit" required> credit<br>
                <input type="submit" name="Submit" value="Submit">
                <input type="hidden" name="action" value="checkpickup">
                <input type="hidden" name="useexisting" value="yes">
            </form>
            <% } else {%>

            <h3>Complete all fields</h3>
            <form action ="CheckoutController" method ="post">
                <p>First Name <input type="text" name="firstName"  required pattern="\S+" title="Enter valid text" required />&nbsp;
                    Last Name <input type="text" name="lastName" required />&nbsp;
                <p>Telephone <input type="number" name="telephone" size="20" maxlength =10 required /><br />
                    Cash or credit<br /><input type="radio" name="payment" value="cash" required > cash<br>
                    <input type="radio" name="payment" value="credit" required > credit<br>
                <p><input type="submit" name="Submit" value="Submit">
                    <input type="reset" value="Reset"></p>
                <input type="hidden" name="action" value="checkpickup">
                <input type="hidden" name="useexisting" value="no">
            </form>
            <% } %>
            <% }%>
    </body>
</html>

