package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Endereco extends InsertConnection implements InsertInto{
    private int numeroRegistro;
    private String logradouro;
    private String cidade;
    private String estado;
    private String tipo_endereco;
    private String cep;
    private String numero;
    
    public int getNumeroRegistro(){
        return this.numeroRegistro;
    }    
    public void setNumeroRegistro(int numeroRegistro){
        this.numeroRegistro = numeroRegistro;
    }

    public String getLogradouro(){
        return this.logradouro;
    }    
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public String getCidade(){
        return this.cidade;
    }    
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getEstado(){
        return this.estado;
    }    
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getCep(){
        return this.cep;
    }    
    public void setCep(String cep){
        this.cep = cep;
    }
    public String getNumero(){
        return this.numero;
    }    
    public void setNumero(String numero){
        this.numero = numero;
    }
    public String getTipo(){
        return this.tipo_endereco;
    }    
    public void setTipo(String tipo_endereco){
        this.tipo_endereco = tipo_endereco;
    }
        
    public Endereco(int numeroRegistro, String cidade, String estado, String cep, String logradouro, String numero, String tipo_endereco) throws SQLException {
            this.setNumeroRegistro(numeroRegistro);
            this.setCidade(cidade);
            this.setEstado(estado);
            this.setCep(cep);
            this.setLogradouro(logradouro);
            this.setNumero(numero);
            this.setTipo(tipo_endereco);
            
            this.insertDml();
    }
    
    public void insertDml() throws SQLException {

        String insertAddressDml = "Use UpperComputers INSERT INTO [UpperComputers].[Employee].[endereco] (numero_registro, cidade, estado, cep, logradouro, numero, tipo)"
                + "VALUES("
                + this.getNumeroRegistro()
                + ",'" + this.getCidade() + "' "
                + ",'" + this.getEstado() + "' "
                + ",'" + this.getCep() + "' "
                + ",'" + this.getLogradouro() + "' "
                + ",'" + this.getNumero() + "' "
                + ",'" + this.getTipo() + "' "
                + ")";
        
        super.insertStatement(insertAddressDml);

    }  
}