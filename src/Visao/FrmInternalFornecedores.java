/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControleFornecedores;
import Modelo.ModeloFornecedores;
import Controle.ControleDocumentos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import Modelo.ModeloTabela;

/**
 *
 * @author Alexandre
 */
public class FrmInternalFornecedores extends javax.swing.JInternalFrame {

    private final ControleFornecedores cont;
    private final ControleDocumentos docs;

    public FrmInternalFornecedores() {
        initComponents();
        this.cont = new ControleFornecedores();
        this.docs = new ControleDocumentos();
        preencheTblaFornecedores();
    }

    public final void preencheTblaFornecedores() {

        String[] colunas = new String[]{"CODIGO", "NOME FORNECEDOR", "CNPJ"};
        ArrayList dados = cont.retornaListaFornecedores();

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblaFornecedores.setModel(modelo);
        tblaFornecedores.getColumnModel().getColumn(0).setMaxWidth(60);
        tblaFornecedores.getColumnModel().getColumn(1).setMaxWidth(400);
        tblaFornecedores.getColumnModel().getColumn(2).setMaxWidth(150);
        tblaFornecedores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public final void resetFrame() {

        lbStatus.setText("");
        tfCodigoFornecedor.setText("0000");
        tfCnpjFornecedor.setText("");
        tfNomeFornecedor.setText("");
        tfTelefoneCelular.setText("");
        tfTelefoneFixo.setText("");
        tfOutrosContatos.setText("");
        btSalvar.setEnabled(false);
        btExcluir.setEnabled(false);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfNomeFornecedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfCnpjFornecedor = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaFornecedores = new javax.swing.JTable();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tfTelefoneFixo = new javax.swing.JFormattedTextField();
        tfTelefoneCelular = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfOutrosContatos = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btCancelar1 = new javax.swing.JButton();
        painelCabecalho = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfCodigoFornecedor = new javax.swing.JTextField();
        lbStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Fornecedores");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfNomeFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNomeFornecedorKeyPressed(evt);
            }
        });

        jLabel1.setText("Nome Fornecedor (Razão Social) *");

        jLabel2.setText("Telefone Fixo");

        try {
            tfCnpjFornecedor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCnpjFornecedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCnpjFornecedor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCnpjFornecedorFocusLost(evt);
            }
        });
        tfCnpjFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCnpjFornecedorActionPerformed(evt);
            }
        });

        jLabel3.setText("CNPJ *");

        tblaFornecedores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblaFornecedores.setToolTipText("Tabela de Fornecedores");
        tblaFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaFornecedoresMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaFornecedores);

        btNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo24.png"))); // NOI18N
        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar24.png"))); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover.png"))); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.setEnabled(false);
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        try {
            tfTelefoneFixo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            tfTelefoneCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setText("Telefone Celular");

        jLabel5.setText("Outros Contatos");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/primeiro24.png"))); // NOI18N
        jButton1.setToolTipText("Primeiro");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/anterior24.png"))); // NOI18N
        jButton2.setToolTipText("Anterior");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo24.png"))); // NOI18N
        jButton3.setToolTipText("Proximo");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ultimo24.png"))); // NOI18N
        jButton4.setToolTipText("Ultimo");

        btCancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar24.png"))); // NOI18N
        btCancelar1.setText("Sair");
        btCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNomeFornecedor)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(tfCnpjFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfTelefoneCelular)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfOutrosContatos)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 80, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCancelar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCnpjFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefoneFixo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTelefoneCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfOutrosContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btCancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        painelCabecalho.setBackground(new java.awt.Color(102, 102, 102));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CODIGO :");

        tfCodigoFornecedor.setEditable(false);
        tfCodigoFornecedor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfCodigoFornecedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCodigoFornecedor.setText("0000");
        tfCodigoFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoFornecedorActionPerformed(evt);
            }
        });

        lbStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText(" ");

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCabecalhoLayout.createSequentialGroup()
                .addGap(196, 196, 196)
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoFornecedorActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCodigoFornecedorActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        if (!tfNomeFornecedor.getText().equals("") && tfCnpjFornecedor.getBackground().equals(Color.white)) {

            ModeloFornecedores mod = new ModeloFornecedores();
            mod.setNome_fornecedor(tfNomeFornecedor.getText());
            mod.setCnpj_fornecedor(tfCnpjFornecedor.getText());
            mod.setTel_fixo(tfTelefoneFixo.getText());
            mod.setTel_celular(tfTelefoneCelular.getText());
            mod.setOutros_contatos(tfOutrosContatos.getText());

            switch (lbStatus.getText()) {
                case "Cadastrando...":
                    cont.cadastrarFornecedor(mod);
                    break;
                case "Editando...":
                    mod.setId_fornecedor(Integer.parseInt(tfCodigoFornecedor.getText()));
                    cont.editarFornecedor(mod);
                    break;
            }

            preencheTblaFornecedores();
            resetFrame();

        } else {
            JOptionPane.showMessageDialog(null, "VERIFIQUE OS CAMPOS OBRIGATÓRIOS", "AVISO", JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:

        resetFrame();
        btSalvar.setEnabled(true);
        lbStatus.setText("Cadastrando...");
        lbStatus.setForeground(Color.green);
        tfCodigoFornecedor.setText(String.valueOf(cont.retornaUltimoID() + 1));

    }//GEN-LAST:event_btNovoActionPerformed

    private void tfCnpjFornecedorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCnpjFornecedorFocusLost
        // TODO add your handling code here:

        if (!docs.validaCNPJ(tfCnpjFornecedor.getText())) {
            tfCnpjFornecedor.setBackground(Color.red);
        } else {
            tfCnpjFornecedor.setBackground(Color.white);
        }

    }//GEN-LAST:event_tfCnpjFornecedorFocusLost

    private void tblaFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaFornecedoresMouseClicked
        // TODO add your handling code here:

        int id_forn = (int) tblaFornecedores.getValueAt(tblaFornecedores.getSelectedRow(), 0);
        String nome = (String) tblaFornecedores.getValueAt(tblaFornecedores.getSelectedRow(), 1);
        String cnpj = (String) tblaFornecedores.getValueAt(tblaFornecedores.getSelectedRow(), 2);

        if (evt.getClickCount() > 1) {
            ModeloFornecedores mod;
            mod = cont.retornaDadosFornecedor("select * from tbla_fornecedores where id_fornecedor = " + id_forn);
            tfCodigoFornecedor.setText(String.valueOf(id_forn));
            tfNomeFornecedor.setText(nome);
            tfCnpjFornecedor.setText(cnpj);
            tfTelefoneFixo.setText(mod.getTel_fixo());
            tfTelefoneCelular.setText(mod.getTel_celular());
            tfOutrosContatos.setText(mod.getOutros_contatos());
            lbStatus.setText("Editando...");
            lbStatus.setForeground(Color.yellow);
            btSalvar.setEnabled(true);
            btExcluir.setEnabled(true);

        }

    }//GEN-LAST:event_tblaFornecedoresMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR ESSE FORNECEDOR", "EXCLUIR?", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            cont.excluirFornecedor(Integer.parseInt(tfCodigoFornecedor.getText()));
            preencheTblaFornecedores();
            resetFrame();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        preencheTblaFornecedores();
        resetFrame();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfNomeFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNomeFornecedorKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfNomeFornecedorKeyPressed

    private void tfCnpjFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCnpjFornecedorActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCnpjFornecedorActionPerformed

    private void btCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelar1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCancelar1;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JTable tblaFornecedores;
    private javax.swing.JFormattedTextField tfCnpjFornecedor;
    private javax.swing.JTextField tfCodigoFornecedor;
    private javax.swing.JTextField tfNomeFornecedor;
    private javax.swing.JTextField tfOutrosContatos;
    private javax.swing.JFormattedTextField tfTelefoneCelular;
    private javax.swing.JFormattedTextField tfTelefoneFixo;
    // End of variables declaration//GEN-END:variables
}
