/* ***************************************************************
* Classe: Animation
* Funcao: Fazer a animacao do pacote sendo enviado de roteador
* a roteador seguindo o algoritmo do camino mais curto.
*************************************************************** */

import java.util.List;
import javafx.scene.image.ImageView;

public class Animation {

  private Tela tela;
  public static List<Node> shortestNodes;

/* ***************************************************************
  * Metodo: Animation
  * Funcao: metodo construtor
  * Parametros: List nodes
  * Retorno: -
  *************************************************************** */
  public Animation(List nodes) {
    shortestNodes = nodes;
  }//fim do metodo construtor

  public Animation() {}

  /* ***************************************************************
  * Metodo: run
  * Funcao: inicia a simulacao
  * Parametros: Tela t
  * Retorno: void
  *************************************************************** */
  public void run(Tela t) {
    try {
      shortestNodes.get(0).setReceive();
      this.tela = t;
      arrive(t);
    }//fim do try
    catch (Exception e) {}
  }//fim do metodo run

  /* ***************************************************************
  * Metodo: arrive
  * Funcao: inicia a simulacao do pacote sendo enviado
  * Parametros: Tela tela
  * Retorno: void
  *************************************************************** */
  public void arrive(Tela tela) {
    try {
      if (shortestNodes.size() > 1) {
        int x, y, x1, y1;
        x = shortestNodes.get(0).getX();
        y = shortestNodes.get(0).getY();
        x1 = shortestNodes.get(1).getX();
        y1 = shortestNodes.get(1).getY();
        ImageView packageImage;
        packageImage = tela.addPackage(x, y);
        MessagePacket mp = new MessagePacket(packageImage, x, y, x1, y1, shortestNodes.get(0).getId(), shortestNodes.get(0).getId(), tela, shortestNodes.get(0));
        mp.run2();
      }//fim do if
    }//fim do try
    catch (Exception e) {
      e.printStackTrace();
      //System.out.println("catch");
    }//fim do catch
  }//fim do arrive

  /* ***************************************************************
  * Metodo: setTela
  * Funcao: atualiza o valor da tela
  * Parametros: Tela t
  * Retorno: void
  *************************************************************** */
  public void setTela(Tela t) {
    this.tela = t;
  }//fim do metodo setTEla

}//fim da classe animation
