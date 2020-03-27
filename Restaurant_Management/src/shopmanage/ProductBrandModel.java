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

/**
 *
 * @author DELL
 */
public class ProductBrandModel {
        //declare variables
    private Connection con;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private ArrayList<ProductBrandInformation> probrands;
    private String str;

    /**
     * constructor no parameter
     *
     * @throws SQLException
     */
    public ProductBrandModel() throws SQLException {
        try {
            con = null;
            st = null;
            ps = null;
            rs = null;
            str = "";
            probrands = new ArrayList<>();
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
    public ArrayList<ProductBrandInformation> loadProductBrand() {
        str = "SELECT * FROM `productbrand` WHERE 1";//query load data
        try {
            rs = st.executeQuery(str);
            while (rs.next()) {
                int pbid = rs.getInt("pbid");
                String pbname = rs.getString("pbname");
                probrands.add(new ProductBrandInformation(pbid, pbname));//add data to arraylist                
            }
        } catch (SQLException ex) {
            System.out.println("Can't load data product type.");//display warning message          
        }
        return probrands;

    }

    /**
     * insert product type
     *
     * @param ptid
     * @param ptname
     * @return
     */
    public boolean insertProductBrand(int pbid, String pbname) {
        str = "INSERT INTO `productbrand`(`pbid`, `pbname`) VALUES (?,?)";//query insert data
        try {
            ps = con.prepareStatement(str, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pbid);
            ps.setString(2, pbname);
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();
            rs.next();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't insert data.");//display warning message
            return false;
        }
    }

    public String findProductName(int pbrandid) {
        String a="";
        for (int i = 0; i < probrands.size(); i++) {
            if (pbrandid == probrands.get(i).getPbid()) {
                a= probrands.get(i).getPbname();
            }
        }
        return a;
    }
    public int findIndexProductByBrand(String str){
        int a=0;
        for (int i = 0; i < probrands.size(); i++) {
            if(str.toLowerCase().trim().equals(probrands.get(i).getPbname().toLowerCase().trim())){
                a = probrands.get(i).getPbid();
            }
        }
        return a;
    }
}
