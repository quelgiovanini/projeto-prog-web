package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import model.Funcionario;
import util.PropertiesManager;

/**
 *
 * @author Prado
 */
public class FuncionarioDAO implements InterfaceDAO {
  
  private HashMap dados;
  
  public FuncionarioDAO() throws IOException{
    dados = new PropertiesManager("sql.properties").readPropertiesFile();
  }

  @Override
  public void inserir(Object obj) throws SQLException {
    Funcionario func = (Funcionario) obj;
    PreparedStatement stmt;
    
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Funcionario.Inserir");
    stmt = conexao.prepareStatement(sql);
    stmt.setInt(1,func.getCodPessoa());
    stmt.setInt(2,func.getSetor());
    stmt.setInt(3,func.getCodTipoFuncionario());
    stmt.setInt(4,1);
    
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