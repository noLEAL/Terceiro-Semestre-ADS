public class Processo {
    String nome;
    String tempoChegada;
    String prioridade;

    public Processo(String nome, String tempoChegada) {
        this.nome = nome;
        this.tempoChegada = tempoChegada;
    }

    public Processo(String nome, String tempoChegada, String prioridade) {
        this.nome = nome;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
    }

    public String getNome() {
        return nome;
    }

    public String getTempoChegada() {
        return tempoChegada;
    }
}
