public class Principal{
	
	public static void main(String args[]){

		int tam=100;
		int vetor[] = new int[tam];
		Sort s = new Sort();
		vetor=s.geraVetor(tam);
		s.imprimir(vetor,tam);
		s.desordenar(vetor, tam);
		s.imprimir(vetor,tam);
		//s.selectionSort(vetor, tam);
		//s.insertSort(vetor, tam);
		//s.bubbleSort(vetor, tam);
		//s.shellSort(vetor, tam);
		//s.mergeSort(vetor, 0, tam-1);
		s.quickSort(vetor, 0, tam-1);
		s.imprimir(vetor, tam);
	}
	
}//fim da classe
