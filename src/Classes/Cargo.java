package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Cargo extends InsertConnection implements InsertInto{ 
    private int cod_cargo;
    private String nome_cargo;
    private double salario;

    public int getCod_cargo() {
        return cod_cargo;
    }

    public void setCod_cargo(int cod_cargo) {
        this.cod_cargo = cod_cargo;
    }

    public String getNome_cargo() {
        return nome_cargo;
    }

    public void setNome_cargo(String nome_cargo) {
        this.nome_cargo = nome_cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    
    public Cargo(int cod_cargo, String nome_cargo, double salario) throws SQLException{
        this.setCod_cargo(cod_cargo);
        this.setNome_cargo(nome_cargo);
        this.setSalario(salario);
        
        insertDml();
    }

    @Override
    public void insertDml() throws SQLException{
        String insertRoleDml = "Use UpperComputers INSERT INTO [UpperComputers].[Role].[cargo] (cod_cargo,nome, salario) "
         + "VALUES("
             + " " + this.getCod_cargo() + " " 
             + ",'"+ this.getNome_cargo()+ "'"  
             + "," + this.getSalario()
         +")";

        super.insertStatement(insertRoleDml);
    }
    
}
