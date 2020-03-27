/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramShop;

/**
 *
 * @author DELL
 */
public class MainFunction {

    public static void main(String[] args) throws InterruptedException {
        Welcome wc = new Welcome();
        wc.setVisible(true);
        wc.setLocationRelativeTo(null);
        for (int i = 0; i < 101; i++) {
            wc.lblLoading.setText("Loading " + i + " %");
            wc.lblPro.setValue(i);
            Thread.sleep(30);
        }
        wc.setVisible(true);
        InterfaceShop login = new InterfaceShop();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
    }
}
