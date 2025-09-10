package AlgoritmosOrdenacao;

import java.util.Scanner;
import ManipulacaoArquivo.ManipularArquivo;

public class Main_V2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int opcao = 0;
        int escolha = 0;
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
