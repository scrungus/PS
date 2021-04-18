import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorter {

    public List<Contact[]> permutations = new ArrayList<Contact[]>();
    private Contact[] contacts = new Contact[10];

    public Sorter(){
        contacts[3] = new Contact("Webb","");
        contacts[8] = new Contact("Sophie-Louise","Bernard");
        contacts[4] = new Contact("King Sharma","Byers");
        contacts[0] = new Contact("John","Dee");
        contacts[1] = new Contact("Zackary","Hassan");
        contacts[5] = new Contact("Rojin","Mccormack");
        contacts[2] = new Contact("","Mercer");
        contacts[9] = new Contact("Madison","Munro");
        contacts[6] = new Contact("Edgar","Phan");
        contacts[7] = new Contact("Sayed","Quinn");
    }

    public void selectionSort(Contact[] contacts) {
        Contact[] sorted = new Contact[contacts.length];
        int i=0;
        
        while(i<contacts.length){
            Contact lowest = null;
            int j = -1;
            int storeJ = -1;
            while(lowest == null){
                j++;
                lowest = contacts[j];
                storeJ = j;
            } 
            for(j = 0; j<contacts.length; j++){
                if(contacts[j] != null){
                    if(contacts[j].compareTo(lowest) < 0){
                        lowest = contacts[j];
                        storeJ = j;
                    }
                }
            }
            sorted[i] = lowest;
            contacts[storeJ] = null;
            i++;
        }
        printArray(sorted);
    }

    public void insertionSort(){
        Contact[] contactsClone = this.contacts.clone();
        for(int i=1; i<contactsClone.length;i++){
            Contact curr = contactsClone[i];
            int j = i-1;

            while(j>= 0 && contactsClone[j].compareTo(curr) > 0){
                contactsClone[j+1] = contactsClone[j];
                permutations.add(contactsClone);
                j--; 
            }
            contactsClone[j+1] = curr;
            permutations.add(contactsClone);
        }
        System.out.println(Arrays.toString(permutations.get(0)));
        System.out.println(Arrays.toString(permutations.get(5)));
        System.out.println(Arrays.toString(permutations.get(10)));
    }

    private int partition(Contact[] contacts, int low, int high){
        Contact pivot = contacts[high];
        int i = low-1;

        for(int j=low; j< high; j++){
            if(contacts[j].compareTo(pivot) < 0){
                i++;
                Contact temp = contacts[j];
                contacts[j] = contacts[i];
                contacts[i] = temp;
            }
        }
        Contact temp = contacts[high];
        contacts[high] = contacts[i+1];
        contacts[i+1] = temp;
        return i+1;
    }

    private Contact[] quickSorter(Contact[] contacts, int low, int high){
        if(low < high){
            int partIndex = partition(contacts,low, high);

            quickSorter(contacts,low,partIndex-1);
            quickSorter(contacts,partIndex+1,high);
        }
        return contacts;
    }

    public void quickSort(Contact[] contacts) {
        Contact[] sorted = quickSorter(contacts,0,contacts.length-1);
        printArray(sorted);
    }

    private Contact[] merge(Contact[] contacts, int l, int m, int r){
        
        Contact[] left = new Contact[m+1-l];
        Contact[] right = new Contact[r-m];

        for(int i=l; i<m+1;i++){
            left[i-l] = contacts[i];
        }
        for(int i=m;i<r;i++){
            right[i-m] = contacts[i+1];
        }
        int i; int j; int k; i = j = 0; k=l;

        while(i<(m+1-l) && j<(r-m)){
            if(left[i].compareTo(right[j]) < 0){
                contacts[k] = left[i++];
            }
            else{
                contacts[k] = right[j++];
            }
            k++;
        }
        while(i<(m+1-l)){
            contacts[k++] = left[i++];
        }
        while(j<(r-m)){
            contacts[k++] = right[j++];
        }
        return contacts;
    }

    private Contact[] mergeSorter(Contact[] contacts, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSorter(contacts, l, m);
            mergeSorter(contacts, m+1, r);
            contacts = merge(contacts, l, m, r);
        }
        return contacts;
    }

    public void mergeSort(Contact[] contacts) {
        Contact[] sorted = mergeSorter(contacts,0,contacts.length-1);
        printArray(sorted);
    }

    public void printArray(Contact[] contacts){
        System.out.print("[");
        for(int i=0; i<contacts.length;i++){
            System.out.print("'"+contacts[i]+"', ");
        }
        System.out.println("]");
    }
}
