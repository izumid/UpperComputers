package Conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConn{
    //private Connection connection = null;
    //private Connection connection;
    //private Statement stat;
    private Connection conn = null;
    
    private final String connectionUrl =
        "jdbc:sqlserver://localhost:1433;"
               // +"instanceName=SQLSERVER;"
                //+ "database=UpperComputers;"
               // + "user=UpperDBA;"
               // + "password=@dmin;"

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