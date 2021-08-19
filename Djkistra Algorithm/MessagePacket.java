import javafx.scene.image.ImageView;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.application.Platform;

public class MessagePacket {

	private ImageView image;
	private Tela tela;
	private int x;
	private int y;
	private int x1;
	private int y1;
	private int idRem;
	private int idDest;
	private Node whoSent;
	private int hopLimit;
	Animation ani;
	TranslateTransition translateTransition;

	/* ***************************************************************
	* Metodo: MessagePacket
	* Funcao: metodo construtor que inicializa as variaveis e atri-
	* butos da classe
	* Parametros: ImageView image, int x1, int y1, int x, int y,
	* int idRem, int idDest, Tela tela, Node n
	* Retorno: -
	*************************************************************** */
	public MessagePacket(ImageView image, int x1, int y1, int x, int y, int idRem, int idDest, Tela tela, Node n) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.idRem = idRem;
		this.idDest = idDest;
		this.tela = tela;
		this.whoSent = n;
		this.hopLimit = 12;
		this.ani = new Animation();
	}//fim do metodo construtor Package

	/* ***************************************************************
	* Metodo: MessagePacket
	* Funcao: metodo construtor que inicializa as variaveis e atri-
	* butos da classe
	* Parametros: ImageView image, int x1, int y1, int x, int y,
	* int idRem, int idDest, Tela tela, Node n, int hopLimit
	* Retorno: -
	*************************************************************** */
	public MessagePacket(ImageView image, int x1, int y1, int x, int y, int idRem, int idDest, Tela tela, Node n, int hopLimit) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.idRem = idRem;
		this.idDest = idDest;
		this.tela = tela;
		this.whoSent = n;
		this.hopLimit = hopLimit;
		this.ani = new Animation();
	}//fim do metodo construtor Package

	/* ***************************************************************
	* Metodo: run
	* Funcao: realiza a animacao do pacote
	* Parametros: -
	* Retorno: void
	*************************************************************** */
	public void run2() {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					translateTransition = new TranslateTransition(Duration.millis(3000), image);
					translateTransition.setFromX(image.getX());
					translateTransition.setFromY(image.getY());
					translateTransition.setToX(x - x1);
					translateTransition.setToY(y - y1);
					translateTransition.setCycleCount(0);
					translateTransition.setAutoReverse(false);
					translateTransition.setOnFinished((o) -> {
						hopLimit--;
						image.setVisible(false);
						Animation.shortestNodes.remove(0);
						ani.arrive(tela);
					});//fim do setOnFinished
					translateTransition.play();
				}//fim do try
				catch (Exception e) {}
			}//fim do metodo run
		}); //fim do Platform 
	}//fim do metodo run2

	/* ***************************************************************
	* Metodo: setTela
	* Funcao: atualizar o valor da tela
	* Parametros: Tela t
	* Retorno: void
	*************************************************************** */
		public void setWindow(Tela t) {
				this.tela = t;
		}//fim do metodo setWindow

}//fim da classe message packet
