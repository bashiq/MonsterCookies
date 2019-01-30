/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.CartBean;
import bean.CartItemBean;
import bean.DBBean;
import bean.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Bilal
 */
public class CheckoutController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "delivery":
                SetDeliveryType(request, response, "delivery");
                break;
            case "pickup":
                SetDeliveryType(request, response, "pickup");
                break;
            case "checkpickup":
                PickupCheckout(request, response);
                return;
            case "checkdelivery":
                DeliveryCheckout(request, response);
                return;
            case "submit":
                Submit(request, response);
                return;
            default:
                break;
        }

    }

    private void SetDeliveryType(HttpServletRequest request, HttpServletResponse response, String type) {
        try {
            HttpSession session = request.getSession();
            UserInfo ui;
            Object objui = session.getAttribute("userInfo");

            if (objui != null) {
                ui = (UserInfo) objui;
            } else {
                ui = new UserInfo();
                session.setAttribute("userInfo", ui);
            }
            if (type.equals("delivery")) {
                ui.setDelivery(true);
            } else {
                ui.setDelivery(false);
            }
            session.setAttribute("userInfo", ui);
            String nextPage = "/Login.jsp";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
            dispatcher.forward(request, response);
        } catch (ServletException ex) {
            ex.getLocalizedMessage();
        } catch (IOException ex) {
            ex.getLocalizedMessage();
        }
    }

    private void PickupCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("useexisting");
        
        UserInfo ui = (UserInfo) session.getAttribute("userInfo");
        if (!action.equals("yes")) {
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String phone = request.getParameter("telephone");
            String paytype = request.getParameter("payment");
            System.out.println("checkoutc paytype "+ paytype);
            ui.setFirstName(fname);
            ui.setLastName(lname);
            ui.setPhoneNumber(Long.parseLong(phone));
            ui.setPaytype(paytype);
            ui.setAddressId(-1);
            session.setAttribute("userInfo", ui);
        }else{
            ui.setPaytype(request.getParameter("payment"));
        session.setAttribute("userInfo", ui);
        }
        System.out.println("pick up"+ ui.toString());
        String nextPage = "/Confirmation.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    private void DeliveryCheckout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String action = request.getParameter("useaddress");
        
        UserInfo ui = (UserInfo) session.getAttribute("userInfo");
        
        if (action.equals("yes")) {
            ui.setAddressId(Integer.parseInt(request.getParameter("storeId")));
            ui.setPaytype(request.getParameter("payment"));
            session.setAttribute("userInfo", ui);
        }else{
            if(ui.getUserId() == -1){
                ui.setFirstName(request.getParameter("firstName"));
                ui.setLastName(request.getParameter("lastName"));
                ui.setPhoneNumber(Long.parseLong(request.getParameter("telephone")));
            }
            ui.setStreet(request.getParameter("street"));
            ui.setCity(request.getParameter("city"));
            ui.setState(request.getParameter("state"));
            ui.setZipcode(Integer.parseInt(request.getParameter("zip")));
            ui.setDelivery(true);
            ui.setPaytype(request.getParameter("payment"));
            
            ui.setAddressId(-1);
            session.setAttribute("userInfo", ui);
        }
        System.out.println("whatever" + ui);
        String nextPage = "/Confirmation.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
        dispatcher.forward(request, response);
    }

    private void Submit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        DBBean db = (DBBean) session.getAttribute("dbBean");
        UserInfo ui = (UserInfo) session.getAttribute("userInfo");
        CartBean ct = (CartBean) session.getAttribute("cart");
        int addid, orderid= -1, check = -1, payid;

        ArrayList<CartItemBean> cib = ct.getCartItemsArr();
        if (ui.getUserId() == -1) {
            ui.setUserId(db.InsertIntoCustomer(ui.getFirstName(), ui.getLastName(), Long.toString(ui.getPhoneNumber())));
        }
        if (ui.isDelivery()) {
            addid = db.InsertIntoAddress(Integer.toString(ui.getUserId()), ui.getStreet(), Integer.toString(ui.getZipcode()), ui.getCity(), ui.getState(), "1");
        } else {
            System.out.println("userid is "+ ui.getUserId());
            addid = db.InsertIntoAddress(Integer.toString(ui.getUserId()), " ", "0", " ", " ", "0");
        }
        session.setAttribute("userInfo", ui);

        if (addid != -1) {
            orderid = db.InsertIntoOrder(Integer.toString(addid));
            if (orderid != -1) {
                for (int i = 0; i < cib.size(); i++) {
                    System.out.println("cib "+cib.size());
                    CartItemBean temp = (CartItemBean) cib.get(i);
                    check = db.InsertIntoOrderItems(Integer.toString(orderid), Integer.toString(temp.getItemNumber()), Integer.toString(temp.getQuantity()));
                }
                if (check == 0) {
                    payid = db.InsertPaymentMethod(Integer.toString(ui.getUserId()), Double.toString(ct.getCartOrderTotal()), ui.getPaytype(), orderid);
                    if (payid != -1) {
                        if(ui.isDelivery())
                        session.setAttribute("success", "Your order id is: " + orderid +"\nExpected delivery time is 30 minutes");
                        else
                            session.setAttribute("success", "Your order id is: " + orderid +"\nOrder will be ready in 20 minutes");
                        session.removeAttribute("cart");
                        session.removeAttribute("userInfo");
                        session.removeAttribute("dbBean");
                        response.sendRedirect("./Result.jsp");
                        return;
                    }
                }
            }
        }
        session.setAttribute("ErrorMessage", "Error something went Wrong try ordering again");
                    response.sendRedirect("./Result.jsp");
    }
}
