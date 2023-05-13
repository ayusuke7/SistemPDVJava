package Visao;

import Visao.Dialogs.FrmDialogPagamento;
import Visao.Dialogs.FrmDialogPesquisas;
import Controle.ControleDataHora;
import Controle.ControleProdutos;
import Controle.ControleVendas;
import Modelo.ModeloItensVenda;
import Modelo.ModeloParcelamento;
import Modelo.ModeloProdutos;
import Modelo.ModeloTabela;
import Modelo.ModeloVendas;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Alexandre
 */
public class FrmInternalVendas extends javax.swing.JInternalFrame {

    ControleDataHora dt_hr = new ControleDataHora();
    ControleVendas cont = new ControleVendas();
    ControleProdutos produtos = new ControleProdutos();
    DecimalFormat df = new DecimalFormat("###,###,##0.00");
    int id_funcionario;
    String tipo_venda;

    public FrmInternalVendas(String id_func, String funcionario, int tipo) {
        initComponents();
        tfFuncionarios.setText(funcionario);
        spinnerQuant.setValue(1);
        this.id_funcionario = Integer.parseInt(id_func);
        setTipoVenda(tipo);
    }

    public final void setTipoVenda(int tipo) {

        if (tipo == 1) {
            setTitle("Realizando Venda a Vista");
            jTabbedPane1.setEnabledAt(0, true);
            jTabbedPane1.setEnabledAt(1, false);
            tipo_venda = "A VISTA";
        } else {
            setTitle("Realizando Venda a Prazo");
            jTabbedPane1.setEnabledAt(0, false);
            jTabbedPane1.setEnabledAt(1, true);
            jTabbedPane1.setSelectedIndex(1);
            tipo_venda = "A PRAZO";
        }

    }

