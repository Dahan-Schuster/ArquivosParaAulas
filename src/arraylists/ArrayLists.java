package arraylists;

import java.util.ArrayList;

public class ArrayLists {
	
	private static ArrayList<String> linguagens;
	
	public static void main(String[] args) {
		linguagens = new ArrayList<String>();
		
		adicionarDados();
		lerDados();
		alterarDados();
		lerDados();
		removerDadosPorIndice(0);
		lerDados();
		verificarTamanho();
		limparTodosDados();
		verificarTamanho();
		
	}
	
	private static void adicionarDados() {
		linguagens.add("Java");
		// TODO Completar ArrayList com dados sugeridos
	}
	
	private static void lerDados() {
		// TODO block try-catch
		// TODO Percorrer o ArrayList com o loop For
		for (int i = 0; i < linguagens.size(); i++) {
			System.out.println("Valor do índice " + i + ": " + linguagens.get(i));
		}
		
	}
	
	private static void alterarDados() {
		// TODO block try-catch
		// TODO Alterar dados sugeridos
		
	}

	private static void removerDadosPorIndice(int indice) {
		// TODO block try-catch
		System.out.println("Removendo índice "+ indice + "...");
		linguagens.remove(indice);
		
	}

	private static void verificarTamanho() {
		System.out.println("Tamanho atual: " + linguagens.size());
		
	}

	private static void limparTodosDados() {
		linguagens.clear();
	}




	
	


}


