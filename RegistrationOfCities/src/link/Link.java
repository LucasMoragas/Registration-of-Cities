package link;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lucas Moragas Melo Oliveira
 */
public class Link {
    //The function will establish a connection to the database
    public static Connection getConnection(){
        Connection connection = null;
        
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cities","root","oeste0808");//jbc (java database connector)
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "CONNECTION ERROR");
        }
        
        return connection;
    }
}
