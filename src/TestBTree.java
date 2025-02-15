import java.util.Scanner;

class TestBTree {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        BTree<Integer> t = LibBTree.readIntTree(scn);

        System.out.println("numberNodes = " + t.numberNodes());
        System.out.println("depth = " + t.depth());
        System.out.println("contains(2) = " + t.contains(2));
        System.out.println("contains(3) = " + t.contains(3));

        t.printPreOrder();
        t.printInOrder();
        t.printPostOrder();
        t.printBFS();
        t.printDFS();
    }
}