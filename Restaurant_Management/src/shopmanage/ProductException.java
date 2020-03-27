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
public class ProductException extends Exception {

    public ProductException(String string) {
        super("ProductExceptionis : " + string);//display warning message
    }

}
