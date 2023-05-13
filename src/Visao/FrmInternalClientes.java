package Visao;

import Visao.Dialogs.FrmDialogListas;
import Visao.Dialogs.FrmDialogPesquisas;
import Controle.ControleArquivos;
import Controle.ControleClientes;
import Controle.ControleDataHora;
import Modelo.ModeloClientes;
import Controle.ControleDocumentos;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alexandre
 */
public class FrmInternalClientes extends javax.swing.JInternalFrame {

    ControleClientes cliente = new ControleClientes();
    ControleDocumentos docs = new ControleDocumentos();

    public FrmInternalClientes() {
        initComponents();
        painelAbas.setEnabledAt(2, false);
    }

    public void setDados(String id_cliente) {

        ModeloClientes mod = cliente.retornaValores(id_cliente);

        tfCodigoCliente.setText("" + mod.getId_pessoa());
        tfNomeCliente.setText(mod.getNome_pessoa());
        tfDtCliente.setText(mod.getDt_nascimento());
        cbGeneroCliente.setSelectedItem(mod.getGenero());
        tfCpfCliente.setText(mod.getDocumento1());
        tfRgCliente.setText(mod.getDocumento2());
        cbEstCivilCliente.setSelectedItem(mod.getEstado_civil());
        tfContatos.setText(mod.getContatos());
        tfEmail.setText(mod.getEmail());
        tfRendaFamiliar.setText(mod.getRenda());

        tfNomeConjuge.setText(mod.getConjuge());
        tfDtConjuge.setText(mod.getDt_nasc_conjuge());
        tfCpfConjuge.setText(mod.getCpf_conjuge());
        tfContatosConjuge.setText(mod.getContato_conjuge());

        tfEndereco.setText(mod.getEndereco());
        tfBairro.setText(mod.getBairro());
        tfCidade.setText(mod.getCidade());
        cbEstados.setSelectedItem(mod.getEstado());
        tfComplemento.setText(mod.getComplemento());
        tfCEP.setText(mod.getCep());
        cbMoradia.setSelectedItem(mod.getMoradia());

        tfNomeEmpresa.setText(mod.getNome_empresa());
        tfContatoEmpresa.setText(mod.getContato_empresa());
        tfFuncaoEmpresa.setText(mod.getFuncao());
        tfEnderecoEmpresa.setText(mod.getEndereco_empresa());
        tfDtAdmissao.setText(mod.getDt_admissao());

        btSalvar.setEnabled(true);
        btExcluir.setEnabled(true);

        HabilitaCamposConjuge();

    }

    public void resetFrame() {

        for (int i = 0; i < painelDadosPessoais.getComponentCount(); i++) {
            if (this.painelDadosPessoais.getComponent(i) instanceof JTextField) {
                JTextField tf = (JTextField) painelDadosPessoais.getComponent(i);
                tf.setText(null);
            }
        }

        for (int i = 0; i < painelConjugeTrabalho.getComponentCount(); i++) {
            if (this.painelConjugeTrabalho.getComponent(i) instanceof JTextField) {
                JTextField tf = (JTextField) painelConjugeTrabalho.getComponent(i);
                tf.setText(null);
            }
        }

        tfCodigoCliente.setText("0000");
        tfRendaFamiliar.setText("0,00");
        tfSalarioConjuge.setText("0,00");
        tfSalarioCliente.setText("0,00");
        painelAbas.setSelectedIndex(0);
        lbStatus.setText("");
        btExcluir.setEnabled(false);

    }

    public void calculaRenda() {

        double s1 = Double.parseDouble(tfSalarioConjuge.getText().replace(",", "."));
        double s2 = Double.parseDouble(tfSalarioCliente.getText().replace(",", "."));

        tfRendaFamiliar.setText(String.format("%.2f", s1 + s2));
    }

    public boolean calculaMaiorIdade(String data) {

        ControleDataHora dt = new ControleDataHora();
        String hj = dt.retornaData();

        int ano_niver = Integer.parseInt(data.substring(6));
        int ano_atual = Integer.parseInt(hj.substring(6));

        return (ano_atual - ano_niver) >= 18;

    }

