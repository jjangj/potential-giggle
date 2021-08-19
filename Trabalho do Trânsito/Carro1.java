public class Carro1 extends Thread{

  CityPanel city;
  private int velocidade;

/* ***************************************************************
* Metodo: Carro1
* Funcao: Inicializar os atributos da classe.
*************************************************************** */
  public Carro1(CityPanel city){
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
      	down(200, 100);
      	city.mutexR1.acquire(); //ENTRAR REGIAO CRITICA 1
      	change1();
      	left(460, 565);
      	change2();
      	city.mutexR1.release(); //SAIR REGIAO CRITICA 1
      	up(120, 220);
      	change3();
      	right(590, 460);
      	change4();
      }//fim do while
    }//fim do try
    catch(Exception e){}
  }//fim do run

/* ***************************************************************
* Metodo: down
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void down(int distance, int y){
    int posicao=0;
    if(city.car11B.getX()>=605 && city.car11B.getY()<=y){
      posicao=city.car11B.getY();
      for(int i = posicao; i<=distance; i++){
        city.car11B.setBounds(city.car11B.getX(), i, 40, 77);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: left
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void left(int distance, int x){
    int posicao=0;
    if(city.car11E.getX()>=x && city.car11E.getY()<=262){
      posicao=city.car11E.getX();
      for(int i = posicao; i>=distance; i--){
        city.car11E.setBounds(i, city.car11E.getY(), 77, 40);
        try{
        sleep(1*velocidade);
        }//fim do try
        catch(Exception e){}
      }//fim do for
    }//fim do if
  }//fim do metodo

/* ***************************************************************
* Metodo: up
* Funcao: altera a interface grafica para simular o carro andando.
* Parametros: distance(int), y(int) 
* Retorno: void
*************************************************************** */
  public void up(int distance, int y){
    int posicao=0;
    if(city.car11C.getX()>=460 && city.car11C.getY()<=y){
      posicao=city.car11C.getY();
      for(int i = posicao; i>=distance; i--){
        city.car11C.setBounds(city.car11C.getX(), i, 40, 77);
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
    if(city.car11D.getX()>=x && city.car11D.getY()<=100){
      posicao=city.car11D.getX();
      for(int i = posicao; i<=distance; i++){
        city.car11D.setBounds(i, city.car11D.getY(), 77, 40);
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
  	city.car11B.setVisible(false);
  	city.car11E.setVisible(true);
  	city.car11B.setBounds(605, 100, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change2
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change2(){
  	city.car11E.setVisible(false);
  	city.car11C.setVisible(true);
  	city.car11E.setBounds(565, 262, 77, 40);
  }//fim do metodo

/* ***************************************************************
* Metodo: change3
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change3(){
  	city.car11C.setVisible(false);
  	city.car11D.setVisible(true);
  	city.car11C.setBounds(460, 220, 40, 77);
  }//fim do metodo

/* ***************************************************************
* Metodo: change4
* Funcao: muda a visibilidade das imagens
* Retorno: void
*************************************************************** */
  public void change4(){
  	city.car11D.setVisible(false);
  	city.car11B.setVisible(true);
  	city.car11D.setBounds(460, 100, 77, 40);
  }//fim do metodo

}//fim da classe
