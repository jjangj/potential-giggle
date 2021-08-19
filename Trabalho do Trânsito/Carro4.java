/* ***************************************************************
* Classe: Carro4
* Funcao: Modela o comportamento do carro4
*************************************************************** */

public class Carro4 extends Thread{

  CityPanel city;
  private int velocidade;

/* ***************************************************************
* Metodo: Carro4
* Funcao: Inicializar os atributos da classe.
*************************************************************** */
  public Carro4(CityPanel city){
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
      city.mutexR2.acquire();
      while(true){
        down(370, 100);
        change1();
        city.mutexR2.release();//SAIR REGIAO CRITICA 2
        right(200, 153);
        city.mutexR3.acquire(); //ENTRAR REGIAO CRITICA 3
        right(300, 200);
        city.mutexR3.release(); //SAIR REGIAO CRITICA 3
        right(550, 300);
        city.mutexR4.acquire(); //ENTRAR REGIAO CRITICA 4
        change2();
        up1();
        city.mutexR1.acquire(); //ENTRAR REGIAO CRITICA 1
        change3();
        left(430, 575);
        city.mutexR1.release(); //SAIR REGIAO CRITICA 1
        left(315, 430);
        city.mutexR2.acquire(); //ENTRAR REGIAO CRITICA 2
        city.mutexR4.release(); //SAIR REGIAO CRITICA 4
        change4();
        up2();
        change5();
        left2();
        change6();
      }//fim do while
    }//fim do try
    catch(Exception e){}
  }//fim do metodo

/* ***************************************************************
* Metodo: up1
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void up1(){
    int posicao=0;
    if(city.car44C.getX()>=605 && city.car44C.getY()<=350){
      posicao=city.car44C.getY();
      for(int i = posicao; i>=285; i--){
        city.car44C.setBounds(city.car44C.getX(), i, 40, 77);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: up2
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void up2(){
    int posicao=0;
    if(city.car44C2.getX()>=290 && city.car44C2.getY()<=235){
      posicao=city.car44C2.getY();
      for(int i = posicao; i>=100; i--){
        city.car44C2.setBounds(city.car44C2.getX(), i, 40, 77);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: left2
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
    public void left2(){
    int posicao=0;
    if(city.car44E2.getX()>=280 && city.car44E2.getY()<=100){
      posicao=city.car44E2.getX();
      for(int i = posicao; i>=153; i--){
        city.car44E2.setBounds(i, city.car44E2.getY(), 77, 40);
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
    if(city.car44B.getX()>=153 && city.car44B.getY()<=y){
      posicao=city.car44B.getY();
      for(int i = posicao; i<=distance; i++){
        city.car44B.setBounds(city.car44B.getX(), i, 40, 77);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: right
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void right(int distance, int x){
    int posicao=0;
    if(x==153){
      if(city.car44D.getX()>=x && city.car44D.getY()<=400){
        posicao=x;
        for(int i = posicao; i<=distance; i++){
          city.car44D.setBounds(i, city.car44D.getY(), 77, 40);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else if(x==183){
      if(city.car44D.getX()>=x && city.car44D.getY()<=400){
        posicao=x;
        for(int i = posicao; i<=distance; i++){
          city.car44D.setBounds(i, city.car44D.getY(), 77, 40);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else if
    else{
      if(city.car44D.getX()>=x && city.car44D.getY()<=400){
        posicao=x;
        for(int i = posicao; i<=distance; i++){
          city.car44D.setBounds(i, city.car44D.getY(), 77, 40);
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
    if(x==575){
      if(city.car44E.getX()>=x && city.car44E.getY()<=261){
        posicao=x;
        for(int i = posicao; i>=distance; i--){
          city.car44E.setBounds(i, city.car44E.getY(), 77, 40);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do if
    else{
      if(city.car44E.getX()>=x && city.car44E.getY()<=261){
        posicao=x;
        for(int i = posicao; i>=distance; i--){
          city.car44E.setBounds(i, city.car44E.getY(), 77, 40);
          try{
          sleep(1*velocidade);
          }//fim do try
          catch(Exception e){}
        }//fim do for
      }//fim do if
    }//fim do else
  }//fim do metodo

/* ***************************************************************
* Metodo: change1
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change1(){
    city.car44B.setVisible(false);
    city.car44D.setVisible(true);
    city.car44B.setBounds(153, 100, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change2
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change2(){
    city.car44D.setVisible(false);
    city.car44C.setVisible(true);
    city.car44D.setBounds(153, 400, 77, 40);
  }//fim do metodo

/* ***************************************************************
* Metodo: change3
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change3(){
    city.car44C.setVisible(false);
    city.car44E.setVisible(true);
    city.car44C.setBounds(605, 345, 40, 77);
  }//fim do metodo 

/* ***************************************************************
* Metodo: change4
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change4(){
    city.car44E.setVisible(false);
    city.car44C2.setVisible(true);
    city.car44E.setBounds(575, 261, 77, 40);
  }//fim do metodo

/* ***************************************************************
* Metodo: change5
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change5(){
    city.car44C2.setVisible(false);
    city.car44E2.setVisible(true);
    city.car44C2.setBounds(290, 235, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change6
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change6(){
    city.car44E2.setVisible(false);
    city.car44B.setVisible(true);
    city.car44E2.setBounds(280, 100, 77, 40);
  }//fimd do metodo

}//fim da classe