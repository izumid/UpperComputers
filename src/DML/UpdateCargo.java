package DML;

import DML.InsertConnection;
import DML.InsertInto;
import java.sql.SQLException;


public class UpdateCargo extends InsertConnection implements InsertInto{
    private int newRoleCode;
    private int oldRoleCode;
    private int userID;
    private float newPaymentValue;
    private String description;
 
    public int getNewRoleCode() {
        return newRoleCode;
    }

    public void setNewRoleCode(int newRoleCode) {
        this.newRoleCode = newRoleCode;
    }

    public int getOldRoleCode() {
        return oldRoleCode;
    }

    public void setOldRoleCode(int oldRoleCode) {
        this.oldRoleCode = oldRoleCode;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }
    
    public float getNewPaymentValue() {
        return newPaymentValue;
    }

    public void setNewPaymentvalue(float newPaymentValue) {
        this.newPaymentValue = newPaymentValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public UpdateCargo(int userID, int newRoleCode, int oldRoleCode, String description) throws SQLException{
        this.setNewRoleCode(newRoleCode);
        this.setOldRoleCode(oldRoleCode);
        this.setUserID(userID);
        this.setDescription(description);
        
        this.insertDml();
    }
    @Override
    public void insertDml() throws SQLException{
        String setCurrentRoleAsOld =  
               "USE UpperComputers UPDATE [UpperComputers].[History].[historicocargo] SET [atual] = 0" 
               +" where [numero_registro] = "
               +  this.getUserID();
       

        String updateRoleDML =
                "Use UpperComputers UPDATE [UpperComputers].[Employee].[recurso] SET "
                + " salario = (SELECT salario FROM [UpperComputers].[Role].[cargo] WHERE cod_cargo = " + this.getNewRoleCode() +")"
                + " WHERE numero_registro = " 
                + this.getUserID();     

        String insertNewRole =
                "Use UpperComputers INSERT INTO [UpperComputers].[History].[historicocargo] (data_alteracao, descricao, salario, atual, cod_cargo, numero_registro)"
                + " VALUES( CAST(GETDATE() AS DATE), "
                + " '" + this.getDescription() + "' "
                +", (SELECT salario FROM [UpperComputers].[Role].[cargo] WHERE cod_cargo = " + this.getNewRoleCode() +") "
                +", 1 "
                +", " + this.getNewRoleCode() + " "
                + ", " +this.getUserID() + ") ";
        
        super.insertStatement(setCurrentRoleAsOld);
        super.insertStatement(updateRoleDML);
        super.insertStatement(insertNewRole);
  
      }
}
