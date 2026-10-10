class LRUCache {

    // Doubly linked list ka node
    class Node {
        int key, val;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; }
    }

    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head = new Node(0, 0); // dummy: most recent side
    private final Node tail = new Node(0, 0); // dummy: least recent side

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;

        remove(node);       // purani jagah se nikalo
        addToFront(node);   // front pe lagao (ab ye most recent hai)
        return node.val;
    }

    public void put(int key, int value) {
        // Case 1: key already hai -> update + front
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToFront(node);
            return;
        }

        // Case 2: key nayi hai, cache full -> LRU evict karo
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);   // isliye node mein key store karte hain!
        }

        // Naya node add karo
        Node node = new Node(key, value);
        map.put(key, node);
        addToFront(node);
    }

    // Node ko list se nikalna (O(1))
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Node ko head ke just baad lagana (O(1))
    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}