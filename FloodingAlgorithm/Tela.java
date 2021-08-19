/* ***************************************************************
* Classe: Tela
* Funcao: Criar e manipular os elementos da GUI
*************************************************************** */

import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.control.TextField;
import javafx.geometry.Pos;
import javafx.scene.shape.Line;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;
import javafx.scene.text.FontWeight;
import java.util.HashMap;
import java.util.Map;

public class Tela {

	private AnchorPane panel;
	private Pane controlPane;
	private Pane principalPane;
	private TextField node1;
	private TextField node2;
	private int x;
	private int y;
	private int counter = 1;
	private int fromXEdge = 0;
	private int fromYEdge = 0;
	private int toXEdge = 0;
	private int toYEdge = 0;
	private boolean flagNode = true;
	private boolean flagEdge = false;
	private Graphs graphs = new Graphs();
	private char edgeId = 'a';
	public static Map<Integer, Button> buttons; 
	public static Map<Character, Line> lines;
	private Images allImage;
	private TextField initialNode;
	private TextField finalNodeT;

	/**********************************************
	* Metodo: Tela 
	* Funcao: Inicializar as variaveis e atributos
	* da classe Tela.
	* Parametros: - 
	* Retorno: - 
	********************************************/
	public Tela() {
		buttons = new HashMap<>();
		lines = new HashMap<>();
	}//fim do metodo construtor Tela

