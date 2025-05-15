
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import common.OpenPdf;
import deo.ConnectionProvider;
import deo.StoreUtils;
import java.io.FileOutputStream;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Hp
 */
public class Order extends javax.swing.JFrame {

    private int product_Pk = 0;
    private int customer_id = 0;
    private int finalTotalPrice = 0;
    private String orderid = "";

    public Order() {
        initComponents();
        setLocationRelativeTo(null);
    }

    private void clearproductfields() {
        product_Pk = 0;
        txtPname.setText("");
        txtPprice.setText("");
        txtPdiscription.setText("");
        txtPquantity.setText("");

    }

    public String getUniqueId(String prefix) {

        return prefix + System.nanoTime();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClist = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablePlist = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableCart = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtCmobile = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtCemail = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtPname = new javax.swing.JTextField();
        txtPprice = new javax.swing.JTextField();
        txtPdiscription = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtPquantity = new javax.swing.JTextField();
        btnAddcart = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lblFinal = new javax.swing.JLabel();
        btnSorder = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnDorder = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Manage Orders");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 16, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Customer list");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 60, -1, -1));

        tableClist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Mobile Number ", "Email"
            }
        ));
        tableClist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClist);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 95, 294, 271));
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Product List");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(567, 60, -1, -1));

        tablePlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Price", "Quantity", "Discription", "Catagory ID", "Catagory Name"
            }
        ));
        tablePlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePlistMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablePlist);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(319, 95, 490, 271));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Cart");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1071, 60, -1, -1));

        tableCart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Id", "Name", "Quantity", "Price", "Discription", "Sub Total"
            }
        ));
        tableCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCartMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tableCart);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(821, 95, 435, 271));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Selected Customer:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 388, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Name ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 421, -1, -1));

        txtCname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCnameActionPerformed(evt);
            }
        });
        getContentPane().add(txtCname, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 444, 240, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Mobile Number");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 489, -1, -1));

        txtCmobile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCmobileActionPerformed(evt);
            }
        });
        getContentPane().add(txtCmobile, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 511, 240, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Email");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 557, -1, -1));
        getContentPane().add(txtCemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 584, 240, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Selected Product:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Product Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 410, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Product Price");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Product Discription");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, -1, -1));
        getContentPane().add(txtPname, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 440, 261, -1));

        txtPprice.setText(" ");
        getContentPane().add(txtPprice, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 490, 261, -1));

        txtPdiscription.setText(" ");
        txtPdiscription.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPdiscriptionActionPerformed(evt);
            }
        });
        getContentPane().add(txtPdiscription, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 550, 261, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setText("Order Quantity");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, -1, -1));

        txtPquantity.setText(" ");
        getContentPane().add(txtPquantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 600, 261, -1));

        btnAddcart.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddcart.setText(" Add To Cart ");
        btnAddcart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddcartActionPerformed(evt);
            }
        });
        getContentPane().add(btnAddcart, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 630, 159, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setText("Total Amount RS:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(928, 384, -1, -1));

        lblFinal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFinal.setText("00000");
        getContentPane().add(lblFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 384, -1, -1));

        btnSorder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSorder.setText("Save Order");
        btnSorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSorderActionPerformed(evt);
            }
        });
        getContentPane().add(btnSorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 444, 322, -1));

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setText("Reset ");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        getContentPane().add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 495, 322, -1));

        btnDorder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDorder.setText("Delete Order");
        btnDorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDorderActionPerformed(evt);
            }
        });
        getContentPane().add(btnDorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 551, 322, -1));

        btnClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });
        getContentPane().add(btnClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(847, 612, 322, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here: 
        txtCname.setEditable(false);
        txtCmobile.setEditable(false);
        txtCemail.setEditable(false);

        txtPname.setEnabled(false);
        txtPprice.setEnabled(false);
        txtPdiscription.setEnabled(false);

        DefaultTableModel model = (DefaultTableModel) tableClist.getModel();
        DefaultTableModel productmodel = (DefaultTableModel) tablePlist.getModel();

        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select *from customer");
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("customer_id"), rs.getString("name"), rs.getString("mobilenumber"), rs.getString("email")});
            }

            rs = st.executeQuery("SELECT * \n"
                    + "FROM product \n"
                    + "INNER JOIN catagory  \n"
                    + "ON product.catagory_fk = catagory .catagory_pk;");
            while (rs.next()) {
                productmodel.addRow(new Object[]{rs.getString("product_pk"), rs.getString("name"), rs.getString("price"), rs.getString("quantity"), rs.getString("description"), rs.getString("catagory_fk"), rs.getString(8)});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }


    }//GEN-LAST:event_formComponentShown

    private void txtCnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCnameActionPerformed

    }//GEN-LAST:event_txtCnameActionPerformed

    private void txtCmobileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCmobileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCmobileActionPerformed

    private void txtPdiscriptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPdiscriptionActionPerformed

    }//GEN-LAST:event_txtPdiscriptionActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed

        setVisible(false);
        new Order().setVisible(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed

        setVisible(false);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void tableClistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClistMouseClicked

        int index = tableClist.getSelectedRow();
        TableModel model = tableClist.getModel();
        String id = model.getValueAt(index, 0).toString();
        customer_id = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtCname.setText(name);

        String mobilenumber = model.getValueAt(index, 2).toString();
        txtCmobile.setText(mobilenumber);

        String email = model.getValueAt(index, 3).toString();
        txtCemail.setText(email);


    }//GEN-LAST:event_tableClistMouseClicked

    private void tablePlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePlistMouseClicked
        // TODO add your handling code here:

        int index = tablePlist.getSelectedRow();
        TableModel model = tablePlist.getModel();
        String id = model.getValueAt(index, 0).toString();
        product_Pk = Integer.parseInt(id);

        String name = model.getValueAt(index, 1).toString();
        txtPname.setText(name);

        String price = model.getValueAt(index, 2).toString();
        txtPprice.setText(price);

        String quantity = model.getValueAt(index, 3).toString();
        txtPquantity.setText(quantity);

        String discription = model.getValueAt(index, 4).toString();
        txtPdiscription.setText(discription);


    }//GEN-LAST:event_tablePlistMouseClicked

    private void btnAddcartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddcartActionPerformed

        String noOfUnit = txtPquantity.getText();
        if (!noOfUnit.isEmpty() && noOfUnit.matches("\\d+")) { // Validate input
            int quantity = Integer.parseInt(noOfUnit);
            int availableQuantity = Integer.parseInt(txtPquantity.getText().trim());

            if (quantity > 0 && quantity <= availableQuantity) {
                String name = txtPname.getText();
                String description = txtPdiscription.getText();
                int price = Integer.parseInt(txtPprice.getText().trim());
                int subTotal = price * quantity;
                finalTotalPrice += subTotal;

                DefaultTableModel cartModel = (DefaultTableModel) tableCart.getModel();
                cartModel.addRow(new Object[]{product_Pk, name, quantity, price, description, subTotal});

                lblFinal.setText(String.valueOf(finalTotalPrice)); // Update Total Price
                clearproductfields();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Quantity! Ensure it's within the available stock.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Enter a valid quantity!");
        }
    }//GEN-LAST:event_btnAddcartActionPerformed

    private void tableCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCartMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tableCartMouseClicked

    private void btnDorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDorderActionPerformed

        int selectedRow = tableCart.getSelectedRow();

        if (selectedRow != -1) {
            DefaultTableModel model = (DefaultTableModel) tableCart.getModel();

            String productId = model.getValueAt(selectedRow, 0).toString();
            int confirmation = JOptionPane.showConfirmDialog(null,
                    "Are you sure you want to delete this order?",
                    "Delete Confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    int subTotal = Integer.parseInt(model.getValueAt(selectedRow, 5).toString());
                    model.removeRow(selectedRow);

                    finalTotalPrice -= subTotal;
                    lblFinal.setText(String.valueOf(finalTotalPrice));

                    Connection con = ConnectionProvider.getCon();
                    Statement st = con.createStatement();
                    String deleteQuery = "DELETE FROM order_details WHERE product_pk = '" + productId + "'";
                    st.executeUpdate(deleteQuery);

                    JOptionPane.showMessageDialog(null, "Order Successfully Deleted");
                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Error while deleting order: " + e.getMessage());
                }
            } else {

                JOptionPane.showMessageDialog(null, "Order deletion cancelled.");
            }
        } else {

            JOptionPane.showMessageDialog(null, "Please select an order to delete from the cart.");
        }
    }//GEN-LAST:event_btnDorderActionPerformed

    private void btnSorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSorderActionPerformed
        if (finalTotalPrice != 0 && !txtCname.getText().equals("")) {

            String orderId = getUniqueId("Bill-");

            DefaultTableModel dtm = (DefaultTableModel) tableCart.getModel();
            if (tableCart.getRowCount() != 0) {

                for (int i = 0; i < tableCart.getRowCount(); i++) {
                    try {
                        Connection con = ConnectionProvider.getCon();
                        Statement st = con.createStatement();
                        int productQuantity = Integer.parseInt(dtm.getValueAt(i, 2).toString());
                        int productPk = Integer.parseInt(dtm.getValueAt(i, 0).toString());

                        st.executeUpdate("UPDATE product SET quantity = quantity - " + productQuantity
                                + " WHERE product_pk = " + productPk);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }

                // Insert order details into the database
                try {
                    SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Calendar cal = Calendar.getInstance();
                    Connection con = ConnectionProvider.getCon();
                    PreparedStatement ps = con.prepareStatement("INSERT INTO orderdetail(orderId, customer_fk, orderDate, totalPaid) VALUES (?, ?, ?, ?)");
                    ps.setString(1, orderId);
                    ps.setInt(2, customer_id);
                    ps.setString(3, myFormat.format(cal.getTime()));
                    ps.setInt(4, finalTotalPrice);
                    ps.executeUpdate();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                // Generate a PDF receipt for the order
                com.itextpdf.text.Document doc = new com.itextpdf.text.Document();
                try {
                    SimpleDateFormat myFormat = new SimpleDateFormat("dd-MM-yyyy");
                    Calendar cal = Calendar.getInstance();

                    PdfWriter.getInstance(doc, new FileOutputStream(StoreUtils.billpath + orderId + ".pdf"));
                    doc.open();

                    Paragraph projectName = new Paragraph("Store Management System\n");
                    doc.add(projectName);
                    Paragraph starLine = new Paragraph("*******************************************************************************************\n");
                    doc.add(starLine);
                    String customerName = txtCname.getText().trim();
                    Paragraph customerNamePara = new Paragraph("Customer Name: " + customerName + "\n");
                    doc.add(customerNamePara);

                    Paragraph details = new Paragraph("\tOrder ID: " + orderId + "\nDate: " + myFormat.format(cal.getTime())
                            + "\nTotal Paid: " + finalTotalPrice);
                    doc.add(details);
                    doc.add(starLine);

                    PdfPTable tb1 = new PdfPTable(5);
                    tb1.addCell(new PdfPCell(new Phrase("Name")));
                    tb1.addCell(new PdfPCell(new Phrase("Description")));
                    tb1.addCell(new PdfPCell(new Phrase("Price per Unit")));
                    tb1.addCell(new PdfPCell(new Phrase("Quantity")));
                    tb1.addCell(new PdfPCell(new Phrase("Sub Total Price")));

                    for (int i = 0; i < tableCart.getRowCount(); i++) {
                        tb1.addCell(tableCart.getValueAt(i, 1).toString());
                        tb1.addCell(tableCart.getValueAt(i, 4).toString());
                        tb1.addCell(tableCart.getValueAt(i, 3).toString());
                        tb1.addCell(tableCart.getValueAt(i, 2).toString());
                        tb1.addCell(tableCart.getValueAt(i, 5).toString());
                    }
                    doc.add(tb1);
                    doc.add(starLine);

                    Paragraph thanksMsg = new Paragraph("Thank you for shopping with us!");
                    doc.add(thanksMsg);
                    OpenPdf.OpenByID(orderId);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                } finally {

                    doc.close();
                }
                setVisible(false);
                new Order().setVisible(true);
            }
        } else {

            JOptionPane.showMessageDialog(null, "Please add some products to the cart.");
        }

    }

    private PdfPCell newPdfPCell(Phrase phrase) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody

    }//GEN-LAST:event_btnSorderActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Order().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddcart;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnDorder;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSorder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblFinal;
    private javax.swing.JTable tableCart;
    private javax.swing.JTable tableClist;
    private javax.swing.JTable tablePlist;
    private javax.swing.JTextField txtCemail;
    private javax.swing.JTextField txtCmobile;
    private javax.swing.JTextField txtCname;
    private javax.swing.JTextField txtPdiscription;
    private javax.swing.JTextField txtPname;
    private javax.swing.JTextField txtPprice;
    private javax.swing.JTextField txtPquantity;
    // End of variables declaration//GEN-END:variables
}
