package module6;


/**
 * My implementation of stack
 *
 */
public class MyStack<T> {

    private MyLinkedList<T> stack = new MyLinkedList<>();

    public MyStack() {
    }

    /**
     * add element to the end of stack
     * @param value element which will be added to stack
     */
    public void push(T value) {
        stack.add(value);
    }

    /**
     * removes element from stack at <index>index</index>
     * @param index index of an element which will be removed
     */
    public void remove(int index) {
        stack.remove(index);
    }

    /**
     * clears the stack
     */
    public void clear() {
    stack.clear();
    }

    /**
     * return the size of stack
     * @return size of stack
     */
    public int size() {
    return stack.size();
    }

    /**
     * return first element in stack
     * @return first element in stack
     */
    public T peek() {
    return stack.get(stack.size() -1);
    }

    /**
     *return first element in the stack and removes it
     * @return first element in stack
     */
    public T pop() {
    return stack.remove(stack.size()-1);
    }

    public Object[] toArray(){
        return stack.toArray();
    }

}
