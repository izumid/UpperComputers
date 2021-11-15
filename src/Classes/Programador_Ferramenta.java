package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Programador_Ferramenta extends InsertConnection implements InsertInto{
    private int numero_registro;
    private int cod_ferramenta;

    public int getNumero_registro() {
        return numero_registro;
    }

    public void setNumero_registro(int numero_registro) {
        this.numero_registro = numero_registro;
    }

    public int getCod_ferramenta() {
        return cod_ferramenta;
    }

    public void setCod_ferramenta(int cod_ferramenta) {
        this.cod_ferramenta = cod_ferramenta;
    }
    
    public Programador_Ferramenta(int numero_registro, int cod_ferramenta) throws SQLException {
        this.setCod_ferramenta(cod_ferramenta);
        this.setNumero_registro(numero_registro);
        
        this.insertDml();
    }


    public void insertDml() throws SQLException{
       String insertProgrammerToolDml = "USE UpperComputers INSERT INTO [UpperComputers].[Tool].[programador_ferramenta] (cod_ferramenta,  numero_registro) "
            + "VALUES("
               + "  (SELECT cod_ferramenta FROM [UpperComputers].[Tool].[ferramenta] WHERE cod_ferramenta = " + this.getCod_ferramenta() +") "
               + ", (SELECT numero_registro FROM [UpperComputers].[Employee].[recurso] WHERE numero_registro = " + this.getNumero_registro() +") "                  
               +" ) ";
        
        super.insertStatement(insertProgrammerToolDml);
    }
       
   }