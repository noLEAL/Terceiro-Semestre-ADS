package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;


public class Main {
    private static Path src;

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Inicio do Programa");

        String entryDirectory = "C:\\Users\\Cliente\\Documents\\GitHub\\Terceiro-Semestre-ADS\\Sistemas-Operacionais\\trabalho-semestre\\main\\src\\main\\java\\org\\example\\input.txt";

        int opition;

        try {

            String grossInput = new String(Files.readAllBytes(Path.of(entryDirectory)));

            System.out.println(grossInput);

            String[] partes = grossInput.split(";");

            for (String parte : partes) {

            }


        }catch (IOException input_error){

            input_error.printStackTrace();

        }

        Scanner key = new Scanner(System.in);
        
        while (true) {

            opition = key.nextInt();
            
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


            switch (opition) {
                case 1 -> {
                    System.out.println("FCFS");


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

                default -> throw new IllegalStateException("Valor invalido: " + opition);
            }
        }
    }
}