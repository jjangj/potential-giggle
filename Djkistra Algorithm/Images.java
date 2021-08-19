import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.application.Platform;
import java.util.ArrayList;

public class Images{

	private ArrayList<Image> imageList = new ArrayList<>();
	private String names[] = {"pacote"};

	/*********************************************
  * Metodo: Imagem
  * Funcao: Criar objetos da Classe Imagem
  * Parametros: void
  *********************************************/
  public Images() {
    for (int i=0; i<names.length; i++) {
      imageList.add(new Image(Images.class.getResourceAsStream(names[i]+".PNG")));
    }//fim do for
  }//fim do Imagem

    /*********************************************
  * Metodo: getImages
  * Funcao: Retornar uma image
  * Parametros: String
  * Retorno: Image
  *********************************************/
  private Image getImages(String name) {
  	int position = 0;
    for (; position<names.length; position++) {
      if (names[position].equals(name)) {
        break;
      }//fim do if
    }//fim do for
    return this.imageList.get(position);
  }//fim do getImages

  /*********************************************
  * Metodo: change
  * Funcao: Trocar as Imagens das ImageView do programa
  * Parametros: ImageView String
  * Retorno: void
  *********************************************/
  public synchronized void change(ImageView imageView, String nomeImagem) {
    Platform.runLater(new Runnable(){
      @Override
      public void run() {
        imageView.setImage(getImages(nomeImagem));
      }//fim do run
    });//fim do platform
  }//fim do change

}//fim da classe imagem