package AlgoritmosOrdenacao;

public class Ordenar {

	private Item[] vetor;
	private int nElem;

	public Ordenar(Item[] vetor, int nElem) {
		this.vetor = vetor;
		this.nElem = nElem;
	}

	public void selecaoDireta() {
		int i, j, minimo;
		Item temp;
		for (i = 0; i < this.nElem - 1; i++) {
			minimo = i;
			for (j = i + 1; j < this.nElem; j++)
				if (this.vetor[j].getChave() < this.vetor[minimo].getChave())
					minimo = j;
			temp = this.vetor[minimo];
			this.vetor[minimo] = this.vetor[i];
			this.vetor[i] = temp;
		}
	}

	public void heapSort() {
		int dir = nElem - 1;
		int esq = (dir - 1) / 2;
		Item temp;
		while (esq >= 0)
			refazHeap(esq--, this.nElem - 1);
		while (dir > 0) {
			temp = this.vetor[0];
			this.vetor[0] = this.vetor[dir];
			this.vetor[dir--] = temp;
			refazHeap(0, dir);
		}
	}

	private void refazHeap(int esq, int dir) {
		int i = esq;
		int MaiorFolha = 2 * i + 1;
		Item raiz = this.vetor[i];
		boolean heap = false;
		while ((MaiorFolha <= dir) && (!heap)) {
			if (MaiorFolha < dir)
				if (this.vetor[MaiorFolha].getChave() < this.vetor[MaiorFolha + 1].getChave())
					MaiorFolha++;
			if (raiz.getChave() < this.vetor[MaiorFolha].getChave()) {
				this.vetor[i] = this.vetor[MaiorFolha];
				i = MaiorFolha;
				MaiorFolha = 2 * i + 1;
			} else
				heap = true;
		}
		this.vetor[i] = raiz;
	}

	public void insercaoDireta() {
		int i, j;
		Item temp;
		for (i = 1; i < this.nElem; i++) {
			temp = this.vetor[i];
			j = i - 1;
			while ((j >= 0) && (this.vetor[j].getChave() > temp.getChave())) {
				this.vetor[j + 1] = this.vetor[j--];
			}
			this.vetor[j + 1] = temp;
		}
	}

	public void shellSort() {
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
				while (this.vetor[j - h].getChave() > temp.getChave()) {
					this.vetor[j] = this.vetor[j - h];
					j -= h;
					if (j < h)
						break;
				}
				this.vetor[j] = temp;
			}
		} while (h != 1);
	}

	public void bubblesort() {
		int n, i, j;
		Item temp;
		n = this.nElem - 1;
		do {
			i = 0;
			for (j = 0; j < n; j++)
				//comparacao++
				if (this.vetor[j].getChave() > this.vetor[j + 1].getChave()) {
					temp = this.vetor[j];
					this.vetor[j] = this.vetor[j + 1];
					this.vetor[j + 1] = temp;
					i = j;
				}
			n = i;
		} while (n >= 1);
	}

	public void shakesort() {
		int esq, dir, i, j;
		Item temp;
		esq = 1;
		dir = this.nElem - 1;
		j = dir;
		do {
			for (i = dir; i >= esq; i--)
			//comparacao++
				if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					j = i;
				}
			esq = j + 1;
			for (i = esq; i <= dir; i++)
				if (this.vetor[i - 1].getChave() > this.vetor[i].getChave()) {
					temp = this.vetor[i];
					this.vetor[i] = this.vetor[i - 1];
					this.vetor[i - 1] = temp;
					//movimentacao++
					j = i;
				}
			dir = j - 1;
		} while (esq <= dir);

	}

	public void quicksort() {
		ordena(0, this.nElem - 1);
	}

	private void ordena(int esq, int dir) {
		int pivo, i = esq, j = dir;
		Item temp;
		pivo = this.vetor[(i + j) / 2].getChave();
		do {
			//comparacao++
			while (this.vetor[i].getChave() < pivo)
			//comparacao++
				i++;
			while (this.vetor[j].getChave() > pivo)
				j--;
			if (i <= j) {
				//movimentacao++
				temp = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = temp;
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
