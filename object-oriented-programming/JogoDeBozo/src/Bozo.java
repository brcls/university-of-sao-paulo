import java.io.IOException;

/**
 * Essa � a classe inicial do programa Boz�. 
 * Possui apenas o m�todo main, que cuida da execu��o do jogo.
 * @author Erick Barcelos (11345562)
 *
 */

public class Bozo {
	/**
	 * M�todo inicial do programa. 
	 * Ele cuida da execu��o do jogo e possui um la�o, no qual cada itera��o representa uma rodada do jogo. 
	 * Em cada rodada, o jogador joga os dados at� 3 vezes e depois escolhe a posi��o do placar que deseja preencher. 
	 * No final das rodadas a pontua��o total � exibida.
	 * @param args -
	 * @throws java.io.IOException -
	 */
	public static void main(String[] args) throws IOException {
		Placar placar = new Placar();
		RolaDados dados= new RolaDados(5);
		String ler = new String();
		
		int[] valores = new int[5];
		int posicao;
		
		System.out.print("Jogo de Boz�!" + placar);
		
		for(int i = 0; i < 10; i++) {
			System.out.print("****** Rodada " + (i+1));
			System.out.print("\nPressione ENTER para lan�ar os dados");
			
			EntradaTeclado.leString();
			
			dados.rolar();

			System.out.println(dados);			
			System.out.println("Digite os n�meros dos dados que quiser TROCAR. Separados por espa�os.");		
			
			ler = EntradaTeclado.leString();
			dados.rolar(ler);
			
			System.out.println(dados);
			System.out.println("Digite os n�meros dos dados que quiser TROCAR. Separados por espa�os.");
			
			ler = EntradaTeclado.leString();
			valores = dados.rolar(ler);
		
			System.out.println(dados);
			System.out.print(placar);
			System.out.println("Escolha a posi��o que quer ocupar com essa jogada ====> ");
			
			for(;;) {
				try {
					posicao = EntradaTeclado.leInt();
					placar.add(posicao, valores);	
					break;
				} catch (IllegalArgumentException e) { 
					System.out.println("Posi��o ocupada ou valor inv�lido. Digite novamente ====> ");
				}
			}
			System.out.print(placar);
		}
		System.out.print("\n******************************************\n");
		System.out.print("Seu escore final foi: " + placar.getScore());
		System.out.print("\n******************************************");
	}

}
