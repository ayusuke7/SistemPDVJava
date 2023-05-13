package Controle;

import DAO.DAOConexao;
import Modelo.ModeloItensVenda;
import Modelo.ModeloParcelamento;
import Modelo.ModeloVendas;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleVendas {

    private final DAOConexao con;

    public ControleVendas() {
        this.con = new DAOConexao();
    }

    public boolean iniciarVenda(ModeloVendas mod) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("insert into tbla_vendas "
                    + "(id_funcionario, id_cliente, ini_venda, status, tipo) values (?,?,?,?,?)");
            pst.setInt(1, mod.getId_funcionario());
            pst.setInt(2, mod.getId_cliente());
            pst.setString(3, mod.getIni_venda());
            pst.setString(4, mod.getStatus());
            pst.setString(5, mod.getTipo());
            pst.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao iniciar a venda\n" + ex);
        }
        con.Desconecta();
        return false;
    }

    public boolean finalizarVenda(ModeloVendas mod) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_vendas set "
                    + "id_forma_pag=?, fim_venda=?, desconto=?, subtotal=?, valor_total=?, status=? "
                    + "where id_venda=?");
            pst.setInt(1, mod.getId_forma_pagamento());
            pst.setString(2, mod.getFim_venda());
            pst.setFloat(3, mod.getDesconto());
            pst.setFloat(4, mod.getSub_total());
            pst.setFloat(5, mod.getValor_total());
            pst.setString(6, mod.getStatus());
            pst.setInt(7, mod.getId_venda());
            pst.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao finalizar a venda\n" + ex);
        }
        con.Desconecta();
        return false;
    }

    public boolean adicionarItensVenda(ModeloItensVenda mod) {

        con.Conecta();
        con.executaSQL("select quantidade from tbla_produtos where id_produto = " +mod.getId_produto());
        PreparedStatement pst;
        try {   
            con.rs.first();
            int qtd = con.rs.getInt("quantidade");            
            if(qtd >= mod.getQuantidade()){
                
                //adiciona o produto na tabela itens_venda
                pst = con.con.prepareStatement("insert into tbla_itens_vendas "
                        + "(id_venda, id_produto, qtd_prod, valor_un, valor_total) values (?,?,?,?,?)");
                pst.setInt(1, mod.getId_venda());
                pst.setInt(2, mod.getId_produto());
                pst.setInt(3, mod.getQuantidade());
                pst.setFloat(4, mod.getValor_un());
                pst.setFloat(5, mod.getValor_total());
                pst.execute();

                //Baixa de produto no estoque
                pst = con.con.prepareStatement("update tbla_produtos set quantidade=? where id_produto=?");
                pst.setInt(1, (qtd - mod.getQuantidade()));
                pst.setInt(2, mod.getId_produto());
                pst.execute();
                return true;

            }else{
                JOptionPane.showMessageDialog(null, "QUANTIDADE INSUFICIENTE EM ESTOQUE","AVISO", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ADICIONAR ITEM A VENDA\n" + ex);
        }
        con.Desconecta();
        return false;
    }

    public boolean cancelarVenda(int id_venda) {

        con.Conecta();
        PreparedStatement pst;
        con.executaSQL("select * from tbla_produtos inner join tbla_itens_vendas "
                     + "on tbla_produtos.id_produto = tbla_itens_vendas.id_produto "
                     + "where id_venda = "+id_venda);
        try {
            //estorno de produto para o estoque caso tenha sido adicionado produto e depois cancelada a venda
            if(con.rs.first()){
                do{
                    int qtd_atual = con.rs.getInt("quantidade");
                    int qtd_estorno = con.rs.getInt("qtd_prod");
                    int prod = con.rs.getInt("id_produto");

                    pst = con.con.prepareStatement("update tbla_produtos set quantidade=? where id_produto=?");
                    pst.setInt(1, (qtd_atual + qtd_estorno));
                    pst.setInt(2, prod);
                    pst.execute();
                }while(con.rs.next());
            }
            
            pst = con.con.prepareStatement("delete from tbla_itens_vendas where id_venda = ?");
            pst.setInt(1, id_venda);
            pst.execute();

            pst = con.con.prepareStatement("delete from tbla_vendas where id_venda = ?");
            pst.setInt(1, id_venda);
            pst.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao cancelar a venda " + id_venda + "\n" + ex);
        }
        con.Desconecta();
        return false;
    }

    public boolean salvarVenda(int id_venda) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_vendas set status=? where id_venda=?");
            pst.setString(1, "Aberta");
            pst.setInt(2, id_venda);
            pst.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO Salvar a venda " + id_venda + "\n" + ex);
        }
        con.Desconecta();
        return false;

    }

    public boolean salvarParcelamento(ModeloParcelamento mod) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("insert into tbla_parcelamento "
                    + "(id_venda, qtd_parcelas, numero_parcela, vencimento, juros, valor_parcela, valor_total) "
                    + "values (?,?,?,?,?,?,?)");
            pst.setInt(1, mod.getId_venda());
            pst.setInt(2, mod.getQtd_parcelas());
            pst.setInt(3, mod.getNumero_parcela());
            pst.setString(4, mod.getVencimento());
            pst.setInt(5, mod.getJuros());
            pst.setDouble(6, mod.getValor_parcela());
            pst.setDouble(7, mod.getValor_total());
            pst.execute();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao salvar parcelamento\n" + ex);
        }
        con.Desconecta();
        return false;
    }
    
    public ArrayList retornaItensVenda(String id_venda) {

        ArrayList dados = new ArrayList();

        con.Conecta();
        try {
            con.executaSQL("select * from tbla_itens_vendas inner join tbla_produtos \n"
                    + "on tbla_itens_vendas.id_produto = tbla_produtos.id_produto "
                    + "where id_venda = " + id_venda);
            if (con.rs.first()) {
                do {
                    dados.add(new Object[]{con.rs.getInt("id_produto"),
                        con.rs.getString("descricao"),
                        con.rs.getInt("qtd_prod"),
                        con.rs.getDouble("valor_un"),
                        con.rs.getDouble("valor_total")});
                } while (con.rs.next());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao retornar Itens da Venda\nERROR " + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return dados;

    }

    public int retornaUltimaVenda() {

        int id = 0;
        con.Conecta();
        try {
            con.executaSQL("select id_venda from tbla_vendas");
            if (con.rs.last()) {
                id = con.rs.getInt("id_venda");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO RETORNAR CODIGO DA VENDA\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return id;
    }

}
