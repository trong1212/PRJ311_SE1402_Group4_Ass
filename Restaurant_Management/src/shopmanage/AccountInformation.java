/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

/**
 *
 * @author DELL
 */
public class AccountInformation {
    //declare variables

    private int aid;//account id
    private String aname;//account name
    private String apassword;//account password
    private String atype;//account type

    /**
     * get Account ID
     *
     * @return
     */
    public int getAid() {
        return aid;
    }

    /**
     * Set Account ID
     *
     * @param aid
     * @throws AccountException
     */
    public void setAid(int aid) throws AccountException {
        if (aid < 0) {
            throw new AccountException("Account ID must be greater than 0.");//display warning message
        } else {
            this.aid = aid;
        }

    }

    /**
     * get Account Name
     *
     * @return
     */
    public String getAname() {
        return aname;
    }

    /**
     * Set Account Name
     *
     * @param aname
     * @throws AccountException
     */
    public void setAname(String aname) throws AccountException {
        if (aname.equals("")) {
            throw new AccountException("Account name can't be empty.");//display warning message
        } else {
            this.aname = aname;
        }

    }

    /**
     * Get Password
     *
     * @return
     */
    public String getApassword() {
        return apassword;
    }

    /**
     * Set Password
     *
     * @param apassword
     * @throws AccountException
     */
    public void setApassword(String apassword) throws AccountException {
        if (apassword.equals("")) {
            throw new AccountException("Password can't be empty.");//display warning message
        } else {
            this.apassword = apassword;
        }

    }

    /**
     * Get Account Type
     *
     * @return
     */
    public String getAtype() {
        return atype;
    }

    /**
     * Set Account Type
     *
     * @param atype
     * @throws AccountException
     */
    public void setAtype(String atype) throws AccountException {
        if (atype.equals("")) {
            throw new AccountException("Account type can't be empty.");//display warning message
        } else {
            this.atype = atype;
        }

    }

    /**
     * constructor have 4 parameter
     *
     * @param aid
     * @param aname
     * @param apassword
     * @param atype
     */
    public AccountInformation(int aid, String aname, String apassword, String atype) {
        this.aid = aid;
        this.aname = aname;
        this.apassword = apassword;
        this.atype = atype;
    }

}
