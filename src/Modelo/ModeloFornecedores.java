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
public class ModeloFornecedores {
    
    private int id_fornecedor;
    private String nome_fornecedor;
    private String cnpj_fornecedor;
    private String tel_fixo;
    private String tel_celular;
    private String outros_contatos;

    /**
     * @return the id_fornecedor
     */
    public int getId_fornecedor() {
        return id_fornecedor;
    }

    /**
     * @param id_fornecedor the id_fornecedor to set
     */
    public void setId_fornecedor(int id_fornecedor) {
        this.id_fornecedor = id_fornecedor;
    }

    /**
     * @return the nome_fornecedor
     */
    public String getNome_fornecedor() {
        return nome_fornecedor;
    }

    /**
     * @param nome_fornecedor the nome_fornecedor to set
     */
    public void setNome_fornecedor(String nome_fornecedor) {
        this.nome_fornecedor = nome_fornecedor;
    }

    /**
     * @return the cnpj_fornecedor
     */
    public String getCnpj_fornecedor() {
        return cnpj_fornecedor;
    }

    /**
     * @param cnpj_fornecedor the cnpj_fornecedor to set
     */
    public void setCnpj_fornecedor(String cnpj_fornecedor) {
        this.cnpj_fornecedor = cnpj_fornecedor;
    }

    /**
     * @return the tel_fixo
     */
    public String getTel_fixo() {
        return tel_fixo;
    }

    /**
     * @param tel_fixo the tel_fixo to set
     */
    public void setTel_fixo(String tel_fixo) {
        this.tel_fixo = tel_fixo;
    }

    /**
     * @return the tel_celular
     */
    public String getTel_celular() {
        return tel_celular;
    }

    /**
     * @param tel_celular the tel_celular to set
     */
    public void setTel_celular(String tel_celular) {
        this.tel_celular = tel_celular;
    }

    /**
     * @return the outros_contatos
     */
    public String getOutros_contatos() {
        return outros_contatos;
    }

    /**
     * @param outros_contatos the outros_contatos to set
     */
    public void setOutros_contatos(String outros_contatos) {
        this.outros_contatos = outros_contatos;
    }
    
    
}
