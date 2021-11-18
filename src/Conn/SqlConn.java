package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConn{
    private Connection conn = null;
    
    private final String connectionUrl =
        "jdbc:sqlserver://localhost:1433;"
                + "user=DBA;"
                + "password=admin;"
                + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;";
    
    public Connection getNewConnection() throws SQLException{
        try {
            conn = DriverManager.getConnection(connectionUrl);       
            return conn;
        }
        catch (SQLException e) {
            return null;
        }  
    }
    
}