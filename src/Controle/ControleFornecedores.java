package Controle;

import DAO.DAOConexao;
import Modelo.ModeloFornecedores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleFornecedores {

    DAOConexao con = new DAOConexao();

    public void cadastrarFornecedor(ModeloFornecedores mod) {

        con.Conecta();
        try {
            con.executaSQL("select cnpj from tbla_fornecedores where cnpj='" + mod.getCnpj_fornecedor() + "'");
            if (con.rs.first()) {
                JOptionPane.showMessageDialog(null, "JÁ EXISTE UM FORNECEDOR COM ESTE CNPJ","AVISO",JOptionPane.OK_OPTION);
            } else {
                PreparedStatement pst = con.con.prepareStatement("insert into tbla_fornecedores (nome_fornecedor, "
                        + "cnpj, tel_fixo, tel_celular, outros_contatos) values (?,?,?,?,?)");
                pst.setString(1, mod.getNome_fornecedor());
                pst.setString(2, mod.getCnpj_fornecedor());
                pst.setString(3, mod.getTel_fixo());
                pst.setString(4, mod.getTel_fixo());
                pst.setString(5, mod.getOutros_contatos());
                pst.execute();
                JOptionPane.showMessageDialog(null, "FORNECEDOR CADASTRADO COM SUCESSO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO CADASTRO DE FORNECEDOR\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void editarFornecedor(ModeloFornecedores mod) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_fornecedores set nome_fornecedor=?, "
                    + "cnpj=?, tel_fixo=?, tel_celular=?, outros_contatos=? where id_fornecedor=?");
            pst.setString(1, mod.getNome_fornecedor());
            pst.setString(2, mod.getCnpj_fornecedor());
            pst.setString(3, mod.getTel_fixo());
            pst.setString(4, mod.getTel_fixo());
            pst.setString(5, mod.getOutros_contatos());
            pst.setInt(6, mod.getId_fornecedor());
            pst.execute();
            JOptionPane.showMessageDialog(null, "FORNECEDOR ATUALIZADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO ATUALIZAR CADASTRO DE FORNECEDOR\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void excluirFornecedor(int id_fornecedor) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("delete from tbla_fornecedores where id_fornecedor=?");
            pst.setInt(1, id_fornecedor);
            pst.execute();
            JOptionPane.showMessageDialog(null, "FORNECEDOR EXCLUIDO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR CADASTRO DE FORNECEDOR\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public ModeloFornecedores retornaDadosFornecedor(String sql) {

        con.Conecta();
        try {
            con.executaSQL(sql);
            if (con.rs.first()) {
                ModeloFornecedores mod =  new ModeloFornecedores();
                mod.setNome_fornecedor(con.rs.getString("nome_fornecedor"));
                mod.setCnpj_fornecedor(con.rs.getString("cnpj"));
                mod.setTel_celular(con.rs.getString("tel_celular"));
                mod.setTel_fixo(con.rs.getString("tel_fixo"));
                mod.setOutros_contatos(con.rs.getString("outros_contatos"));
                return mod;
                
            } else {
                JOptionPane.showMessageDialog(null, "NENHUM FORNECEDOR CADASTRADO", "AVISO", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao array de registros!\nERROR " + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return null;
        
    }

    public ArrayList retornaListaFornecedores(){
        
        ArrayList dados = new ArrayList();

        con.Conecta();
        try {
            con.executaSQL("select * from tbla_fornecedores");
            if (con.rs.first()) {
                do {
                    dados.add(new Object[]{con.rs.getInt("id_fornecedor"),
                                           con.rs.getString("nome_fornecedor"),
                                           con.rs.getString("cnpj")});

                } while (con.rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "NENHUM FORNECEDOR CADASTRADO", "AVISO", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Problemas ao array de registros!\nERROR " + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return dados;
        
    }
    
    public int retornaUltimoID() {

        int id = 0;
        con.Conecta();

        try {
            con.executaSQL("select id_fornecedor from tbla_fornecedores");
            if (con.rs.last()) {
                id = con.rs.getInt("id_fornecedor");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO RETORNAR CODIGO DE FORNECEDOR\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        return id;
    }

}
