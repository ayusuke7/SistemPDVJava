package Controle;

import DAO.DAOConexao;
import Modelo.ModeloFuncionario;
import Modelo.ModeloPerfil;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleFuncionario {

    DAOConexao con = new DAOConexao();

    public void cadastrarFuncionario(ModeloFuncionario modF) {

        con.Conecta();
        try {
            PreparedStatement pst2 = con.con.prepareStatement("insert into tbla_funcionarios ("
                    + "nome_funcionario, funcao, nivel_prioridade, senha, cpf, contatos, email, "
                    + "endereco, bairro, cidade, estado, cep, complemento) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");

            pst2.setString(1, modF.getNome_funcionario());
            pst2.setString(2, modF.getFuncao());
            pst2.setInt(3, modF.getNivel_prioridade());
            pst2.setString(4, modF.getSenha());
            pst2.setString(5, modF.getCpf());
            pst2.setString(6, modF.getContatos());
            pst2.setString(7, modF.getEmail());

            pst2.setString(8, modF.getEndereco());
            pst2.setString(9, modF.getBairro());
            pst2.setString(10, modF.getCidade());
            pst2.setString(11, modF.getEstado());
            pst2.setString(12, modF.getCep());
            pst2.setString(13, modF.getComplemento());

            pst2.execute();

            JOptionPane.showMessageDialog(null, "FUNCIONARIO CADASTRADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NO CADASTRO DE FUNCIONARIO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void editarFuncionario(ModeloFuncionario modF) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_funcionarios set "
                    + "nome_funcionario=?, funcao=?, nivel_prioridade=?, senha=?, cpf=?, contatos=?, "
                    + "email=?, endereco=?, bairro=?, cidade=?, estado=?, cep=?, complemento=? "
                    + "where id_funcionario=?");

            pst.setString(1, modF.getNome_funcionario());
            pst.setString(2, modF.getFuncao());
            pst.setInt(3, modF.getNivel_prioridade());
            pst.setString(4, modF.getSenha());
            pst.setString(5, modF.getCpf());
            pst.setString(6, modF.getContatos());
            pst.setString(7, modF.getEmail());
            pst.setString(8, modF.getEndereco());
            pst.setString(9, modF.getBairro());
            pst.setString(10, modF.getCidade());
            pst.setString(11, modF.getEstado());
            pst.setString(12, modF.getCep());
            pst.setString(13, modF.getComplemento());
            pst.setInt(14, modF.getId_funcionario());

            pst.execute();
            JOptionPane.showMessageDialog(null, "CADASTRO DE FUNCIONARIO ATUALIZADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO NA ATUALIZAÇÃO DO FUNCIONARIO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void excluirFuncionario(int id_funcionario) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("delete from tbla_funcionarios where id_funcionario=?");
            pst.setInt(1, id_funcionario);
            pst.execute();

            JOptionPane.showMessageDialog(null, "FUNCIONÁRIO EXCLUIDO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR FUNCIONARIO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public int retornaProximoID() {
        int id = 1;
        con.Conecta();
        try {
            con.executaSQL("select id_funcionario from tbla_funcionarios");
            if (con.rs.last()) {
                id = con.rs.getInt("id_funcionario") + 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO RETORNAR CODIGO DO FUNCIONARIO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return id;
    }

    public ModeloFuncionario retornaFuncionario(String id_funcionario) {

        ModeloFuncionario modF = new ModeloFuncionario();

        con.Conecta();
        try {
            con.executaSQL("select * from tbla_funcionarios where id_funcionario = " + id_funcionario);
            if (con.rs.first()) {

                modF.setId_funcionario(con.rs.getInt("id_funcionario"));
                modF.setNome_funcionario(con.rs.getString("nome_funcionario"));
                modF.setCpf(con.rs.getString("cpf"));
                modF.setFuncao(con.rs.getString("funcao"));
                modF.setNivel_prioridade(con.rs.getInt("nivel_prioridade"));
                modF.setSenha(String.valueOf(con.rs.getString("senha")));
                modF.setContatos(con.rs.getString("contatos"));
                modF.setEmail(con.rs.getString("email"));

                modF.setEndereco(con.rs.getString("endereco"));
                modF.setBairro(con.rs.getString("bairro"));
                modF.setCidade(con.rs.getString("cidade"));
                modF.setEstado(con.rs.getString("estado"));
                modF.setComplemento(con.rs.getString("complemento"));
                modF.setCep(con.rs.getString("cep"));

            } else {
                JOptionPane.showMessageDialog(null, "NENHUM FUNCIONARIO ENCONTRADO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO RETORNAR DADOS DO FUNCIONARIO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return modF;

    }

    public ArrayList tabeladeFuncionarios() {

        ArrayList dados = new ArrayList();
        con.Conecta();
        try {
            con.executaSQL("select * from tbla_funcionarios");
            if (con.rs.first()) {
                do {
                    dados.add(new Object[]{con.rs.getInt("id_funcionario"),
                        con.rs.getString("nome_funcionario")});
                } while (con.rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro em tabeladeFuncionarios\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return dados;
    }

    public void cadastraPerfil() {

    }

    public ModeloPerfil retornaPerfil(String id_funcionario) {

        ModeloPerfil mod = new ModeloPerfil();

        con.Conecta();
        con.executaSQL("select * from tbla_perfis where id_funcionario=" + id_funcionario);
        try {
            if (con.rs.first()) {

                mod.setCad_cliente(con.rs.getBoolean("cad_cliente"));
                mod.setCad_fornec(con.rs.getBoolean("cad_fornec"));
                mod.setCad_funcio(con.rs.getBoolean("cad_func"));
                mod.setCad_prod(con.rs.getBoolean("cad_prod"));
                mod.setCons_estoque(con.rs.getBoolean("cons_estoque"));
                mod.setCons_caixa(con.rs.getBoolean("cons_caixa"));
                mod.setMov_vendas(con.rs.getBoolean("mov_vendas"));
                mod.setMov_caixas(con.rs.getBoolean("mov_caixas"));
                mod.setRelat_venda(con.rs.getBoolean("relat_vendas"));
                mod.setRelat_estoque(con.rs.getBoolean("relat_caixas"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ControleFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.Desconecta();
        return mod;

    }

}
