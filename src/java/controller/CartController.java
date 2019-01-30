/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import bean.*;

/**
 *
 * @author Bilal
 */
public class CartController extends HttpServlet {

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
        
        switch(action){
            case "add":
                AddToCart(request);
                response.sendRedirect("./Products.jsp");
                    return;
            case "update":
                UpdateItemInCart(request);
                break;
            case "delete":
                DeleteItemInCart(request);
                break;
            default:
                break;
        }
        response.sendRedirect("./Cart.jsp");
    }
    
    private void AddToCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        String itemName = request.getParameter("cookieType");
        String itemNumber = request.getParameter("itemNumber");
        String description = request.getParameter("description");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        
        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }
        
        if(cartBean.addCartItem(itemName, itemNumber, description, price, quantity))
            request.getSession().setAttribute("message", ("\n" + itemName +" has been added to your cart"));
        else
            request.getSession().setAttribute("message", ("Enter a valid result"));
    }
    
    private void DeleteItemInCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        String ItemIndex = request.getParameter("itemIndex");
        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.deleteCartItem(ItemIndex);
        
    }
    private void UpdateItemInCart(HttpServletRequest request){
         HttpSession session = request.getSession();
        String quantity = request.getParameter("quantity");
        String itemIndex = request.getParameter("itemIndex");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(itemIndex, quantity);
        
    }


}
