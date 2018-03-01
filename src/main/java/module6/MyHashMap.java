package module6;

import java.util.Map;
import java.util.Objects;

/**
 * My implementation of HashMap
 * @param <K> key type
 * @param <V> value type
 */
public class MyHashMap<K, V> {

    /**
     * The load factor used when none specified in constructor.
     */
    static private final float DEFAULT_LOAD_FACTOR = 0.75f;
    static private final int MAXIMUM_CAPACITY = 1 << 30;
    static private final int CAPACITY_GROW_FACTOR = 2;
    static private final int DEFAULT_INITIONAL_CAPASITY = 16;

    /**
     * The table, initialized on first use, and resized as
     * necessary. When allocated, length is always a power of two.
     * (We also tolerate length zero in some operations to allow
     * bootstrapping mechanics that are currently not needed.)
     */
    private transient Node[] table;

    /**
     * The number of key-value mappings contained in this map.
     */
    private transient int size;

    private int capacity;

    private transient int threshold;

    /**
     * The load factor for the hash table.
     *
     * @serial
     */
    private final float loadFactor;

    public MyHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.capacity = DEFAULT_INITIONAL_CAPASITY;
        calculateThreshold();
        this.table = new Node[DEFAULT_INITIONAL_CAPASITY];
    }

    /**
     * Calculate hashcode of key
     */
    static int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    /**
     * put the <code>value</code> for null key
     *
     * @param value value for null key
     */
    private V putForNullKey(V value) {
        addEntry(0, null, value, 0);
        return value;
    }

    /**
     * calculate index of Object in HashMap
     *
     * @param h      hash of Key
     * @param length of HashMap
     * @return index for place in HashMap
     */
    private static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private Node<K, V> newNode(int hash, K key, V value, Node<K, V> next) {
        return new Node<>(hash, key, value, next);
    }

    private void addEntry(int hash, K key, V value, int index) {
        Node<K, V> e = table[index];
        table[index] = new Node<>(hash, key, value, e);
    }

    private void calculateThreshold() {
        this.threshold = (int) (this.capacity * loadFactor);
    }

    /**
     * grow capacity of HashMap
     */
    private void growCapacity() {
        this.capacity = capacity * CAPACITY_GROW_FACTOR;
    }

    /**
     * resize HashMap
     */
    private void resize() {
        Node[] arrayToTransfer = table;
        growCapacity();
        calculateThreshold();
        this.table = transfer(arrayToTransfer);

    }

    /**
     * transfer all elements from old Node array to new Node array
     *
     * @param arrayToTransfer array with old capacity
     * @return array with new Capacity
     */
    private Node[] transfer(Node[] arrayToTransfer) {
        Node[] resultArray = new Node[capacity];
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                resultArray[i] = null;
            } else {
                int index = indexFor(table[i].hash, resultArray.length);
                resultArray[index] = table[i];
            }
        }
        return resultArray;
    }


    private void overflowControl() {
        if (size == threshold) {
            resize();
        }
    }

    /**
     * add element to map
     *
     * @param key   key
     * @param value value
     * @return value of added element
     */
    public V put(K key, V value) {
        if (key == null) {
            return putForNullKey(value);
        }

        int hash = hash(key.hashCode());
        int positionInArray = indexFor(hash, table.length);

        addEntry(hash, key, value, positionInArray);
        size++;

        overflowControl();
        return value;
    }

    /**
     * remove element with <code>key</code> from map
     *
     * @param key key of element which will be removed
     */
    public void remove(K key) {
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                break;
            } else if (table[i].key == key && (table[i].key).equals(key)) {
                table[i] = null;
                size--;
            }
        }
    }

    /**
     * clears the map
     */
    public void clear() {
        for (int i = 0; i < table.length; i++) {
            table[i] = null;
        }
        size = 0;
    }

    /**
     * Returns count of elements in map
     *
     * @return size of the map
     */
    public int size() {
        return size;
    }

    /**
     * Getting value of element with <code>key</code>
     *
     * @param key key of element
     * @return value of element
     */
    public V get(K key) {
        for (Node node :
                table) {
            if (node.key.equals(key) && node.key == key && node != null) {
                return (V) node.value;
            }
        }
        return null;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < table.length; i++) {
            if (table[i] == null) {
                stringBuilder.append("[null]");
                if (i != table.length - 1) {
                    stringBuilder.append(",");
                }
            } else {
                stringBuilder.append(table[i].toString()).append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    static class Node<K, V> implements Map.Entry<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }

        public final String toString() {
            return "[" + key + " = " + value + "]";
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }

        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }

        public final boolean equals(Object o) {
            if (o == this)
                return true;
            if (o instanceof Map.Entry) {
                Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
                if (Objects.equals(key, e.getKey()) &&
                        Objects.equals(value, e.getValue()))
                    return true;
            }
            return false;
        }
    }
}
