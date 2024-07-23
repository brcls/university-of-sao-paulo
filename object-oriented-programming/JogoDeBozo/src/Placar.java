/**
 * Esta classe representa o placar de um jogo de Boz�. 
 * Permite que combina��es de dados sejam alocadas �s posi��es e mant�m o escore de um jogador.
 * @author Erick Barcelos (11345562)
 *
 */
public class Placar {
	
	private boolean[] dadosPosicao = new boolean[10];
	private int[] score = new int[10];
	//Constructors
	
	public Placar() {
		for(int i = 0; i < 10; i++) {
			score[i] = 0;
			dadosPosicao[i] = false;
		}
	}
	
	//Methods
	/**
	 * Adiciona uma sequencia de dados em uma determinada posi��o do placar. 
	 * Ap�s a chamada, aquela posi��o torna-se ocupada e n�o pode ser usada uma segunda vez.
	 * @param posicao - Posi��o a ser preenchida. As posi��es 1 a 6 correspondem �s quantidas de uns at� seis, ou seja, as laterais do placar. As outas posi��es s�o: 7 - full hand; 8 - sequencia; 9 - quadra; e 10 - quina
	 * @param dados - um array de inteiros, de tamanho 5. 
	 * Cada posi��o corresponde a um valor de um dado. 
	 * Sup�es-se que cada dado pode ter valor entre 1 e 6.
	 * @throws java.lang.IllegalArgumentException - - Se a posi��o estiver ocupada ou se for passado um valor de posi��o inv�lido, essa exce��o � lan�ada.
	 * N�o � feita nenhuma verifica��o quanto ao tamanho do array nem quanto ao seu conte�do.
	 */	
	public void add(int posicao, int[]dados){
		int[] hash = new int[10];
		
		if(posicao > 10 || posicao < 1)
			throw new IllegalArgumentException();
		
		for(int i = 0; i < 10; i++)
			hash[i] = 0;
		
		switch(posicao){
		case 1:
			for(int i = 0; i < dados.length; i++) 
				if(dados[i] == 1) 
					score[0] += 1;
			
			if (dadosPosicao[0])
				throw new IllegalArgumentException();
			
			dadosPosicao[0] = true;
			
			break;
		case 2:
			for(int i = 0; i < dados.length; i++) 
				if(dados[i] == 2) 
					score[1] += 2;
			
			if (dadosPosicao[1])
				throw new IllegalArgumentException();
			
			dadosPosicao[1] = true;
			
			break;
		case 3:
			for(int i = 0; i < dados.length; i++) 
				if(dados[i] == 3) 
					score[2] += 3;
			
			if (dadosPosicao[2])
				throw new IllegalArgumentException();
			
			dadosPosicao[2] = true;
			
			break;
		case 4:
			for(int i = 0; i < dados.length; i++) 
				if(dados[i] == 4) 
					score[3] += 4;
			
			if (dadosPosicao[3])
				throw new IllegalArgumentException();
			
			dadosPosicao[3] = true;
			
			break;
		case 5:
			for(int i = 0; i < dados.length; i++) 
				if(dados[i] == 5) 
					score[4] += 5;
			
			if (dadosPosicao[4])
				throw new IllegalArgumentException();
			
			dadosPosicao[4] = true;
			
			break;
		case 6:
			for(int i = 0; i < dados.length; i++) 
				if(dados[i] == 6) 
					score[5] += 6;
			
			if (dadosPosicao[5])
				throw new IllegalArgumentException();
			
			dadosPosicao[5] = true;
			
			break;
		case 7:
			for(int i = 0; i < dados.length; i++) 
				hash[dados[i]-1]++;
			
			for(int i = 0; i < dados.length; i++){
				if(hash[i] == 2) 
					for(int j = 0; j < dados.length; j++) 
						if(hash[j] == 3) 
							score[6] = 15;
			}
			
			if (dadosPosicao[6])
				throw new IllegalArgumentException();
			
			dadosPosicao[6] = true;
			
			break;
		case 8:
			for(int i = 0; i < dados.length; i++) 
				hash[dados[i]-1]++;
			
			if((hash[0]==1 || hash[5]==1) && (hash[1]==1 && hash[2]==1 && hash[3]==1 && hash[4]==1))
				score[7] = 20;
			
			if (dadosPosicao[7])
				throw new IllegalArgumentException();
			
			dadosPosicao[7] = true;
			
			break;
		case 9:
			for(int i = 0; i < dados.length; i++) 
				hash[dados[i]-1]++;
			
			for(int i = 0; i < dados.length; i++) 
				if(hash[i] == 4) 
					score[8] = 30;
			
			if (dadosPosicao[8])
				throw new IllegalArgumentException();
			
			dadosPosicao[8] = true;
			
			break;
		case 10:
			for(int i = 0; i < dados.length; i++) 
				hash[dados[i]-1]++;
			
			for(int i = 0; i < dados.length; i++) 
				if(hash[i] == 5) 
					score[9] = 40;
			
			if (dadosPosicao[9])
				throw new IllegalArgumentException();
			
			dadosPosicao[9] = true;
			
			break;
		}
	}
	/**
	 * Computa a soma dos valores obtidos, considerando apenas as posi��es que j� est�o ocupadas.
	 * @return - O valor da soma.
	 */
	public int getScore() {
		int scoreTotal = 0;
		
		for(int i = 0; i < 10; i++) 
			scoreTotal += score[i];
		
		return scoreTotal;
	}
	/**
	 * A representa��o na forma de string, mostra o placar completo, indicando quais s�o as posi��es livres (com seus respectivos n�meros) e o valor obtido nas posi��es j� ocupadas.
	 * Por exemplo: 
	 * (1)    |   (7)    |   (4) 
	 * --------------------------
	 * (2)    |   20     |   (5) 
	 * --------------------------
	 * (3)    |   30     |   (6) 
	 * --------------------------
	 *        |   (10)   |
	 *        +----------+ 
	 *        
	 *mostra as posi��es 8 (sequencia) e 9 (quadra) ocupadas.
	 *@override toString in class java.lang.Object
	 */
	@Override
	public String toString() {
		String s = "\n\n";

		getScore();
		
		s += (!dadosPosicao[0]) ? "  (1)  " : "   "+ score[0] +"   ";
		s += " | ";
		s += (!dadosPosicao[6]) ? "  (7)  " : "   "+ score[6] +"   ";
		s += " | ";
		s += (!dadosPosicao[3]) ? "  (4)  " : "   "+ score[3] +"   ";
		s += "\n";
		s += "---------------------------\n";
		s += (!dadosPosicao[1]) ? "  (2)  " : "   "+ score[1] +"   ";
		s += " | ";
		s += (!dadosPosicao[7]) ? "  (8)  " : "   "+ score[7] +"   ";
		s += " | ";
		s += (!dadosPosicao[4]) ? "  (5)  " : "   "+ score[4] +"   ";
		s += "\n";
		s += "---------------------------\n";
		s += (!dadosPosicao[2]) ? "  (3)  " : "   "+ score[2] +"   ";
		s += " | ";
		s += (!dadosPosicao[8]) ? "  (9)  " : "   "+ score[8] +"   ";
		s += " | ";
		s += (!dadosPosicao[5]) ? "  (6)  " : "   "+ score[5] +"   ";
		s += "\n";
		s += "---------------------------\n";
		s += (!dadosPosicao[9]) ? "        |   (10)  |" : "      |  "+ score[9] +"  |";
		s += "\n";
		s += "        +---------+ \n\n";
	
		return s;
	}
	
}
