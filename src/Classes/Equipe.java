package Classes;

import DML.InsertConnection;
import java.sql.SQLException;
import DML.InsertInto;

public class Equipe extends InsertConnection implements InsertInto{
    private int cod_equipe;
    private String nome;
    private int quantidade_recursos;
    private int numero_registro;

    public int getCod_equipe() {
        return cod_equipe;
    }

    public void setCod_equipe(int cod_equipe) {
        this.cod_equipe = cod_equipe;
    }

    public int getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(int numero_registro) {
        this.numero_registro = numero_registro;
    }
   
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade_recursos() {
        return quantidade_recursos;
    }

    public void setQuantidade_recursos(int quantidade_recursos) {
        this.quantidade_recursos = quantidade_recursos;
    }
    
    public Equipe(int cod_equipe,int numero_registro, String nome, int quantidade_recursos) throws SQLException {
        this.cod_equipe = cod_equipe;
        this.numero_registro = numero_registro;
        this.nome = nome;
        this.quantidade_recursos = quantidade_recursos;
        
        this.insertDml();
    }
    
   @Override
   public void insertDml()throws SQLException{
        String insertTeamDml = "Use UpperComputers INSERT INTO [UpperComputers].[Project].[equipe] (cod_equipe,numero_registro,nome,quantidade_recursos) "
         + "VALUES("
             + this.getCod_equipe() 
             + ", '" + this.getNumero_registro() + "' " 
             + ", '" + this.getNome()+ "' "  
             + ", "  + this.getQuantidade_recursos()
         +")";

        super.insertStatement(insertTeamDml);
   }
   
}