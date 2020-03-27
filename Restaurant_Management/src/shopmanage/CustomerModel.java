/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

import DBIList.ConnectionLib;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DELL
 */
public class CustomerModel {

    //Declare variavles
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    ArrayList<CustomerInformation> customers;
    private String query;

    /**
     * constructor no parameter
     *
     * @throws Exception
     * @throws SQLException
     */
    public CustomerModel() throws Exception, SQLException {
        con = null;
        ps = null;
        rs = null;
        st = null;
        customers = new ArrayList<>();//create new list customer
        con = ConnectionLib.getConnection();//connection with sql server
        st = con.createStatement();//create statement
    }

    /**
     * load customer
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public ArrayList<CustomerInformation> loadCustomer() throws Exception, SQLException {
        customers = new ArrayList<>();//create new list customer
        query = "SELECT * FROM `customer` WHERE 1";//query select customer
        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {//check
                while (rs.next()) {
                    int cid = rs.getInt("cid");//get customer id
                    String cname = rs.getString("cname");//get customer name
                    String cphone = rs.getString("cphone");//get customer phone
                    String cemail = rs.getString("cemail");//get customer email
                    customers.add(new CustomerInformation(cid, cname, cphone, cemail));//add new customer to list
                }
            }
        } catch (SQLException e) {
            System.out.println("Can't load list customer.");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load list customer.");//display warning message
        }
        return customers;
    }

    /**
     * insert customer
     *
     * @param cname
     * @param cphone
     * @param cemail
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public int insertCustomer(String cname, String cphone, String cemail) throws Exception, SQLException {
        query = "INSERT INTO `customer`(`cname`, `cphone`, `cemail`) VALUES (?,?,?)";//query insert customer
        int id = customers.get(customers.size() - 1).getCid() + 1;//get id customer
        try {
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create perpare statement

            ps.setString(1, cname);//set customer name
            ps.setString(2, cphone);//set customer phone
            ps.setString(3, cemail);//set customer email
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();

        } catch (SQLException e) {
            System.out.println("Can't insert customer.");//display warning message
        } catch (Exception e) {
            System.out.println("Can't insert customer.");//display warning message
        }
        return id = rs.getInt(1);
    }

    /**
     * update customer
     *
     * @param cid
     * @param cname
     * @param cphone
     * @param cemail
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public boolean updateCustomer(int cid, String cname, String cphone, String cemail) throws Exception, SQLException {
        boolean check = true;
        query = "UPDATE `customer` SET `cname`=?,`cphone`=?,`cemail`=? WHERE `cid`=?";//query update customer
        try {
            ps = con.prepareStatement(query);//create prepare statement
            ps.setString(1, cname);//set customer name
            ps.setString(2, cphone);//set customer phone
            ps.setString(3, cemail);//set customer email
            ps.setInt(4, cid);//set customer ID
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update customer.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update customer.");//display warning message
            return false;
        }

    }

    /**
     * delete customer
     *
     * @param cid
     * @return
     */
    public boolean deleteCustomer(int cid) {
        query = "DELETE FROM `customer` WHERE `cid`=?";//query delete customer
        try {
            ps = con.prepareStatement(query);//create prepare statement
            ps.setInt(1, cid);//set customer ID
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete customer.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete customer.");//display warning message
            return false;
        }
    }

    /**
     * find customer
     *
     * @param cid
     * @return
     */
    public ArrayList<CustomerInformation> findCustomer(int cid) {
        ArrayList<CustomerInformation> cus = new ArrayList<>();//create new list customer
        for (int i = 0; i < customers.size(); i++) {
            if (i == cid) {
                cus.add(new CustomerInformation(customers.get(i).getCid(), customers.get(i).getCname(),
                        customers.get(i).getCphone(), customers.get(i).getCemail()));//add customer you want to find to new list
            }
        }
        return cus;
    }

    /**
     * check phone
     *
     * @param phone
     * @return
     */
    public boolean checkPhone(String phone) {
        String regex = "([0]\\d{9})";//regex check phone
        Pattern pt = Pattern.compile(regex);
        Matcher mc = pt.matcher(phone);
        if (mc.matches()) {
            return true;
        }
        return false;
    }

    /**
     * check email
     *
     * @param email
     * @return
     */
    public boolean checkEmail(String email) {
        String regex = "\\w+@\\w+[.]\\w+||\\w+@\\w+[.]\\w+[.]\\w+";//regex check email
        Pattern pt = Pattern.compile(regex);
        Matcher mc = pt.matcher(email);
        if (mc.matches()) {
            return true;
        }
        return false;
    }

    /**
     * check Name
     *
     * @param name
     * @return
     */
    public boolean checkName(String name) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCname().trim().toLowerCase().equals(name.trim().toLowerCase())) {//check name 
                return true;
            }
        }
        return false;
    }
}
