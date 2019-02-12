package br.com.fiap.loja;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import br.com.fiap.loja.bo.EstoqueBO;
import br.com.fiap.loja.singleton.LojaSingleton;
import br.com.fiap.loja.to.ProdutoTO;

public class TerminalConsulta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Data atual
		Calendar data = Calendar.getInstance();
		// Formatar a data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		EstoqueBO bo = new EstoqueBO();
		int codigo;
		
		//Recuperar a configuração
		String loja = LojaSingleton.getInstance().getProperty("filial");
		do {

			System.out.println(loja + " - " + sdf.format(data.getTime()));
			// Ler um código do produto
			System.out.print("Digite o código do produto: ");
			codigo = sc.nextInt();			
			ProdutoTO to = bo.consultarProduto(codigo);
			
			if (to != null)
				System.out.println(to);
			else
				System.out.println("Produto não encontrado!\n");
			
		} while (codigo != 0);
		
		sc.close();
	}

}
