package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import model.Aluno;
import model.Pessoa;
import util.PropertiesManager;

/**
 *
 * @author Prado
 */
public class AlunoDAO implements InterfaceDAO {
  
  private HashMap dados;
  
  public AlunoDAO() throws IOException{
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
  }

  @Override
  public void inserir(Object obj) throws SQLException {
    Aluno aluno = (Aluno) obj;
    PreparedStatement stmt;
    
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Aluno.Inserir");
    stmt = conexao.prepareStatement(sql);
    stmt.setInt(1,aluno.getCodPessoa());
    //stmt.setString(1, pessoa.getNomePessoa());
    //stmt.setString(2, pessoa.getRg());
    //stmt.setString(3, pessoa.getDataNascimento()); // a data está hard coded por enquanto até usarmos alguma maneira de validar antes se a data foi digitada corretamente
   
    stmt.execute();
    //conexao.close();
        
  }

  @Override
  public void excluir(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }  
 
  @Override
  public ArrayList pesquisarTudo() throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Object pesquisarChave(int chave) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void editar(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
}