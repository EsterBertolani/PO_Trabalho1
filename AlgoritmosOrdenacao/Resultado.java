package AlgoritmosOrdenacao;

public class Resultado {
    public long comparacoes;
    public long movimentacoes;
    public long tempo;
    public String nomeAlgoritmo;
    public int[] numerosOrdenados;

    public Resultado(long comp, long mov, long temp, String algoritmo, int[] numeros) {
        this.comparacoes = comp;
        this.movimentacoes = mov;
        this.tempo = temp;
        this.nomeAlgoritmo = algoritmo;
        this.numerosOrdenados = numeros;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public long getTempo() {
        return tempo;
    }

    public String getNomeAlgoritmo() {
        return nomeAlgoritmo;
    }

    public int[] getNumerosOrdenados() {
        return numerosOrdenados;
    }

}
