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
    private int area;
    private Professor orientador = new Professor();
    private String sigla;
    
    public Curso() { }

    public Curso (int codCurso, String nome, int area, Professor orientador) {
        this.setCodCurso(codCurso);
        this.setNome(nome);
        this.setArea(area);
        this.setOrientador(orientador);
    }
    
    public Curso (int codCurso, String nome, int area, int professor) {
        this.setCodCurso(codCurso);
        this.setNome(nome);
        this.setArea(area);
        this.setCodProfessor(professor);
    }  
    
    public Curso (String nome, int area, int professor) {
      //  this.setCodCurso(codCurso);
        this.setNome(nome);
        this.setArea(area);
        this.setCodProfessor(professor);
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
        this.setArea(cursos.getArea());
        this.setOrientador(cursos.getOrientador());
    }
    
    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodProfessor() throws SQLException {
        return  this.orientador.getCodPessoa();
    }
    
    public void setCodProfessor(Integer codProfessor) {
        this.orientador.setCodPessoa(codProfessor);
    }    
    
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
