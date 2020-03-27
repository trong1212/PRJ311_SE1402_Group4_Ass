/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramShop;

import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class MenuShop extends javax.swing.JFrame {

    /**
     * Creates new form MenuShop
     */
    public MenuShop() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/hinh/account.png")));//set icon for program
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAll = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        pnlManagement = new javax.swing.JPanel();
        btnProduct = new javax.swing.JButton();
        btnEmployee = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnBill = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        lblManagement = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        pnlBill = new javax.swing.JPanel();
        lblBillCalculation = new javax.swing.JLabel();
        btnNewBill = new javax.swing.JButton();
        pnlOption = new javax.swing.JPanel();
        lblOption = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);

        pnlAll.setBackground(new java.awt.Color(102, 102, 102));

        lblTitle.setFont(new java.awt.Font("Elephant", 1, 48)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("RESTAURANT MANAGER");

        pnlManagement.setBackground(new java.awt.Color(204, 204, 204));
        pnlManagement.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnProduct.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/product.png"))); // NOI18N
        btnProduct.setText("Product");
        btnProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductActionPerformed(evt);
            }
        });

        btnEmployee.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEmployee.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/employee.png"))); // NOI18N
        btnEmployee.setText("Employee");
        btnEmployee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeActionPerformed(evt);
            }
        });

        btnCustomer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnCustomer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/customer.png"))); // NOI18N
        btnCustomer.setText("Customer");
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnBill.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/bill.png"))); // NOI18N
        btnBill.setText("Bill");
        btnBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBillActionPerformed(evt);
            }
        });

        btnAccount.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/account.png"))); // NOI18N
        btnAccount.setText("Account");
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });

        lblManagement.setFont(new java.awt.Font("Elephant", 1, 24)); // NOI18N
        lblManagement.setForeground(new java.awt.Color(0, 0, 0));
        lblManagement.setText("Management");

        btnLogout.setBackground(new java.awt.Color(255, 255, 255));
        btnLogout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnLogout.setForeground(new java.awt.Color(0, 0, 0));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/exit-93-458494.png"))); // NOI18N
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlManagementLayout = new javax.swing.GroupLayout(pnlManagement);
        pnlManagement.setLayout(pnlManagementLayout);
        pnlManagementLayout.setHorizontalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagementLayout.createSequentialGroup()
                .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlManagementLayout.createSequentialGroup()
                        .addGap(274, 274, 274)
                        .addComponent(lblManagement))
                    .addGroup(pnlManagementLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProduct, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlManagementLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlManagementLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        pnlManagementLayout.setVerticalGroup(
            pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblManagement)
                .addGap(14, 14, 14)
                .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEmployee, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(pnlManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLogout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAccount, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                    .addComponent(btnBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pnlBill.setBackground(new java.awt.Color(197, 209, 197));
        pnlBill.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblBillCalculation.setFont(new java.awt.Font("Elephant", 1, 18)); // NOI18N
        lblBillCalculation.setForeground(new java.awt.Color(0, 0, 0));
        lblBillCalculation.setText("Bill Calculation");

        btnNewBill.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNewBill.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/add (1).png"))); // NOI18N
        btnNewBill.setText("New Bill");
        btnNewBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewBillActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBillLayout = new javax.swing.GroupLayout(pnlBill);
        pnlBill.setLayout(pnlBillLayout);
        pnlBillLayout.setHorizontalGroup(
            pnlBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(pnlBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNewBill, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBillCalculation, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBillLayout.setVerticalGroup(
            pnlBillLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(lblBillCalculation)
                .addGap(32, 32, 32)
                .addComponent(btnNewBill)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pnlOption.setBackground(new java.awt.Color(197, 209, 197));
        pnlOption.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        lblOption.setFont(new java.awt.Font("Elephant", 0, 24)); // NOI18N
        lblOption.setForeground(new java.awt.Color(0, 0, 0));
        lblOption.setText("Option");

        btnHelp.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnHelp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/Help-icon (1).png"))); // NOI18N
        btnHelp.setText("Help");
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        btnAbout.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/info.png"))); // NOI18N
        btnAbout.setText("About");
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        btnExit.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hinh/exit-93-458494.png"))); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlOptionLayout = new javax.swing.GroupLayout(pnlOption);
        pnlOption.setLayout(pnlOptionLayout);
        pnlOptionLayout.setHorizontalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(lblOption))
                    .addGroup(pnlOptionLayout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHelp, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnAbout, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                                .addComponent(btnExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        pnlOptionLayout.setVerticalGroup(
            pnlOptionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOptionLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(lblOption)
                .addGap(29, 29, 29)
                .addComponent(btnHelp)
                .addGap(35, 35, 35)
                .addComponent(btnAbout)
                .addGap(30, 30, 30)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout pnlAllLayout = new javax.swing.GroupLayout(pnlAll);
        pnlAll.setLayout(pnlAllLayout);
        pnlAllLayout.setHorizontalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlManagement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlBill, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlOption, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        pnlAllLayout.setVerticalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAllLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addComponent(pnlBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(pnlOption, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(275, 275, 275))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.PREFERRED_SIZE, 639, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * action when click product button
     *
     * @param evt
     */
    private void btnProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductActionPerformed
        // TODO add your handling code here:
        ProductMenu pm;
        try {
            pm = new ProductMenu();
            pm.setVisible(true);
            pm.setLocationRelativeTo(null);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Can't show product menu.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        }


    }//GEN-LAST:event_btnProductActionPerformed
    /**
     * action when click logout button
     *
     * @param evt
     */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        InterfaceShop ifs = new InterfaceShop();
        ifs.setVisible(true);
        ifs.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLogoutActionPerformed
    /**
     * action when click customer button
     *
     * @param evt
     */
    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        try {
            // TODO add your handling code here:
            CustomerMenu cm = new CustomerMenu();
            cm.setVisible(true);
            cm.setLocationRelativeTo(null);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can't select customer menu.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        }

    }//GEN-LAST:event_btnCustomerActionPerformed
    /**
     * action when click new bill button
     *
     * @param evt
     */
    private void btnNewBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewBillActionPerformed
        // TODO add your handling code here:
        new BillMenu().setVisible(true);

    }//GEN-LAST:event_btnNewBillActionPerformed
    /**
     * action when click exit button
     *
     * @param evt
     */
    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
    /**
     * action when click employee button
     *
     * @param evt
     */
    private void btnEmployeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeActionPerformed
        try {
            // TODO add your handling code here:
            new EmployeeMenu().setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can't show employee menu.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        }
    }//GEN-LAST:event_btnEmployeeActionPerformed
    /**
     * action when lick account button
     *
     * @param evt
     */
    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Vui long nap 500k de tiep tuc su dung dich vu.", "Error", JOptionPane.INFORMATION_MESSAGE);//display warning message
    }//GEN-LAST:event_btnAccountActionPerformed
    /**
     * action when click bill button
     *
     * @param evt
     */
    private void btnBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBillActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Vui long nap 500k de tiep tuc su dung dich vu.", "Error", JOptionPane.INFORMATION_MESSAGE);//display warning message
    }//GEN-LAST:event_btnBillActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        // TODO add your handling code here:
        new About().setVisible(true);
    }//GEN-LAST:event_btnAboutActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        // TODO add your handling code here:
        new HelpMenu().setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuShop.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuShop().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnBill;
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnEmployee;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNewBill;
    private javax.swing.JButton btnProduct;
    private javax.swing.JLabel lblBillCalculation;
    private javax.swing.JLabel lblManagement;
    private javax.swing.JLabel lblOption;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlBill;
    private javax.swing.JPanel pnlManagement;
    private javax.swing.JPanel pnlOption;
    // End of variables declaration//GEN-END:variables
}