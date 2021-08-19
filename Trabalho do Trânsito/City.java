/* ***************************************************************
* Classe: City
* Funcao: Jframe para o programa
*************************************************************** */

import javax.swing.*;

public class City extends JFrame{

  private CityPanel panel1;
  private StartPanel panel2;
  public JLabel invisible;
  private Update update;

/* ***************************************************************
* Metodo: City
* Funcao: Inicializar os atributos da classe
*************************************************************** */
  public City(){
    super("Transito Automato");
    this.setSize(899, 652);
    this.setResizable(false);
    this.setLayout(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel2 = new StartPanel(this);
    panel1 = new CityPanel(this);
    invisible = new JLabel("");
    update = new Update(this);
    add(panel2);
    add(panel1);
    this.setVisible(true);
    showStartPanel();
    invisible.setVisible(true);
    invisible.setBounds(400,10,10,10);
    panel1.add(invisible);
    update.start();

  }//fim do metodo

/* ***************************************************************
* Metodo: showCityPanel
* Funcao: Ir para a tela principal, mudando as visibilidades
* dos JPanels.
* Retorno: void  
*************************************************************** */
  public void showCityPanel(){
      panel1.setVisible(true);
      panel2.setVisible(false);
    }//fim do metodo

/* ***************************************************************
* Metodo: showStartPanel
* Funcao: Ir para a tela inicial, mudando as visibilidades
* dos JPanels.
* Retorno: void  
*************************************************************** */
  public void showStartPanel(){
    panel2.setVisible(true);
    panel1.setVisible(false);
  }//fim do metodo

}//fim da classe
