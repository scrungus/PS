public class AVLTreeNode {
    public String value;
    public int balance;
    public int height;
    public AVLTreeNode left;
    public AVLTreeNode right;

    public AVLTreeNode(String value){
        this.value = value;
        balance = 0;
        height = 0;
        left = right = null;
    }
}
