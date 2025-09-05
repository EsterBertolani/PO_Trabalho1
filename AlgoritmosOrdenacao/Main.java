package AlgoritmosOrdenacao;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int opcao = 0;
		int escolha = 0;
		String nm = "";

		do {
			System.out.println("===== MENU PRINCIPAL =====\n"
					+ " 1. Gerar e Gravar Arquivo com Números\n" + //
					" 2. Ler e Exibir Conteúdo de um Arquivo\n" + //
					" 3. Sair\n" + //
					"==================================\n" + //
					"Escolha uma opção:");
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
						System.out.println("\n Ler e Exibir Conteúdo:\n" +
								"  1. Arquivo Desordenado\n" +
								"  2. Seleção Direta\n" +
								"  3. HeapSort\n" +
								"  4. Inserção Direta\n" +
								"  5. Voltar\n " +
								" ==================================\n" +
								" Escolha uma opção: ");
						escolha = scan.nextInt();

						String resultado = "";
						if (escolha == 1) {
							resultado = ManipularArquivo.lerArquivo(nm);
						} else if (escolha == 2) {
							resultado = ManipularArquivo.ordenarArquivo(nm, "sd");
						} else if (escolha == 3) {
							resultado = ManipularArquivo.ordenarArquivo(nm, "hs");
						} else if (escolha == 4) {
							resultado = ManipularArquivo.ordenarArquivo(nm, "id");
						} else if (escolha == 5) {
							break;
						}

						if (!resultado.isEmpty()) {
							System.out.println(resultado + "\n");
						}

					} while (escolha != 5);

					break;

				case 3:
					System.out.println("Programa finalizado.");
					break;

				default:
					break;
			}
		} while (opcao != 3);

		scan.close();
	}
}
