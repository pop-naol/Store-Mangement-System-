package deo;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 * Creates a table and inserts initial data in the database.
 */
public class tables {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            // Establishing connection
            con = ConnectionProvider.getCon();
            st = con.createStatement();

            
//            st.executeUpdate(
//                "CREATE TABLE sysuser (" +
//                "sysuser_pk INT AUTO_INCREMENT PRIMARY KEY, " +
//                "userRole VARCHAR(50), " +
//                "name VARCHAR(200), " +
//                "mobileNumber VARCHAR(50), " +
//                "email VARCHAR(200), " +
//                "password VARCHAR(50), " +
//                "address VARCHAR(200), " +
//                "status VARCHAR(50)" +
//                ")"
    
//            );
//             
            // Inserting initial data
//            st.executeUpdate("CREATE TABLE catagory (" + "catagory_Pk INT AUTO_INCREMENT PRIMARY KEY, name varchar(200)  )"
//            );  
//            st.executeUpdate("CREATE TABLE product (" + "product_Pk INT AUTO_INCREMENT PRIMARY KEY, name varchar(200) , quantity int, price int, description varchar(500),catagory_fk int  )");
//            JOptionPane.showMessageDialog(null, "Table and data created successfully!");
//        st.executeUpdate("INSERT INTO sysuser (userRole, name, mobilenumber, email, password, address, status) "
//    + "VALUES ('SuperAdmin', 'Super Admin', '989943228', 'Superadmin@gmail.com', 'Admin2025', 'DBU', 'Active')");
//            
// st.executeUpdate("CREATE TABLE orderDetail (" +
//                 "orderDetail_pk INT AUTO_INCREMENT PRIMARY KEY, " +
//                 "orderId VARCHAR(200), " +
//                 "customer_fk INT, " +
//                 "orderDate VARCHAR(200), " +
//                 "totalPaid INT);");

//
//st.executeUpdate("CREATE TABLE IF NOT EXISTS customer (" +
//                "customer_id INT AUTO_INCREMENT PRIMARY KEY, " +
//                "name VARCHAR(200), " +
//                "phoneNumber VARCHAR(50), " +
//                "email VARCHAR(200)" +
//            ")");



// In the 'btnSaveActionPerformed' and 'btnUpdateActionPerformed' methods
String query = "INSERT INTO customer (name, phoneNumber, email) VALUES (?, ?, ?)";


  

            JOptionPane.showMessageDialog(null, "Table and data created successfully!");

        } catch (Exception e) {
            // Displaying the error message
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            try {
                // Closing resources
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
