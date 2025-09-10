package AlgoritmosOrdenacao;

public class Resultado {
    public long comparacoes;
    public long movimentacoes;
    public long tempo;
    public int[] numerosOrdenados;

    public Resultado(long comp, long mov, long temp, int[] numeros) {
        this.comparacoes = comp;
        this.movimentacoes = mov;
        this.tempo = temp;
        this.numerosOrdenados = numeros;
    }
}
