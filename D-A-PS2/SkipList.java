class SkipList {
    private SkipListNode[] head;
    private int n = 0; // list size
    private int MAX_LANES = 5;

    public SkipList() {
        head = new SkipListNode[MAX_LANES];
        //fill head with null pointers
        for(int i = 0; i<MAX_LANES; i++){
            head[i] = new SkipListNode("", 1);
        }
    }

    public void createTestList() {
        //head 
        head[0].next[0] = head[1].next[0] = head[2].next[0] = new SkipListNode("Anne", 3);
        //base level pointers
        head[0].next[0].next[0] = new SkipListNode("Ben", 1);
        head[0].next[0].next[0].next[0] = new SkipListNode("Charlie", 2);
        head[0].next[0].next[0].next[0].next[0] = new SkipListNode("Don", 1);
        head[0].next[0].next[0].next[0].next[0].next[0] = new SkipListNode("Ernie", 3);
        n = 5;
        //Annie's pointers
        head[1].next[0].next[1] = head[0].next[0].next[0].next[0];
        head[2].next[0].next[2] = head[0].next[0].next[0].next[0].next[0].next[0];

        //Charlies pointers
        head[1].next[0].next[1].next[1] = head[0].next[0].next[0].next[0].next[0].next[0];

        //Ernie's pointers 
        head[2].next[0].next[2].next[0] = null;
        head[2].next[0].next[2].next[1] = null;
        head[2].next[0].next[2].next[2] = null;
    }

    public void print() {
        int i = MAX_LANES-1;
        SkipListNode curr = head[i];
        //find top lane
        while(curr.next[0] == null){
            i--;
            curr = head[i];
        }
        curr = curr.next[0];
        //walk through lanes
        while(true){
            while(curr != null){
                if(curr.element != null){
                    System.out.print(curr.element+", ");
                }      
                curr = curr.next[i];
            }
            if(i == 0){
                break;
            }
            System.out.println();
            curr = head[--i].next[0];
        }
        
    }

    public boolean inList(String s) {
        int i = MAX_LANES-1;
        SkipListNode curr = head[i];
        //find top lane
        while(curr.next[0] == null){
            i--;
            curr = head[i];
        }
        //go to first element of top lane
        curr = curr.next[0];
        while(true){
            //walk through lane until next element is bigger than s or end of lane
            while(curr.next[i] != null && curr.next[i].element.compareTo(s) <=0){
                curr = curr.next[i];
            }
            //found element
            if(curr.element.compareTo(s) == 0){
                return true;
            }
            //break if at end of lane or on bottom lane and element not found
            if(i == 0 || curr.next[0] == null){
                break;
            }
            //if s is between curr and next, drop down to next lane
            if(curr.element.compareTo(s)<=0 && curr.next[i].element.compareTo(s)>0){
                i--;
            }
            //start at top of next lane
            else{
                curr = head[--i].next[0];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SkipList sl = new SkipList();
        sl.createTestList();
        sl.print();
        System.out.println();

        System.out.println(sl.inList("Anne") + " should be true");
        System.out.println(sl.inList("Ben") + " should be true");
        System.out.println(sl.inList("Charlie") + " should be true");
        System.out.println(sl.inList("Don") + " should be true");
        System.out.println(sl.inList("Ernie") + " should be true");

        System.out.println(sl.inList("Arya") + " should be false");
        System.out.println(sl.inList("Elmo") + " should be false");
        System.out.println(sl.inList("Zorro") + " should be false");
    }
}
