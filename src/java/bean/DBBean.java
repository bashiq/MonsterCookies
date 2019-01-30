/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bilal
 */
public class DBBean {

    private Connection connection = null;

    public static void main(String[] args) throws SQLException {
        DBBean db = new DBBean();

        System.out.println(db.InsertIntoOrderItems("2", "200", "3"));
//        Address[] ad = db.getAddresses(31);
//        //if(ad == null)
//        for (Address ad1 : ad) {
//            System.out.println(ad1);
//        }
//        int userid= db.InsertIntoCustomer("elmo", "luis", "2222");
//        System.out.println("user"+ userid);
//        int orderid ;
//        int addressId = db.InsertIntoAddress(Integer.toString(userid), "31 capitol st", "21221", "laurel", "md", "1");
//        if(addressId != -1){
//            orderid = db.InsertIntoOrder(Integer.toString(addressId));
//            if(orderid != -1){
//                int check=  db.InsertIntoOrderItems(Integer.toString(orderid), "200", "9");
//                if(check == 0){
//                    int payid = db.InsertPaymentMethod(Integer.toString(userid), "19.56", "cash");
//                    if(payid != -1)
//                        System.out.println("YEAHHHHHHH");
//                }
//            }
//        }
        // System.out.println("hello");
    } // pstmt = conn.prepareStatement("insert into Address " +

    public DBBean() {
        initializeJdbc();
    }

    /**
     * Initialize database connection
     */
    public void initializeJdbc() {
        String username = "root";
        String password = "root";
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/monstercookies?zeroDateTimeBehavior=convertToNull";
        try {
            Class.forName(driver);
            // Connect to the sample database
            connection = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println("Error: In DBBean initializeJdbc");
        }
    }

    /**
     * Return connection property
     */
    public Connection getConnection() {
        return connection;
    }

