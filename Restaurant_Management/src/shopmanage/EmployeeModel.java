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
public class EmployeeModel {

    //Declare variables
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    private Statement st;
    ArrayList<EmployeeInformation> employees;//create new list employee information
    private String query;
    ArrayList<AccountInformation> ai = new ArrayList<>();//create new list account information

    /**
     * Create model
     *
     * @throws Exception
     * @throws SQLException
     */
    public EmployeeModel() throws Exception, SQLException {
        con = null;
        ps = null;
        rs = null;
        st = null;
        employees = new ArrayList<>();
        con = ConnectionLib.getConnection();//connection with sql server
        st = con.createStatement();
    }

    /**
     * Load information of employee
     *
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public ArrayList<EmployeeInformation> loadEmployee() throws Exception, SQLException {
        //load on SQL sever
        employees = new ArrayList<>();//create new array list
        query = "SELECT * FROM `employee`";//query load employee
        try {
            rs = st.executeQuery(query);//excute query
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    int eid = rs.getInt("eid");//get employee id
                    int aid = rs.getInt("aid");//get account id
                    String ename = rs.getString("ename");//get employee name
                    String ephone = rs.getString("ephone");//get employee phone
                    String eemail = rs.getString("eemail");//get employee email
                    String etype = rs.getString("etype");//get employee type
                    employees.add(new EmployeeInformation(eid, aid, ename, ephone, eemail, etype));//add information
                }
            }
            //exception
        } catch (SQLException e) {
            System.out.println("Can't load employee.");//display warning message
        } catch (Exception e) {
            System.out.println("Can't load employee.");//display warning message
        }
        return employees;
    }

    /**
     * Insert new employee
     *
     * @param aid
     * @param ename
     * @param ephone
     * @param eemail
     * @param etype
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public boolean insertEmployee(String ename, String ephone, String eemail, String etype) throws Exception, SQLException {
        //add into SQL sever
        query = "INSERT INTO `employee`(`aid`, `ename`, `ephone`, `eemail`, `etype`) VALUES (?,?,?,?,?)";//SQL sever command
        int id2 = employees.get(employees.size() - 1).getEid() + 1;//get id account
        try {
            ps = con.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);//prepare statement
            //all information of employee

            ps.setInt(1, id2);//set id account
            ps.setString(2, ename);//set employee name
            ps.setString(3, ephone);//set employee phone
            ps.setString(4, eemail);//set employee email
            ps.setString(5, etype);//set employee type
            ps.executeUpdate();//update
            rs = ps.getGeneratedKeys();
            rs.next();
            return true;
            //exception
        } catch (SQLException e) {
            System.out.println("Can't insert employee.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't insert employee.");//display warning message
            return false;
        }

    }

    /**
     * Update information of employee
     *
     * @param eid
     * @param aid
     * @param ename
     * @param ephone
     * @param eemail
     * @param etype
     * @return
     * @throws Exception
     * @throws SQLException
     */
    public boolean updateEmployee(int eid, int aid, String ename, String ephone, String eemail, String etype) throws Exception, SQLException {
        boolean check = true;
        //update in SQL sever
        query = "UPDATE `employee` SET `ename`=?,`ephone`=?,`eemail`=?,`etype`=? WHERE `eid`=?";//SQL sever command
        try {
            ps = con.prepareStatement(query);//prepare statement
            //all information of employee

            ps.setString(1, ename);//set employee name
            ps.setString(2, ephone);//set employee phone
            ps.setString(3, eemail);//set employee email
            ps.setString(4, etype);//set employee type
            ps.setInt(5, eid);//set employee ID
            ps.executeUpdate();//update
            return true;
            //exception
        } catch (SQLException ex) {
            System.out.println("Can't update employee.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't update employee.");//display warning message
            return false;
        }

    }

    /**
     * Delete employee
     *
     * @param eid
     * @return
     */
    public boolean deleteEmployee(int eid) {
        query = "DELETE FROM `employee` WHERE `eid`=?";//SQL Sever command
        try {
            ps = con.prepareStatement(query);//prepare statement
            ps.setInt(1, eid);//delete by ID
            ps.executeUpdate();//update
            return true;
            //exception
        } catch (SQLException ex) {
            System.out.println("Can't delete employee.");//display warning message
            return false;
        } catch (Exception e) {
            System.out.println("Can't delete employee.");//display warning message
            return false;
        }
    }

    /**
     * Find Employee by ID
     *
     * @param id
     * @return
     */
    public ArrayList<EmployeeInformation> findID(int eid) {
        ArrayList<EmployeeInformation> employee = new ArrayList<>();
        for (int i = 0; i < employees.size(); i++) {
            if (i == eid) {//check employee ID
                employee.add(new EmployeeInformation(employees.get(i).getEid(), employees.get(i).getAid(),
                        employees.get(i).geteName(), employees.get(i).getePhone(),
                        employees.get(i).geteEmail(), employees.get(i).geteType()));//add employee to new list
            }
        }
        return employee;
    }

    /**
     * Check phone
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
     * check Email
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
     * check name
     *
     * @param name
     * @return
     */
    public boolean checkName(String name) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).geteName().trim().toLowerCase().equals(name.trim().toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
