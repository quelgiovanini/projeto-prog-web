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
    Funcionario funcionario = null;
      
    Connection conexao = DBConnection.getInstance();
    String sql = (String) dados.get("Funcionario.BuscaPorCod");
    PreparedStatement pstmt = conexao.prepareStatement(sql);
    pstmt.setInt(1, chave);
    ResultSet rs = pstmt.executeQuery();
    if(rs.next()){
        funcionario.setCodPessoa(rs.getInt(1));
        funcionario.setSetor(rs.getInt(2));
        funcionario.setTipoFuncionario(rs.getInt(3));
    }
    return funcionario;
  }

  @Override
  public void editar(Object obj) throws SQLException {
    Funcionario newFunc = (Funcionario) obj;   
    Funcionario oldFunc = (Funcionario) pesquisarChave(newFunc.getCodPessoa()); 

    Connection conexao = DBConnection.getInstance();
    String sql = (String) dados.get("Aluno.Update");
    PreparedStatement pstmt = conexao.prepareStatement(sql);
    pstmt.setInt(1, newFunc.getSetor());
    pstmt.setInt(2, newFunc.getCodTipoFuncionario());
    pstmt.setInt(3, newFunc.getCurso().getCodCurso());
    pstmt.setInt(4, oldFunc.getCodPessoa());
    
    pstmt.execute();
    pstmt.close();
  }
  
}