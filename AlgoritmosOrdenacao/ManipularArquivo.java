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

    public static String ordenarArquivo(String nomeArquivo, String tipoOrdenacao) {
        String erro = "Erro ao ler o arquivo: ";
        int[] numeros = new int[tamArquivo(nomeArquivo)];

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            int i = 0;
            while ((linha = reader.readLine()) != null) {
                numeros[i] = Integer.parseInt(linha);
                i++;
            }

            Item[] itens = new Item[numeros.length];
            for (int j = 0; j < numeros.length; j++) {
                itens[j] = new Item(numeros[j]);
            }

            Resultado resultado;
            switch (tipoOrdenacao.toLowerCase()) {
                case "id":
                    resultado = Ordenar.insercaoDireta(itens);
                    break;
                case "sd":
                    resultado = Ordenar.selecaoDireta(itens);
                    break;
                case "bs":
                    resultado = Ordenar.bubbleSort(itens);
                    break;
                case "ss":
                    resultado = Ordenar.shakerSort(itens);
                    break;
                case "sh":
                    resultado = Ordenar.shellSort(itens);
                    break;
                case "hs":
                    resultado = Ordenar.heapSort(itens);
                    break;
                case "qs":
                    resultado = Ordenar.quickSort(itens);
                    break;
                default:
                    return "Tipo de ordenação inválido!";
            }

            for (int j = 0; j < itens.length; j++) {
                numeros[j] = itens[j].getChave();
            }

            return toString(numeros) +
                   "\nComparações: " + resultado.comparacoes +
                   "\nMovimentações: " + resultado.movimentacoes +
                   "\nTempo (ns): " + resultado.tempo;

        } catch (IOException e) {
            erro += e.getMessage();
        }

        return erro;
    }
}
