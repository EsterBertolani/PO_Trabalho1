package AlgoritmosOrdenacao;

public class Ordenar {

    // ---------------- INSERÇÃO DIRETA ----------------
    public static Resultado insercaoDireta(Item[] vetor) {
        Item[] v = vetor.clone();
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime(); // marca tempo

        for (int i = 1; i < v.length; i++) {
            Item temp = v[i];
            movimentacoes++; // movimentação: salvar chave temporária
            int j = i - 1;
            while (j >= 0) {
                comparacoes++; // comparação: testar v[j] > temp
                if (v[j].getChave() > temp.getChave()) {
                    v[j + 1] = v[j];
                    movimentacoes++; // movimentação: deslocamento
                    j--;
                } else break;
            }
            v[j + 1] = temp;
            movimentacoes++; // movimentação: inserção do temp
        }

        long fim = System.nanoTime(); // marca tempo
        return new Resultado(comparacoes, movimentacoes, fim - inicio);
    }

    // ---------------- SELEÇÃO DIRETA ----------------
    public static Resultado selecaoDireta(Item[] vetor) {
        Item[] v = vetor.clone();
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        for (int i = 0; i < v.length - 1; i++) {
            int minimo = i;
            for (int j = i + 1; j < v.length; j++) {
                comparacoes++; // comparação: v[j] < v[minimo]
                if (v[j].getChave() < v[minimo].getChave()) {
                    minimo = j;
                }
            }
            if (minimo != i) {
                Item temp = v[minimo];
                v[minimo] = v[i];
                v[i] = temp;
                movimentacoes += 3; // movimentação: troca
            }
        }

        long fim = System.nanoTime();
        return new Resultado(comparacoes, movimentacoes, fim - inicio);
    }

    // ---------------- BUBBLE SORT ----------------
    public static Resultado bubbleSort(Item[] vetor) {
        Item[] v = vetor.clone();
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int n = v.length - 1;
        do {
            int i = 0;
            for (int j = 0; j < n; j++) {
                comparacoes++; // comparação: v[j] > v[j+1]
                if (v[j].getChave() > v[j + 1].getChave()) {
                    Item temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    movimentacoes += 3; // movimentação: troca
                    i = j;
                }
            }
            n = i;
        } while (n >= 1);

        long fim = System.nanoTime();
        return new Resultado(comparacoes, movimentacoes, fim - inicio);
    }

    // ---------------- SHAKER SORT ----------------
    public static Resultado shakerSort(Item[] vetor) {
        Item[] v = vetor.clone();
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int esq = 1, dir = v.length - 1, j = dir;
        do {
            for (int i = dir; i >= esq; i--) {
                comparacoes++; // comparação: v[i-1] > v[i]
                if (v[i - 1].getChave() > v[i].getChave()) {
                    Item temp = v[i];
                    v[i] = v[i - 1];
                    v[i - 1] = temp;
                    movimentacoes += 3; // movimentação: troca
                    j = i;
                }
            }
            esq = j + 1;
            for (int i = esq; i <= dir; i++) {
                comparacoes++; // comparação: v[i-1] > v[i]
                if (v[i - 1].getChave() > v[i].getChave()) {
                    Item temp = v[i];
                    v[i] = v[i - 1];
                    v[i - 1] = temp;
                    movimentacoes += 3;
                    j = i;
                }
            }
            dir = j - 1;
        } while (esq <= dir);

        long fim = System.nanoTime();
        return new Resultado(comparacoes, movimentacoes, fim - inicio);
    }

