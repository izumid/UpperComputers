package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;


public class Tarefa extends InsertConnection implements InsertInto{   
    private int cod_tarefa;
    private int cod_atividade;
    private String descricao;

    public int getCod_tarefa() {
        return cod_tarefa;
    }

    public void setCod_tarefa(int cod_tarefa) {
        this.cod_tarefa = cod_tarefa;
    }

    public int getCod_atividade() {
        return cod_atividade;
    }

    public void setCod_atividade(int cod_atividade) {
        this.cod_atividade = cod_atividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Tarefa(int cod_tarefa, int cod_atividade, String descricao) throws SQLException {
        this.setCod_tarefa(cod_tarefa);
        this.setCod_atividade(cod_atividade);
        this.setDescricao(descricao);
        
        this.insertDml();
    }

    @Override
    public void insertDml() throws SQLException{

           String insertTaskDml = "Use UpperComputers INSERT INTO [UpperComputers].[Project].[tarefa] (cod_tarefa, cod_atividade, descricao) "
            + "VALUES( "
                + " " + this.getCod_tarefa() + " " 
                + ", "+ this.getCod_atividade()+ " "  
                + ",'"+ this.getDescricao()+ "'"  
            +")";
                 
           super.insertStatement(insertTaskDml);
    }
    
}