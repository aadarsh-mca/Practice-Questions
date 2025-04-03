package linkedList;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GenericQueue<T> {
	//
	private LinkedList<T> linkedList;
	
	public GenericQueue() {
		linkedList = new LinkedList<T>();
	}
	
	public boolean add(T obj) {
		linkedList.addLast(obj);
		return true;
	}
	
	public T remove() {
		return linkedList.removeFirst();
	}
	
	@Override
	public String toString() {
		return linkedList.toString();
	}
}
