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
public class BillException extends Exception {

    public BillException(String string) {
        super("BillException: " + string);//display warning message
    }

}
