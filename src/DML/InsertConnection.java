package DML;

import java.sql.SQLException;
import java.sql.Statement;
import Conn.SqlConn;

public abstract class InsertConnection {
    SqlConn conn = new SqlConn();
    private String pathLocation;

    
    public void insertStatement(String insertDml){
        pathLocation = insertDml;
        String checker = pathLocation.substring(0,pathLocation.indexOf(" ",+1));
        
        String value = pathLocation.substring(pathLocation.indexOf("[",+1));
        value = value.substring(0,value.indexOf(" ",+1));
       // System.out.println(checker);

        try{
            Statement stmt = conn.getNewConnection().createStatement();
            stmt.executeUpdate(insertDml);

            if(checker.equals("DELETE")){
                System.out.println("DELETE D.M.L was run successful!");
            }
            else{
                System.out.println("INSERT INTO " + value +" was Successful!");
            }
            
            stmt.close();
        }
        catch(SQLException e){
           
            if(checker != "DELETE"){
                System.out.println("DELETE D.M.L ERROR: " + e);
            }
            else{
                System.out.println("ERROR IN " + value +  ": (" + e + ")");
            }
            
        }
        
    }
}