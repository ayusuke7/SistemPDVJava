package Controle;

import DAO.DAOConexao;
import Modelo.ModeloClientes;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleClientes {

    DAOConexao con = new DAOConexao();

    public void CadastrarCliente(ModeloClientes modP) {

        con.Conecta();
        try {
            PreparedStatement pst2 = con.con.prepareStatement("insert into tbla_clientes "
                    + "(nome_pessoa, genero, dt_nascimento, documento1, documento2, estado_civil, contatos, email, "
                    + "renda, nome_conjuge, dt_nasc_conjuge, cpf_conjuge, contato_conjuge, nome_empresa, "
                    + "funcao, contato_empresa, endereco_empresa, dt_admissao, endereco, bairro, cidade, estado, cep, "
                    + "complemento, moradia) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            pst2.setString(1, modP.getNome_pessoa());
            pst2.setString(2, modP.getGenero());
            pst2.setString(3, modP.getDt_nascimento());
            pst2.setString(4, modP.getDocumento1());
            pst2.setString(5, modP.getDocumento2());
            pst2.setString(6, modP.getEstado_civil());
            pst2.setString(7, modP.getContatos());
            pst2.setString(8, modP.getEmail());
            pst2.setString(9, modP.getRenda());
            pst2.setString(10, modP.getConjuge());
            pst2.setString(11, modP.getDt_nasc_conjuge());
            pst2.setString(12, modP.getCpf_conjuge());
            pst2.setString(13, modP.getContato_conjuge());
            pst2.setString(14, modP.getNome_empresa());
            pst2.setString(15, modP.getFuncao());
            pst2.setString(16, modP.getContato_empresa());
            pst2.setString(17, modP.getEndereco_empresa());
            pst2.setString(18, modP.getDt_admissao());
            pst2.setString(19, modP.getEndereco());
            pst2.setString(20, modP.getBairro());
            pst2.setString(21, modP.getCidade());
            pst2.setString(22, modP.getEstado());
            pst2.setString(23, modP.getCep());
            pst2.setString(24, modP.getComplemento());
            pst2.setString(25, modP.getMoradia());
            pst2.execute();

            JOptionPane.showMessageDialog(null, "CLIENTE CADASTRADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRO DE CLIENTE\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void EditarCliente(ModeloClientes modP) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_clientes set nome_pessoa=?, "
                    + "genero=?, dt_nascimento=?, documento1=?, documento2=?, estado_civil=?, contatos=?, "
                    + "email=?, renda=?, nome_conjuge=?, dt_nasc_conjuge=?, cpf_conjuge=?, contato_conjuge=?, "
                    + "nome_empresa=?, funcao=?, contato_empresa=?, endereco_empresa=?, dt_admissao=?, endereco=?, "
                    + "bairro=?, cidade=?, estado=?, cep=?, complemento=?, moradia=? where id_cliente=?");

            pst.setString(1, modP.getNome_pessoa());
            pst.setString(2, modP.getGenero());
            pst.setString(3, modP.getDt_nascimento());
            pst.setString(4, modP.getDocumento1());
            pst.setString(5, modP.getDocumento2());
            pst.setString(6, modP.getEstado_civil());
            pst.setString(7, modP.getContatos());
            pst.setString(8, modP.getEmail());
            pst.setString(9, modP.getRenda());
            pst.setString(10, modP.getConjuge());
            pst.setString(11, modP.getDt_nasc_conjuge());
            pst.setString(12, modP.getCpf_conjuge());
            pst.setString(13, modP.getContato_conjuge());
            pst.setString(14, modP.getNome_empresa());
            pst.setString(15, modP.getFuncao());
            pst.setString(16, modP.getContato_empresa());
            pst.setString(17, modP.getEndereco_empresa());
            pst.setString(18, modP.getDt_admissao());
            pst.setString(19, modP.getEndereco());
            pst.setString(20, modP.getBairro());
            pst.setString(21, modP.getCidade());
            pst.setString(22, modP.getEstado());
            pst.setString(23, modP.getCep());
            pst.setString(24, modP.getComplemento());
            pst.setString(25, modP.getMoradia());
            pst.setInt(26, modP.getId_pessoa());
            pst.execute();

            JOptionPane.showMessageDialog(null, "CADASTRO DE CLIENTE ATUALIZADO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR CADASTRO\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();

    }

    public void ExcluirCliente(String id_cliente) {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("delete from tbla_clientes where id_cliente=?");
            pst.setInt(1, Integer.parseInt(id_cliente));
            pst.execute();

            JOptionPane.showMessageDialog(null, "CLIENTE EXCLUIDO COM SUCESSO");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR CLIENTE\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
    }

    public int retornaUltimoId() {

        int id = 0;
        con.Conecta();
        try {
            con.executaSQL("select id_cliente from tbla_clientes");
            if (con.rs.last()) {
                id = con.rs.getInt("id_cliente") + 1;
            } else {
                id = 1;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO RETORNO PROXIMO COD. DE CLIENTE\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return id;

    }

    public ModeloClientes retornaValores(String id_cliente) {

        ModeloClientes modP = new ModeloClientes();

        con.Conecta();
        try {
            con.executaSQL("select * from tbla_clientes where id_cliente = " + id_cliente);
            if (con.rs.first()) {
                
                modP.setId_pessoa(con.rs.getInt("id_cliente"));
                modP.setNome_pessoa(con.rs.getString("nome_pessoa"));
                modP.setGenero(con.rs.getString("genero"));
                modP.setDt_nascimento(con.rs.getString("dt_nascimento"));
                modP.setDocumento1(con.rs.getString("documento1"));
                modP.setDocumento2(con.rs.getString("documento2"));
                modP.setEstado_civil(con.rs.getString("estado_civil"));
                modP.setContatos(con.rs.getString("contatos"));
                modP.setEmail(con.rs.getString("email"));
                
                modP.setConjuge(con.rs.getString("nome_conjuge"));
                modP.setDt_nasc_conjuge(con.rs.getString("dt_nasc_conjuge"));
                modP.setCpf_conjuge(con.rs.getString("cpf_conjuge"));
                modP.setContato_conjuge(con.rs.getString("contato_conjuge"));
                modP.setNome_empresa(con.rs.getString("nome_empresa"));
                modP.setContato_empresa(con.rs.getString("contato_empresa"));
                modP.setFuncao(con.rs.getString("funcao"));
                modP.setEndereco_empresa(con.rs.getString("endereco_empresa"));
                modP.setRenda(con.rs.getString("renda"));
                modP.setDt_admissao(con.rs.getString("dt_admissao"));

                modP.setEndereco(con.rs.getString("endereco"));
                modP.setBairro(con.rs.getString("bairro"));
                modP.setCidade(con.rs.getString("cidade"));
                modP.setEstado(con.rs.getString("estado"));
                modP.setMoradia(con.rs.getString("moradia"));
                modP.setComplemento(con.rs.getString("complemento"));
                modP.setCep(con.rs.getString("cep"));
                
            } else {
                JOptionPane.showMessageDialog(null, "NENHUM CADASTRO ENCONTRADO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO RETORNAR CLIENTE\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
        return modP;

    }

}
