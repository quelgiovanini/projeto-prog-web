/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.SQLException;

/**
 *
 * @author Quele
 */
public class Curso implements Serializable {
    private int codCurso;
    private String nome;
    private Area area = new Area();
    private Professor orientador = new Professor();
    private String sigla;
    private int codArea;
    private int codProfessor;
    
    public Curso() { }

    public Curso (int codCurso, String nome, Professor orientador, Area area) {
        this.setCodCurso(codCurso);
        this.setNome(nome);
        this.setOrientador(orientador);
        this.setArea(area);        
    }
    
    public Curso (int codCurso, String nome, int professor, int area) {
        this.setCodCurso(codCurso);
        this.setNome(nome);
        this.setCodProfessor(professor);
        this.setCodArea(area);
    }  
    
    public Curso (String _nome, int _professor, int _area) {
      //  this.setCodCurso(codCurso);
        //this.setNome(nome);
        //this.setCodProfessor(professor);
        //this.setArea(area);
        this.nome = _nome;
        this.codProfessor = _professor;
        this.codArea = _area;
    }     
    
    public Curso(Integer codCurso) {
        this.setCodCurso(codCurso);
    }
    
    public Curso getCurso() {
        return this;
    }
    
    public void setCurso(Curso cursos) {
        this.setCodCurso(cursos.getCodCurso());
        this.setNome(cursos.getNome());
        this.setOrientador(cursos.getOrientador());
        this.setArea(cursos.getArea());
        
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }    
    
    public int getCodProfessor() {
        return codProfessor;
    }

    public void setCodProfessor(int codProfessor) {
        this.codProfessor = codProfessor;
    }
    
    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int area) {
        this.codArea = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
/*
    public Integer getCodProfessor() throws SQLException {
        return  this.orientador.getCodPessoa();
    }
    
    public void setCodProfessor(Integer codProfessor) {
        this.orientador.setCodPessoa(codProfessor);
    }    
    */
    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
 
    @Override
    public String toString(){
        return ("Curso: " + getNome()+"\n");
    }  
    
}
