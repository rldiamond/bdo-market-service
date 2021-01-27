package twich.bdo.market.data.cache;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Generic thread-safe cache object. Providing additional functionality.
 *
 * @param <K> The key of the cached item
 * @param <V> The value of the cached item.
 */
public class DataCache<K, V> {

    private final ConcurrentHashMap<K, V> myCache;

    public DataCache() {
        myCache = new ConcurrentHashMap<>();
    }

    /**
     * Clears all data in the cache.
     */
    public void clear() {
        myCache.clear();
    }

    /**
     * Loads the cache with the provided key and value datas.
     *
     * @param key   The key to load into the cache.
     * @param value The value to load into the cache.
     */
    public void load(K key, V value) {
        myCache.put(key, value);
    }

    /**
     * Determines if the provided key is in the cache.
     *
     * @param key The key to search for.
     * @return True if the key is found in the cache.
     */
    public boolean containsKey(K key) {
        return myCache.containsKey(key);
    }

    /**
     * Determines if the provided value is in the cache.
     *
     * @param value The value to search for.
     * @return True if the value is found in the cache.
     */
    public boolean containsValue(V value) {
        return myCache.containsValue(value);
    }

    /**
     * Gets a cached object by the key.
     *
     * @param key The key of an object to get.
     * @return Optional (nullable) containing the object for the provided key.
     */
    public Optional<V> get(K key) {
        return Optional.ofNullable(myCache.get(key));
    }


}

