public class LinkedList1 {
    static class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data= data;
            this.next= null;
        }
    }
    public static void main(String args[])
    {
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);
        head.next= second;
        second.next= third;
        Node temp = head;
        while(temp!=null)
        {
            System.out.println(temp.data);
            temp= temp.next;
        }
    }
}
