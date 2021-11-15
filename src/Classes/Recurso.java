package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Recurso extends InsertConnection implements InsertInto{
    private int numero_registro;
    private String nome_recurso;
    private String ultimonome_recurso;
    private int cod_cargo;
    
    public int getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(int numero_registro) {
        this.numero_registro = numero_registro;
    }

    public String getNome_recurso() {
        return nome_recurso;
    }

    public void setNome_recurso(String nome_recurso) {
        this.nome_recurso = nome_recurso;
    }

    public String getUltimoNome_recurso() {
        return ultimonome_recurso;
    }

    public void setUltimoNome_recurso(String ultimonome_recurso) {
        this.ultimonome_recurso = ultimonome_recurso;
    }

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }
    
    public Recurso(int numero_registro, String nome_recurso, String ultimonome_recurso, int cod_cargo) throws SQLException {
        this.setNumero_registro(numero_registro);
        this.setNome_recurso(nome_recurso);
        this.setUltimoNome_recurso(ultimonome_recurso);
        this.setCod_cargo(cod_cargo);
        
        insertDml();
    }
    
      @Override
      public void insertDml() throws SQLException{
            String insertUserDml = "Use UpperComputers INSERT INTO [UpperComputers].[Employee].[recurso] (numero_registro,nome, ultimo_nome,cod_cargo, salario) "
                + "VALUES("
                    + this.getNumero_registro() 
                    + ",'" + this.getNome_recurso() + "'" 
                    + ",'"+ this.getUltimoNome_recurso()+ "'"  
                    + ", " + this.getCod_cargo() 
                    + ", (SELECT salario FROM [UpperComputers].[Role].[cargo] WHERE cod_cargo = " + this.getCod_cargo() +")" 
             +")";

            String insertoIntoHistoricDml = "Use UpperComputers INSERT INTO [UpperComputers].[History].[historicocargo] (cod_cargo, numero_registro, data_alteracao, descricao, salario, atual) "
                + "VALUES("
                    + this.getCod_cargo()
                    + ", " + this.getNumero_registro() 
                    + ", CAST(getDate() AS DATE) "
                    + ", 'Cargo Inicial' "    
                    + ", (SELECT salario FROM [UpperComputers].[Role].[cargo] WHERE cod_cargo = " + this.getCod_cargo() +")"
                    + ", 1"
            +")";

            super.insertStatement(insertUserDml);
            super.insertStatement(insertoIntoHistoricDml);
       }
   
    
}
