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
public class ModeloVendas {
    
    private int id_venda;
    private int id_funcionario;
    private int id_cliente;
    private int id_produto;
    private int quantidade;
    private String ini_venda;
    private String fim_venda;
    private float desconto;
    private float sub_total;
    private float valor_total;
    private int id_forma_pagamento;
    private String status;
    private String tipo;
    
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
     * @return the id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * @param id_cliente the id_cliente to set
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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
     * @return the ini_venda
     */
    public String getIni_venda() {
        return ini_venda;
    }

    /**
     * @param ini_venda the ini_venda to set
     */
    public void setIni_venda(String ini_venda) {
        this.ini_venda = ini_venda;
    }

    /**
     * @return the fim_venda
     */
    public String getFim_venda() {
        return fim_venda;
    }

    /**
     * @param fim_venda the fim_venda to set
     */
    public void setFim_venda(String fim_venda) {
        this.fim_venda = fim_venda;
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

    /**
     * @return the id_forma_pagamento
     */
    public int getId_forma_pagamento() {
        return id_forma_pagamento;
    }

    /**
     * @param id_forma_pagamento the id_forma_pagamento to set
     */
    public void setId_forma_pagamento(int id_forma_pagamento) {
        this.id_forma_pagamento = id_forma_pagamento;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the desconto
     */
    public float getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the sub_total
     */
    public float getSub_total() {
        return sub_total;
    }

    /**
     * @param sub_total the sub_total to set
     */
    public void setSub_total(float sub_total) {
        this.sub_total = sub_total;
    }
    
}
