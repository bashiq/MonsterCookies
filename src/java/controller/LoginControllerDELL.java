/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.DBBean;
import bean.UserInfo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class LoginControllerDELL extends HttpServlet {

    private DBBean dbBean = null;

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
        HttpSession session = request.getSession();
        Object objdbBean = session.getAttribute("dbBean");

        if (objdbBean != null) {
            dbBean = (DBBean) objdbBean;
        } else {
            dbBean = new DBBean();
        }

        String action = request.getParameter("action");

        switch (action) {
            case "guest":
                GuestMode(request, response);
                //response.sendRedirect("./Products.jsp");
                return;
            case "signin":
                SignIn(request, response);
                break;
            case "signup":
                SignUp(request, response);
                break;
            case "logout":
                Logout(request, response);
                break;
            default:
                break;
        }
    }

    public void SignUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String email = request.getParameter("id");
        String password = request.getParameter("password");
        String cpass = request.getParameter("confirm");
        String first = request.getParameter("firstname");
        String last = request.getParameter("lastname");
        String phone = request.getParameter("phonenumber");
        if (password.equals(cpass)) {
            try {
                int userId = dbBean.CreateUserLogin(first, last, phone, email, cpass);
                UserInfo ui = (UserInfo) session.getAttribute("userInfo");
                ui.setFirstName(first);
                ui.setLastName(last);
                ui.setPhoneNumber(Long.parseLong(phone));
                if (userId != -1) {
                    ui.setUserId(userId);

                    ui.setUserLogggedIn(true);
                    session.setAttribute("userInfo", ui);
                    String nextJSP = "/Checkout.jsp";
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
                    dispatcher.forward(request, response);
                }else{

                session.setAttribute("signupMessage", "invalid data try again");
                response.sendRedirect("./Login.jsp");
                }
            } catch (SQLException ex) {
                ex.getLocalizedMessage();
                session.setAttribute("signupMessage", ex.getLocalizedMessage());
                response.sendRedirect("./Login.jsp");
            }
        } else {
            
            session.setAttribute("signupMessage", "Passwords do not match");
            response.sendRedirect("./Login.jsp");
        }

    }

    public void SignIn(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = request.getParameter("id");
        String password = request.getParameter("password");
        int id = dbBean.canlogin(username, password);
        if (id != -1) {
            UserInfo ui = (UserInfo) session.getAttribute("userInfo");
            UserInfo temp = dbBean.GetUserInfo(id);
            ui.setFirstName(temp.getFirstName()); ui.setLastName(temp.getLastName()); ui.setPhoneNumber(temp.getPhoneNumber());
            ui.setUserId(id);
            ui.setUserLogggedIn(true);
            session.setAttribute("userInfo", ui);
            String nextJSP;
           // System.out.println("in signin" + request.getParameter("action"));
            if(request.getParameter("vieworder").equals("vieworder")){
                nextJSP = "/OrderHistory.jsp";
            }else{
            nextJSP = "/Checkout.jsp";
        }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
            dispatcher.forward(request, response);
        } else {
            session.setAttribute("loginMessage", "Invalid UserName or password");
            if(request.getParameter("ohj").equals("ohj"))
                response.sendRedirect("./OrderHistory.jsp");
            else
                response.sendRedirect("./Login.jsp");
        }

    }

    public void GuestMode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         HttpSession session = request.getSession();
            UserInfo ui = (UserInfo) session.getAttribute("userInfo");
            ui.setUserId(-1);
            session.setAttribute("userInfo", ui);
        
        
        String nextJSP = "/Checkout.jsp";
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
        dispatcher.forward(request, response);
    }
    
    private void Logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("userInfo");
        response.sendRedirect("./OrderHistory.jsp");
    }
}
