package DML;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class DeleteData extends InsertConnection implements InsertInto{ 
    private String scheme;
    private String table;
    private String usedDml;

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

    public DeleteData() throws SQLException{    
        this.insertDml();
    }
    
    public DeleteData(String scheme,String table) throws SQLException{
        this.scheme = scheme;
        this.table = table;
        
        this.insertDml();
        System.out.println("DELETE [UpperComputers].[" + this.getScheme() + "].[" + this.getTable() +"] ");
    }
    
    String deleteTableDataDML = "DELETE [UpperComputers].[" + this.getScheme() + "].[" + this.getTable() +"] ";

    String deleteAllTableDataDML = 
         "DELETE [UpperComputers].[Employee].[endereco]             "
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

        @Override
        public void insertDml() throws SQLException{          
            String deleteTableDataDML = "DELETE [UpperComputers].[" + this.getScheme() + "].[" + this.getTable() +"] ";

            String deleteAllTableDataDML = 
                 "DELETE [UpperComputers].[Employee].[endereco]             "
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
    
            if(this.getScheme() == null) usedDml = deleteAllTableDataDML;
            else usedDml = deleteTableDataDML; 
            
            super.insertStatement(usedDml);
        }  
}