/** A stack abstract data type that contains Strings. */
public class StringStack {
	
	private String[] stack;
	private int head;
	private int len;
	
	/**
	* Constructor for creating a new StringStack with a certain capacity.
	* @param capacity the maximum number of strings the stack can hold
	*/
	public StringStack(int capacity) {
		stack = new String[capacity];
		len = capacity;
		head = -1;
	}
	
	/**
	* Puts the given String on top of the stack (if there is enough space).
	* @param s the String to add to the top of the stack
	* @return false if there was not enough space in the stack to add the string;
	*         otherwise true
	*/
	public boolean push(String s) {
		if (head < len-1 && len>0){
			head++;
			stack[head] = s;
			return true;	
		}
		return false;
	}
	
	/**
	* Removes the String on top of the stack from the stack and returns it.
	* @return the String on top of the stack, or null if the stack is empty.
	*/
	public String pop() {
		if(head >= 0){
			return stack[head--];
		}
		return null;
	}
	
	/**
	* Returns the number of Strings in the stack.
	* @return the number of Strings in the stack
	*/
	public int count() {
		return head+1;
	}
}
