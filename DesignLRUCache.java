/* HashMap and DLL head tail
put(1, 10) at node x do u have 1 no check max capacity put (3, 15) at node y
get put 0(1)
*/
class LRUCache {

    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap(); // key and value
    int capacity;

    public LRUCache(int _capacity) {
        capacity = _capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            //move data to the top
            remove(node);
            insert(node);// at top


            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        if(map.size() == capacity) {
            remove(tail.prev);
        }
        insert(new Node(key, value));
    }

    private void remove(Node node) {
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key, node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }
}
