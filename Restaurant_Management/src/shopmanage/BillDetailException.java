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
public class BillDetailException extends Exception {

    public BillDetailException(String string) {
        super("BillDetailException: " + string);//display warning message
    }

}
