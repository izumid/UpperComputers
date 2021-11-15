package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Atividade extends InsertConnection implements InsertInto{
    private int cod_atividade;
    private String nome;

    public int getCod_atividade() {
        return cod_atividade;
    }

    public void setCod_atividade(int cod_atividade) {
        this.cod_atividade = cod_atividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Atividade(int cod_atividade, String nome) throws SQLException {
        this.setCod_atividade(cod_atividade);
        this.setNome(nome);
        this.insertDml();
    }
    
    @Override
    public void insertDml() throws SQLException{
           String insertActivityDml = "Use UpperComputers INSERT INTO [UpperComputers].[Project].[atividade] (cod_atividade, nome) "
            + "VALUES("
                + " " + this.getCod_atividade() + " " 
                + ",'"+ this.getNome()+ "'"
            +")";
           
           super.insertStatement(insertActivityDml);
    }
}