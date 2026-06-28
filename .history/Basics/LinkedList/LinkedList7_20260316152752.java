class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList7 {

    Node head;

    // Insert at end
    void insertAtEnd(int data) {

        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Delete node by value
    void deleteByValue(int value) {

        // empty list
        if (head.data == value) {
            System.out.println("Element is found");
            return;
        }

        if (head.data == value) {
            head = head.next;
            return;
        }

        Node temp = head;

        // traversed till the node which is previous to the node to delete
        while (temp.next != null && temp.next.data != value) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
        } else {
            System.out.println("Value not found in list");
        }
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList5();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);

        System.out.println("Original List:");
        list.display();

        list.deleteByValue(20);

        System.out.println("After deleting 20:");
        list.display();
    }
}