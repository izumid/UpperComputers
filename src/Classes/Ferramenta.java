package Classes;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;

public class Ferramenta extends InsertConnection implements InsertInto{
    private int cod_ferramenta;
    private String nome;
    private String versao;

    public int getCod_ferramenta() {
        return cod_ferramenta;
    }

    public void setCod_ferramenta(int cod_ferramento) {
        this.cod_ferramenta = cod_ferramento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }


    public Ferramenta(int cod_ferramento, String nome, String versao) throws SQLException{
        this.cod_ferramenta = cod_ferramento;
        this.nome = nome;
        this.versao = versao;
                
        this.insertDml();
    }

    @Override
    public void insertDml() throws SQLException{
        String insertToolDml = "Use UpperComputers INSERT INTO [UpperComputers].[Tool].[ferramenta] (cod_ferramenta, nome, versao) "
            + "VALUES("
                + this.getCod_ferramenta() 
                + " ,'" + this.getNome() + "' " 
                + " , '"+ this.getVersao()  +"' "
            +")";
            
        super.insertStatement(insertToolDml);
    }

    
}