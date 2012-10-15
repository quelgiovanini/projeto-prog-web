package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
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
    throw new UnsupportedOperationException("Not supported yet.");
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
