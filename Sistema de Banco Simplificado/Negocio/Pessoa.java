package banco.Negocio;

/*
 * Classe do modelo de negocio que implementa as funcionalidades dos
 * clientes do banco
 */
import java.util.ArrayList;
import java.util.List;

public class Pessoa {
    private String cpf;
    private String nome;
    private String endereco;
    private List <Conta> minhasContas;
    
    public Pessoa (String novocpf, String novonome){
     this.cpf = novocpf;
     this.nome = novonome;
     this.minhasContas = new ArrayList<>();
    }
    
    public String getEndereco(){
     return this.endereco;
    }    
    public void setEndereco(String novoend){
     this.endereco = novoend;    
    }
    
    public void AbrirConta(int numeroConta) {
        Conta c = new Conta(this,numeroConta,0);
        this.minhasContas.add(c);
    }
    public boolean FecharConta(int NumeroConta) {
       Conta c;
       c = this.RetornaConta(NumeroConta);
       if (c == null){
         return false;
       }
       else {
        c.Desativa();
        return true;
       }
    }
    
    public Conta RetornaConta(int NumeroConta) {
        //navegar na lista para achar a conta
        Conta c;
        for (int i=0; i<this.minhasContas.size();i++){
         c = this.minhasContas.get(i);
         if (c.getIdConta()== NumeroConta){
              return c;
         }
        }        
        return null;
        
    }
      
    
    

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }
   
    
}
