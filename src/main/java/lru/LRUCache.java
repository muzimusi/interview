package lru;

import java.util.HashMap;

//LRU原理和Redis实现——一个今日头条的面试题
//https://zhuanlan.zhihu.com/p/34133067
public class LRUCache<K, V> {
    // hash用来缓存数据
    private HashMap<K, DoubleListNode> hash;
    // 双向链表用于实现LRU原理：最新访问过的节点，置于队首
    private DoubleListNode head;
    private DoubleListNode tail;
    // 缓存上限
    private int capacity = 3;
    private int count = 0;

    public LRUCache() {
        this(3);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        init();
    }

    private void init() {
        hash = new HashMap<K, DoubleListNode>();
        head = new DoubleListNode();
        tail = new DoubleListNode();

        head.setPre(null);
        head.setPost(tail);

        tail.setPre(head);
        tail.setPost(null);
    }

    // get
    public V get(K key) {
        DoubleListNode node = hash.get(key);
        if (node != null) {
            // 将刚访问的节点置于队首
            moveNode2First(node);
            return (V) node.getValue();
        }
        return null;
    }

    // set
    public void set(K key, V value) {
        DoubleListNode node = hash.get(key);
        // 缓存中不存在key，需添加，
        if (node == null) {
            DoubleListNode<K, V> newNode = new DoubleListNode<K, V>(key, value);
            hash.put(key, newNode);
            addNodeAtFirst(newNode);
            // 超过容量，移除尾部元素
            if (++count > capacity) {
                DoubleListNode tailPre = tail.getPre();
                removeNode(tailPre);
                hash.remove(tailPre.getKey());
            }
        }
        // 缓存中存在，需更新
        else {
            node.setValue(value);
        }
    }

    // 队头添加新元素
    private void addNodeAtFirst(DoubleListNode firstNode) {
        DoubleListNode secondNode = head.getPost();
        head.setPost(firstNode);
        firstNode.setPre(head);
        firstNode.setPost(secondNode);
        secondNode.setPre(firstNode);
    }

    // 从队列中移除元素
    private void removeNode(DoubleListNode node) {
        DoubleListNode pre = node.getPre();
        DoubleListNode post = node.getPost();
        pre.setPost(node.getPost());
        post.setPre(node.getPre());
        count--;
    }

    // 移动元素到队首
    private void moveNode2First(DoubleListNode node) {
        removeNode(node);
        addNodeAtFirst(node);
    }


    public static void main(String[] args) {
        LRUCache<String, Integer> lruCache = new LRUCache<String, Integer>();
        lruCache.set("one", 1);
        lruCache.set("tow", 2);
        lruCache.set("three", 3);
        lruCache.set("four", 4);
        Integer three = lruCache.get("three");
        System.out.println(three);
    }
}

// 双向链表
class DoubleListNode<K, V> {
    private K key;
    private V value;
    private DoubleListNode pre;
    private DoubleListNode post;

    public DoubleListNode() {
    }

    public DoubleListNode(K key, V value) {
        this(key, value, null, null);
    }

    public DoubleListNode(K key, V value, DoubleListNode pre, DoubleListNode post) {
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.post = post;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public DoubleListNode getPre() {
        return pre;
    }

    public void setPre(DoubleListNode pre) {
        this.pre = pre;
    }

    public DoubleListNode getPost() {
        return post;
    }

    public void setPost(DoubleListNode post) {
        this.post = post;
    }
}

