/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopmanage;

import java.sql.Date;

/**
 *
 * @author DELL
 */
public class BillInformation {

    //declare variables
    private int bId;//bill ID
    private Date date;//date 
    private int eId;//employee ID
    private int cid;//customer ID

    /**
     * get bill ID
     *
     * @return
     */
    public int getbId() {
        return bId;
    }

    /**
     * Set bill ID
     *
     * @param bId
     * @throws BillException
     */
    public void setbId(int bId) throws BillException {
        if (bId < 0) {
            throw new BillException("Bill ID must be greater than 0.");//display warning message
        } else {
            this.bId = bId;
        }
    }

    /**
     * Set Date
     *
     * @return
     */
    public Date getDate() {
        return date;
    }

    /**
     * Get Date
     *
     * @param date
     * @throws BillException
     */
    public void setDate(Date date) throws BillException {
        if (date.equals("")) {
            throw new BillException("Date can't be empty.");//display warning message
        } else {
            this.date = date;
        }

    }

    /**
     * Get employee
     *
     * @return
     */
    public int geteId() {
        return eId;
    }

    /**
     * Set employee
     *
     * @param eId
     * @throws BillException
     */
    public void seteId(int eId) throws BillException {
        if (eId < 0) {
            throw new BillException("Employee ID must be greater than 0.");//display warning message
        } else {
            this.eId = eId;
        }

    }

    /**
     * get customer
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
     * @throws BillException
     */
    public void setCid(int cid) throws BillException {
        if (cid < 0) {
            throw new BillException("Customer ID must be greater than 0.");//display warning message
        } else {
            this.cid = cid;
        }

    }

    /**
     * constructor have 4 parameter
     *
     * @param bId
     * @param date
     * @param eId
     * @param cid
     */
    public BillInformation(int bId, Date date, int eId, int cid) {
        this.bId = bId;
        this.date = date;
        this.eId = eId;
        this.cid = cid;
    }

}
