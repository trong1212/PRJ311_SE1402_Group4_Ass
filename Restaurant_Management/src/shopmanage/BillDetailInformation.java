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
public class BillDetailInformation {

    //declare variables
    private int bdId;
    private int pId;
    private int price;
    private int amount;
    private String note;
    private int bid;

    /**
     * set Bill ID
     *
     * @return
     */
    public int getBid() {
        return bid;
    }

    /**
     * set Bill ID
     *
     * @param bid
     * @throws BillDetailException
     */
    public void setBid(int bid) throws BillDetailException {
        if (bid < 0) {
            throw new BillDetailException("Bill Detail must be greater than 0.");
        } else {
            this.bid = bid;
        }

    }

    /**
     * get BillDetail ID
     *
     * @return
     */
    public int getBdId() {
        return bdId;
    }

    /**
     * Set billDetail ID
     *
     * @param bdId
     * @throws BillDetailException
     */
    public void setBdId(int bdId) throws BillDetailException {
        if (bdId < 0) {
            throw new BillDetailException("Bill Detail Id must be greater than 0.");
        } else {
            this.bdId = bdId;
        }

    }

    /**
     * get bill ID
     *
     * @return
     *
     *
     * /**
     * get Product ID
     *
     * @return
     */
    public int getpId() {
        return pId;
    }

    /**
     * set Product ID
     *
     * @param pId
     * @throws BillDetailException
     */
    public void setpId(int pId) throws BillDetailException {
        if (pId < 0) {
            throw new BillDetailException("Product ID must be greater than 0.");
        } else {
            this.pId = pId;
        }

    }

    /**
     * Get price
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set price
     *
     * @param price
     * @throws BillDetailException
     */
    public void setPrice(int price) throws BillDetailException {
        if (price < 0) {
            throw new BillDetailException("Price must be greater than 0.");
        } else {
            this.price = price;
        }

    }

    /**
     * Get Amount
     *
     * @return
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set Amount
     *
     * @param amount
     * @throws BillDetailException
     */
    public void setAmount(int amount) throws BillDetailException {
        if (amount < 0) {
            throw new BillDetailException("Amount must be greater than 0.");
        } else {
            this.amount = amount;
        }

    }

    /**
     * Get note
     *
     * @return
     */
    public String getNote() {
        return note;
    }

    /**
     * Set note
     *
     * @param note
     * @throws BillDetailException
     */
    public void setNote(String note) throws BillDetailException {
        if (note.equals("")) {
            throw new BillDetailException("Note can't be empty.");
        } else {
            this.note = note;
        }

    }

    /**
     * constructor have 6 parameters
     *
     * @param bdId
     * @param pId
     * @param price
     * @param amount
     * @param note
     * @param bid
     */
    public BillDetailInformation(int bdId, int pId, int price, int amount, String note, int bid) {
        this.bdId = bdId;
        this.pId = pId;
        this.price = price;
        this.amount = amount;
        this.note = note;
        this.bid = bid;
    }

}
