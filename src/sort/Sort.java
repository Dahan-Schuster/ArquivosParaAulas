package sort;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * @author Dahan Schuster
 *
 */
public class Sort {
	/**
	 * <h1>Passos para rearranjo de um array com o método Bubble</h1>
	 * <hr>
	 * <ol style="font-size:14pt;" >
	 *  <li>Percorrer o array até achar uma sequencia {x, y} tal que x > y<br></li>
	 * 	<li>Trocar x e y de posição<br></li>
	 *	<li>Continuar pecorrendo, procurando e trocando até o final do array<br></li>
	 *	<li>Reinicar a iteração<br></li>
	 *	<li>Repetir estes passos até a iteração não realizar nenhuma troca<br></li>
	 *	<li><b>Retornar</b> <i>Output<i></li>
	 *	</ol>
	 */
	public static ArrayList<Integer> bubble(ArrayList<Integer> arrayList) {
		ArrayList<Integer> outPut = arrayList;
		boolean isRepeticaoAtiva = true;
		
		while (isRepeticaoAtiva) {
			isRepeticaoAtiva = false;
			for (int i = 0; i < outPut.size(); i++) {
				
				try {
				
					int primeiraPosicao = i;
					int primeiroNumero = outPut.get(primeiraPosicao);
					
					int segundaPosicao = (i+1);
					int segundoNumero = outPut.get(segundaPosicao);
					
					if (primeiroNumero > segundoNumero) {
						outPut.set(segundaPosicao, primeiroNumero);
						outPut.set(primeiraPosicao, segundoNumero);
						
						isRepeticaoAtiva = true;
					}
				} catch (IndexOutOfBoundsException ex) {
					break;
				}
			}
		}
		
		return outPut;
	}
	
	public static ArrayList<String> bubbleVerboso(ArrayList<Integer> arrayList) {
		ArrayList<Integer> etapa = arrayList;
		ArrayList<String> output = new ArrayList<>(); 
		boolean isRepeticaoAtiva = true;

		output.add(Arrays.toString(etapa.toArray()) + ";" + "Primeira iteração;" );
		
		while (isRepeticaoAtiva) {
			isRepeticaoAtiva = false;
			
			for (int i = 0; i < etapa.size(); i++) {
				try {
				
					int primeiraPosicao = i;
					int primeiroNumero = etapa.get(primeiraPosicao);
					
					int segundaPosicao = (i+1);
					int segundoNumero = etapa.get(segundaPosicao);
					
					if (primeiroNumero > segundoNumero) {
						etapa.set(segundaPosicao, primeiroNumero);
						etapa.set(primeiraPosicao, segundoNumero);

						String corpoEtapa = Arrays.toString(etapa.toArray());
						String textoDescricao = "<html>"
								+ "Índice <u><font color=\"red\">" +
								primeiraPosicao +
								"<font></u>, valor <u><font color=\"blue\">" +
								primeiroNumero +
								"</font></u> movido para o índice <u><font color=\"red\">" +
								segundaPosicao + 
								"</font></u>.</html>";
						
						output.add(corpoEtapa + ";" +textoDescricao);
						
						isRepeticaoAtiva = true;
					}
				} catch (IndexOutOfBoundsException ex) {
					break;
				}
			}
		}
		
		return output;
	}
	
}



 