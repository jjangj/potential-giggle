import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShortestPath {

  private List<Node> shortestPath;
  private Node nodePath;
  private Node current;
  private Node neighbor;
  private List<Node> notVisited;

  /* ***************************************************************
  * Metodo: ShortestPath
  * Funcao: metodo construtor que inicializa as variaveis e atri-
  * butos da classe
  * Parametros: -
  * Retorno: -
  *************************************************************** */
  public ShortestPath() {
    shortestPath = new ArrayList<>();
    notVisited = new ArrayList<>();
    nodePath = new Node();
    current = new Node();
    neighbor = new Node();
  }//fim do metodo construtor 

  /* ***************************************************************
  * Metodo: shortestPathAlgorithm
  * Funcao: calcular o menor caminho de um grafo
  * Parametros: Graphd g, Node initialN, Node finalN
  * Retorno: List<Node> - Lista com os vertices que estao no menor 
  * caminho encontrado.
  *************************************************************** */
  public List<Node> shortestPathAlgorithm(Graphs g, Node initialN, Node finalN) {
    int total = 0;
    initialN.setStatus(Node.LabelStatus.PERMANENT);
    shortestPath.add(initialN);

    for (int i = 0; i < g.allNode().size(); i++) {
      if (g.allNode().get(i).getId() == initialN.getId()) {
        g.allNode().get(i).setDistance(0);
      }//fim do if
      else {
        g.allNode().get(i).setDistance(Integer.MAX_VALUE);
      }//fim do else
      this.notVisited.add(g.allNode().get(i));
    }//fim do for

    while (!notVisited.isEmpty()) {
      current = this.notVisited.get(0);

      for (int i = 0; i < current.getAmountOfAdjacent()-1; i++) {
         
        neighbor = current.getEdge().get(i).getFinalNode2();

        if (!neighbor.isVisited()) {
          if(neighbor.getDistance() > current.getDistance() + current.getEdge().get(i).getWeight()){
            neighbor.setDistance(current.getDistance() + current.getEdge().get(i).getWeight());
            neighbor.setFather(current);
            neighbor.setStatus(Node.LabelStatus.PERMANENT);
            
            if(neighbor == finalN){
              shortestPath.clear();
              nodePath = neighbor;
              shortestPath.add(neighbor);
              while(nodePath.getFather() != null){
                shortestPath.add(nodePath.getFather());
                nodePath = nodePath.getFather();
              }//fim do while
              Collections.sort(shortestPath);
            }//fim do if 
          }//fim do if
        }//fim do if
      }//fim do for
      current.setVisited(true);
      this.notVisited.remove(current);
      Collections.sort(notVisited);
    }//fim do while
    System.out.println("SHORTEST PATH");
    /*for(int i = 0;i< shortestPath.size();i++){
      System.out.println(shortestPath.get(i).getId());
    }//fim do for*/
    return shortestPath;
  }//fim do metodo shortestePathAlgorithm

}//fim da classe ShortestPath
