/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Quele
 */

public class Curriculo {

    private String nomeCurriculo;
    private Curso curso;
    private int totalHoras;

    public Curriculo(String nomeCurriculo, Curso curso, int totalHoras){
        this.setNomeCurriculo(nomeCurriculo);
        this.setCurso(curso);
        this.setTotalHoras(totalHoras);
    }    
    
    public Curriculo(){
      
    }
    
    public Curriculo getCurriculo() {
        return this;
    }
    
    public void setCurriculo(Curriculo curriculos){
        this.setNomeCurriculo(curriculos.getNomeCurriculo());
        this.setCurso(curriculos.getCurso());
        this.setTotalHoras(curriculos.getTotalHoras());
    }    
    
    public java.lang.String getNomeCurriculo() {
        return nomeCurriculo;
    }

    public void setNomeCurriculo(java.lang.String nomeCurriculo) {
        this.nomeCurriculo = nomeCurriculo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(int totalHoras) {
        this.totalHoras = totalHoras;
    }
    
    @Override
        public String toString(){
        return("Nome curriculo: " + getNomeCurriculo() + 
                "\n" + getCurso() + 
                "Horas do curso: " + getTotalHoras() + "\n\n");
    }
        
}