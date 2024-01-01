package DSA;

import java.util.ArrayDeque;

public class StackUsingQueue {

    public static void main(String[] args) {
        ArrayDeque<Integer> list = new ArrayDeque<>();

        list.add(10);
        list.addFirst(20);
        list.addLast(30);
        list.remove();
        list.removeFirst();
        list.removeLast();
        list.getFirst();
        list.getLast();

    }

}