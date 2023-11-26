import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite quantidade de processos: ");
        int qtdProcessos = teclado.nextInt();

        qtdProcessos = 3; //<<<<----------------- APAGAR ESSA LINHA

        System.out.println("População Manual ou Randomica? (M/R)");
        String pop = teclado.next();

        pop = "M"; //<<<<----------------- APAGAR ESSA LINHA

        List<Processo> processosPopulados = new ArrayList<Processo>();

        if (pop.equalsIgnoreCase("M")){

//            for (int i = 0; i < qtdProcessos; i++){
//
//                System.out.println("Digite o tempo de execução do processo " + i + ": ");
//                int tempoDeExecucao = teclado.nextInt();
//
//                System.out.println("Digite o tempo de chegada do processo " + i + ": ");
//                int tempoChegada = teclado.nextInt();
//
//                System.out.println("Digite a prioridade do processo " + i + ": ");
//                int prioridade = teclado.nextInt();
//
//                processosPopulados.add(new Processo(tempoDeExecucao, tempoChegada, prioridade));
//
//            }
            processosPopulados.add(new Processo(10, 3, 9)); //<<<<----------------- APAGAR ESSA LINHA
            processosPopulados.add(new Processo(7, 7, 7)); //<<<<----------------- APAGAR ESSA LINHA
            processosPopulados.add(new Processo(3, 2, 15)); //<<<<----------------- APAGAR ESSA LINHA


        } else if (pop.equalsIgnoreCase("R")){

            for (int i = 0; i < qtdProcessos; i++){

                Random random = new Random();

                processosPopulados.add(new Processo(random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1));

            }
        }

        imprime_processos(processosPopulados);

        System.out.println("Preemptivo ou não preemptivo? (P/N)");
        String preemp = teclado.next();

        //FCFS(processosPopulados);
        SJF(processosPopulados, preemp);


    }

    public static void FCFS(List<Processo> processosFCFS){

        System.out.println("FCFS");

        //Metodo de ordenação dos processos, utilizando o tempo de chegada dento do Comparator.comparing() . e o .sort() para ordenar o arraylist
        processosFCFS.sort(Comparator.comparing(Processo::getTempoChegada));

        imprime_processos(processosFCFS);
        int tempo = 0;
        int tempoEspera = 0;

        for (int i = 0; i < processosFCFS.size(); i++) {

            if (processosFCFS.get(i) != processosFCFS.get(0)) {
                tempoEspera =  tempoEspera + processosFCFS.get(i).getTempoDeExecucao();
            }

            for (int j = 0; j < processosFCFS.get(i).getTempoDeExecucao(); j++) {
                processosFCFS.get(i).setTempoRestante(processosFCFS.get(i).getTempoRestante()-1);
                System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processosFCFS.get(i).getNome(), processosFCFS.get(i).getTempoRestante());
                tempo++;
            }
        }

        System.out.println("Tempo de espera: " + tempoEspera);
        System.out.println("Tempo médio de espera: " + tempoEspera/processosFCFS.size());
    }

    public static void SJF(List<Processo> processosSJF, String preemp){

        //Metodo de ordenação dos processos, utilizando de Execusao dento do Comparator.comparing() . e o .sort() para ordenar o arraylist
        processosSJF.sort(Comparator.comparing(Processo::getTempoDeExecucao));

        imprime_processos(processosSJF);

        if (preemp.equalsIgnoreCase("P")){
            System.out.println("SJF Preemptivo");
            List<Processo> filaDeProntos = new ArrayList<>();
            int tempo = 0;


            while (!filaDeProntos.isEmpty() || !processosSJF.isEmpty()) {

                for (int i = 0; i < processosSJF.size(); i++) {
                    filaDeProntos.add(processosSJF.get(i));
                    processosSJF.remove(i);
                }

                if (filaDeProntos.size() > 0) {
                    for (int i = 0; i < filaDeProntos.size(); i++) {
                        for (int j = 0; j < filaDeProntos.get(i).getTempoDeExecucao(); j++) {
                            filaDeProntos.get(i).setTempoRestante(filaDeProntos.get(i).getTempoRestante()-1);
                            System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, filaDeProntos.get(i).getNome(), filaDeProntos.get(i).getTempoRestante());
                            tempo++;

                            //Verifica se o processo atual tem o tempo restante maior do que o tempo de execução de todos os outros processos na fila de prontos
                            for (int k = 0; k < filaDeProntos.size(); k++){
                                if (filaDeProntos.get(i).getTempoRestante() > filaDeProntos.get(k).getTempoDeExecucao()){

                                    filaDeProntos.add(k, filaDeProntos.get(i));
                                    if (i+1 < filaDeProntos.size()) {
                                        filaDeProntos.remove(i+1);
                                    }

                                }
                            }
                        }
                        if (filaDeProntos.get(i).getTempoRestante() == 0) {
                            filaDeProntos.remove(i);
                        }
                    }
                }
            }


//            for (int i = 0; i < processosSJF.size(); i++) {
//
//                for (int j = 0; j < processosSJF.get(i).getTempoDeExecucao(); j++) {
//                    processosSJF.get(i).setTempoRestante(processosSJF.get(i).getTempoRestante()-1);
//                    System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processosSJF.get(i).getNome(), processosSJF.get(i).getTempoRestante());
//                    for (int k = 0; k < processosSJF.size(); k++){
//                        if (processosSJF.get(i).getTempoRestante() > processosSJF.get(k).getTempoDeExecucao()){
//                            processosSJF.add(k, processosSJF.get(i));
//                            if (i+1 < processosSJF.size()) {
//                                processosSJF.remove(i+1);
//                            }
//                        }
//                    }
//                    tempo++;
//                }
//
//            }

        }else if (preemp.equalsIgnoreCase("N")){

            System.out.println("SJF Não Preemptivo");
            int tempo = 0;

            for (int i = 0; i < processosSJF.size(); i++) {

                for (int j = 0; j < processosSJF.get(i).getTempoDeExecucao(); j++) {
                    processosSJF.get(i).setTempoRestante(processosSJF.get(i).getTempoRestante()-1);
                    System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processosSJF.get(i).getNome(), processosSJF.get(i).getTempoRestante());
                    tempo++;
                }
            }

        }
        System.out.println("Fim do SJF");

    }



    public static void imprime_processos(List<Processo> processosPopulados) {
        //Imprime lista de processos
        System.out.println("Lista de processos: ");
        for (Processo processo : processosPopulados) {
            System.out.println("Processo: " + processo.getNome() + " | Tempo de Execução: " + processo.getTempoDeExecucao() + " | Tempo Restante: " + processo.getTempoRestante() + " | Tempo de Chegada: " + processo.getTempoChegada() + " | Prioridade: " + processo.getPrioridade());
        }
    }

    public static void imprime_stats () {



    }


}