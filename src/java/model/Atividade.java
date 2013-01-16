/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 * @author Quele
 */

public class Atividade implements Serializable {
    private int idAtividade;
    private Aluno aluno = new Aluno();
    private TipoAtividade tipoAtividade = new TipoAtividade();
    private int horasRequisitadas = 0; 
    private int horasAceitas = 0;
    private Date dataRequisicao = null;
    private Funcionario funcionarioResponsavel = new Funcionario();
    private Date dataAvaliacao = null;
    private Professor professorResponsavel = new Professor();
    private String status = " ";
    private String observacao = null;

    public Atividade () { }
    
    public Atividade(Aluno aluno, int idAtividade, Date dataRequisicao, TipoAtividade tipoAtividade, int horasRequisitadas, Funcionario funcionario, String obs){
        this.setAluno(aluno);
        this.setIdAtividade(idAtividade);
        this.setDataRequisicao(dataRequisicao);
        this.setTipoAtividade(tipoAtividade);
        this.setHorasRequisitadas(horasRequisitadas);
        this.setFuncionarioResponsavel(funcionario);
        this.setObservacao(obs);
        this.setStatus("E");
      //this.professorResponsavel = tipoAtividade.getCurso().getProfessor();
    }
    
    public Atividade(Integer aluno, Integer tipoAtividade, Integer professorResponsavel, String status){
       // this.setIdAtividade(idAtividade);
        this.setCodAluno(aluno);
    //    this.setIdAtividade(idAtividade);
     //   this.setDataRequisicao(dataRequisicao);
        this.setCodTipoAtividade(tipoAtividade);
     //   this.setHorasRequisitadas(horasRequisitadas);
        this.setCodProfessor(professorResponsavel);
     //   this.setObservacao(obs);
        this.setStatus(status);
      //this.professorResponsavel = tipoAtividade.getCurso().getProfessor();
    }    

        
    public Atividade(Integer idAtividade, Integer aluno, Integer tipoAtividade, Integer professorResponsavel, String status){
        this.setIdAtividade(idAtividade);
        this.setCodAluno(aluno);
    //    this.setIdAtividade(idAtividade);
     //   this.setDataRequisicao(dataRequisicao);
        this.setCodTipoAtividade(tipoAtividade);
     //   this.setHorasRequisitadas(horasRequisitadas);
        this.setCodProfessor(professorResponsavel);
     //   this.setObservacao(obs);
        this.setStatus(status);
      //this.professorResponsavel = tipoAtividade.getCurso().getProfessor();
    } 
    
    public Atividade getAtividade() {
        return this;
    }

    public void setAtividade(Atividade atividades){
        this.setIdAtividade(atividades.getIdAtividade());
        this.setAluno(atividades.getAluno());
     //   this.setDataRequisicao(atividades.getDataRequisicao());
        this.setTipoAtividade(atividades.getTipoAtividade());
   //     this.setHorasRequisitadas(atividades.getHorasRequisitadas());
        this.setProfessorResponsavel(atividades.getProfessorResponsavel());
  //      this.setObservacao(atividades.getObservacao());        
        this.setStatus(atividades.getStatus());        
    }    

    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }
    
    public Integer getCodAluno() throws SQLException {
        return aluno.getCodPessoa();
    }
    
    public void setCodAluno(Integer codAluno) {
        this.aluno.setCodPessoa(codAluno);
    }
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Integer getCodTipoAtividade() {
        return tipoAtividade.getIdTipo();
    }
    
    public void setCodTipoAtividade(Integer idTipo) {
        this.tipoAtividade.setIdTipo(idTipo);
    }
    
    public TipoAtividade getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(TipoAtividade tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public int getHorasRequisitadas() {
        return horasRequisitadas;
    }

    public void setHorasRequisitadas(int horasRequisitadas) {
        this.horasRequisitadas = horasRequisitadas;
    }

    public int getHorasAceitas() {
        return horasAceitas;
    }

    public void setHorasAceitas(int horasAceitas) {
        this.horasAceitas = horasAceitas;
    }

    public Date getDataRequisicao() {
        return dataRequisicao;
    }

    public void setDataRequisicao(Date dataRequisicao) {
        this.dataRequisicao = dataRequisicao;
    }

    public Funcionario getFuncionarioResponsavel() {
        return funcionarioResponsavel;
    }

    public void setFuncionarioResponsavel(Funcionario funcionarioResponsavel) {
        this.funcionarioResponsavel = funcionarioResponsavel;
    }

    public Date getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Date dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Professor getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(Professor professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

   public Integer getCodProfessor() throws SQLException {
        return professorResponsavel.getCodPessoa();
    }
    
    public void setCodProfessor(Integer codProfessor) {
        this.professorResponsavel.setCodPessoa(codProfessor);
    }
    
    
    public java.lang.String getStatus() {
        return status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public java.lang.String getObservacao() {
        return observacao;
    }

    public void setObservacao(java.lang.String observacao) {
        this.observacao = observacao;
    }

    public String toString(){
        return ("Aluno: " + getAluno().getNomePessoa() + 
                "\nHoras Requisitadas: " + getHorasRequisitadas() +
                "\nHoras Aceitas: " + getHorasAceitas() +
                "\nData de Requisição: " + getDataRequisicao() +
        //        "\nFuncionário Responsável: " + funcionarioResponsavel.getNome() +
                "\nData de Avaliação: " + getDataAvaliacao() +
        //        "\nProfessor Responsável: " + professorResponsavel.getNome() +
                "\nStatus: " + getStatus() +
                "\nObservação: " + getObservacao() + "\n\n");
    }    
    
}
