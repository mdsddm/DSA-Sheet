package Hashing;

import java.util.ArrayList;
import java.util.LinkedList;

/*
put(K key, V value): Associates a specified value with a specified key in the map.
    If the key already exists, the old value is replaced.

get(Object key): Returns the value mapped to the specified key, or null if no mapping exists.

remove(Object key): Removes the key-value pair for the specified key from the map.

isEmpty(): Checks if the map contains no key-value mappings, returning true if empty.

size(): Returns the number of key-value mappings in the map.

containsKey(Object key): Checks if the map contains a mapping for the specified key.

containsValue(Object value): Checks if the map contains one or more keys mapped to the specified value.

clear(): Removes all key-value pairs from the map.

keySet(): Returns a Set view of all the keys contained in the map.

values(): Returns a Collection view of all the values contained in the map.

entrySet(): Returns a Set view of the mappings contained in the map as Map.Entry objects.
 */
public class HashMapImplementation {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        System.out.println("Is empty? " + hm.isEmpty()); // true

        hm.put("India", 100);
        hm.put("China", 150);
        hm.put("USA", 200);
        System.out.println("Size after inserts: " + hm.size()); // 3
        System.out.println("Is empty? " + hm.isEmpty()); // false

        System.out.println("Contains 'India'? " + hm.containsKey("India")); // true
        System.out.println("Contains 'Japan'? " + hm.containsKey("Japan")); // false

        System.out.println("Value for 'China': " + hm.get("China")); // 150
        System.out.println("Value for 'Japan': " + hm.get("Japan")); // null

        hm.put("India", 110); // update value
        System.out.println("Updated value for 'India': " + hm.get("India")); // 110

        System.out.println("Keys: " + hm.keySet()); // [India, China, USA]

        System.out.println("Removing 'China': " + hm.remove("China")); // 150
        System.out.println("Size after removal: " + hm.size()); // 2
        System.out.println("Contains 'China'? " + hm.containsKey("China")); // false

        // Add more elements to trigger rehash
        hm.put("Russia", 130);
        hm.put("Germany", 140);
        hm.put("France", 160);
        hm.put("Japan", 170);
        System.out.println("Size after more inserts (should trigger rehash): " + hm.size());
        System.out.println("Value for 'Japan': " + hm.get("Japan")); // 170

        // Clear map
        hm.clear();
        System.out.println("Size after clear: " + hm.size()); // 0
        System.out.println("Is empty after clear? " + hm.isEmpty()); // true
    }

}

class HashMap<K, V> {
    private int size;
    private LinkedList<Node>[] buckets;

    @SuppressWarnings("unchecked")
    public HashMap() {
        this.size = 0;
        this.buckets = new LinkedList[4];
        // filling buckets with linked list
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // used for getting node index in linked list
    private int searchInLL(K key, int bi) {
        LinkedList<Node> list = buckets[bi];
        int di = 0;
        for (Node node : list) {
            if (node.key.equals(key)) return di;
            di++;
        }
        return -1;
    }

    // used for rehashing
    @SuppressWarnings("unchecked")
    private void rehash() {
        LinkedList<Node>[] oldBuckets = buckets;
        int n = buckets.length;
        buckets = new LinkedList[n * 2];

        // filling buckets with linked list
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }

        // copy old buckets data into new bucket
        for (LinkedList<Node> list : oldBuckets) {
            for (Node node : list)
                put(node.key, node.val);
        }

    }

    // used for getting hash code
    private int hashOF(K key) {
        int hc = key.hashCode();
        return Math.abs(hc) % buckets.length;
    }

    // used for putting keys and values
    public void put(K key, V val) {
        int bi = hashOF(key);
        int di = searchInLL(key, bi);
        // already exist
        if (di != -1) {
            Node node = buckets[bi].get(di);
            // updating value
            node.val = val;
        } else {  // not exist
            buckets[bi].add(new Node(key, val));
            size++;
        }

        // n : size
        // N : buckets.length
        double lambda = (double) size / buckets.length;
        // checking for threshold
        if (lambda > 2.0) { // need for rehashing
            rehash();
        }
    }

    public V get(K key) {
        int bi = hashOF(key);
        int di = searchInLL(key, bi);
        if (di != -1) {
            Node node = buckets[bi].get(di);
            return node.val;
        } else {
            return null;
        }
    }

    public V remove(K key) {
        int bi = hashOF(key);
        int di = searchInLL(key, bi);
        if (di != -1) {
            Node node = buckets[bi].remove(di);
            size--;
            return node.val;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public boolean containsKey(K key) {
        int bi = hashOF(key);
        int di = searchInLL(key, bi);
        return di != -1;
    }

    @SuppressWarnings("unchecked")
    public void clear() {
        int n = buckets.length;
        buckets = new LinkedList[n];
        // filling buckets with linked list
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public ArrayList<K> keySet() {
        ArrayList<K> arrayList = new ArrayList<>();
        for (LinkedList<Node> list : buckets) {
            for (Node node : list) {
                arrayList.add(node.key);
            }
        }
        return arrayList;
    }

    private class Node {
        K key;
        V val;

        Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}
