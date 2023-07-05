package com.conversor;

import javax.swing.JOptionPane;

public class Main {

    private static String[] opcao = { "Conversor de Moeda", "Conversor de Temperatura", "Conversor de Unidades de Comprimento" };

    public static void main(String[] args) {
        exibirMenu();
    }

    private static void exibirMenu() {
        int opcaoSelecionada;
        do {
            String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção", "Menu",
                    JOptionPane.PLAIN_MESSAGE, null, opcao, opcao[0]);

            if (escolha != null) {
                switch (escolha) {
                    case "Conversor de Moeda":
                        ConversorMoedas.converterMoeda();
                        break;
                    case "Conversor de Temperatura":
                        ConversorTemperatura.converterTemperatura();
                        break;
                    case "Conversor de Unidades de Comprimento":
                        ConversorMetro.converterComprimento();
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            }

            opcaoSelecionada = exibirCaixaDialogoContinuar();
            if (opcaoSelecionada == JOptionPane.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(null, "Programa concluído.");
                System.exit(0);
            } else if (opcaoSelecionada == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "Programa finalizado.");
            }
        } while (opcaoSelecionada == JOptionPane.YES_OPTION);
    }

    private static int exibirCaixaDialogoContinuar() {
        String[] opcoes = { "Sim", "Não", "Cancelar" };
        return JOptionPane.showOptionDialog(null, "Deseja continuar?", "Continuar",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);
    }
}
