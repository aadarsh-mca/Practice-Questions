package stack;

import java.util.LinkedList;

public class GenericStack<T> {
	//
	private LinkedList<T> linkedList;
	
	public GenericStack() {
		linkedList = new LinkedList<T>();
	}
	
	public void push(T obj) {
		linkedList.addFirst(obj);
	}
	
	public T pop() {
		return linkedList.removeFirst();
	}
	
	@Override
	public String toString() {
		return linkedList.toString();
	}
}
