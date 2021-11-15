package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Projeto_Finalizado extends InsertConnection implements InsertInto{
    private int cod_projeto;
    private String data_termino_real;
    private int hora_real;

    public int getHora_real() {
        return hora_real;
    }

    public void setHora_real(int hora_real) {
        this.hora_real = hora_real;
    }

    public int getCod_projeto() {
        return cod_projeto;
    }

    public void setCod_projeto(int cod_projeto) {
        this.cod_projeto = cod_projeto;
    }

    public String getData_termino_real() {
        return data_termino_real;
    }

    public void setData_termino_real(String data_termino_real) {
        this.data_termino_real = data_termino_real;
    }

    public Projeto_Finalizado(int cod_projeto, String data_termino_real, int horareal) throws SQLException {
        this.setCod_projeto(cod_projeto);
        this.setData_termino_real(data_termino_real);
        this.setHora_real(horareal);
        
        this.insertDml();
    }

    @Override
    public void insertDml() throws SQLException{
        String insertEndProjectDml = "Use UpperComputers INSERT INTO [UpperComputers].[Project].[projeto_finalizado] (cod_projeto, data_termino_real, numero_hora_real_utilizada) "
         + "VALUES("
             + " " + this.getCod_projeto()
             + ", '"+ this.getData_termino_real() + "' "
             + ", "+ this.getHora_real()
         +")";
                 
        super.insertStatement(insertEndProjectDml);
    }
    
}