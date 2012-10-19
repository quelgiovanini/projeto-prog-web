/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Quele
 */
class Curso {
    private Area area;
    private String nome;
    private Professor orientador;
    
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
    
    @Override
    public String toString(){
        return ("Curso: " + getNome()+"\n");
    }
    
}
