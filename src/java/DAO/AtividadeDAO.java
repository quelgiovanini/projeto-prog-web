/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Atividade;
import Database.DBConnection;
import Util.PropertiesManager;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
   //     Professor professores = (Professor) obj1;
  //      TipoAtividade tipos = (TipoAtividade) obj2;
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Insert.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, atividades.getAluno().getNome());
        pstmt.setString(2, atividades.getTipoAtividade().getDescricaoTipo());
        pstmt.setString(3, atividades.getProfessorResponsavel().getNome());
        pstmt.setString(4, atividades.getStatus());
        pstmt.execute();
        pstmt.close();
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
