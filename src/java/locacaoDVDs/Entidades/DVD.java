/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.Entidades;

import java.sql.Date ;
/**
 *
 * @author nicho
 */
public class DVD {
    
    private int id ;
    private Genero genero ;
    private ClassificacaoEtaria ClasEt ;
    private Ator atorPrincipal ;
    private Ator atorCoadjuvante ;
    private String titulo ;
    private int anoLancamento ;
    private Date dataLancamento ;
    private int duracaoMinutos ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public ClassificacaoEtaria getClasEt() {
        return ClasEt;
    }

    public void setClasEt(ClassificacaoEtaria ClasEt) {
        this.ClasEt = ClasEt;
    }

    public Ator getAtorPrincipal() {
        return atorPrincipal;
    }

    public void setAtorPrincipal(Ator atorPrincipal) {
        this.atorPrincipal = atorPrincipal;
    }

    public Ator getAtorCoadjuvante() {
        return atorCoadjuvante;
    }

    public void setAtorCoadjuvante(Ator atorCoadjuvante) {
        this.atorCoadjuvante = atorCoadjuvante;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Date getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Date dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String toString() {
        return "DVD{" + "id=" + id + ",\n genero=" + genero.toString() + ",\n ClasEt=" + ClasEt.toString() + ",\n atorPrincipal=" + atorPrincipal.toString() + ",\n atorCoadjuvante=" + atorCoadjuvante.toString() + ", titulo=" + titulo + ", anoLancamento=" + anoLancamento + ", dataLancamento=" + dataLancamento + ", duracaoMinutos=" + duracaoMinutos + '}';
    }
    
    
}
