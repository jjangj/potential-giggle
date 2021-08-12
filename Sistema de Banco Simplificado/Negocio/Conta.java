package banco.Negocio;

/*classe do modelo de negocio que implementa as funcionalidades
 * de uma conta bancária.
 */

import java.util.ArrayList;
import java.util.List;

public class Conta {
    private Pessoa dono;
    private int idConta;
    private double saldo;
    private boolean EstaAtiva;
    private List <Movimentacao> minhasMovimentacoes;
    
    public Conta(Pessoa dono, int idConta, double saldo) {
        this.dono = dono;
        this.idConta = idConta;
        saldo=0;
        this.EstaAtiva = true;
        this.minhasMovimentacoes = new ArrayList<>();
    }
    
    
    public void Depositar(double valor) {
        saldo+=valor;
        Movimentacao m = new Movimentacao(this,true,valor);
        this.minhasMovimentacoes.add(m);
    }
    
    public boolean Sacar(double valor) {
        //verificar se tem saldo
        if (this.getSaldoAtual()>=valor){
            saldo-=valor;
          Movimentacao m = new Movimentacao(this,false,valor);
          this.minhasMovimentacoes.add(m);
          return true;
        }
        else return false;
        
    }

    public Pessoa getDono() {
        return dono;
    }

    public int getIdConta() {
        return idConta;
    }

    public double getSaldoAtual() {
        return saldo;
   }
       
    protected boolean IsAtivo(){ 
         return this.EstaAtiva;                
    }
   
   protected void Desativa(){
    this.EstaAtiva = false;
   }
}
