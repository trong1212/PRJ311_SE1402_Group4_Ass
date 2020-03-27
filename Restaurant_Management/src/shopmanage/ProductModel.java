/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

import DBIList.ConnectionLib;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class ProductModel {

    //declare variables
    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;
    private String query;
    private ArrayList<ProductInformation> products;

    private Statement st;

    public ProductModel() throws SQLException {
        con = null;
        rs = null;
        ps = null;
        st = null;
        con = ConnectionLib.getConnection();//connection with sql server
        st = con.createStatement();
        // mở lại cái hồi sớm đi, cái tui đang làm ă
        products = new ArrayList<>();//create new list products
    }

    /**
     * load products
     *
     * @return
     */
    public ArrayList<ProductInformation> loadProduct() throws SQLException, Exception {
        try {
            products = new ArrayList<>();//create new list product
            query = "SELECT * FROM `product`";//query select product
            rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("pid");//get product id
                String name = rs.getString("pname");//get product name
                int type = rs.getInt("ptype");//get product type
                int price = rs.getInt("pprice");//get product price
                String size = rs.getString("psize");//get size
                int brand = rs.getInt("pbrand");//get brand
                products.add(new ProductInformation(id, name, type, price, size, brand));//add 1 product to list products
            } 

        } catch (SQLException e) {
            System.out.println("Can't load product.");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load product.");//display warning message
        }
        return products;
    }

    /**
     * insert products
     *
     * @param pname
     * @param ptype
     * @param price
     * @param size
     * @param brand
     * @return
     * @throws SQLException
     */
    public int insertProduct(String pname, int price, String size, int ptype, int brand) throws SQLException, Exception {
        query = "INSERT INTO `product`(`pname`, `ptype`, `pprice`, `psize`, `pbrand`) VALUES (?,?,?,?,?)";//query insert product 
        try {
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//create prepare statement
            int id = products.get(products.size() - 1).getPid() + 1;//get ID
            ps.setString(1, pname);//set product name 
            ps.setInt(2, ptype);//set product type
            ps.setInt(3, price);//set price
            ps.setString(4, size);//set size
            ps.setInt(5, brand);//set brand
            ps.executeUpdate();
            rs = ps.getGeneratedKeys();//generated key
            rs.next();
            return id = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("Can't insert product.");//display warning message
            return -1;
        } catch (Exception e) {
            System.out.println("Can't insert product.");//display warning message
            return -1;
        }
    }

    /**
     * update product
     *
     * @param pid
     * @param pname
     * @param ptype
     * @param price
     * @param size
     * @param brand
     * @return
     * @throws SQLException
     */
    public boolean updateProduct(int pid, String pname, int ptype, int price, String size, int brand) throws SQLException, Exception {
        query = "UPDATE `product` SET `pname`=?, `ptype`=?, `pprice`=?, `psize`=?, `pbrand`=? WHERE `pid`=? ";//query update 
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, pname);//set product name
            ps.setInt(2, ptype);//set product type
            ps.setInt(3, price);//set price
            ps.setString(4, size);//set size
            ps.setInt(5, brand);//set brand
            ps.setInt(6, pid);//set product ID
            
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't update product.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update product.");//display warning message
            return false;
        }
    }

    /**
     * delete product
     *
     * @param pid
     * @return
     */
    public boolean deleteProduct(int pid) throws SQLException, Exception {
        query = "DELETE FROM `product` WHERE `pid`=?";//query delete
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pid);//set ID
            ps.execute();
            return true;
        } catch (SQLException ex) {
            System.out.println("Can't delete product.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete product");//display warning message
            return false;
        }
    }

    /**
     * find product
     *
     * @param pid
     * @return
     */
    public ArrayList<ProductInformation> findProduct(int pid) {
        ArrayList<ProductInformation> pro = new ArrayList<>();//create new list products
        for (int i = 0; i < products.size(); i++) {
            if (i == pid) {
                pro.add(new ProductInformation(products.get(i).getPid(), products.get(i).getPname(), products.get(i).getPtype(),
                        products.get(i).getPrice(), products.get(i).getSize(), products.get(i).getBrand()));//add product you want find to new list
            }
        }
        return pro;
    }

    /**
     * check name product
     *
     * @param name
     * @return
     */
    public boolean checkName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getPname().trim().toLowerCase().equals(name.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    public void insertProduct(String name, int price, String size, int t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
