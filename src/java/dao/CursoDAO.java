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

public class CursoDAO implements InterfaceDAO {

    private HashMap dados;
    
    public CursoDAO() throws IOException{
        
        dados = new PropertiesManager("sql.properties").readPropertiesFile();
        
    }    
    
    @Override
    public void inserir (Object obj) throws SQLException {
        Curso curso = (Curso) obj;        
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("Curso.Inserir");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setString(1, curso.getNome());
        pstmt.setInt(2, curso.getOrientador().getCodPessoa());
        pstmt.setString(3, curso.getSigla());
        pstmt.setInt(4, curso.getArea().ordinal());
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
    
    public Object pesquisarCod(String cod) throws SQLException {
 throw new UnsupportedOperationException("Not supported yet.");
    }    

    @Override
    public Object pesquisarChave(int chave) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void editar(Object newObj) throws SQLException {
 throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    /*
     * this methos gets the max number used for curso and semester
     * in case it is necessary to create more than one
     */
    public int getMaxNrSeqNumber(int codCurso, String semestreCurriculo) throws SQLException{
        int nrSeqNumber = 0;
                     
        Connection conexao = DBConnection.getInstance();
        String sql = (String) dados.get("SelectById.Atividade");
        PreparedStatement pstmt = conexao.prepareStatement(sql);
        pstmt.setInt(1, codCurso);
        pstmt.setString(2, semestreCurriculo);
        ResultSet rs = pstmt.executeQuery();
        
        if(rs.next()){
            nrSeqNumber = rs.getInt(1);
        }
        
        return nrSeqNumber;
    }
    
}
