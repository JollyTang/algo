package hot100;

import java.util.*;

public class Leetcode146 {

    int capacity;
    int size;
    HashMap<Integer, Node> map;
    Node head;
    Node tail;

    public Leetcode146(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();

        head.last = null;
        head.next = tail;
        tail.next = null;
        tail.last = head;
    }

    public int get(int key) {
        if (!this.map.containsKey(key)) {
            return -1;
        }
        moveToHead(key);
        return this.map.get(key).value;
    }

    public void put(int key, int value) {
        System.out.println("size = " + this.size + " capacity = " + this.capacity);
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(key);
            return;
        }
        if (this.size == this.capacity) {
            this.removeLast();
        }
        Node node = new Node();
        node.key = key;
        node.value = value;
        this.map.put(key, node);
        moveToHead(key);
        this.size++;
    }

    // head -> 1 -> 2
    public void moveToHead(int key) {
        Node node = this.map.get(key);
        if (node.next != null) {
            node.next.last = node.last;
            node.last.next = node.next;
        }

        head.next.last = node;
        node.next = head.next;
        head.next = node;
        node.last = head;
    }

    public void removeLast() {
        Node last = tail.last;
        last.last.next = tail;
        tail.last = last.last;
        this.map.remove(last.key);
        this.size--;
    }

}

class Node {
    int key;
    int value;
    Node next;
    Node last;
}
