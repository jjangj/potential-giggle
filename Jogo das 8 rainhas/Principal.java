/* ***************************************************************
* Autor: Jenifer Jang
* Inicio: 16/08/2018
* Ultima alteracao: 09/08/2018
* Nome: Problema das 8 rainhas.
* Funcao: O algoritmo mostra todas as disposições de peças possiveis
* em um tabuleiro com 8 rainhas usando o algoritmo de backtracking
*************************************************************** */

public class Principal{
	public static void main(String a[]){

		//Criacao de uma matriz 8x8 para simular o tabuleiro
		int tab[][] = new int[8][8];
		for(int i = 0; i<8; i++){
			for(int j = 0; j<8; j++){
				tab[i][j] = 0;
			}//fim do for
		}//fim do for

		Tabuleiro tabuleiro = new Tabuleiro();
		tabuleiro.executar(tab, 0);
	}//fim da main
}//fim da classe Principal
