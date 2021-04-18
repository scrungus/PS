class AVLTree {
  AVLTreeNode root;
  // Note: you may define other variables here

  public AVLTree() {
    // TODO implement this
  }

  public void createTestTree() {
    root = new AVLTreeNode("4");
    root.left = new AVLTreeNode("2");
    root.right = new AVLTreeNode("6");
    
    root.left.left = new AVLTreeNode("1");
    root.left.right = new AVLTreeNode("3");

    root.right.left = new AVLTreeNode("5");
    root.right.right = new AVLTreeNode("7");
  }

  private void preOrder(AVLTreeNode node, String indent){
    if(node == null){
      return;
    }
    if(indent == null){
      indent = "";
    }
    System.out.println(indent+node.value);
    indent = indent+"  ";
    preOrder(node.left, indent);
    preOrder(node.right, indent);
  }

  public void print() {
    preOrder(root,null);  
  }

  private AVLTreeNode search(AVLTreeNode node, String e){
    if(node == null || node.value.equals(e)){
      return node;
    }
    if(node.value.compareTo(e) < 0){
      return search(node.right,e);
    }
    return search(node.left,e);
  }

  public boolean inTree(String e) { 
    AVLTreeNode result = search(root, e);

    if(result != null){
      return true;
    }
    return false;
  }

  private int getHeight(AVLTreeNode node){
    if(node == null){
      return 0;
    }
    return node.height;
  }

  private int updateHeight(AVLTreeNode node){
    if(getHeight(node.left) > getHeight(node.right)){
      return getHeight(node.left)+1;
    }
    return getHeight(node.right)+1;
  }

  private int getBalance(AVLTreeNode node){
    if(node == null){
      return 0;
    }
    return(getHeight(node.right) - getHeight(node.left));
  }

  private AVLTreeNode leftRotate(AVLTreeNode node){
    AVLTreeNode r_ST = node.right;
    AVLTreeNode r_l_ST = r_ST.left;
    
    r_ST.left = node;
    node.right = r_l_ST;

    r_ST.height = updateHeight(node);
    node.height = updateHeight(node);
    
    return r_ST;
  }

  private AVLTreeNode rightRotate(AVLTreeNode node){
    AVLTreeNode l_ST = node.left;
    AVLTreeNode l_r_ST = l_ST.right;
    
    l_ST.right = node;
    node.left = l_r_ST;

    l_ST.height = updateHeight(node);
    node.height = updateHeight(node);

    return l_ST;
  }

  private AVLTreeNode balance(AVLTreeNode node, String e){
    //LL
    if(node.balance < -1 && node.left.value.compareTo(e) > 0){
      node = rightRotate(node);
    }
    //RR
    else if(node.balance > 1 && node.right.value.compareTo(e) < 0){
      node = leftRotate(node);
    }
    //LR
    else if(node.balance < -1 && node.left.value.compareTo(e) < 0){
      node.left = leftRotate(node.left);
      node = rightRotate(node);
    }
    //RL
    else if(node.balance > 1 && node.right.value.compareTo(e) > 0){
      node.right = rightRotate(node.right);
      node = leftRotate(node);
    }
    return node;
  }
  private AVLTreeNode insertElement(AVLTreeNode node, String e){
    
    if(node == null){
      return new AVLTreeNode(e);
    }

    else if(node.value.compareTo(e) < 0){
      node.right = insertElement(node.right, e);
    }
    else if(node.value.compareTo(e) > 0){
      node.left = insertElement(node.left, e);
    }

    node.height = updateHeight(node);
    node.balance = getBalance(node);

    return balance(node,e);
  }

  public void insert(String e) { 
    root = insertElement(root, e);
  }
}
