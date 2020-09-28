package algorithm.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * date: 2020/9/27
 * description: LRUSimpleCache
 *
 * @author xiaopihai7256
 */
public class LRUSimpleCache<K, V> extends LinkedHashMap<K, V> {

    private static final long serialVersionUID = 23094571L;
    private final int maxCacheSize;

    LRUSimpleCache(int initialCapacity, int maxCacheSize) {
        super(initialCapacity, 0.75F, true);
        this.maxCacheSize = maxCacheSize;
    }

    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return this.size() > this.maxCacheSize;
    }

    public static void main(String[] args) {
        final var lruCache = new LRUSimpleCache<>(3, 3);
        lruCache.put("test1", 1);
        lruCache.put("test2", 2);
        System.out.println(lruCache.toString());
        lruCache.get("test1");
        System.out.println(lruCache.toString());
        lruCache.put("test3", 3);
        lruCache.put("test4", 1);
        lruCache.put("test5", 2);
        lruCache.put("test4", 2);
        System.out.println(lruCache.toString());
    }
}
