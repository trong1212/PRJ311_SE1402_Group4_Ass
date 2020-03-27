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
public class ProductBrandException extends Exception {

    /**
     * Exception of Product Brand
     *
     * @param str
     */
    public ProductBrandException(String str) {
        super("Product Brand: " + str);//display warning message
    }

}
