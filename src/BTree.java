import java.util.LinkedList;
import java.util.List;

public class BTree<T>{
    private BTNode<T> root;

    //Construtor
    BTree(){
        root = null;
    }

    //Getter e Setter
    public BTNode<T> getRoot(){ return root;}
    public void setRoot(BTNode<T> r){root = r;}

    //Verificar se árvore está vazia
    public boolean isEmpty(){return root == null;}
    public int depth(){return depth(root);}

    public int numberNodes(){
        return numberNodes(root);
    }

    private int numberNodes(BTNode<T> n){
        if(n == null)return 0;
        return 1 + numberNodes(n.getLeft()) + numberNodes(n.getRight());
    }

    private int depth(BTNode<T> n){
        if (n == null) return -1;
        return 1 + Math.max(depth(n.getLeft()), depth(n.getRight()));
    }

    public boolean contains(T value){return contains(root, value);}
    private boolean contains(BTNode<T> n, T value){
        if(n == null) return false;
        if (n.getValue().equals(value)) return true; {
            return contains(n.getLeft(), value) || contains(n.getRight(), value);
        }
    }
    
    
    public void printPreOrder(){
        System.out.print("PreOrder:");
        printPreOrder(root);
        System.out.println();
    }

    private void printPreOrder(BTNode<T> n){
        if (n ==null) return;
        System.out.print(" " + n.getValue());
        printPreOrder(n.getLeft());
        printPreOrder(n.getRight());
    }

    public void printInOrder(){
        System.out.print("InOrder:");
        printInOrder(root);
        System.out.println();
    }

    private void printInOrder(BTNode<T> n){
        if(n == null) return;
        printInOrder(n.getLeft());
        System.out.print(" " + n.getValue());
        printInOrder(n.getRight());
    }

    public void printPostOrder(){
        System.out.print("PostOrder:");
        printPostOrder(root);
        System.out.println();
    }
    private void printPostOrder(BTNode<T> n){
        if(n==null) return;
        printPostOrder(n.getLeft());
        printPostOrder(n.getRight());
        System.out.print(" " + n.getValue());
    }
    public void printBFS(){
        System.out.print("BFS:");
        LinkedList<BTNode<T>> q = new LinkedList<BTNode<T>>();
        q.add(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.remove();
            if(cur != null){
                System.out.print(" " + cur.getValue());
                q.add(cur.getLeft());
                q.add(cur.getRight());
            }
        }
        System.out.println();
    }
    public void printDFS(){
        System.out.print("DFS: ");
        LinkedList<BTNode<T>> q = new LinkedList<BTNode<T>>();
        q.add(root);
        while (!q.isEmpty()) {
            BTNode<T> cur = q.pop();
            if(cur != null){
                System.out.print(" " + cur.getValue());
                q.push(cur.getLeft());
                q.push(cur.getRight());
            }
        }
        System.out.println();
    }
}

    class BTNode<T>{
        private T value;
        private BTNode<T> left;
        private BTNode<T> right;

        //Constructor
        BTNode(T v, BTNode<T> l, BTNode<T> r){
            value = v; left = l; right = r;
        }

        //Getters e Setters
        public T getValue(){return value;}
        public BTNode<T> getLeft(){return left;}
        public BTNode<T> getRight(){return right;}
        public void setValue(T v){value = v;}
        public void setLeft(BTNode<T> l){left = l;}
        public void setRight(BTNode<T> r){right = r;}

    }