    public int InsertIntoCustomer(String first, String last, String pNum) {
        int id;
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (Firstname, LastName, phoneNumber) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setLong(3, Long.parseLong(pNum));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        id = (generatedKeys.getInt(1));
                        return id;
                    } else {
                        return -1;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("incustomer" + ex.getLocalizedMessage());
            return -1;
        }
        return -1;
    }

    public CartItemBean[] getCookiesAvailible() {

        return null;
    }

    public int canlogin(String email, String password) {
        try {
            Statement st = connection.createStatement();
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select * from useraccount where email= ? and password= ?");
            stmt.setString(1, email);
            stmt.setString(2, password);
            rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("userid");
            }
        } catch (SQLException ex) {
            System.out.println("in userlogin" + ex.getLocalizedMessage());
        }
        return -1;
    }

    /**
     * returns userid
     *
     * @param first
     * @param last
     * @param pNum
     * @param user
     * @param pass
     * @return
     * @throws SQLException
     */
    public int CreateUserLogin(String first, String last, String pNum, String user, String pass) throws SQLException {
        int id = -1;
        try {
            // Statement st = connection.createStatement();

            PreparedStatement stmt = connection.prepareStatement("INSERT INTO customer (Firstname, LastName, phoneNumber) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setLong(3, Long.parseLong(pNum));

            id = InsertIntoCustomer(first, last, pNum);
            int rowsin;
            if (id > 0) {

                System.out.println("user id is" + id);
                PreparedStatement stmt1 = connection.prepareStatement("insert into useraccount (email, password, userid) values (?, ?, ?)");
                stmt1.setString(1, user);
                stmt1.setString(2, pass);
                stmt1.setInt(3, id);
                rowsin = stmt1.executeUpdate();
                stmt1.close();
                if (rowsin > 0) {
                    return id;
                }
            }
        } catch (SQLException ex) {
            System.out.println("in create" + ex.getLocalizedMessage());
            return -1;
        }
        return -1;
    }

    /**
     * returns addressid
     *
     * @param userid
     * @param street
     * @param zip
     * @param city
     * @param state
     * @param isDelivery
     * @return
     */
    public int InsertIntoAddress(String userid, String street, String zip, String city, String state, String isDelivery) {
        int adId = -1;
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO addresstable (custid, street, zipcode, city, state, isdelivery) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, userid);
            stmt.setString(2, street);
            stmt.setInt(3, Integer.parseInt(zip));
            stmt.setString(4, city);
            stmt.setString(5, state);
            stmt.setInt(6, Integer.parseInt(isDelivery));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        adId = (generatedKeys.getInt(1));
                        return adId;
                    } else {
                        return -1;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("inaddress" + ex.getLocalizedMessage());
        }
        return -1;
    }

    /**
     * return orderid
     *
     * @param addressId
     * @return
     */
    public int InsertIntoOrder(String addressId) {
        int orderId = -1;
        try {
            Calendar cal = Calendar.getInstance();
            java.sql.Timestamp timestamp = new java.sql.Timestamp(cal.getTimeInMillis());
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO ordertable (Orderdate, addrid) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, timestamp.toString());
            stmt.setInt(2, Integer.parseInt(addressId));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        orderId = (generatedKeys.getInt(1));
                        return orderId;
                    } else {
                        return -1;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("inOrder " + ex.getLocalizedMessage());
        }
        return -1;
    }

    /**
     * return 0 if succesful -1 if not no pk for this table
     *
     * @param itemNum
     * @param oq
     * @param orderid
     * @return
     */
    public int InsertIntoOrderItems(String orderid, String itemnum, String oq) {
        int orderitemId = -1;
        try {
            String query = "UPDATE items SET quantity = quantity - " + oq + " where items.itemid = " + itemnum;
            Statement st = connection.createStatement();
            int success = st.executeUpdate(query);
            if (success == 0) {
                return -1;
            }
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO orderitems (orderedId, itemnumber, orderedqauntity) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, Integer.parseInt(orderid));
            stmt.setInt(2, Integer.parseInt(itemnum));
            stmt.setInt(3, Integer.parseInt(oq));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return 0;
            }
        } catch (SQLException ex) {
            System.out.println("in orderitem " + ex.getLocalizedMessage());
        }
        return -1;
    }

    /**
     * returns paymentid
     *
     * @param custid
     * @param total
     * @param ptype
     * @return
     */
    public int InsertPaymentMethod(String custid, String total, String ptype, int orderid) {
        int payId = -1;
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO paymentmethod (customerIdm, totalAmount, paymentType, ordernumber) VALUES (?,?,?, ?)", Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, Integer.parseInt(custid));
            stmt.setDouble(2, Double.parseDouble(total));
            stmt.setString(3, ptype);
            stmt.setInt(4, orderid);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {

                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        payId = (generatedKeys.getInt(1));
                        return payId;
                    } else {
                        return -1;
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println("ininsert " + ex.getLocalizedMessage());
        }
        return -1;
    }

    public UserInfo GetUserInfo(int id) {
        UserInfo ui = new UserInfo();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from customer where CustomerId =?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                ui.setFirstName(rs.getString("FirstName"));
                ui.setLastName(rs.getString("LastName"));
                ui.setPhoneNumber(rs.getLong("phoneNumber"));
            }
        } catch (SQLException e) {
            System.out.println("in getuserinfo " + e.getLocalizedMessage());
        }

        return ui;
    }

    public Address[] getAddresses(int id) {
        ArrayList<Address> ad;
        ad = new ArrayList();
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from addresstable where custid =?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Address e = new Address();
                //System.out.println(rs.getInt("addressid"));
                e.setId(rs.getInt(1));
                e.setStreet(rs.getString(3));
                e.setZip(rs.getInt(4));
                e.setCity(rs.getString(5));
                e.setState(rs.getString(6));
                if (rs.getInt(7) == 1) {
                    ad.add(e);
                }
            }
            Address[] arr = ad.toArray(new Address[ad.size()]);
            return arr;

        } catch (SQLException ex) {
            System.out.println("in getadd" + ex.getLocalizedMessage());
        }
        return null;
    }

    public ResultSet OrderNumberView(int id) {

        try {
            ResultSet rs;
            PreparedStatement stmt = connection.prepareStatement("select * from ordernumberview where customerid =?");
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {
            ex.getLocalizedMessage();
            return null;
        }
    }

    public int IsSoldOut(int id) {
        try {
            PreparedStatement stmt = connection.prepareStatement("select * from items where itemid =?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt("quantity");
        } catch (SQLException ex) {
            ex.getLocalizedMessage();
            return -1;
        }
    }
}
