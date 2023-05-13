package Modelo;

/**
 *
 * @author Alexandre
 */
public class ModeloCaixa {
    
    private int id_caixa;
    private String data;
    private String valor_inicial;
    private String valor_final;
    private String status;

    /**
     * @return the id_caixa
     */
    public int getId_caixa() {
        return id_caixa;
    }

    /**
     * @param id_caixa the id_caixa to set
     */
    public void setId_caixa(int id_caixa) {
        this.id_caixa = id_caixa;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the valor_inicial
     */
    public String getValor_inicial() {
        return valor_inicial;
    }

    /**
     * @param valor_inicial the valor_inicial to set
     */
    public void setValor_inicial(String valor_inicial) {
        this.valor_inicial = valor_inicial;
    }

    /**
     * @return the valor_final
     */
    public String getValor_final() {
        return valor_final;
    }

    /**
     * @param valor_final the valor_final to set
     */
    public void setValor_final(String valor_final) {
        this.valor_final = valor_final;
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
    
    
}
