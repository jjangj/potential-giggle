/* ***************************************************************
* Classe: StartPanel
* Funcao: Controle do JPanel StartPanel  
*************************************************************** */

import javax.swing.*;
import java.awt.event.*;

public class StartPanel extends JPanel implements ActionListener{

  private City city;
  private CityPanel cityP;
  JButton startButton;
  JLabel imageCity;
  Icon cityBg;

/* ***************************************************************
* Metodo: StartPanel
* Funcao: Inicializar os atributos da classe.
*************************************************************** */
  public StartPanel(City city){
    this.city=city;
    this.setSize(899, 652);
    this.setLayout(null);
    this.setBounds(1, 0, 890, 645);
    this.setVisible(true);

    cityBg = new ImageIcon("NYInicial.png");
    imageCity = new JLabel(cityBg);
    imageCity.setBounds(1, 0, 890, 645);

    startButton = new JButton("Iniciar");
    startButton.setBounds(412, 567, 80, 40);
    startButton.addActionListener(this);

    this.add(startButton);
    this.add(imageCity);
    this.setVisible(true);

  }//fim do metodo

/* ***************************************************************
* Metodo: actionPerformed
* Funcao: Adiciona evento no botão.
*************************************************************** */
  public void actionPerformed(ActionEvent e) { 
      if(e.getSource() == startButton){
        this.city.showCityPanel();
        //cityP.startButton.setEnabled(true);
      }//fim do if
    }//fim do metodo

}//fim da classe