/* ***************************************************************
* Classe: CityPanel
* Funcao: Controle do JPanel CityPanel  
*************************************************************** */

import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.concurrent.Semaphore;

public class CityPanel extends JPanel implements ActionListener{

  public static Icon car1C;
  public static Icon car1B;
  public static Icon car1E;
  public static Icon car1D;

  public static Icon car2C;
  public static Icon car2B;
  public static Icon car2E;
  public static Icon car2D;

  public static Icon car3C;
  public static Icon car3B;
  public static Icon car3E;
  public static Icon car3D;

  public static Icon car4C;
  public static Icon car4C2;
  public static Icon car4B;
  public static Icon car4E;
  public static Icon car4E2;
  public static Icon car4D;

  public static JLabel car11C;
  public static JLabel car11B;
  public static JLabel car11E;
  public static JLabel car11D;

  public static JLabel car22C;
  public static JLabel car22B;
  public static JLabel car22E;
  public static JLabel car22D;

  public static JLabel car33C;
  public static JLabel car33B;
  public static JLabel car33E;
  public static JLabel car33D;

  public static JLabel car44C;
  public static JLabel car44C2;
  public static JLabel car44B;
  public static JLabel car44E;
  public static JLabel car44E2;
  public static JLabel car44D;

  public static JSlider sliderCar1;
  public static JSlider sliderCar2;
  public static JSlider sliderCar3;
  public static JSlider sliderCar4;

