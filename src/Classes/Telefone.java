package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Telefone extends InsertConnection implements InsertInto{
    private int numeroRegistro;
    private String codigo_area;
    private String telefone;
    private String tipo;
    
    public int getNumeroRegistro(){
        return this.numeroRegistro;
    }    
    public void setNumeroRegistro(int numeroRegistro){
        this.numeroRegistro = numeroRegistro;
    }

    public String getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(String codigo_area) {
        this.codigo_area = codigo_area;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public Telefone(int numeroRegistro,String codigo_area, String telefone, String tipo) throws SQLException {
        this.setNumeroRegistro(numeroRegistro);
        this.setCodigo_area(codigo_area);
        this.setTelefone(telefone);
        this.setTipo(tipo);
        
        this.insertDml();
    }
    
    public void insertDml() throws SQLException {
        String insertTelephoneDml = "USE UpperComputers INSERT INTO [UpperComputers].[Employee].[telefone] (numero_registro, codigo_area, numero, tipo) "
                + " VALUES( "
                + this.getNumeroRegistro()
                +",'" + this.getCodigo_area() + "' "
                +",'" + this.getTelefone() + "' "
                +",'" + this.getTipo() + "' "
                +")";
        
        super.insertStatement(insertTelephoneDml);
    }  
}
