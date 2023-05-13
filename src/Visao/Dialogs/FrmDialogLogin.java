package Visao.Dialogs;

import DAO.DAOConexao;
import java.awt.Cursor;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class FrmDialogLogin extends javax.swing.JDialog {

    DAOConexao con = new DAOConexao();
    private boolean confirma = false;
    private String funcionario;
    private String id_funcionario;

    public FrmDialogLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public final void autenticacao() {

        con.Conecta();
        con.executaSQL("select * from tbla_funcionarios where cpf ='" + tfUsuario.getText() + "'");
        try {
            if (con.rs.first()) {
                String senha = con.rs.getString("senha");
                if (tfSenha.getText().equals(senha)) {
                    setConfirma(true);
                    setFuncionario(con.rs.getString("nome_funcionario"));
                    setId_funcionario(""+con.rs.getInt("id_funcionario"));
                    this.dispose();
                }else{
                    JOptionPane.showMessageDialog(rootPane, "SENHA INCORRETA");
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "FUNCIONÁRIO NÃO ENCOTRADO");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "ERRO retornar funcionario na Autenticacao\n" + ex);
        }
        con.Desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        checkSenha = new javax.swing.JCheckBox();
        tfSenha = new javax.swing.JPasswordField();
        btEntrar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfUsuario = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        checkSenha.setBackground(new java.awt.Color(255, 255, 255));
        checkSenha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        checkSenha.setToolTipText("Visualizar Senha!");
        checkSenha.setBorder(null);
        checkSenha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        checkSenha.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        checkSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(checkSenha);
        checkSenha.setBounds(366, 214, 16, 16);

        tfSenha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfSenha.setText("1234");
        tfSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSenhaActionPerformed(evt);
            }
        });
        jPanel1.add(tfSenha);
        tfSenha.setBounds(250, 210, 140, 25);

        btEntrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btEntrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btn_entrar2.png"))); // NOI18N
        btEntrar.setToolTipText("Acessar sistema");
        btEntrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btEntrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btEntrarMouseExited(evt);
            }
        });
        btEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEntrarActionPerformed(evt);
            }
        });
        jPanel1.add(btEntrar);
        btEntrar.setBounds(170, 240, 180, 30);

        btCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btn_cancel.png"))); // NOI18N
        btCancelar.setToolTipText("Sair do sistema");
        btCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btCancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btCancelarMouseExited(evt);
            }
        });
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar);
        btCancelar.setBounds(170, 280, 180, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Funcionario / CPF");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(90, 190, 140, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Senha");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(250, 190, 60, 15);

        try {
            tfUsuario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfUsuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfUsuario.setText("052.830.423-24");
        tfUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfUsuarioActionPerformed(evt);
            }
        });
        jPanel1.add(tfUsuario);
        tfUsuario.setBounds(90, 210, 160, 25);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 480, 190);

        jLabel3.setFont(new java.awt.Font("Tahoma", 2, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sistema de vendas - SisPDV, desenvolvido por Alexandre H. http://alexandrehenrique.esy.es");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 330, 480, 13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(482, 346));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEntrarActionPerformed
        // TODO add your handling code here:
        autenticacao();
    }//GEN-LAST:event_btEntrarActionPerformed

    private void checkSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkSenhaActionPerformed
        // TODO add your handling code here:
        if(checkSenha.isSelected()){
            tfSenha.setEchoChar((char)0);
        }else{
            tfSenha.setEchoChar(('*'));
        }
    }//GEN-LAST:event_checkSenhaActionPerformed

    private void tfUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfUsuarioActionPerformed
        // TODO add your handling code here:
        tfSenha.requestFocus();
    }//GEN-LAST:event_tfUsuarioActionPerformed

    private void tfSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSenhaActionPerformed
        // TODO add your handling code here:
        autenticacao();
    }//GEN-LAST:event_tfSenhaActionPerformed

    private void btEntrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEntrarMouseEntered
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btEntrarMouseEntered

    private void btEntrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btEntrarMouseExited
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btEntrarMouseExited

    private void btCancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseEntered
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btCancelarMouseEntered

    private void btCancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCancelarMouseExited
        // TODO add your handling code here:
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btCancelarMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btEntrar;
    private javax.swing.JCheckBox checkSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField tfSenha;
    private javax.swing.JFormattedTextField tfUsuario;
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
     * @return the funcionario
     */
    public String getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the id_funcionario
     */
    public String getId_funcionario() {
        return id_funcionario;
    }

    /**
     * @param id_funcionario the id_funcionario to set
     */
    public void setId_funcionario(String id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

}
