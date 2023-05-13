/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Alexandre
 */
public class ControleArquivos {

    public ArrayList retornaListaLinhas(String caminho) {

        File arquivo = new File(caminho);
        ArrayList lista = new ArrayList();

        if (arquivo.exists()) {
            try {
                try (BufferedReader buff = new BufferedReader(new FileReader(arquivo))) {
                    do {
                        lista.add(buff.readLine());
                    } while (buff.ready());
                }

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "ERRO 1 ao ler arquivo \n" + ex, "AVISO", JOptionPane.OK_OPTION);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERRO 2 ao ler arquivo \n" + ex, "AVISO", JOptionPane.OK_OPTION);
            }
        } else {
            JOptionPane.showMessageDialog(null, "ARQUIVO " + caminho + " \nNÃO ENCONTRADO, VERIFIQUE");
        }

        return lista;

    }

}
