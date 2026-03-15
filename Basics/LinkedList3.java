public class LinkedList3 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head; // Nodes object newnode

    void insertatbeg(int data) {
        Node newnode = new Node(data); // node class object
        newnode.next = head;
        head = newnode;
    }

    void display() {
        Node temp;
        temp = head;
        while (temp != null) {
            System.err.println(temp.data);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList3 l1 = new LinkedList3();
        l1.insertatbeg(30);
        l1.insertatbeg(20);
        l1.insertatbeg(10);
        l1.display();
    }
}
