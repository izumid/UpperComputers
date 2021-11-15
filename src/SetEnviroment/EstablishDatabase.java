package SetEnviroment;
import Conn.SqlConn;
import java.sql.Statement;
import java.sql.SQLException;

public class EstablishDatabase{

   //SqlConn conn = null;
   //connection = SqlConn.getNewConnection();
    //SqlConn conect = new SqlConn();
    //conect.getNewConnection();
    
    //SqlConn  db = new SqlConn();    //it's working
    //db.getNewConnection();          //it's working
    
    SqlConn conect = new SqlConn();
    
    public void  createDb() throws SQLException{
    
        
        String sqlCreate =
"       /* ========================= CREATING DATABASE COMMANDS ========================= */    "   
+"      USE master IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'UpperComputers')    "
+"          BEGIN                                                                               "
+"              CREATE DATABASE UpperComputers                                                  "
+"          END;                                                                                ";  

        try{
            Statement stmt = conect.getNewConnection().createStatement();
            stmt.executeUpdate(sqlCreate);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
     
    }
     
    
    public void  createTables() throws SQLException{
   
        String sqlCreate = 
"       /* ========================= CREATING TABLES COMMANDS =========================  */                                                                                                         "  
+"	IF EXISTS (SELECT * FROM sys.databases WHERE name = 'UpperComputers')                                                                                                                       "
+"                                                                                                                                                                                                  "
+"		BEGIN                                                                                                                                                                               "
+"			USE UpperComputers;                                                                                                                                                         "
+"                                                                                                                                                                                                  "
+"			IF (NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'Employee'))                                                                                                         "
+"	 			BEGIN EXEC('CREATE SCHEMA [Employee] AUTHORIZATION [dbo]')                                                                                                          "
+"			END                                                                                                                                                                         "
+"                                                                                                                                                                                                  "
+"			IF (NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'Role'))                                                                                                             "
+"	 			BEGIN EXEC('CREATE SCHEMA [Role]    AUTHORIZATION [dbo]')                                                                                                           "
+"			END                                                                                                                                                                         "
+"                                                                                                                                                                                                  "
+"			IF (NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'Project'))                                                                                                          "
+"	 			BEGIN EXEC('CREATE SCHEMA [Project] AUTHORIZATION [dbo]')                                                                                                           "
+"			END                                                                                                                                                                         "
+"                                                                                                                                                                                                  "
+"			IF (NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'Tool'))                                                                                                             "
+"				BEGIN EXEC('CREATE SCHEMA  [Tool]	 AUTHORIZATION [dbo]')                                                                                                      "
+"			END                                                                                                                                                                         "
+"                                                                                                                                                                                                  "
+"			IF (NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'History'))                                                                                                          "
+"				BEGIN EXEC('CREATE SCHEMA  [History]	 AUTHORIZATION [dbo]')                                                                                                      "
+"			END                                                                                                                                                                         "
+"                                                                                                                                                                                                  "
+"                                                                                                                                                                                                  "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='cargo' and xtype='U')                                                                                                   "
+"	 			CREATE TABLE [Role].[cargo](                                                                                                                                        "
+"	 				cod_cargo				INT		NOT NULL,                                                                                           "
+"	 				nome    				VARCHAR(255)	NOT NULL,                                                                                           "
+"	 				salario 				FLOAT		NOT NULL,                                                                                           "
+"					CONSTRAINT PK_cargo                     PRIMARY KEY     (cod_cargo)                                                                                         "
+"	 			)                                                                                                                                                                   "
+"			IF NOT EXISTS (select * from sysobjects where name='recurso' and xtype='U')                                                                                                 "
+"	 			CREATE TABLE [Employee].[recurso] (                                                                                                                                 "
+"	 				numero_registro 			INT		NOT NULL,                                                                                           "
+"	 				nome 					VARCHAR(50)	NOT NULL,                                                                                           "
+"                                      ultimo_nome 				VARCHAR(50)	NOT NULL,                                                                                           "
+"	 				salario 				FLOAT		NOT NULL,                                                                                           "
+"					CONSTRAINT PK_numero_registro           PRIMARY KEY    (numero_registro),                                                                                   "
+"					cod_cargo 				INT             FOREIGN KEY REFERENCES [Role].[cargo](cod_cargo)                                                    "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='historicocargo' and xtype='U')                                                                                          "
+"	 			CREATE TABLE [History].[historicocargo](                                                                                                                            "
+"					cod_cargo 				INT		FOREIGN KEY REFERENCES [Role].[cargo](cod_cargo)  ON DELETE CASCADE,                                "
+"	 				numero_registro 			INT		FOREIGN KEY REFERENCES [Employee].[recurso](numero_registro) ON DELETE CASCADE,                     "
+"	 				data_alteracao				DATE		NOT NULL,                                                                                           "
+"                                      salario 				FLOAT		NOT NULL,                                                                                           "
+"	 				descricao				VARCHAR(255)	NOT NULL,                                                                                           "
+"					atual 					BIT		NOT NULL                                                                                            "
+"				)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='endereco' and xtype='U')                                                                                                "
+"	 			CREATE TABLE [Employee].[endereco](                                                                                                                                 "
+"					numero_registro                         INT              FOREIGN KEY REFERENCES [Employee].[recurso](numero_registro)  ON DELETE CASCADE,                   "
+"	 				cidade                                  VARCHAR(100)     NOT NULL,                                                                                          "
+"	 				estado                                  VARCHAR(100)     NOT NULL,                                                                                          "   
+"	 				cep                                     CHAR(10)         NOT NULL,                                                                                          "
+"	 				logradouro                              VARCHAR(100)     NOT NULL,                                                                                          "
+"	 				numero                                  CHAR(6)          NOT NULL,                                                                                          "   
+"	 				tipo                                    VARCHAR(20)      NOT NULL                                                                                           "
+"					CONSTRAINT PK_endereco          	PRIMARY KEY	(numero_registro, estado, cep, numero)                                                              "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='telefone' and xtype='U')                                                                                                "
+"	 			CREATE TABLE [Employee].[telefone](                                                                                                                                 "
+"					numero_registro                         INT             FOREIGN KEY REFERENCES [Employee].[recurso](numero_registro)  ON DELETE CASCADE,                    "
+"	 				codigo_area                             CHAR(2)         NOT NULL,                                                                                           "
+"	 				numero                                  CHAR(9)         NOT NULL,                                                                                           "
+"	 				tipo                                    VARCHAR(255)    NOT NULL                                                                                            "
+"					CONSTRAINT PK_telefone          	PRIMARY KEY	(numero_registro, numero)                                                                           "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='equipe' and xtype='U')                                                                                                  "
+"				CREATE TABLE [Project].[equipe] (                                                                                                                                   "
+"					cod_equipe 				INT		NOT NULL,                                                                                           "
+"					numero_registro 			INT 		NOT NULL,                                                                                           "
+"					nome    				VARCHAR(100)    NOT NULL,                                                                                           "
+"					quantidade_recursos                     INT 		NOT NULL,                                                                                           "
+"					CONSTRAINT PK_equipe                    PRIMARY KEY     (cod_equipe)                                                                                        "
+"			)                                                                                                                                                                           "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='ferramenta' and xtype='U')                                                                                              "
+"	 			CREATE TABLE [Tool].[ferramenta] (                                                                                                                                  "
+"	 				cod_ferramenta 				INT		NOT NULL,                                                                                           "
+"	 				nome            			VARCHAR(100)    NOT NULL,                                                                                           "
+"	 				versao          			VARCHAR(100)    NOT NULL,                                                                                           "
+"					CONSTRAINT PK_ferramenta                PRIMARY KEY    (cod_ferramenta)                                                                                     "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='programador_ferramenta' and xtype='U')                                                                                  "
+"	 			CREATE TABLE [Tool].[programador_ferramenta] (                                                                                                                      "
+"	 				numero_registro                         INT		FOREIGN KEY REFERENCES [Employee].[recurso](numero_registro)  ON DELETE CASCADE,                    "
+"	 				cod_ferramenta                          INT		FOREIGN KEY REFERENCES  [Tool].[ferramenta](cod_ferramenta)	ON DELETE CASCADE                   "
+"					CONSTRAINT PK_programador_ferramenta	PRIMARY KEY	(numero_registro, cod_ferramenta)                                                                   "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='projeto' and xtype='U')                                                                                                 "   
+"	 			CREATE TABLE [Project].[projeto] (                                                                                                                                  "
+"	 				cod_projeto 				INT 		NOT NULL,                                                                                           "
+"	 				nome            			VARCHAR(100)    NOT NULL,                                                                                           "
+"	 				data_inicio				DATE 		NOT NULL,                                                                                           "
+"	 				data_prevista_termino                   DATE 		NOT NULL,                                                                                           "
+"	 				[status]         			VARCHAR(100)    NOT NULL,                                                                                           "
+"	 				numero_hora_prevista                    INT             NOT NULL,                                                                                           "
+"					linguagem				VARCHAR(100)    NOT NULL,                                                                                           "
+"					CONSTRAINT PK_cod_projeto               PRIMARY KEY     (cod_projeto)                                                                                       "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='atividade' and xtype='U')                                                                                               "
+"	 			CREATE TABLE [Project].[atividade] (                                                                                                                                "
+"	 				cod_atividade 				INT 		NOT NULL,                                                                                           "
+"					nome            			VARCHAR(100)    NOT NULL                                                                                            "
+"					CONSTRAINT PK_atividade                          PRIMARY KEY     (cod_atividade)                                                                            "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			 IF NOT EXISTS (select * from sysobjects where name='projeto_atividade' and xtype='U')                                                                                      "
+"	 			CREATE TABLE [Project].[projeto_atividade] (                                                                                                                        "
+"	 				cod_projeto				INT		FOREIGN KEY	(cod_projeto) REFERENCES [Project].[projeto](cod_projeto) ON DELETE CASCADE,        "
+"	 				cod_atividade				INT		FOREIGN KEY	(cod_atividade) REFERENCES [Project].[atividade](cod_atividade) ON DELETE CASCADE   "
+"                                      CONSTRAINT PK_projeto_atividade         PRIMARY KEY	(cod_projeto, cod_atividade)                                                                        "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='projeto_finalizado' and xtype='U')                                                                                      "
+"	 			CREATE TABLE [Project].[projeto_finalizado] (                                                                                                                       "
+"					cod_projeto				INT		FOREIGN KEY	(cod_projeto) REFERENCES [Project].[projeto](cod_projeto) ON DELETE CASCADE,        "
+"	 				data_termino_real 			DATE 		NOT NULL,                                                                                           "
+"					numero_hora_real_utilizada              INT 		NOT NULL                                                                                            "
+"                                      CONSTRAINT PK_projeto_finalizado        PRIMARY KEY	(cod_projeto)                                                                                       "
+"				)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"			IF NOT EXISTS (select * from sysobjects where name='tarefa' and xtype='U')                                                                                                  "
+"	 			CREATE TABLE [Project].[tarefa] (                                                                                                                                   "
+"					cod_tarefa				INT		NOT NULL,                                                                                           "
+"	 				descricao                               VARCHAR(255)    NOT NULL,                                                                                           "
+"					CONSTRAINT PK_tarefa                    PRIMARY KEY     (cod_tarefa),                                                                                       "
+"					cod_atividade				INT		FOREIGN KEY	(cod_atividade) REFERENCES [Project].[atividade](cod_atividade) ON DELETE CASCADE   "
+"	 			)                                                                                                                                                                   "
+"                                                                                                                                                                                                  "
+"                                                                                                                                                                                                  "
+"	 END;                                                                                                                                                                                       ";
        try{
            Statement stmt = conect.getNewConnection().createStatement();
            stmt.executeUpdate(sqlCreate);
            stmt.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }  
}