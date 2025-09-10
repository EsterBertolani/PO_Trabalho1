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

    public static String toString(int[] numeros) {
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
                numeros[i] = Integer.parseInt(linha);
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

    /*
     * public static String ordenarArquivo(String nomeArquivo, String tipoOrdenacao)
     * {
     * String erro = "Erro ao ler o arquivo: ";
     * int[] numeros = new int[tamArquivo(nomeArquivo)];
     * 
     * try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo)))
     * {
     * String linha;
     * int i = 0;
     * while ((linha = reader.readLine()) != null) {
     * numeros[i] = Integer.parseInt(linha);
     * i++;
     * }
     * 
     * Item[] itens = new Item[numeros.length];
     * for (int j = 0; j < numeros.length; j++) {
     * itens[j] = new Item(numeros[j]);
     * }
     * 
     * Ordenar ord = new Ordenar(itens);
     * 
     * switch (tipoOrdenacao.toLowerCase()) {
     * case "sd":
     * ord.selecaoDireta();
     * break;
     * 
     * case "hs":
     * ord.heapSort();
     * break;
     * 
     * case "id":
     * ord.insercaoDireta();
     * break;
     * 
     * case "shs":
     * ord.shellSort();
     * break;
     * 
     * case "bs":
     * ord.bubblesort();
     * break;
     * case "ss":
     * ord.shakesort();
     * break;
     * 
     * case "qs":
     * ord.quicksort();
     * break;
     * default:
     * return "Tipo de ordenação inválido!";
     * }
     * 
     * for (int j = 0; j < itens.length; j++) {
     * numeros[j] = itens[j].getChave();
     * }
     * 
     * 
     * 
     * } catch (IOException e) {
     * erro += e.getMessage();
     * }
     * 
     * if (numeros.length > 0) {
     * return toString(numeros);
     * } else {
     * return erro;
     * }
     * }
     */

    /*
     * public static Resultado ordenarArquivo(String nomeArquivo, String
     * tipoOrdenacao) {
     * int[] numeros = new int[tamArquivo(nomeArquivo)];
     * 
     * try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo)))
     * {
     * String linha;
     * int i = 0;
     * while ((linha = reader.readLine()) != null) {
     * numeros[i] = Integer.parseInt(linha);
     * i++;
     * }
     * 
     * Item[] itens = new Item[numeros.length];
     * for (int j = 0; j < numeros.length; j++) {
     * itens[j] = new Item(numeros[j]);
     * }
     * 
     * Ordenar ord = new Ordenar(itens);
     * String nomeAlgoritmo;
     * 
     * switch (tipoOrdenacao.toLowerCase()) {
     * case "sd":
     * ord.selecaoDireta();
     * nomeAlgoritmo = "Seleção Direta";
     * break;
     * case "hs":
     * ord.heapSort();
     * nomeAlgoritmo = "HeapSort";
     * break;
     * case "id":
     * ord.insercaoDireta();
     * nomeAlgoritmo = "Inserção Direta";
     * break;
     * case "bs":
     * ord.bubblesort();
     * nomeAlgoritmo = "BubbleSort";
     * break;
     * case "ss":
     * ord.shakesort();
     * nomeAlgoritmo = "ShakerSort";
     * break;
     * case "shs":
     * ord.shellSort();
     * nomeAlgoritmo = "ShellSort";
     * break;
     * case "qs":
     * ord.quicksort();
     * nomeAlgoritmo = "QuickSort";
     * break;
     * default:
     * return null;
     * }
     * 
     * return new Resultado(nomeAlgoritmo, ord.comparacoes, ord.movimentacoes,
     * ord.tempoExecucao);
     * 
     * } catch (IOException e) {
     * System.out.println("Erro: " + e.getMessage());
     * }
     * 
     * return null;
     * }
     */

}
