package database;

import java.io.*;
import java.sql.*; // para manipulação do JDBC

/**
 * Classe responsável pelo gerenciamento da conexão com o banco de dados
 */
public class DBConnection {

    //Atributos para manipulação do BD
    private static String user;
    private static String password;
    private String driver;
    private static String url;
    private static Connection conexao;

    /**
     * M�todo do padr�o Singleton.
     * Se a conex�o n�o existir, cria e retorna.
     * Caso contr�rio retorna o objeto de conex�o j� existente.
     * @param user Usu�rio de conex�o com o banco de dados
     * @param password Senha de conex�o com o banco de dados
     * @param driver Driver de conex�o com o banco de dados
     * @param url URL de conex�o com o banco de dados
     * @return Objeto de conex�o
     * @throws java.lang.ClassNotFoundException Exce��o gerada em caso de problemas com o driver do banco de dados
     */
    public DBConnection(String user, String senha, String driver, String url) throws ClassNotFoundException {
        this.user = user;
        this.password = senha;
        this.driver = driver;
        this.url = url;
        Class.forName(driver); //carrega o drive. Pode gerar ClassNotFoundException
    }
    
    public static Connection getInstance() throws SQLException{
         if (conexao == null) {
            openConnection();
        }
        return conexao;
    }

    private static void openConnection() throws SQLException{ 
        conexao = DriverManager.getConnection(url, user, password); // abre a conex�o para esta URL usando o driver carregado na linha anterior
        
    }

    /**
     * M�todo que fecha a conex�o.
     * @throws java.sql.SQLException Exce��o gerada em caso de problema no momento de encerrar a conex�o
     */
    public static void closeConnection() throws SQLException {
        if (conexao != null) {
            conexao.close();
            conexao = null;
        }
    }
}