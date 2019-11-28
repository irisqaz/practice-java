/**
 * LinkedListExample
 */
public class LinkedListExample {

    public static void main(String[] args) {
        var n = new Node(25, null);
        n = new Node(3, null);
        System.out.println(n);
    }
}

/**
 * Node
 */
class Node {
    int value;
    Node next;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
    
}