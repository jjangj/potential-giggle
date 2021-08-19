/* ***************************************************************
* Classe: Carro3
* Funcao: Modela o comportamento do carro3
*************************************************************** */

public class Carro3 extends Thread{

  CityPanel city;
  private int velocidade;

/* ***************************************************************
* Metodo: Carro3
* Funcao: Inicializar os atributos da classe.
*************************************************************** */
  public Carro3(CityPanel city){
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
  			up(420, 490);
  			city.mutexR2.acquire(); //ENTRAR REGIAO CRITICA 2
  			up(120, 420);
  			change1();
  			right(280, 153);
  			change2();
  			down(230, 100);
  			city.mutexR5.acquire(); //ENTRAR REGIAO CRITICA 5
        down(280, 230);
        city.mutexR2.release(); //SAIR REGIAO CRITICA 2
  			down(350, 280);
  			city.mutexR3.acquire(); //ENTRAR REGIAO CRITICA 3
  			down(500, 350);
  			city.mutexR3.release(); //SAIR REGIAO CRITICA 3
  			down(530, 500);
  			change3();
        left(227, 230);
  			city.mutexR5.release(); //SAIR REGIAO CRITICA 5
        left(143, 227);
        change4();
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
    if(y==590){
      if(city.car33C.getX()>=153 && city.car33C.getY()<=y){
        posicao=y;
        for(int i = posicao; i>=distance; i--){
          city.car33C.setBounds(city.car33C.getX(), i, 40, 77);
          try{
            sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else{
      if(city.car33C.getX()>=153 && city.car33C.getY()<=y){
        posicao=y;
        for(int i = posicao; i>=distance; i--){
          city.car33C.setBounds(city.car33C.getX(), i, 40, 77);
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
    if(city.car33D.getX()>=x && city.car33D.getY()<=100){
      posicao=city.car33D.getX();
      for(int i = posicao; i<=distance; i++){
        city.car33D.setBounds(i, city.car33D.getY(), 77, 40);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: down
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void down(int distance, int y){
    int posicao=0;
    if(y==100){
      if(city.car33B.getX()>=290 && city.car33B.getY()<=y){
        posicao=y;
        for(int i = posicao; i<=distance; i++){
          city.car33B.setBounds(city.car33B.getX(), i, 40, 77);
          try{
            sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else if(y==250){
      if(city.car33B.getX()>=290 && city.car33B.getY()<=y){
        posicao=y;
        for(int i = posicao; i<=distance; i++){
          city.car33B.setBounds(city.car33B.getX(), i, 40, 77);
          try{
            sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else if
    else if(y==350){
      if(city.car33B.getX()>=290 && city.car33B.getY()<=y){
        posicao=y;
        for(int i = posicao; i<=distance; i++){
          city.car33B.setBounds(city.car33B.getX(), i, 40, 77);
          try{
            sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else if
    else{
      if(city.car33B.getX()>=290 && city.car33B.getY()<=y){
      posicao=y;
      for(int i = posicao; i<=distance; i++){
        city.car33B.setBounds(city.car33B.getX(), i, 40, 77);
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
    if(city.car33E.getX()>=x && city.car33E.getY()<=545){
      posicao=city.car33E.getX();
      for(int i = posicao; i>=143; i--){
        city.car33E.setBounds(i, city.car33E.getY(), 77, 40);
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
  	city.car33C.setVisible(false);
  	city.car33D.setVisible(true);
  	city.car33C.setBounds(153, 490, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change2
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change2(){
  	city.car33D.setVisible(false);
  	city.car33B.setVisible(true);
  	city.car33D.setBounds(153, 100, 77, 40);
  }//fim do metodo

/* ***************************************************************
* Metodo: change3
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change3(){
  	city.car33B.setVisible(false);
  	city.car33E.setVisible(true);
  	city.car33B.setBounds(290, 100, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change4
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change4(){
  	city.car33E.setVisible(false);
  	city.car33C.setVisible(true);
  	city.car33E.setBounds(230, 545, 77, 40);
  }//fim do metodo

}//fim da classe
