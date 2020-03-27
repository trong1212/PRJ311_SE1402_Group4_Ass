/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramShop;

import java.awt.Font;
import java.awt.Toolkit;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import shopmanage.BillDetailInformation;
import shopmanage.BillDetailModel;
import shopmanage.ProductInformation;
import shopmanage.ProductModel;
import sun.awt.image.ToolkitImage;

/**
 *
 * @author DELL
 */
public class BillMenu extends javax.swing.JFrame {

    //declare variables
    public DefaultTableModel dtm = new DefaultTableModel();
    public ProductModel pm;
    public ArrayList<ProductInformation> products;
    public ArrayList<BillDetailInformation> billdetails;
    public BillDetailModel bdm;
    public int allTotal = 0;
    public int billID = 1;
    Vector v = new Vector();

    String data = "Name,Price,Amount,Total price,Note\n";

    /**
     * Creates new form BillMenu
     */
    public BillMenu() {
        initComponents();
        this.setLocationRelativeTo(null);

        tbProduct.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));//set font and size for table header 
        tbBillDetail.getTableHeader().setFont(new Font("Tahoma", Font.CENTER_BASELINE, 20));//set font and size for table header 
        tbBillDetail.setRowHeight(30);//set size table row
        tbProduct.setRowHeight(30);//set size table row
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/hinh/customer.png")));//set icon for program
        dtm = (DefaultTableModel) tbProduct.getModel();
        products = new ArrayList<>();//create new list product
        billdetails = new ArrayList<>();
        try {
            pm = new ProductModel();
            bdm = new BillDetailModel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Can't load data product.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        }
        loadData();//load data to table

    }

    /**
     * Load data
     */
    public void loadData() {
        try {
            products = pm.loadProduct();
            billID = billdetails.size() + 1;
            txtBillID.setText(String.valueOf(billID));
            dtm.setRowCount(0);
            for (int i = 0; i < products.size(); i++) {
                Object[] row = {products.get(i).getPname(), products.get(i).getPrice()};
                dtm.addRow(row);//set data to table row
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Can't load data product.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        }

    }

    /**
     * load data use for mouse click
     */
    public void loadA() {
        dtm = (DefaultTableModel) tbBillDetail.getModel();
        int select = tbProduct.getSelectedRow();

        try {
            if (txtAmount.getText().equals("")) {//check equal empty
                JOptionPane.showMessageDialog(this, "Amount can't be empty.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
            } else if (Integer.parseInt(txtAmount.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Amount must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
            } else if (txtBillID.getText().equals("")) {//check equal empty
                JOptionPane.showMessageDialog(this, "Bill ID can't be empty.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
            } else if (Integer.parseInt(txtBillID.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Bill ID must be greater than 0.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
            } else {//check true
                int total = Integer.parseInt(txtAmount.getText()) * products.get(select).getPrice();
                Object[] row = {products.get(select).getPname(), txtAmount.getText(), String.valueOf(total)};

                v.add(row);
                dtm.addRow(row);
                tbBillDetail.updateUI();
                allTotal += total;
                txtBillID.setText(String.valueOf(billID));

                String pname = products.get(select).getPname();
                int pprice = products.get(select).getPrice();
                int amount = Integer.parseInt(txtAmount.getText());
                int totalPrice = pprice * amount;
                String note = txtNote.getText();

                data += pname + "," + pprice + "," + amount + "," + totalPrice + "," + note + "\n";
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Number can't be number decimal.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        }

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
        pnlProduct = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProduct = new javax.swing.JTable();
        txtAmount = new javax.swing.JTextField();
        lblAmount = new javax.swing.JLabel();
        pnlBillDetail = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbBillDetail = new javax.swing.JTable();
        btnPrintBill = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        txtAllTotal = new javax.swing.JTextField();
        btnExit = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();
        lblNote = new javax.swing.JLabel();
        txtBillID = new javax.swing.JTextField();
        lblBillId = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bill Menu");

        pnlAll.setBackground(new java.awt.Color(102, 102, 102));

        pnlProduct.setBackground(new java.awt.Color(197, 209, 197));
        pnlProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbProduct.setBackground(new java.awt.Color(197, 209, 197));
        tbProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Product name", "Price"
            }
        ));
        tbProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProduct);

        javax.swing.GroupLayout pnlProductLayout = new javax.swing.GroupLayout(pnlProduct);
        pnlProduct.setLayout(pnlProductLayout);
        pnlProductLayout.setHorizontalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlProductLayout.setVerticalGroup(
            pnlProductLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlProductLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtAmount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblAmount.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAmount.setForeground(new java.awt.Color(0, 0, 0));
        lblAmount.setText("Amount");

        pnlBillDetail.setBackground(new java.awt.Color(197, 209, 197));
        pnlBillDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tbBillDetail.setBackground(new java.awt.Color(145, 235, 144));
        tbBillDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Amount", "Total"
            }
        ));
        jScrollPane2.setViewportView(tbBillDetail);

        javax.swing.GroupLayout pnlBillDetailLayout = new javax.swing.GroupLayout(pnlBillDetail);
        pnlBillDetail.setLayout(pnlBillDetailLayout);
        pnlBillDetailLayout.setHorizontalGroup(
            pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlBillDetailLayout.setVerticalGroup(
            pnlBillDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBillDetailLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnPrintBill.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPrintBill.setText("Print Bill");
        btnPrintBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBillActionPerformed(evt);
            }
        });

        lblTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblTotal.setForeground(new java.awt.Color(0, 0, 0));
        lblTotal.setText("All Total ");

        txtAllTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnExit.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

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

        lblTitle.setFont(new java.awt.Font("Elephant", 1, 36)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Bill Detail");

        lblNote.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNote.setForeground(new java.awt.Color(0, 0, 0));
        lblNote.setText("NOTE");

        txtBillID.setEditable(false);
        txtBillID.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtBillID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBillIDActionPerformed(evt);
            }
        });

        lblBillId.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblBillId.setForeground(new java.awt.Color(0, 0, 0));
        lblBillId.setText("Bill ID");

        javax.swing.GroupLayout pnlAllLayout = new javax.swing.GroupLayout(pnlAll);
        pnlAll.setLayout(pnlAllLayout);
        pnlAllLayout.setHorizontalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlProduct, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAllLayout.createSequentialGroup()
                                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(pnlAllLayout.createSequentialGroup()
                                        .addComponent(lblBillId)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtBillID, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblNote))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(pnlAllLayout.createSequentialGroup()
                                        .addComponent(lblAmount)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlBillDetail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlAllLayout.createSequentialGroup()
                                .addComponent(lblTotal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAllTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAllLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitle)
                        .addGap(322, 322, 322)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        pnlAllLayout.setVerticalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(btnLogout))
                .addGap(8, 8, 8)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlBillDetail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAmount)
                            .addComponent(txtBillID, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBillId))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNote)
                            .addComponent(txtAllTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTotal))
                        .addGap(76, 76, 76))
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnPrintBill, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * action product mouse click
     *
     * @param evt
     */
    private void tbProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductMouseClicked
        // TODO add your handling code here:

        loadA();
        txtAllTotal.setText(String.valueOf(allTotal));
    }//GEN-LAST:event_tbProductMouseClicked
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
     * action when click logout button
     *
     * @param evt
     */
    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        new InterfaceShop().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed
    /**
     * action when click print button
     *
     * @param evt
     */
    private void btnPrintBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBillActionPerformed

        int price = Integer.parseInt(txtAllTotal.getText());
        int amount = Integer.parseInt(txtAmount.getText());
        int select = tbProduct.getSelectedRow();
        billID++;
        int bid = Integer.parseInt(txtBillID.getText());
        try {
            bdm.insertBillDetail(select, price, amount, txtNote.getText(), bid);
            createBill(bid);
            JOptionPane.showMessageDialog(this, "Print bill successfully !", "Information", JOptionPane.INFORMATION_MESSAGE);//display warning message
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Can't save data to list bill details.", "Error", JOptionPane.ERROR_MESSAGE);//display warning message
        } catch (IOException ex) {
            Logger.getLogger(BillMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintBillActionPerformed

    public void createBill(int bid) throws FileNotFoundException, IOException {
        data += "Totals: " + allTotal + "\n";
        String path = "" + bid + ".csv";
        File file = new File(path);
        file.createNewFile();
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(data);
        bw.close();

    }


    private void txtBillIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBillIDActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtBillIDActionPerformed

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
            java.util.logging.Logger.getLogger(BillMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BillMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BillMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BillMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BillMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnPrintBill;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAmount;
    private javax.swing.JLabel lblBillId;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlBillDetail;
    private javax.swing.JPanel pnlProduct;
    private javax.swing.JTable tbBillDetail;
    private javax.swing.JTable tbProduct;
    private javax.swing.JTextField txtAllTotal;
    private javax.swing.JTextField txtAmount;
    private javax.swing.JTextField txtBillID;
    private javax.swing.JTextField txtNote;
    // End of variables declaration//GEN-END:variables
}
