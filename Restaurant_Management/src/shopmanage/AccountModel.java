/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

import DBIList.ConnectionLib;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class AccountModel {

    //Declare variables
    private Connection con;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    ArrayList<AccountInformation> accounts;

    /**
     * Constructor no parameter
     *
     * @throws SQLException
     */
    public AccountModel() throws SQLException {
        con = null;
        ps = null;
        st = null;
        rs = null;
        accounts = new ArrayList<>();//create new list account
        con = ConnectionLib.getConnection();//connection with sql Server
        st = con.createStatement();
    }

    /**
     * load data of store account from sql server to ArrayList
     *
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<AccountInformation> loadAccount() throws SQLException {
        accounts = new ArrayList<>();//create new store of account
        query = "SELECT * FROM `account`";//query select
        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {//check
                while (rs.next()) {
                    int aid = rs.getInt("aid");//get account id
                    String aname = rs.getString("aname");//get account name
                    String apass = rs.getString("apass");//get account password
                    String atype = rs.getString("atype");//get account type
                    accounts.add(new AccountInformation(aid, aname, apass, atype));//add 1 account to array list
                }
            }
        } catch (SQLException ex) {
            System.out.println("Can't load data of list account");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load data of list account.");//display warning message
        }

        return accounts;
    }

    /**
     * insert account to list
     *
     * @param aname
     * @param apass
     * @param atype
     * @return
     * @throws SQLException
     */
    public int insertAccount(String aname, String apass, String atype) throws SQLException {
        query = "INSERT INTO `account`(`aname`, `apass`, `atype`) VALUES (?,?,?)";//query insert
        int id = accounts.get(accounts.size() - 1).getAid() + 1;//get id of account
        try {
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create prepare statement

            ps.setString(1, aname);//set account name
            ps.setString(2, apass);//set account password 
            ps.setString(3, atype);//set account type
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();//
        } catch (SQLException ex) {
            System.out.println("Can't insert account to list.");//display warning message
        } catch (Exception e) {
            System.out.println("can't insert account to list.");//display warning message
        }

        return id = rs.getInt(1);
    }

    /**
     * update account
     *
     * @param aid
     * @param aname
     * @param apass
     * @param atype
     * @return
     */
    public boolean updateAccount(int aid, String aname, String apass, String atype) {

        query = "UPDATE `account` SET `aid`=?,`aname`=?,`apass`=?,`atype`=? WHERE 1";//query update
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, aname);//set account name
            ps.setString(2, apass);//set account password
            ps.setString(3, atype);//set account type
            ps.setInt(4, aid);//set account id
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update account.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update account.");//display warning message
            return false;
        }

    }

    /**
     * delete account
     *
     * @param aid
     * @return
     */
    public boolean deleteAccount(int aid) {
        query = "DELETE FROM `account` WHERE aid=?";//query delete
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, aid);//set account id 
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete account.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete account");//display warning message
            return false;
        }
    }

    /**
     * find account
     *
     * @param aid
     * @return
     */
    public ArrayList<AccountInformation> findAccount(int aid) {
        ArrayList<AccountInformation> acc = new ArrayList<>();//create new list account
        for (int i = 0; i < accounts.size(); i++) {
            if (i == aid) {
                acc.add(new AccountInformation(accounts.get(i).getAid(), accounts.get(i).getAname(),
                        accounts.get(i).getApassword(), accounts.get(i).getAtype())); //add account to new list
            }
        }
        return acc;
    }

    /**
     * check username
     *
     * @param user
     * @return
     */
    public int checkUser(String user) {
        int i;
        for (i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAname().trim().toLowerCase().equals(user.trim().toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * check password
     *
     * @param user
     * @param pass
     * @return
     */
    public boolean checkPass(String user, String pass) {
        int n = checkUser(user);//check username
        if (n >= 0) {
            if (accounts.get(n).getApassword().trim().toLowerCase().equals(pass.trim().toLowerCase())) {
                return true;
            }
        }
        return false;

    }

    /**
     * Check name
     *
     * @param name
     * @return
     */
    public boolean checkName(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAname().trim().toLowerCase().equals(name.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
