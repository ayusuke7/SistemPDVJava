package Visao;

import Visao.Dialogs.FrmDialogListas;
import Controle.ControleArquivos;
import DAO.DAOConexao;
import Controle.ControleDocumentos;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class FrmEmpresa extends javax.swing.JFrame {

    private final ControleDocumentos docs;
    private final DAOConexao con;
    int id_empresa;

    public FrmEmpresa() {
        initComponents();
        this.docs = new ControleDocumentos();
        this.con = new DAOConexao();
        con.Conecta();
        setDados();
    }

    public final void setDados() {

        try {
            con.executaSQL("select * from tbla_empresa");
            if (con.rs.first()) {
                id_empresa = con.rs.getInt("id_empresa");
                tfRazao_social.setText(con.rs.getString("razao_social"));
                tfNome_fantasia.setText(con.rs.getString("nome_fantasia"));
                tfCnpjEmpresa.setText(con.rs.getString("cnpj"));
                tfInsc_estadual.setText(con.rs.getString("insc_estadual"));
                tfContato.setText(con.rs.getString("contato"));
                tfEmail.setText(con.rs.getString("email"));
                tfEndereco.setText(con.rs.getString("endereco"));
                tfBairro.setText(con.rs.getString("bairro"));
                tfCidade.setText(con.rs.getString("cidade"));
                cbEstados.setSelectedItem(con.rs.getString("estado"));
                tfRamoAtividade.setText(con.rs.getString("ramo"));
                tfSite.setText(con.rs.getString("site"));
                this.setTitle(tfRazao_social.getText());
            }else{
                this.setTitle("Cadastrando...");
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO ao setar informações da empresa\n" + ex);
        }
        
    }

    public final void cadastrarInformacoes() {

        try {
            PreparedStatement pst = con.con.prepareStatement("insert into tbla_empresa "
                    + "(razao_social, nome_fantasia, cnpj, insc_estadual, contato, email, "
                    + "endereco, bairro, cidade, estado, ramo, site) "
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, tfRazao_social.getText());
            pst.setString(2, tfNome_fantasia.getText());
            pst.setString(3, tfCnpjEmpresa.getText());
            pst.setString(4, tfInsc_estadual.getText());
            pst.setString(5, tfContato.getText());
            pst.setString(6, tfEmail.getText());
            pst.setString(7, tfEndereco.getText());
            pst.setString(8, tfBairro.getText());
            pst.setString(9, tfCidade.getText());
            pst.setString(10, String.valueOf(cbEstados.getSelectedItem()));
            pst.setString(11, tfRamoAtividade.getText());
            pst.setString(12, tfSite.getText());
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "DADOS EMPRESARIAS CADASTRADOS");
            this.dispose();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO ao cadastrar empresa\n" + ex);
        }
    }

    public final void editarInformacoes() {

        con.Conecta();
        try {
            PreparedStatement pst = con.con.prepareStatement("update tbla_empresa set "
                    + "razao_social=?, nome_fantasia=?, cnpj=?, insc_estadual=?, contato=?, email=?, "
                    + "endereco=?, bairro=?, cidade=?, estado=?, ramo=?, site=? where id_empresa=?");
            pst.setString(1, tfRazao_social.getText());
            pst.setString(2, tfNome_fantasia.getText());
            pst.setString(3, tfCnpjEmpresa.getText());
            pst.setString(4, tfInsc_estadual.getText());
            pst.setString(5, tfContato.getText());
            pst.setString(6, tfEmail.getText());
            pst.setString(7, tfEndereco.getText());
            pst.setString(8, tfBairro.getText());
            pst.setString(9, tfCidade.getText());
            pst.setString(10, String.valueOf(cbEstados.getSelectedItem()));
            pst.setString(11, tfRamoAtividade.getText());
            pst.setString(12, tfSite.getText());
            pst.setInt(13, id_empresa);
            pst.execute();
            JOptionPane.showMessageDialog(rootPane, "DADOS EMPRESARIAS ATUALIZADOS");
            this.dispose();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO ao atualizar empresa\n" + ex);
        }
        con.Desconecta();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfRazao_social = new javax.swing.JTextField();
        tfCnpjEmpresa = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfNome_fantasia = new javax.swing.JTextField();
        tfInsc_estadual = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tfEndereco = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        tfBairro = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        cbEstados = new javax.swing.JComboBox<>();
        btLista = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        tfCidade = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        tfContato = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfSite = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        tfRamoAtividade = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();
        tfEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Razão Social *");

        try {
            tfCnpjEmpresa.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCnpjEmpresa.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCnpjEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCnpjEmpresaFocusLost(evt);
            }
        });
        tfCnpjEmpresa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCnpjEmpresaActionPerformed(evt);
            }
        });

        jLabel2.setText("CNPJ *");

        jLabel3.setText("Nome Fantasia *");

        jLabel4.setText("Inscrição Estadual");

        jLabel41.setText("Endereço : (Rua, Nº,  Quadra, Praça)*");

        jLabel49.setText("Bairro");

        jLabel38.setText("UF - Estado");

        cbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        btLista.setText("...");
        btLista.setToolTipText("Pesquisa");
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });

        jLabel37.setText("Cidade*");

        jLabel5.setText("Contato");

        jLabel6.setText("Page / Website");

        jLabel7.setText("Ramo de Atividade *");

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar24.png"))); // NOI18N
        btSalvar.setText("Salvar informações");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        jLabel9.setText("Email");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar24.png"))); // NOI18N
        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel41)
                            .addComponent(jLabel38))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfBairro)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(tfRamoAtividade)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNome_fantasia)
                            .addComponent(tfRazao_social)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tfCnpjEmpresa, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(tfInsc_estadual))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLista, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 297, Short.MAX_VALUE))
                            .addComponent(tfContato)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(286, 286, 286)
                                .addComponent(jLabel9)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfSite, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRazao_social, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCnpjEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNome_fantasia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfInsc_estadual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfRamoAtividade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel37)
                        .addComponent(jLabel38)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLista)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel9))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Dados fornecidos no cadastro da Empresa/Loja, servirão para montagem dos relatórios");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("envolvendo o PDV cedente em questão ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(34, Short.MAX_VALUE)
                    .addComponent(jLabel10)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfCnpjEmpresaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCnpjEmpresaFocusLost
        // TODO add your handling code here:

        if (!docs.validaCNPJ(tfCnpjEmpresa.getText())) {
            tfCnpjEmpresa.setBackground(Color.red);
        } else {
            tfCnpjEmpresa.setBackground(Color.white);
        }
    }//GEN-LAST:event_tfCnpjEmpresaFocusLost

    private void tfCnpjEmpresaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCnpjEmpresaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCnpjEmpresaActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
        // TODO add your handling code here:

        ControleArquivos arq = new ControleArquivos();
        String estado = (String) cbEstados.getSelectedItem();
        ArrayList dados = arq.retornaListaLinhas("C:\\SistemaPDV\\cidades\\" + estado + ".txt");

        FrmDialogListas frm = new FrmDialogListas(new JFrame(), true, dados);
        frm.setTitle("Lista de cidades UF - " + estado);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            tfCidade.setText(frm.getValor());
        }
    }//GEN-LAST:event_btListaActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:       
        
        if(this.getTitle().equals("Cadastrando...")){
            cadastrarInformacoes();
        }else{
            editarInformacoes();
        }
        
    }//GEN-LAST:event_btSalvarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        con.Desconecta();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLista;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JFormattedTextField tfCnpjEmpresa;
    private javax.swing.JTextField tfContato;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfInsc_estadual;
    private javax.swing.JTextField tfNome_fantasia;
    private javax.swing.JTextField tfRamoAtividade;
    private javax.swing.JTextField tfRazao_social;
    private javax.swing.JTextField tfSite;
    // End of variables declaration//GEN-END:variables
}
