class DoublyLinkedList {
    private ListNode2 head = null;
    private int n = 0; // list size

    /**
     * Prints out the elements in the list from the first to the last (front to back) and then from the last to the first
     * (back to front). This is useful to test whether the list nodes are connected correctly with next and prev references.
     */
    public void print() {
        // no elements to print for empty list
        if (head == null) {
            System.out.println("list empty.");
            return;
        }

        // follow next references to list elements from the front to the back of the list
        System.out.print("front to back: ");
        ListNode2 node = head;
        System.out.print(node.element + " ");
        while (node.next != null) {
            node = node.next;
            System.out.print(node.element + " ");
        }

        // follow prev references to list elements from the back to the front of the list
        System.out.print("-- and back to front: ");
        while (node != null) {
            System.out.print(node.element + " ");
            node = node.prev;
        }
        System.out.println();
    }

    public void addFirst(Object o){
        //if list is not empty
        if(n>0){
            //save old head and set its prev pointer to new head, set new head next pointer to old head
            ListNode2 old = head;
            head = new ListNode2(o,null, old);
            old.prev = head;
        }
        else{
            head = new ListNode2(o,null, null);
        }  
        n++;
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
        ListNode2 node = head;
        for(int j=0; j<i-1; j++){
            node = node.next;
        }
        //middle insertion
        if(node.next != null){
            node.next.prev = new ListNode2(o, node,node.next);
            node.next = node.next.prev;
        }
        //tail insertion
        else{
            node.next = new ListNode2(o, node,node.next);
        }
        n++;
    }

    public void remove(int i){
        //if insertion point exceeds linked list dimensions
        if(i<0 || i>= n){
            return;
        }
        //remove head
        if(i==0 && n>1){
            head = head.next;
            if(head != null){
                head.prev = null;
            }
            n--;
            return;
        }
        //walk through list
        ListNode2 node = head;
        for(int j=0; j<i; j++){
            node = node.next;          
        }
        //update surrounding node pointers
        if(node.prev != null){
            node.prev.next = node.next;
        }  
        if(node.next != null){
            node.next.prev = node.prev;     
        }
        n--;
    }

    public Object get(int i){    
        //if insertion point exceeds linked list dimensions 
        if(i<0 || i>= n){
            return null;
        }
        //walk through list
        ListNode2 node = head;
        for(int j=0; j<i; j++){
            node = node.next;
        }
        return node.element;
    }
}
