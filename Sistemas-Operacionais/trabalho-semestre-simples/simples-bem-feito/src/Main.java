import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite quantidade de processos: ");
        int qtdProcessos = teclado.nextInt();

        System.out.println("População Manual ou Randomica? (M/R)");
        String pop = teclado.next();

        List<Processo> processosPopulados = new ArrayList<Processo>();

        if (pop.equalsIgnoreCase("M")){

            for (int i = 0; i < qtdProcessos; i++){

                System.out.println("Digite o tempo de execução do processo " + i + ": ");
                int tempoDeExecucao = teclado.nextInt();

                System.out.println("Digite o tempo de chegada do processo " + i + ": ");
                int tempoChegada = teclado.nextInt();

                System.out.println("Digite a prioridade do processo " + i + ": ");
                int prioridade = teclado.nextInt();

                processosPopulados.add(new Processo(tempoDeExecucao, tempoChegada, prioridade));

            }

        } else if (pop.equalsIgnoreCase("R")){

            for (int i = 0; i < qtdProcessos; i++){

                Random random = new Random();

                processosPopulados.add(new Processo(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1));

            }
        }

        imprime_processos(processosPopulados);

        FCFS(processosPopulados);

    }

    public static void FCFS(List<Processo> processosFCFS){

        //Metodo de ordenação dos processos, utilizando o tempo de chegada dento do Comparator.comparing() . e o .sort() para ordenar o arraylist
        processosFCFS.sort(Comparator.comparing(Processo::getTempoChegada));

        imprime_processos(processosFCFS);
        int tempo = 0;
        for (int i = 0; i < processosFCFS.size(); i++) {

            for (int j = 0; j < processosFCFS.get(i).getTempoDeExecucao(); j++) {
                System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processosFCFS.get(i).getNome(), processosFCFS.get(i).getTempoRestante());
                tempo++;
                processosFCFS.get(i).setTempoRestante(processosFCFS.get(i).getTempoRestante()-1);
            }
//            System.out.printf("TEMPO[%s] : processo[%s] restante=%s", tempo, processosFCFS.get(i).getNome(), processosFCFS.get(i).getTempoRestante());
//            tempo++;

        }
    }

    public static void SJF(List<Processo> processosSJF){
        //Metodo de ordenação dos processos, utilizando o tempo de chegada dento do Comparator.comparing() . e o .sort() para ordenar o arraylist
        processosSJF.sort(Comparator.comparing(Processo::getTempoChegada));



    }



    public static void imprime_processos(List<Processo> processosPopulados) {
        //Imprime lista de processos
        System.out.println("Lista de processos: ");
        for (Processo processo : processosPopulados) {
            System.out.println("Processo: " + processo.getNome() + " | Tempo de Execução: " + processo.getTempoDeExecucao() + " | Tempo Restante: " + processo.getTempoRestante() + " | Tempo de Chegada: " + processo.getTempoChegada() + " | Prioridade: " + processo.getPrioridade());
        }
    }
}