/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author YU7
 */
public class ModeloPerfil {

    private int id_funcionario;
    private boolean cad_cliente;
    private boolean cad_fornec;
    private boolean cad_prod;
    private boolean cad_funcio;
    private boolean cons_estoque;
    private boolean cons_caixa;
    private boolean mov_vendas;
    private boolean mov_caixas;
    private boolean relat_venda;
    private boolean relat_estoque;

    /**
     * @return the id_funcionario
     */
    public int getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(int id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    /**
     * @return the cad_cliente
     */
    public boolean isCad_cliente() {
        return cad_cliente;
    }

    /**
     * @param cad_cliente the cad_cliente to set
     */
    public void setCad_cliente(boolean cad_cliente) {
        this.cad_cliente = cad_cliente;
    }

    /**
     * @return the cad_fornec
     */
    public boolean isCad_fornec() {
        return cad_fornec;
    }

    /**
     * @param cad_fornec the cad_fornec to set
     */
    public void setCad_fornec(boolean cad_fornec) {
        this.cad_fornec = cad_fornec;
    }

    /**
     * @return the cad_prod
     */
    public boolean isCad_prod() {
        return cad_prod;
    }

    /**
     * @param cad_prod the cad_prod to set
     */
    public void setCad_prod(boolean cad_prod) {
        this.cad_prod = cad_prod;
    }

    /**
     * @return the cad_funcio
     */
    public boolean isCad_funcio() {
        return cad_funcio;
    }

    /**
     * @param cad_funcio the cad_funcio to set
     */
    public void setCad_funcio(boolean cad_funcio) {
        this.cad_funcio = cad_funcio;
    }

    /**
     * @return the cons_estoque
     */
    public boolean isCons_estoque() {
        return cons_estoque;
    }

    /**
     * @param cons_estoque the cons_estoque to set
     */
    public void setCons_estoque(boolean cons_estoque) {
        this.cons_estoque = cons_estoque;
    }

    /**
     * @return the cons_caixa
     */
    public boolean isCons_caixa() {
        return cons_caixa;
    }

    /**
     * @param cons_caixa the cons_caixa to set
     */
    public void setCons_caixa(boolean cons_caixa) {
        this.cons_caixa = cons_caixa;
    }

    /**
     * @return the mov_vendas
     */
    public boolean isMov_vendas() {
        return mov_vendas;
    }

    /**
     * @param mov_vendas the mov_vendas to set
     */
    public void setMov_vendas(boolean mov_vendas) {
        this.mov_vendas = mov_vendas;
    }

    /**
     * @return the mov_caixas
     */
    public boolean isMov_caixas() {
        return mov_caixas;
    }

    /**
     * @param mov_caixas the mov_caixas to set
     */
    public void setMov_caixas(boolean mov_caixas) {
        this.mov_caixas = mov_caixas;
    }

    /**
     * @return the relat_venda
     */
    public boolean isRelat_venda() {
        return relat_venda;
    }

    /**
     * @param relat_venda the relat_venda to set
     */
    public void setRelat_venda(boolean relat_venda) {
        this.relat_venda = relat_venda;
    }

    /**
     * @return the relat_estoque
     */
    public boolean isRelat_estoque() {
        return relat_estoque;
    }

    /**
     * @param relat_estoque the relat_estoque to set
     */
    public void setRelat_estoque(boolean relat_estoque) {
        this.relat_estoque = relat_estoque;
    }

}
