/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Quele
 */
public class Curso implements Serializable {
    private Area area;
    private String nome;
    private Professor orientador;
    private int codCurso;
    private String sigla;
    
    public Curso() { }
    
    public Curso (Area area, String nome, Professor orientador){
        this.setArea(area);
        this.setNome(nome);
        this.setOrientador(orientador);
    }    

   public Curso getCurso() {
        return this;
    }

    public void setCurso(Curso cursos){
        this.setArea(cursos.getArea());
        this.setNome(cursos.getNome());
        this.setOrientador(cursos.getOrientador());
    }
        
    
    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public java.lang.String getNome() {
        return nome;
    }

    public void setNome(java.lang.String nome) {
        this.nome = nome;
    }

    public Professor getOrientador() {
        return orientador;
    }

    public void setOrientador(Professor orientador) {
        this.orientador = orientador;
    }
    
    public void setCodCurso(int codCurso){
        this.codCurso = codCurso;
    }
    
    public int getCodCurso(){
        return this.codCurso;
    }
    
    public void setSigla(String sigla){
        this.sigla = sigla;
    }
    
    public String getSigla(){
        return this.sigla;
    }
    
    @Override
    public String toString(){
        return ("Curso: " + getNome()+"\n");
    }
    
}
