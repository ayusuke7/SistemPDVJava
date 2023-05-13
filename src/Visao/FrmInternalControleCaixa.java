package Visao;

import Controle.ControleCaixa;
import Controle.ControleDataHora;
import Modelo.ModeloCaixa;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class FrmInternalControleCaixa extends javax.swing.JInternalFrame {

    private final ControleCaixa caixas;

    public FrmInternalControleCaixa() {
        initComponents();
        this.caixas = new ControleCaixa();
        setInformacoes();

    }

    public final void setInformacoes() {
        
        ModeloCaixa mod = caixas.retornaCaixaAberto();
        
        if (mod != null) {
            tfCodigo.setText(String.valueOf(mod.getId_caixa()));
            tfDataMovimento.setText(mod.getData());
            tfValorInicial.setText(mod.getValor_inicial());
            lbInforma.setText(mod.getStatus());
            btIniciarMovimento.setEnabled(false);
            tfValorInicial.setEditable(false);
        } else {
            tfCodigo.setText(String.valueOf(caixas.retornaUltimoID()+1));
            tfDataMovimento.setText(new ControleDataHora().retornaData());
            btFinalizarMov.setEnabled(false);
            tfValorInicial.setEditable(true);
            lbInforma.setText("Aguardando Abertura");
            lbInforma.setForeground(Color.BLUE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btIniciarMovimento = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfDataMovimento = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        tfValorInicial = new javax.swing.JFormattedTextField();
        btFinalizarMov = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbInforma = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        tfCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Movimentação");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btIniciarMovimento.setText("Iniciar Movimento");
        btIniciarMovimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIniciarMovimentoActionPerformed(evt);
            }
        });

        jLabel1.setText("Data do movimento");

        tfDataMovimento.setEditable(false);
        tfDataMovimento.setBackground(new java.awt.Color(255, 255, 255));
        try {
            tfDataMovimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDataMovimento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDataMovimento.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel3.setText("Valor Inicial R$");

        tfValorInicial.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorInicial.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorInicial.setText("0,00");
        tfValorInicial.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btFinalizarMov.setText("Finalizar Movimento");
        btFinalizarMov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarMovActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("STATUS DO CAIXA");

        lbInforma.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbInforma.setForeground(new java.awt.Color(0, 153, 51));
        lbInforma.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbInforma.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbInforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btIniciarMovimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btFinalizarMov))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDataMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfValorInicial)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDataMovimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addGap(9, 9, 9)
                .addComponent(lbInforma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btFinalizarMov)
                    .addComponent(btIniciarMovimento))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfCodigo.setEditable(false);
        tfCodigo.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CAIXA Nº :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(tfCodigo)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btIniciarMovimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIniciarMovimentoActionPerformed
        // TODO add your handling code here:

        Modelo.ModeloCaixa mod = new ModeloCaixa();
        mod.setData(tfDataMovimento.getText());
        mod.setValor_inicial(tfValorInicial.getText());
        mod.setStatus("Aberto");

        if (caixas.aberturaCaixa(mod)) {
            JOptionPane.showMessageDialog(null, "Movimento " + tfDataMovimento.getText() + " Liberado");
            this.dispose();
        }

    }//GEN-LAST:event_btIniciarMovimentoActionPerformed

    private void btFinalizarMovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarMovActionPerformed
        // TODO add your handling code here:
        
        ModeloCaixa mod = new ModeloCaixa();
        
        mod.setStatus("Fechado");
        mod.setId_caixa(Integer.parseInt(tfCodigo.getText()));
        
        if(caixas.fechamentoCaixa(mod)){
           JOptionPane.showMessageDialog(null, "Movimento " + tfDataMovimento.getText() + " Finalizado");
           this.dispose();
        }
        
        
    }//GEN-LAST:event_btFinalizarMovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFinalizarMov;
    private javax.swing.JButton btIniciarMovimento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbInforma;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JFormattedTextField tfDataMovimento;
    private javax.swing.JFormattedTextField tfValorInicial;
    // End of variables declaration//GEN-END:variables
}
