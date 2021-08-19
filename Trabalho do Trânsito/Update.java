/* ***************************************************************
* Classe: Update
* Funcao: Evitar que as animações dos carros travem durante a 
* execução no sistema operacional linux.
*************************************************************** */

public class Update extends Thread{

  City city;

  public Update(City c){
    city=c;
  }//fim do metodo

  public void run(){
    while(true){
      city.repaint();
    }//fim do while
  }//fim do run
}//fim da classe