	/**********************************************
	* Metodo: show 
	* Funcao: Mostrar a GUI Parametros: primaryStage
	* Retorno: void
	*********************************************/
	public void show(Stage primaryStage) {

		primaryStage.setTitle("Roteamento por Inundacao");
		primaryStage.setResizable(false);
		panel = new AnchorPane();
		panel.setPrefSize(1100, 600);
		panel.setStyle("-fx-background-color: #FFFFE0");

		controlPane = new Pane();
		controlPane.setStyle("-fx-background-color: #D3D5D7");
		controlPane.setLayoutX(871);
		controlPane.setLayoutY(0);
		controlPane.setPrefSize(229, 600);
		panel.getChildren().add(controlPane);

		principalPane = new Pane();
		principalPane.setStyle("-fx-background-color: transparent");
		principalPane.setLayoutX(0);
		principalPane.setLayoutY(0);
		principalPane.setPrefSize(871, 600);
		panel.getChildren().add(principalPane);

		/**************************BOTOES*************************/
		Button node = new Button("Vertice");
		node.setLayoutX(17);
		node.setLayoutY(263);
		node.setPrefSize(91, 40);
		node.setTextFill(Paint.valueOf("WHITE"));
		node.setStyle("-fx-background-color: #050517;");
		node.setFocusTraversable(false);
		node.setDisable(true);
		controlPane.getChildren().add(node);

		Button edge = new Button("Arestas");
		edge.setLayoutX(122);
		edge.setLayoutY(263);
		edge.setPrefSize(91, 40);
		edge.setTextFill(Paint.valueOf("WHITE"));
		edge.setStyle("-fx-background-color: #050517;");
		edge.setFocusTraversable(false);
		controlPane.getChildren().add(edge);

		Button ok = new Button("Ok");
		ok.setLayoutX(63);
		ok.setLayoutY(390);
		ok.setPrefSize(91, 40);
		ok.setTextFill(Paint.valueOf("WHITE"));
		ok.setStyle("-fx-background-color: #050517;");
		ok.setFocusTraversable(false);
		controlPane.getChildren().add(ok);

		Button start = new Button("Iniciar");
		start.setLayoutX(17);
		start.setLayoutY(530);
		start.setPrefSize(91, 40);
		start.setTextFill(Paint.valueOf("WHITE"));
		start.setStyle("-fx-background-color: #050517;");
		start.setFocusTraversable(false);
		controlPane.getChildren().add(start);

		Button restart = new Button("Recomecar");
		restart.setLayoutX(122);
		restart.setLayoutY(530);
		restart.setPrefSize(91, 40);
		restart.setTextFill(Paint.valueOf("WHITE"));
		restart.setStyle("-fx-background-color: #050517;");
		restart.setFocusTraversable(false);
		restart.setDisable(true);
		controlPane.getChildren().add(restart);

		/*************************LABEL************************/
		Label instruction = new Label("Instrucoes");
		instruction.setLayoutX(70);
		instruction.setLayoutY(5);
		instruction.setTextFill(Paint.valueOf("#050517"));
		instruction.setFont(Font.font("Lucida", FontWeight.BOLD, 18));
		controlPane.getChildren().add(instruction);

		Label configuration = new Label("Configuracoes");
		configuration.setLayoutX(50);
		configuration.setLayoutY(215);
		configuration.setTextFill(Paint.valueOf("#050517"));
		configuration.setFont(Font.font("Lucida", FontWeight.BOLD, 18));
		controlPane.getChildren().add(configuration);

		Label initial = new Label("Inicial");
		initial.setLayoutX(40);
		initial.setLayoutY(445);
		initial.setTextFill(Paint.valueOf("#050517"));
		initial.setFont(Font.font("Lucida Bright Regular"));
		initial.setFont(Font.font(18));
		controlPane.getChildren().add(initial);

		Label finalNode = new Label("Final");
		finalNode.setLayoutX(145);
		finalNode.setLayoutY(445);
		finalNode.setTextFill(Paint.valueOf("#050517"));
		finalNode.setFont(Font.font("Lucida Bright Regular"));
		finalNode.setFont(Font.font(18));
		controlPane.getChildren().add(finalNode);

		Label first = new Label("1- Adicione todos os vertices\nCom cliques do mouse");
		first.setLayoutX(10);
		first.setLayoutY(45);
		first.setTextFill(Paint.valueOf("#050517"));
		first.setFont(Font.font("Lucida Bright Regular"));
		first.setFont(Font.font(12));
		controlPane.getChildren().add(first);

		Label second = new Label("2- Clique no botao arestas");
		second.setLayoutX(10);
		second.setLayoutY(80);
		second.setTextFill(Paint.valueOf("#050517"));
		second.setFont(Font.font("Lucida Bright Regular"));
		second.setFont(Font.font(12));
		controlPane.getChildren().add(second);

		Label third = new Label("3- Adicione todas as arestas\nInsira os vertices que serao ligados");
		third.setLayoutX(10);
		third.setLayoutY(100);
		third.setTextFill(Paint.valueOf("#050517"));
		third.setFont(Font.font("Lucida Bright Regular"));
		third.setFont(Font.font(12));
		controlPane.getChildren().add(third);

		Label fourth = new Label("4- Prencha os campos de vertice inicial \n e final");
		fourth.setLayoutX(10);
		fourth.setLayoutY(136);
		fourth.setTextFill(Paint.valueOf("#050517"));
		fourth.setFont(Font.font("Lucida Bright Regular"));
		fourth.setFont(Font.font(12));
		controlPane.getChildren().add(fourth);

		Label fifth = new Label("5- Clique em iniciar");
		fifth.setLayoutX(10);
		fifth.setLayoutY(173);
		fifth.setTextFill(Paint.valueOf("#050517"));
		fifth.setFont(Font.font("Georgia"));
		fifth.setFont(Font.font(12));
		controlPane.getChildren().add(fifth);

		Label node1Label = new Label("Vertice 1");
		node1Label.setLayoutX(25);
		node1Label.setLayoutY(315);
		node1Label.setTextFill(Paint.valueOf("#050517"));
		node1Label.setFont(Font.font("Lucida Bright Regular"));
		node1Label.setFont(Font.font(18));
		controlPane.getChildren().add(node1Label);

		Label node2Label = new Label("Vertice 2");
		node2Label.setLayoutX(130);
		node2Label.setLayoutY(315);
		node2Label.setTextFill(Paint.valueOf("#050517"));
		node2Label.setFont(Font.font("Lucida Bright Regular"));
		node2Label.setFont(Font.font(18));
		controlPane.getChildren().add(node2Label);

		/***********************TEXTFIELD************************/

		initialNode = new TextField();
		initialNode.setAlignment(Pos.CENTER);
		initialNode.setPromptText("0");
		initialNode.setLayoutX(17);
		initialNode.setLayoutY(470);
		initialNode.setPrefSize(91, 40);
		controlPane.getChildren().add(initialNode);

		finalNodeT = new TextField();
		finalNodeT.setAlignment(Pos.CENTER);
		finalNodeT.setPromptText("0");
		finalNodeT.setLayoutX(122);
		finalNodeT.setLayoutY(470);
		finalNodeT.setPrefSize(91, 40);
		controlPane.getChildren().add(finalNodeT);

		node1 = new TextField();
		node1.setAlignment(Pos.CENTER);
		node1.setPromptText("0");
		node1.setLayoutX(17);
		node1.setLayoutY(340);
		node1.setPrefSize(91, 40);
		node1.setDisable(true);
		controlPane.getChildren().add(node1);

		node2 = new TextField();
		node2.setAlignment(Pos.CENTER);
		node2.setPromptText("0");
		node2.setLayoutX(122);
		node2.setLayoutY(340);
		node2.setPrefSize(91, 40);
		node2.setDisable(true);
		controlPane.getChildren().add(node2);

		/***********************OUTROS***********************/

		Line line = new Line();
		line = new Line(-110, 1, 100, 2);
		line.setLayoutX(120);
		line.setLayoutY(205);
		controlPane.getChildren().add(line);

		allImage = new Images();

		primaryStage.setScene(new Scene(panel, 1100, 600));
		primaryStage.show();

		Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
    alert1.setTitle("Informacao");
    alert1.setHeaderText("Informacao");
    alert1.setContentText("Para adicionar os vertices, clique no lugar em que quiser adiciona-lo no painel.\nQuando todos os vertices tiverem sido adicionados clique no botao 'Arestas' no painel Configuracoes.");
    alert1.showAndWait(); 

		/***********************ACOES***********************/

		principalPane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (flagNode) {
					x = (int) event.getX();
					y = (int) event.getY();
					String c = Integer.toString(counter);
					Button b = new Button(c);
					double r = 25.0;
					b.setShape(new Circle(r));
					b.setMinSize(2 * r, 2 * r);
					b.setMaxSize(2 * r, 2 * r);
					b.setStyle("-fx-background-color: #FE5F55;");
					b.setLayoutX(x);
					b.setLayoutY(y);
					b.setFocusTraversable(false);
					principalPane.getChildren().add(b);
					graphs.addNode(counter, x, y);
					buttons.put(counter, b);
					toXEdge = x;
					toYEdge = y;
					counter++;
				}//fim do if
			}//fim do metodo handle
		});//fim do setOnMouseClicked

		restart.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				start.setDisable(false);
				
			}//fim do handle
		});//fim do set onAction

		node.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				node.setDisable(true);
				edge.setDisable(false);
				flagNode = true;
				flagEdge = false;
				node1.setDisable(true);
				node2.setDisable(true);
			}//fim do handle
		});//fim do setOnAction

		edge.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				node.setDisable(false);
				flagNode = false;
				flagEdge = true;
				edge.setDisable(true);
				node1.setDisable(false);
				node2.setDisable(false);
				Alert alert2 = new Alert(Alert.AlertType.INFORMATION);
    		alert2.setTitle("Informacao");
    		alert2.setHeaderText("Informacao");
    		alert2.setContentText("Para adicionar as arestas, insira os nomes dos vertices nos espacoes 'Vertice1' e 'Vertice2' no painel Configuracoes e clique em OK");
    		alert2.showAndWait();
			}//fim do handle
		});//fim do setOnAction

		ok.setOnAction((ActionEvent event) -> {
			try{
				String no1 = node1.getText().trim();
				String no2 = node2.getText().trim();
				clear();
				graphs.addEdge(no1, no2, edgeId, fromXEdge, fromYEdge, toXEdge, toYEdge);
				
				Node nodeOne = graphs.getNode(no1);
				Node nodeTwo = graphs.getNode(no2);
				
				if (flagEdge) {
					Line line2 = new Line();
					line2 = new Line(nodeOne.getX()+33, nodeOne.getY()+32, nodeTwo.getX()-5, nodeTwo.getY());
					line2.setLayoutX(10);
					line2.setLayoutY(10);
					line2.setStyle("-fx-stroke: #B5B5B5;");
					principalPane.getChildren().add(line2);
					lines.put(edgeId, line2);
				}//fim do if
				edgeId++;
			}//fim do try
			catch(Exception e){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Erro");
        alert.setContentText("Prencha os dois espacos corretamente!\nNo espaco 'Vertice1' coloque o nome do vertice da primeira extremidade da aresta e no espaco 'Vertice 2' coloque o nome do outro vertice");
        alert.showAndWait(); 
      }//fim do catch
		} //fim do handle
		);//fim do setOnAction

		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				try{
					String no1 = initialNode.getText().trim();
					String no2 = finalNodeT.getText().trim();

					int noOne = Integer.parseInt(no1);
					int noTwo = Integer.parseInt(no2);

					graphs.getNode(no1).setType(Node.Type.INITIAL);
					graphs.getNode(no2).setType(Node.Type.FINAL);

					buttons.get(noOne).setStyle("-fx-background-color: #CB4C44;");
					buttons.get(noTwo).setStyle("-fx-background-color: #CB4C44;");

    			//restart.setDisable(false);
    			start.setDisable(true);

    			FloodRouting flood = new FloodRouting(graphs, no1, no2);
    			clear2();
					flood.setTela(setTela());
          flood.run();
          
			}//fim do try
			catch(Exception e){
				Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Erro");
        alert.setHeaderText("Erro");
        alert.setContentText("Insira os vertices iniciais e finais corretamente!");
        alert.showAndWait();
			}//fim do catch
			}//fim do handle
		});//fim do setOnAction

	}//fim do metodo show

  /* ***************************************************************
	* Metodo: clear
	* Funcao: limpar os campos dos textfields
	* Parametros: -
	* Retorno: void
	*************************************************************** */
	private void clear() {
		node1.setText("");
		node2.setText("");
	}//fim do metodo clear

/* ***************************************************************
	* Metodo: clear2
	* Funcao: limpar os campos dos textfields
	* Parametros: -
	* Retorno: void
	*************************************************************** */
	private void clear2(){
		initialNode.setText("");
		finalNodeT.setText("");
	}//fim do metodo clear2

/* ***************************************************************
	* Metodo: addPackage
	* Funcao: adiciona uma imagem na tela
	* Parametros: int x, int y
	* Retorno: ImageView
	*************************************************************** */
	public ImageView addPackage(int x, int y){
		ImageView packageImage = new ImageView();
    allImage.change(packageImage, "pacote");
    packageImage.setPreserveRatio(true);
    packageImage.setFitWidth(45);
    packageImage.setLayoutX(x);
    packageImage.setLayoutY(y);
    panel.getChildren().add(packageImage);
    return packageImage;
	}//fim do metodo addPackage

/* ***************************************************************
	* Metodo: setTela
	* Funcao: retorna a tela
	* Parametros: -
	* Retorno: void
	*************************************************************** */
	public Tela setTela(){
		return this;
	}//fim do metodo tela

}//fim da classe Tela