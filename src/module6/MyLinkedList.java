package module6;

/**
 * My implementation of LinkedList
 * @param <T>
 */
public class MyLinkedList<T> {

    /**
     * Pointer to first node.
     */
    private MyNode<T> first;

    /**
     * Pointer to last node.
     */
    private MyNode<T> last;
    private int size = 0;

    public MyLinkedList() {
    }

    /**
     * Links e as last element.
     */
    private void linkLast(T e) {
        final MyNode<T> l = last;
        final MyNode<T> newNode = new MyNode<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * Unlinks non-null node x.
     */
    private T unlink(MyNode<T> x) {
        assert x != null;
        final T element = x.item;
        final MyNode<T> next = x.next;
        final MyNode<T> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    private MyNode<T> node(int index) {

        if (index < (size >> 1)) {
            MyNode<T> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyNode<T> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }

    /**
     * add element to list
     *
     * @param value element whitch will be added
     */
    public void add(T value) {
        linkLast(value);
    }

    /**
     * remove element at index
     *
     * @param index index of element which will be removed
     * @return element which will be removed
     */
    public T remove(int index) {

        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return unlink(node(index));
    }

    /**
     * clear the LinkedList
     */
    public void clear() {
        for (MyNode<T> x = first; x != null; ) {
            MyNode<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * returns size of the list
     *
     * @return size
     */
    public int size() {
        return size;
    }

    /**
     * get element at index
     *
     * @param index index of the element
     * @return element at <code>index</code>
     */
    public T get(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        return node(index).item;
    }

    /**
     * Returns an array containing all of the elements in this list
     *
     * @return an array containing all of the elements in this list
     */
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (MyNode<T> x = first; x != null; x = x.next)
            result[i++] = x.item;
        return result;
    }

}

class MyNode<E> {
    E item;
    MyNode<E> next;
    MyNode<E> prev;

    MyNode(MyNode<E> prev, E element, MyNode<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}
