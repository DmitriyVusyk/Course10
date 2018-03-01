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


        //Test of MySack
        System.out.println("----------TEST OF STACK:");

        MyStack<Integer> stack = new MyStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Stack after filling: ");
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println("size" + stack.size());
        System.out.println("Peek first element in stack: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack after pop: ");
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println("Remove element at index : ");
        stack.remove(2);
        System.out.println("Stack after remove: ");
        System.out.println(Arrays.toString(stack.toArray()));
        System.out.println("Stack after clearing: ");
        stack.clear();
        System.out.println(Arrays.toString(stack.toArray()));

        //Test of MyHashMap
        MyHashMap<String, Integer> map = new MyHashMap<>();

        System.out.println("----------TEST OF HASHMAP:");
        System.out.println("Fill MyHashMap:  ");
        map.put("1", 111);
        map.put("2", 222);
        map.put("3", 333);
        map.put("4", 444);
        map.put("5", 555);
        map.put("6", 666);
        map.put("7", 777);
        map.put("8", 888);
        System.out.println(map);

        System.out.println("Getting value from element: " + map.get("3"));

        System.out.println("Removing element: ");
        map.remove("2");
        System.out.println(map);
        System.out.println("Count of elements in Map: " + map.size());
        System.out.println("Clearing HashMap:");
        map.clear();
        System.out.println(map);
    }

}
