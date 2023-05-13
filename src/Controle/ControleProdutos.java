package Controle;

import DAO.DAOConexao;
import Modelo.ModeloProdutos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleProdutos {

    DAOConexao con = new DAOConexao();

    public void cadastrarProduto(ModeloProdutos mod) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("insert into tbla_produtos (descricao, cod_barras, "
                    + "id_fornecedor, dt_entrada, quantidade, tipo, valor_compra, valor_venda, valor_total_nota, "
                    + "estoque_minimo) values (?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, mod.getDescricao());
            pst.setString(2, mod.getCod_barra());
            pst.setInt(3, mod.getId_fornecedor());
            pst.setString(4, mod.getDt_entrada());
            pst.setInt(5, mod.getQuantidade());
            pst.setString(6, mod.getTipo());
            pst.setString(7, mod.getValor_compra());
            pst.setString(8, mod.getValor_venda());
            pst.setString(9, mod.getValor_total());
            pst.setInt(10, mod.getQtd_estoque());
            pst.execute();
            JOptionPane.showMessageDialog(null, "PRODUTO CADASTRADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO CADASTRO DE PRODUTO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void editarProduto(ModeloProdutos mod) {

        con.Conecta();

        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_produtos set descricao=?, cod_barras=?, "
                    + "id_fornecedor=?, dt_entrada=?, quantidade=?, tipo=?, valor_compra=?, valor_venda=?, valor_total_nota=? "
                    + "where id_produto=?");
            pst.setString(1, mod.getDescricao());
            pst.setString(2, mod.getCod_barra());
            pst.setInt(3, mod.getId_fornecedor());
            pst.setString(4, mod.getDt_entrada());
            pst.setInt(5, mod.getQuantidade());
            pst.setString(6, mod.getTipo());
            pst.setString(7, mod.getValor_compra());
            pst.setString(8, mod.getValor_venda());
            pst.setString(9, mod.getValor_total());
            pst.setInt(10, mod.getId_produto());
            pst.execute();
            JOptionPane.showMessageDialog(null, "PRODUTO ATUALIZADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA ATUALIZAÇÃO DO PRODUTO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void excluirProduto(int id_produto) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("delete from tbla_produtos where id_produto=?");
            pst.setInt(1, id_produto);
            pst.execute();
            JOptionPane.showMessageDialog(null, "PRODUTO EXCLUIDO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR PRODUTO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public int retornaUltimoID() {

        int id = 0;
        con.Conecta();
        try {
            con.executaSQL("select id_produto from tbla_produtos");
            if (con.rs.last()) {
                id = con.rs.getInt("id_produto");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO RETORNAR CODIGO DO PRODUTO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return id;
    }

    public ModeloProdutos retornaProduto(String id_produto) {

        ModeloProdutos mod = new ModeloProdutos();
        con.Conecta();
        con.executaSQL("select * from tbla_produtos where id_produto = " + id_produto);
        try {
            if (con.rs.first()) {
                mod.setId_produto(con.rs.getInt("id_produto"));
                mod.setDescricao(con.rs.getString("descricao"));
                mod.setCod_barra(con.rs.getString("cod_barras"));
                mod.setId_fornecedor(con.rs.getInt("id_fornecedor"));
                mod.setDt_entrada(con.rs.getString("dt_entrada"));
                mod.setQuantidade(con.rs.getInt("quantidade"));
                mod.setTipo(con.rs.getString("tipo"));
                mod.setValor_compra(con.rs.getString("valor_compra"));
                mod.setValor_venda(con.rs.getString("valor_venda"));
                mod.setValor_total(con.rs.getString("valor_total_nota"));
            } else {
                JOptionPane.showMessageDialog(null, "PRODUTO NÃO ENCONTRADO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error ao retornar produto\n" + ex);
        }
        return mod;
    }

    public ResultSet retornaValores(String id_produto) {

        con.Conecta();
        try {
            con.executaSQL("select * from tbla_produtos inner join tbla_fornecedores on "
                    + "tbla_produtos.id_fornecedor = tbla_fornecedores.id_fornecedor "
                    + "where id_produto = " + id_produto);
            if (con.rs.first()) {
                return con.rs;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO RETORNAR DADOS DO PRODUTO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return null;

    }

    public ArrayList retornaListaProdutos(String sql) {

        ArrayList dados = new ArrayList();
        con.Conecta();
        try {
            con.executaSQL(sql);
            if (con.rs.first()) {
                do{
                    dados.add(new Object[]{con.rs.getInt("id_produto"),
                                           con.rs.getString("descricao"),
                                           con.rs.getString("dt_entrada"),
                                           con.rs.getString("quantidade")});
                }while(con.rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retornarListaProdutos","PROBLEMAS"+ex, JOptionPane.OK_OPTION);
        }
        return dados;

    }

}
