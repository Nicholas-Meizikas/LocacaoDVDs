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
public class Ator {
    
    private int id ;
    private String nome ;
    private String sobrenome ;
    private Date dataEstreia ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Date getDataEstreia() {
        return dataEstreia;
    }

    public void setDataEstreia(Date dataEstreia) {
        this.dataEstreia = dataEstreia;
    }

    @Override
    public String toString() {
        return "Ator{" + "id=" + id + ", nome=" + nome + ", sobrenome=" + sobrenome + ", dataEstreia=" + dataEstreia + '}';
    }
    
    
}
