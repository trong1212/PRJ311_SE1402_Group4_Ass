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
public class CustomerException extends Exception{

    public CustomerException(String string) {
       super("Customer Exception is : "+string);//display warning message
    }
}
