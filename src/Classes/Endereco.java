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

/* 
    static String nomesEstados[]={                                              // opção um, dois strings[] com os 27 estados  
        "Acre","Alagoas","Amapá","Amazonas","Bahia",
        "Ceará","Distrito Federal","Espírito Santo","Goiás",
        "Maranhão","Mato Grosso","Mato Grosso do Sul","Minas Gerais",
        "Pará","Paraíba","Paraná","Pernambuco",
        "Piauí","Rio de Janeiro","Rio Grande do Norte","Rio Grande do Sul",
        "Rondônia","Roraima","Santa Catarina","São Paulo","Sergipe","Tocantins"};
    static String siglasEstados[]={
        "AC","AL","AP","AM","BA","CE","DF","ES","GO",
        "MA","MT","MS","MG","PA","PB","PR","PE","PI",
        "RJ","RN","RS","RO","RR","SC","SP","SE","TO"};


    HashMap<String, String> estados = new HashMap<>();                          // opção dois, um HashMap com as 27 siglas e nomes das 27 UFs
        estados.put("AC", "Acre");
        estados.put("AL", "Alagoas");
        estados.put("AP", "Amapá");
        estados.put("AM", "Amazonas");
        estados.put("BA", "Bahia");
        estados.put("CE", "Ceará");
        estados.put("DF", "Distrito Federal");
        estados.put("ES", "Espírito Santo");
        estados.put("GO", "Goiás");
        estados.put("MA", "Maranhão");
        estados.put("MT", "Mato Grosso");
        estados.put("MS", "Mato Grosso do Sul");
        estados.put("MG", "Minas Gerais");
        estados.put("PA", "Pará");
        estados.put("PB", "Paraíba");
        estados.put("PR", "Paraná");
        estados.put("PE", "Pernambuco");
        estados.put("PI", "Piauí");
        estados.put("RJ", "Rio de Janeiro");
        estados.put("RN", "Rio Grande do Norte");
        estados.put("RS", "Rio Grande do Sul");
        estados.put("RO", "Rondônia");
        estados.put("RR", "Roraima");
        estados.put("SC", "Santa Catarina");
        estados.put("SP", "São Paulo");
        estados.put("SE", "Sergipe");
        estados.put("TO", "Tocantins");
     */