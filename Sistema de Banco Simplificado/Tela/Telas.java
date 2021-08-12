/*
 * Classe que possui metodos estaticos para apresentacao 
 * das telas do sistema. Favor consultar o que é um metodo estatico.
 */

package banco.Tela;

import java.util.Scanner;
import banco.FachadaBanco;

/**
 *
 * @author Hélio Lopes
 */
public class Telas {
    
    
      public static int TelaPrincipal(Scanner sc){
       
       System.out.println("Bem Vindo ao sistema Bancario da Turma de AP II");
       System.out.println("");
       System.out.println("Escolha uma das seguintes opções do menu: ");
       System.out.println("");
       System.out.println("Numero da opção: ");
       System.out.println("1 - Cadastrar cliente");
       System.out.println("2 - Consultar cliente");
       System.out.println("0 - sair do sistema");
       System.out.print("Digite a sua opção: ");
       return sc.nextInt();
    }
    
    public static void TelaCadastrarCliente(Scanner sc, FachadaBanco f){
       System.out.println("Cadastrar um novo cliente.");
       
       System.out.println("Digite o nome do cliente: ");
       String nome = sc.next();
       
       System.out.println("Digite o cpf do cliente: ");
       String cpf = sc.next();
       
       
       System.out.println("Digite o endereco do cliente: ");
       String endereco = sc.next();
        
       //chama o metodo da fachada para cadastrar o novo cliente
       f.CadastrarCliente(cpf, nome, endereco);
       
       System.out.println("Cliente de nome: " + nome + " e cpf " + cpf + " cadastrado com sucesso!!!");
      
    }
    
    public static String TelaConsultarCliente(Scanner sc, FachadaBanco f){
        
       System.out.println("Consultar um cliente.");
       
       System.out.println("Digite o cpf do cliente: ");
       String cpf = sc.next();

       //chama o metodo da fachada para consultar o cliente
       f.ConsultarCliente(cpf);
             return "";  
    }
}