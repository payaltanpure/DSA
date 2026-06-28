class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList6 {

    Node head;

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

    void searchvalue(int value) {
        int position = 1;
        Node temp = head;
        while (temp != null) {
            if (temp.data == value) {
                System.out.println("Element is found at position:" + position);
                return;
            }
            position++;
            temp = temp.next;
        }
        System.out.println("Element no found");
    }

    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {

        LinkedList6 list = new LinkedList6();

        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(10);
        list.insertAtEnd(5);

        list.searchvalue(10);

        System.out.println("Linked List:");
        list.display();
    }
}