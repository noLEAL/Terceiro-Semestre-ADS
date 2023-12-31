public class Processo implements Cloneable {


    private static int ultimoNome = 0;
    int nome;
    int tempoDeExecucao;
    int tempoRestante;
    int tempoChegada;
    int prioridade;

    /*===============================================================================================================*/
    public Processo(int nome, int tempoDeExecucao, int tempoChegada, int prioridade) {
        this.nome = nome;
        this.tempoDeExecucao = tempoDeExecucao;
        this.tempoRestante = tempoDeExecucao;
        this.tempoChegada = tempoChegada;
        this.prioridade = prioridade;
    }
    /*===============================================================================================================*/

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Cloning not supported", e);
        }
    }


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
