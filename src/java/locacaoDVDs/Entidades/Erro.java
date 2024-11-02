/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package locacaoDVDs.Entidades;

/**
 *
 * @author nicho
 */
public class Erro {
    private String mensagem ;
    private String caminho ;
    private String processa ;
    private int id ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getProcessa() {
        return processa;
    }

    public void setProcessa(String processa) {
        this.processa = processa;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCaminho() {
        return caminho;
    }

    public void setCaminho(String caminho) {
        this.caminho = caminho;
    }

    @Override
    public String toString() {
        return "Erro{" + "mensagem=" + mensagem + ", caminho=" + caminho + '}';
    }
    
}
