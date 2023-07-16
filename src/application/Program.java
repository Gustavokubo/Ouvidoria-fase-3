package application;

import java.sql.Connection;
import java.util.Scanner;

import db.DB;
import entities.Elogio;
import entities.Manifestacao;
import entities.Menu;
import entities.Pessoa;
import entities.Reclamacao;
import entities.Sugestao;

public class Program {

	public static void main(String[] args) {

		Connection con = DB.getConnection();

		Scanner sc = new Scanner(System.in);

		Menu menu = new Menu();

		//Menu para cadastrar usuários.
		menu.menuIdentificacao();
		System.out.print("Nome: ");
		String nome = sc.nextLine();
		System.out.print("CPF: ");
		String cpf = sc.nextLine();
		Pessoa pessoa = new Pessoa(nome,cpf);
		pessoa.inserir(con);
		Pessoa.listar(con);

		int opcao = 1;
		while (opcao != 0) {
			System.out.println("");
			menu.menuPrincipal();
			opcao = sc.nextInt();
			

			switch (opcao) {

			case 1: {

				menu.menuManifestacoes();
				opcao = sc.nextInt();
				sc.nextLine();

					// Código para inseir uma reclamação.
					if (opcao == 1) {

						System.out.println("|=========================|");
						System.out.println("| Digite sua reclamação:  |");
						System.out.println("|=========================|");

						String Reclamacao = sc.nextLine();

						Reclamacao reclamacao = new Reclamacao(Reclamacao, pessoa);
						reclamacao.inserirManifestacao(con);

						System.out.println("");
						System.out.println("Reclamação cadastrada com sucesso!");
						System.out.println("");

						break;
					}

					// Código para inserir um elogio.
					if (opcao == 2) {
						
						System.out.println("|=========================|");
						System.out.println("|    Digite seu elogio:   |");
						System.out.println("|=========================|");

						String Elogio = sc.nextLine();

						Elogio elogio = new Elogio(Elogio, pessoa);
						elogio.inserirManifestacao (con);
						
						System.out.println("");
						System.out.println("Elogio cadastrado com sucesso!");
						System.out.println("");

						break;
					}

					// Código para inserir uma sugestão.
					if (opcao == 3) {

						System.out.println("|=========================|");
						System.out.println("|   Digite sua sugestão:  |");
						System.out.println("|=========================|");

						String Sugestao = sc.nextLine();

						Sugestao sugestao = new Sugestao(Sugestao, pessoa);
						sugestao.inserirManifestacao(con);

						System.out.println("");
						System.out.println("Sugestão cadastrada com sucesso!");
						System.out.println("");
						
						break;
					}
				}
			
			//Listar as manifestações.
			case 2: {

				System.out.println("|==========================|");
				System.out.println("|  LISTA DE MANIFESTAÇÕES  |");
				System.out.println("|==========================|");

				Manifestacao.listarManifestacao(con);
				
				break;
			}
			
			//Deletar manifestações.
			case 3: {
				
				menu.menuDeletarManifestacao();
				System.out.println("");
				System.out.println("|==========================|");
				System.out.println("|  LISTA DE MANIFESTAÇÕES  |");
				System.out.println("|==========================|");
				System.out.println("");
				Manifestacao.listarManifestacao(con);
				System.out.println("");
				System.out.println("|============================|");
				System.out.println("|  DIGITE O ID PARA DELETAR  |");
				System.out.println("|============================|");
				System.out.println("");
				System.out.println("Digite sua opção: ");
				Manifestacao.deletarmanifestacao(con, 0);
				break;
			}
			
			//Sair da ouvidoria.
			case 4: { 
				opcao=0;
				
				System.out.println("Obrigado por utilizar nosso sistema de ouvidoria!");
			}

				sc.close(); // Fecha o Scanner

			} // Fecha o Switch
		} // Fecha o While
	} // Fecha o Main
} // Fecha a classe Program

