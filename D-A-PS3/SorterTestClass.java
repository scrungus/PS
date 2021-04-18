public class SorterTestClass {
    public static void main(String[] args) {
        Contact[] contacts = new Contact[10];
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

        Sorter.selectionSort(contacts.clone());
        Sorter.insertionSort(contacts.clone());
        Sorter.quickSort(contacts.clone());
        Sorter.mergeSort(contacts.clone());
    }
}
