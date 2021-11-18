package uppercomputers;

//Exception do SQL errors
import java.sql.SQLException;

//Create Database Objects
import SetEnviroment.EstablishDatabase;
 
//Insert's Classes
import Classes.Cargo;
import Classes.Recurso;
import Classes.Projeto;
import Classes.Atividade;
import Classes.Projeto_Atividade;
import Classes.Projeto_Finalizado;
import Classes.Tarefa;
import Classes.Endereco;
import Classes.Telefone;

import Classes.Ferramenta;
import Classes.Programador_Ferramenta;
import Classes.Equipe;

//DMLS
import DML.UpdateCargo;
import DML.DeleteData;


public class UpperComputers {
    public static void main(String[] args) throws SQLException{
    
        EstablishDatabase ed = new EstablishDatabase();
        ed.createDb();
        ed.createTables();

        //(Cod Project, Name, IntialDate, PreviousData, Status, HoursNumber, Language)
        Projeto projeto1 = new Projeto(19,"Celta Prata 20212 4 Portas","20210201","20250101","Em Andamento",17532,"Java");
      
        //(CodTask, Name)
        Atividade atividade1 = new Atividade(87, "Database");
        Atividade atividade2 = new Atividade(39, "Frontend");
        Atividade atividade3 = new Atividade(48, "Backend");
        Atividade atividade4 = new Atividade(17, "Software Engineering");
        Atividade atividade5 = new Atividade(26, "Maintenance");
        
        //(CodTask, CodActivity)
        Projeto_Atividade projetoAtividade1 = new Projeto_Atividade(19,87);
        Projeto_Atividade projetoAtividade2 = new Projeto_Atividade(19,39);
        Projeto_Atividade projetoAtividade3 = new Projeto_Atividade(19,48);
        Projeto_Atividade projetoAtividade4 = new Projeto_Atividade(19,17);
        Projeto_Atividade projetoAtividade5 = new Projeto_Atividade(19,26);

        //(CodProject, EndDate, HoursNumber
        Projeto_Finalizado projetoFinalizado = new Projeto_Finalizado(19, "20250101",17520);

        //(Cod Task, Cod Activity, Description)
        Tarefa tarefa1 = new Tarefa(20,87,"Analise De Requisitos");
        Tarefa tarefa2 = new Tarefa(21,87,"Modelo Realacional Desenvolvimento");
        Tarefa tarefa3 = new Tarefa(22,87,"Normalizacao");
        Tarefa tarefa4 = new Tarefa(23,87,"Modelo Fisico Desenvolvimento");
        Tarefa tarefa5 = new Tarefa(24,87,"Homologacao");
       
        //(Cod, Name, Salary)
        Cargo cargo1 = new Cargo(1, "Gerente",6225.87);
        Cargo cargo2 = new Cargo(2, "Gerente Jr",7954.54);
        Cargo cargo3 = new Cargo(3, "Gerente Pleno",8954.54);
        Cargo cargo4 = new Cargo(4, "Gerente Senior",9540.54);

        Cargo cargo5 = new Cargo(5, "Database Administrator",2152.55);
        Cargo cargo6 = new Cargo(6, "Database Administrator Jr",3278.87);
        Cargo cargo7 = new Cargo(7, "Database Administrator Pleno",4566.54);
        Cargo cargo8 = new Cargo(8, "Database Administrator Senior",6125.54);

        Cargo cargo9 = new Cargo(9,   "Programador Senior",5125.12);
        Cargo cargo10 = new Cargo(10, "Programador Pleno",3566.77);
        Cargo cargo11 = new Cargo(11, "Programador Jr",2789.88);
        Cargo cargo12 = new Cargo(12, "Assitente Programador",1850.87);
        Cargo cargo13 = new Cargo(13, "Faxineiro", 2000);

        //(ID,First Name,Last Name,Role)     
        Recurso recurso0 = new Recurso(111, "Beto",   "A", 11);
        Recurso recurso1 = new Recurso(222, "Joyce",  "B", 11);
        Recurso recurso2 = new Recurso(333, "Thiago", "C", 11);
        Recurso recurso3 = new Recurso(444, "Fabiro", "D", 11);


        //(ID,NewRole,OldRole, Description)
        UpdateCargo upt = new UpdateCargo(111,10,11,"Promocao");

        //(ID, City, State, ZipCode, StreetAdress, Number, PropertyType)
        Endereco endereco1 = new Endereco(111, "São Paulo", "São Paulo", "11111-111","Bastino Da Conceição","78","Residencial");

        //(ID, AreaCode, Number, NumberType)
        Telefone telefone1 = new Telefone(111,"11","911111111","Celular");

       //(IDTool, Language, Version)
        Ferramenta ferramenta1 = new Ferramenta(3154,"C#","8.45");

        //(ID,IDToll)
        Programador_Ferramenta programadorFerramenta1  = new Programador_Ferramenta(111,3154);
        
        //(CodTeam, ID, Name, MemberAmmount)
        Equipe equipe1 = new Equipe(54,111,"Caçadores de trolls",5);

        //Method to clean all tables data
       //DeleteData deleteData = new DeleteData();

        //Specific table to clean data SchemeName, TableName
       // DeleteData deleteData = new DeleteData("Project","projeto");

    }
    
}

