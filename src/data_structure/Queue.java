package data_structure;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * date: 2020/8/22
 * description: 队列模拟
 * @author xiaopihai7256
 */
public class Queue<T> implements Iterable<T> {

    public static void main(String[] args) {
        java.util.Queue queue1 = new PriorityQueue();
        Queue<Integer> queue = new Queue<>(10);
        for (int i = 0; i <= 10; i++) {
            queue.enQueue(i);
            queue1.add(i);
        }
        System.out.println(queue1);
        System.out.println(queue);
        for (Integer num : queue) {
            System.out.println(num);
        }
    }

    private final Object[] queue;
    private int head;
    private int tail;

    public Queue(int length) {
        this.queue = new Object[length];
        this.head = 0;
        this.tail = 0;
    }

    public boolean enQueue(T ele) {
        if (size() == queue.length - 1) {
            return false;
        }
        queue[tail] = ele;
        if (tail == queue.length - 1) {
            tail = 0;
        } else {
            tail = tail + 1;
        }
        return true;
    }

    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T ele = eleData(head);
        if (head == queue.length - 1) {
            head = 0;
        } else {
            head = head + 1;
        }
        return ele;
    }

    public int size() {
        if (head > tail) return queue.length - (head - tail);
        else return tail - head;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public String toString() {
        if (isEmpty()) return "[]";
        StringBuilder builder = new StringBuilder("[");
        int count = size();
        for (int index = head; count > 0; count--) {
            builder.append(queue[index].toString()).append(',');
            if (index == queue.length - 1) {
                index = 0;
            } else {
                index = index + 1;
            }
        }
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();
    }

    private class QueueIterator implements Iterator<T> {

        private int cursor = size();
        private int index = head;

        @Override
        public boolean hasNext() {
            return cursor > 0;
        }

        @Override
        public T next() {
            T result = eleData(index);
            cursor--;
            index = index == queue.length - 1 ? 0 : index + 1;
            return result;
        }
    }

    @SuppressWarnings("unchecked")
    private T eleData(int i) {
        return (T)queue[i];
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
