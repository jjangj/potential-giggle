package q3;

public class Node {

    Valor valor;
    Node left;
    Node Right;
    
    public Node(){
        this.left=null;
        this.Right=null;
        this.valor = new Valor();
    }

    public Valor getValor() {
        return valor;
    }

    public void setValor(Valor valor) {
        this.valor = valor;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return Right;
    }

    public void setRight(Node Right) {
        this.Right = Right;
    }
    
    
}
