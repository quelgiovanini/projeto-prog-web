/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Aplicando padrão JavaBean
 * @author Quele
 */

public class Aluno implements Serializable {
     private int codPessoa;
     private String nome;
     private String rg;
     private int tipoPessoa;
     private String numeroMatricula;
     private Date dataIngresso;
     private int horasAcumuladas;
     private Curriculo curriculo = new Curriculo();

     public Aluno () {}
     
     public Aluno(int codPessoa, String nome, String rg, int tipoPessoa, String numeroMatricula, Date dataIngresso, int horasAcumuladas) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setNumeroMatricula(numeroMatricula);
        this.setDataIngresso(dataIngresso);
        this.setHorasAcumuladas(horasAcumuladas);
    }    

     public Aluno(int codPessoa, String nome, String rg, int tipoPessoa, String numeroMatricula, Date dataIngresso) {
        this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setNumeroMatricula(numeroMatricula);
        this.setDataIngresso(dataIngresso);
    //    this.setHorasAcumuladas(horasAcumuladas);
    }               
     
     public Aluno (int cod, String nome, String rg, String mat, Date data) {
         this.codPessoa = cod;
         this.nome = nome;
         this.rg = rg;
         this.numeroMatricula = mat;
         this.dataIngresso = data;
     }
     
     public Aluno(String nome, String rg, int tipoPessoa, String numeroMatricula, Date dataIngresso) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setNumeroMatricula(numeroMatricula);
        this.setDataIngresso(dataIngresso);
    //    this.setHorasAcumuladas(horasAcumuladas);
    }       
     
     public Aluno(String nome, String rg, int tipoPessoa, String numeroMatricula) {
     //   this.setCodPessoa(codPessoa);
        this.setNome(nome);
        this.setRg(rg);
        this.setTipoPessoa(tipoPessoa);
        this.setNumeroMatricula(numeroMatricula);
      //  this.setDataIngresso(dataIngresso);
    //    this.setHorasAcumuladas(horasAcumuladas);
    }       
     
    public Aluno (int cod, String nome, String rg, String mat, Date data) {
         this.codPessoa = cod;
         this.nome = nome;
         this.rg = rg;
         this.numeroMatricula = mat;
         this.dataIngresso = data;
     }     
     
     public Aluno (int codPessoa) {
         this.setCodPessoa(codPessoa);
     }
     
     public Aluno getAluno() {
         return this;
     }
     
    public void setAluno(Aluno alunos) {
        this.setCodPessoa(alunos.getCodPessoa());
        this.setNome(alunos.getNome());
        this.setRg(alunos.getRg());
        this.setTipoPessoa(alunos.getTipoPessoa());
        this.setNumeroMatricula(alunos.getNumeroMatricula());
        this.setDataIngresso(alunos.getDataIngresso());
    }     
     
    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(int tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public Date getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(Date dataIngresso) {
        this.dataIngresso = dataIngresso;
    }

    public int getHorasAcumuladas() {
        return horasAcumuladas;
    }

    public void setHorasAcumuladas(int horasAcumuladas) {
        this.horasAcumuladas = horasAcumuladas;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
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
    
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("<b>" + super.toString() + "</b><br>" +
                      this.getDataIngresso()  + "<br>" + 
                      this.getHorasAcumuladas()  + "<br><br>" );
        return buffer.toString();    
    } 
}
