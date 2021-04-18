class LinkedList{

    private ListNode head = null;
    private ListNode tail = null;
    private int n = 0;

    public void addFirst(Object o){
        head = new ListNode(o, head);
        if(n==0){
            tail = head;
        }
        n++;
    }

    public void add(Object o){
        //new head
        if(n==0){
            addFirst(o);
        }
        //add to end of list
        else{
            tail.next = new ListNode(o, null);
            tail = tail.next;
            n++;
        }
    }

    public Object get(int i){  
        //if insertion point exceeds linked list dimensions   
        if(i<0 || i>= n){
            return null;
        }
        //walk through list
        ListNode node = head;
        for(int j=0; j<i; j++){
            node = node.next;
        }
        return node.element;
    }

    public void insert(Object o, int i){
        //if insertion point exceeds linked list dimensions
        if(i<0 || i> n){
            return;
        }
        //new head
        if(i==0){
            addFirst(o);
            return;
        }
        //walk through list
        ListNode node = head;
        for(int j=0; j<i-1; j++){
            node = node.next;
        }
        //insertion
        node.next = new ListNode(o, node.next);
        //new tail
        if(i==n){
            tail = node.next;
        }
        n++;
    }

    public void remove(int i){
        //if insertion point exceeds linked list dimensions
        if(i<0 || i>= n){
            return;
        }
        //new head
        if(i==0){
            head = head.next;
            n--;
            return;
        }
        //walk through list
        ListNode node = head;
        ListNode prev = null;
        for(int j=0; j<i; j++){
            prev = node;
            node = node.next;          
        }
        //new tail
        if(i==n-1){
            tail = prev;
            tail.next = null;
        }
        //node removal
        else{
            prev.next = node.next;
        }
        n--;
    }

}