package Visao;

import Visao.Dialogs.FrmDialogListas;
import Visao.Dialogs.FrmDialogPesquisas;
import Controle.ControleArquivos;
import Controle.ControleFuncionario;
import Modelo.ModeloFuncionario;
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
public class FrmInternalFuncionarios extends javax.swing.JInternalFrame {

    private final ControleDocumentos docs;
    private final ControleFuncionario cont;

    public FrmInternalFuncionarios() {
        initComponents();
        this.docs = new ControleDocumentos();
        this.cont = new ControleFuncionario();
        
    }

    public void setDados(String id_func) {

        ModeloFuncionario mod = cont.retornaFuncionario(id_func);

        tfNomeFunc.setText(mod.getNome_funcionario());
        tfCpfFunc.setText(mod.getCpf());
        tfBairroFunc.setText(mod.getBairro());
        tfCepFunc.setText(mod.getCep());
        tfCidadeFunc.setText(mod.getCidade());
        tfCodigoFuncionario.setText("" + mod.getId_funcionario());
        tfComplementoFunc.setText(mod.getComplemento());
        tfContatosFunc.setText(mod.getContatos());
        tfEmailFunc.setText(mod.getEmail());
        tfEnderecoFunc.setText(mod.getEndereco());
        tfFuncao.setText(mod.getFuncao());
        tfSenha.setText(mod.getSenha());

        cbEstadosFunc.setSelectedItem(mod.getEstado());
        cbNivelPrioridade.setSelectedItem("" + mod.getNivel_prioridade());

        lbStatus.setText("Editando...");
        lbStatus.setForeground(Color.yellow);
        btExcluir.setEnabled(true);

    }

    public void resetFrame() {

        //Limpa todos os TextFields do painelCampos
        for (int i = 0; i < painelCampos.getComponentCount(); i++) {
            if (this.painelCampos.getComponent(i) instanceof JTextField) {
                JTextField tf = (JTextField) painelCampos.getComponent(i);
                tf.setText(null);
            }
        }

        btSalvar.setEnabled(false);
        btExcluir.setEnabled(false);
        lbStatus.setText("");
        tfCodigoFuncionario.setText("0000");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCabecalho = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        tfCodigoFuncionario = new javax.swing.JTextField();
        lbStatus = new javax.swing.JLabel();
        painelCampos = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfNomeFunc = new javax.swing.JTextField();
        tfCpfFunc = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        cbNivelPrioridade = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfEnderecoFunc = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfContatosFunc = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        tfEmailFunc = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfBairroFunc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfCidadeFunc = new javax.swing.JTextField();
        cbEstadosFunc = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfCepFunc = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tfComplementoFunc = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        tfFuncao = new javax.swing.JTextField();
        checkMostrarSenha = new javax.swing.JCheckBox();
        jSeparator1 = new javax.swing.JSeparator();
        btLista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btSair = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Funcionários");

        painelCabecalho.setBackground(new java.awt.Color(102, 102, 102));
        painelCabecalho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CODIGO :");

        tfCodigoFuncionario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        tfCodigoFuncionario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCodigoFuncionario.setText("0000");
        tfCodigoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfCodigoFuncionarioActionPerformed(evt);
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
                .addGap(57, 57, 57)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelCabecalhoLayout.setVerticalGroup(
            painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        painelCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Nome Completo *");

        try {
            tfCpfFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfCpfFunc.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCpfFunc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCpfFuncFocusLost(evt);
            }
        });

        jLabel2.setText("CPF*");

        cbNivelPrioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));

        jLabel3.setText("Nivel de Prioridade ");

        jLabel4.setText("Endereco (Nº, Rua, Praça, Quadra)*");

        jLabel5.setText("Contatos* (Tel. Cel. Fax)");

        jLabel6.setText("Senha de Acesso*");

        jLabel7.setText("Email");

        jLabel8.setText("Bairro");

        jLabel10.setText("Cidade / Municipio");

        cbEstadosFunc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel11.setText("Estado - UF");

        try {
            tfCepFunc.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel12.setText("CEP (Caixa postal)");

        jLabel13.setText("Complemento");

        jLabel15.setText("Funcão");

        checkMostrarSenha.setText("?");
        checkMostrarSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMostrarSenhaActionPerformed(evt);
            }
        });

        btLista.setText("...");
        btLista.setToolTipText("Pesquisa");
        btLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCamposLayout = new javax.swing.GroupLayout(painelCampos);
        painelCampos.setLayout(painelCamposLayout);
        painelCamposLayout.setHorizontalGroup(
            painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfContatosFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCamposLayout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfEmailFunc)))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(tfEnderecoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCamposLayout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(painelCamposLayout.createSequentialGroup()
                                .addComponent(tfBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfComplementoFunc)
                                    .addGroup(painelCamposLayout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(tfCepFunc)))))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(cbNivelPrioridade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCamposLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelCamposLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                                .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(checkMostrarSenha)
                                .addGap(4, 4, 4))))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(tfNomeFunc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfCpfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbEstadosFunc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                        .addGap(5, 5, 5)
                        .addComponent(btLista, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelCamposLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10))
                            .addGroup(painelCamposLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(tfCidadeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelCamposLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(378, 378, 378)
                        .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel2))))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        painelCamposLayout.setVerticalGroup(
            painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCpfFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel15)
                    .addComponent(jLabel3))
                .addGap(4, 4, 4)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfFuncao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNivelPrioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(checkMostrarSenha))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfEnderecoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfBairroFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfComplementoFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCidadeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbEstadosFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfCepFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLista))
                .addGap(12, 12, 12)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfContatosFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmailFunc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/cancelar24.png"))); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(btCancelar))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelCabecalho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(painelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(painelCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfCodigoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfCodigoFuncionarioActionPerformed
        // TODO add your handling code here:
        setDados(tfCodigoFuncionario.getText());
    }//GEN-LAST:event_tfCodigoFuncionarioActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btSairActionPerformed

    private void tfCpfFuncFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCpfFuncFocusLost
        // TODO add your handling code here:
        if (!docs.validaCPF(tfCpfFunc.getText())) {
            tfCpfFunc.setBackground(Color.red);
        } else {
            tfCpfFunc.setBackground(Color.white);
        }
    }//GEN-LAST:event_tfCpfFuncFocusLost

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        // TODO add your handling code here:

        if (!tfNomeFunc.getText().equals("") && !tfEnderecoFunc.getText().equals("") 
         && !tfContatosFunc.getText().equals("") && !tfSenha.getText().equals("")) {            
               
                ModeloFuncionario modF = new ModeloFuncionario();
                modF.setNome_funcionario(tfNomeFunc.getText());
                modF.setCpf(tfCpfFunc.getText());
                modF.setFuncao(tfFuncao.getText());
                modF.setNivel_prioridade(cbNivelPrioridade.getSelectedIndex() + 1);
                modF.setSenha(String.valueOf(tfSenha.getPassword()));
                modF.setContatos(tfContatosFunc.getText());
                modF.setEmail(tfEmailFunc.getText());
                modF.setEndereco(tfEnderecoFunc.getText());
                modF.setBairro(tfBairroFunc.getText());
                modF.setCidade(tfCidadeFunc.getText());
                modF.setEstado((String) cbEstadosFunc.getSelectedItem());
                modF.setComplemento(tfComplementoFunc.getText());
                modF.setCep(tfCepFunc.getText());

                modF.setId_funcionario(Integer.parseInt(tfCodigoFuncionario.getText()));

                switch (lbStatus.getText()) {
                    case "Cadastrando...":
                        cont.cadastrarFuncionario(modF);
                        break;
                    case "Editando...":
                        cont.editarFuncionario(modF);
                        break;
                }
                resetFrame();
        } else {
            JOptionPane.showMessageDialog(null, "VERIFIQUE OS CAMPOS OBRIGATÓRIOS (*)");
        }


    }//GEN-LAST:event_btSalvarActionPerformed

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        // TODO add your handling code here:

        String sql = "select id_funcionario, nome_funcionario, funcao from tbla_funcionarios order by id_funcionario";
        String[] col = {"ID FUNCIONARIO", "NOME COMPLETO", "FUNÇÃO"};
        int[] larg = {20, 200, 80};

        FrmDialogPesquisas frm = new FrmDialogPesquisas(new JFrame(), true, sql, col, larg);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            setDados(frm.getValor1());
        }

    }//GEN-LAST:event_btBuscarActionPerformed

    private void btListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListaActionPerformed
        // TODO add your handling code here:

        ControleArquivos arq = new ControleArquivos();
        String estado = (String) cbEstadosFunc.getSelectedItem();
        ArrayList dados = arq.retornaListaLinhas("C:\\SistemaPDV\\cidades\\" + estado + ".txt");

        FrmDialogListas frm = new FrmDialogListas(new JFrame(), true, dados);
        frm.setTitle("Lista de cidades UF - " + estado);
        frm.setVisible(true);

        if (frm.isConfirma()) {
            tfCidadeFunc.setText(frm.getValor());
        }

    }//GEN-LAST:event_btListaActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:

        int op = JOptionPane.showConfirmDialog(null, "DESEJA EXCLUIR ESSE FUNCIONARIO", "EXCLUIR?", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            cont.excluirFuncionario(Integer.parseInt(tfCodigoFuncionario.getText()));
            resetFrame();
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        resetFrame();
        btSalvar.setEnabled(true);
        lbStatus.setText("Cadastrando...");
        lbStatus.setForeground(Color.green);
        tfCodigoFuncionario.setText("" + cont.retornaProximoID());
    }//GEN-LAST:event_btNovoActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        resetFrame();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void checkMostrarSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMostrarSenhaActionPerformed
        // TODO add your handling code here:

        if (checkMostrarSenha.isSelected()) {
            tfSenha.setEchoChar((char) 0);
        } else {
            tfSenha.setEchoChar(('*'));
        }
    }//GEN-LAST:event_checkMostrarSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btLista;
    private javax.swing.JButton btNovo;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btSalvar;
    private javax.swing.JComboBox<String> cbEstadosFunc;
    private javax.swing.JComboBox<String> cbNivelPrioridade;
    private javax.swing.JCheckBox checkMostrarSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbStatus;
    private javax.swing.JPanel painelCabecalho;
    private javax.swing.JPanel painelCampos;
    private javax.swing.JTextField tfBairroFunc;
    private javax.swing.JFormattedTextField tfCepFunc;
    private javax.swing.JTextField tfCidadeFunc;
    private javax.swing.JTextField tfCodigoFuncionario;
    private javax.swing.JTextField tfComplementoFunc;
    private javax.swing.JTextField tfContatosFunc;
    private javax.swing.JFormattedTextField tfCpfFunc;
    private javax.swing.JTextField tfEmailFunc;
    private javax.swing.JTextField tfEnderecoFunc;
    private javax.swing.JTextField tfFuncao;
    private javax.swing.JTextField tfNomeFunc;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables
}
