/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.util.ArrayList;

/**
 *
 * @author Bilal
 */
public class CartBean {

    private ArrayList<CartItemBean> cartItemsArr = new ArrayList();
    private double cartOrderTotal;
    private int totalCartCount;

    public int getTotalCartCount() {
        totalCartCount = cartItemsArr.size();
        return totalCartCount;
    }

    public void deleteCartItem(String itemIndex) {
        try {
            cartItemsArr.remove(Integer.parseInt(itemIndex));
            calculateOrderTotal();
        } catch (NumberFormatException ex) {
            System.out.println("Error while converting string to number: " + ex.getMessage());
        }
    }

    public void updateCartItem(String nitemIndex, String nquantity) {
        double totalCost = 0.0;
        double unitCost = 0.0;
        CartItemBean cartItem = null;

        try {
            int quantity = Integer.parseInt(nquantity);
            int itemIndex = Integer.parseInt(nitemIndex);
            if (quantity > 0) {
                cartItem = (CartItemBean) cartItemsArr.get(itemIndex);
                unitCost = cartItem.getUnitCost();
                totalCost = unitCost * quantity;
                cartItem.setQuantity(quantity);
                cartItem.setItemTotalCost(totalCost);
                calculateOrderTotal();
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error while converting string to number: " + ex.getMessage());
        }
    }

    public boolean addCartItem(String itemName, String iNumber, String desc, String price, String q) {
        boolean flag = false;
        double totalCost = 0.0;
        double unitCost = 0.0;
        int quantity = 0;
        CartItemBean cartItem = new CartItemBean();
        try {
            unitCost = Double.parseDouble(price);
            quantity = Integer.parseInt(q);

            for (int i = 0; i < cartItemsArr.size(); i++) {
                if (cartItemsArr.get(i).getItemNumber() == Integer.parseInt(iNumber)) {
                    cartItemsArr.get(i).setQuantity(cartItemsArr.get(i).getQuantity() + quantity);
                    flag = true;

                    totalCost = unitCost * cartItemsArr.get(i).getQuantity();
                    cartItem.setItemTotalCost(totalCost);
                    calculateOrderTotal();
                    return true;
                }
            }

            if (quantity > 0 && flag == false) {
                totalCost = unitCost * quantity;
                cartItem.setItemNumber(Integer.parseInt(iNumber));
                cartItem.setCookieType(itemName);
                cartItem.setDescription(desc);
                cartItem.setUnitCost(unitCost);
                cartItem.setQuantity(quantity);
                cartItem.setItemTotalCost(totalCost);
                cartItemsArr.add(cartItem);
                calculateOrderTotal();
                //System.out.println(cartItem);
                return true;
            }

        } catch (NumberFormatException ex) {
            System.out.println("Error while converting string to number: " + ex.getMessage());
        }
        return false;
    }

    public void addCartItemArr(CartItemBean cartItem) {
        cartItemsArr.add(cartItem);
    }

    public CartItemBean getCartItemArr(int iItemIndex) {
        CartItemBean cartItem = null;
        if (cartItemsArr.size() > iItemIndex) {
            cartItem = (CartItemBean) cartItemsArr.get(iItemIndex);
        }
        return cartItem;
    }

    public ArrayList getCartItemsArr() {
        return cartItemsArr;
    }

    public void setCartItemsArr(ArrayList cartItems) {
        this.cartItemsArr = cartItems;
    }

    public double getCartOrderTotal() {
        return cartOrderTotal;
    }

    public void setCartOrderTotal(double orderTotal) {
        this.cartOrderTotal = orderTotal;
    }

    private void calculateOrderTotal() {
        double total = 0;
        for (int i = 0; i < cartItemsArr.size(); i++) {
            CartItemBean cartItem = (CartItemBean) cartItemsArr.get(i);
            total += cartItem.getItemTotalCost();
        }
        setCartOrderTotal(total);
    }

    public String cartIsEmpty() {
        return "<p> Cart is Empty</p>";
    }

}
