/* ***************************************************************
* Autor: Jenifer de Jesus Jang
* Inicio: 11/11/2017
* Ultima alteracao: 24/11/2017
* Nome: Problema do transito automato.
* Funcao: Resolver problema do transito automato com semaforos
*************************************************************** */

public class Principal{
  public static void main(String args[]){
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }//fim do if
      }//fim do for
    } //fim do try
    catch (ClassNotFoundException ex) {}
    catch (InstantiationException ex) {}
    catch (IllegalAccessException ex) {}
    catch (javax.swing.UnsupportedLookAndFeelException ex) {}

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        City city = new City();
      }//fim do metodo
    }); //fim do runable
  }//fim da main
  
}//fim da classe
