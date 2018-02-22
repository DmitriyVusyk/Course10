package module6;

import java.util.Arrays;

public class MainTest {

    public static void main(String[] args) {

    // Test of MyArrayList:

        System.out.println("----------TEST OF ARRAYLIST:");

        MyArrayList<Integer> arrayList = new MyArrayList<>();

        System.out.println(arrayList.add(1));
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("size: " + arrayList.size());

        System.out.println("remove: " + arrayList.remove(3));
        arrayList.remove(3);
        System.out.println("print arraylist: ");
        arrayList.printList();

        System.out.println("Get element:" + arrayList.get(2));
        arrayList.clear();
        System.out.println("Print list after clear: ");
        arrayList.printList();

    // Test of MyLinkedList

        System.out.println("----------TEST OF LINKEDLIST:");

        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);


        System.out.println("LinkedList after filling: ");
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println("size: " + linkedList.size());
        System.out.println("Get element at index: " + linkedList.get(3));
        System.out.println("Remove element at index 2 :" + linkedList.remove(2));
        System.out.println("LinkedList after removing of the element: ");
        System.out.println(Arrays.toString(linkedList.toArray()));
        System.out.println("Linked list after clearing: ");
        linkedList.clear();
        System.out.println(Arrays.toString(linkedList.toArray()));

     //Test of my Queue
        System.out.println("----------TEST OF QUEUE:");

        MyQueue<Integer> queue = new MyQueue<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println("Queue after filling: ");
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println("size: " + queue.size());
        System.out.println("Peek element in queue: " + queue.peek());
        System.out.println("Remove element at index : " + queue.remove(2));
        System.out.println("Queue after removing of the element: ");
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println("Poll: " + queue.poll());
        System.out.println("Queue after poll(): ");
        System.out.println(Arrays.toString(queue.toArray()));
        System.out.println("Queue after clearing: ");
        queue.clear();
        System.out.println(Arrays.toString(linkedList.toArray()));
    }

}
