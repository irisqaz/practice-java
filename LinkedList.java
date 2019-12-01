/**
 * LinkedList
 */
public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    LinkedList (){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public String toString() {
        String result = "[";

        for( Node temp = this.head; temp != null; temp = temp.next){
            result = result + temp.toString();
            if(temp.next != null){
                result = result + ", ";
            }
        }

        result = result + "]";
        return result;
    }

    public void addFront(int value){
        Node temp = new Node(value);
        temp.next = head;
        head = temp;
        if (tail == null){
            tail = temp;
        }
        this.length++;
    }

    public void addLast(int value){
        Node temp = new Node(value);

        if(tail == null){
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        
        this.length++;
    }

    public int length(){
        return this.length;
    }

    public static void main(String[] args) {
        // Node head = new Node(25);
        // head.next = new Node(3);

        // Node temp = new Node(7);
        // temp.next = head;
        // head = temp;
        // temp = null;
        

        
        // for( temp = head; temp != null; temp = temp.next){
        //     System.out.println(temp);
        //     //temp = temp.next;
        // }

        // temp = head;

        // while (temp != null) {
        //     System.out.println(temp);
        //     temp = temp.next;
        // }

        //System.out.println(head);
        //System.out.println(head.next);

        LinkedList list = new LinkedList();
        list.addLast(1);
        list.addLast(3);
        list.addLast(8);

        list.addFront(5);
        list.addFront(6);
        list.addFront(7);


        System.out.println(list);
        System.out.println(list.length());

    }
}

class Node {
    int value;
    Node next;
    Node(int value){
        this.value = value;
        this.next = null;
    }
    
    public String toString() {
        return Integer.toString(this.value);
    }
}