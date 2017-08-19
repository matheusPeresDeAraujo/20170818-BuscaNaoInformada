

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BuscaNaoInformada {
	
	public static void main(String[] args) {
		
		// 1 Nomes das cidades posicional
		String[] cidades = new String[]{
				"Arad", "Bucharest", "Craiova", "Dobreta", "Eforie",
				"Fagaras", "Giurgiu", "Hirsova", "Iasi", "Lugoj", 
				"Mehadia", "Neamt", "Oradea", "Pitesti", "Rimnicu Vilcea",
				"Sibiu", "Timisoara", "Urziceni", "Vaslui", "Zerind"
		};
		
		int[][] distancias = new int[][] {
			// "Arad", "Bucharest", "Craiova", "Dobreta", "Eforie",
			{    0,   -1,   -1,  -1,    -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  140,  118,   -1,   -1,    75},
			{   -1,   0,    -1,  -1,    -1,  211,   90,   -1,   -1,   -1,   -1,   -1,   -1,  101,   -1,   -1,   -1,   85,   -1,    -1},
			{   -1,   -1,    0, 120,    -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  138,  146,   -1,   -1,   -1,   -1,    -1},
			{   -1,   -1,  120,   0,    -1,   -1,   -1,   -1,   -1,   -1,   75,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    -1},
			{   -1,   -1,   -1,   -1,    0,   -1,   -1,   86,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    -1},
			{   -1,  211,   -1,   -1,   -1,   0,   -1,    -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   99,   -1,   -1,   -1,    -1},
			{   -1,   90,   -1,   -1,   -1,   -1,   0,    -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    -1},
			{   -1,   -1,   -1,   -1,   86,   -1,   -1,    0,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   98,   -1,    -1},
			{   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    0,   -1,   -1,   87,   -1,   -1,   -1,   -1,   -1,   -1,   92,    -1},
			{   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    0,   70,   -1,   -1,   -1,   -1,   -1,  111,   -1,   -1,    -1},
			{   -1,   -1,   -1,   75,   -1,   -1,   -1,   -1,   -1,   70,    0,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    -1},
			{   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   87,   -1,   -1,    0,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    -1},
			{   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   0,    -1,   -1,  151,   -1,   -1,   -1,    71},
			{   -1,  101,  138,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,    0,   97,   -1,   -1,   -1,   -1,    -1},
			{   -1,   -1,  146,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   97,    0,    80,  -1,   -1,   -1,    -1},
			{  140,   -1,   -1,   -1,   -1,   99,   -1,   -1,   -1,   -1,   -1,   -1,  151,   -1,   80,    0,   -1,   -1,   -1,    -1},
			{  118,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  111,   -1,   -1,   -1,   -1,   -1,   -1,    0,   -1,   -1,    -1},
			{   -1,   85,   -1,   -1,   -1,   -1,  98,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,     0,  142,    -1},
			{   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   92,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,  142,    0,    -1},	
			{   75,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   -1,   71,   -1,   -1,   -1,   -1,   -1,   -1,     0}			
		};
		
		
		
		
		int origem = 12; // Arad
		
		int destino = 10; // Bucareste
		
		buscaEmLargura(origem, destino, distancias, cidades);
		
	}
	
	public static void buscaEmLargura(int origem, int destino, int[][] distancias, String[] cidades){
		
		//Tabela de caminho utilizado e de onde saiu rota mais curta
		int result[][] = new int[][]{{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
			{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}};
			
		
		// 1 - Inicia a Borda
		LinkedList<Integer> fila = new LinkedList<>();
		
		// 2 - Adiciona o estado inicialo na borda.
		fila.addLast(origem);
		result[0][origem] = 0;
		result[1][origem] = -1;
		// 3 - Repetir até encontrar a solução
		for (;;){
			
			// 3.1 Se a fila acabar, não encontramos a solução.
			if (fila.isEmpty()) {
				System.out.println("Solução não encontrada!");
				return;
			}
			
			// 3.2 Pega o próximo da fila.
			
			int no = fila.removeFirst();
			
			System.out.println("Visitando "+ cidades[no]);
			
			// 3.3 Se é o destino, problema resolvido!
			if (no == destino) {
				System.out.println("Solução encontrada!");
				rota(result, cidades, no);
				return;
			} else {
				// 3.4 se não é, adiciona na fila.
				for (int i = 0; i < distancias.length; i++) {
					
					if (distancias[no][i] > 0) {
						if(result[0][i] == -1 || distancias[no][i]+result[0][no] < result[0][i]) {
							fila.addLast(i);
							//Define qual o caminho anterior para chegar neste local
							result[0][i] = distancias[no][i]+result[0][no];
							result[1][i] = no;
						}
					}
					
				}
			}
		}
		
	}
	
	public static void rota(int[][] result, String[] cidades, int no){

		System.out.println("\n\nKm necessário para o objetivo: "+ result[0][no]);
		System.out.println("\nA rota é:");
		System.out.println(cidades[no]);
		for(;;){
			if(result[1][no] != -1) {
				System.out.println((cidades[result[1][no]]));
				no = result[1][no];
			}else {
				return;
			}
		}
	}

}