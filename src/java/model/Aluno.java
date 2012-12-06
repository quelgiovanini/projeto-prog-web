/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Aplicando padrão JavaBean
 * @author Quele
 */

public class Aluno extends Pessoa implements Serializable {
    
     private String ingresso;
     private String numeroMatricula;
   //  private ArrayList atividades = new ArrayList();
     private int horasAcumuladas;
     private Curriculo curriculo;
    
    public Aluno(String nome, String email, String matricula, String ingresso, Curriculo curriculo){
        super(nome, email, matricula);
        this.setIngresso(ingresso);
        this.setCurriculo(curriculo);
    }
    
    public Aluno(int codPessoa, String nome, String email, String matricula, String ingresso){
        super(codPessoa, nome, email, matricula);
        this.setIngresso(ingresso);
        
    }
    
    public Aluno(String nome, String email, String matricula, String ingresso){
        super(nome, email, matricula);
        this.setIngresso(ingresso);
     //   this.setCurriculo(curriculo);
    }
    
    public Aluno () {
        
    }
    public Aluno getAluno() {
        return this;
    }    
    
    public void setAluno(Aluno alunos){
        this.setPessoa(this);
        this.setIngresso(alunos.getIngresso());
        this.setCurriculo(alunos.getCurriculo());
    }    
    
    public java.lang.String getIngresso() {
        return ingresso;
    }

    public void setIngresso(java.lang.String ingresso) {
        this.ingresso = ingresso;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public int getHorasAcumuladas() {
        return horasAcumuladas;
    }
    
    public void setNumMatricula(String matricula){
        this.numeroMatricula = matricula;
    }
    
    public String getNumMatricula(){
        return this.numeroMatricula;
    }
    
    public int addHoras(int valor){
        if (curriculo.getTotalHoras() > valor)
            horasAcumuladas+=valor;
        else{
            System.out.println("Horas acima do limite permitido.");
        }
        if (horasAcumuladas > curriculo.getTotalHoras())
            System.out.println("Total de horas ultrapassaram o limite");
        
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(int horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }
    
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<b>" + super.toString() + "</b><br>" +
                      this.getIngresso()  + "<br>" + 
                      this.getHorasAcumuladas()  + "<br><br>" );
        return buffer.toString();    
    } 
}
