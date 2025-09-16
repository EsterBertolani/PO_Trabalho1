package AlgoritmosOrdenacao;

import java.util.Scanner;
import ManipulacaoArquivo.ManipularArquivo;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        String nm = "";

        do {
            System.out.println("===== MENU PRINCIPAL =====");
            System.out.println(" 1. Gerar e Gravar Arquivo com Números");
            System.out.println(" 2. Executar Algoritmos de Ordenação");
            System.out.println(" 3. Sair");
            System.out.println("==================================");
            System.out.print("Escolha uma opção: ");
            opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite a quantidade de números que deseja no arquivo: ");
                    int n = scan.nextInt();

                    System.out.print("Digite o nome do arquivo: ");
                    String nome = scan.next();

                    int[] numeros = ManipularArquivo.gerarNumeros(n);
                    String msg = ManipularArquivo.gerarArquivo(numeros, nome);
                    System.out.println(msg + "\n");
                    break;

                case 2:
                    System.out.print("Digite o nome do arquivo: ");
                    nm = scan.next();

                    System.out.println(ManipularArquivo.lerArquivo(nm));

                    System.out.println("\n====== RESULTADOS COMPARATIVOS ======");

                    Resultado[] resultados = ManipularArquivo.ordenarArquivo(nm);

                    if (resultados.length > 0) {

                        System.out.println("\n ===== VETOR ORDENADO =====");
                        for (int num : resultados[0].numerosOrdenados) {
                            System.out.print(num + " | ");
                        }
                        System.out.println("\n");

                        // Quadro 1: Comparações
                        System.out.println("\nQuadro Comparativo - Número de Comparações");
                        System.out.println("-------------------------------------------");
                        System.out.printf("%-15s | %15s\n", "Algoritmo", "Comparações");
                        System.out.println("-------------------------------------------");

                        for (Resultado resultado : resultados) {
                            System.out.printf("%-15s | %15d\n", resultado.getNomeAlgoritmo(),
                                    resultado.getComparacoes());
                        }

                        // Quadro 2: Movimentações
                        System.out.println("\nQuadro Comparativo - Número de Movimentações");
                        System.out.println("-------------------------------------------");
                        System.out.printf("%-15s | %15s\n", "Algoritmo", "Movimentações");
                        System.out.println("-------------------------------------------");

                        for (Resultado resultado : resultados) {
                            System.out.printf("%-15s | %15d\n", resultado.getNomeAlgoritmo(),
                                    resultado.getMovimentacoes());
                        }

                        // Quadro 3: Tempo de Execução
                        System.out.println("\nQuadro Comparativo - Tempo de Execução (ns)");
                        System.out.println("-------------------------------------------");
                        System.out.printf("%-15s | %15s\n", "Algoritmo", "Tempo (ns)");
                        System.out.println("-------------------------------------------");

                        for (Resultado resultado : resultados) {
                            System.out.printf("%-15s | %15d\n", resultado.getNomeAlgoritmo(), resultado.getTempo());
                        }

                    } else {
                        System.out.println("Erro ao executar os algoritmos ou arquivo não encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 3);
        scan.close();
    }
}
