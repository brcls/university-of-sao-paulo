package jogo.bozo;
/**
 * Simula um dado de n�mero de lados variados. 
 * Ao criar o objeto � poss�vel estabelecer o n�mero de lados. 
 * A rolagem do dado � feita por meio de um gerador de n�meros aleat�rios (Random).
 * @author Erick Barcelos (11345562)
 *
 */

public class Dado {
	
	private int numeroLados;
	public int ladoSuperior;
	private Random rand = new Random();

	//Constructors
	/**
	 * Cria um dado com 6 lados (um cubo)
	 */
	public Dado(){
		numeroLados = 6;
		rolar();
	}
	/**
	 * Cria objeto com um n�mero qualquer de lados
	 * @param n - - n�mero de lados do dado
	 */
	public Dado(int n) {
		numeroLados = n;
		rolar();
	}
	//Methods
	/**
	 * N�o tem fun��o real dentro da classe. 
	 * Foi usada apenas para testar os m�todos implementados
	 * @param args - -- Sem uso
	 
	public static void main(String[] args) {
		Dado d = new Dado();
		d.rolar();
		System.out.println("Lado: \n" +d);
	}
	
	*/
	/**
	 * Recupera o �ltimo n�mero selecionado.
	 * @return o n�mero do �ltimo lado selecionado.
	 */
	public int getLado() {
		return ladoSuperior;
	}
	/**
	 * Simula a rolagem do dado por meio de um gerador aleat�rio. 
	 * O n�mero selecionado pode posteriormente ser recuperado com a chamada a getLado()
	 * @return o n�mero que foi sorteado
	 */
	public int rolar() {
		ladoSuperior =  1 + rand.getIntRand(numeroLados);
		return ladoSuperior;
	}
	/**
	 * Transforma representa��o do dado em String. 
	 * � mostrada uma representa��o do dado que est� para cima. 
	 * Note que s� funciona corretamente para dados de 6 lados. Exemplo:
	 * +-----+    
	 * |*   *|    
	 * |  *  |    
	 * |*   *|    
	 * +-----+
	 * @override toString in class java.lang.Object
	 */
	@Override
	public String toString() {
			switch(getLado()){
			case 1: return "+-----+\n|     |\n|  *  |\n|     |\n+-----+\n";
			case 2: return "+-----+\n|    *|\n|     |\n|*    |\n+-----+\n";
			case 3: return "+-----+\n|    *|\n|  *  |\n|*    |\n+-----+\n";
			case 4: return "+-----+\n|*   *|\n|     |\n|*   *|\n+-----+\n";
			case 5: return "+-----+\n|*   *|\n|  *  |\n|*   *|\n+-----+\n";
			case 6: return "+-----+\n|*   *|\n|*   *|\n|*   *|\n+-----+\n";
			}
			return "";
	}
	
}