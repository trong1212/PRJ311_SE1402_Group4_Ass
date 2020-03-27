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
public class ProductBrandInformation {

    //Declare variables
    private int pbid;
    private String pbname;

    /**
     * Get id of Product Brand
     *
     * @return
     */
    public int getPbid() {
        return pbid;
    }

    /**
     * Set id of Product Brand
     *
     * @param pbid
     */
    public void setPbid(int pbid) {
        //check
        if (pbid <= 0) {//invalid
            System.out.println("ID must be greater than 0.");//display warning message
        } else {//invalid
            this.pbid = pbid;
        }
    }

    /**
     * Get name of Product Brand
     *
     * @return
     */
    public String getPbname() {
        return pbname;
    }

    /**
     * Set name of Product Brand
     *
     * @param pbname
     */
    public void setPbname(String pbname) {
        //check
        if (pbname.equals("")) {//invalid
            System.out.println("Name can't be empty.");//display warning message
        } else {//valid
            this.pbname = pbname;
        }
    }

    /**
     * Constructor
     *
     * @param pbid
     * @param pbname
     */
    public ProductBrandInformation(int pbid, String pbname) {
        this.pbid = pbid;
        this.pbname = pbname;
    }

}
