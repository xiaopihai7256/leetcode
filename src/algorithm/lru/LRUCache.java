package algorithm.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * date: 2020/9/27
 * description: 双向连标+map实现
 * @author xiaopihai7256
 */

public class LRUCache<K, T> {

    public static void main(String[] args) {

        LRUCache<String, Integer> cache2 = new LRUCache<>(3);
        cache2.put("test1", 1);
        System.out.println(cache2);
        cache2.put("test2", 2);
        System.out.println(cache2);
        cache2.put("test3", 3);
        System.out.println(cache2);
        cache2.get("test1");
        System.out.println(cache2);
        cache2.put("test2", 5);
        System.out.println(cache2);
        cache2.delete("test2");
        System.out.println(cache2);
        System.out.println(cache2.getHead());
        System.out.println(cache2.getLast());

    }

    /**
     * 首尾标志元素
     * lruNode.pre -> last
     * lruNode.next -> head
     */
    private final Node<T> lruNode;
    /**
     * hash访问缓存
     */
    private final Map<K, Node<T>> cache;
    /**
     * LRU size
     */
    private final int size;

    public LRUCache(int size) {
        lruNode = new Node<>(null);
        cache = new HashMap<>(size <= 16 ? size : 16, 0.75f);
        this.size = size;
    }

    /**
     * 普通获取
     * @param key key
     * @return T value
     */
    public T get(K key) {
        Node<T> node = cache.get(key);
        if (node == null) {
            return null;
        } else {
            if (node != lruNode.pre) {
                moveToLast(node);
            }
            return node.value;
        }
    }

    /**
     * 添加或者更新元素
     * @param key
     * @param value
     */
    public void put(K key, T value) {
        final Node<T> cacheNode = cache.get(key);
        // 无缓存历史，则new一个，按照存储是否满了决定添加方式
        if (cacheNode == null) {
            Node<T> node = new Node<>(value);
            if (cache.size() >= size) {
                Node<T> head = lruNode.next;
                removeFromChain(head);
                appendToChain(node);
            } else {
                appendToChain(node);
            }
            cache.put(key, node);
        } else { // 存在缓存，则直接更新缓存，并移动到队尾
            // modified value
            cacheNode.value = value;
            // move to last
            moveToLast(cacheNode);
        }
    }

    /**
     * 从LRU中删除元素
     * @param key 元素的key
     */
    public void delete(K key) {
        final Node<T> node = cache.remove(key);
        if (node != null) {
            removeFromChain(node);
        }
    }

    /**
     * 将指定节点移动到链表尾部）
     * @param node
     */
    private void moveToLast(Node<T> node) {
        removeFromChain(node);
        appendToChain(node);
    }

    /**
     * 将指定节点从链表中移除
     * @param node
     */
    private void removeFromChain(Node<T> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    /**
     * 将指定节点添加到链表中
     * @param node 节点
     */
    private void appendToChain(Node<T> node) {
        Node<T> last = lruNode.pre;
        if (last == null) {
            lruNode.next = node;
            node.pre = lruNode;
        } else {
            last.next = node;
            node.pre = last;
        }
        node.next = lruNode;
        lruNode.pre = node;
    }

    // 头部元素(非必须方法，用于校验）
    public T getHead() {
        return lruNode.next == null ? null : lruNode.next.value;
    }

    /**
     * 也是最后添加的或者访问过的元素（非必须方法，用于校验）
     * @return last ele
     */
    public T getLast() {
        return lruNode.pre == null ? null : lruNode.pre.value;
    }

    @Override
    public String toString() {
        Node<T> node = lruNode.next;
        if (node == null) return "null";
        StringBuilder builder = new StringBuilder();
        while (node != lruNode.pre) {
            builder.append(node.toString()).append(" => ");
            node = node.next;
        }
        builder.append(node.toString());
        return builder.toString();
    }

    /**
     * node节点
     * @param <T>
     */
    public static class Node<T> {

        private T value;
        Node<T> pre;
        Node<T> next;

        public Node(T value) {
            this.value = value;
            this.pre = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return value == null ? "null" : value.toString();
        }
    }
}
