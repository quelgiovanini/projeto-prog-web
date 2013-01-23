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
import model.Funcionario;
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
    
    Connection conexao = DBConnection.getInstance();    
    String sql = (String) dados.get("Aluno.Inserir");
    PreparedStatement pstmt = conexao.prepareStatement(sql);
  //  pstmt.setInt(1,aluno.getCodPessoa());
    pstmt.setString(1, aluno.getNome());
    pstmt.setString(2, aluno.getRg());
    pstmt.setInt(3, aluno.getTipoPessoa());
    pstmt.setString(4, aluno.getNumeroMatricula());
   
    try {
            pstmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        pstmt.close();
    }

  @Override
  public void excluir(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  }  
 
      public String remover(String codal) throws SQLException {
        String retorno = "erro";                 

        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Delete.Aluno");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, codal);
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
      ArrayList alunoList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectAll.Aluno");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Aluno aluno = new Aluno(); 
          aluno.setCodPessoa(rs.getInt(1));
          aluno.setNome(rs.getString(2));
          aluno.setRg(rs.getString(3));
          aluno.setTipoPessoa(rs.getInt(4));
          aluno.setNumeroMatricula(rs.getString(5));

          alunoList.add(aluno);
      }
       pstmt.close();
       return alunoList;
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
            usu.setHorasAcumuladas(rs.getInt(3));
            
            if (usu.getHorasAcumuladas() < 72)
                alList.add(usu);
      }
       pstmt.close();
       return alList;
    } 

    public Aluno pesquisarCod(String codAlu) throws SQLException {
      //ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
        Aluno alu = null;
        String sql = (String) dados.get("SelectById.Aluno");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, codAlu);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            alu = new Aluno(); 
            alu.setCodPessoa(rs.getInt(1));
            alu.setNome(rs.getString(2));
            alu.setRg(rs.getString(3));
            alu.setTipoPessoa(rs.getInt(4));
            alu.setNumeroMatricula(rs.getString(5));
        }
        pstmt.close();
        return alu;
    }
  
    public String editar(Aluno aluno) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Update.Aluno");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setString(1, aluno.getNome());
            pstmt.setString(2, aluno.getRg());
            pstmt.setInt(3, aluno.getTipoPessoa());
            pstmt.setString(4, aluno.getNumeroMatricula());
            pstmt.setInt(5, aluno.getCodPessoa());            

            pstmt.execute();
            retorno = "sucesso";

            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return retorno;

    }
    
    public String editarhora(Aluno aluno) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("UpdateHora.Aluno");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setInt(1, aluno.getHorasAcumuladas());
            pstmt.setInt(2, aluno.getCodPessoa());            

            pstmt.execute();
            retorno = "sucesso";

            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        return retorno;

    }    
    
  @Override
  public void editar(Object obj) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet.");
  } 
  
}