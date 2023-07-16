package entities;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	//Menu para cadastrar usuário. 
	public void menuIdentificacao() {
		
		System.out.println("|============================|");
		System.out.println("|    OUVIDORIA UNIFACISA     |");
		System.out.println("|============================|");
		System.out.println("|                            |");
		System.out.println("|  IDENTIFIQUE-SE COM O SEU  |");
		System.out.println("|       NOME E SEU CPF       |");
		System.out.println("|                            |");
		System.out.println("|============================|");
		System.out.println("");
		
	}
	
	//Menu principal da ouvidoria.
	public void menuPrincipal() {

		System.out.println("|=============================|");
		System.out.println("|     OUVIDORIA UNIFACISA     |");
		System.out.println("|=============================|");
		System.out.println("|           OPÇÕES:           |");
		System.out.println("|                             |");
		System.out.println("|1 - ADICIONAR MANIFESTAÇÃO   |");
		System.out.println("|                             |");
		System.out.println("|2 - LISTAR MANIFESTAÇÃO      |");
		System.out.println("|                             |");
		System.out.println("|3 - DELETAR MANIFESTAÇÃO     |"); 
		System.out.println("|                             |");
		System.out.println("|4 - SAIR DO SISTEMA          |");
		System.out.println("|                             |");
		System.out.println("|=============================|");
		System.out.println("");
		System.out.print("Digite sua opção: ");
		System.out.println("");


	}

	//Menu para adicionar manifestações. 
	public void menuManifestacoes() {

		System.out.println("|===============================|");
		System.out.println("|       OUVIDORIA UNIFACISA     |");
		System.out.println("|===============================|");
		System.out.println("|             OPÇÕES:           |");
		System.out.println("|                               |");
		System.out.println("|1 - ADICIONAR RECLAMAÇÃO       |");
		System.out.println("|                               |");
		System.out.println("|2 - ADICIONAR ELOGIO           |");
		System.out.println("|                               |");
		System.out.println("|3 - ADICIONAR SUGESTÃO         |");
		System.out.println("|                               |");
		System.out.println("|===============================|");
		System.out.println("");
		System.out.print("Digite sua opção: ");
		System.out.println("");

	}
	
	//Menu para deletar manifestações por tipo ou deletar todas. 
	public void menuDeletarManifestacao () {
		
		System.out.println("|===================================================|");
		System.out.println("|                 OUVIDORIA UNIFACISA               |");
		System.out.println("|===================================================|");
		System.out.println("|                                                   |");
		System.out.println("| ESCOLHA O ID PARA DELETAR MANIFESTAÇÃO ESPECÍFICA |");
		System.out.println("|                      OU                           |");
		System.out.println("|   PRESSIONE 0 PARA DELETAR TODAS MANIFESTAÇÕES    |");
		System.out.println("|                                                   |");
		System.out.println("|===================================================|");
		System.out.println("");
		
	}
}