  private City city;
  JButton startButton, backButton;
  JLabel imageCityBg;
  Icon cityBackground;
  Carro1 carro1;
  Carro2 carro2;
  Carro3 carro3;
  Carro4 carro4;
  private int pause=1;
  public static Semaphore mutexR1;
  public static Semaphore mutexR2;
  public static Semaphore mutexR3;
  public static Semaphore mutexR4;
  public static Semaphore mutexR5;

/* ***************************************************************
* Metodo: CityPanel
* Funcao: Inicializar os atributos da classe.
*************************************************************** */
  public CityPanel(City city){
    carro1 = new Carro1(this);
    carro2 = new Carro2(this);
    carro3 = new Carro3(this);
    carro4 = new Carro4(this);

    mutexR1 = new Semaphore(1);
    mutexR2 = new Semaphore(1);
    mutexR3 = new Semaphore(1);
    mutexR4 = new Semaphore(1);
    mutexR5 = new Semaphore(1);

    this.city=city;
    this.setSize(899, 652);
    this.setLayout(null);
    this.setBounds(1, 0, 890, 645);
    this.setVisible(true);

    cityBackground = new ImageIcon("city2.png");
    imageCityBg = new JLabel(cityBackground);
    imageCityBg.setBounds(1, 0, 890, 645);

    startButton = new JButton("Start");
    startButton.setVisible(true);
    startButton.setBounds(700, 205, 80, 40);
    this.startButton.addActionListener(this);

    backButton = new JButton("Pause");
    backButton.setVisible(true);
    backButton.setBounds(790, 205, 80, 40);
    this.backButton.addActionListener(this);

    car1C = new ImageIcon("carro1Cima.png");
    car11C = new JLabel(car1C);
    car11C.setBounds(460, 220, 40, 77);
    car11C.setVisible(false);

    car1B = new ImageIcon("carro1Baixo.png");
    car11B = new JLabel(car1B);
    car11B.setBounds(605, 100, 40, 77);

    car1E = new ImageIcon("carro1Esquerda.png");
    car11E = new JLabel(car1E);
    car11E.setBounds(565, 262, 77, 40);
    car11E.setVisible(false);

    car1D = new ImageIcon("carro1Direita.png");
    car11D = new JLabel(car1D);
    car11D.setBounds(460, 100, 77, 40);
    car11D.setVisible(false);

    car2C = new ImageIcon("carro2Cima.png");
    car22C = new JLabel(car2C);
    car22C.setBounds(290, 500, 40, 77);

    car2B = new ImageIcon("carro2Baixo.png");
    car22B = new JLabel(car2B);
    car22B.setBounds(605, 260, 40, 77);
    car22B.setVisible(false);

    car2E = new ImageIcon("carro2Esquerda.png");
    car22E = new JLabel(car2E);
    car22E.setBounds(590, 543, 77, 40);
    car22E.setVisible(false);

    car2D = new ImageIcon("carro2Direita.png");
    car22D = new JLabel(car2D);
    car22D.setBounds(300, 260, 77, 40);
    car22D.setVisible(false);

    car3C = new ImageIcon("carro3.png");
    car33C = new JLabel(car3C);
    car33C.setBounds(153, 490, 40, 77);

    car3B = new ImageIcon("carro3Baixo.png");
    car33B = new JLabel(car3B);
    car33B.setBounds(290, 100, 40, 77);
    car33B.setVisible(false);

    car3E = new ImageIcon("carro3Esquerda.png");
    car33E = new JLabel(car3E);
    car33E.setBounds(230, 545, 77, 40);
    car33E.setVisible(false);

    car3D = new ImageIcon("carro3Direita.png");
    car33D = new JLabel(car3D);
    car33D.setBounds(153, 100, 77, 40);
    car33D.setVisible(false);

    car4C = new ImageIcon("carro4Cima.png");
    car44C = new JLabel(car4C);
    car44C.setBounds(605, 345, 40, 77);
    car44C.setVisible(false);

    car4C2 = new ImageIcon("carro4Cima2.png");
    car44C2 = new JLabel(car4C2);
    car44C2.setBounds(290, 235, 40, 77);
    car44C2.setVisible(false);

    car4B = new ImageIcon("carro4.png");
    car44B = new JLabel(car4B);
    car44B.setBounds(153, 100, 40, 77);

    car4E = new ImageIcon("carro4Esquerda.png");
    car44E = new JLabel(car4E);
    car44E.setBounds(575, 261, 77, 40);
    car44E.setVisible(false);

    car4E2 = new ImageIcon("carro4Esquerda2.png");
    car44E2 = new JLabel(car4E2);
    car44E2.setBounds(280, 100, 77, 40);
    car44E2.setVisible(false);

    car4D = new ImageIcon("carro4Direita.png");
    car44D = new JLabel(car4D);
    car44D.setBounds(153, 400, 77, 40);
    car44D.setVisible(false);

    sliderCar1 = new JSlider();
    sliderCar1.setMaximum(10);
    sliderCar1.setMinimum(5);
    sliderCar1.setValue(7);
    sliderCar1.setVisible(true);
    sliderCar1.setPaintTicks(true);
    sliderCar1.setMajorTickSpacing(1);
    sliderCar1.setSnapToTicks(true);
    sliderCar1.setBounds(730, 255, 100, 120);
    sliderCar1.addChangeListener(new ChangeListener(){
    public void stateChanged(ChangeEvent e) {
      JSlider comp = (JSlider) e.getSource();
      if(!comp.getValueIsAdjusting())
        carro1.setVelocidade(103-(comp.getValue()*10));
      }//fim do stateChanged
    }//fim do ChangeListener
    );//fim do addChangeListener

    sliderCar2 = new JSlider();
    sliderCar2.setMaximum(10);
    sliderCar2.setMinimum(5);
    sliderCar2.setValue(7);
    sliderCar2.setVisible(true);
    sliderCar2.setPaintTicks(true);
    sliderCar2.setMajorTickSpacing(1);
    sliderCar2.setSnapToTicks(true);
    sliderCar2.setBounds(730, 335, 100, 120);
    sliderCar2.addChangeListener(new ChangeListener(){
    public void stateChanged(ChangeEvent e) {
      JSlider comp = (JSlider) e.getSource();
      if(!comp.getValueIsAdjusting())
        carro2.setVelocidade(103-(comp.getValue()*10));
      }//fim do stateChanged
    }//fim do ChangeListener
    );//fim do addChangeListener

    sliderCar3 = new JSlider();
    sliderCar3.setMaximum(10);
    sliderCar3.setMinimum(5);
    sliderCar3.setValue(7);
    sliderCar3.setVisible(true);
    sliderCar3.setPaintTicks(true);
    sliderCar3.setMajorTickSpacing(1);
    sliderCar3.setSnapToTicks(true);
    sliderCar3.setBounds(730, 415, 100, 120);
    sliderCar3.addChangeListener(new ChangeListener(){
    public void stateChanged(ChangeEvent e) {
      JSlider comp = (JSlider) e.getSource();
      if(!comp.getValueIsAdjusting())
        carro3.setVelocidade(103-(comp.getValue()*10));
      }//fim do stateChanged
    }//fim do ChangeListener
    );//fim do addChangeListener

    sliderCar4 = new JSlider();
    sliderCar4.setMaximum(10);
    sliderCar4.setMinimum(5);
    sliderCar4.setValue(7);
    sliderCar4.setVisible(true);
    sliderCar4.setPaintTicks(true);
    sliderCar4.setMajorTickSpacing(1);
    sliderCar4.setSnapToTicks(true);
    sliderCar4.setBounds(730, 495, 100, 120);
    sliderCar4.addChangeListener(new ChangeListener(){
    public void stateChanged(ChangeEvent e) {
      JSlider comp = (JSlider) e.getSource();
      if(!comp.getValueIsAdjusting())
        carro4.setVelocidade(103-(comp.getValue()*10));
      }//fim do stateChanged
    }//fim do ChangeListener
    );//fim do addChangeListener

    this.add(backButton);
    this.add(startButton);
    this.add(sliderCar1);
    this.add(sliderCar2);
    this.add(sliderCar3);
    this.add(sliderCar4);

    this.add(car11C);
    this.add(car11B);
    this.add(car11E);
    this.add(car11D);

    this.add(car22C);
    this.add(car22B);
    this.add(car22E);
    this.add(car22D);

    this.add(car33C);
    this.add(car33B);
    this.add(car33E);
    this.add(car33D);

    this.add(car44C);
    this.add(car44C2);
    this.add(car44B);
    this.add(car44E);
    this.add(car44E2);
    this.add(car44D);

    this.add(imageCityBg);
    this.setVisible(true);

  }//fim do metodo

  /* ***************************************************************
* Metodo: actionPerformed
* Funcao: Adiciona evento nos botões.
* Retorno: void  
*************************************************************** */
  public void actionPerformed(ActionEvent e) { 
    if(e.getSource() == backButton){
      if(pause==1){
        carro1.suspend();
        carro2.suspend();
        carro3.suspend();
        carro4.suspend();
        backButton.setText("Resume");
        pause=2;
      }//fim do if
      else{
        carro1.resume();
        carro2.resume();
        carro3.resume();
        carro4.resume();
        backButton.setText("Pause");
        pause=1;
      }//fim do else
      //this.city.showStartPanel();
    }//fim do if 
    else{
      carro1.start();
      carro2.start();
      carro3.start();
      carro4.start();
      startButton.setEnabled(false);
    }//fim do else
  }//fim do metodo

}//fim da classe