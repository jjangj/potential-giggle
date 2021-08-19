import javafx.scene.image.ImageView;

public class FloodRouting {

  public static Graphs graphs;
  private String idInitial;
  private String idFinal;
  private Tela tela;
  public static boolean flag;

/* ***************************************************************
  * Metodo: FloodRouting
  * Funcao: metodo construtor que inicializa as variaveis e atri-
  * butos da classe
  * Parametros: Graphs gr, String initial, String finalN
  * Retorno: -
  *************************************************************** */
  public FloodRouting(Graphs gr, String initial, String finalN) {
    this.graphs = gr;
    this.idInitial = initial;
    this.idFinal = finalN;
    this.flag = true;
  }//fim do metodo construtor FloodRouting

  FloodRouting() {}

/* ***************************************************************
  * Metodo: run
  * Funcao: inicia o algoritmo
  * Parametros: -
  * Retorno: void
  *************************************************************** */
  public void run() {
    try {
      int x, y;
      graphs.getNode(idInitial).setReceive();

      if (graphs.getNode(idInitial).getReceive()) {//verifica se ja recebeu uma mensagem
        arrive(graphs.getNode(idInitial), tela);
      }//fim do if

    }//fim do try
    catch (Exception e) {
      e.printStackTrace();
    }//fim do catch
  }//fim do metodo run

/* ***************************************************************
  * Metodo: setTela
  * Funcao: atualiza o valor da tela
  * Parametros: Tela t
  * Retorno: void
  *************************************************************** */
  public void setTela(Tela t) {
    this.tela = t;
  }//fim do metodo setTEla

  /* ***************************************************************
  * Metodo: arrive
  * Funcao: envia o pacote a todos os adjacentes
  * Parametros: Node node
  * Retorno: void
  *************************************************************** */
  public void arrive(Node node, Tela t) {
    int x, y;
    for (Node adjacencyNode : node.adjacencyNode) { //pega os vertices adjacentes
      x = node.getX();
      y = node.getY();
      int x1 = adjacencyNode.getX();
      int y1 = adjacencyNode.getY();
      ImageView packageImage;
      packageImage = t.addPackage(x, y);
      MessagePacket mp = new MessagePacket(packageImage, x, y, x1, y1, node.getId(), adjacencyNode.getId(), t, node);
      mp.run2();
    } //fim do for
  }//fim do metodo arrive

  /* ***************************************************************
  * Metodo: arrive
  * Funcao: envia o pacote a todos os adjacentes
  * Parametros: Node node
  * Retorno: void
  *************************************************************** */
  public void arrive(Node node, Node node1, Tela t, int hopLimit) {
    int x, y;
    MessagePacket mp = null;
    //System.out.println(hopLimit);
    if (hopLimit > 0) {
      hopLimit--;
      for (Node adjacencyNode : node.adjacencyNode) { //pega os vertices adjacentes
        if (!adjacencyNode.equals(node1)) {
          x = node.getX();
          y = node.getY();
          int x1 = adjacencyNode.getX();
          int y1 = adjacencyNode.getY();
          ImageView packageImage;
          packageImage = t.addPackage(x, y);
          mp = new MessagePacket(packageImage, x, y, x1, y1, node.getId(), adjacencyNode.getId(), t, node, hopLimit);
          mp.run2();
        }//fim do if
      } //fim do for
    }//fim do if
  }//fim do metodo arrive

  public void stop() {
    flag = false;
  }//fim do metodo stop

}//fim da classe FloodRouting
