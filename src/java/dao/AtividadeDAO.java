/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import model.*;
import util.PropertiesManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Quele
 */

public class AtividadeDAO implements InterfaceDAO {

    private HashMap dados;
    
    public AtividadeDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        Atividade atividades = (Atividade) obj;        
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
   //     pstmt.setString(1, atividades.getIdAtividade());
        pstmt.setInt(1, atividades.getCodAluno());
        pstmt.setInt(2, atividades.getCodTipoAtividade());
        pstmt.setInt(3, atividades.getCodProfessor());
        pstmt.setString(4, atividades.getStatus());
        pstmt.execute();
        pstmt.close();
    }

    @Override
    public void excluir(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String remover(String codati) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Delete.Atividade");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.executeQuery(codati);
            retorno = "sucesso";
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
        
    }    

    @Override
    public ArrayList pesquisarTudo() throws SQLException {
      ArrayList ativList = new ArrayList();
      ativList = new AtividadeDAO.atividadeDouble().getListAtividades();
      return ativList;
   /*   Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectALL.Atividade");
      PreparedStatement pstmt = conexao.prepareStatement(sql);
      ResultSet rs = pstmt.executeQuery();
      
      while (rs.next()) {

          Atividade atividade = new Atividade(); 
          atividade.setIdAtividade(rs.getString(1));
          atividade.getAluno().setNomePessoa(rs.getString(1));
          atividade.getTipoAtividade().setDescricaoTipo(rs.getString(2));
          atividade.getProfessorResponsavel().setNomePessoa(rs.getString(3));
          atividade.setStatus(rs.getString(4));
          ativList.add(rs);
      }
       pstmt.close();
       return ativList;*/
    } 
    
    public Atividade pesquisarCod(String cod) throws SQLException {
      //ArrayList ativList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
        Atividade ativ = null;
        String sql = (String) dados.get("SelectById.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, cod);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            ativ = new Atividade(); 
            ativ.setIdAtividade(rs.getString(1));
            ativ.getAluno().setNomePessoa(rs.getString(2));
            ativ.getTipoAtividade().setDescricaoTipo(rs.getString(3));
            ativ.getProfessorResponsavel().setNomePessoa(rs.getString(4));
            ativ.setStatus(rs.getString(5));
        }
        pstmt.close();
        return ativ;
    }    

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public String editar(Atividade atividade) throws SQLException {
        String retorno = "erro";                 
        
        Connection conexao = DBConnection.getInstance();
        try{
            String sql = (String) dados.get("Update.Atividade");
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            
            pstmt.setString(1, atividade.getIdAtividade());
            pstmt.setString(2, atividade.getAluno().getNomePessoa());
            pstmt.setString(3, atividade.getTipoAtividade().getDescricaoTipo());
            pstmt.setString(4, atividade.getProfessorResponsavel().getNomePessoa());
            pstmt.setString(5, atividade.getStatus());
            pstmt.execute();
            retorno = "sucesso";
            pstmt.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return retorno;
    }
    
    class atividadeDouble {
        public ArrayList getListAtividades() {
            ArrayList atividades = new ArrayList();
            Atividade atividade;
         //   atividade = new Atividade(new Aluno("Johnny","teste","0120","2012"), new TipoAtividade("Estagio"), new Professor("Karen","teste","0012",Area.INFORMATICA), "P");
       //     atividades.add(atividade);
         //   atividade = new Atividade(new Aluno("Sheldon","teste","0120","2012"), new TipoAtividade("Pesquisa"), new Professor("Marcia","teste","0012",Area.INFORMATICA), "P");
       //     atividades.add(atividade);
           // atividade = new Atividade(new Aluno("Leonard","teste","0120","2012"), new TipoAtividade("Congresso"), new Professor("Cesar","teste","0012",Area.INFORMATICA), "P");
     //       atividades.add(atividade);
            return atividades;
        }
    }
    
}