    public final void iniciarVenda(String id_cliente, String nome_cliente) {

        int op = JOptionPane.showConfirmDialog(null, "DESEJA INICIAR VENDA PARA O CLIENTE\n" + nome_cliente,
                "INICIAR VENDA", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {

            tfCodCliente.setText(id_cliente);
            tfNomeCliente.setText(nome_cliente);
            tfDataHora.setText(dt_hr.retornaData() + " " + dt_hr.retornaHora());

            ModeloVendas venda = new ModeloVendas();
            venda.setIni_venda(tfDataHora.getText());
            venda.setId_funcionario(id_funcionario);
            venda.setId_cliente(Integer.parseInt(id_cliente));
            venda.setTipo(tipo_venda);
            venda.setStatus("Andamento");

            if (cont.iniciarVenda(venda)) {
                tfCodVenda.setText("" + cont.retornaUltimaVenda());
                btAdicionar.setEnabled(true);
                btCancelar.setEnabled(true);
                btSair.setEnabled(false);
                btBuscaProd.setEnabled(true);
                btCalcularParcelamento.setEnabled(true);
            }

        }

    }

    public final void finalizaVendaAVista() {

        float vTotal = Float.parseFloat(tfValorTotalAVista.getText().replace(",", "."));
        float vSubTotal = Float.parseFloat(tfSubTotalAVista.getText().replace(",", "."));
        
        ModeloVendas venda = new ModeloVendas();
        
        venda.setFim_venda(dt_hr.retornaData() + " " + dt_hr.retornaHora());
        venda.setDesconto(vSubTotal - vTotal);
        venda.setSub_total(vSubTotal);
        venda.setValor_total(vTotal);
        venda.setId_venda(Integer.parseInt(tfCodVenda.getText()));
        venda.setStatus("Finalizada");

        FrmDialogPagamento frm = new FrmDialogPagamento(new JFrame(), true, tfValorTotalAVista.getText());
        frm.setVisible(true);

        if (frm.isConfirma()) {
            venda.setId_forma_pagamento(frm.getForma_pagamento());
            cont.finalizarVenda(venda);
        }

    }

    public final void finalizaVendaAPrazo() {

        float vTotal = Float.parseFloat(tfValorTotalAPrazo.getText().replace(",", "."));
        float vSubTotal = Float.parseFloat(tfSubTotalAPrazo.getText().replace(",", "."));
        
        ModeloVendas venda = new ModeloVendas();

        venda.setFim_venda(dt_hr.retornaData() + " " + dt_hr.retornaHora());
        venda.setSub_total(vSubTotal);
        venda.setValor_total(vTotal);
        venda.setId_venda(Integer.parseInt(tfCodVenda.getText()));
        venda.setStatus("Finalizada");

        if (checkEntrada.isSelected()) {

            FrmDialogPagamento frm = new FrmDialogPagamento(new JFrame(), true, tfValorTotalAPrazo.getText());
            frm.setVisible(true);
            if (frm.isConfirma()) {
                venda.setId_forma_pagamento(frm.getForma_pagamento());
            }
            cont.finalizarVenda(venda);

        } else {
//            venda.setId_forma_pagamento(1);
            cont.finalizarVenda(venda);
        }

    }

    public final void salvaParcelamento() {

        ModeloParcelamento mod = new ModeloParcelamento();

        mod.setId_venda(Integer.parseInt(tfCodVenda.getText()));
        mod.setQtd_parcelas(cbParcelamento.getSelectedIndex() + 1);
        mod.setJuros(Integer.parseInt(tfJuros.getText()));
        mod.setValor_total(Double.parseDouble(tfValorTotalAPrazo.getText().replace(",", ".")));

        for (int i = 0; i < tblaParcelamento.getRowCount(); i++) {

            String num_parc = "" + tblaParcelamento.getValueAt(i, 0);
            String vencimento = "" + tblaParcelamento.getValueAt(i, 1);
            String valor_parc = "" + tblaParcelamento.getValueAt(i, 2);

            mod.setNumero_parcela(Integer.parseInt(num_parc));
            mod.setValor_parcela(Double.parseDouble(valor_parc.replace(",", ".")));
            mod.setVencimento(vencimento);

            cont.salvarParcelamento(mod);

        }
    }

    public final void tabelaItensVenda(String id_venda) {

        String[] colunas = new String[]{"CODIGO", "DESCRIÇÃO", "QUANT", "VALOR UN", "VALOR TOTAL"};
        ArrayList dados = cont.retornaItensVenda(id_venda);

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblaItensVenda.setModel(modelo);
        tblaItensVenda.getColumnModel().getColumn(0).setMaxWidth(80);
        tblaItensVenda.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblaItensVenda.getColumnModel().getColumn(2).setMaxWidth(100);
        tblaItensVenda.getColumnModel().getColumn(3).setMaxWidth(100);
        tblaItensVenda.getColumnModel().getColumn(4).setMaxWidth(100);
        tblaItensVenda.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        switch (tipo_venda) {
            case "A VISTA":
                calculaValoresAVista();
                break;
            case "A PRAZO":
                calculaValoreAPrazo();
                break;

        }

    }

    public final void calculaValoresAVista() {

        //Calcula o Sub-total dos Itens adicionados
        String aux;
        double subtotal = 0.00;
        for (int i = 0; i < tblaItensVenda.getRowCount(); i++) {
            aux = "" + tblaItensVenda.getValueAt(i, 4);
            subtotal = subtotal + Double.parseDouble(aux.replace(",", "."));
        }
        tfSubTotalAVista.setText(df.format(subtotal));

        //Calcula desconto de avista do Sub-total
        int porcenta = Integer.parseInt(tfDesconto.getText());
        double desc = (subtotal * porcenta) / 100;
        double vtotal = subtotal - desc;

        tfValorTotalAVista.setText(df.format(vtotal));

    }

    public final void calculaValoreAPrazo() {

        //Calcula o Sub-total dos Itens adicionados
        String aux;
        double subtotal = 0.00;
        for (int i = 0; i < tblaItensVenda.getRowCount(); i++) {
            aux = "" + tblaItensVenda.getValueAt(i, 4);
            subtotal = subtotal + Double.parseDouble(aux.replace(",", "."));
        }

        tfSubTotalAPrazo.setText(df.format(subtotal));

        //Calcula sub-total mais Juros        
        int porcenta = Integer.parseInt(tfJuros.getText());
        double juros = (subtotal * porcenta) / 100;
        double vlr_total = subtotal + juros;

        tfValorTotalAPrazo.setText(df.format(vlr_total));

    }

    public final void tabelaParcelamento() {

        String[] colunas = new String[]{"PARCELA", "VENCIMENTO", "VALOR PARCELA"};
        ArrayList dados = new ArrayList();

        String dia = dt_hr.retornaData().substring(0, 2);
        int mes = Integer.parseInt(dt_hr.retornaData().substring(3, 5)) + 1;
        int ano = Integer.parseInt(dt_hr.retornaData().substring(6));

        double vtotal = Double.parseDouble(tfValorTotalAPrazo.getText().replace(",", "."));
        double entrada = Double.parseDouble(tfValorEntrada.getText().replace(",", "."));
        int qtd_parc = cbParcelamento.getSelectedIndex() + 1;
        double valor_parc = (vtotal - entrada) / qtd_parc;
        
        int i = 1;
        while (i <= qtd_parc) {

            if (mes < 10) {
                dados.add(new Object[]{i, dia + "/0" + mes + "/" + ano, String.format("%.2f", valor_parc)});
            } else {
                dados.add(new Object[]{i, dia + "/" + mes + "/" + ano, String.format("%.2f", valor_parc)});
            }
            mes++;
            if (mes > 12) {
                ano++;
                mes = 1;
            }
            i++;

        }

        ModeloTabela modelo = new ModeloTabela(dados, colunas);
        tblaParcelamento.setModel(modelo);
        tblaParcelamento.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblaParcelamento.getColumnModel().getColumn(1).setPreferredWidth(100);
        tblaParcelamento.getColumnModel().getColumn(2).setPreferredWidth(100);
        tblaParcelamento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tfFuncionarios = new javax.swing.JTextField();
        tfDataHora = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCodVenda = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfNomeCliente = new javax.swing.JTextField();
        tfCodCliente = new javax.swing.JTextField();
        btCliente = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblaItensVenda = new javax.swing.JTable();
        tfNomeProduto = new javax.swing.JTextField();
        tfCodProduto = new javax.swing.JTextField();
        tfValorProduto = new javax.swing.JTextField();
        btAdicionar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        spinnerQuant = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        btBuscaProd = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btSalvar = new javax.swing.JButton();
        btFinalizarVenda = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btSair = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        tfDesconto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        tfSubTotalAVista = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        tfValorTotalAVista = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        cbParcelamento = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblaParcelamento = new javax.swing.JTable();
        checkEntrada = new javax.swing.JCheckBox();
        tfValorEntrada = new javax.swing.JFormattedTextField();
        btCalcularParcelamento = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        tfValorTotalAPrazo = new javax.swing.JTextField();
        tfJuros = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        tfSubTotalAPrazo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setTitle("Realizar Venda");
        setToolTipText("");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfFuncionarios.setEditable(false);
        tfFuncionarios.setBackground(new java.awt.Color(255, 255, 255));

        tfDataHora.setEditable(false);
        tfDataHora.setBackground(new java.awt.Color(255, 255, 255));
        tfDataHora.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel1.setText("Funcionário");

        jLabel3.setText("Iniciada ás");

        tfCodVenda.setEditable(false);
        tfCodVenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfCodVenda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCodVenda.setText("000000");

        jLabel2.setText("Código da Venda");

        tfNomeCliente.setEditable(false);
        tfNomeCliente.setBackground(new java.awt.Color(255, 255, 255));

        tfCodCliente.setEditable(false);
        tfCodCliente.setBackground(new java.awt.Color(255, 255, 255));
        tfCodCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfCodCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        btCliente.setText("Cliente");
        btCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btCliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfFuncionarios))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeCliente)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfCodVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(tfDataHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(tfFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCliente))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tblaItensVenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblaItensVenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblaItensVendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblaItensVenda);

        tfCodProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodProdutoActionPerformed(evt);
            }
        });

        tfValorProduto.setEditable(false);
        tfValorProduto.setBackground(new java.awt.Color(255, 255, 255));
        tfValorProduto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btAdicionar.setText("Adicionar");
        btAdicionar.setEnabled(false);
        btAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAdicionarActionPerformed(evt);
            }
        });

        jLabel4.setText("Codigo do Produto / Descrição");

        jLabel5.setText("Valor R$");

        jLabel6.setText("Quantidade");

        btBuscaProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/search.png"))); // NOI18N
        btBuscaProd.setEnabled(false);
        btBuscaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscaProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tfCodProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfNomeProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btBuscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(39, 39, 39)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(spinnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAdicionar)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(3, 3, 3)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfCodProduto)
                    .addComponent(tfNomeProduto)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btAdicionar)
                                .addComponent(spinnerQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btBuscaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btSalvar.setText("SALVAR VENDA");
        btSalvar.setEnabled(false);
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btFinalizarVenda.setText("FINALIZAR VENDA");
        btFinalizarVenda.setEnabled(false);
        btFinalizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFinalizarVendaActionPerformed(evt);
            }
        });

        btCancelar.setText("CANCELAR VENDA");
        btCancelar.setEnabled(false);
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btSair.setText("SAIR");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180)
                .addComponent(btFinalizarVenda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btFinalizarVenda)
                    .addComponent(btCancelar)
                    .addComponent(btSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("SUB-TOTAL R$ :");

        tfDesconto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfDesconto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDesconto.setText("0");
        tfDesconto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDescontoFocusLost(evt);
            }
        });
        tfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDescontoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("DESCONTO % :");

        tfSubTotalAVista.setEditable(false);
        tfSubTotalAVista.setBackground(new java.awt.Color(255, 255, 255));
        tfSubTotalAVista.setForeground(new java.awt.Color(0, 0, 255));
        tfSubTotalAVista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfSubTotalAVista.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSubTotalAVista.setText("0,00");
        tfSubTotalAVista.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("TOTAL R$ :");

        tfValorTotalAVista.setEditable(false);
        tfValorTotalAVista.setBackground(new java.awt.Color(255, 255, 255));
        tfValorTotalAVista.setForeground(new java.awt.Color(0, 0, 255));
        tfValorTotalAVista.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat(""))));
        tfValorTotalAVista.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorTotalAVista.setText("0,00");
        tfValorTotalAVista.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfSubTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfValorTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(tfSubTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(tfValorTotalAVista, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venda a Vista", jPanel4);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Parcelamento :");

        cbParcelamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        cbParcelamento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbParcelamentoItemStateChanged(evt);
            }
        });

        tblaParcelamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tblaParcelamento);

        checkEntrada.setText("Com entrada R$ :");
        checkEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkEntradaActionPerformed(evt);
            }
        });

        tfValorEntrada.setEditable(false);
        tfValorEntrada.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfValorEntrada.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorEntrada.setText("0,00");
        tfValorEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfValorEntradaActionPerformed(evt);
            }
        });

        btCalcularParcelamento.setText("Calcular Parcelamento");
        btCalcularParcelamento.setEnabled(false);
        btCalcularParcelamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCalcularParcelamentoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setText("TOTAL R$ :");

        tfValorTotalAPrazo.setEditable(false);
        tfValorTotalAPrazo.setBackground(new java.awt.Color(255, 255, 255));
        tfValorTotalAPrazo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tfValorTotalAPrazo.setForeground(new java.awt.Color(0, 0, 255));
        tfValorTotalAPrazo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfValorTotalAPrazo.setText("0,00");

        tfJuros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfJuros.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfJuros.setText("0");
        tfJuros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJurosActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("JUROS %");

        tfSubTotalAPrazo.setEditable(false);
        tfSubTotalAPrazo.setBackground(new java.awt.Color(255, 255, 204));
        tfSubTotalAPrazo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfSubTotalAPrazo.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSubTotalAPrazo.setText("0,00");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Sub-total  R$:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfJuros)
                    .addComponent(tfValorTotalAPrazo, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                    .addComponent(tfSubTotalAPrazo))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(checkEntrada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btCalcularParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel13)
                            .addComponent(tfSubTotalAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(tfJuros, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tfValorTotalAPrazo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cbParcelamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(checkEntrada)
                            .addComponent(tfValorEntrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btCalcularParcelamento)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Venda a Prazo", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "DESEJA REALMENTE CANCELAR ESTA VENDA?",
                "CANCELAR VENDA", JOptionPane.YES_NO_OPTION);
        if (op == JOptionPane.YES_OPTION) {
            if (cont.cancelarVenda(Integer.parseInt(tfCodVenda.getText()))) {
                JOptionPane.showMessageDialog(null, "VENDA CANCELADA");
            }
            this.dispose();
        }


    }//GEN-LAST:event_btCancelarActionPerformed

    private void btBuscaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscaProdActionPerformed
        // TODO add your handling code here:

        String sql = "select id_produto, descricao, valor_venda, quantidade from tbla_produtos order by id_produto";
        String[] col = {"COD. PRODUTO", "DESCRIÇÃO", "VALOR DE VENDA", "QUANTIDADE"};
        int[] larg = {80, 200, 120, 80};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            tfCodProduto.setText(frm.getValor1());
            tfNomeProduto.setText(frm.getValor2());
            tfValorProduto.setText(frm.getValor3());
        }

    }//GEN-LAST:event_btBuscaProdActionPerformed

    private void btClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btClienteActionPerformed
        // TODO add your handling code here:

        String sql = "select id_cliente, nome_pessoa, documento1 from tbla_clientes order by id_cliente";
        String[] col = {"ID CLIENTE", "CLIENTE", "CPF / CNPJ"};
        int[] larg = {20, 300, 80};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            iniciarVenda(frm.getValor1(), frm.getValor2());
        }

    }//GEN-LAST:event_btClienteActionPerformed

    private void btAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAdicionarActionPerformed
        // TODO add your handling code here:

        if (!tfCodProduto.getText().equals("")) {
            if ((int) spinnerQuant.getValue() > 0) {

                    int qtd = (int) spinnerQuant.getValue();
                    float vlr_un = Float.parseFloat(tfValorProduto.getText().replace(",", "."));

                    ModeloItensVenda item = new ModeloItensVenda();

                    item.setId_venda(Integer.parseInt(tfCodVenda.getText()));
                    item.setId_produto(Integer.parseInt(tfCodProduto.getText()));
                    item.setQuantidade(qtd);
                    item.setValor_un(vlr_un);
                    item.setValor_total(qtd * vlr_un);

                    if (cont.adicionarItensVenda(item)) {
                        tabelaItensVenda(tfCodVenda.getText());
                        tfCodProduto.setText("");
                        tfNomeProduto.setText("");
                        tfValorProduto.setText("");
                        spinnerQuant.setValue(1);
                        btFinalizarVenda.setEnabled(true);
                        btSalvar.setEnabled(true);
                    }
       
            } else {
                JOptionPane.showMessageDialog(null, "Digite um quantidade maior que 0");
            }
        } else {
            JOptionPane.showMessageDialog(null, "SELECIONE UM PRODUTO PARA ADICIONAR A VENDA");
        }
    }//GEN-LAST:event_btAdicionarActionPerformed

    private void checkEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkEntradaActionPerformed
        // TODO add your handling code here:
      
        if (checkEntrada.isSelected()) {
            tfValorEntrada.setEditable(true);
        } else {
            tfValorEntrada.setEditable(false);
            tfValorEntrada.setText("0,00");
        }
    }//GEN-LAST:event_checkEntradaActionPerformed

    private void tfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDescontoActionPerformed
        // TODO add your handling code here:
        calculaValoresAVista();
    }//GEN-LAST:event_tfDescontoActionPerformed

    private void tfDescontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDescontoFocusLost
        // TODO add your handling code here:
        calculaValoresAVista();
    }//GEN-LAST:event_tfDescontoFocusLost

    private void btFinalizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFinalizarVendaActionPerformed
        // TODO add your handling code here:

        switch (tipo_venda) {
            case "A VISTA":
                finalizaVendaAVista();
                this.dispose();
                break;
            case "A PRAZO":
                salvaParcelamento();
                finalizaVendaAPrazo();
                this.dispose();
                break;
        }

    }//GEN-LAST:event_btFinalizarVendaActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        if (cont.salvarVenda(Integer.parseInt(tfCodVenda.getText()))) {
            JOptionPane.showMessageDialog(null, "VENDA " + tfCodVenda.getText() + " SALVA");
            this.dispose();
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCalcularParcelamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCalcularParcelamentoActionPerformed
        // TODO add your handling code here:
        tabelaParcelamento();
    }//GEN-LAST:event_btCalcularParcelamentoActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tfJurosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJurosActionPerformed
        // TODO add your handling code here:
        calculaValoreAPrazo();
        tabelaParcelamento();
    }//GEN-LAST:event_tfJurosActionPerformed

    private void tfValorEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfValorEntradaActionPerformed
        // TODO add your handling code here:        

        double total = Double.parseDouble(tfValorTotalAPrazo.getText().replace(",", "."));
        double entrada = Double.parseDouble(tfValorEntrada.getText().replace(",", "."));
        double vtotal = total - entrada;

        tfValorTotalAPrazo.setText(df.format(vtotal));

    }//GEN-LAST:event_tfValorEntradaActionPerformed

    private void cbParcelamentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbParcelamentoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbParcelamentoItemStateChanged

    private void tfCodProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodProdutoActionPerformed
        // TODO add your handling code here:

        ModeloProdutos mod = produtos.retornaProduto(tfCodProduto.getText());
        tfNomeProduto.setText(mod.getDescricao());
        tfValorProduto.setText(mod.getValor_venda());

    }//GEN-LAST:event_tfCodProdutoActionPerformed

    private void tblaItensVendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblaItensVendaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tblaItensVendaMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdicionar;
    private javax.swing.JButton btBuscaProd;
    private javax.swing.JButton btCalcularParcelamento;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCliente;
    private javax.swing.JButton btFinalizarVenda;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbParcelamento;
    private javax.swing.JCheckBox checkEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner spinnerQuant;
    private javax.swing.JTable tblaItensVenda;
    private javax.swing.JTable tblaParcelamento;
    private javax.swing.JTextField tfCodCliente;
    private javax.swing.JTextField tfCodProduto;
    private javax.swing.JTextField tfCodVenda;
    private javax.swing.JTextField tfDataHora;
    private javax.swing.JTextField tfDesconto;
    private javax.swing.JTextField tfFuncionarios;
    private javax.swing.JTextField tfJuros;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNomeProduto;
    private javax.swing.JTextField tfSubTotalAPrazo;
    private javax.swing.JFormattedTextField tfSubTotalAVista;
    private javax.swing.JFormattedTextField tfValorEntrada;
    private javax.swing.JTextField tfValorProduto;
    private javax.swing.JTextField tfValorTotalAPrazo;
    private javax.swing.JFormattedTextField tfValorTotalAVista;
    // End of variables declaration//GEN-END:variables
}
