/*
Navicat MySQL Data Transfer

Source Server         : local MySQL
Source Server Version : 50614
Source Host           : localhost:3306
Source Database       : bd_sistemapdv

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2017-06-12 08:16:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbla_caixas
-- ----------------------------
DROP TABLE IF EXISTS `tbla_caixas`;
CREATE TABLE `tbla_caixas` (
`id_caixa`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`data`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`valor_inicial`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' ,
`valor_final`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' ,
`status`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_caixa`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of tbla_caixas
-- ----------------------------
BEGIN;
INSERT INTO `tbla_caixas` VALUES ('000001', '13/01/2017', '0,00', '0,00', 'Fechado'), ('000002', '14/01/2017', '0,00', '0,00', 'Fechado'), ('000003', '19/01/2017', '0,00', '0,00', 'Fechado'), ('000004', '14/02/2017', '0,00', '0,00', 'Fechado'), ('000006', '20/04/2017', '100,00', '0', 'Aberto');
COMMIT;

-- ----------------------------
-- Table structure for tbla_clientes
-- ----------------------------
DROP TABLE IF EXISTS `tbla_clientes`;
CREATE TABLE `tbla_clientes` (
`id_cliente`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`nome_pessoa`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`genero`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dt_nascimento`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`documento1`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`documento2`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`estado_civil`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`contatos`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`renda`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nome_conjuge`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dt_nasc_conjuge`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cpf_conjuge`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`contato_conjuge`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nome_empresa`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`funcao`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`contato_empresa`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`endereco_empresa`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`dt_admissao`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`endereco`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bairro`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cidade`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`estado`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`complemento`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cep`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`moradia`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_cliente`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=4

;

-- ----------------------------
-- Records of tbla_clientes
-- ----------------------------
BEGIN;
INSERT INTO `tbla_clientes` VALUES ('000001', 'ALEXANDRE HENRIQUE CARVALHO BARBOSA', 'Masculino', '07/03/1992', '052.830.423-24', '0324680920062', 'Casado(a)', '(99) 984406552', 'alexhcb.7392@gmail.com', '2200,00', 'NICOLE STEFANIE MACEDO DA COSTA', '08/07/1992', '059.339.383-00', '', 'CONTABILIZE CONTABILIDADE LTDA - EPP', 'TECNICO EM INFORMATICA', '(99) 3541-2621', 'AVENIDA CONTORNO, Nº 555, BAIRRO DE FATIMA, ANDAR 01 SALA B', '01/07/2015', 'RUA COELHO NETO 231', 'CENTRO', 'Balsas', 'MA', 'Em frente a malharia mano a mano', '65.800-000', 'Propria'), ('000002', 'CLIENTE TESTE 001', 'Feminino', '01/01/1989', '111.222 .333-44  ', '', 'Solteiro(a)', '(99) 99999-9999', '', '900,00', '', '  /  /    ', '   .   .   -  ', '', 'EMPRESA 001', 'AUX. INFORMATICA', '(99) 12345-1234', 'RUA 01, SN, CENTRO', '01/01/2009', 'RUA 01, SN', 'CENTRO', 'Tasso Fragoso', 'MA', '', '65.800-000', 'Propria'), ('000003', 'CLIENTE TESTE 002', 'Masculino', '01/01/1981', '222.222 .222-22  ', '', 'Solteiro(a)', '(99) 99999-9999', '', '900,00', '', '  /  /    ', '   .   .   -  ', '', 'EMPRESA 002', 'SECRETÁRIA', '(99) 12345-1234', 'RUA 01, SN, CENTRO', '01/01/2009', 'RUA 01, SN', 'CENTRO', 'Tasso Fragoso', 'MA', '', '65.800-000', 'Propria');
COMMIT;

-- ----------------------------
-- Table structure for tbla_empresa
-- ----------------------------
DROP TABLE IF EXISTS `tbla_empresa`;
CREATE TABLE `tbla_empresa` (
`id_empresa`  int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`razao_social`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nome_fantasia`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cnpj`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`insc_estadual`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`contato`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`endereco`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bairro`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cidade`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`estado`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`ramo`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`site`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_empresa`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of tbla_empresa
-- ----------------------------
BEGIN;
INSERT INTO `tbla_empresa` VALUES ('00000000002', 'ALEXANDRE H. C. B. SISTEMAS', 'ATI SISTEMAS', '13.249.083/0001-07', '12.123.12-12', '(99) 1234-1234 / (99) 9876-5432', '', 'AV CONTORNO', 'FLORA-RICA', 'Balsas', 'MA', 'MANUTENÇÃO, INFORMATICA', '');
COMMIT;

-- ----------------------------
-- Table structure for tbla_forma_pagamento
-- ----------------------------
DROP TABLE IF EXISTS `tbla_forma_pagamento`;
CREATE TABLE `tbla_forma_pagamento` (
`id_forma_pag`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`descricao`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_forma_pag`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=7

;

-- ----------------------------
-- Records of tbla_forma_pagamento
-- ----------------------------
BEGIN;
INSERT INTO `tbla_forma_pagamento` VALUES ('000001', 'A PRAZO'), ('000002', 'DINHEIRO'), ('000003', 'CARTÃO DE CREDITO'), ('000005', 'CARTÃO DE DEBITO'), ('000006', 'CADASTRO');
COMMIT;

-- ----------------------------
-- Table structure for tbla_fornecedores
-- ----------------------------
DROP TABLE IF EXISTS `tbla_fornecedores`;
CREATE TABLE `tbla_fornecedores` (
`id_fornecedor`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`nome_fornecedor`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cnpj`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel_fixo`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tel_celular`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`outros_contatos`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_fornecedor`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of tbla_fornecedores
-- ----------------------------
BEGIN;
INSERT INTO `tbla_fornecedores` VALUES ('000001', 'FORNECEDOR TESTE 001', '11.222.333/0001-04', '(99)1234-1234', '(99)1234-1234', ''), ('000002', 'FORNECEDOR TESTE 002', '12.123.123/0001-12', '(99)1111-1111', '(99)2222-2222', null);
COMMIT;

-- ----------------------------
-- Table structure for tbla_funcionarios
-- ----------------------------
DROP TABLE IF EXISTS `tbla_funcionarios`;
CREATE TABLE `tbla_funcionarios` (
`id_funcionario`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`nome_funcionario`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`funcao`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`nivel_prioridade`  int(11) NULL DEFAULT NULL ,
`senha`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cpf`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`contatos`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`email`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`endereco`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`bairro`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cidade`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`estado`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`complemento`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cep`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_funcionario`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=3

;

-- ----------------------------
-- Records of tbla_funcionarios
-- ----------------------------
BEGIN;
INSERT INTO `tbla_funcionarios` VALUES ('000001', 'FUNCIONARIO 001', 'GERENTE DE VENDAS', '5', '1234', '052.830.423-24', '(99) 984406552', 'alexhcb.7392@gmail.com', 'RUA COELHO NETO, 231', 'CENTRO', 'Balsas', 'MA', '', '65.800-000'), ('000002', 'FUNCIONARIO 002', 'VENDEDOR INTERNO', '1', '1234', '111.222.333-44', '(99) 1234-1234', null, 'RUA 01', 'CENTRO', 'Balsas', 'MA', null, null);
COMMIT;

-- ----------------------------
-- Table structure for tbla_itens_vendas
-- ----------------------------
DROP TABLE IF EXISTS `tbla_itens_vendas`;
CREATE TABLE `tbla_itens_vendas` (
`id_itens_venda`  int(11) NOT NULL AUTO_INCREMENT ,
`id_venda`  int(6) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
`id_produto`  int(6) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
`qtd_prod`  int(11) NULL DEFAULT NULL ,
`valor_un`  float(10,2) NULL DEFAULT NULL ,
`valor_total`  float(10,2) NULL DEFAULT NULL ,
PRIMARY KEY (`id_itens_venda`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=95

;

-- ----------------------------
-- Records of tbla_itens_vendas
-- ----------------------------
BEGIN;
INSERT INTO `tbla_itens_vendas` VALUES ('22', '000017', '000001', '2', '20.00', '40.00'), ('23', '000017', '000002', '2', '61.50', '123.00'), ('24', '000018', '000002', '2', '61.50', '123.00'), ('25', '000018', '000001', '2', '20.00', '40.00'), ('67', '000059', '000004', '2', '110.00', '220.00'), ('69', '000061', '000003', '5', '25.00', '125.00'), ('70', '000062', '000004', '2', '110.00', '220.00'), ('71', '000063', '000003', '5', '25.00', '125.00'), ('77', '000069', '000004', '2', '110.00', '220.00'), ('78', '000070', '000003', '2', '25.00', '50.00'), ('79', '000070', '000002', '1', '61.50', '61.50'), ('81', '000072', '000004', '1', '110.00', '110.00'), ('82', '000073', '000001', '1', '20.00', '20.00'), ('83', '000074', '000001', '1', '20.00', '20.00'), ('84', '000075', '000004', '1', '110.00', '110.00'), ('85', '000076', '000002', '1', '61.50', '61.50'), ('86', '000077', '000004', '1', '110.00', '110.00'), ('87', '000078', '000005', '2', '60.00', '120.00'), ('88', '000079', '000010', '2', '80.00', '160.00'), ('90', '000081', '000009', '5', '120.00', '600.00'), ('91', '000082', '000003', '5', '25.00', '125.00'), ('94', '000084', '000002', '3', '61.50', '184.50');
COMMIT;

-- ----------------------------
-- Table structure for tbla_parcelamento
-- ----------------------------
DROP TABLE IF EXISTS `tbla_parcelamento`;
CREATE TABLE `tbla_parcelamento` (
`id_parcelamento`  int(11) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`id_venda`  int(6) UNSIGNED ZEROFILL NULL DEFAULT NULL ,
`qtd_parcelas`  int(11) NULL DEFAULT NULL ,
`numero_parcela`  int(11) NULL DEFAULT NULL ,
`vencimento`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`juros`  int(11) NULL DEFAULT NULL ,
`valor_parcela`  double(11,2) NULL DEFAULT NULL ,
`valor_total`  double(11,2) NULL DEFAULT NULL ,
PRIMARY KEY (`id_parcelamento`),
FOREIGN KEY (`id_venda`) REFERENCES `tbla_vendas` (`id_venda`) ON DELETE RESTRICT ON UPDATE RESTRICT,
INDEX `venda` (`id_venda`) USING BTREE 
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=28

;

-- ----------------------------
-- Records of tbla_parcelamento
-- ----------------------------
BEGIN;
INSERT INTO `tbla_parcelamento` VALUES ('00000000004', '000061', '4', '1', '14/02/2017', '0', '31.25', '125.00'), ('00000000005', '000061', '4', '2', '14/03/2017', '0', '31.25', '125.00'), ('00000000006', '000061', '4', '3', '14/04/2017', '0', '31.25', '125.00'), ('00000000007', '000061', '4', '4', '14/05/2017', '0', '31.25', '125.00'), ('00000000008', '000062', '2', '1', '14/02/2017', '0', '110.00', '220.00'), ('00000000009', '000062', '2', '2', '14/03/2017', '0', '110.00', '220.00'), ('00000000010', '000063', '2', '1', '14/02/2017', '0', '62.50', '125.00'), ('00000000011', '000063', '2', '2', '14/03/2017', '0', '62.50', '125.00'), ('00000000019', '000069', '2', '1', '14/02/2017', '0', '85.00', '170.00'), ('00000000020', '000069', '2', '2', '14/03/2017', '0', '85.00', '170.00'), ('00000000021', '000072', '2', '1', '19/02/2017', '0', '55.00', '110.00'), ('00000000022', '000072', '2', '2', '19/03/2017', '0', '55.00', '110.00'), ('00000000023', '000081', '2', '1', '15/03/2017', '10', '330.00', '660.00'), ('00000000024', '000081', '2', '2', '15/04/2017', '10', '330.00', '660.00'), ('00000000025', '000082', '2', '1', '15/03/2017', '0', '62.50', '125.00'), ('00000000026', '000082', '2', '2', '15/04/2017', '0', '62.50', '125.00'), ('00000000027', '000084', '1', '1', '15/03/2017', '0', '184.50', '184.50');
COMMIT;

-- ----------------------------
-- Table structure for tbla_perfis
-- ----------------------------
DROP TABLE IF EXISTS `tbla_perfis`;
CREATE TABLE `tbla_perfis` (
`id_funcionario`  int(6) UNSIGNED ZEROFILL NOT NULL ,
`cad_cliente`  tinyint(1) NULL DEFAULT 0 ,
`cad_fornec`  tinyint(1) NULL DEFAULT 0 ,
`cad_prod`  tinyint(1) NULL DEFAULT 0 ,
`cad_func`  tinyint(1) NULL DEFAULT 0 ,
`cons_estoque`  tinyint(1) NULL DEFAULT 0 ,
`cons_caixa`  tinyint(1) NULL DEFAULT 0 ,
`mov_vendas`  tinyint(1) NULL DEFAULT 0 ,
`mov_caixas`  tinyint(1) NULL DEFAULT 0 ,
`relat_venda`  tinyint(1) NULL DEFAULT 0 ,
`relat_estoque`  tinyint(1) NULL DEFAULT 0 ,
PRIMARY KEY (`id_funcionario`),
FOREIGN KEY (`id_funcionario`) REFERENCES `tbla_funcionarios` (`id_funcionario`) ON DELETE RESTRICT ON UPDATE RESTRICT
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=latin1 COLLATE=latin1_swedish_ci

;

-- ----------------------------
-- Records of tbla_perfis
-- ----------------------------
BEGIN;
INSERT INTO `tbla_perfis` VALUES ('000001', '1', '1', '1', '1', '0', '0', '0', '0', '0', '0'), ('000002', '1', '0', '1', '0', '0', '0', '0', '0', '0', '0');
COMMIT;

-- ----------------------------
-- Table structure for tbla_produtos
-- ----------------------------
DROP TABLE IF EXISTS `tbla_produtos`;
CREATE TABLE `tbla_produtos` (
`id_produto`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`descricao`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`cod_barras`  varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`id_fornecedor`  int(6) NOT NULL ,
`dt_entrada`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`quantidade`  int(11) NOT NULL ,
`estoque_minimo`  int(11) NULL DEFAULT NULL ,
`tipo`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`valor_compra`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`valor_venda`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`valor_total_nota`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_produto`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=11

;

-- ----------------------------
-- Records of tbla_produtos
-- ----------------------------
BEGIN;
INSERT INTO `tbla_produtos` VALUES ('000001', 'MOUSE OPTICO MULTILASER', '1482547412854A', '1', '12/01/2017', '20', '5', 'Un', '9,00', '20,00', '180,00'), ('000002', 'TECLADO GAMER RAZER', '1325235136221B', '1', '12/01/2017', '19', '5', 'Un', '45,00', '61,50', '990,00'), ('000003', 'PENDRIVE 16GB MULTI COLORS MULTILASER', '1321626264747C', '2', '13/11/2017', '35', '5', 'Un', '10,00', '25,00', '400,00'), ('000004', 'WEBCAM LEADERSHIP FULHD 1080PX/4K', '1231553255261D', '1', '13/01/2017', '10', '5', 'Un', '60,00', '110,00', '600,00'), ('000005', 'TORNER HP LASERJET MULTIFUNCIONAL M1132 (REDE)', '123151152632E', '2', '14/01/2017', '18', '4', 'Un', '35,00', '60,00', '700,00'), ('000006', 'Placa Mãe 45gmx 45cmx 775 Ddr2 Core 2 Até 4gb', '', '2', '15/02/2017', '10', '0', 'Un', '100,00', '170,00', '1000,00'), ('000007', 'Placa De Vídeo 2gb Gt420 Ddr3 128 Bits Gigabyte', '', '1', '15/02/2017', '10', '2', 'Un', '150,00', '220,00', '1500,00'), ('000008', 'Case Gaveta Hd Sata Notebook Usb Externa Pc Xbox Ps3 Wii T2', '', '1', '15/02/2017', '50', '10', 'Un', '10,00', '25,00', '500,00'), ('000009', 'Fonte Atx 500w Reais Gamer Super Silenciosa Para Pc Bivolt', '', '1', '15/02/2017', '15', '2', 'Un', '80,00', '120,00', '1600,00'), ('000010', 'Drive Externo Slim Usb Gravador Leitor Cd Leitor Dvd Novo', '', '1', '15/02/2017', '8', '2', 'Un', '40,00', '80,00', '400,00');
COMMIT;

-- ----------------------------
-- Table structure for tbla_vendas
-- ----------------------------
DROP TABLE IF EXISTS `tbla_vendas`;
CREATE TABLE `tbla_vendas` (
`id_venda`  int(6) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT ,
`id_funcionario`  int(6) NOT NULL ,
`id_cliente`  int(6) NOT NULL ,
`id_forma_pag`  int(6) NULL DEFAULT 1 ,
`ini_venda`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`fim_venda`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`subtotal`  float(10,2) NULL DEFAULT NULL ,
`desconto`  float(10,0) NULL DEFAULT NULL ,
`valor_total`  float(10,2) NULL DEFAULT NULL ,
`status`  varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`tipo`  varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
PRIMARY KEY (`id_venda`)
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci
AUTO_INCREMENT=85

;

-- ----------------------------
-- Records of tbla_vendas
-- ----------------------------
BEGIN;
INSERT INTO `tbla_vendas` VALUES ('000022', '1', '1', '2', '13/01/2017 14:10', '13/01/2017 14:10', '81.50', '0', '81.50', 'Finalizada', 'A VISTA'), ('000023', '1', '1', '2', '13/01/2017 14:14', '13/01/2017 14:15', '206.00', '0', '206.00', 'Finalizada', 'A VISTA'), ('000024', '1', '1', '2', '13/01/2017 14:29', '13/01/2017 14:30', '20.00', '0', '20.00', 'Finalizada', 'A VISTA'), ('000025', '1', '1', '2', '13/01/2017 14:31', '13/01/2017 14:31', '20.00', '0', '20.00', 'Finalizada', 'A VISTA'), ('000061', '1', '1', '1', '14/01/2017 00:48', '14/01/2017 00:48', '125.00', '0', '0.00', 'Finalizada', 'A PRAZO'), ('000062', '1', '1', '1', '14/01/2017 00:51', '14/01/2017 00:52', '220.00', '0', '220.00', 'Finalizada', 'A PRAZO'), ('000063', '1', '1', '1', '14/01/2017 00:54', '14/01/2017 00:54', '125.00', '0', '125.00', 'Finalizada', 'A PRAZO'), ('000069', '1', '1', '2', '14/01/2017 01:27', '14/01/2017 01:27', '170.00', '0', '170.00', 'Finalizada', 'A PRAZO'), ('000070', '1', '1', '2', '19/01/2017 10:31', '19/01/2017 10:32', '111.50', '0', '111.50', 'Finalizada', 'A VISTA'), ('000072', '1', '1', '1', '19/01/2017 10:44', '19/01/2017 10:45', '110.00', '0', '120.00', 'Finalizada', 'A PRAZO'), ('000073', '1', '1', '2', '19/01/2017 11:04', '19/01/2017 11:04', '20.00', '0', '20.00', 'Finalizada', 'A VISTA'), ('000074', '1', '1', '2', '19/01/2017 11:06', '19/01/2017 11:06', '20.00', '0', '20.00', 'Finalizada', 'A VISTA'), ('000075', '1', '1', '2', '19/01/2017 11:09', '19/01/2017 11:09', '110.00', '0', '110.00', 'Finalizada', 'A VISTA'), ('000076', '1', '1', '2', '19/01/2017 11:13', '19/01/2017 11:13', '61.50', '0', '61.50', 'Finalizada', 'A VISTA'), ('000077', '1', '1', '2', '19/01/2017 11:30', '19/01/2017 11:30', '110.00', '0', '110.00', 'Finalizada', 'A VISTA'), ('000078', '1', '1', '2', '14/02/2017 11:35', '14/02/2017 11:36', '120.00', '0', '120.00', 'Finalizada', 'A VISTA'), ('000079', '1', '1', '2', '15/02/2017 11:10', '15/02/2017 11:10', '160.00', '16', '144.00', 'Finalizada', 'A VISTA'), ('000081', '1', '1', '1', '15/02/2017 11:20', '15/02/2017 11:22', '600.00', '0', '660.00', 'Finalizada', 'A PRAZO'), ('000082', '1', '1', '1', '15/02/2017 11:27', '15/02/2017 11:28', '125.00', '0', '125.00', 'Finalizada', 'A PRAZO'), ('000084', '1', '3', '1', '15/02/2017 17:40', '15/02/2017 17:40', '184.50', '0', '184.50', 'Finalizada', 'A PRAZO');
COMMIT;

-- ----------------------------
-- Auto increment value for tbla_caixas
-- ----------------------------
ALTER TABLE `tbla_caixas` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for tbla_clientes
-- ----------------------------
ALTER TABLE `tbla_clientes` AUTO_INCREMENT=4;

-- ----------------------------
-- Auto increment value for tbla_empresa
-- ----------------------------
ALTER TABLE `tbla_empresa` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for tbla_forma_pagamento
-- ----------------------------
ALTER TABLE `tbla_forma_pagamento` AUTO_INCREMENT=7;

-- ----------------------------
-- Auto increment value for tbla_fornecedores
-- ----------------------------
ALTER TABLE `tbla_fornecedores` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for tbla_funcionarios
-- ----------------------------
ALTER TABLE `tbla_funcionarios` AUTO_INCREMENT=3;

-- ----------------------------
-- Auto increment value for tbla_itens_vendas
-- ----------------------------
ALTER TABLE `tbla_itens_vendas` AUTO_INCREMENT=95;

-- ----------------------------
-- Auto increment value for tbla_parcelamento
-- ----------------------------
ALTER TABLE `tbla_parcelamento` AUTO_INCREMENT=28;

-- ----------------------------
-- Auto increment value for tbla_produtos
-- ----------------------------
ALTER TABLE `tbla_produtos` AUTO_INCREMENT=11;

-- ----------------------------
-- Auto increment value for tbla_vendas
-- ----------------------------
ALTER TABLE `tbla_vendas` AUTO_INCREMENT=85;