    // ---------------- SHELL SORT ----------------
    public static Resultado shellSort(Item[] vetor) {
        Item[] v = vetor.clone();
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int h = 1;
        do {
            h = 3 * h + 1;
        } while (h < v.length);

        do {
            h /= 3;
            for (int i = h; i < v.length; i++) {
                Item temp = v[i];
                movimentacoes++; // salvar chave temporária
                int j = i;
                while (j >= h) {
                    comparacoes++; // comparação: v[j-h] > temp
                    if (v[j - h].getChave() > temp.getChave()) {
                        v[j] = v[j - h];
                        movimentacoes++; // movimentação: deslocamento
                        j -= h;
                    } else break;
                }
                v[j] = temp;
                movimentacoes++; // inserção
            }
        } while (h > 1);

        long fim = System.nanoTime();
        return new Resultado(comparacoes, movimentacoes, fim - inicio);
    }

    // ---------------- HEAP SORT ----------------
    public static Resultado heapSort(Item[] vetor) {
        Item[] v = vetor.clone();
        long comparacoes = 0, movimentacoes = 0;
        long inicio = System.nanoTime();

        int n = v.length;

        // Construção do heap
        for (int esq = (n / 2) - 1; esq >= 0; esq--) {
            long[] aux = refazHeap(v, esq, n - 1);
            comparacoes += aux[0];
            movimentacoes += aux[1];
        }

        for (int dir = n - 1; dir > 0; dir--) {
            Item temp = v[0];
            v[0] = v[dir];
            v[dir] = temp;
            movimentacoes += 3; // movimentação: troca raiz com último
            long[] aux = refazHeap(v, 0, dir - 1);
            comparacoes += aux[0];
            movimentacoes += aux[1];
        }

        long fim = System.nanoTime();
        return new Resultado(comparacoes, movimentacoes, fim - inicio);
    }

    // método auxiliar para HeapSort
    private static long[] refazHeap(Item[] v, int esq, int dir) {
        long comparacoes = 0, movimentacoes = 0;
        int i = esq;
        int maiorFilho = 2 * i + 1;
        Item raiz = v[i];

        boolean heap = false;
        while (maiorFilho <= dir && !heap) {
            if (maiorFilho < dir) {
                comparacoes++; // comparação entre filhos
                if (v[maiorFilho].getChave() < v[maiorFilho + 1].getChave()) {
                    maiorFilho++;
                }
            }
            comparacoes++; // comparação raiz com maior filho
            if (raiz.getChave() < v[maiorFilho].getChave()) {
                v[i] = v[maiorFilho];
                movimentacoes++; // movimentação: sobe filho
                i = maiorFilho;
                maiorFilho = 2 * i + 1;
            } else {
                heap = true;
            }
        }
        v[i] = raiz;
        movimentacoes++; // reposiciona raiz
        return new long[]{comparacoes, movimentacoes};
    }

    // ---------------- QUICK SORT ----------------

public static Resultado quickSort(Item[] vetor) {
    Item[] v = vetor.clone(); // Clona o vetor original para não alterá-lo
    Resultado r = new Resultado(0, 0, 0); // Inicializa o objeto para armazenar resultados
    long inicio = System.nanoTime(); // Marca o tempo de início

    quickSortRec(v, 0, v.length - 1, r); // Chamada recursiva

    long fim = System.nanoTime(); // Marca o tempo de fim
    r.tempo = fim - inicio; // Calcula o tempo total
    return r;
}

private static void quickSortRec(Item[] v, int esq, int dir, Resultado r) {
    int i = esq, j = dir;
    int pivo = v[(i + j) / 2].getChave(); // Escolhe o pivô como o elemento do meio

    do {
        while (v[i].getChave() < pivo) {
            r.comparacoes++; // Conta a comparação
            i++;
        }
        while (v[j].getChave() > pivo) {
            r.comparacoes++; // Conta a comparação
            j--;
        }
        if (i <= j) {
            // Troca os elementos
            Item temp = v[i];
            v[i] = v[j];
            v[j] = temp;
            r.movimentacoes += 3; // Conta como 3 movimentações (leitura, leitura, escrita)
            i++;
            j--;
        }
    } while (i <= j);

    // Chamada recursiva para as subpartes
    if (esq < j) quickSortRec(v, esq, j, r);
    if (i < dir) quickSortRec(v, i, dir, r);
}


}
