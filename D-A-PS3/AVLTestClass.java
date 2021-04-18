public class AVLTestClass {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.createTestTree();
        tree.print();
        System.out.println(tree.inTree("5"));
        System.out.println(tree.inTree("3"));
        System.out.println(tree.inTree("4"));
        System.out.println(tree.inTree("8"));
        System.out.println("7".compareTo("8"));
        System.out.println("1".compareTo("0"));
        tree.insert("8");
        System.out.println("Done");
        tree.insert("0");
        System.out.println("Done");
        tree.insert("4");
        System.out.println("Done");
        tree.insert("9");
        System.out.println("Done");
        System.out.println(tree.inTree("9"));
        tree.print();
    }
}
