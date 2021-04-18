public class Contact implements Comparable<Contact> {
    public String firstName;
    public String lastName;

    public Contact(String f, String l) {
        firstName = f; lastName = l;
    }

    public String toString() {
        return firstName + " " + lastName;
    }

    public int compareTo(Contact c) {
        if(this.lastName.equals(c.lastName)){
            return this.firstName.compareTo(c.firstName);
        }
        return this.lastName.compareTo(c.lastName);
    }
}
