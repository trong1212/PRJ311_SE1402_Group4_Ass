/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

import DBIList.ConnectionLib;
import java.sql.Connection;
import java.util.Date;
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
public class BillModel {

    //declare variables
    private Connection con;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    ArrayList<BillInformation> bills;

    /**
     * constructor no parameter
     *
     * @throws SQLException
     */
    public BillModel() throws SQLException {
        con = null;
        ps = null;
        st = null;
        rs = null;
        bills = new ArrayList<>();//create new list bills
        con = ConnectionLib.getConnection();//connection sql server
        st = con.createStatement();
    }

    /**
     * load bill
     *
     * @return
     */
    public ArrayList<BillInformation> loadBill() {
        bills = new ArrayList<>();
        query = "select * from `bill` ";//query select bill
        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int bid = rs.getInt("bid");//get bill ID
                    Date date = rs.getDate("date");//get bill Date
                    int eid = rs.getInt("eid");//get employee ID
                    int cid = rs.getInt("cid");//get customer ID
                    bills.add(new BillInformation(bid, (java.sql.Date) date, eid, cid));//add bill to list bills
                }
            }
        } catch (SQLException ex) {
            System.out.println("Can't load bill.");//display waring message
        } catch (Exception e) {
            System.out.println("Can't load bill.");//display warning message
        }
        return bills;
    }

    /**
     * insert Bill
     *
     * @param date
     * @param eid
     * @param cid
     * @return
     * @throws SQLException
     */
    public int insertBill(Date date, int eid, int cid) throws SQLException {
        query = "insert into `bill`(`date`,`eid`,`cid`) VALUES(?,?,?)";//query insert bill
        int id = bills.get(bills.size() - 1).getbId() + 1;//get ID
        try {
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create prepare statement
            ps.setDate(1, (java.sql.Date) date);//set Date
            ps.setInt(2, eid);//set employee ID
            ps.setInt(3, cid);//set customer ID
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException ex) {
            System.out.println("Can't insert bill.");//display warning message
        } catch (Exception e) {
            System.out.println("Can't insert bill.");//display waring message
        }
        return id = rs.getInt(1);
    }

    /**
     * update Bill
     *
     * @param bid
     * @param date
     * @param eid
     * @param cid
     * @return
     */
    public boolean updateBill(int bid, Date date, int eid, int cid) {

        query = "update `bill` set `date`=?, `eid`=?, `cid`=? where `bid`=?";//query update bill
        try {
            ps = con.prepareStatement(query);//create prepare statement 
            ps.setDate(1, (java.sql.Date) date);//set Date
            ps.setInt(2, eid);//set employee ID
            ps.setInt(3, cid);//set customer ID
            ps.setInt(4, bid);//set bill ID
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update bill.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update bill.");//display warning message
            return false;
        }
    }

    /**
     * delete Bill
     *
     * @param bid
     * @return
     */
    public boolean deletebBill(int bid) {
        query = "DELETE FROM `bill` WHERE `bid`=?";//query delete bill
        try {
            ps = con.prepareStatement(query);//create prepare statement
            ps.setInt(1, bid);//set ID
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete bill.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete bill");//display warning message
            return false;
        }
    }

    /**
     * find bill
     *
     * @param bid
     * @return
     */
    public ArrayList<BillInformation> findBill(int bid) {
        ArrayList<BillInformation> bill = new ArrayList<>();//create new list bills
        for (int i = 0; i < bills.size(); i++) {
            if (i == bid) {
                bill.add(new BillInformation(bills.get(i).getbId(), bills.get(i).getDate(),
                        bills.get(i).geteId(), bills.get(i).getCid()));//add bill you want find to new list
            }
        }
        return bill;
    }
}
