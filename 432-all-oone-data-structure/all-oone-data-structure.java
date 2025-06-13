public class AllOne {
    class Node {
        int count;
        HashSet<String> st;
        Node lft;
        Node rgt;

        public Node(int count) {
            this.count = count;
            this.st = new HashSet<>();
            this.lft = null;
            this.rgt = null;
        }
    }

    void addAfter(Node prev, Node node) {
        node.rgt = prev.rgt;
        prev.rgt = node;
        node.lft = node.rgt.lft;
        node.rgt.lft = node;
    }

    void addBefore(Node next, Node node) {
        node.lft = next.lft;
        next.lft = node;
        node.lft.rgt = node;
        node.rgt = next;
    }

    void remove(Node node) {
        node.lft.rgt = node.rgt;
        node.rgt.lft = node.lft;
        node.lft = null;
        node.rgt = null;
    }

    Node head, tail;
    HashMap<String, Node> mp;

    public AllOne() {
        head = new Node(0);         
        tail = new Node(100000000); 
        head.rgt = tail;
        tail.lft = head;
        mp = new HashMap<>();
    }

    public void inc(String key) {
        Node prevNode = mp.getOrDefault(key, head);
        if (prevNode.rgt.count != prevNode.count + 1) {
            Node node = new Node(prevNode.count + 1);
            addAfter(prevNode, node);
        }

        if (prevNode != head) {
            prevNode.st.remove(key);
        }

        prevNode.rgt.st.add(key);
        mp.put(key, prevNode.rgt);

        if (prevNode != head && prevNode.st.size() == 0) {
            remove(prevNode);
        }
    }

    public void dec(String key) {
        Node nextNode = mp.getOrDefault(key, tail); 
        if (nextNode.lft.count != nextNode.count - 1) {
            Node node = new Node(nextNode.count - 1);
            addBefore(nextNode, node);
        }

        nextNode.st.remove(key);
        if (nextNode.lft == head) {
            mp.remove(key);
        } else {
            mp.put(key, nextNode.lft);
            nextNode.lft.st.add(key);
        }

        if (nextNode.st.size() == 0) {
            remove(nextNode);
        }
    }

    public String getMaxKey() {
        if (mp.size() == 0) return "";
        return tail.lft.st.iterator().next();
    }

    public String getMinKey() {
        if (mp.size() == 0) return "";
        return head.rgt.st.iterator().next();
    }
}