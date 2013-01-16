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
import model.Atividade;
import model.Pessoa;
import model.Professor;
import model.Usuario;
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
    stmt.setString(2, aluno.getNome());
    stmt.setString(3, aluno.getRg());
    stmt.setInt(4, aluno.getTipoPessoa());
    stmt.setString(5, aluno.getNumeroMatricula());
//    stmt.setDate(6, aluno.getDataIngresso());// a data está hard coded por enquanto até usarmos alguma maneira de validar antes se a data foi digitada corretamente
   
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
      Aluno aluno = null;
      
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("Aluno.BuscaPorCod");
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      pstmt.setInt(1, chave);
      ResultSet rs = pstmt.executeQuery();
      if(rs.next()){
          aluno.setCodPessoa(rs.getInt(1));
    //      aluno.setIngresso(rs.getString(2));
     //     aluno.setNumMatricula(rs.getString(3));
      }
      return aluno;
  }

     public ArrayList pesquisarTipo() throws SQLException {
      ArrayList alList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectUser.Aluno");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            Aluno usu = new Aluno();
            usu.setCodPessoa(rs.getInt(1));
            usu.setNome(rs.getString(2));
            alList.add(usu);
      }
       pstmt.close();
       return alList;
    }  
  
  @Override
  public void editar(Object obj) throws SQLException {
        Aluno newAluno = (Aluno) obj;   
        Aluno oldAluno = (Aluno) pesquisarChave(newAluno.getCodPessoa()); 
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Aluno.Editar");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
    //    pstmt.setString(1, newAluno.getIngresso());
//        pstmt.setString(2, newAluno.getNumMatricula());
        pstmt.setInt(3, oldAluno.getCodPessoa());        
        pstmt.execute();
        pstmt.close();
  } 
  
}