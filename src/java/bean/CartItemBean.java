/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Bilal
 */
public class CartItemBean {

    private int itemNumber;
    private String description, cookieType;
    private double unitCost;
    private int quantity;
    private double itemTotalCost;

    public CartItemBean() {
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemTotalCost() {
        return itemTotalCost;
    }

    public void setItemTotalCost(double totalCost) {
        this.itemTotalCost = totalCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCookieType() {
        return cookieType;
    }

    public void setCookieType(String cookieType) {
        this.cookieType = cookieType;
    }

    @Override
    public String toString() {
        return "CartItemBean{" + "itemNumber=" + itemNumber + ", description=" + description + ", cookieType=" + cookieType + ", unitCost=" + unitCost + ", quantity=" + quantity + ", itemTotalCost=" + itemTotalCost + '}';
    }

}
