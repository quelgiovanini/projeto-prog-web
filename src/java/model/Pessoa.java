package model;

import java.util.Date;

public class Pessoa {
    
    private int codPessoa;
    private String nomePessoa;
    private String rg;
    private Date dataNascimento;

    public Pessoa() {
        
    }
    
    public Pessoa(int codPessoa, String nomePessoa, String rg, Date dataNascimento) {
        this.codPessoa = codPessoa;
        this.nomePessoa = nomePessoa;
        this.rg = rg;
        this.dataNascimento = dataNascimento;
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" + "codPessoa=" + codPessoa + ", nomePessoa=" + nomePessoa + ", rg=" + rg + ", dataNascimento=" + dataNascimento + '}';
    }    
    
}
