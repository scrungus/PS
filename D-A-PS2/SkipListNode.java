import java.util.Random;

public class SkipListNode {

    public String element;
    public SkipListNode[] next;
    private int MAX_LANES = 5;

    public SkipListNode(String s){
        element = s;
        Random r = new Random();
        int l = 1;
        while(r.nextFloat()<0.5 && l<MAX_LANES){
            l++;
        }
        next = new SkipListNode[l];
    }
    
    public SkipListNode(String s, int l){
        element = s;
          
        next = new SkipListNode[l];
    }
}