/* ***************************************************************
* Classe: Edge
* Funcao: Estrutura de dados como se fosse uma aresta de um grafo.
*************************************************************** */
import javafx.scene.canvas.Canvas;

public class Edge {

  private int weight;
  private Canvas edge;
  private Node finalNode1;
  private Node finalNode2;
  private char id;
  private int fromX;
  private int fromY;
  private int toX;
  private int toY;

  /* ***************************************************************
  * Metodo: Edge
  * Funcao: Metodo especial construtor
  * Parametros: Node n1, Node2, char id, int fromx, int fromy, 
  * int tox, int toy.
  *************************************************************** */
  public Edge(Node n1, Node n2, char id, int fromx, int fromy, int tox, int toy, int weight) {
    this.finalNode1 = n1;
    this.finalNode2 = n2;
    this.id = id;
    this.fromX = fromx;
    this.fromY = fromy;
    this.toX = tox;
    this.toY = toy;
    this.weight = weight;
  }//fim do metodo contrutor Edge

  public int getFromX() {
    return fromX;
  }//fim do metodo getFromX

  public void setFromX(int fromX) {
    this.fromX = fromX;
  }//fim do metodo setFromX

  public int getFromY() {
    return fromY;
  }//fim do metodo getFromY

  public void setFromY(int fromY) {
    this.fromY = fromY;
  }//fim do metodo setFromY

  public int getToX() {
    return toX;
  }//fim do metodo getToX

  public void setToX(int toX) {
    this.toX = toX;
  }//fim do metodo setToX

  public int getToY() {
    return toY;
  }//fim do metodo getToY

  public void setToY(int toY) {
    this.toY = toY;
  }//fim do metodo setToY

  public char getId() {
    return id;
  }//fim do metodo getId

  public void setId(char id) {
    this.id = id;
  }//fim do metodo setId

  public int getWeight() {
    return weight;
  }//fim do metodo getWeight

  public void setWeight(int weight) {
    this.weight = weight;
  }//im do metodo setWeight

  public Canvas getEdge() {
    return edge;
  }//fim do metodo getEdge

  public void setEdge(Canvas edge) {
    this.edge = edge;
  }//fim do metodo setEdge

  public Node getFinalNode1() {
    return finalNode1;
  }//fim do metodo getFinalNode1

  public void setFinalNode1(Node finalNode1) {
    this.finalNode1 = finalNode1;
  }//fim do metodo setFinalNode1

  public Node getFinalNode2() {
    return finalNode2;
  }//fim do metodo getFinalNode2

  public void setFinalNode2(Node finalNode2) {
    this.finalNode2 = finalNode2;
  }//fim do metodo setFinalNode2

}//fim da classe Edge
