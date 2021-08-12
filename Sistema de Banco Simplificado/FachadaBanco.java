package banco;

/*vejam o link sobre o padrao de projeto fachada
 * http://www.devmedia.com.br/padrao-de-projeto-facade-em-java/26476
 */

import banco.Negocio.*;//importa todas as classes do pacote negocio

import java.util.ArrayList;
import java.util.List;

public class FachadaBanco {
    
    private List <Pessoa> meusClientes;    
    
    
    public FachadaBanco(){
     meusClientes = new ArrayList<>();
     
    }
    public void CadastrarCliente(String cpf,String nome,String endereco) {
        Pessoa p = new Pessoa(cpf, nome);
        p.setEndereco(endereco);
        
        meusClientes.add(p);
    }
      
    public String ConsultarCliente(String cpf) {
        
        /*se achou o cpf na lista entao retorne o cpf, senao 
        retorne vazio 
        */
        for (int i = 0; i < meusClientes.size(); i++) {
            if(meusClientes.get(i).getCpf().equals(cpf)){
                return cpf;
            }
        }
        return "";//modificar para funcionar corretamente
    }
    
    public void CadastrarConta(String cpf, String NumeroConta, double saldoInicial){
         Pessoa p=null;
         for (int i = 0; i < meusClientes.size(); i++) {
            if(meusClientes.get(i).getCpf().equals(cpf)){
                p = meusClientes.get(i);
            }
        }
         if(p==null){
             //não encontrou
         }else{
             Conta c = new Conta(p, 0, saldoInicial);
         }
         
    
    }
    public void RemoverConta(String cpf, String NumeroConta){
    
    }
    public void ConsultarConta(String cpf, String NumeroConta){}
    
    public void Sacar(String cpf, String NumeroConta,double valor){ }
    public void Depositar(String cpf, String NumeroConta,double valor){ }
    public void Transferencia(String cpforigem, String NumeroContaOrigem,
                              String cpfdest, String NumeroContaDest,
                              double valor){}
    
    public void VerSaldoAtual(String cpf, String NumeroConta){
    
    }
    
    
}
