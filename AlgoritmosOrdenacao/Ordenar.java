package AlgoritmosOrdenacao;

public class Ordenar {

    private Item[] vetor;
    private int nElem;

    public long comparacoes = 0;
    public long movimentacoes = 0;
    public long tempoExecucao = 0;

    public Ordenar(Item[] vetor) {
        this.vetor = vetor;
        this.nElem = vetor.length;
    }

    // --------------- SELEÇÃO DIRETA ---------------
    public void selecaoDireta() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        int i, j, minimo;
        Item temp;
        for (i = 0; i < this.nElem - 1; i++) {
            minimo = i;
            for (j = i + 1; j < this.nElem; j++) {
                comparacoes++;
                if (this.vetor[j].getChave() < this.vetor[minimo].getChave())
                    minimo = j;
            }
            temp = this.vetor[minimo];
            this.vetor[minimo] = this.vetor[i];
            this.vetor[i] = temp;
            movimentacoes++;
        }

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    // --------------- HEAPSORT ---------------
    public void heapSort() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        int dir = nElem - 1;
        int esq = (dir - 1) / 2;
        Item temp;

        while (esq >= 0)
            refazHeap(esq--, this.nElem - 1);

        while (dir > 0) {
            temp = this.vetor[0];
            this.vetor[0] = this.vetor[dir];
            this.vetor[dir--] = temp;
            movimentacoes += 3; // troca
            refazHeap(0, dir);
        }

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    private void refazHeap(int esq, int dir) {
        int i = esq;
        int MaiorFolha = 2 * i + 1;
        Item raiz = this.vetor[i];
        boolean heap = false;

        while ((MaiorFolha <= dir) && (!heap)) {
            comparacoes++;
            if (MaiorFolha < dir) {
                comparacoes++;
                if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave())
                    MaiorFolha++;
            }
            comparacoes++;
            if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
                this.vetor[i] = this.vetor[MaiorFolha];
                i = MaiorFolha;
                MaiorFolha = 2 * i + 1;
                movimentacoes++;
            } else
                heap = true;
        }
        this.vetor[i] = raiz;
        movimentacoes++;
    }

    // --------------- INSERÇÃO DIRETA ---------------
    public void insercaoDireta() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        int i, j;
        Item temp;
        for (i = 1; i < this.nElem; i++) {
            temp = this.vetor[i];
            j = i - 1;

            comparacoes++;
            while ((j >= 0) && (this.vetor[j].getChave() > temp.getChave())) {
                comparacoes++;
                this.vetor[j + 1] = this.vetor[j--];
                movimentacoes++;
            }
            this.vetor[j + 1] = temp;
            movimentacoes++;
        }

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    // --------------- SHELLSORT ---------------
    public void shellSort() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        int i, j, h;
        Item temp;
        h = 1;
        do {
            h = 3 * h + 1;
        } while (h < this.nElem);

        do {
            h = h / 3;
            for (i = h; i < this.nElem; i++) {
                temp = this.vetor[i];
                j = i;
                comparacoes++;
                while (this.vetor[j - h].getChave() > temp.getChave()) {
                    comparacoes++;
                    this.vetor[j] = this.vetor[j - h];
                    j -= h;
                    movimentacoes++;
                    if (j < h)
                        break;
                }
                this.vetor[j] = temp;
                // movimentacoes++;
            }
        } while (h != 1);

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    // --------------- BUBBLESORT ---------------
    public void bubblesort() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        int n, i, j;
        Item temp;
        n = this.nElem - 1;
        do {
            i = 0;
            for (j = 0; j < n; j++) {
                comparacoes++;
                if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
                    temp = this.vetor[j];
                    this.vetor[j] = this.vetor[j + 1];
                    this.vetor[j + 1] = temp;
                    movimentacoes++;
                    i = j;
                }
            }
            n = i;
        } while (n >= 1);

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    // --------------- SHAKESORT ---------------
    public void shakesort() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        int esq, dir, i, j;
        Item temp;
        esq = 1;
        dir = this.nElem - 1;
        j = dir;
        do {
            for (i = dir; i >= esq; i--) {
                comparacoes++;
                if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
                    temp = this.vetor[i];
                    this.vetor[i] = this.vetor[i - 1];
                    this.vetor[i - 1] = temp;
                    movimentacoes++;
                    j = i;

                }
            }
            esq = j + 1;
            for (i = esq; i <= dir; i++) {
                comparacoes++;
                if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
                    temp = this.vetor[i];
                    this.vetor[i] = this.vetor[i - 1];
                    this.vetor[i - 1] = temp;
                    movimentacoes++;
                    j = i;
                }
            }
            dir = j - 1;
        } while (esq <= dir);

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    // --------------- QUICKSORT ---------------
    public void quicksort() {
        comparacoes = 0;
        movimentacoes = 0;
        long inicio = System.nanoTime();

        ordena(0, this.nElem - 1);

        long fim = System.nanoTime();
        tempoExecucao = fim - inicio;
    }

    private void ordena(int esq, int dir) {
        int pivo, i = esq, j = dir;
        Item temp;
        pivo = this.vetor[(i + j) / 2].getChave();
        do {
            comparacoes++;
            while (this.vetor[i].getChave() < pivo) {
                comparacoes++;
                i++;
            }
            comparacoes++;
            while (this.vetor[j].getChave() > pivo) {
                comparacoes++;
                j--;
            }

            if (i <= j) {
                temp = this.vetor[i];
                this.vetor[i] = this.vetor[j];
                this.vetor[j] = temp;
                movimentacoes++;
                i++;
                j--;

            }
        } while (i <= j);
        if (esq < j) {
            ordena(esq, j);
        }
        if (dir > i) {
            ordena(i, dir);
        }
    }
}
