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
import model.Setor;
import util.PropertiesManager;

/**
 *
 * @author Quele
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
  //  stmt.setInt(1,func.getCodPessoa());
    stmt.setString(1, func.getNome());
    stmt.setString(2, func.getRg());
    stmt.setInt(3, func.getTipoPessoa());
    stmt.setInt(4, func.getCodSetor());
   
    stmt.execute();
    //conexao.close();
        
  }

  @Override
  public void excluir(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }  
 
    public String remover(String codf) throws SQLException {
        String retorno = "erro";                 

        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Delete.Funcionario");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, codf);
            pstmt.execute();
            retorno = "sucesso";
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
        
    }     
  
    @Override
    public ArrayList pesquisarTudo() throws SQLException {
      ArrayList funcList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectAll.Funcionario");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Funcionario funcionario = new Funcionario(); 
          funcionario.setNome(rs.getString(1));
          funcionario.setRg(rs.getString(2));
          funcionario.setTipoPessoa(rs.getInt(3));
          funcionario.setCodSetor(rs.getInt(4));
          funcionario.setCodPessoa(rs.getInt(5));

          funcList.add(funcionario);
      }
       pstmt.close();
       return funcList;
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

    pstmt.setInt(3, newFunc.getCurso().getCodCurso());
    pstmt.setInt(4, oldFunc.getCodPessoa());
    
    pstmt.execute();
    pstmt.close();
  }
  
       public ArrayList pesquisarSetor() throws SQLException {
      ArrayList setList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectSetor.Funcionario");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            Setor f = new Setor();
            f.setCodSetor(rs.getInt(1));
            f.getNomeSetor(rs.getString(2));
            setList.add(f);
      }
       pstmt.close();
       return setList;
    }
  
}