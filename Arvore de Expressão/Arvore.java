package q3;

import java.util.Stack;

public class Arvore {

    Node root;
    Node atual;
    Stack pilha;

    public Arvore() {
        this.root = null;
        this.pilha = new Stack();
    }
    
    public void calculo(){
        float resultado =calcular();
        System.out.println("O resultado é: " + resultado);
    }

    public float calcular() {
        switch (root.valor.valueC) {
            case '+':
                return calcular(root.left) + calcular(root.Right);
            case '-':
                return calcular(root.left) - calcular(root.Right);
            case '*':
                return calcular(root.left) * calcular(root.Right);
            case '/':
                return calcular(root.left) / calcular(root.Right);
            default:
                break;
        }//fim do switch
        return 0;
    }//fim do metodo

public float calcular(Node node) {
        if(node.valor.valueC=='#'){
            return node.valor.valueF;
        }//fim do if
        else{
            switch (node.valor.valueC) {
            case '+':
                return calcular(node.left) + calcular(node.Right);
            case '-':
                return calcular(node.left) - calcular(node.Right);
            case '*':
                return calcular(node.left) * calcular(node.Right);
            case '/':
                return calcular(node.left) / calcular(node.Right);
            default:
                break;
        }//fim do switch
        }//fim do else
        return 0;
    }

public void inserir(String expressao) {
        for (int i = 0; i < expressao.length(); i++) {
            if (expressao.charAt(i) == '(') {
                if (pilha.empty()) {
                    Node vazio = new Node();
                    Node prox = new Node();
                    //Node dir = new Node();
                    vazio.setLeft(prox);
                    //vazio.setRight(dir);
                    atual = vazio.getLeft();
                    pilha.add(vazio);
                    if(root==null)
                      root=vazio;
                }//fim do if
                else {
                    if(atual==null)
                      atual = new Node();
                    atual.valor.valueC = '#';
                    atual.valor.valueF = Integer.MAX_VALUE;
                    Node prox = new Node();
                    atual.setLeft(prox);
                    //Node dir = new Node();
                    //atual.setRight(dir);
                    pilha.add(atual);
                    atual = atual.getLeft();
                }//fim do else
            }//fim do if
            else if (expressao.charAt(i) == '+' || expressao.charAt(i) == '-'
                    || expressao.charAt(i) == '/' || expressao.charAt(i) == '*') {

                ((Node)pilha.peek()).getValor().valueC=expressao.charAt(i);
                ((Node)pilha.peek()).getValor().valueF = Integer.MAX_VALUE;
          
                if(((Node)pilha.peek()).getRight() == null){
                    ((Node)pilha.peek()).setRight(new Node());
                }
               
                atual=((Node)pilha.peek()).getRight();

            }//fim do else if
                
            else if(expressao.charAt(i)== ')'){
                pilha.pop();
            }//fim do else if
            else{
                //System.out.println(Integer.parseInt(expressao.charAt(i)+""));
                atual.valor.valueF = Integer.parseInt(expressao.charAt(i)+"");
                atual.valor.valueC = '#';
            }//fim do else
        }//fim do for
    }//fim do metodo

    public void printPosOrder() {
        if (root == null) {
            System.out.println("Arvore Vazia");
        }//fim do if
        else {
            System.out.println("Expressão na ordem pos Fixa:");
            printPosOrder(root);
        }//fim do else
    }//fim do metodo

 public void printPosOrder(Node root) {
        if (root != null) { //se a arvore nao estiver vazia
            printPosOrder(root.getLeft()); //busca o no mais profundo
            printPosOrder(root.getRight());//busca o no mais profundo 
            if(root.valor.valueF==Integer.MAX_VALUE){
                System.out.print(root.valor.valueC + " ");
            }
            else{
                System.out.print(root.valor.valueF + " ");
            }
            //System.out.print(" "+root.getValor().valueC+ ","+root.getValor().valueF+" "); //imprime
        }//fim do if
    }//fim do metodo

}//fim da classe
