package module6;

/**
 * My implementation of Queue
 *
 * @param <T>
 */
public class MyQueue<T> {

    MyLinkedList<T> queue = new MyLinkedList<>();

    MyQueue() {
    }

    /**
     * add element to the end of queue
     * @param value element which will be added
     * @return  true if element was added
     */
    public boolean add(T value) {
        queue.add(value);
        return true;
    }

    /**
     * remove element at index
     * @param index index of element which will be removed
     * @return element which will be removed
     */
    public T remove(int index) {
        return queue.remove(index);
    }

    /**
     * clears the LinkedList
     */
    public void clear() {
        queue.clear();
    }

    /**
     * returns size of the list
     * @return size of queue
     */
    public int size() {
       return queue.size();
    }

    /**
     * get first element in queue
     * @return first element in queue
     */
    public T peek() {
        return queue.get(0);
    }

    /**
     * return a first element in queue and remove it
     * @return first element in queue
     */
    public T poll() {
        return queue.remove(0);
    }

    public Object[] toArray(){
        return queue.toArray();
    }
}
