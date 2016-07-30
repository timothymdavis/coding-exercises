package spike.datastructures.hashmap;

/**
 * A VERY simple hashmap implementation. It handles collisions using the typical bucket solution. It isn't resizable,
 * so choose your initial size wisely.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public class HashMap<K, V> implements Map<K, V> {

    private static final int DEFAULT_SIZE = 1000;
    private Entry<K, V>[] entries;

    /**
     * This constructor uses {@link #DEFAULT_SIZE} for map size.
     */
    @SuppressWarnings("unchecked")
    public HashMap() {
        entries = new Entry[DEFAULT_SIZE];
    }

    /**
     * This constructor allows a user to specify the map size.
     *
     * Precondition: mapSize > 0
     *
     * @param mapSize The initial size of the map.
     */
    @SuppressWarnings("unchecked")
    public HashMap(int mapSize) {
        if (mapSize < 1) {
            throw new IllegalArgumentException("Parameter mapSize must be greater than 0!");
        }
        entries = new Entry[mapSize];
    }

    private void assertKeyNotNull(K key) {
        if (key == null) {
            throw new IllegalArgumentException("Parameter key must not be null!");
        }
    }

    @Override
    public V get(K key) {
        assertKeyNotNull(key);

        int indexForKey = getIndexForKey(key);
        Entry<K, V> bucket = entries[indexForKey];

        while (bucket != null && !bucket.key.equals(key)) {
            bucket = bucket.next;
        }

        return bucket == null ? null : bucket.value;
    }

    private int getIndexForKey(K key) {
        return key.hashCode() & (entries.length - 1);
    }

    @Override
    public void put(final K key, final V value) {
        assertKeyNotNull(key);

        Entry<K, V> entry = new Entry<>(key, value);
        int indexForKey = getIndexForKey(key);
        Entry<K, V> bucket = entries[indexForKey];

        if (bucket == null) {
            entries[indexForKey] = entry;
        }

        while (bucket != null) {
            if (bucket.key.equals(key)) {
                entry.next = bucket.next;
                bucket.next = entry;
                bucket = null;
            }
            else if (bucket.next == null) {
                bucket.next = entry;
                bucket = null;
            }
            else {
                bucket = bucket.next;
            }
        }
    }

    @Override
    public void remove(K key) {
        assertKeyNotNull(key);

        int indexForKey = getIndexForKey(key);
        Entry<K, V> bucket = entries[indexForKey];
        Entry<K, V> prevBucket = null;

        if (bucket != null && bucket.key.equals(key)) {
            entries[indexForKey] = bucket.next;
            bucket = null;
        }

        while (bucket != null) {
            if (bucket.key.equals(key) && prevBucket != null) {
                prevBucket.next = bucket.next;
                bucket = null;
            }
            else {
                prevBucket = bucket;
                bucket = bucket.next;
            }
        }
    }

    private class Entry<Key, Value> {

        private final Key key;
        private Entry<Key, Value> next;
        private final Value value;

        public Entry(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

    }

}
