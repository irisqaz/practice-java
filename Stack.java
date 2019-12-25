/**
 * LinkedList
 */
public class Stack {

    private Node head;
    private int length;

    Stack() {
        this.head = null;
        this.length = 0;
    }

    public String toString() {
        String result = "[";

        for (Node temp = this.head; temp != null; temp = temp.next) {
            result = result + temp.toString();
            if (temp.next != null) {
                result = result + ", ";
            }
        }

        result = result + "]";
        return result;
    }

    public void push(final int value) {

        final Node temp = new Node(value);

        if (this.length() == 0) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }

        this.length++;
    }

    public void pop() {
        if (this.length > 0) {
            head = head.next;
            this.length--;
        }

    }

    public int length() {
        return this.length;
    }

    public static void main(final String[] args) {
        final Stack stack = new Stack();
        stack.push(24);
        stack.push(66);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
    }
    class Node {
        int value;
        Node next;
    
        Node(final int value) {
            this.value = value;
            this.next = null;
        }
        
        public String toString() {
            return Integer.toString(this.value);
        }
    }
}

