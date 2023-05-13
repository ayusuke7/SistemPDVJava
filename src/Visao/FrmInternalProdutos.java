package Visao;

import Visao.Dialogs.FrmDialogPesquisas;
import Controle.ControleDataHora;
import Controle.ControleProdutos;
import Modelo.ModeloProdutos;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class FrmInternalProdutos extends javax.swing.JInternalFrame {

    ControleProdutos cont = new ControleProdutos();

    public FrmInternalProdutos() {
        initComponents();
    }

    public void calculaValores() {

        DecimalFormat df = new DecimalFormat("###,###,##0.00");

        double vCompra = Double.parseDouble(tfValorCompra.getText().replace(",", "."));
        double vVenda = Double.parseDouble(tfValorVenda.getText().replace(",", "."));
        int quant = (int) spinerQuantidade.getValue();

        double vTotalNota = vCompra * quant;
        double vLucro = (quant * vVenda) - vTotalNota;
//      double percentual = 0.00;

        tfValorTotalNota.setText(df.format(vTotalNota));
//      tfPercentual.setText(String.format("%.2f", percentual));

        if (vLucro > 0) {
            tfLucro.setForeground(Color.blue);
            tfLucro.setText(df.format(vLucro));
        } else {
            tfLucro.setForeground(Color.red);
            tfLucro.setText(df.format(vLucro));
        }

    }

    public void resetFrame() {

        limparCampos();

        lbStatus.setText("");
        btExcluir.setEnabled(false);
        btSalvar.setEnabled(false);

    }

    public void limparCampos() {

        tfCodigoProduto.setText("0000");
        tfNomeFornecedor.setText("");
        tfCodFornecedor.setText("");
        tfDescricao.setText("");
        tfDtEntrada.setText("");
        tfValorCompra.setText("0,00");
        tfValorVenda.setText("0,00");
        tfValorTotalNota.setText("0,00");
        String texto = "Digite ou conecte o Leitor de codigos de barras, habilite a opção para fazer a leitura.";
        tfCodigoBarras.setText(texto);
        spinerQuantidade.setValue(0);

    }

    public void setValores(String id_produto) {

        try {

            ResultSet rs = cont.retornaValores(id_produto);

            tfCodigoProduto.setText("" + rs.getInt("id_produto"));
            tfNomeFornecedor.setText(rs.getString("nome_fornecedor"));
            tfCodFornecedor.setText(String.valueOf(rs.getInt("id_fornecedor")));
            tfDescricao.setText(rs.getString("descricao"));
            tfDtEntrada.setText(rs.getString("dt_entrada"));
            tfValorCompra.setText(rs.getString("valor_compra"));
            tfValorVenda.setText(rs.getString("valor_venda"));
            tfValorTotalNota.setText(rs.getString("valor_total_nota"));
            tfCodigoBarras.setText(rs.getString("cod_barras"));
            spinerQuantidade.setValue(rs.getInt("quantidade"));
            spinerEstoque.setValue(rs.getInt("estoque_minimo"));

            lbStatus.setText("Editando...");
            lbStatus.setForeground(Color.yellow);

            btSalvar.setEnabled(true);
            btExcluir.setEnabled(true);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO SETAR DADOS\n" + ex, "PROBLEMAS", JOptionPane.OK_OPTION);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabecalho = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfCodigoProduto = new javax.swing.JTextField();
        lbStatus = new javax.swing.JLabel();
        painelDados = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCodFornecedor = new javax.swing.JTextField();
        btBuscaFornecedor = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        lbQuantidade = new javax.swing.JLabel();
        cbTipoQuant = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfDtEntrada = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfValorCompra = new javax.swing.JFormattedTextField();
        tfValorVenda = new javax.swing.JFormattedTextField();
        tfValorTotalNota = new javax.swing.JFormattedTextField();
        spinerQuantidade = new javax.swing.JSpinner();
        tfCodigoBarras = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        spinerEstoque = new javax.swing.JSpinner();
        tfNomeFornecedor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfPercentual = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfLucro = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setTitle("Produtos");

        painelCabecalho.setBackground(new java.awt.Color(102, 102, 102));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CODIGO :");

        tfCodigoProduto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfCodigoProduto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCodigoProduto.setText("0000");
        tfCodigoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoProdutoActionPerformed(evt);
            }
        });

        lbStatus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatus.setText(" ");

        javax.swing.GroupLayout painelCabecalhoLayout = new javax.swing.GroupLayout(painelCabecalho);
        painelCabecalho.setLayout(painelCabecalhoLayout);
        painelCabecalhoLayout.setHorizontalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelDados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome / Descrição *");

        tfDescricao.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescricaoFocusLost(evt);
            }
        });

        jLabel2.setText("Fornecedor / Distribuidor(a) *");

        tfCodFornecedor.setEditable(false);
        tfCodFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        tfCodFornecedor.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCodFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodFornecedorActionPerformed(evt);
            }
        });

        btBuscaFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        btBuscaFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaFornecedorActionPerformed(evt);
            }
        });

        jLabel3.setText("Tipo");

        lbQuantidade.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQuantidade.setText("Quantidade");

        cbTipoQuant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Un", "Cx", "Lt", "Kg" }));
        cbTipoQuant.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbTipoQuantFocusLost(evt);
            }
        });

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Data de Entrada");

        try {
            tfDtEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtEntrada.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDtEntrada.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfDtEntradaFocusGained(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Valor de Compra R$");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Valor Total da Nota R$");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Valor de Venda R$");

        tfValorCompra.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorCompra.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorCompra.setText("0,00");
        tfValorCompra.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorCompraFocusLost(evt);
            }
        });

        tfValorVenda.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorVenda.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorVenda.setText("0,00");
        tfValorVenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfValorVendaFocusLost(evt);
            }
        });

        tfValorTotalNota.setEditable(false);
        tfValorTotalNota.setBackground(new java.awt.Color(255, 255, 204));
        tfValorTotalNota.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorTotalNota.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorTotalNota.setText("0,00");
        tfValorTotalNota.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfValorTotalNota.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        spinerQuantidade.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinerQuantidadeStateChanged(evt);
            }
        });

        tfCodigoBarras.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        tfCodigoBarras.setForeground(new java.awt.Color(102, 102, 102));
        tfCodigoBarras.setText("Digite ou conecte o Leitor de codigos de barras, habilite a opção para fazer a leitura.");
        tfCodigoBarras.setMargin(new java.awt.Insets(2, 6, 2, 2));
        tfCodigoBarras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfCodigoBarrasFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoBarrasFocusLost(evt);
            }
        });

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Estoque Mínimo");

        spinerEstoque.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spinerEstoqueStateChanged(evt);
            }
        });

        tfNomeFornecedor.setEditable(false);
        tfNomeFornecedor.setBackground(new java.awt.Color(255, 255, 255));
        tfNomeFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNomeFornecedorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Lucro  de,  %");

        tfPercentual.setEditable(false);
        tfPercentual.setBackground(new java.awt.Color(255, 255, 255));
        tfPercentual.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tfPercentual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfPercentual.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("R$");

        tfLucro.setEditable(false);
        tfLucro.setBackground(new java.awt.Color(255, 255, 255));
        tfLucro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfLucro.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfLucro.setText("0,00");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nenhum" }));

        jLabel13.setText("Grupo");

        jLabel14.setText("Código de barras (N/S) :");

        javax.swing.GroupLayout painelDadosLayout = new javax.swing.GroupLayout(painelDados);
        painelDados.setLayout(painelDadosLayout);
        painelDadosLayout.setHorizontalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator2)
            .addComponent(jSeparator1)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodigoBarras, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfDescricao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTipoQuant, 0, 46, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfDtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbQuantidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinerEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorCompra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorVenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(btBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodFornecedor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfValorTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(tfLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelDadosLayout.createSequentialGroup()
                        .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        painelDadosLayout.setVerticalGroup(
            painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbTipoQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCodFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfNomeFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btBuscaFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lbQuantidade)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDtEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinerEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfValorCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigoBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 25, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPercentual, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfLucro, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(tfValorTotalNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        painelBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/canc24.png"))); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar24.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelBotoesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, painelBotoesLayout.createSequentialGroup()
                        .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelDados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoProdutoActionPerformed
        // TODO add your handling code here:

        setValores(tfCodigoProduto.getText());

    }//GEN-LAST:event_tfCodigoProdutoActionPerformed

    private void tfValorCompraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorCompraFocusLost
        // TODO add your handling code here:
        calculaValores();
    }//GEN-LAST:event_tfValorCompraFocusLost

    private void spinerQuantidadeStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinerQuantidadeStateChanged
        // TODO add your handling code here:
        calculaValores();
    }//GEN-LAST:event_spinerQuantidadeStateChanged

    private void btBuscaFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaFornecedorActionPerformed
        // TODO add your handling code here:

        String sql = "select id_fornecedor, nome_fornecedor, cnpj from tbla_fornecedores";
        String[] col = {"CODIGO", "NOME FORNECEDOR", "CNPJ"};
        int[] larg = {20, 250, 80};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            tfCodFornecedor.setText(frm.getValor1());
            tfNomeFornecedor.setText(frm.getValor2());

        }

    }//GEN-LAST:event_btBuscaFornecedorActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        if (!tfDescricao.getText().equals("") && !tfNomeFornecedor.getText().equals("")
                && !tfValorVenda.getText().equals("0,00") && !tfValorTotalNota.getText().equals("0,00")) {

            ModeloProdutos mod = new ModeloProdutos();
            mod.setDescricao(tfDescricao.getText());
            mod.setTipo((String) cbTipoQuant.getSelectedItem());
            mod.setId_fornecedor(Integer.parseInt(tfCodFornecedor.getText()));
            mod.setDt_entrada(tfDtEntrada.getText());
            mod.setQuantidade((int) spinerQuantidade.getValue());
            mod.setValor_compra(tfValorCompra.getText());
            mod.setValor_venda(tfValorVenda.getText());
            mod.setValor_total(tfValorTotalNota.getText());
            mod.setCod_barra(tfCodigoBarras.getText());
            mod.setQtd_estoque((int) spinerEstoque.getValue());

            switch (lbStatus.getText()) {
                case "Cadastrando...":
                    cont.cadastrarProduto(mod);
                    break;
                case "Editando...":
                    mod.setId_produto(Integer.parseInt(tfCodigoProduto.getText()));
                    cont.editarProduto(mod);
                    break;
            }
            limparCampos();
        } else {
            JOptionPane.showMessageDialog(null, "VERIFIQUE OS CAMPOS OBRIGATÓRIOS", "AVISO", JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:

        resetFrame();

        tfCodigoProduto.setText(String.valueOf(cont.retornaUltimoID() + 1));
        lbStatus.setText("Cadastrando...");
        lbStatus.setForeground(Color.green);
        btSalvar.setEnabled(true);

    }//GEN-LAST:event_btNovoActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR ESSE PRODUTO?", "EXCLUIR", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            cont.excluirProduto(Integer.parseInt(tfCodigoProduto.getText()));
            resetFrame();
        } else {
            JOptionPane.showMessageDialog(null, "EXCLUSÃO CANCELADA");
        }

    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        resetFrame();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbTipoQuantFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbTipoQuantFocusLost
        // TODO add your handling code here:
        lbQuantidade.setText("Quantidade " + cbTipoQuant.getSelectedItem());
    }//GEN-LAST:event_cbTipoQuantFocusLost

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:
        String sql = "select id_produto, descricao, valor_venda from tbla_produtos order by id_produto";
        String[] col = {"COD. PRODUTO", "DESCRIÇÃO", "VALOR DE VENDA"};
        int[] larg = {80, 200, 120};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            setValores(frm.getValor1());
        }
    }//GEN-LAST:event_btBuscarActionPerformed

    private void spinerEstoqueStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spinerEstoqueStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_spinerEstoqueStateChanged

    private void tfCodFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodFornecedorActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfCodFornecedorActionPerformed

    private void tfNomeFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNomeFornecedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeFornecedorActionPerformed

    private void tfDtEntradaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDtEntradaFocusGained
        // TODO add your handling code here:
        tfDtEntrada.setText(new ControleDataHora().retornaData());
    }//GEN-LAST:event_tfDtEntradaFocusGained

    private void tfValorVendaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfValorVendaFocusLost
        // TODO add your handling code here:
        calculaValores();
    }//GEN-LAST:event_tfValorVendaFocusLost

    private void tfCodigoBarrasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoBarrasFocusGained
        // TODO add your handling code here:

        String texto = "Digite ou conecte o Leitor de codigos de barras, habilite a opção para fazer a leitura.";

        if (tfCodigoBarras.getText().equals(texto)) {
            tfCodigoBarras.setText("");
            tfCodigoBarras.setForeground(Color.black);
            tfCodigoBarras.setFont(new Font("Tahoma", 0, 11));
        } 

    }//GEN-LAST:event_tfCodigoBarrasFocusGained

    private void tfCodigoBarrasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoBarrasFocusLost
        // TODO add your handling code here:

        String texto = "Digite ou conecte o Leitor de codigos de barras, habilite a opção para fazer a leitura.";
        
        if (tfCodigoBarras.getText().equals("")) {
            tfCodigoBarras.setText(texto);
            tfCodigoBarras.setForeground(new Color(102, 102, 102));
            tfCodigoBarras.setFont(new Font("Tahoma", 2, 11));
        }
    }//GEN-LAST:event_tfCodigoBarrasFocusLost

    private void tfDescricaoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescricaoFocusLost
        // TODO add your handling code here:
        
        String upper = tfDescricao.getText().toUpperCase();
        tfDescricao.setText(upper);
        
    }//GEN-LAST:event_tfDescricaoFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscaFornecedor;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbTipoQuant;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelDados;
    private javax.swing.JSpinner spinerEstoque;
    private javax.swing.JSpinner spinerQuantidade;
    private javax.swing.JTextField tfCodFornecedor;
    private javax.swing.JTextField tfCodigoBarras;
    private javax.swing.JTextField tfCodigoProduto;
    private javax.swing.JTextField tfDescricao;
    private javax.swing.JFormattedTextField tfDtEntrada;
    private javax.swing.JTextField tfLucro;
    private javax.swing.JTextField tfNomeFornecedor;
    private javax.swing.JTextField tfPercentual;
    private javax.swing.JFormattedTextField tfValorCompra;
    private javax.swing.JFormattedTextField tfValorTotalNota;
    private javax.swing.JFormattedTextField tfValorVenda;
    // End of variables declaration//GEN-END:variables
}
