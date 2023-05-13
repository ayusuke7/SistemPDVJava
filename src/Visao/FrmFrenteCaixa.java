/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Visao;

import Visao.Dialogs.FrmDialogPesquisas;
import Controle.ControleDataHora;
import DAO.DAOConexao;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

/**
 *
 * @author Alexandre
 */
public class FrmFrenteCaixa extends javax.swing.JFrame {

    private final DAOConexao con;// = new DAOConexao();
    private ControleDataHora DtHr;// = new ControleDataHora();
    String cupom;

    public FrmFrenteCaixa() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.con = new DAOConexao();
        this.con.Conecta();
        this.DtHr = new ControleDataHora();
        tfPesquisaProduto.requestFocus();

        setAcessibilidade();

    }

    public boolean pesquisaProdutos(String paramentro) {

        String sql = "select id_produto, descricao, valor_venda, tipo from tbla_produtos where "
                + "(id_produto like '" + paramentro + "' "
                + "or (descricao like '%" + paramentro + "%') "
                + "or (cod_barras like '%" + paramentro + "%'))";
        try {
            con.executaSQL(sql);
            if (con.rs.first()) {
                tfCodigo.setText(String.valueOf(con.rs.getInt("id_produto")));
                tfDescricaoProd.setText(con.rs.getString("descricao"));
                tfValorUnitario.setText(con.rs.getString("valor_venda"));
                tfTipoQuant.setText(con.rs.getString("tipo"));
                return true;
            } else {
                JOptionPane.showMessageDialog(rootPane, "NENHUM ITEM/PROD ENCONTRADO", "AVISO", JOptionPane.OK_OPTION);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO NA PESQUISA DO PRODUTO\n" + ex, "AVISO", JOptionPane.OK_OPTION);
        }
        return false;
    }

    public final void setAcessibilidade() {

        getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        getRootPane().getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                btCancelar.doClick();
            }
        });

    }

    public void gravaCupom() {

        double vTotalAtual = Double.parseDouble(tfValorTotal.getText().replace(",", "."));
        double vSub = Double.parseDouble(tfSubTotal.getText().replace(",", "."));
        double total = vTotalAtual + vSub;
        tfValorTotal.setText(String.format("%.2f", total));

        cupom = tfCupomFiscal.getText() + "\n------------------------------\n"
                + tfQuantidade.getText() + " " + tfTipoQuant.getText() + " de "
                + tfDescricaoProd.getText() + ", R$"
                + tfValorUnitario.getText() + " --- Sub-Total R$"
                + tfSubTotal.getText();
        tfCupomFiscal.setText(cupom);
        limpaCampos();

    }

    public void limpaCampos() {

        tfDescricaoProd.setText("Digite Cod. Prod / Descrição / Cod. Barras");
        tfValorUnitario.setText("0,00");
        tfSubTotal.setText("0,00");
        tfQuantidade.setText("");
        tfDesconto.setText("");
        tfPesquisaProduto.setText("");
        tfPesquisaProduto.requestFocus();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelDescricoes = new javax.swing.JPanel();
        tfDescricaoProd = new javax.swing.JTextField();
        tfTipoQuant = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        painelCupomProd = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfCupomFiscal = new javax.swing.JTextArea();
        tfPesquisaProduto = new javax.swing.JTextField();
        painelValores = new javax.swing.JPanel();
        tfValorUnitario = new javax.swing.JTextField();
        tfSubTotal = new javax.swing.JTextField();
        tfQuantidade = new javax.swing.JTextField();
        tfValorTotal = new javax.swing.JTextField();
        tfDesconto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        painelFuncoes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Frente de Caixa");
        setResizable(false);

        painelDescricoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfDescricaoProd.setEditable(false);
        tfDescricaoProd.setBackground(new java.awt.Color(255, 255, 255));
        tfDescricaoProd.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        tfDescricaoProd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDescricaoProd.setText("Digite Cod. Prod / Descrição / Cod. Barras");

        tfTipoQuant.setEditable(false);
        tfTipoQuant.setBackground(new java.awt.Color(255, 255, 255));
        tfTipoQuant.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        tfTipoQuant.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfCodigo.setEditable(false);
        tfCodigo.setBackground(new java.awt.Color(255, 255, 255));
        tfCodigo.setFont(new java.awt.Font("Courier New", 0, 24)); // NOI18N
        tfCodigo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout painelDescricoesLayout = new javax.swing.GroupLayout(painelDescricoes);
        painelDescricoes.setLayout(painelDescricoesLayout);
        painelDescricoesLayout.setHorizontalGroup(
            painelDescricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDescricaoProd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTipoQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelDescricoesLayout.setVerticalGroup(
            painelDescricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDescricoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDescricoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfDescricaoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTipoQuant)
                    .addComponent(tfCodigo))
                .addContainerGap())
        );

        painelCupomProd.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfCupomFiscal.setEditable(false);
        tfCupomFiscal.setBackground(new java.awt.Color(255, 255, 204));
        tfCupomFiscal.setColumns(20);
        tfCupomFiscal.setLineWrap(true);
        tfCupomFiscal.setRows(5);
        tfCupomFiscal.setWrapStyleWord(true);
        tfCupomFiscal.setBorder(javax.swing.BorderFactory.createTitledBorder("Cupom"));
        jScrollPane1.setViewportView(tfCupomFiscal);

        tfPesquisaProduto.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        tfPesquisaProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPesquisaProduto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Codigo / Descrição / Cod.Barras"));
        tfPesquisaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPesquisaProdutoActionPerformed(evt);
            }
        });
        tfPesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisaProdutoKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout painelCupomProdLayout = new javax.swing.GroupLayout(painelCupomProd);
        painelCupomProd.setLayout(painelCupomProdLayout);
        painelCupomProdLayout.setHorizontalGroup(
            painelCupomProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCupomProdLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCupomProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE)
                    .addComponent(tfPesquisaProduto))
                .addContainerGap())
        );
        painelCupomProdLayout.setVerticalGroup(
            painelCupomProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCupomProdLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelValores.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tfValorUnitario.setEditable(false);
        tfValorUnitario.setBackground(new java.awt.Color(255, 255, 255));
        tfValorUnitario.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfValorUnitario.setForeground(new java.awt.Color(0, 0, 204));
        tfValorUnitario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfValorUnitario.setText("0,00");
        tfValorUnitario.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Valor Un."));

        tfSubTotal.setEditable(false);
        tfSubTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfSubTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfSubTotal.setForeground(new java.awt.Color(0, 0, 204));
        tfSubTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSubTotal.setText("0,00");
        tfSubTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Sub-total"));

        tfQuantidade.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfQuantidade.setForeground(new java.awt.Color(0, 0, 204));
        tfQuantidade.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfQuantidade.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Quantidade"));
        tfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfQuantidadeActionPerformed(evt);
            }
        });
        tfQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfQuantidadeKeyReleased(evt);
            }
        });

        tfValorTotal.setEditable(false);
        tfValorTotal.setBackground(new java.awt.Color(255, 255, 255));
        tfValorTotal.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        tfValorTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfValorTotal.setText("0,00");
        tfValorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Total da Venda"));

        tfDesconto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        tfDesconto.setForeground(new java.awt.Color(0, 0, 204));
        tfDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDesconto.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Desconto %"));
        tfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescontoActionPerformed(evt);
            }
        });
        tfDesconto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfDescontoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDescontoKeyReleased(evt);
            }
        });

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SEM FOTO ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout painelValoresLayout = new javax.swing.GroupLayout(painelValores);
        painelValores.setLayout(painelValoresLayout);
        painelValoresLayout.setHorizontalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfValorTotal, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfValorUnitario)
                    .addComponent(tfSubTotal)
                    .addComponent(tfQuantidade)
                    .addComponent(tfDesconto))
                .addContainerGap())
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        painelValoresLayout.setVerticalGroup(
            painelValoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelValoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(tfValorUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tfSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        painelFuncoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SAIR (ESC)");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btBuscar.setText("BUSCAR (F2)");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jButton4.setText("EXCLUIR (F3)");

        jButton5.setText("FINALIZAR VENDA (F9)");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR (F7)");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelFuncoesLayout = new javax.swing.GroupLayout(painelFuncoes);
        painelFuncoes.setLayout(painelFuncoesLayout);
        painelFuncoesLayout.setHorizontalGroup(
            painelFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        painelFuncoesLayout.setVerticalGroup(
            painelFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelFuncoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btBuscar)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(btCancelar))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelFuncoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCupomProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelValores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
            .addComponent(painelDescricoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelDescricoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(painelCupomProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(painelValores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelFuncoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfPesquisaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPesquisaProdutoActionPerformed
        // TODO add your handling code here:

        if (tfPesquisaProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "INSIRA CODIGO / DESCRICAO / COD.BARRA", "AVISO", JOptionPane.OK_OPTION);
            tfPesquisaProduto.requestFocus();
        } else if (pesquisaProdutos(tfPesquisaProduto.getText())) {
            tfQuantidade.requestFocus();
            tfQuantidade.setText("1");
        }
    }//GEN-LAST:event_tfPesquisaProdutoActionPerformed

    private void tfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfQuantidadeActionPerformed
        // TODO add your handling code here:
        tfDesconto.requestFocus();
    }//GEN-LAST:event_tfQuantidadeActionPerformed

    private void tfQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfQuantidadeKeyPressed

    private void tfQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfQuantidadeKeyReleased
        // TODO add your handling code here:

        if (!tfQuantidade.getText().equals("")) {
            double vUn = Double.parseDouble(tfValorUnitario.getText().replace(",", "."));
            int quant = Integer.parseInt(tfQuantidade.getText());
            double subTotal = vUn * quant;
            tfSubTotal.setText(String.format("%.2f", subTotal));
        }
    }//GEN-LAST:event_tfQuantidadeKeyReleased

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:

        String sql = "select id_produto, descricao, cod_barras from tbla_produtos order by id_produto";
        String[] col = {"CODIGO", "DESCRIÇÃO", "COD. DE BARRAS"};
        int[] larg = {20, 300, 60};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {

        }

    }//GEN-LAST:event_btBuscarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        con.Desconecta();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoActionPerformed
        // TODO add your handling code here:

        if (tfQuantidade.getText().equals("") || tfQuantidade.getText().equals("0")) {
            limpaCampos();
        } else {
            gravaCupom();
        }

    }//GEN-LAST:event_tfDescontoActionPerformed

    private void tfDescontoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescontoKeyPressed

    private void tfDescontoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDescontoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDescontoKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void tfPesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisaProdutoKeyPressed
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (tfPesquisaProduto.getText().equals("")) {
                tfDescricaoProd.setText("Digite Cod. Prod / Descrição / Cod. Barras");
                tfValorUnitario.setText("0,00");
                tfValorTotal.setText("0,00");
            } else {
                pesquisaProdutos(tfPesquisaProduto.getText());
            }

        }


    }//GEN-LAST:event_tfPesquisaProdutoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmFrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmFrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmFrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmFrenteCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new FrmFrenteCaixa().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel painelCupomProd;
    private javax.swing.JPanel painelDescricoes;
    private javax.swing.JPanel painelFuncoes;
    private javax.swing.JPanel painelValores;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextArea tfCupomFiscal;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfDescricaoProd;
    private javax.swing.JTextField tfPesquisaProduto;
    private javax.swing.JTextField tfQuantidade;
    private javax.swing.JTextField tfSubTotal;
    private javax.swing.JTextField tfTipoQuant;
    private javax.swing.JTextField tfValorTotal;
    private javax.swing.JTextField tfValorUnitario;
    // End of variables declaration//GEN-END:variables
}
