package deo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Hp
 */
public class ConnectionProvider {
    public static Connection getCon() {
        try {
    
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/Store?useSSL=false", 
                "root", 
                "1996"
            );
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
