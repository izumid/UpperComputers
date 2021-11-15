package DML;

import java.sql.SQLException;
import java.sql.Statement;
import Conn.SqlConn;

public abstract class InsertConnection {
    SqlConn conn = new SqlConn();
    private String pathLocation;
    
    public void insertStatement(String insertDml){
        pathLocation = insertDml;
        String value = pathLocation.substring(pathLocation.indexOf("[",+1));
        value = value.substring(0,value.indexOf(" ",+1));
        
        try{
            Statement stmt = conn.getNewConnection().createStatement();
            stmt.executeUpdate(insertDml);
            System.out.println("INSERT INTO " + value +" was Successful!");
            stmt.close();
        }
        catch(SQLException e){
            System.out.println("ERROR IN " + value +  ": (" + e + ")");
        }
    }
}