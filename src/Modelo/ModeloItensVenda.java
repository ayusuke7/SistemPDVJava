/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alexandre
 */
public class ModeloItensVenda {
    
    private int id_itens_venda;
    private int id_venda;
    private int id_produto;
    private int quantidade;
    private float valor_un;
    private float valor_total;

    /**
     * @return the id_itens_venda
     */
    public int getId_itens_venda() {
        return id_itens_venda;
    }

    /**
     * @param id_itens_venda the id_itens_venda to set
     */
    public void setId_itens_venda(int id_itens_venda) {
        this.id_itens_venda = id_itens_venda;
    }

    /**
     * @return the id_venda
     */
    public int getId_venda() {
        return id_venda;
    }

    /**
     * @param id_venda the id_venda to set
     */
    public void setId_venda(int id_venda) {
        this.id_venda = id_venda;
    }

    /**
     * @return the id_produto
     */
    public int getId_produto() {
        return id_produto;
    }

    /**
     * @param id_produto the id_produto to set
     */
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the valor_un
     */
    public float getValor_un() {
        return valor_un;
    }

    /**
     * @param valor_un the valor_un to set
     */
    public void setValor_un(float valor_un) {
        this.valor_un = valor_un;
    }

    /**
     * @return the valor_total
     */
    public float getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }
    
}
