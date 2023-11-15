

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    //private static Path src;
    public static void main(String[] args) throws Exception{
        System.out.println("Inicio do Programa");

        Scanner key = new Scanner(System.in);

        String entryDirectory = "C:\\Users\\Cliente\\Documents\\GitHub\\Terceiro-Semestre-ADS\\Sistemas-Operacionais\\trabalho-semestre\\algoritimo-main\\src\\input.txt";

        int opition;

        String grossInput = new String(Files.readAllBytes(Path.of(entryDirectory)));

        System.out.println(grossInput);

        String[] parts = grossInput.split(";");
        //String[] processo = new String[parts.length];
        ArrayList<String> processo = new ArrayList<>();
        ArrayList<String> tempoExecucao = new ArrayList<>();
        ArrayList<String> tempoRestante = new ArrayList<>();
        ArrayList<String> tempoChegada = new ArrayList<>();
        ArrayList<String> prioridade = new ArrayList<>();

        for (int i = 0; i < parts.length; i++) {
            processo.add(Extrairvalor.processo(parts[i]));
            tempoExecucao.add(Extrairvalor.tempoExecucao(parts[i]));
            tempoRestante.add(Extrairvalor.tempoRestante(parts[i]));
            tempoChegada.add(Extrairvalor.tempoChegada(parts[i]));
            prioridade.add(Extrairvalor.prioridade(parts[i]));

        }

        for (int i = 0; i < parts.length; i++){

            System.out.printf("Processo: %s, Tempo de Execução: %s, Tempo Restante: %s, Tempo Chegada: %s, Prioridade: %s \n", processo.get(i), tempoExecucao.get(i), tempoRestante.get(i), tempoChegada.get(i), prioridade.get(i));

        }

        Ordenar testOrder = new Ordenar();
        Ordenar.semPrioridade(processo, tempoChegada);

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

                    for (int i = 0; i < parts.length; i++){

                        System.out.printf("Processo: %s, Tempo de Chegada: %s, Tempo Restante: %s \n", processo[i], tempoChegada[i]);

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