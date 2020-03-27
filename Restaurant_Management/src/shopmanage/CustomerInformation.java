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
public class CustomerInformation {

    //Declare variables
    private int cid;
    private String cname;
    private String cphone;
    private String cemail;

    /**
     * Get customer ID
     *
     * @return
     */
    public int getCid() {
        return cid;
    }

    /**
     * Set customer ID
     *
     * @param cid
     * @throws CustomerException
     */
    public void setCid(int cid) throws CustomerException {
        //check
        if (cid < 0) {//invalid 
            throw new CustomerException("ID must be greater than 0.");//display warning message
        } else {//valid
            this.cid = cid;
        }
    }

    /**
     * Get customer name
     *
     * @return
     */
    public String getCname() {
        return cname;
    }

    /**
     * Set customer name
     *
     * @param cname
     * @throws CustomerException
     */
    public void setCname(String cname) throws CustomerException {
        //check
        if (cname.equals("")) {//invalid
            throw new CustomerException("Name can't be empty.");//display warning message
        } else {//valid
            this.cname = cname;
        }
    }

    /**
     * Get customer phone
     *
     * @return
     */
    public String getCphone() {
        return cphone;
    }

    /**
     * Set customer phone
     *
     * @param cphone
     * @throws CustomerException
     */
    public void setCphone(String cphone) throws CustomerException {
        //check
        if (cphone.equals("")) {//invalid
            throw new CustomerException("Phone can't be empty.");//display warning message
        } else {//valid
            this.cphone = cphone;
        }
    }

    /**
     * Get customer email
     *
     * @return
     */
    public String getCemail() {
        return cemail;
    }

    /**
     * Set customer email
     *
     * @param cemail
     * @throws CustomerException
     */
    public void setCemail(String cemail) throws CustomerException {
        //check
        if (cemail.equals("")) {//invalid
            throw new CustomerException("Email can't be empty.");//display warning message
        } else {//valid
            this.cemail = cemail;
        }
    }

    /**
     * Constructor
     *
     * @param cid
     * @param cname
     * @param cphone
     * @param cemail
     */
    public CustomerInformation(int cid, String cname, String cphone, String cemail) {
        this.cid = cid;
        this.cname = cname;
        this.cphone = cphone;
        this.cemail = cemail;
    }

}
