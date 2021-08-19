/* ***************************************************************
* Classe: Graphs
* Funcao: Estrutura de dados para representar um grafo.
*************************************************************** */
import java.util.List;
import java.util.ArrayList;

public class Graphs{

	public static List<Node> nodes;
	private List<Edge> edges;
	private Node n;

	/* ***************************************************************
	* Metodo: Graphs
	* Funcao: Metodo especial construtor
	* Parametros: -
	* Retorno: -
	*************************************************************** */
	public Graphs(){
		this.nodes = new ArrayList<>();
		this.edges = new ArrayList<>();
	}//fim do metodo construtor Graphs

	/* ***************************************************************
	* Metodo: allNode
	* Funcao: retorna todos os vertices do grafo
	* Parametros: -
	* Retorno: Lista de todos os vertices -List-
	*************************************************************** */
	public List allNode(){
		return this.nodes;
	}//fim do metodo allNode

	/* ***************************************************************
	* Metodo: printNode
	* Funcao: Imprimir todos os id's dos vertices no grafo
	* Parametros: -
	* Retorno: String
	*************************************************************** */
	public String printNode() {
		String str = "";
    for(Node node : nodes){
      str += node.getId() + " ";
    }//fim do metodo
    return str;
  }//fim do metodo printNode

	/* ***************************************************************
	* Metodo: allEdge
	* Funcao: retorna todas as arestas do grafo
	* Parametros: -
	* Retorno: Retorna uma lista de todas as arestas no grafo
	*************************************************************** */
	public List allEdge(){
		return this.edges;
	}//fim do metodo allEdge

	/* ***************************************************************
	* Metodo: incidentEdge
	* Funcao: retorna uma lista de quais arestas sao incidentes em um
	* determinado vertice.
	* Parametros: Node node
	* Retorno: List
	*************************************************************** */
	public List<Edge> incidentEdge(Node node) {
   	return n.getEdge(node);
  }//fim do metodo incidentEdge

	/* ***************************************************************
	* Metodo: addEdge
	* Funcao: cria uma nova aresta
	* Parametros: String source, string destiny, char id, int x1, 
	* int y1, int x2, int y2.
	* Retorno: void
	*************************************************************** */
	public void addEdge(String source, String destiny, char id, int x1, int y1, int x2, int y2) {
		int s = Integer.parseInt(source);
    int d = Integer.parseInt(destiny);
    Node sour = null;
    Node dest = null;
    for (int i = 0; i < nodes.size(); i++) {
      if (nodes.get(i).getId() == s) {
        sour = nodes.get(i);
      }//fim do if
    }//fim do for
    for (Node no : nodes) {
      if (no.getId() == d) {
        dest = no;
      }//fim do if
    }//im do for
    Edge e = new Edge(sour, dest, id, x1, y1, x2, y2);
    edges.add(e);
    
    sour.adjacencyNode.add(dest);
    dest.adjacencyNode.add(sour);
    sour.addAdjacencyList(dest, e);
    sour.addAdjacencyList(sour, e);
    }//fim do metodo addEdge

	/* ***************************************************************
	* Metodo: addNode
	* Funcao: cria um novo vertice
	* Parametros: int id, int x, int y
	* Retorno: void
	*************************************************************** */
  public void addNode(int id, int x, int y){
    Node node = new Node(id, x, y);
    nodes.add(node);
	}//fim do metodo addNode

	/* ***************************************************************
	* Metodo: opposite
	* Funcao: retorna um vertice que é oposto a ele por uma determina-
	* da aresta
	* Parametros: Node node, Edge edge
	* Retorno: Node
	*************************************************************** */
	public Node opposite(Node node, Edge edge){
		return n.oppositeNode(node, edge);
	}//fim do metodo opposite

	/* ***************************************************************
	* Metodo: endNode
	* Funcao: retorna os dois vertices pelo qual uma determinada ares-
	* ta esta ligada.
	* Parametros: Edge e
	* Retorno: List
	*************************************************************** */
	public List endNode(Edge e){
		List<Node> l = new ArrayList<>();
    l.add(e.getFinalNode1());
    l.add(e.getFinalNode2());
  	return l;
  }//fim do metodo endNode

	/* ***************************************************************
	* Metodo: getNode
	* Funcao: retorna um vertice de acordo com um determinado id
	* Parametros: String id
	* Retorno: Node
	*************************************************************** */
  public Node getNode(String id) {
    int d = Integer.parseInt(id);
    for (Node no : nodes) {
      if (no.getId() == d) {
        return no;
      }//fim do if
  	}//im do for
    return null;
  }//fim do metodo getNode

/* ***************************************************************
	* Metodo: amountOfAdjacent
	* Funcao: retorna o numero de vertices adjacentes de um vertice
	* Parametros: Node n
	* Retorno: int
	*************************************************************** */
  public int amountOfAdjacent(Node n){
  	return n.getAmountOfAdjacent();
	}//fim do metodo amountOfAdjacent

	/* ***************************************************************
	* Metodo: getNode
	* Funcao: retorna um vertice de acordo com um determinado id
	* Parametros: int id
	* Retorno: Node
	*************************************************************** */
    public Node getNode(int id) {
      for (Node no : nodes) {
        if (no.getId() == id) {
          return no;
        }//fim do if
      }//im do for
      return null;
    }//fim do metodo getNode
}//fim da classe Graphs