package Visao;

import Controle.ControleCaixa;
import Modelo.ModeloTabela;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Alexandre
 */
public class FrmInternalCaixas extends javax.swing.JInternalFrame {

    private final ControleCaixa cont;

    public FrmInternalCaixas() {
        this.cont = new ControleCaixa();
        initComponents();
        tabelaCaixas();
    }

    public final void tabelaCaixas() {

        String[] colunas = new String[]{"CAIXA", "MOVIMENTO", "VALOR INICIAL", "VALOR FINAL", "STATUS"};
        ArrayList dados = cont.retornaListaCaixas();

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblaCaixas.setModel(modelo);
        tblaCaixas.getColumnModel().getColumn(0).setMaxWidth(60);
        tblaCaixas.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblaCaixas.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblaCaixas.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblaCaixas.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblaCaixas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    public final void tabelaMovimentos(String dt_movimento) {

        String[] colunas = new String[]{"VENDA", "CLIENTE", "PAGAMENTO", "VALOR", "DESCONTO", "TOTAL", "STATUS", "INICIADA", "FINALIZADA", "FUNCIONARIO"};
        ArrayList dados = cont.movimentoCaixa(dt_movimento);

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblaMovimento.setModel(modelo);
        tblaMovimento.getColumnModel().getColumn(0).setMaxWidth(60);
        tblaMovimento.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(4).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(6).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(7).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(8).setPreferredWidth(100);
        tblaMovimento.getColumnModel().getColumn(9).setPreferredWidth(100);
        tblaMovimento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Calcula Valores em DINHEIRO
        DecimalFormat df = new DecimalFormat("###,###,##0.00");

        int linhas = tblaMovimento.getRowCount();
        String aux;
        double valor = 0.00;

        for (int i = 0; i < linhas; i++) {
            aux = "" + tblaMovimento.getValueAt(i, 5);
            valor = valor + Double.parseDouble(aux);
        }

        tfValorTotal.setText(df.format(valor));

    }

    public final void infoCaixa() {

        String data = "" + tblaCaixas.getValueAt(tblaCaixas.getSelectedRow(), 1);

        tabelaMovimentos(data);
        jTabbedPane1.setTitleAt(1, "Movimento " + data);
        jTabbedPane1.setSelectedIndex(1);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabecalho = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaCaixas = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btDetalhes = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblaMovimento = new javax.swing.JTable();
        tfValorDinheiro = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfValorCredito = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfValorCadastro = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        tfValorTotal = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();

        setResizable(true);
        setTitle("Consulta de Caixas");
        setToolTipText("");
        setMinimumSize(new java.awt.Dimension(600, 510));

        painelCabecalho.setBackground(new java.awt.Color(102, 102, 102));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblaCaixas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblaCaixas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaCaixasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaCaixas);

        btDetalhes.setText("Informações");
        btDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetalhesActionPerformed(evt);
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btDetalhes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        jTabbedPane1.addTab("Caixas", jPanel1);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblaMovimento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblaMovimento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tblaMovimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaMovimentoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblaMovimento);

        tfValorDinheiro.setEditable(false);
        tfValorDinheiro.setBackground(new java.awt.Color(255, 255, 255));
        tfValorDinheiro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorDinheiro.setText("0,00");

        jLabel3.setText("CARTÃO DE CREDITO / DÉBITO");

        tfValorCredito.setEditable(false);
        tfValorCredito.setBackground(new java.awt.Color(255, 255, 255));
        tfValorCredito.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorCredito.setText("0,00");

        jLabel4.setText("DINHEIRO");

        jLabel5.setText("CADASTRO");

        tfValorCadastro.setEditable(false);
        tfValorCadastro.setBackground(new java.awt.Color(255, 255, 255));
        tfValorCadastro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorCadastro.setText("0,00");

        tfValorTotal.setEditable(false);
        tfValorTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfValorTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorTotal.setText("0,00");

        jLabel7.setText("TOTAL");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novo24.png"))); // NOI18N
        jButton1.setText("Nova entrada");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Ok24.png"))); // NOI18N
        jButton2.setText("Finalizar Caixa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorDinheiro)
                            .addComponent(tfValorCadastro, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jSeparator3)
                            .addComponent(tfValorCredito, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValorTotal)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorCredito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Movimento", jPanel3);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar24.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tblaCaixasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaCaixasMouseClicked
        // TODO add your handling code here:
      
        if (evt.getClickCount() > 1) {
            infoCaixa();
        }
    }//GEN-LAST:event_tblaCaixasMouseClicked

    private void btDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetalhesActionPerformed
        // TODO add your handling code here:
        infoCaixa();
    }//GEN-LAST:event_btDetalhesActionPerformed

    private void tblaMovimentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaMovimentoMouseClicked
        // TODO add your handling code here:

        int selecao = tblaMovimento.getSelectedRow();

        if (evt.getClickCount() > 1) {

            String info = "";

            for (int i = 0; i < tblaMovimento.getColumnCount(); i++) {
                info += tblaMovimento.getColumnName(i) + ": " + tblaMovimento.getValueAt(selecao, i) + "\n";
            }

        }

    }//GEN-LAST:event_tblaMovimentoMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        int op = JOptionPane.showConfirmDialog(null, 
                "Movimentação CAIXA Nº está batendo?","Finalizar "+jTabbedPane1.getTitleAt(1), JOptionPane.YES_NO_OPTION);
        
        if(op == JOptionPane.YES_OPTION){
            this.dispose();
        }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDetalhes;
    private javax.swing.JButton btSair;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JTable tblaCaixas;
    private javax.swing.JTable tblaMovimento;
    private javax.swing.JTextField tfValorCadastro;
    private javax.swing.JTextField tfValorCredito;
    private javax.swing.JTextField tfValorDinheiro;
    private javax.swing.JTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables
}
