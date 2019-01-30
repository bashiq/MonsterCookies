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
public class UserInfo {

    private String firstName, lastName, street, city, state;
    private int zipcode, userId = -1;
    private Long phoneNumber;
    private String paytype;
    private boolean userLogggedIn = false, delivery;
    private int AddressId = -1;

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int AddressId) {
        this.AddressId = AddressId;
    }

    public boolean isUserLogggedIn() {
        return userLogggedIn;
    }

    public void setUserLogggedIn(boolean userLogggedIn) {
        this.userLogggedIn = userLogggedIn;
    }

    public boolean isDelivery() {
        return delivery;
    }

    public void setDelivery(boolean d) {
        this.delivery = d;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPaytype() {
        return paytype;
    }

    public void setPaytype(String paytype) {
        this.paytype = paytype;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserInfo{" + "firstName=" + firstName + ", lastName=" + lastName + ", street=" + street + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", userId=" + userId + ", phoneNumber=" + phoneNumber + ", paytype=" + paytype + ", userLogggedIn=" + userLogggedIn + ", delivery=" + delivery + ", AddressId=" + AddressId + '}';
    }

}
