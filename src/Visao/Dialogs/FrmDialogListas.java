package Visao.Dialogs;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 *
 * @author Alexandre
 */
public class FrmDialogListas extends javax.swing.JDialog {

    private DefaultListModel model;
    private String valor;
    private boolean confirma = false;

    /*
     * @param parent
     * @param modal
     * @param lista
     */
    public FrmDialogListas(java.awt.Frame parent, boolean modal, ArrayList lista) {
        super(parent, modal);
        initComponents();
        preencheTabela(lista);
    }

    public final void preencheTabela(ArrayList dados) {

        model = new DefaultListModel();

        for (int i = 0; i < dados.size(); i++) {
            model.addElement(dados.get(i));
        }
        
        listaRegistros.setModel(model);
        listaRegistros.setSelectedIndex(0);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaRegistros = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registros");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listaRegistros.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listaRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRegistrosMouseClicked(evt);
            }
        });
        listaRegistros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listaRegistrosKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(listaRegistros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listaRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRegistrosMouseClicked
        // TODO add your handling code here:
        
        if(evt.getClickCount() > 1){
            setConfirma(true);
            setValor(listaRegistros.getSelectedValue());
            this.dispose();
        }
        
    }//GEN-LAST:event_listaRegistrosMouseClicked

    private void listaRegistrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listaRegistrosKeyPressed
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            setConfirma(true);
            setValor(listaRegistros.getSelectedValue());
            this.dispose();
        }
        
    }//GEN-LAST:event_listaRegistrosKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listaRegistros;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the valor1
     */
    public String getValor() {
        return valor;
    }

    /**
     * @param valor the valor1 to set
     */
    public void setValor(String valor) {
        this.valor = valor;
    }

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
}
