package test.alibaba;

import java.util.Hashtable;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhoukx
 * @ClassName: CacheTest
 * @description:
 * 实现缓存
 * @date 2021/5/20
 */
public class CacheUtil {

    // 容量
    private static final int MAX_SIZE = 1024;

    // 默认过期时间为0~10s + 10s（1防止过期时间太短，2防止一起失效）
    private static final int DEFAULT_TIMEOUT = 10000;

    private static final Timer timer = new Timer();

    // 为保证性能，设置为最大容量的2倍
    private static ConcurrentHashMap<Long, Node> map = new ConcurrentHashMap<>(MAX_SIZE << 1);

    // 头(用空节点占位)
    private Node head = new Node();
    // 尾(用空节点占位)
    private Node tail = new Node();

    public CacheUtil() {
        head.setNext(tail);
        tail.setPrev(head);
    }

    // 普通put方法，设置默认的过期时间
    public synchronized void put(Long productId, Product product){
        // 随机生产过期时间
        put(productId, product, (long) (DEFAULT_TIMEOUT * Math.random()) + DEFAULT_TIMEOUT);
    }

    // 带过期时间的put方法
    public synchronized void put(Long productId, Product product, Long timeout){
        Node node = map.get(productId);

        // 更新
        if(Objects.nonNull(node)){
            node.setValue(product);
            map.put(productId, node);
            moveToHead(node);
        }
        // 新增
        else {
            // 如果此时缓存已达到最大预期值，用LRU淘汰
            if (map.size() >= MAX_SIZE) {
                // 删除尾节点以及对于的map
                tail = removeTail();
                map.remove(tail.getProductId());
            }

            // 创建新节点
            Node newNode = new Node(productId, product);
            map.put(productId, newNode);
            addToHead(newNode);
        }

        // 定时删除过期的键
        timer.schedule(new ClearTask(productId), timeout);

    }

    public synchronized Product get(Long productId){
        Node node = map.get(productId);
        // 如果没有从数据源中获取（模拟）
        if(Objects.isNull(node)){
            Product product = new Product(productId, "产品名称" + productId);
            node = new Node(productId, product);
            map.put(productId, node);
        }
        addToHead(node);
        return node.getValue();
    }

    private void addToHead(Node node) {
        node.setPrev(head);
        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        head.setNext(node);
    }

    private void removeNode(Node node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private Node removeTail() {
        Node res = tail.getPrev();
        removeNode(res);
        return res;
    }

    class ClearTask extends TimerTask {
        private final Long productId;
        public ClearTask(Long productId) {
            this.productId = productId;
        }
        @Override
        public void run() {
            removeTail();
            map.remove(productId);
        }
    }
}

// 商品
class Product {

    private Long productId;
    private String productName;

    public Product(Long productId, String productName) {
        this.productId = productId;
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}

// LRU节点
class Node {

    private Long productId;
    private Product value;
    private Node prev;
    private Node next;

    public Node() {}

    public Node(Long productId, Product value) {
        this.productId = productId;
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Product getValue() {
        return value;
    }

    public void setValue(Product value) {
        this.value = value;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
