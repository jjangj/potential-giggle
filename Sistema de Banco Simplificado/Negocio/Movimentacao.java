package banco.Negocio;

/*classe do modelo de negocio que implementa as funcionalidades
 * da movimentação de uma conta bancaria
 */

import java.util.Date;

public class Movimentacao {
    private Date dataTime;
    private boolean Ehcredito;
    private double valor;
    private Conta conta;
    

 public Movimentacao(Conta novaconta, boolean ehcredito, double novovalor){
  this.dataTime = new Date();
  this.Ehcredito = ehcredito;
  this.valor = novovalor;
  this.conta = novaconta;
 }
         
         
    public Date getData() {
        return dataTime;
    }

    public boolean isCredito() {
        return Ehcredito;
    }
    
    public double getValor() {
        return valor;
    }

       
}