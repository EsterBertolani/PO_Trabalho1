package AlgoritmosOrdenacao;

import java.util.Scanner;
import ManipulacaoArquivo.ManipularArquivo;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        String nm = "";

        do {
            System.out.println("===== MENU PRINCIPAL =====\n"
                    + " 1. Gerar e Gravar Arquivo com Números\n"
                    + " 2. Executar Algoritmos de Ordenação\n"
                    + " 3. Sair\n"
                    + "==================================\n"
                    + "Escolha uma opção:");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite a quantidade de números que deseja no arquivo: ");
                    int n = scan.nextInt();

                    System.out.println("Digite o nome do arquivo: ");
                    String nome = scan.next();

                    int[] numeros = ManipularArquivo.gerarNumeros(n);
                    String msg = ManipularArquivo.gerarArquivo(numeros, nome);
                    System.out.println(msg + "\n");
                    break;

                case 2:
                    System.out.println("Digite o nome do arquivo: ");
                    nm = scan.next();

                    System.out.println(ManipularArquivo.lerArquivo(nm));

                    System.out.println("\n===== RESULTADOS COMPARATIVOS =====");

                    Resultado[] resultados = ManipularArquivo.ordenarArquivoTodos(nm);
                    String[] nomes = ManipularArquivo.getNomesAlgoritmos();

                    if (resultados == null || resultados.length == 0) {
                        System.out.println("Não foi possível gerar resultados (arquivo vazio ou erro de leitura).");
                    } else {
                        System.out.printf("%-15s | %-15s | %-15s | %-15s\n",
                                "Algoritmo", "Comparações", "Movimentações", "Tempo(ns)");
                        System.out.println("----------------------------------------------------------------------");

                        for (int idx = 0; idx < resultados.length; idx++) {
                            Resultado r = resultados[idx];
                            System.out.printf("%-15s | %-15d | %-15d | %-15d\n",
                                    nomes[idx], r.comparacoes, r.movimentacoes, r.tempo);
                        }

                        System.out.println("\n===== VETOR ORDENADO =====");
                        for (int num : resultados[0].numerosOrdenados) {
                            System.out.print(num + " | ");
                        }
                        System.out.println("\n");
                    }
                    break;

                case 3:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 3);

        scan.close();
    }
}
