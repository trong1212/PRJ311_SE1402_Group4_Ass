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
public class ProductTypeException extends Exception {

    /**
     * Exception of product type
     *
     * @param str
     */
    public ProductTypeException(String str) {
        super("Product type exception: " + str);//display warning mesage
    }
}
