package com.conversor;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ConversorMetro {

    public static void converterComprimento() {
        String strValor = JOptionPane.showInputDialog("Insira um valor:");

        if (strValor != null && !strValor.isEmpty()) {
            try {
                double valor = Double.parseDouble(strValor);

                String[] opcoes = { "Metro para Quilômetro", "Metro para Milha", "Quilômetro para Metro",
                        "Quilômetro para Milha", "Milha para Metro", "Milha para Quilômetro" };

                String escolha = (String) JOptionPane.showInputDialog(null,
                        "Escolha uma opção de conversão de comprimento", "Conversor de Comprimento",
                        JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

                if (escolha != null) {
                    double valorConvertido = converter(valor, escolha);

                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    String valorFormatado = decimalFormat.format(valorConvertido);

                    JOptionPane.showMessageDialog(null,
                            "Valor convertido: " + valorFormatado + " " + obterUnidadeMedida(escolha));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Insira um valor numérico.");
            }
        }
    }

    public static double converter(double valor, String escolha) {
        double valorConvertido = 0.0;

        if (escolha.equals("Metro para Quilômetro")) {
            valorConvertido = valor / 1000;
        } else if (escolha.equals("Metro para Milha")) {
            valorConvertido = valor * 0.000621371;
        } else if (escolha.equals("Quilômetro para Metro")) {
            valorConvertido = valor * 1000;
        } else if (escolha.equals("Quilômetro para Milha")) {
            valorConvertido = valor * 0.621371;
        } else if (escolha.equals("Milha para Metro")) {
            valorConvertido = valor * 1609.34;
        } else if (escolha.equals("Milha para Quilômetro")) {
            valorConvertido = valor * 1.60934;
        }

        return valorConvertido;
    }

    public static String obterUnidadeMedida(String escolha) {
        String unidadeMedida = "";

        if (escolha.equals("Metro para Quilômetro")) {
            unidadeMedida = "km";
        } else if (escolha.equals("Metro para Milha")) {
            unidadeMedida = "mi";
        } else if (escolha.equals("Quilômetro para Metro")) {
            unidadeMedida = "m";
        } else if (escolha.equals("Quilômetro para Milha")) {
            unidadeMedida = "mi";
        } else if (escolha.equals("Milha para Metro")) {
            unidadeMedida = "m";
        } else if (escolha.equals("Milha para Quilômetro")) {
            unidadeMedida = "km";
        }

        return unidadeMedida;
    }
}

