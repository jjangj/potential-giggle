/* ***************************************************************
* Classe: Node
* Funcao: Estrutura de dados como se fosse um vertice de um grafo.
*************************************************************** */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node{

	private int id;
	private Map<Node, Edge> adjacencyList;
	public List<Node> adjacencyNode;
	private int x;
  private int y;
  public static enum Type {INITIAL, FINAL, COMMON};
  private Type type;
  private boolean receive;

	/* ***************************************************************
	* Metodo: Node
	* Funcao: metodo especial construtor
	* Parametros: int id, int x, int y
	* Retorno: -
	*************************************************************** */
	public Node(int id, int x, int y){
		adjacencyList = new HashMap<>();
		adjacencyNode = new ArrayList<>();
		this.id = id;
		this.x = x;
		this.y = y;
		this.type = Type.COMMON;
		this.receive = false;
	}//fim do metodo construtor Node

	Node() {}

	/* ***************************************************************
	* Metodo: getEdge
	* Funcao: retorna a lista de aresta que sao incidentes em um
	* vertice.
	* Parametros: Node node
	* Retorno: List
	*************************************************************** */
  public List<Edge> getEdge(Node n) {
		List<Edge> edgesList = new ArrayList<>();
    for(Node n1 : adjacencyList.keySet()){
    	if(n1.equals(n)){
      	edgesList.add(adjacencyList.get(n));
      }//fim do if
    }//fim do for
    return edgesList;
	}//fim do metodo getEdge

	/* ***************************************************************
	* Metodo: oppositeNode
	* Funcao: retorna um vertice de acordo um determinado vertice e 
	* uma aresta.
	* Parametros: Node node, Edge edge
	* Retorno: Node
	*************************************************************** */
	public Node oppositeNode(Node node, Edge edge){
    for(Node n1 : adjacencyList.keySet()){
      if(n1.equals(node) && edge.equals(adjacencyList.get(n1))){
        if(node.equals(edge.getFinalNode1())){
          return edge.getFinalNode2();
        }//im do if
        else{
          return edge.getFinalNode1();
        }//fim do else
      }//fim do if
    }//fim do for
    return null;
	}//fim do metodo oppositeNode

	public void setType(Type type){
		this.type = type;
	}//fim do metodo setType

	public Type getType(){
		return this.type;
	}//fim do metodo getType

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

	public int getId() {
		return id;
  }//fim do metodo getId

  public void setId(int id) {
  	this.id = id;
  }//fim do metodo setId

	public Map getAdjacencyList() {
  	return this.adjacencyList;
  }//fim do metodo getAdjacencyList
    
	public void addAdjacencyList(Node n, Edge e){
    adjacencyList.put(n, e);
  }//fim do metodo addAdjacencyList

  public int getAmountOfAdjacent(){
  	return adjacencyList.size();
	}//fim do metodo amountOfAdjacent

	public List<Node> getAdjacencyNode() {
		return adjacencyNode;
  }//fim do metodo get...

  public void setAdjacencyNode(List<Node> adjacencyNode) {
  	this.adjacencyNode = adjacencyNode;
  }//fim do metodo set...
 
  public void setReceive(){
  	this.receive = true;
  }//fim do metodo setReceive

  public boolean getReceive(){
  	return this.receive;
  }//fim do metodo getReceive
    
  public void printAdjacencyList(){
  	for(Node n : adjacencyNode){
    	System.out.print(n.getId()+ " ");
    }//fim do for
    System.out.println("");
  }//fim do metodo printAdjacencyList
	
}//fim da classe Node