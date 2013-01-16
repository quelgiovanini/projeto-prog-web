/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.Atividade;
import model.TipoAtividade;
import util.PropertiesManager;

/**
 *
 * @author Quele
 */
public class TipoAtividadeDAO implements InterfaceDAO {
    

    private HashMap dados;
    
    public TipoAtividadeDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        TipoAtividade tipos = (TipoAtividade) obj;        
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Tipo");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
   //     pstmt.setString(1, atividades.getIdAtividade());
        pstmt.setInt(1, tipos.getIdTipo());
        pstmt.setString(2, tipos.getDescricaoTipo());
        pstmt.setDouble(3, tipos.getProporcao());
        pstmt.setInt(4, tipos.getMaximoPermitido());
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
      ArrayList tipoList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectAll.Tipo");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

          TipoAtividade tipos = new TipoAtividade(); 
          tipos.setIdTipo(rs.getInt(1));
          tipos.setDescricaoTipo(rs.getString(2));
          tipos.setProporcao(rs.getDouble(3));
          tipos.setMaximoPermitido(rs.getInt(4));
          tipoList.add(tipos);
      }
       pstmt.close();
       return tipoList;
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
            ativ.setIdAtividade(rs.getInt(1));
            ativ.getAluno().setNome(rs.getString(2));
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
            
            pstmt.setInt(1, atividade.getIdAtividade());
            pstmt.setString(2, atividade.getAluno().getNome());
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
    
    public ArrayList pesquisarTipo() throws SQLException {
      ArrayList tipoList = new ArrayList();
      Connection conexao = DBConnection.getInstance();
      String sql = (String) dados.get("SelectTipo.Tipo");
      PreparedStatement pstmt = conexao.prepareStatement(sql) ;
      ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
            TipoAtividade tipo = new TipoAtividade();
            tipo.setIdTipo(rs.getInt(1));
            tipo.setDescricaoTipo(rs.getString(2));
            tipoList.add(tipo);
      }
       pstmt.close();
       return tipoList;
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
