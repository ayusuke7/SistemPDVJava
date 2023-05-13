package Controle;

import DAO.DAOConexao;
import Modelo.ModeloCaixa;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleCaixa {

    private final DAOConexao con;

    public ControleCaixa() {
        this.con = new DAOConexao();
    }

    public boolean aberturaCaixa(ModeloCaixa mod) {

        con.Conecta();
        PreparedStatement pst;
        try {
            pst = con.con.prepareStatement("insert into tbla_caixas "
                    + "(data, valor_inicial, status) values (?,?,?)");
            pst.setString(1, mod.getData());
            pst.setString(2, mod.getValor_inicial());
            pst.setString(3, mod.getStatus());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao abrir movimento\n(CAIXA) "
                    + mod.getData() + "\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return false;

    }

    public boolean fechamentoCaixa(ModeloCaixa mod) {

        con.Conecta();
        PreparedStatement pst;
        try {
            pst = con.con.prepareStatement("update tbla_caixas set valor_final=?, status=? "
                    + "where id_caixa=?");
            pst.setString(1, mod.getValor_final());
            pst.setString(2, mod.getStatus());
            pst.setInt(3, mod.getId_caixa());
            pst.execute();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao finalizar movimento\n(CAIXA) "
                    + mod.getData() + "\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return false;

    }

    public ArrayList movimentoCaixa(String dt_movimento) {

        ArrayList dados = new ArrayList();

        con.Conecta();
        con.executaSQL("select id_venda, nome_pessoa, descricao, subtotal, desconto, valor_total, status, "
                + "ini_venda, fim_venda, nome_funcionario from tbla_vendas \n"
                + "inner join tbla_clientes\n"
                + "on tbla_vendas.id_cliente = tbla_clientes.id_cliente\n"
                + "inner join tbla_forma_pagamento\n"
                + "on tbla_vendas.id_forma_pag = tbla_forma_pagamento.id_forma_pag\n"
                + "inner join tbla_funcionarios\n"
                + "on tbla_vendas.id_funcionario = tbla_funcionarios.id_funcionario\n"
                + "where tbla_vendas.ini_venda like '" + dt_movimento + "%'");
        try {
            if (con.rs.first()) {
                do {
                    dados.add(new Object[]{con.rs.getInt("id_venda"),
                        con.rs.getString("nome_pessoa"),
                        con.rs.getString("descricao"),
                        con.rs.getFloat("subtotal"),
                        con.rs.getFloat("desconto"),
                        con.rs.getFloat("valor_total"),
                        con.rs.getString("status"),
                        con.rs.getString("ini_venda"),
                        con.rs.getString("fim_venda"),
                        con.rs.getString("nome_funcionario")});
                } while (con.rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum movimento nesse CAIXA");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retornar MovimentoCaixa\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return dados;

    }

    public ArrayList retornaListaCaixas() {

        ArrayList dados = new ArrayList();
        con.Conecta();
        try {
            con.executaSQL("select * from tbla_caixas");
            if (con.rs.first()) {
                do {
                    dados.add(new Object[]{con.rs.getInt("id_caixa"),
                        con.rs.getString("data"),
                        con.rs.getString("valor_inicial"),
                        con.rs.getString("valor_final"),
                        con.rs.getString("status")});
                } while (con.rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retornarListaCaixas\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        return dados;

    }

    public ModeloCaixa retornaCaixaAberto() {

        ModeloCaixa mod = null;

        con.Conecta();
        con.executaSQL("select * from tbla_caixas where status = 'Aberto'");
        try {
            if (con.rs.first()) {
                mod = new ModeloCaixa();
                mod.setId_caixa(con.rs.getInt("id_caixa"));
                mod.setData(con.rs.getString("data"));
                mod.setValor_inicial(con.rs.getString("valor_inicial"));
                mod.setValor_final(con.rs.getString("valor_final"));
                mod.setStatus(con.rs.getString("status"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao retornarCaixa\n" + ex, "AVISO", JOptionPane.ERROR_MESSAGE);
        }

        con.Desconecta();
        return mod;

    }

    public int retornaUltimoID() {

        int id = 0;
        con.Conecta();
        try {
            con.executaSQL("select id_caixa from tbla_caixas");
            if (con.rs.last()) {
                id = con.rs.getInt("id_caixa");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao retornarUltimoID\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return id;
    }

}
