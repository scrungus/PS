public class Sorter {

    public static void selectionSort(Contact[] contacts) {
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

    public static void insertionSort(Contact[] contacts){
        for(int i=1; i<contacts.length;i++){
            Contact curr = contacts[i];
            int j = i-1;

            while(j>= 0 && contacts[j].compareTo(curr) > 0){
                contacts[j+1] = contacts[j];
                j--; 
            }
            contacts[j+1] = curr;
        }
        printArray(contacts);
    }

    private static int partition(Contact[] contacts, int low, int high){
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

    private static Contact[] quickSorter(Contact[] contacts, int low, int high){
        if(low < high){
            int partIndex = partition(contacts,low, high);

            quickSorter(contacts,low,partIndex-1);
            quickSorter(contacts,partIndex+1,high);
        }
        return contacts;
    }

    public static void quickSort(Contact[] contacts) {
        Contact[] sorted = quickSorter(contacts,0,contacts.length-1);
        printArray(sorted);
    }

    private static Contact[] merge(Contact[] contacts, int l, int m, int r){
        
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

    private static Contact[] mergeSorter(Contact[] contacts, int l, int r){
        if(l < r){
            int m = (l+r)/2;
            mergeSorter(contacts, l, m);
            mergeSorter(contacts, m+1, r);
            contacts = merge(contacts, l, m, r);
        }
        return contacts;
    }

    public static void mergeSort(Contact[] contacts) {
        Contact[] sorted = mergeSorter(contacts,0,contacts.length-1);
        printArray(sorted);
    }

    public static void printArray(Contact[] contacts){
        System.out.print("[");
        for(int i=0; i<contacts.length;i++){
            System.out.print("'"+contacts[i]+"', ");
        }
        System.out.println("]");
    }
}
