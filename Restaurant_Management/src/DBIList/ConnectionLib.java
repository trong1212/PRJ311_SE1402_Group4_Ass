/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBIList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author
 */
public class ConnectionLib {

    private static final String URL = "jdbc:mysql://localhost:3306/shop_manage";
    private static final String USER = "root";
    private static final String PASS = "";
    private static Connection con = null;

    public static Connection getConnection() throws SQLException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        con = (Connection) DriverManager.getConnection(URL, USER, PASS);
        return con;
    }

    public boolean isConnected() {
        return this.con != null;
    }

    public void closeConnection() throws SQLException {
        this.con.close();
    }

}
