package Visao;

import Controle.ControleCaixa;
import Controle.ControleDataHora;
import Visao.Dialogs.FrmDialogEscolhaVenda;
import Visao.Dialogs.FrmDialogGruposProd;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Alexandre
 */
public class FrmPrincipalPDV extends javax.swing.JFrame {
    
    private final ControleDataHora dt_hr;
    
    public FrmPrincipalPDV() {
        initComponents();
        setExtendedState(this.getExtendedState() | MAXIMIZED_BOTH);
        setTemas();
        dt_hr = new ControleDataHora();
    }
    
    public final void setDetalhes(String funcionario, String id_funcionario) {
        
        tfFuncionario.setText(funcionario);
        tfCodigo.setText(id_funcionario);
        lbStatus.setText("Conectado");
    }
    
    private void setTemas() {

        //Altera o Tema atraves do LookAndFeel
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao aplicar TEMA\n" + ex);
        }
        
    }
    
    private void iniciarFrames(JInternalFrame frame) {
        
        jDesktopPrincipal.add(frame);
        frame.setVisible(true);
        
        Dimension d = this.jDesktopPrincipal.getSize();
        int largura = (d.width - frame.getSize().width) / 2;
        int altura = (d.height - frame.getSize().height) / 2;
        frame.setLocation(largura, altura);
        
    }
    
    private void iniciarVenda(int tipo) {
        
        ControleCaixa caixa = new ControleCaixa();
        
        if (caixa.retornaCaixaAberto() != null) {
            iniciarFrames(new FrmInternalVendas(tfCodigo.getText(), tfFuncionario.getText(), tipo));
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum CAIXA Aberto\n"
                    + "Inicie uma movimentação para efetuar a venda!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        barraAtalhos = new javax.swing.JToolBar();
        jButton8 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btFrenteLoja = new javax.swing.JButton();
        btVenda = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jDesktopPrincipal = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbStatus = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfFuncionario = new javax.swing.JTextField();
        tfCodigo = new javax.swing.JTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuPerfis = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenuClientes = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuProdutos = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuFuncionarios = new javax.swing.JMenuItem();
        jMenuFornecedores = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuSair = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuVendaAVista = new javax.swing.JMenuItem();
        jMenuVendaAPrazo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SistemaPDV");
        setMinimumSize(new java.awt.Dimension(700, 500));

        barraAtalhos.setFloatable(false);
        barraAtalhos.setRollover(true);

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Identification card.png"))); // NOI18N
        jButton8.setText("Empresa");
        jButton8.setFocusable(false);
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        barraAtalhos.add(jButton8);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/User.png"))); // NOI18N
        jButton2.setText("Usuários");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        barraAtalhos.add(jButton2);

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Wallet2.png"))); // NOI18N
        jButton5.setText("Caixas");
        jButton5.setFocusable(false);
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        barraAtalhos.add(jButton5);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Zoom.png"))); // NOI18N
        jButton4.setText("Estoque");
        jButton4.setToolTipText("");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        barraAtalhos.add(jButton4);

        btFrenteLoja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Shop.png"))); // NOI18N
        btFrenteLoja.setText("Frente Loja");
        btFrenteLoja.setFocusable(false);
        btFrenteLoja.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btFrenteLoja.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btFrenteLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFrenteLojaActionPerformed(evt);
            }
        });
        barraAtalhos.add(btFrenteLoja);

        btVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/basket.png"))); // NOI18N
        btVenda.setText("Venda");
        btVenda.setFocusable(false);
        btVenda.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btVenda.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVendaActionPerformed(evt);
            }
        });
        barraAtalhos.add(btVenda);
        barraAtalhos.add(jSeparator4);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Power.png"))); // NOI18N
        jButton6.setText("Sair");
        jButton6.setFocusable(false);
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        barraAtalhos.add(jButton6);

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Orb info.png"))); // NOI18N
        jButton7.setText("Sobre");
        jButton7.setFocusable(false);
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        barraAtalhos.add(jButton7);

        jDesktopPrincipal.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Logomarca aqui");

        jDesktopPrincipal.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPrincipalLayout = new javax.swing.GroupLayout(jDesktopPrincipal);
        jDesktopPrincipal.setLayout(jDesktopPrincipalLayout);
        jDesktopPrincipalLayout.setHorizontalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDesktopPrincipalLayout.setVerticalGroup(
            jDesktopPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("FUNCIONÁRIO : ");

        tfFuncionario.setEditable(false);
        tfFuncionario.setBackground(new java.awt.Color(255, 255, 255));

        tfCodigo.setEditable(false);
        tfCodigo.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tfFuncionario)
            .addComponent(tfCodigo)
        );

        jMenu1.setText("Cadastros");

        jMenu4.setText("Configurações");

        jMenuItem6.setText("Informações Empresa / PDV");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuPerfis.setText("Perfis de Acesso");
        jMenuPerfis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPerfisActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuPerfis);

        jMenu1.add(jMenu4);
        jMenu1.add(jSeparator3);

        jMenuClientes.setText("Cadastro de Clientes");
        jMenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuClientesActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuClientes);

        jMenu7.setText("Cadastro de Produtos");

        jMenuProdutos.setText("Produtos");
        jMenuProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProdutosActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuProdutos);

        jMenuItem4.setText("Grupos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem4);

        jMenu1.add(jMenu7);

        jMenuFuncionarios.setText("Cadastro de Funcionários");
        jMenuFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFuncionariosActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuFuncionarios);

        jMenuFornecedores.setText("Cadastro de Fornecedores");
        jMenuFornecedores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenuFornecedoresMouseClicked(evt);
            }
        });
        jMenuFornecedores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFornecedoresActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuFornecedores);
        jMenu1.add(jSeparator2);

        jMenuSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuSair.setText("Sair");
        jMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSairActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSair);

        jMenuBar1.add(jMenu1);

        jMenu5.setText("Consultas");

        jMenuItem7.setText("Estoque ");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuBar1.add(jMenu5);

        jMenu6.setText("Movimentação");

        jMenuItem8.setText("Abertura / Fechamento Caixa");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);
        jMenu6.add(jSeparator1);

        jMenuItem10.setText("Consultar Caixas");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem10);

        jMenuBar1.add(jMenu6);

        jMenu3.setText("Vendas");

        jMenuItem3.setText("Iniciar Frente de Loja");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuVendaAVista.setText("Venda a Vista");
        jMenuVendaAVista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVendaAVistaActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuVendaAVista);

        jMenuVendaAPrazo.setText("Venda a Prazo");
        jMenuVendaAPrazo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuVendaAPrazoActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuVendaAPrazo);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Ajuda");

        jMenuItem1.setText("Manual");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Sobre");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barraAtalhos, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
            .addComponent(jDesktopPrincipal)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(barraAtalhos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPrincipal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuClientesActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalClientes());
    }//GEN-LAST:event_jMenuClientesActionPerformed

    private void jMenuFornecedoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFornecedoresActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalFornecedores());
    }//GEN-LAST:event_jMenuFornecedoresActionPerformed

    private void jMenuProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProdutosActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalProdutos());
    }//GEN-LAST:event_jMenuProdutosActionPerformed

    private void jMenuFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFuncionariosActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalFuncionarios());
    }//GEN-LAST:event_jMenuFuncionariosActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new FrmFrenteCaixa().setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuVendaAVistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVendaAVistaActionPerformed
        // TODO add your handling code here:
        iniciarVenda(1);
    }//GEN-LAST:event_jMenuVendaAVistaActionPerformed

    private void jMenuVendaAPrazoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuVendaAPrazoActionPerformed
        // TODO add your handling code here:
        iniciarVenda(2);
    }//GEN-LAST:event_jMenuVendaAPrazoActionPerformed

    private void jMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSairActionPerformed
        // TODO add your handling code here:
        if (jDesktopPrincipal.getAllFrames().length > 0) {
            JOptionPane.showMessageDialog(null, "Finaliza todos os môdulos antes de sair do Sistema!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.exit(0);
        }

    }//GEN-LAST:event_jMenuSairActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        FrmEmpresa frm = new FrmEmpresa();
        frm.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuFornecedoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuFornecedoresMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jMenuFornecedoresMouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalEstoque());
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalControleCaixa());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalCaixas());
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenuPerfisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPerfisActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalPerfis());
    }//GEN-LAST:event_jMenuPerfisActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        iniciarFrames(new FrmInternalEstoque());
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btFrenteLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFrenteLojaActionPerformed
        // TODO add your handling code here:
        new FrmFrenteCaixa().setVisible(true);
    }//GEN-LAST:event_btFrenteLojaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:

        if (jDesktopPrincipal.getAllFrames().length > 0) {
            JOptionPane.showMessageDialog(null, "Finalize todos os môdulos\nAntes de sair do Sistema!", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            System.exit(0);
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        new FrmEmpresa().setVisible(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVendaActionPerformed
        // TODO add your handling code here:

        FrmDialogEscolhaVenda choose = new FrmDialogEscolhaVenda(this, true);
        choose.setVisible(true);
        
        if (choose.isConfirma()) {
            iniciarVenda(choose.getTipo());
        }

    }//GEN-LAST:event_btVendaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new FrmDialogGruposProd(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here
        iniciarFrames(new FrmInternalCaixas());
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToolBar barraAtalhos;
    private javax.swing.JButton btFrenteLoja;
    private javax.swing.JButton btVenda;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JDesktopPane jDesktopPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuClientes;
    private javax.swing.JMenuItem jMenuFornecedores;
    private javax.swing.JMenuItem jMenuFuncionarios;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuPerfis;
    private javax.swing.JMenuItem jMenuProdutos;
    private javax.swing.JMenuItem jMenuSair;
    private javax.swing.JMenuItem jMenuVendaAPrazo;
    private javax.swing.JMenuItem jMenuVendaAVista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JToolBar.Separator jSeparator4;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfFuncionario;
    // End of variables declaration//GEN-END:variables

}
