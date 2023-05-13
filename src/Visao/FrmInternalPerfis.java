/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Controle.ControleFuncionario;
import Modelo.ModeloPerfil;
import Modelo.ModeloTabela;
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;

/**
 *
 * @author YU7
 */
public class FrmInternalPerfis extends javax.swing.JInternalFrame {

    private ControleFuncionario func;

    public FrmInternalPerfis() {
        initComponents();
        tabelaFuncionarios();
    }

    public final void tabelaFuncionarios() {

        func = new ControleFuncionario();

        String[] colunas = new String[]{"CODIGO", "NOME FUNCIONÁRIO"};
        ArrayList dados = func.tabeladeFuncionarios();

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblaFuncionarios.setModel(modelo);
        tblaFuncionarios.getColumnModel().getColumn(0).setMaxWidth(60);
        tblaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblaFuncionarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public void selecionaCheckBoxs(boolean op) {

        for (int i = 0; i < jPanel1.getComponentCount(); i++) {
            if (this.jPanel1.getComponent(i) instanceof JCheckBox) {
                JCheckBox cb = (JCheckBox) jPanel1.getComponent(i);
                cb.setSelected(op);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaFuncionarios = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        check_cadClientes = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        check_cadProd = new javax.swing.JCheckBox();
        check_cadFornec = new javax.swing.JCheckBox();
        check_cadFuncio = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        check_consEstoque = new javax.swing.JCheckBox();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        check_consCaixas = new javax.swing.JCheckBox();
        check_movCaixa = new javax.swing.JCheckBox();
        check_movVendas = new javax.swing.JCheckBox();
        jSeparator3 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        check_relatVenda = new javax.swing.JCheckBox();
        check_relatEstoque = new javax.swing.JCheckBox();
        jSeparator4 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();

        setTitle("Perfis de Acesso");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOME FUNCIONARIO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaFuncionarios);

        check_cadClientes.setText("Cadastro de Clientes");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("CADASTROS");

        check_cadProd.setText("Cadastro de Produtos");

        check_cadFornec.setText("Cadastro de Fornecedores");

        check_cadFuncio.setText("Cadastro de Funcionários");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("CONSULTAS");

        check_consEstoque.setText("Consultar Estoque");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("MOVIMENTOS");

        check_consCaixas.setText("Consultar Caixas");

        check_movCaixa.setText("Iniciar / Finalizar Caixas");

        check_movVendas.setText("Iniciar / Finalizar Vendas");

        jButton1.setText("Salvar perfil");

        jButton2.setText("Marcar todos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Desmarcar todos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Sair");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("RELATÓRIOS");

        check_relatVenda.setText("Relatórios de Vendas");

        check_relatEstoque.setText("Relatórios de Estoque");

        jCheckBox1.setText("Perfis de Acesso");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("CONFIGURAÇÕES");

        jCheckBox2.setText("Configuração 1");

        jCheckBox3.setText("Configuração 2");

        jCheckBox4.setText("Configuração 3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(check_cadFornec)
                                            .addComponent(check_cadClientes))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(check_cadProd)
                                            .addComponent(check_cadFuncio)))
                                    .addComponent(jLabel4)
                                    .addComponent(check_relatVenda)
                                    .addComponent(check_relatEstoque)
                                    .addComponent(check_consCaixas)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(check_consEstoque))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(41, 41, 41)
                                                .addComponent(jLabel3))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(43, 43, 43)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(check_movCaixa)
                                                    .addComponent(check_movVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(jLabel5)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox1)
                                            .addComponent(jCheckBox2))
                                        .addGap(51, 51, 51)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jCheckBox4)
                                            .addComponent(jCheckBox3))))
                                .addGap(0, 44, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check_cadClientes)
                            .addComponent(check_cadProd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check_cadFornec)
                            .addComponent(check_cadFuncio))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check_consEstoque)
                            .addComponent(check_movVendas))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check_consCaixas)
                            .addComponent(check_movCaixa))
                        .addGap(9, 9, 9)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_relatVenda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_relatEstoque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox1)
                            .addComponent(jCheckBox3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox4)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        selecionaCheckBoxs(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        selecionaCheckBoxs(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tblaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaFuncionariosMouseClicked
        // TODO add your handling code here:
        
        if (evt.getClickCount() > 1) {
            
            String id = ""+tblaFuncionarios.getValueAt(tblaFuncionarios.getSelectedRow(), 0);
            ModeloPerfil mod = func.retornaPerfil(id);
            

            check_cadClientes.setSelected(mod.isCad_cliente());
            check_cadFornec.setSelected(mod.isCad_fornec());
            check_cadFuncio.setSelected(mod.isCad_funcio());
            check_cadProd.setSelected(mod.isCad_prod());
            
            check_consCaixas.setSelected(mod.isCons_caixa());
            check_consEstoque.setSelected(mod.isCons_estoque());
            check_movCaixa.setSelected(mod.isMov_caixas());
            check_movVendas.setSelected(mod.isMov_vendas());
            
            check_relatVenda.setSelected(mod.isRelat_venda());
            check_relatEstoque.setSelected(mod.isRelat_estoque());
                        
            
        }

    }//GEN-LAST:event_tblaFuncionariosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox check_cadClientes;
    private javax.swing.JCheckBox check_cadFornec;
    private javax.swing.JCheckBox check_cadFuncio;
    private javax.swing.JCheckBox check_cadProd;
    private javax.swing.JCheckBox check_consCaixas;
    private javax.swing.JCheckBox check_consEstoque;
    private javax.swing.JCheckBox check_movCaixa;
    private javax.swing.JCheckBox check_movVendas;
    private javax.swing.JCheckBox check_relatEstoque;
    private javax.swing.JCheckBox check_relatVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable tblaFuncionarios;
    // End of variables declaration//GEN-END:variables
}
