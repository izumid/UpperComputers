package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Projeto_Atividade extends InsertConnection implements InsertInto{
    private int cod_projeto;
    private int cod_atividade;
    
    public int getCod_projeto() {
        return cod_projeto;
    }

    public void setCod_projeto(int cod_projeto) {
        this.cod_projeto = cod_projeto;
    }
    
    public int getCod_atividade() {
        return cod_atividade;
    }

    public void setCod_atividade(int cod_atividade) {
        this.cod_atividade = cod_atividade;
    }

    public Projeto_Atividade(int cod_projeto, int cod_atividade) throws SQLException {
        this.setCod_projeto(cod_projeto);
        this.setCod_atividade(cod_atividade);
        
        this.insertDml();
    }

    @Override
    public void insertDml() throws SQLException{
        String insertProjectActivityDml = "Use UpperComputers INSERT INTO [UpperComputers].[Project].[projeto_atividade] (cod_projeto, cod_atividade) "
         + "VALUES("
             + " " + this.getCod_projeto()  
             + ", " + this.getCod_atividade()
         +")";
                 
        super.insertStatement(insertProjectActivityDml);
    }
    
}


/*

package Classes;

import java.sql.SQLException;
import java.sql.Statement;
import uppercomputers.Data.SqlConn;

public class projeto_atividade {
    
    private atividade cod_atividade;
   
    private projeto cod_projeto;
    
     SqlConn conn = new SqlConn();

    public atividade getCod_atividade() {
        return cod_atividade;
    }

    public void setCod_atividade(atividade cod_atividade) {
        this.cod_atividade = cod_atividade;
    }

    

    public projeto getCod_projeto() {
        return cod_projeto;
    }

    public void setCod_projeto(projeto cod_projeto) {
        this.cod_projeto = cod_projeto;
    }

   

   

    public projeto_atividade(atividade codatividade, projeto codprojeto) throws SQLException {
      
        this.setCod_atividade(codatividade);
        this.setCod_projeto(codprojeto);
        
        this.insertUser();
    }

    @Override
    public String toString() {
        return "projeto_atividade{" + "cod_atividade=" + this.getCod_atividade() + ",  cod_projeto="+ this.getCod_projeto() ;
    }
  
    private void insertUser() throws SQLException{

         //String insertUserDML = "Use UpperComputers INSERT INTO [UpperComputers].[dbo].[recurso](numero_registro,nome_recurso, sobrenome_recurso, salario, cod_cargo,cod_equipe) "
           String insertUserDML = "Use UpperComputers INSERT INTO [UpperComputers].[dbo].[projeto_atividade]( cod_atividade,  cod_projeto) "
            + "VALUES("
                //+ null
                + "'" + this.getCod_atividade() + "'" 
                 
                + ",'"+ this.getCod_projeto()+ "'"  
                
            +")";
                 
        try{
            Statement stmt = conn.getNewConnection().createStatement();
            stmt.executeUpdate(insertUserDML);
            stmt.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }   
    }}

*/