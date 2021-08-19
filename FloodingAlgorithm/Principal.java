/* ***************************************************************
* Autor: Jenifer de Jesus Jang
* Inicio: 04/07/2018
* Ultima alteracao: 13/07/2018
* Nome: Roteamento por inundacao
* Funcao: Simular o envio de um pacote em uma rede utilizando o 
* algoritmo de roteamento por inundacao com GUI que permite que 
* o usuário insira um grafo qualquer na tela.
*************************************************************** */
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.WindowEvent;

public class Principal extends Application{

	Tela tela = new Tela();

	/*********************************************
  * Metodo: start
  * Funcao: Inicializa a GUI
  * Parametros: primaryStage
  * Retorno: void
  *********************************************/
	@Override
  public void start(Stage primaryStage){
	  tela.show(primaryStage);

	  /*********************************************
	  * Metodo: setOnCloseRequest
	  * Funcao: Finaliza todo o programa ao fechar
	  * Parametros: EventHandler
	  * Retorno: void
	  *********************************************/
	  primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	    @Override
	    public void handle(WindowEvent t) {
	      t.consume();
	      primaryStage.close();
	      System.exit(0);
	    }//fim do handle
	  });//fim do setOnCloseRequest
  }//fim do metodo start

	public static void main(String args[]){
		launch(args);
	}//fim do metodo main
}//fim da classe Principal
