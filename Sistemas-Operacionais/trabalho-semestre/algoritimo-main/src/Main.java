package org.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Main {
    //private static Path src;
    public static void main(String[] args) throws Exception{
        System.out.println("Inicio do Programa");

        Scanner key = new Scanner(System.in);

        String entryDirectory = "C:\\Users\\Cliente\\Documents\\GitHub\\Terceiro-Semestre-ADS\\Sistemas-Operacionais\\trabalho-semestre\\main\\src\\main\\java\\org\\example\\input.txt";

        int opition;

        String grossInput = new String(Files.readAllBytes(Path.of(entryDirectory)));

        System.out.println(grossInput);

        String[] parts = grossInput.split(";");
        String[] processo = new String[parts.length];
        String[] tempoExecucao = new String[parts.length];
        String[] tempoRestante = new String[parts.length];
        String[] tempoChegada = new String[parts.length];
        //String[] Prioridade = new String[parts.length];

        //System.out.println("processo");
        for (int i = 0; i < parts.length; i++) {
            // Extrai o valor entre [ e ] de cada parte
            processo[i] = extrairValor.processo(parts[i]);
            //System.out.println("indice:" + i + " linha:" + parts[i] + " valor:" + processo[i]);
        }

        //System.out.println("tempoExecucao");
        for (int i = 0; i < parts.length; i++) {
            // Extrai o valor entre ´ e ´ de cada parte
            tempoExecucao[i] = extrairValor.tempoExecucao(parts[i]);
            //System.out.println("indice:" + i + " linha:" + parts[i] + " valor:" + tempoExecucao[i]);
        }

        //System.out.println("tempoRestante");
        for (int i = 0; i < parts.length; i++) {
            // Extrai o valor entre ´ e ´ de cada parte
            tempoRestante[i] = extrairValor.tempoRestante(parts[i]);
            //System.out.println("indice:" + i + " linha:" + parts[i] + " valor:" + tempoRestante[i]);
        }

        for (int i = 0; i < parts.length; i++){

            System.out.printf("Processo: %s, Tempo de Execução: %s, Tempo Restante: %s \n", processo[i], tempoExecucao[i], tempoRestante[i]);
        }

        while (true) {
            System.out.println("=".repeat(100));

            System.out.println("Escolha qual metodo de escalonamento que deseja usar ");

            System.out.println("(1)FCFS");
            System.out.println("(2)SJF Não-Preemptivo");
            System.out.println("(3)SJF Preemptivo");
            System.out.println("(4)Prioridade Não-Preemptivo");
            System.out.println("(5)Prioridade Preemptivo");
            System.out.println("(6)Round-Robin");

            System.out.println("(0) Encerrar atividades");


            System.out.println("=".repeat(100));

            System.out.println("Digite o numero correspondente ao metodo de escalonamento que deseja usar: ");
            opition = key.nextInt();



            switch (opition) {
                case 1 -> {
                    System.out.println("Inicio FCFS");

                    int contEspera = 0;
                    int contProcesso = 0;
                    int tempo = 0;
                    int restante = 0;
                    int flag = 0;

                    for (int i = 0; i < parts.length; i++){

                        //System.out.printf("Processo: %s, Tempo de Execução: %s, Tempo Restante: %s \n", processo[i], tempoExecucao[i], tempoRestante[i]);
                        restante = Integer.parseInt(tempoRestante[i]);

                        //precisso testar as o tempó de chegada antes de executar o processo

                        for (int j = 0; j < Integer.parseInt(tempoExecucao[i]); j++){

                            System.out.printf("Tempo[%s] : Processo[%s] : Tempo Restante[%s]\n", tempo, processo[i], restante);
                            tempo++;
                            restante--;


                        }
                    }

                    System.out.println("Fim do FCFS");
                }
                case 2 -> {
                    System.out.println("SJF Não-Preemptivo");

                }
                case 3 -> {
                    System.out.println("SJF Preemptivo");

                }
                case 4 -> {
                    System.out.println("Prioridade Não-Preemptivo");

                }
                case 5 -> {
                    System.out.println("Prioridade Preemptivo");

                }
                case 6 -> {
                    System.out.println("Round-Robin");

                }
                case 7 -> {
                    System.out.println("Encerrando atividades");
                    System.exit(0);

                }
                default ->
                    throw new IllegalStateException("Valor invalido: " + opition);
            }
        }
    }
}