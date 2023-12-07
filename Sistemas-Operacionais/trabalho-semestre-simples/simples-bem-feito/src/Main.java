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

        processosSJF.sort(Comparator.comparing(Processo::getTempoChegada));

        imprime_processos(processosSJF);
        int totalProcessos =  processosSJF.size();
        int tempo = 0;
        int tempoEspera = 0;
        int totalTempoEspera = 0;

        if (preemp.equalsIgnoreCase("P")){

            System.out.println("SJF Preemptivo");

            List<Processo> filaDeProntosP = new ArrayList<>();

            int processosCompletados = 0;
            int tempoDeExecucaoAtual = 0;
            Processo processoAtual = null;

            do{
                for (int i = processosSJF.size() - 1; i >= 0; i--) {
                    if (processosSJF.get(i).getTempoChegada() <= tempo) {
                        filaDeProntosP.add(processosSJF.get(i));
                        processosSJF.remove(i);
                    }
                }

                if (!filaDeProntosP.isEmpty()){
                    filaDeProntosP.sort(Comparator.comparing(Processo::getTempoDeExecucao));
                    if (processoAtual == null || processoAtual.getTempoRestante() > filaDeProntosP.get(0).getTempoDeExecucao()) {
                        if (processoAtual != null) {
                            filaDeProntosP.add(processoAtual);
                        }
                        processoAtual = filaDeProntosP.get(0);
                        filaDeProntosP.remove(0);
                        tempoDeExecucaoAtual = 0;
                    }

                    processoAtual.setTempoRestante(processoAtual.getTempoRestante()-1);
                    System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processoAtual.getNome(), processoAtual.getTempoRestante());
                    tempo++;
                    tempoDeExecucaoAtual++;

                    if (processoAtual.getTempoRestante() == 0){
                        tempoEspera = tempo - tempoDeExecucaoAtual - processoAtual.getTempoChegada();
                        totalTempoEspera += tempoEspera;
                        processoAtual = null;
                        processosCompletados++;
                    }
                } else {
                    tempoEspera++;
                    System.out.printf("TEMPO[%s] : Nenhum Processo Chegou \n", tempo);
                    tempo++;
                }

            }while (processosCompletados < totalProcessos);



        }else if (preemp.equalsIgnoreCase("N")) {

            System.out.println("SJF Não Preemptivo");

            List<Processo> filaDeProntosNP = new ArrayList<>();

            int processosCompletados = 0;

            do{

                for (int i = processosSJF.size() - 1; i >= 0; i--) {
                    if (processosSJF.get(i).getTempoChegada() <= tempo) {
                        filaDeProntosNP.add(processosSJF.get(i));
                        processosSJF.remove(i);
                    }
                }

                if (filaDeProntosNP.isEmpty()){
                    tempoEspera++;
                    System.out.printf("TEMPO[%s] : Nenhum Processo Chegou \n", tempo);
                    tempo++;

                }else{
                    filaDeProntosNP.sort(Comparator.comparing(Processo::getTempoDeExecucao));

                    int tempoInicio = 0;
                    tempoInicio = tempo;

                    for (int j = 0; j < filaDeProntosNP.get(0).getTempoDeExecucao(); j++) {

                        filaDeProntosNP.get(0).setTempoRestante(filaDeProntosNP.get(0).getTempoRestante()-1);
                        System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, filaDeProntosNP.get(0).getNome(), filaDeProntosNP.get(0).getTempoRestante());
                        tempo++;

                        if (filaDeProntosNP.get(0).getTempoRestante() == 0){

                            tempoEspera = tempoInicio - filaDeProntosNP.get(0).getTempoChegada();
                            totalTempoEspera += tempoEspera;

                            filaDeProntosNP.remove(0);
                            break;
                        }
                    }

                    processosCompletados++;
                }

            }while (processosCompletados < totalProcessos);
        }

        System.out.println("totalTempoEspera:" + totalTempoEspera);
        System.out.println("Tempo de Espera:" + (double) totalTempoEspera/totalProcessos);

    }

    public static void Prioridade(List<Processo> processosPrioridade, String preemp){

        //Metodo de ordenação dos processos, utilizando o Prioridade dento do Comparator.comparing() . e o .sort() para ordenar o arraylist
        processosPrioridade.sort(Comparator.comparing(Processo::getTempoChegada));

        imprime_processos(processosPrioridade);
        int totalProcessos =  processosPrioridade.size();
        int tempo = 0;
        int tempoEspera = 0;
        int totalTempoEspera = 0;

        if (preemp.equalsIgnoreCase("P")){

            System.out.println("Prioridade Preemptivo");

            List<Processo> filaDeProntosP = new ArrayList<>();

            int processosCompletados = 0;
            int tempoDeExecucaoAtual = 0;
            Processo processoAtual = null;

            do{

                for (int i = processosPrioridade.size() - 1; i >= 0; i--) {
                    if (processosPrioridade.get(i).getTempoChegada() <= tempo) {
                        filaDeProntosP.add(processosPrioridade.get(i));
                        processosPrioridade.remove(i);
                    }
                }

                if (!filaDeProntosP.isEmpty()){
                    filaDeProntosP.sort(Comparator.comparing(Processo::getPrioridade));
                    if (processoAtual == null || processoAtual.getTempoRestante() > filaDeProntosP.get(0).getTempoDeExecucao()) {
                        if (processoAtual != null) {
                            filaDeProntosP.add(processoAtual);
                        }
                        processoAtual = filaDeProntosP.get(0);
                        filaDeProntosP.remove(0);
                        tempoDeExecucaoAtual = 0;
                    }

                    processoAtual.setTempoRestante(processoAtual.getTempoRestante()-1);
                    System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processoAtual.getNome(), processoAtual.getTempoRestante());
                    tempo++;
                    tempoDeExecucaoAtual++;

                    if (processoAtual.getTempoRestante() == 0){
                        tempoEspera = tempo - tempoDeExecucaoAtual - processoAtual.getTempoChegada();
                        totalTempoEspera += tempoEspera;
                        processoAtual = null;
                        processosCompletados++;
                    }
                } else {
                    tempoEspera++;
                    System.out.printf("TEMPO[%s] : Nenhum Processo Chegou \n", tempo);
                    tempo++;
                }

            }while (processosCompletados < totalProcessos);


        }else if (preemp.equalsIgnoreCase("N")){

            System.out.println("Prioridade Não Preemptivo");

            List<Processo> filaDeProntosNP = new ArrayList<>();

            int processosCompletados = 0;

            do{
                for (int i = processosPrioridade.size() - 1; i >= 0; i--) {
                    if (processosPrioridade.get(i).getTempoChegada() <= tempo) {
                        filaDeProntosNP.add(processosPrioridade.get(i));
                        processosPrioridade.remove(i);
                    }
                }

                if (filaDeProntosNP.isEmpty()){
                    tempoEspera++;
                    System.out.printf("TEMPO[%s] : Nenhum Processo Chegou \n", tempo);
                    tempo++;

                }else{
                    filaDeProntosNP.sort(Comparator.comparing(Processo::getTempoDeExecucao));

                    int tempoInicio = 0;
                    tempoInicio = tempo;

                    for (int j = 0; j < filaDeProntosNP.get(0).getTempoDeExecucao(); j++) {

                        filaDeProntosNP.get(0).setTempoRestante(filaDeProntosNP.get(0).getTempoRestante()-1);
                        System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, filaDeProntosNP.get(0).getNome(), filaDeProntosNP.get(0).getTempoRestante());
                        tempo++;

                        if (filaDeProntosNP.get(0).getTempoRestante() == 0){

                            tempoEspera = tempoInicio - filaDeProntosNP.get(0).getTempoChegada();
                            totalTempoEspera += tempoEspera;

                            filaDeProntosNP.remove(0);
                            break;
                        }
                    }

                    processosCompletados++;
                }

            }while (processosCompletados < totalProcessos);

       }

        System.out.println("totalTempoEspera:" + totalTempoEspera);
        System.out.println("Tempo de Espera:" + (double) totalTempoEspera/totalProcessos);
    }

    public static void roundRobin(List<Processo> processosRR) {

        imprime_processos(processosRR);

        System.out.println("Round Robin");

        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o Time Slice: ");
        int timeslice = teclado.nextInt();

        int tempo = 0;
        int totalProcessos = processosRR.size();
        int totalTempoEspera = 0;

        boolean fim = true;

        while (fim){

            for (int i = 0; i < processosRR.size(); i++) {
                for (int j = 0; j < timeslice; j++) {

                    if (processosRR.get(i).getTempoRestante() == 0) {

                        processosRR.remove(i);
                        break;
                    }
                    totalTempoEspera += tempo - processosRR.get(i).getTempoDeExecucao();
                    processosRR.get(i).setTempoRestante(processosRR.get(i).getTempoRestante() - 1);
                    System.out.printf("TEMPO[%s] : processo[%s] restante=%s\n", tempo, processosRR.get(i).getNome(), processosRR.get(i).getTempoRestante());
                    tempo++;



                }
            }

            if (processosRR.isEmpty()){
                fim = false;
            }

        }

        totalTempoEspera += 1;
        System.out.println("totalTempoEspera:" + totalTempoEspera);
        System.out.println("Tempo de Espera:" + totalTempoEspera/totalProcessos);

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


        if (pop.equalsIgnoreCase("M")){

            for (int i = 0; i < qtdProcessos; i++){

                System.out.println("Digite o tempo de execução do processo " + i + ": ");
                int tempoDeExecucao = teclado.nextInt();

                System.out.println("Digite o tempo de chegada do processo " + i + ": ");
                int tempoChegada = teclado.nextInt();

                System.out.println("Digite a prioridade do processo " + i + ": ");
                int prioridade = teclado.nextInt();

                processosPopulados.add(new Processo(i, tempoDeExecucao, tempoChegada, prioridade));

            }

        } else if (pop.equalsIgnoreCase("R")){

            for (int i = 0; i < qtdProcessos; i++){

                Random random = new Random();

                processosPopulados.add(new Processo(i, random.nextInt(10)+1, random.nextInt(10)+1, random.nextInt(10)+1));

            }
        }
        imprime_processos(processosPopulados);

    }



}