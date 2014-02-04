package spike.hashmap;

/**
 * Super basic map interface. It only supports the minimal number of methods required.
 *
 * @param <K> The key type.
 * @param <V> The value type.
 */
public interface Map<K, V> {

    /**
     * Get value based upon the key provided.
     *
     * Precondition: key != null
     *
     * @param key The key to search for in the map.
     * @return The value associated with the key.
     */
    V get(K key);

    /**
     * Inserts a value into the map based upon a lookup key.
     *
     * Precondition: key != null
     *
     * @param key   The key to search for in the map.
     * @param value The value associated with the key.
     */
    void put(K key, V value);

    /**
     * Removes the key/value pair from the map.
     *
     * Precondition: key != null
     *
     * @param key   The key to search for in the map.
     */
    void remove(K key);

}
