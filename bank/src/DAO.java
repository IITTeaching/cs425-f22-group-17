import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO 
{
    private DBConnect conn = null;
    private Statement statement = null;

    public DAO(String username, String password)
    {
        this.conn = new DBConnect(username, password);
    }

    public void insertTransaction(int accountNumber, String type, double amount, String description)
    {
        try
        {
            this.statement = this.conn.connect().createStatement();
            String sql = String.format("insert into Transactions(acct_num, type, amount, description) values (%d, %s, %.2f, %s)", accountNumber, type, amount, description);
            this.statement.executeUpdate(sql);
            this.conn.connect().close();
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }

}
