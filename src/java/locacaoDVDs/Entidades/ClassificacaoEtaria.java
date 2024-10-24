/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.Entidades;

/**
 *
 * @author nicho
 */
public class ClassificacaoEtaria {
    private int id ;
    private String descricao ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "ClassificaoEtaria{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
    
}
