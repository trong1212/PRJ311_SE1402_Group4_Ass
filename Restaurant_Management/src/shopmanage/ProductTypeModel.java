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
public class ProductTypeModel {

    //declare variables
    private Connection con;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<ProductTypeInformation> protypes;
    private String str;

    /**
     * constructor no parameter
     *
     * @throws SQLException
     */
    public ProductTypeModel() throws SQLException {
        try {
            con = null;
            st = null;
            ps = null;
            rs = null;
            str = "";
            protypes = new ArrayList<>();
            con = ConnectionLib.getConnection();
            st = con.createStatement();
        } catch (SQLException e) {
            System.out.println("Can't connection database.");//display warning message
        } catch (Exception e) {
            System.out.println("Can't connection database.");//display warning message
        }
    }

    /**
     * load product type
     *
     * @return
     */
    public ArrayList<ProductTypeInformation> loadProductType() {
        str = "SELECT * FROM `producttype` WHERE 1";//query load data
        try {
            rs = st.executeQuery(str);
            while (rs.next()) {
                int ptid = rs.getInt("ptid");
                String ptname = rs.getString("ptname");
                protypes.add(new ProductTypeInformation(ptid, ptname));//add data to arraylist                
            }
        } catch (SQLException ex) {
            System.out.println("Can't load data product type.");//display warning message          
        }
        return protypes;

    }

    /**
     * insert product type
     *
     * @param ptid
     * @param ptname
     * @return
     */
    public boolean insertProductType(int ptid, String ptname) {
        str = "INSERT INTO `producttype`(`ptid`, `ptname`) VALUES (?,?)";//query insert data
        try {
            ps = con.prepareStatement(str, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ptid);
            ps.setString(2, ptname);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't insert data.");//display warning message
            return false;
        }
    }

    public String findProductName(int ptypeid) {
        String a="";
        for (int i = 0; i < protypes.size(); i++) {
            if (ptypeid == protypes.get(i).getPtid()) {
                a= protypes.get(i).getPtname();
            }
        }
        return a;
    }
    public int findIndexProduct(String str){
        int a=0;
        for (int i = 0; i < protypes.size(); i++) {
            if(str.toLowerCase().trim().equals(protypes.get(i).getPtname().toLowerCase().trim())){
                a = protypes.get(i).getPtid();
            }
        }
        return a;
    }
}