    public void HabilitaCamposConjuge() {

        if (cbEstCivilCliente.getSelectedIndex() == 1) {
            tfNomeConjuge.setEnabled(true);
            tfDtConjuge.setEnabled(true);
            tfCpfConjuge.setEnabled(true);
            tfContatosConjuge.setEnabled(true);
            tfSalarioConjuge.setEnabled(true);
        } else {
            tfNomeConjuge.setEnabled(false);
            tfNomeConjuge.setText("");
            tfDtConjuge.setEnabled(false);
            tfDtConjuge.setText("");
            tfCpfConjuge.setEnabled(false);
            tfCpfConjuge.setText("");
            tfContatosConjuge.setEnabled(false);
            tfContatosConjuge.setText("");
            tfSalarioConjuge.setEnabled(false);
            tfSalarioConjuge.setText("0,00");

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        painelAbas = new javax.swing.JTabbedPane();
        painelDadosPessoais = new javax.swing.JPanel();
        tfNomeCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfDtCliente = new javax.swing.JFormattedTextField();
        cbGeneroCliente = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbEstCivilCliente = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        tfContatos = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        tfCidade = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        tfComplemento = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        cbEstados = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        cbMoradia = new javax.swing.JComboBox<>();
        tfEndereco = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        tfCEP = new javax.swing.JFormattedTextField();
        tfBairro = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        tfRgCliente = new javax.swing.JTextField();
        tfCpfCliente = new javax.swing.JFormattedTextField();
        btLista = new javax.swing.JButton();
        painelConjugeTrabalho = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        tfNomeConjuge = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        tfDtConjuge = new javax.swing.JFormattedTextField();
        jLabel34 = new javax.swing.JLabel();
        tfContatosConjuge = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        tfSalarioConjuge = new javax.swing.JFormattedTextField();
        jLabel35 = new javax.swing.JLabel();
        tfFuncaoEmpresa = new javax.swing.JTextField();
        tfContatoEmpresa = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        tfEnderecoEmpresa = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        tfSalarioCliente = new javax.swing.JFormattedTextField();
        jLabel48 = new javax.swing.JLabel();
        tfCpfConjuge = new javax.swing.JFormattedTextField();
        tfDtAdmissao = new javax.swing.JFormattedTextField();
        tfRendaFamiliar = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        tfNomeEmpresa = new javax.swing.JTextField();
        painelPessoaJuridica = new javax.swing.JPanel();
        painelCabecalho = new javax.swing.JPanel();
        rbPessoaFisica = new javax.swing.JRadioButton();
        rbPessoaJuridica = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        tfCodigoCliente = new javax.swing.JTextField();
        lbStatus = new javax.swing.JLabel();
        painelBotoes = new javax.swing.JPanel();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setTitle("Clientes");
        setToolTipText("");

        painelDadosPessoais.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome Completo*");

        jLabel2.setText("C.P.F*");

        jLabel3.setText("Data de Nascimento*");

        jLabel4.setText("R.G");

        jLabel5.setText("Gênero");

        try {
            tfDtCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDtClienteFocusLost(evt);
            }
        });

        cbGeneroCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino", "Outros" }));

        jLabel6.setText("Estado Civil");

        cbEstCivilCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Solteiro(a)", "Casado(a)" }));
        cbEstCivilCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cbEstCivilClienteFocusLost(evt);
            }
        });

        jLabel26.setText("Contatos : Fixo, Celular, Fax*");

        jLabel29.setText("Email");

        jLabel37.setText("Cidade*");

        jLabel38.setText("UF - Estado");

        cbEstados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel39.setText("Complemento");

        cbMoradia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Propria", "Alugada" }));

        jLabel40.setText("Moradia");

        jLabel41.setText("Endereço : (Rua, Nº,  Quadra, Praça)*");

        try {
            tfCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel42.setText("CEP");

        jLabel49.setText("Bairro");

        try {
            tfCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpfCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCpfCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCpfClienteFocusLost(evt);
            }
        });

        btLista.setText("...");
        btLista.setToolTipText("Pesquisa");
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelDadosPessoaisLayout = new javax.swing.GroupLayout(painelDadosPessoais);
        painelDadosPessoais.setLayout(painelDadosPessoaisLayout);
        painelDadosPessoaisLayout.setHorizontalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39)
                            .addComponent(tfBairro, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                            .addComponent(tfComplemento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel38)
                                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                        .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btLista, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfCidade))
                                .addContainerGap())
                            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(cbMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel42)
                                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(103, 103, 103))))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addComponent(jLabel41)
                        .addGap(447, 447, 447))
                    .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel26)
                                    .addComponent(tfContatos, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfEmail))
                            .addComponent(tfEndereco)
                            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))
                            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel29)
                                    .addComponent(tfRgCliente))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(cbEstCivilCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        painelDadosPessoaisLayout.setVerticalGroup(
            painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelDadosPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addGap(9, 9, 9)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfDtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbGeneroCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstCivilCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfRgCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel29)
                    .addComponent(jLabel26))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfContatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLista))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40)
                    .addComponent(jLabel42))
                .addGap(4, 4, 4)
                .addGroup(painelDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbMoradia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        painelAbas.addTab("Dados Pessoais", painelDadosPessoais);

        painelConjugeTrabalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setText("Nome Completo (Cônjuge)");

        tfNomeConjuge.setEnabled(false);

        jLabel33.setText("Data de Nascimento");

        try {
            tfDtConjuge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtConjuge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfDtConjuge.setEnabled(false);
        tfDtConjuge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfDtConjugeFocusLost(evt);
            }
        });

        jLabel34.setText("Contatos : Fixo, Celular, Fax *");

        tfContatosConjuge.setEnabled(false);

        jLabel31.setText("C.P.F");

        jLabel7.setText("Salário R$ (Cônjuge)");

        tfSalarioConjuge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfSalarioConjuge.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSalarioConjuge.setText("0,00");
        tfSalarioConjuge.setEnabled(false);
        tfSalarioConjuge.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfSalarioConjuge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSalarioConjugeFocusLost(evt);
            }
        });

        jLabel35.setText("Função ou cargo excercido");

        jLabel36.setText("Contatos (Tel., Cel., Fax)");

        jLabel43.setText("Data de Admissão");

        jLabel44.setText("Nome da Empresa");

        jLabel46.setText("Endereço Completo (Rua, Nº, Bairro, Quadra, Praça)");

        tfSalarioCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfSalarioCliente.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfSalarioCliente.setText("0,00");
        tfSalarioCliente.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tfSalarioCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfSalarioClienteFocusLost(evt);
            }
        });

        jLabel48.setText("Salário (R$) *");

        try {
            tfCpfConjuge.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpfConjuge.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCpfConjuge.setEnabled(false);
        tfCpfConjuge.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCpfConjugeFocusLost(evt);
            }
        });

        try {
            tfDtAdmissao.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDtAdmissao.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        tfRendaFamiliar.setBackground(new java.awt.Color(204, 204, 255));
        tfRendaFamiliar.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("##0.00"))));
        tfRendaFamiliar.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfRendaFamiliar.setText("0,00");
        tfRendaFamiliar.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        tfRendaFamiliar.setEnabled(false);
        tfRendaFamiliar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel8.setText("Renda Familiar R$");

        tfNomeEmpresa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfNomeEmpresaFocusGained(evt);
            }
        });

        javax.swing.GroupLayout painelConjugeTrabalhoLayout = new javax.swing.GroupLayout(painelConjugeTrabalho);
        painelConjugeTrabalho.setLayout(painelConjugeTrabalhoLayout);
        painelConjugeTrabalhoLayout.setHorizontalGroup(
            painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator3)
            .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(400, 400, 400))
                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                        .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel35)
                                    .addComponent(tfFuncaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfNomeEmpresa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfContatoEmpresa)
                                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                        .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                        .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                                .addComponent(jLabel48)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(tfSalarioCliente)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConjugeTrabalhoLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfRendaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(368, 368, 368))
                                        .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                            .addComponent(tfCpfConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                                    .addComponent(jLabel34)
                                                    .addGap(225, 225, 225))
                                                .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                                    .addComponent(tfContatosConjuge)
                                                    .addGap(10, 10, 10)))))
                                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                        .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfNomeConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfDtConjuge)
                                    .addComponent(tfSalarioConjuge)
                                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                                        .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel33)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addComponent(tfEnderecoEmpresa))
                        .addContainerGap())))
        );
        painelConjugeTrabalhoLayout.setVerticalGroup(
            painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(9, 9, 9)
                        .addComponent(tfNomeConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfDtConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jLabel31)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfContatosConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSalarioConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpfConjuge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfContatoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                            .addComponent(jLabel35)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(tfFuncaoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSalarioCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfDtAdmissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(painelConjugeTrabalhoLayout.createSequentialGroup()
                        .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(jLabel48))
                        .addGap(26, 26, 26)))
                .addGap(7, 7, 7)
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfEnderecoEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelConjugeTrabalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfRendaFamiliar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        painelAbas.addTab("Dados Cônjuge & Trabalhista", painelConjugeTrabalho);

        javax.swing.GroupLayout painelPessoaJuridicaLayout = new javax.swing.GroupLayout(painelPessoaJuridica);
        painelPessoaJuridica.setLayout(painelPessoaJuridicaLayout);
        painelPessoaJuridicaLayout.setHorizontalGroup(
            painelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 669, Short.MAX_VALUE)
        );
        painelPessoaJuridicaLayout.setVerticalGroup(
            painelPessoaJuridicaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 348, Short.MAX_VALUE)
        );

        painelAbas.addTab("Dados Empresa", painelPessoaJuridica);

        painelCabecalho.setBackground(new java.awt.Color(102, 102, 102));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rbPessoaFisica.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(rbPessoaFisica);
        rbPessoaFisica.setForeground(new java.awt.Color(255, 255, 255));
        rbPessoaFisica.setSelected(true);
        rbPessoaFisica.setText("Pessoa Física");
        rbPessoaFisica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoaFisicaActionPerformed(evt);
            }
        });

        rbPessoaJuridica.setBackground(new java.awt.Color(102, 102, 102));
        buttonGroup2.add(rbPessoaJuridica);
        rbPessoaJuridica.setForeground(new java.awt.Color(255, 255, 255));
        rbPessoaJuridica.setText("Pessoa Jurídica");
        rbPessoaJuridica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPessoaJuridicaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CODIGO :");

        tfCodigoCliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfCodigoCliente.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCodigoCliente.setText("0000");
        tfCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoClienteActionPerformed(evt);
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
                .addContainerGap()
                .addComponent(rbPessoaFisica)
                .addGap(18, 18, 18)
                .addComponent(rbPessoaJuridica)
                .addGap(38, 38, 38)
                .addComponent(lbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbPessoaFisica)
                    .addComponent(rbPessoaJuridica)
                    .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar24.png"))); // NOI18N
        btCancelar.setText("Sair");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/primeiro24.png"))); // NOI18N
        jButton1.setToolTipText("Primeiro");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/anterior24.png"))); // NOI18N
        jButton2.setToolTipText("Anterior");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/proximo24.png"))); // NOI18N
        jButton3.setToolTipText("Proximo");

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ultimo24.png"))); // NOI18N
        jButton4.setToolTipText("Ultimo");

        javax.swing.GroupLayout painelBotoesLayout = new javax.swing.GroupLayout(painelBotoes);
        painelBotoes.setLayout(painelBotoesLayout);
        painelBotoesLayout.setHorizontalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelBotoesLayout.setVerticalGroup(
            painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelBotoesLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelAbas, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(painelBotoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelAbas, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelBotoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        if (!tfNomeCliente.getText().equals("") && !tfContatos.getText().equals("")
                && !tfEndereco.getText().equals("") && !tfCidade.getText().equals("")
                && tfDtCliente.getForeground().equals(new Color(255, 255, 2555))) {

            if (!tfRendaFamiliar.getText().equals("0,00")) {
                ModeloClientes modP = new ModeloClientes();

                modP.setNome_pessoa(tfNomeCliente.getText());
                modP.setGenero((String) cbGeneroCliente.getSelectedItem());
                modP.setDt_nascimento(tfDtCliente.getText());
                modP.setDocumento1(tfCpfCliente.getText());
                modP.setDocumento2(tfRgCliente.getText());
                modP.setEstado_civil((String) cbEstCivilCliente.getSelectedItem());
                modP.setContatos(tfContatos.getText());
                modP.setEmail(tfEmail.getText());
                modP.setConjuge(tfNomeConjuge.getText());
                modP.setDt_nasc_conjuge(tfDtConjuge.getText());
                modP.setCpf_conjuge(tfCpfConjuge.getText());
                modP.setContato_conjuge(tfContatosConjuge.getText());
                modP.setNome_empresa(tfNomeEmpresa.getText());
                modP.setContato_empresa(tfContatoEmpresa.getText());
                modP.setFuncao(tfFuncaoEmpresa.getText());
                modP.setEndereco_empresa(tfEnderecoEmpresa.getText());
                modP.setRenda(tfRendaFamiliar.getText());
                modP.setDt_admissao(tfDtAdmissao.getText());

                modP.setEndereco(tfEndereco.getText());
                modP.setBairro(tfBairro.getText());
                modP.setCidade(tfCidade.getText());
                modP.setEstado((String) cbEstados.getSelectedItem());
                modP.setMoradia((String) cbMoradia.getSelectedItem());
                modP.setComplemento(tfComplemento.getText());
                modP.setCep(tfCEP.getText());

                modP.setId_pessoa(Integer.parseInt(tfCodigoCliente.getText()));

                switch (lbStatus.getText()) {
                    case "Cadastrando...":
                        cliente.CadastrarCliente(modP);
                        resetFrame();
                        break;
                    case "Editando...":
                        cliente.EditarCliente(modP);
                        resetFrame();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Informe sua Renda");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os campos os obrigatórios (*)", "AVISO", JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void rbPessoaJuridicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPessoaJuridicaActionPerformed
        // TODO add your handling code here:

        painelAbas.setEnabledAt(0, false);
        painelAbas.setEnabledAt(1, false);
        painelAbas.setEnabledAt(2, true);
        painelAbas.setSelectedIndex(2);

    }//GEN-LAST:event_rbPessoaJuridicaActionPerformed

    private void rbPessoaFisicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPessoaFisicaActionPerformed
        // TODO add your handling code here:
        painelAbas.setEnabledAt(0, true);
        painelAbas.setEnabledAt(1, true);
        painelAbas.setEnabledAt(2, false);
        painelAbas.setSelectedIndex(0);
    }//GEN-LAST:event_rbPessoaFisicaActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR O CLIENTE\n" + tfNomeCliente.getText());

        if (op == JOptionPane.YES_OPTION) {
            cliente.ExcluirCliente(tfCodigoCliente.getText());
            resetFrame();

        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:

        String sql = "select id_cliente, nome_pessoa, documento1 from tbla_clientes order by id_cliente";
        String[] col = {"ID CLIENTE", "CLIENTE", "CPF / CNPJ"};
        int[] larg = {20, 300, 80};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            setDados(frm.getValor1());
            lbStatus.setText("Editando...");
            lbStatus.setForeground(Color.YELLOW);
        }

    }//GEN-LAST:event_btBuscarActionPerformed

    private void cbEstCivilClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cbEstCivilClienteFocusLost
        // TODO add your handling code here:
        HabilitaCamposConjuge();
    }//GEN-LAST:event_cbEstCivilClienteFocusLost

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        resetFrame();
        btSalvar.setEnabled(true);
        tfCodigoCliente.setText(String.valueOf(cliente.retornaUltimoId() + 1));
        lbStatus.setText("Cadastrando...");
        lbStatus.setForeground(Color.GREEN);

    }//GEN-LAST:event_btNovoActionPerformed

    private void tfCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoClienteActionPerformed
        // TODO add your handling code here:
        if (!tfCodigoCliente.getText().equals("0000") && !tfCodigoCliente.getText().equals("")) {
            setDados(tfCodigoCliente.getText());
            lbStatus.setText("Editando...");
            lbStatus.setForeground(Color.YELLOW);
        } else {
            JOptionPane.showMessageDialog(null, "PARÂMENTRO INCORRETO, 0000 ou Null", "AVISO", JOptionPane.OK_OPTION);
        }

    }//GEN-LAST:event_tfCodigoClienteActionPerformed

    private void tfSalarioClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSalarioClienteFocusLost
        // TODO add your handling code here:
        calculaRenda();
    }//GEN-LAST:event_tfSalarioClienteFocusLost

    private void tfSalarioConjugeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfSalarioConjugeFocusLost
        // TODO add your handling code here:
        calculaRenda();
    }//GEN-LAST:event_tfSalarioConjugeFocusLost

    private void tfNomeEmpresaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfNomeEmpresaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNomeEmpresaFocusGained

    private void tfDtConjugeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDtConjugeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDtConjugeFocusLost

    private void tfDtClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfDtClienteFocusLost
        // TODO add your handling code here:   

        if (calculaMaiorIdade(tfDtCliente.getText())) {
            tfDtCliente.setBackground(Color.white);
        } else {
            tfDtCliente.setBackground(Color.red);
        }

    }//GEN-LAST:event_tfDtClienteFocusLost

    private void tfCpfClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfClienteFocusLost
        // TODO add your handling code here:

        if (docs.validaCPF(tfCpfCliente.getText())) {
            tfCpfCliente.setBackground(Color.white);
        } else {
            tfCpfCliente.setBackground(Color.red);
        }

    }//GEN-LAST:event_tfCpfClienteFocusLost

    private void tfCpfConjugeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfConjugeFocusLost
        // TODO add your handling code here:
        if (!docs.validaCPF(tfCpfConjuge.getText())) {
            tfCpfConjuge.setBackground(Color.red);
        } else {
            tfCpfConjuge.setBackground(Color.white);
        }
    }//GEN-LAST:event_tfCpfConjugeFocusLost

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
        // TODO add your handling code here:

        ControleArquivos arq = new ControleArquivos();
        String estado = (String) cbEstados.getSelectedItem();
        ArrayList dados = arq.retornaListaLinhas("C:\\SistemaPDV\\cidades\\" + estado + ".txt");

        FrmDialogListas frm = new FrmDialogListas(new JFrame(), true, dados);
        frm.setTitle("Lista de cidades UF - " + estado);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            tfCidade.setText(frm.getValor());
        }

    }//GEN-LAST:event_btListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbEstCivilCliente;
    private javax.swing.JComboBox<String> cbEstados;
    private javax.swing.JComboBox<String> cbGeneroCliente;
    private javax.swing.JComboBox<String> cbMoradia;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JTabbedPane painelAbas;
    private javax.swing.JPanel painelBotoes;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelConjugeTrabalho;
    private javax.swing.JPanel painelDadosPessoais;
    private javax.swing.JPanel painelPessoaJuridica;
    private javax.swing.JRadioButton rbPessoaFisica;
    private javax.swing.JRadioButton rbPessoaJuridica;
    private javax.swing.JTextField tfBairro;
    private javax.swing.JFormattedTextField tfCEP;
    private javax.swing.JTextField tfCidade;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JTextField tfComplemento;
    private javax.swing.JTextField tfContatoEmpresa;
    private javax.swing.JTextField tfContatos;
    private javax.swing.JTextField tfContatosConjuge;
    private javax.swing.JFormattedTextField tfCpfCliente;
    private javax.swing.JFormattedTextField tfCpfConjuge;
    private javax.swing.JFormattedTextField tfDtAdmissao;
    private javax.swing.JFormattedTextField tfDtCliente;
    private javax.swing.JFormattedTextField tfDtConjuge;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfEndereco;
    private javax.swing.JTextField tfEnderecoEmpresa;
    private javax.swing.JTextField tfFuncaoEmpresa;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNomeConjuge;
    private javax.swing.JTextField tfNomeEmpresa;
    private javax.swing.JFormattedTextField tfRendaFamiliar;
    private javax.swing.JTextField tfRgCliente;
    private javax.swing.JFormattedTextField tfSalarioCliente;
    private javax.swing.JFormattedTextField tfSalarioConjuge;
    // End of variables declaration//GEN-END:variables
}
