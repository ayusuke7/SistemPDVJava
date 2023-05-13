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
public class ModeloParcelamento {
    
    private int id_parcelamento;
    private int id_venda;
    private int qtd_parcelas;
    private int numero_parcela;
    private int juros;
    private String vencimento;
    private double valor_parcela;
    private double valor_total;

    /**
     * @return the id_parcelamento
     */
    public int getId_parcelamento() {
        return id_parcelamento;
    }

    /**
     * @param id_parcelamento the id_parcelamento to set
     */
    public void setId_parcelamento(int id_parcelamento) {
        this.id_parcelamento = id_parcelamento;
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
     * @return the qtd_parcelas
     */
    public int getQtd_parcelas() {
        return qtd_parcelas;
    }

    /**
     * @param qtd_parcelas the qtd_parcelas to set
     */
    public void setQtd_parcelas(int qtd_parcelas) {
        this.qtd_parcelas = qtd_parcelas;
    }

    /**
     * @return the numero_parcela
     */
    public int getNumero_parcela() {
        return numero_parcela;
    }

    /**
     * @param numero_parcela the numero_parcela to set
     */
    public void setNumero_parcela(int numero_parcela) {
        this.numero_parcela = numero_parcela;
    }

    /**
     * @return the juros
     */
    public int getJuros() {
        return juros;
    }

    /**
     * @param juros the juros to set
     */
    public void setJuros(int juros) {
        this.juros = juros;
    }

    /**
     * @return the vencimento
     */
    public String getVencimento() {
        return vencimento;
    }

    /**
     * @param vencimento the vencimento to set
     */
    public void setVencimento(String vencimento) {
        this.vencimento = vencimento;
    }

    /**
     * @return the valor_venda
     */
    public double getValor_parcela() {
        return valor_parcela;
    }

    /**
     * @param valor_parcela the valor_venda to set
     */
    public void setValor_parcela(double valor_parcela) {
        this.valor_parcela = valor_parcela;
    }

    /**
     * @return the valor_total
     */
    public double getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(double valor_total) {
        this.valor_total = valor_total;
    }
    
}
