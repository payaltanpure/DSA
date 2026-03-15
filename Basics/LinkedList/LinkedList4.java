class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList4 {

    Node head;

   
    void insertAtEnd(int data) {

        Node newNode = new Node(data); 
        if(head==null)
        {
            head= newNode;
            return;
        }
        Node temp= head;
        while(temp.next!=null)
        {
            temp= temp.next;
        }
        temp.next= newNode;
 
    }
  
    void display() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

    }

    public static void main(String[] args) {

        LinkedList4 list = new LinkedList4();

        list.insertAtEnd(30);
        list.insertAtEnd(20);
        list.insertAtEnd(10);
        list.insertAtEnd(5);

        System.out.println("Linked List:");
        list.display();
    }
}