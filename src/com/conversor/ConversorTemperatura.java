package com.conversor;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ConversorTemperatura {

    public static void converterTemperatura() {
        String strValor = JOptionPane.showInputDialog("Insira uma temperatura:");

        if (strValor != null && !strValor.isEmpty()) {
            try {
                double temperatura = Double.parseDouble(strValor);

                String[] opcoes = { "Celsius para Fahrenheit", "Celsius para Kelvin", "Fahrenheit para Celsius",
                        "Fahrenheit para Kelvin", "Kelvin para Celsius", "Kelvin para Fahrenheit" };

                String escolha = (String) JOptionPane.showInputDialog(null,
                        "Escolha uma opção de conversão de temperatura", "Conversor de Temperatura",
                        JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

                if (escolha != null) {
                    double temperaturaConvertida = converter(temperatura, escolha);

                    DecimalFormat decimalFormat = new DecimalFormat("#0.00");
                    String temperaturaFormatada = decimalFormat.format(temperaturaConvertida);

                    JOptionPane.showMessageDialog(null,
                            "Temperatura convertida: " + temperaturaFormatada + " " + obterUnidadeMedida(escolha));
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido. Insira uma temperatura numérica.");
            }
        }
    }

    public static double converter(double temperatura, String escolha) {
        double temperaturaConvertida = 0.0;

        if (escolha.equals("Celsius para Fahrenheit")) {
            temperaturaConvertida = (temperatura * 9 / 5) + 32;
        } else if (escolha.equals("Celsius para Kelvin")) {
            temperaturaConvertida = temperatura + 273.15;
        } else if (escolha.equals("Fahrenheit para Celsius")) {
            temperaturaConvertida = (temperatura - 32) * 5 / 9;
        } else if (escolha.equals("Fahrenheit para Kelvin")) {
            temperaturaConvertida = (temperatura + 459.67) * 5 / 9;
        } else if (escolha.equals("Kelvin para Celsius")) {
            temperaturaConvertida = temperatura - 273.15;
        } else if (escolha.equals("Kelvin para Fahrenheit")) {
            temperaturaConvertida = (temperatura * 9 / 5) - 459.67;
        }

        return temperaturaConvertida;
    }

    public static String obterUnidadeMedida(String escolha) {
        String unidadeMedida = "";

        if (escolha.equals("Celsius para Fahrenheit")) {
            unidadeMedida = "°F";
        } else if (escolha.equals("Celsius para Kelvin")) {
            unidadeMedida = "K";
        } else if (escolha.equals("Fahrenheit para Celsius")) {
            unidadeMedida = "°C";
        } else if (escolha.equals("Fahrenheit para Kelvin")) {
            unidadeMedida = "K";
        } else if (escolha.equals("Kelvin para Celsius")) {
            unidadeMedida = "°C";
        } else if (escolha.equals("Kelvin para Fahrenheit")) {
            unidadeMedida = "°F";
        }

        return unidadeMedida;
    }
}

