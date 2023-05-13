package Visao.Dialogs;

import DAO.DAOConexao;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Alexandre
 */
public class FrmDialogPesquisas extends javax.swing.JDialog {

    DAOConexao con = new DAOConexao();

    private boolean confirma = false;
    private String valor1;
    private String valor2;
    private String valor3;

    String coluna1, coluna2, coluna3;

    public FrmDialogPesquisas(java.awt.Frame parent, boolean modal, String sql, String[] col, int[] larg) {
        super(parent, modal);
        initComponents();
        tabelaRegistros(sql, col, larg);
    }

    public final void tabelaRegistros(String sql, String[] col, int[] larg) {

        con.Conecta();
        try {
            con.executaSQL(sql);
            if (con.rs.first()) {
                
                ResultSetMetaData rsMeta = con.rs.getMetaData();
                int tam = rsMeta.getColumnCount(); //quantidade de colunas contidas no ResultSet
                String[] colunas = new String[tam]; //vetor do tamanho da quantidade de colunas no ResultSet

                //Preenchendo o vetor de String com os nomes das Colunas
                for (int i = 0; i < tam; i++) {
                    colunas[i] = rsMeta.getColumnName(i + 1);
                }

                //Setando o modelo e Desativando o edição da celulas da jTable
                DefaultTableModel modelo = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int rowIndex, int mColIndex) {
                        return false;
                    }                    
                };
                
                for (int i = 0; i < col.length; i++) {
                    modelo.addColumn(col[i]);
                }      
                
                //Enquanto tiver dados no ResultSet, adiciona as linhas no DefaultTableModel           
                do {
                    String[] registros = new String[tam];
                    for (int i=0; i<tam; i++) {
                        registros[i] = con.rs.getString(colunas[i]);
                    }
                    modelo.addRow(registros);                     
                } while (con.rs.next());
                
                //Seta na JTable o modelo montado com as linhas e colunas
                tblaRegistros.setModel(modelo);      
                tblaRegistros.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                for(int i=0; i<larg.length; i++){
                    tblaRegistros.getColumnModel().getColumn(i).setPreferredWidth(larg[i]);
                }
            } else {
                JOptionPane.showMessageDialog(null, "SEM REGISTROS CADASTRADOS", "AVISO", JOptionPane.OK_OPTION);
                this.dispose();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO ao preencher tabela com os registros\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }
        con.Desconecta();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaRegistros = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa de Registros");
        setMinimumSize(new java.awt.Dimension(571, 346));
        setResizable(false);

        tblaRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblaRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaRegistros);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblaRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaRegistrosMouseClicked
        // TODO add your handling code here:
        
        coluna1 = "" + tblaRegistros.getValueAt(tblaRegistros.getSelectedRow(), 0);
        coluna2 = "" + tblaRegistros.getValueAt(tblaRegistros.getSelectedRow(), 1);
        coluna3 = "" + tblaRegistros.getValueAt(tblaRegistros.getSelectedRow(), 2);

        if (evt.getClickCount() > 1) {
            setConfirma(true);
            setValor1(coluna1);
            setValor2(coluna2);
            setValor3(coluna3);
            this.dispose();

        }
        
    }//GEN-LAST:event_tblaRegistrosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tblaRegistros;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the valor1
     */
    public String getValor1() {
        return valor1;
    }

    /**
     * @param valor1 the valor1 to set
     */
    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    /**
     * @return the valor2
     */
    public String getValor2() {
        return valor2;
    }

    /**
     * @param valor2 the valor2 to set
     */
    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    /**
     * @return the valor3
     */
    public String getValor3() {
        return valor3;
    }

    /**
     * @param valor3 the valor3 to set
     */
    public void setValor3(String valor3) {
        this.valor3 = valor3;
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
