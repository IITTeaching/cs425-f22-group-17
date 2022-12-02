import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
    static final String DB_URL = "jdbc:postgresql://group17database.net:5432/postgres";

    private String username;
    private String password;

    public DBConnect(String username, String password)
    {
        this.username = username;
        this.password = password;
    }
    
    public Connection connect() throws SQLException
    {
        return DriverManager.getConnection(DB_URL, this.username, this.password);
    }
}
