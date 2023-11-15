import java.util.ArrayList;
import java.util.Comparator;

public class Ordenar {




    public static void semPrioridade(ArrayList<String> processo, ArrayList<String> tempoChegada){

        for (int i = 0; i < processo.size(); i++){
            System.out.printf("Processo: %s, Tempo de Chegada: %s\n", processo.get(i), tempoChegada.get(i));
        }

        ArrayList<Processo> processosSPrioridade = new ArrayList<>();

        for (int i = 0; i < processo.size(); i++){
            processosSPrioridade.add(new Processo(processo.get(i), tempoChegada.get(i)));
        }

        processosSPrioridade.sort(Comparator.comparing(Processo::getTempoChegada));

        for (Processo p : processosSPrioridade){
            System.out.printf("Processo: %s, Tempo de Chegada: %s\n", p.getNome(), p.getTempoChegada());
        }

    }
}
