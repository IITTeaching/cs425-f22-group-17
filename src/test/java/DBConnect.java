package test.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect 
{
    private String username;
    private String password;

    public DBConnect(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public Connection connect() throws SQLException
    {
        return DriverManager.getConnection("jdbc:postgresql://group17database.net:5432/postgres", this.username, this.password); //attempts to connect to database
    }
}
