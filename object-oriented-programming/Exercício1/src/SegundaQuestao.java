// Erick Barcelos | NUSP: 11345562

public class SegundaQuestao {

	public static void main(String[] args){
		// Leitura dos valores
		System.out.println("Valor de A: ");
		double a = lerValores(); // Fun��o para tratar das exce��es
		
		System.out.println("Valor de B: ");
		double b = lerValores();
		
		System.out.println("Valor de C: ");
		double c = lerValores();
		
		double resultado = b*b - 4.0*a*c; // Calculando o delta
		
		if (resultado > 0.0) { // Caso seja maior que zero
			// Calcula as raizes
			double raiz1 = (-b + Math.pow(resultado, 0.5)) / (2.0*a);
			double raiz2 = (-b - Math.pow(resultado, 0.5)) / (2.0*a);
			
			System.out.println("As raizes s�o " + raiz1 + " e " + raiz2);
		} else if (resultado == 0.0){ // Caso seja igual a zero
			// Calcula a raiz
			double raiz = -b/(2.0*a);
			
			System.out.println("A raiz � " + raiz);
		} else { // N�o possui raizes reais
			System.out.println("A equa��o n�o possui raizes reais.");
		}
		
	}
	
	// Fun��o para tratar as exce��es
	public static double lerValores() {
		double x = 0;
		boolean leu = false; // booleano para verificar se foi digitado um n�mero
		
		while(!leu)
		{
			leu = true;
			try {
				x = EntradaTeclado.leDouble();	
			} catch(Exception e) { 
				System.out.println("O valor � invalido, digite um valor correto: ");
				leu = false;
			}
		}
	
		return x;
	}
}
