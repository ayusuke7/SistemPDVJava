package Visao.Dialogs;

import DAO.DAOConexao;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class FrmDialogPagamento extends javax.swing.JDialog {

    private final DAOConexao con;
    private boolean confirma = false;
    private int forma_pagamento;

    public FrmDialogPagamento(java.awt.Frame parent, boolean modal, String valor_total) {
        super(parent, modal);
        initComponents();
        this.con = new DAOConexao();
        con.Conecta();
        tfValorTotal.setText(valor_total);
        preencheCbFormaPagamento();

    }

    public final void preencheCbFormaPagamento() {

        con.executaSQL("select * from tbla_forma_pagamento where id_forma_pag > 1");
        try {
            if (con.rs.first()) {
                do {
                    cbFormaPagamento.addItem(con.rs.getString("descricao"));
                } while (con.rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma forma de pagamento cadastrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher CBformasdePagamentos\n" + ex);
        }

    }

    public int retornaCodFormaPagamento() {

        int id = 0;
        try {
            con.executaSQL("select * from tbla_forma_pagamento where descricao ='" + cbFormaPagamento.getSelectedItem() + "'");
            if (con.rs.first()) {
                id = con.rs.getInt("id_forma_pag");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhuma forma de pagamento encontrada");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao retornarCodFormaPagamento\n" + ex);
        }
        return id;
    }

    public void calculaTroco() {

        tfValorRecebido.setForeground(Color.blue);

        double vtotal = Double.parseDouble(tfValorTotal.getText().replace(",", "."));
        double vreceb = Double.parseDouble(tfValorRecebido.getText().replace(",", "."));
        double troco = vreceb - vtotal;

        if (vreceb >= vtotal) {
            tfValorRecebido.setForeground(Color.blue);
            tfTroco.setForeground(Color.blue);
            tfTroco.setText(String.format("%.2f", troco));
        } else {
            tfTroco.setForeground(Color.red);
            tfTroco.setText(String.format("%.2f", troco));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbFormaPagamento = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btFinalizar = new javax.swing.JButton();
        tfValorTotal = new javax.swing.JFormattedTextField();
        tfValorRecebido = new javax.swing.JFormattedTextField();
        tfTroco = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Forma de Pagamento");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Valor total R$ ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Valor recebido R$ ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Troco R$");

        btFinalizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btFinalizar.setText("RECEBER");
        btFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarActionPerformed(evt);
            }
        });

        tfValorTotal.setEditable(false);
        tfValorTotal.setBackground(new java.awt.Color(255, 255, 204));
        tfValorTotal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorTotal.setText("0,00");
        tfValorTotal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        tfValorRecebido.setForeground(new java.awt.Color(51, 0, 255));
        tfValorRecebido.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorRecebido.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorRecebido.setText("0,00");
        tfValorRecebido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfValorRecebido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorRecebidoFocusLost(evt);
            }
        });
        tfValorRecebido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorRecebidoActionPerformed(evt);
            }
        });

        tfTroco.setEditable(false);
        tfTroco.setBackground(new java.awt.Color(255, 255, 255));
        tfTroco.setForeground(new java.awt.Color(51, 0, 255));
        tfTroco.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfTroco.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfTroco.setText("0,00");
        tfTroco.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                    .addComponent(btFinalizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(cbFormaPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(tfValorTotal)
                    .addComponent(tfValorRecebido, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfTroco))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorRecebido, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTroco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addComponent(btFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarActionPerformed
        // TODO add your handling code here:

        double troco = Double.parseDouble(tfTroco.getText().replace(",", "."));

        if (!tfValorRecebido.getText().equals("0,00")) {
            if (troco >= 0) {
                setConfirma(true);
                setForma_pagamento(retornaCodFormaPagamento());
                con.Desconecta();
                this.dispose();
            } else {
                tfValorRecebido.setBackground(Color.yellow);
            }
        }else{
            tfValorRecebido.setBackground(Color.yellow);
        }

    }//GEN-LAST:event_btFinalizarActionPerformed

    private void tfValorRecebidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorRecebidoFocusLost
        // TODO add your handling code here:
        calculaTroco();
    }//GEN-LAST:event_tfValorRecebidoFocusLost

    private void tfValorRecebidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorRecebidoActionPerformed
        // TODO add your handling code here:
        tfTroco.requestFocus();
    }//GEN-LAST:event_tfValorRecebidoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizar;
    private javax.swing.JComboBox<String> cbFormaPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JFormattedTextField tfTroco;
    private javax.swing.JFormattedTextField tfValorRecebido;
    private javax.swing.JFormattedTextField tfValorTotal;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the confirma
     */
    public boolean isConfirma() {
        return confirma;
    }

    /**
     * @param confirma the confirma to set
     */
    public void setConfirma(boolean confirma) {
        this.confirma = confirma;
    }

    /**
     * @return the forma_pagamento
     */
    public int getForma_pagamento() {
        return forma_pagamento;
    }

    /**
     * @param forma_pagamento the forma_pagamento to set
     */
    public void setForma_pagamento(int forma_pagamento) {
        this.forma_pagamento = forma_pagamento;
    }
}
