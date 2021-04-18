
public class DNABook implements SocialNetwork {

    private int SIZE = 100;
    private String[] users = new String[SIZE];
    private int[][] friendships = new int[SIZE][SIZE];
    private int head = -1;

    private int findUser(String name){
        int mid = head/2;
        int first = 0;
        int last = head;
        if(head == 0){
            return -1;
        }
        while(first <= last){
            if(users[mid].equals(name)){
                return mid;
            }
            if(users[mid].compareTo(name) < 0){
                first = mid+1;

            }
            else{
                last = mid-1;
            }
            mid = (first+last)/2;
        }
            return -1;
    }

    @Override
    public void registerUser(String name) {
        if (findUser(name) == -1){
            if(++head < SIZE){
                users[head] = name;
            }
        }
    }

    @Override
    public void becomeFriends(String name1, String name2) {
        int nUID1 = findUser(name1);
        int nUID2 = findUser(name2);

        if((nUID1 != -1) &&
           (nUID2 != -1)){

            friendships[nUID1][nUID2] = 1;
            friendships[nUID2][nUID1] = 1;
        }

    }

    @Override
    public boolean areTheyFriends(String name1, String name2) {
        int nUID1 = findUser(name1);
        int nUID2 = findUser(name2);

        if((nUID1 != -1) && 
           (nUID2 != -1) &&
           (friendships[nUID1][nUID2] == 1)){
            return true;
        }

        return false;
    }

}