import java.util.Random;

public class Sort <Integer extends Comparable<Integer>>{

  Random random = new Random();

  public int[] geraVetor(int tam){
    int vetor[] = new int[tam];
    for(int i=0;i<tam;i++){
      vetor[i]=i;
    }//fim do for
    return vetor;
  }//fim do metodo

  public int[] desordenar(int vetor[], int tam){
    int aux=0, aux2=0, aux3=0;
    for(int i=0; i<(tam/2); i++){
      aux=0+random.nextInt(tam);
      aux2=0+random.nextInt(tam);
      aux3=vetor[aux];
      vetor[aux]=vetor[aux2];
      vetor[aux2]=aux3;
    }//fim do for
    return vetor;
  }//fim do metodo

  public void imprimir(int vetor[],int tam){
    String srt = "";
    for (int i=0;i<tam;i++){
      srt+="["+vetor[i]+"] ";
    }//fim do for
    System.out.println(srt);
  }//fim do metodo

  public void bubbleSort(int vetor[], int tam){
    int aux=0;
    for(int i=0; i<tam; i++){
      for(int j=0; j<tam-1; j++){
        if(vetor[j] > vetor[j+1]){
          aux=vetor[j];
          vetor[j]=vetor[j+1];
          vetor[j+1]=aux;
        }//fim do if
      }//fim do for
    }//fim do for
  }//fim do metodo

  public void insertSort(int vetor[], int tam){
    int atual=0, aux=0, j=0;
    for(int i=0; i<tam;i++){
      atual=vetor[i];
      for(j=i-1; j>=0;j--){
        if(atual<vetor[j]){
          vetor[j+1]=vetor[j];
        }//fim do if
        else{
          break;
        }//fim do else
      }//fim do for
      vetor[j+1]=atual;
    }//fim do for
  }//fim do metodo

  public void selectionSort(int vetor[], int tam){
    int aux=0, posicao=0;
    for(int i=0; i<tam;i++){
      posicao=i;
      for(int j=i; j<tam;j++){
        if(vetor[j]<vetor[posicao]){
            posicao=j;
          }//fim do if
          aux=vetor[i];
          vetor[i]=vetor[posicao];
          vetor[posicao]=aux;
      }//fim do for
    }//fim do for
  }//fim do metodo

    public void shellSort(int vetor[], int tam){
    long tempoInicial = System.currentTimeMillis();
    int i, j, h=1, value;
    do{
      h=3*h+1;
    }//fim do doWhile
    while(h<tam);
    do{
      h=h/3;
      for(i=h;i<tam;i++){
        value=vetor[i];
        j=i-h;
        while(j>=0 && value<vetor[j]){
          vetor[j+h]=vetor[j];
          j=j-h;
        }//fim do while
        vetor[j+h]=value;
      }//fim do for
    }while(h>1);
    long tempoFinal = System.currentTimeMillis();
    System.out.printf("%.3f ms%n", (tempoFinal - tempoInicial) / 1000d);
  }//fim do metodo

  public void buildMaxHeap(int vetor[], int size) {
    if(size>vetor.length) {
      size = vetor.length;
    }//fim do if
    for(int i=size/2; i>0; i--) {
      maxHeapify(vetor, i, size);
    }//fim do for
  }//fim do metodo

  public void mergeSort(int vetor[], int inicio, int fim){
    int meio;
    if(inicio<fim){
      meio=(inicio+fim)/2;
      mergeSort(vetor, inicio, meio);
      mergeSort(vetor, meio+1, fim);
      merge(vetor, inicio, meio, fim);
    }//fim do if
  }//fim do metodo

  public void merge(int vetor[], int inicio, int meio, int fim) {
		int auxiliar[] = new int [vetor.length];
		for (int i=inicio; i<=fim; i++) {
			auxiliar[i] = vetor[i];
		}//fim do for
		int i = inicio;
		int j = meio + 1;
		int k = inicio;
		while (i<=meio && j<=fim) {
			if (auxiliar[i]<auxiliar[j]) {
				vetor[k]=auxiliar[i];
				i++;
			}//fim do if 
			else {
				vetor[k]=auxiliar[j];
				j++;
			}//fim do else
			k++;
		}//fim do while
		while (i<=meio) {
			vetor[k]=auxiliar[i];
			i++;
			k++;
		}//fim do while
		while (j<=fim) {
			vetor[k]=auxiliar[j];
			j++;
			k++;
		}//fim do while
	}//fim do metodo

	public void quickSort(int vetor[], int inicio, int fim){
		if (inicio<fim) {
			int posicao = separar(vetor, inicio, fim);
			quickSort(vetor, inicio, posicao-1);
			quickSort(vetor, posicao+1, fim);	
		}//fim do if
	}//fim do metodo

	public int separar(int[] vetor, int inicio, int fim) {
		int posicao=vetor[inicio];
		int i=inicio+1, f=fim;
		while (i<=f) {
			if (vetor[i]<=posicao){
				i++;
			}//fim do if
			else if (posicao<vetor[f]){
				f--;
			}//fim do else if
			else {
				int troca=vetor[i];
				vetor[i]=vetor[f];
				vetor[f]=troca;
				i++;
				f--;	
			}//fim do else
		}//fim do while
		vetor[inicio]=vetor[f];
		vetor[f]=posicao;
		return f;
		}//fim do metodo

    public void maxHeapfy(int vetor[], int indice, int size){
      int esquerda=indice*2;
      int direita=esquerda+1;
      int maior;
      if(esquerda<=size && vetor[esquerda-1]>vetor[indice-1]) {
        maior=esquerda;
      }//fim do if
      else{
        maior=indice;
      }//fim do else
      if(direita<=size && vetor[direita-1]>vetor[maior-1]) {
        maior=direita;
      }//fim do if
      if(maior!=indice) {
        int temp=vetor[indice - 1];
        vetor[indice-1] = vetor[maior-1];
        vetor[maior-1] = temp;
        maxHeapify(vetor, maior, size);
      }//fim do if
    }//fim do metodo

    public void montarHeap(int vetor[], int size){
      int i=size/2;

    }//fim do metodo

    public void heapSort(int vetor[]){
      int size=vetor.length;
      montarHeap(vetor, size);
      for(int i=size-1; i>0; i--) {
        int temp = vetor[0];
        vetor[0] = vetor[i];
        vetor[i] = temp;
        maxHeapify(vetor, 1, i);
      }//fim do for
    }//fim do metodo

}//fim da classe