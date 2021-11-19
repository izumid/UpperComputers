package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Projeto extends InsertConnection implements InsertInto{  
    private int cod_projeto;
    private String nome;
    private String data_inicio;
    private String data_prevista_termino;
    private String status;
    private int numero_hora_prevista;
    private String lingugagem;
    
    public int getCod_projeto() {
        return cod_projeto;
    }

    public void setCod_projeto(int cod_projeto) {
        this.cod_projeto = cod_projeto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio = data_inicio;
    }

    public String getData_prevista_termino() {
        return data_prevista_termino;
    }

    public void setData_prevista_termino(String data_prevista_termino) {
        this.data_prevista_termino = data_prevista_termino;
    }

    public int getNumero_hora_prevista() {
        return numero_hora_prevista;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setNumero_hora_prevista(int numero_hora_prevista) {
        this.numero_hora_prevista = numero_hora_prevista;
    }

    public String getLingugagem() {
        return lingugagem;
    }

    public void setLingugagem(String lingugagem) {
        this.lingugagem = lingugagem;
    }

    public Projeto(int cod_projeto, String nome, String data_inicio, String data_prevista_termino, String status, int numero_hora_prevista, String lingugagem) throws SQLException{
        this.setCod_projeto(cod_projeto);
        this.setNome(nome);
        this.setData_inicio(data_inicio);
        this.setData_prevista_termino(data_prevista_termino);
        this.setStatus(status);
        this.setNumero_hora_prevista(numero_hora_prevista);
        this.setLingugagem(lingugagem);
        
        //call method to pull data to DB
        this.insertDml();
    }
    
    
    @Override
    public void insertDml() throws SQLException{
        String insertProjectDML = "USE UpperComputers INSERT INTO [UpperComputers].[Project].[projeto] (cod_projeto, nome, data_inicio,data_prevista_termino,status,numero_hora_prevista,linguagem) "
        + "VALUES("
            +this.getCod_projeto()
            +", '" + this.getNome() + "' "
            +", '" + this.getData_inicio() + "' "
            +", '" + this.getData_prevista_termino() + "' "
            +", '" + this.getStatus() + "' "
            +", '" + this.getNumero_hora_prevista() + "' "
            +", '" + this.getLingugagem() + "' "
        +")";
        
        super.insertStatement(insertProjectDML);
    }
    
    
}
