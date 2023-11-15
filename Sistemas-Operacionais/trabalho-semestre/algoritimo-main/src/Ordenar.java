import java.util.ArrayList;
import java.util.Comparator;

public class Ordenar {




    public static void semPrioridade(ArrayList<String> processo, ArrayList<String> tempoChegada){
        ArrayList<Processo> processosSPrioridade = new ArrayList<>();

        for (int i = 0; i < processo.size(); i++){
            processosSPrioridade.add(new Processo(processo.get(i), tempoChegada.get(i)));
        }

        processosSPrioridade.sort(Comparator.comparing(Processo::getTempoChegada));

        for (Processo p : processosSPrioridade){
            System.out.printf("Processo: %s, Tempo de Chegada: %s\n", p.getNome(), p.getTempoChegada());
        }

    }

//    public static String[]orderPrime(String[] Processo, String[] odemChegada, String[] Prioridade){
//
//
//        for (int i =0; i < Processo.length; i++){
//            System.out.printf("Processo: %s, Tempo de Execução: %s, Tempo Restante: %s \n", Processo[i], odemChegada[i], Prioridade[i]);
//        }
//        String[] ProcessoOrdenado = new String[Processo.length];
////        String[] odemChegadaOrdenado = new String[odemChegada.length];
////        String[] PrioridadeOrdenado = new String[Prioridade.length];
////
////        for (int i = 0; i < Processo.length; i++) {
////            for (int j = 0; j < Processo.length; j++) {
////                if (Integer.parseInt(odemChegada[i]) < Integer.parseInt(odemChegada[j])) {
////                    String aux = Processo[i];
////                    Processo[i] = Processo[j];
////                    Processo[j] = aux;
////
////                    String aux2 = odemChegada[i];
////                    odemChegada[i] = odemChegada[j];
////                    odemChegada[j] = aux2;
////
////                    String aux3 = Prioridade[i];
////                    Prioridade[i] = Prioridade[j];
////                    Prioridade[j] = aux3;
////                }
////            }
////        }
////
////        for (int i = 0; i < Processo.length; i++) {
////            ProcessoOrdenado[i] = Processo[i];
////            odemChegadaOrdenado[i] = odemChegada[i];
////            PrioridadeOrdenado[i] = Prioridade[i];
////        }
//
//        return ProcessoOrdenado;
//    }

}
