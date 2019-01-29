package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author work
 */
public class Database {
    
    private Database(){}
    
    public static Connection getConnection() throws SQLException 
    {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/skodatabas", "root", "spiderman");
        
        /*Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT id, name FROM Customer");
        int x = 0;
        String s = "";
        while (rs.next()) {
            x = rs.getInt("id");
            s = rs.getString("name");
        }
        
        System.out.println(x + " " + s);
    */
    }
}
