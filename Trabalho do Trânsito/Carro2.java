/* ***************************************************************
* Classe: Carro2
* Funcao: Modela o comportamento do carro2
*************************************************************** */

public class Carro2 extends Thread{

  CityPanel city;
  private int velocidade;

/* ***************************************************************
* Metodo: Carro2
* Funcao: Inicializar os atributos da classe.
*************************************************************** */
  public Carro2(CityPanel city){
    this.city=city;
    this.velocidade=34;
  }//fim do metodo

/* ***************************************************************
* Metodo: setVelocidade
* Funcao: Altera o valor do atributo velocidade.
* Parametros: velocidade(int). 
* Retorno: void
*************************************************************** */
  public void setVelocidade(int velocidade){
    this.velocidade=velocidade;
  }//fim do metodo

/* ***************************************************************
* Metodo: run
* Funcao: modela o comportamento da thead
* Retorno: void
*************************************************************** */
  @Override
  public void run(){
  	try{
  		while(true){
  			if(city.mutexR4.tryAcquire()){//ENTRAR REGIAO CRITICA 4
          if(city.mutexR5.tryAcquire()){ //ENTRA REGIAO CRITICA 5
          	change4();
  					up(430, 500);
  					city.mutexR3.acquire(); //ENTRAR REGIAO CRITICA 3
  					up(350, 430);
  					city.mutexR3.release(); //SAIR REGIAO CRITICA 3
  					up(260, 350);
 	 					change1();
 	 					city.mutexR5.release(); //SAIR REGIAO CRITICA 5
 	 					right(405, 300);
 	 					city.mutexR1.acquire(); //ENTRAR REGIAO CRITICA 1
 	 					right(590, 405);
 	 					change2();
            down(285,260);
 	 					city.mutexR1.release(); //SAIR REGIAO CRITICA 1
 	 					down(415, 285);
 	 					city.mutexR4.release(); //SAIR REGIAO CRITICA 4
 	 					down(500, 415);
            change3();
            left(320, 590);
  				}//fim do if
          else{
            city.mutexR4.release();
          }//fim do else
  			}//fim do if
  		}//fim do while
  	}//fim do try
  	catch(Exception e){}
  }//fim do metodo

/* ***************************************************************
* Metodo: up
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void up(int distance, int y){
    int posicao=0;
    if(y==500){
      if(city.car22C.getX()>=290 && city.car22C.getY()<=y){
        posicao=y;
        for(int i = posicao; i>=distance; i--){
          city.car22C.setBounds(city.car22C.getX(), i, 40, 77);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else if(y==430){	
    	if(city.car22C.getX()>=290 && city.car22C.getY()<=y){
        posicao=y;
        for(int i = posicao; i>=distance; i--){
          city.car22C.setBounds(city.car22C.getX(), i, 40, 77);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else if
    else{
      if(city.car22C.getX()>=290 && city.car22C.getY()<=y){
        posicao=y;
        for(int i = posicao; i>=distance; i--){
          city.car22C.setBounds(city.car22C.getX(), i, 40, 77);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else
  }//fim do metodo

  /* ***************************************************************
* Metodo: right
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void right(int distance, int x){
    int posicao=0;
    if(x==300){
      if(city.car22D.getX()>=x && city.car22D.getY()<=260){
        posicao=city.car22D.getX();
        for(int i = posicao; i<=distance; i++){
          city.car22D.setBounds(i, city.car22D.getY(), 77, 40);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else{
      if(city.car22D.getX()>=x && city.car22D.getY()<=260){
        posicao=city.car22D.getX();
        for(int i = posicao; i<=distance; i++){
          city.car22D.setBounds(i, city.car22D.getY(), 77, 40);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else
  }//fim do metodo

  /* ***************************************************************
* Metodo: down
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void down(int distance, int y){
    int posicao=0;
    if(y==260){
      if(city.car22B.getX()>=605 && city.car22B.getY()<=y){
        posicao=y;
        for(int i = posicao; i<=distance; i++){
          city.car22B.setBounds(city.car22B.getX(), i, 40, 77);
          try{
            sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else{
      if(city.car22B.getX()>=605 && city.car22B.getY()<=y){
        posicao=y;
        for(int i = posicao; i<=distance; i++){
          city.car22B.setBounds(city.car22B.getX(), i, 40, 77);
          try{
            sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else
  }//fim do metodo

  /* ***************************************************************
* Metodo: left
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void left(int distance, int x){
    int posicao=0;
    if(city.car22E.getX()>=x && city.car22E.getY()<=543){
      posicao=city.car22E.getX();
      for(int i = posicao; i>=distance; i--){
        city.car22E.setBounds(i, city.car22E.getY(), 77, 40);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: change1
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change1(){
  	city.car22C.setVisible(false);
  	city.car22D.setVisible(true);
  	city.car22C.setBounds(290, 500, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change2
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change2(){
  	city.car22D.setVisible(false);
  	city.car22B.setVisible(true);
  	city.car22D.setBounds(300, 260, 77, 40);
  }//fim do metodo

/* ***************************************************************
* Metodo: change3
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change3(){
  	city.car22B.setVisible(false);
  	city.car22E.setVisible(true);
  	city.car22B.setBounds(605, 260, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change4
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change4(){
  	city.car22E.setVisible(false);
  	city.car22C.setVisible(true);
  	city.car22E.setBounds(590, 543, 77, 40);
  }//fim do metodo

}//fim da classe