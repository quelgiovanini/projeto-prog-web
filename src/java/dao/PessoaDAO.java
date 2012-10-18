package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import model.Pessoa;
import util.PropertiesManager;

/**
 *
 * @author Prado
 */
public class PessoaDAO implements InterfaceDAO {
  
  private HashMap dados;
  
  public PessoaDAO() throws IOException{
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
  }

  @Override
  public void inserir(Object obj) throws SQLException {
    Pessoa pessoa = (Pessoa) obj;
    
    Connection conexao = DBConnection.getInstance();
    
    String sql = (String) dados.get("Pessoa.Inserir");
        
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, pessoa.getNomePessoa());
        stmt.setString(2, pessoa.getRg());        
        stmt.setString(3, pessoa.getDataNascimento());
        stmt.execute();
        conexao.close();
            
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
