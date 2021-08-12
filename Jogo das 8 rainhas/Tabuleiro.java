/* ***************************************************************
* Classe: Tabuleiro
* Funcao: Achar todas as possibilidades de disposicoes das rainhas
* no jogo das 8 rainhas usando backtracking.
*************************************************************** */

public class Tabuleiro{

	private int sol; //numero de solucoes
	private int N; //Numero de rainhas

	/****************************************************************
  * Metodo: Tabuleiro
  * Funcao: Inicializa todos os atributos e variaveis da classe
  * Parametros: -
  * Retorno: -
  ****************************************************************/
	public Tabuleiro(){
		this.sol = 0;
		this.N = 8;
	}//fim do construtor

	/****************************************************************
  * Metodo: executar
  * Funcao: Executa o algoritmo usando o backtracking
  * Parametros: int tab[][], int col
  * Retorno: void
  ****************************************************************/
	public void executar(int tab[][], int col){
		int aux = 0;
		if(col == N){
			aux = sol + 1;
			System.out.print("Solucao " + aux + ":\n\n");
			mostrarTabuleiro(tab);
			sol++;
			return;
		}//fim do if

		for(int i = 0; i < N; i++){
			if(seguro(tab, i, col)){
				tab[i][col] = 1; // insere a rainha
				executar(tab, col + 1);
				tab[i][col] = 0; //bactracking
			}//fim do if
		}//fim do for
	}//fim do metodo executar

	/****************************************************************
  * Metodo: mostrarTabuleiro
  * Funcao: Exibe o tabuleiro para o usuario
  * Parametros: int tab[][]
  * Retorno: void
  ****************************************************************/
	public void mostrarTabuleiro(int tab[][]){
	for(int i = 0; i < N; i++){
		for(int j = 0; j < N; j++){
			if(tab[i][j] == 1){
				System.out.print("R\t");
      }//fim do if
			else{
				System.out.print("*\t");
      }//fim do else
		}//fim do else
		System.out.print("\n\n");
	}//fim do for
	System.out.print("\n");
}//fim da funcao

	/****************************************************************
  * Metodo: seguro
  * Funcao: Verifica se e seguro colocar uma rainhas em determinada
  * posicao.
  * Parametros: int tab[][], int lin, int col
  * Retorno: boolean
  ****************************************************************/
	public boolean seguro(int tab[][], int lin, int col){
		int i, j;

		//verifica se ocorre ataque na linha
		for(i = 0; i < N; i++){
			if(tab[lin][i] == 1){
				return false;
	    }//fim do if
		}//fim do for

		//verifica se ocorre ataque na coluna
		for(i = 0; i < N; i++){
			if(tab[i][col] == 1){
				return false;
	    }//fim do if
		}//fim do for

		//verifica se ocorre ataque na diagonal principal
		for(i = lin, j = col; i >= 0 && j >= 0; i--, j--){
			if(tab[i][j] == 1){
				return false;
	    }//fim do if
		}//fim do for

		for(i = lin, j = col; i < N && j < N; i++, j++){
			if(tab[i][j] == 1){
				return false;
	    }//fim do if
		}//fim do for

		//verifica se ocorre ataque na diagonal secundaria
		for(i = lin, j = col; i >= 0 && j < N; i--, j++){
			if(tab[i][j] == 1){
				return false;
	    }//fim do if
		}//fim do for
		for(i = lin, j = col; i < N && j >= 0; i++, j--){
			if(tab[i][j] == 1){
				return false;
	    }//fim do if
		}//fim do for

		return true;
	}//fim da funcao
	
}//fim da classe tabuleiro