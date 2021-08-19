/* ***************************************************************
* Classe: Node
* Funcao: Estrutura de dados como se fosse um vertice de um grafo.
*************************************************************** */
import java.util.List;
import java.util.ArrayList;

public class Node implements Comparable<Node> {

  private int id;
  private int x;
  private int y;

  public static enum LabelStatus {
    PROVISION, PERMANENT
  };
  private LabelStatus status;

  public static enum Type {
    INITIAL, FINAL, COMMON
  };
  private Type type;
  private boolean receive;
  private List<Edge> incidentList;
  public List<Node> adjacencyNode;

  private boolean visited;
  private Node father;
  private int distance;

  /* ***************************************************************
  * Metodo: Node
  * Funcao: metodo especial construtor
  * Parametros: int id, int x, int y
  * Retorno: -
  *************************************************************** */
  public Node(int id, int x, int y) {
    incidentList = new ArrayList<>();
    adjacencyNode = new ArrayList<>();
    this.id = id;
    this.x = x;
    this.y = y;
    this.type = Type.COMMON;
    this.receive = false;
    this.status = LabelStatus.PROVISION;
  }//fim do metodo construtor Node

  Node() {}

  public void clear() {
    try {
      incidentList.clear();
      adjacencyNode.clear();
    }//fim do try 
    catch (Exception e) {}
  }//fim do metodo clear

  /* ***************************************************************
  * Metodo: getEdge
  * Funcao: retorna a lista de aresta que sao incidentes em um
  * vertice.
  * Parametros: Node node
  * Retorno: List
  *************************************************************** */
  public List<Edge> getEdge(Node n) {
    return this.incidentList;
  }//fim do metodo getEdge

  public void setType(Type type) {
    this.type = type;
  }//fim do metodo setType

  public Type getType() {
    return this.type;
  }//fim do metodo getType

  public int getDistance() {
    return distance;
  }//fim do metodo getDistance

  public void setDistance(int distance) {
    this.distance = distance;
  }//fimd o metodo setDistance

  public LabelStatus getStatus() {
    return status;
  }//fim do metodo getStatus

  public void setStatus(LabelStatus status) {
    this.status = status;
  }//fim do metodo setStatus

  public int getX() {
    return x;
  }//fim do metodo getX

  public void setX(int x) {
    this.x = x;
  }//fim do metodo setX

  public int getY() {
    return y;
  }//fim do metodo getY

  public void setY(int y) {
    this.y = y;
  }//fim do metodo setY

  public Node getFather() {
    return father;
  }//fim do metodo getFather

  public void setFather(Node father) {
    this.father = father;
  }//fim do metodo setFather

  public List<Edge> getEdge() {
    return incidentList;
  }//fim do metodo getEdge

  public void setEdge(List<Edge> edge) {
    this.incidentList = edge;
  }//fim do metodo setEdge

  public int getId() {
    return id;
  }//fim do metodo getId

  public void setId(int id) {
    this.id = id;
  }//fim do metodo setId

  public boolean isVisited() {
    return visited;
  }//fim do metodo isVisited

  public void setVisited(boolean visited) {
    this.visited = visited;
  }//fim do metodo setVisited

  public void addIncidentList(Edge e) {
    incidentList.add(e);
  }//fim do metodo addAdjacencyList

  public int getAmountOfAdjacent() {
    return incidentList.size();
  }//fim do metodo amountOfAdjacent

  public List<Node> getAdjacencyNode() {
    return adjacencyNode;
  }//fim do metodo get...

  public void setAdjacencyNode(List<Node> adjacencyNode) {
    this.adjacencyNode = adjacencyNode;
  }//fim do metodo setadjacencyNode

  public void setReceive() {
    this.receive = true;
  }//fim do metodo setReceive

  public boolean getReceive() {
    return this.receive;
  }//fim do metodo getReceive

  public void printAdjacencyList() {
    adjacencyNode.forEach((Node n) -> {
      System.out.print(n.getId() + " ");
    }); //fim do for
    System.out.println("");
  }//fim do metodo printAdjacencyList

  @Override
  public int compareTo(Node n) {
    if (this.getDistance() < n.getDistance()) {
      return -1;
    }//fim do if
    else if (this.getDistance() == n.getDistance()) {
      return 0;
    }//fim do else 
    return 1;
  }//fim do metodo compareTo

}//fim da classe Node
