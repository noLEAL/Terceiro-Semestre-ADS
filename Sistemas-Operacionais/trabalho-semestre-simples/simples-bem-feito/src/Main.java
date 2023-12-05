import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        List<Processo> processosPopulados = new ArrayList<>();
        int escolha = -1;

        //usar metodo para popular processos apenas uma unica vez
        if (escolha == -1){
            popularProcessos(processosPopulados);
            escolha++;
        }


        do {
            System.out.println("Escolha o algoritmo:");
            System.out.println(" 1=FCFS \n 2=SJF Preemptivo \n 3=SJF Não Preemptivo \n 4=Prioridade Preemptivo \n 5=Prioridade Não Preemptivo \n 6=Round Robin \n 7=Imprime lista de processos \n 8=Popular processos novamente \n 9=Sair");

            escolha = teclado.nextInt();

            switch (escolha) {
                case 1:
                    List<Processo> cloneFCFS = new ArrayList<>();
                    for (Processo processo : processosPopulados) {
                        cloneFCFS.add((Processo) processo.clone());
                    }
                    FCFS(cloneFCFS);
                    break;
                case 2:
                    List<Processo> cloneSJF = new ArrayList<>();
                    for (Processo processo : processosPopulados) {
                        cloneSJF.add((Processo) processo.clone());
                    }
                    SJF(cloneSJF, "P");
                    break;
                case 3:
                    cloneSJF = new ArrayList<>();
                    for (Processo processo : processosPopulados) {
                        cloneSJF.add((Processo) processo.clone());
                    }
                    SJF(cloneSJF, "N");
                    break;
                case 4:
                    List<Processo> clonePrioridade = new ArrayList<>();
                    for (Processo processo : processosPopulados) {
                        clonePrioridade.add((Processo) processo.clone());
                    }
                    Prioridade(clonePrioridade, "P");
                    break;
                case 5:
                    clonePrioridade = new ArrayList<>();
                    for (Processo processo : processosPopulados) {
                        clonePrioridade.add((Processo) processo.clone());
                    }
                    Prioridade(clonePrioridade, "N");
                    break;
                case 6:
                    List<Processo> cloneRR = new ArrayList<>();
                    for (Processo processo : processosPopulados) {
                        cloneRR.add((Processo) processo.clone());
                    }
                    roundRobin(cloneRR);
                    break;
                case 7:
                    imprime_processos(processosPopulados);
                    break;
                case 8:

                    //usar metodo para popular processos
                    popularProcessos(processosPopulados);

                    break;
                case 9:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (escolha != 9);

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
        System.out.println("Tempo médio de espera: " + (double) tempoEspera / processosFCFS.size());
    }

    public static void SJF(List<Processo> processosSJF, String preemp){

        processosSJF.sort(Comparator.comparing(Processo::getTempoDeExecucao));

        imprime_processos(processosSJF);
        int tempo = 0;
        int tempoEspera = 0;

        if (preemp.equalsIgnoreCase("P")){
            System.out.println("SJF Preemptivo");
            List<Processo> filaDeProntos = new ArrayList<>();
            List<Processo> cloneSJF = new ArrayList<>(processosSJF);

            while (!filaDeProntos.isEmpty() || !cloneSJF.isEmpty()) {
                if (!cloneSJF.isEmpty()) {
                    filaDeProntos.add(cloneSJF.get(0));
                    cloneSJF.remove(0);
                }

                if (!filaDeProntos.isEmpty()) {
                    for (int i = 0; i < filaDeProntos.size(); i++) {
                        //int tempoInicioExecucao = tempo;
                        for (int j = 0; j < filaDeProntos.get(i).getTempoDeExecucao(); j++) {
                            filaDeProntos.get(i).setTempoRestante(filaDeProntos.get(i).getTempoRestante()-1);
                            System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, filaDeProntos.get(i).getNome(), filaDeProntos.get(i).getTempoRestante());
                            tempo++;

                            tempoEspera =  tempoEspera + filaDeProntos.get(i).getTempoDeExecucao();

                            //Verifica se o processo atual tem o maior do que o tempo de execução de todos os outros processos na fila de prontos
                            for (int k = 0; k < filaDeProntos.size(); k++){

                                if (filaDeProntos.get(i).getTempoRestante() > filaDeProntos.get(k).getTempoDeExecucao()){
                                    filaDeProntos.add(k, filaDeProntos.get(i));
                                    if (i+1 < filaDeProntos.size()) {
                                        filaDeProntos.remove(i+1);
                                    }
                                    break;
                                }
                            }
                        }
                        if (filaDeProntos.get(i).getTempoRestante() == 0) {
                            filaDeProntos.remove(i);
                        }
                    }
                }
            }

            tempoEspera =  tempoEspera - processosSJF.get(0).getTempoDeExecucao();

        }else if (preemp.equalsIgnoreCase("N")) {

            System.out.println("SJF Não Preemptivo");
            List<Processo> filaDeProntosNP = new ArrayList<>();
            int indexMenorTempoChegada = 0;
            int menorTempoChegada = processosSJF.get(0).getTempoChegada();

            for (int i = 1; i < processosSJF.size(); i++) {
                if (processosSJF.get(i).getTempoChegada() < menorTempoChegada) {
                    menorTempoChegada = processosSJF.get(i).getTempoChegada();
                    indexMenorTempoChegada = i;
                }
            }

            filaDeProntosNP.add(processosSJF.get(indexMenorTempoChegada));

            for (int i = 0; i < processosSJF.size(); i++) {
                if (i != indexMenorTempoChegada) {
                    filaDeProntosNP.add(processosSJF.get(i));
                }
            }

            int somaTempoExecucao = 0;

            for (Processo processo : processosSJF) {
                somaTempoExecucao += processo.getTempoDeExecucao();
            }



            int totalProcessos = processosSJF.size();
            int processosCompletados = 0;

            while (processosCompletados < totalProcessos) {
                    int i = 0;
                    if (filaDeProntosNP.get(i).getTempoChegada() <= tempo){

                        for (int j = 0; j < filaDeProntosNP.get(i).getTempoDeExecucao(); j++) {
                            filaDeProntosNP.get(i).setTempoRestante(filaDeProntosNP.get(i).getTempoRestante()-1);
                            System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, filaDeProntosNP.get(i).getNome(), filaDeProntosNP.get(i).getTempoRestante());
                            tempo++;

                            tempoEspera = tempoEspera + filaDeProntosNP.get(i).getTempoDeExecucao();

                        }

                        if (filaDeProntosNP.get(i).getTempoRestante() == 0) {
                            processosCompletados++;
                        }

                        filaDeProntosNP.remove(i);

                        i++;
                    }else{
                        System.out.printf("TEMPO[%s] : Nenhum Processo Chegou \n", tempo);
                        tempo++;
                    }

            }


        }

        System.out.println("Tempo de espera: " + tempoEspera);
        System.out.println("Tempo médio de espera: " + (double) tempoEspera / processosSJF.size());

    }

    public static void Prioridade(List<Processo> processosPrioridade, String preemp){

        System.out.println("Prioridade");

        //Metodo de ordenação dos processos, utilizando o Prioridade dento do Comparator.comparing() . e o .sort() para ordenar o arraylist
        processosPrioridade.sort(Comparator.comparing(Processo::getPrioridade));

        imprime_processos(processosPrioridade);
        int tempo = 0;
        int tempoEspera = 0;

        if (preemp.equalsIgnoreCase("P")){
            System.out.println("Prioridade Preemptivo");
            List<Processo> filaDeProntosP = new ArrayList<>();
            List<Processo> clonePrioridade = new ArrayList<>(processosPrioridade);

            while (!filaDeProntosP.isEmpty() || !clonePrioridade.isEmpty()) {
                if (!clonePrioridade.isEmpty()) {
                    filaDeProntosP.add(clonePrioridade.get(0));
                    clonePrioridade.remove(0);
                }

                if (!filaDeProntosP.isEmpty()) {
                    for (int i = 0; i < filaDeProntosP.size(); i++) {
                        //int tempoInicioExecucao = tempo;
                        for (int j = 0; j < filaDeProntosP.get(i).getTempoDeExecucao(); j++) {
                            filaDeProntosP.get(i).setTempoRestante(filaDeProntosP.get(i).getTempoRestante()-1);
                            System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, filaDeProntosP.get(i).getNome(), filaDeProntosP.get(i).getTempoRestante());
                            tempo++;

                            tempoEspera =  tempoEspera + filaDeProntosP.get(i).getTempoDeExecucao();

                            //Verifica se o processo atual tem o maior do que o tempo de prioridade  de todos os outros processos na fila de prontos
                            for (int k = 0; k < filaDeProntosP.size(); k++){
                                if (filaDeProntosP.get(i).getPrioridade() > filaDeProntosP.get(k).getPrioridade()){
                                    filaDeProntosP.add(k, filaDeProntosP.get(i));
                                    if (i+1 < filaDeProntosP.size()) {
                                        filaDeProntosP.remove(i+1);
                                    }
                                    break;
                                }
                            }
                        }
                        if (filaDeProntosP.get(i).getTempoRestante() == 0) {
                            filaDeProntosP.remove(i);
                        }
                    }
                }
            }
            tempoEspera =  tempoEspera - processosPrioridade.get(0).getTempoDeExecucao();
        }else if (preemp.equalsIgnoreCase("N")){

            System.out.println("Prioridade Não Preemptivo");

            for (int i = 0; i < processosPrioridade.size(); i++) {

                for (int j = 0; j < processosPrioridade.get(i).getTempoDeExecucao(); j++) {

                    if (processosPrioridade.get(i) != processosPrioridade.get(0)) {
                        tempoEspera =  tempoEspera + processosPrioridade.get(i).getTempoDeExecucao();
                    }

                    processosPrioridade.get(i).setTempoRestante(processosPrioridade.get(i).getTempoRestante()-1);
                    System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processosPrioridade.get(i).getNome(), processosPrioridade.get(i).getTempoRestante());
                    tempo++;
                }
            }
       }

        System.out.println("Tempo de espera: " + tempoEspera);
        System.out.println("Tempo médio de espera: " + (double) tempoEspera / processosPrioridade.size());
    }

    public static void roundRobin(List<Processo> processosRR) {
        processosRR.sort(Comparator.comparing(Processo::getTempoChegada));

        int gambi = processosRR.size();

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o Time Slice: ");
        int timeslice = teclado.nextInt();
        int tempo = 0;

        int tempoEspera = 0;

        while (!processosRR.isEmpty()) {
            for (Processo processo : processosRR) {
                if (processo.getTempoRestante() > 0) {
                    if (processo.getTempoRestante() > timeslice) {
                        tempo += timeslice;
                        processo.setTempoRestante(processo.getTempoRestante() - timeslice);
                        tempoEspera += timeslice;
                    } else {
                        tempo += processo.getTempoRestante();
                        processo.setTempoRestante(0);
                        tempoEspera += processo.getTempoRestante();
                    }
                    System.out.println("Processo: " + processo.getNome() + " | Tempo de Execução: " + processo.getTempoDeExecucao() + " | Tempo Restante: " + processo.getTempoRestante() + " | Tempo de Chegada: " + processo.getTempoChegada() + " | Prioridade: " + processo.getPrioridade());
                }
            }

            processosRR.removeIf(processo -> processo.getTempoRestante() == 0);
        }

        System.out.println("Tempo de espera: " + tempoEspera);
        System.out.printf("Tempo médio de espera: %8.2f\n", (double) tempoEspera / gambi);

    }

    public static void imprime_processos(List<Processo> processosPopulados) {
        //Imprime lista de processos
        System.out.println("Lista de processos: ");
        for (Processo processo : processosPopulados) {
            System.out.println("Processo: " + processo.getNome() + " | Tempo de Execução: " + processo.getTempoDeExecucao() + " | Tempo Restante: " + processo.getTempoRestante() + " | Tempo de Chegada: " + processo.getTempoChegada() + " | Prioridade: " + processo.getPrioridade());
        }
    }

    public static void popularProcessos(List<Processo> processosPopulados){

        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite quantidade de processos: ");
        int qtdProcessos = teclado.nextInt();

        System.out.println("População Manual ou Randomica? (M/R)");
        String pop = teclado.next();

        processosPopulados.clear();


        Processo processo1 = new Processo(2, 5, 10, 4);
        Processo processo2 = new Processo(1, 7, 9, 4);
        Processo processo3 = new Processo(3, 10, 4, 7);

        // Adiciona os processos à lista
        processosPopulados.add(processo1);
        processosPopulados.add(processo2);
        processosPopulados.add(processo3);

//
//        if (pop.equalsIgnoreCase("M")){
//
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
//                processosPopulados.add(new Processo(i, tempoDeExecucao, tempoChegada, prioridade));
//
//            }
//
//        } else if (pop.equalsIgnoreCase("R")){
//
//            for (int i = 0; i < qtdProcessos; i++){
//
//                Random random = new Random();
//
//                processosPopulados.add(new Processo(i, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1));
//
//            }
//        }
        imprime_processos(processosPopulados);

    }



}