/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author Quele
 */

public class Atividade {
    private Aluno aluno = null;
    private String idAtividade = null;
    private TipoAtividade tipoAtividade;
    private int horasRequisitadas = 0; 
    private int horasAceitas = 0;
    private Date dataRequisicao = null;
    private Funcionario funcionarioResponsavel = null;
    private Date dataAvaliacao = null;
    private Professor professorResponsavel = null;
    private String status = " ";
    private String observacao = null;
    
    public Atividade(Aluno aluno, String idAtividade, Date dataRequisicao, TipoAtividade tipoAtividade, int horasRequisitadas, Funcionario funcionario, String obs){
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
    
    public Atividade(Aluno aluno, TipoAtividade tipoAtividade, Professor professorResponsavel, String status){
        this.setAluno(aluno);
    //    this.setIdAtividade(idAtividade);
     //   this.setDataRequisicao(dataRequisicao);
        this.setTipoAtividade(tipoAtividade);
     //   this.setHorasRequisitadas(horasRequisitadas);
        this.setProfessorResponsavel(professorResponsavel);
     //   this.setObservacao(obs);
        this.setStatus(status);
      //this.professorResponsavel = tipoAtividade.getCurso().getProfessor();
    }    
    
    public Atividade getNoticia() {
        return this;
    }

    public void setNoticia(Atividade atividades){
        this.setAluno(atividades.getAluno());
        this.setIdAtividade(atividades.getIdAtividade());
        this.setDataRequisicao(atividades.getDataRequisicao());
        this.setTipoAtividade(atividades.getTipoAtividade());
        this.setHorasRequisitadas(atividades.getHorasRequisitadas());
        this.setFuncionarioResponsavel(atividades.getFuncionarioResponsavel());
        this.setObservacao(atividades.getObservacao());        
        this.setStatus(atividades.getStatus());        
    }    
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public java.lang.String getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(java.lang.String idAtividade) {
        this.idAtividade = idAtividade;
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
        return ("Aluno: " + getAluno().getNome() + 
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
