public class Processo {


    private static int ultimoNome = 0;
    int nome;
    int tempoDeExecucao;
    int tempoRestante;
    int tempoChegada;
    int prioridade;

    /*===============================================================================================================*/
    public Processo(int tempoDeExecucao, int tempoChegada, int prioridade) {
        this.nome = ++ultimoNome;
        this.tempoDeExecucao = tempoDeExecucao;
        this.tempoRestante = tempoDeExecucao;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
    }
    /*===============================================================================================================*/




    /*===============================================================================================================*/

    public int getNome() {
        return nome;
    }

    public void setNome(int nome) {
        this.nome = nome;
    }

    public int getTempoDeExecucao() {
        return tempoDeExecucao;
    }

    public void setTempoDeExecucao(int tempoDeExecucao) {
        this.tempoDeExecucao = tempoDeExecucao;
    }

    public int getTempoRestante() {
        return tempoRestante;
    }

    public void setTempoRestante(int tempoRestante) {
        this.tempoRestante = tempoRestante;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
