package DML;

import java.sql.SQLException;
import java.sql.Statement;
import Conn.SqlConn;

public class DeleteData{
    SqlConn conn = new SqlConn();
    
    private String scheme;
    private String table;

    public DeleteData() throws SQLException{
        
        this.deleteAllTableData();
    }

    public DeleteData(String scheme,String table) throws SQLException{
        this.scheme = scheme;
        this.table = table;
        
        this.deleteTableData();
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }
    
    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    
    public void deleteAllTableData() throws SQLException{
       String deleteAllTableDataDML = " Use UpperComputers               "
            +" DELETE [UpperComputers].[Employee].[endereco]             "
            +" DELETE [UpperComputers].[Employee].[recurso]              "
            +" DELETE [UpperComputers].[Employee].[telefone]             "
            +" DELETE [UpperComputers].[History].[historicocargo]        "
            +" DELETE [UpperComputers].[Project].[atividade]             "
            +" DELETE [UpperComputers].[Project].[equipe]                "
            +" DELETE [UpperComputers].[Project].[projeto]               "
            +" DELETE [UpperComputers].[Project].[projeto_atividade]     "
            +" DELETE [UpperComputers].[Project].[projeto_finalizado]    "
            +" DELETE [UpperComputers].[Project].[tarefa]                "   
            +" DELETE [UpperComputers].[Role].[cargo]                    "
            +" DELETE [UpperComputers].[Tool].[ferramenta]               "
            +" DELETE [UpperComputers].[Tool].[programador_ferramenta]   ";
       
       try{
            Statement stmt = conn.getNewConnection().createStatement();
            stmt.executeUpdate(deleteAllTableDataDML);
            System.out.println("Delete all tables data Successful!!");
            stmt.close();
       }catch(SQLException e){
             System.out.println("Delete Failure: (" + e + ")");
       }
        
    }
    
    public void deleteTableData() throws SQLException{
     String deleteTableDataDML = " Use UpperComputers "
            +" DELETE [UpperComputers].[" + this.getScheme() + "].[" + this.getTable() +"]";
     
           try{
            Statement stmt = conn.getNewConnection().createStatement();
            stmt.executeUpdate(deleteTableDataDML);
            System.out.println("Delete: Successful!!");
            stmt.close();
       }catch(SQLException e){
             System.out.println("Delete Failure: (" + e + ")");
       }
     
    }
    
}
