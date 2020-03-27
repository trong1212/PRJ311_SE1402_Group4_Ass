/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

import DBIList.ConnectionLib;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
public class BillDetailModel {

    //declare variables
    private Connection con;
    private PreparedStatement ps;
    private Statement st;
    private ResultSet rs;
    private String query;
    ArrayList<BillDetailInformation> billdetails;

    public BillDetailModel() throws SQLException {
        con = null;
        ps = null;
        st = null;
        rs = null;
        billdetails = new ArrayList<>();//create new list billdetail
        con = ConnectionLib.getConnection();//connection with sql server
        st = con.createStatement();//create statement
    }

    /**
     * load BillDetail
     *
     * @return
     */
    public ArrayList<BillDetailInformation> loadBillDetail() {
        billdetails = new ArrayList<>();//create new billdetails list
        query = "SELECT * FROM `billdetail` WHERE 1";//query select billdetail
        try {
            rs = st.executeQuery(query);
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int bdid = rs.getInt("bdid");//get billdetail id
                    int pid = rs.getInt("pid");//get product id
                    int price = rs.getInt("price");//get price
                    int amount = rs.getInt("amount");//get amount
                    String note = rs.getString("note");//get note
                    int bid = rs.getInt("bid");//get bill id
                    billdetails.add(new BillDetailInformation(bdid, pid, price, amount, note, bid));//add billdetail to list
                }
            }
        } catch (SQLException ex) {
            System.out.println("Can't load BillDetail.");//display waring message
        } catch (Exception e) {
            System.out.println("can't load BillDetail.");//display warning message
        }
        return billdetails;
    }

    /**
     * *
     * insert BillDetail
     *
     * @param bid
     * @param pid
     * @param price
     * @param amount
     * @param note
     * @return
     * @throws SQLException
     */
    public boolean insertBillDetail(int pid, int price, int amount, String note, int bid) throws SQLException {
        query = "INSERT INTO `billdetail`(`pid`, `price`, `amount`, `note`, `bid`) VALUES (?,?,?,?,?)";//query insert billdetail
        try {

            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pid);//set product ID
            ps.setInt(2, price);//set price
            ps.setInt(3, amount);//set amount
            ps.setString(4, note);//set note
            ps.setInt(5, bid);//set bill ID
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't insert BillDetail.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't insert BillDetail.");//display warning message
            return false;
        }

    }

    /**
     * update BillDetail
     *
     * @param bdid
     * @param bid
     * @param pid
     * @param price
     * @param amount
     * @param note
     * @return
     */
    public boolean updateBillDetail(int bdid, int bid, int pid, int price, int amount, String note) {

        query = "update `billdetail` set `bid`=?, `pid`=?, `price`=?, `amount`=?, `note`=? where `bdid`=?";//query update BillDetail
        try {
            ps = con.prepareStatement(query);//create prepare statement
            ps.setInt(1, bid);//set bill ID
            ps.setInt(2, pid);//set product ID
            ps.setInt(3, price);//set price 
            ps.setInt(4, amount);//set amount
            ps.setString(5, note);//set note
            ps.setInt(6, bdid);//set billdetail ID
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update bill detail.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update bill detail.");//display warning message
            return false;
        }
    }

    /**
     * Delete billDetail
     *
     * @param bdid
     * @return
     */
    public boolean deleteBillDetail(int bdid) {
        query = "DELETE FROM `billdetail` WHERE `bdid`=?";//query delete billdetail
        try {
            ps = con.prepareStatement(query);//create prepare statement
            ps.setInt(1, bdid);//set billdetail ID
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete bill detail.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete bill detail.");//display warning message
            return false;
        }

    }

}
