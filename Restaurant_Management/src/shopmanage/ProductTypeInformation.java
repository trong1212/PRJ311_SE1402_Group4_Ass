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
public class ProductTypeInformation {

    //Declare variables
    private int ptid;
    private String ptname;

    /**
     * Get id of Product Type
     *
     * @return
     */
    public int getPtid() {
        return ptid;
    }

    /**
     * set ID of Product type
     *
     * @param ptid
     */
    public void setPtid(int ptid) {
        //check
        if (ptid <= 0) {//invalid
            System.out.println("ID must be greater than 0.");//display warning message
        } else {//valid
            this.ptid = ptid;
        }
    }

    /**
     * Get name of Product type
     *
     * @return
     */
    public String getPtname() {
        return ptname;
    }

    public void setPtname(String ptname) {
        //check
        if (ptname.equals("")) {//invalid
            System.out.println("Name can't be empty");//DIsplay warning message
        } else {//valid
            this.ptname = ptname;
        }
    }

    /**
     * Constructor
     *
     * @param ptid
     * @param ptname
     */
    public ProductTypeInformation(int ptid, String ptname) {
        this.ptid = ptid;
        this.ptname = ptname;
    }

}
