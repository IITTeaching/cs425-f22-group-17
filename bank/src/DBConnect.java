import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
    static final String DB_URL = "jdbc:postgresql://group17database.net:5432/postgres";
    
    public Connection connect(String username, String password) throws SQLException
    {
        return DriverManager.getConnection(DB_URL, username, password);
    }
}
