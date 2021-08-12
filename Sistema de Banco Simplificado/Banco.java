package banco;

import banco.Tela.*;
import java.util.Scanner;

/*essa é a classe onde reside o metodo main, ela é a classe de interface
 * com o usuario.Nesta classe podemos criar um formulario de interface grafica.
 
 * As classes do "modelo de negocio" estao no pacote banco.negocio
 * e são: Pessoa,Conta e Movimentacao;
 
 * A classe que faz a ligaçao entre a classe da interface com o usuario (Banco)
 * e as classes do "Modelo de negocio" é a FachadaBanco
 * 
 */
public class Banco {

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela().setVisible(true);
            }
        });
    }

    /* public static void main(String[] args) {
      /*classe fachada, onde invocamos todas as classes do negocio    
       * aqui nao referenciamos as classes do modelo de negocio.
      
      FachadaBanco f = new FachadaBanco();  //cria no inciio do programa
      Scanner sc = new Scanner(System.in); //cria a entrada do teclado
       int opcao = 1;
       while (opcao>0){
         opcao = Telas.TelaPrincipal(sc);
         switch (opcao) {
            case 1:
                Telas.TelaCadastrarCliente(sc,f);
                break;
            case 2:
                Telas.TelaConsultarCliente(sc,f);
                break;
            default:
                 System.out.println("\nEsta é uma opção inválida!!!");
                 opcao = Telas.TelaPrincipal(sc);                
       
       }
       
    }
       System.out.println("Obrigado por usar o nosso sistema bancário!!! Tchau!!!");
    }
     */
}
