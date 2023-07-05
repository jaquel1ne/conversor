package com.conversor;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ConversorMoedas {
	
    public static void converterMoeda() {
        String strValor = JOptionPane.showInputDialog("Insira um valor:");

        if (strValor != null && !strValor.isEmpty()) {
            try {
                double valor = Double.parseDouble(strValor);

                String[] opcoes = { "Converter de Reais para Dólar", "Converter de Reais para Euro",
                        "Converter de Reais para Libras Esterlinas", "Converter de Reais para Peso Argentino",
                        "Converter de Reais para Peso Chileno", "Converter de Dólar para Reais",
                        "Converter de Euro para Reais", "Converter de Libras Esterlinas para Reais",
                        "Converter de Peso Argentino para Reais", "Converter de Peso Chileno para Reais" };

                String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção de conversão de moeda",
                        "Conversor de Moeda", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

                if (escolha != null) {
                    double taxaDeCambio = obterTaxaDeCambio(escolha);
                    double resultado = valor * taxaDeCambio;

                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    String resultadoFormatado = decimalFormat.format(resultado);

                    JOptionPane.showMessageDialog(null, "Resultado da conversão: " + resultadoFormatado);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Insira um valor numérico.");
            }
        }
    }

    public static double obterTaxaDeCambio(String escolha) {
        double taxaDeCambio = 0.0;

        if (escolha.equals("Converter de Reais para Dólar")) {
            taxaDeCambio = 0.2080906;
        } else if (escolha.equals("Converter de Reais para Euro")) {
            taxaDeCambio = 0.1908725;
        } else if (escolha.equals("Converter de Reais para Libras Esterlinas")) {
            taxaDeCambio = 0.1634388;
        } else if (escolha.equals("Converter de Reais para Peso Argentino")) {
            taxaDeCambio = 53.8793103;
        } else if (escolha.equals("Converter de Reais para Peso Chileno")) {
            taxaDeCambio = 167.7275439;
        } else if (escolha.equals("Converter de Dólar para Reais")) {
            taxaDeCambio = 4.805;
        } else if (escolha.equals("Converter de Euro para Reais")) {
            taxaDeCambio = 5.2379;
        } else if (escolha.equals("Converter de Libras Esterlinas para Reais")) {
            taxaDeCambio = 6.1168;
        } else if (escolha.equals("Converter de Peso Argentino para Reais")) {
            taxaDeCambio = 0.01855;
        } else if (escolha.equals("Converter de Peso Chileno para Reais")) {
            taxaDeCambio = 0.00603;
        }

        return taxaDeCambio;
    }
}
