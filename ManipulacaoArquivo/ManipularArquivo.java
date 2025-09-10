package ManipulacaoArquivo;

import AlgoritmosOrdenacao.Item;
import AlgoritmosOrdenacao.Ordenar;
import AlgoritmosOrdenacao.Resultado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManipularArquivo {

    private static final String[] CODIGOS_ALGORITMOS = { "sd", "hs", "id", "bs", "ss", "shs", "qs" };
    private static final String[] NOMES_ALGORITMOS = { "Seleção Direta", "HeapSort", "Inserção Direta",
            "BubbleSort", "ShakerSort", "ShellSort", "QuickSort" };

    public static int[] gerarNumeros(int qtdNum) {
        int[] numeros = new int[qtdNum];
        for (int i = 0; i < qtdNum; i++) {
            numeros[i] = (int) (Math.random() * 1000);
        }
        return numeros;
    }

    public static String gerarArquivo(int[] numeros, String nomeArquivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            for (int i : numeros) {
                writer.write(String.valueOf(i));
                writer.newLine();
            }
            return "Arquivo \"" + nomeArquivo + "\" criado com sucesso contendo " + numeros.length + " números!";
        } catch (IOException e) {
            return "Erro ao criar o arquivo \"" + nomeArquivo + "\": " + e.getMessage();
        }
    }

    private static String toString(int[] numeros) {
        StringBuilder msg = new StringBuilder("\nNúmeros: ");
        for (int i : numeros) {
            msg.append(i).append(" | ");
        }
        return msg.toString();
    }

    private static int tamArquivo(String nomeArquivo) {
        int cont = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            while ((reader.readLine()) != null) {
                cont++;
            }
        } catch (IOException e) {
            return 0;
        }
        return cont;
    }

    public static String lerArquivo(String nomeArquivo) {
        String erro = "Erro ao ler o arquivo: ";
        int[] numeros = new int[tamArquivo(nomeArquivo)];

        try (BufferedReader rd = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int i = 0;
            while ((linha = rd.readLine()) != null) {
                numeros[i] = Integer.parseInt(linha.trim());
                i++;
            }
        } catch (IOException e) {
            erro += e.getMessage();
        }

        if (numeros.length > 0) {
            return toString(numeros);
        } else {
            return erro;
        }
    }

    private static int[] copiaChaves(Item[] itens) {
        int[] numeros = new int[itens.length];
        for (int i = 0; i < itens.length; i++) {
            numeros[i] = itens[i].getChave();
        }
        return numeros;
    }

    public static Resultado[] ordenarArquivo(String nomeArquivo) {
        int tamanho = tamArquivo(nomeArquivo);

        if (tamanho == 0)
            return new Resultado[0];

        int[] numeros = new int[tamanho];

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int i = 0;
            while ((linha = reader.readLine()) != null) {
                numeros[i] = Integer.parseInt(linha.trim());
                i++;
            }
        } catch (IOException e) {
            return new Resultado[0];
        }

        Resultado[] resultados = new Resultado[CODIGOS_ALGORITMOS.length];

        for (int k = 0; k < CODIGOS_ALGORITMOS.length; k++) {
            Item[] itens = new Item[numeros.length];

            for (int j = 0; j < numeros.length; j++) {
                itens[j] = new Item(numeros[j]);
            }

            Ordenar ord = new Ordenar(itens);

            switch (CODIGOS_ALGORITMOS[k]) {
                case "sd":
                    ord.selecaoDireta();
                    break;
                case "hs":
                    ord.heapSort();
                    break;
                case "id":
                    ord.insercaoDireta();
                    break;
                case "bs":
                    ord.bubblesort();
                    break;
                case "ss":
                    ord.shakesort();
                    break;
                case "shs":
                    ord.shellSort();
                    break;
                case "qs":
                    ord.quicksort();
                    break;
            }

            resultados[k] = new Resultado(ord.comparacoes, ord.movimentacoes, ord.tempoExecucao, NOMES_ALGORITMOS[k],
                    copiaChaves(itens));
        }

        return resultados;
    }
}
