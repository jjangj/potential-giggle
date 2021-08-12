package q3;

public class Principal {

    public static void main(String[] args) {
        
        Arvore a = new Arvore();
        String expressao = "((5*6)+(4-(5/2)))";
        a.inserir(expressao);
        a.calculo();
        a.printPosOrder();
    }
    
}
