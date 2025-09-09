package AlgoritmosOrdenacao;

import java.util.Scanner;
import ManipulacaoArquivo.ManipularArquivo;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        int escolha = 0;
        String nm = "";

        do {
            System.out.println("===== MENU PRINCIPAL =====\n"
                    + " 1. Gerar e Gravar Arquivo com Números\n"
                    + " 2. Ler e Exibir Conteúdo de um Arquivo\n"
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

                    do {
                        System.out.println("\n Ler e Exibir Conteúdo:\n"
                                + "  1. Arquivo Desordenado\n"
                                + "  2. Seleção Direta\n"
                                + "  3. HeapSort\n"
                                + "  4. Inserção Direta\n"
                                + "  5. BubbleSort\n"
                                + "  6. ShakerSort\n"
                                + "  7. ShellSort\n"
                                + "  8. QuickSort\n"
                                + "  9. Voltar\n"
                                + " ==================================\n"
                                + " Escolha uma opção: ");
                        escolha = scan.nextInt();

                        String resultado = "";
                        switch (escolha) {
                            case 1:
                                resultado = ManipularArquivo.lerArquivo(nm);
                                break;
                            case 2:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "sd");
                                break;
                            case 3:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "hs");
                                break;
                            case 4:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "id");
                                break;
                            case 5:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "bs");
                                break;
                            case 6:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "ss");
                                break;
                            case 7:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "sh");
                                break;
                            case 8:
                                resultado = ManipularArquivo.ordenarArquivo(nm, "qs");
                                break;
                            case 9:
                                break;
                            default:
                                System.out.println("Opção inválida.");
                                break;
                        }

                        if (!resultado.isEmpty()) {
                            System.out.println(resultado + "\n");
                        }

                    } while (escolha != 9);
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
