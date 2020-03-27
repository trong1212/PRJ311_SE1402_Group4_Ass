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
public class ProductInformation {

    //declare variables
    private int pid;
    private String pname;
    private int ptype;
    private int price;
    private String size;
    private int brand;

    /**
     * get product ID
     *
     * @return
     */
    public int getPid() {
        return pid;
    }

    /**
     * set Product ID
     *
     * @param pid
     * @throws ProductException
     */
    public void setPid(int pid) throws ProductException {
        if (pid < 0) {
            throw new ProductException("Product ID must be greater than 0.");//display warning message
        } else {
            this.pid = pid;
        }

    }

    /**
     * Get Product Name
     *
     * @return
     */
    public String getPname() {
        return pname;
    }

    /**
     * Set Product Name
     *
     * @param pname
     * @throws ProductException
     */
    public void setPname(String pname) throws ProductException {
        if (pname.equals("")) {
            throw new ProductException("Product name can't be empty.");//display warning message
        } else {
            this.pname = pname;
        }

    }

    /**
     * get Product type
     *
     * @return
     */
    public int getPtype() {
        return ptype;
    }

    /**
     * Set Product type
     *
     * @param ptype
     * @throws ProductException
     */
    public void setPtype(int ptype) throws ProductException {
        if (ptype < 0) {
            throw new ProductException("Product must be greater than 0.");//display warning message
        } else {
            this.ptype = ptype;
        }

    }

    /**
     * get Price
     *
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * set Price
     *
     * @param price
     * @throws ProductException
     */
    public void setPrice(int price) throws ProductException {
        if (price < 0) {
            throw new ProductException("Price must be greater than 0.");//display warning message
        } else {
            this.price = price;
        }

    }

    /**
     * Get size
     *
     * @return
     */
    public String getSize() {
        return size;
    }

    /**
     * Set Size
     *
     * @param size
     * @throws ProductException
     */
    public void setSize(String size) throws ProductException {
        if (size.equals("")) {
            throw new ProductException("Size can't be empty.");//display warning message
        } else {
            this.size = size;
        }

    }

    /**
     * get Brand
     *
     * @return
     */
    public int getBrand() {
        return brand;
    }

    /**
     * Set Brand
     *
     * @param brand
     * @throws ProductException
     */
    public void setBrand(int brand) throws ProductException {
        if (brand < 0) {
            throw new ProductException("Brand ID must be greater than 0.");//display warning message
        } else {
            this.brand = brand;
        }

    }

    /**
     * constructor have 6 parameter
     *
     * @param pid
     * @param pname
     * @param ptype
     * @param price
     * @param size
     * @param brand
     */
    public ProductInformation(int pid, String pname, int ptype, int price, String size, int brand) {
        this.pid = pid;
        this.pname = pname;
        this.ptype = ptype;
        this.price = price;
        this.size = size;
        this.brand = brand;
    }

}
