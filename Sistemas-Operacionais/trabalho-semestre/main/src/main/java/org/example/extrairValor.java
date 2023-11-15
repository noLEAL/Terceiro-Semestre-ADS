package org.example;

public class extrairValor {


    public static String processo(String input) {
        int startIndex = input.indexOf("[") + 1;
        int endIndex = input.lastIndexOf("]");
        return input.substring(startIndex, endIndex);
    }

    public static String tempoExecucao(String input) {
        int startIndex = input.indexOf("´") + 1;
        int endIndex = input.lastIndexOf("´");
        return input.substring(startIndex, endIndex);
    }

    public static String tempoRestante(String input) {
        int startIndex = input.indexOf("(") + 1;
        int endIndex = input.lastIndexOf(")");
        return input.substring(startIndex, endIndex);

    }

    public static String tempoChegada(String input) {
        int startIndex = input.indexOf("(") + 1;
        int endIndex = input.lastIndexOf(")");
        return input.substring(startIndex, endIndex);
    }

    public static String prioridade (String input) {
        int startIndex = input.indexOf("(") + 1;
        int endIndex = input.lastIndexOf(")");
        return input.substring(startIndex, endIndex);
    }
}
