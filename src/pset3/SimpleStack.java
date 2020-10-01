package pset3;
import java.util.EmptyStackException;

public class SimpleStack {
	
	private String[] array;
	private int first;
	private static final int CAPACITY = 10;
	
	public SimpleStack() {
		array = new String[CAPACITY];
		first = -1;
	}
	
	public boolean empty() {
		boolean empty = (first == -1);
		return (empty);
	}
	
	public String peek() {
		checkUnderflowError();
		return array[first];
	}
	
	public String pop() {
		checkUnderflowError();
		String element = array[first];
		first--;
		return element;
	}
	
	public void push(String s) {
		first++;
		array[first] = s;
	}
	
	public int search(String s) {
		for(int i = 0; i < size(); i++) {
			if(array[i].equals(s)) {
				return size() - i;
			}
		}
		return -1;
	}
	
	public int size() {
		return first + 1;
	}
	
	public String toString() {
		String s = "[";
		for(int i = 0; i < size()-1; i++) {
            s +=  array[i];
            s += ", ";
        }
		if(size() != 0) {
			s += array[size()-1];
		}
		s += "]";
		return s;
	}
	
	private void checkUnderflowError() {
		if(empty()) {
			throw new EmptyStackException();
		}
	}

}