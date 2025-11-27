class Node{
    int data;
    Node next;
    Node(int data){
        this.data=data;
        this.next=null;
    }
}
public class LinkedList{
    public static void main(String arsg[])
    {

    Node node1=new Node(10);
    Node node2=new Node(20);
    Node node3=new Node(30);
    Node node4=new Node(40);
    node1.next=node2;
    node2.next=node3;
    node3.next=node4;
    Node head=node1;
    while(head!=null){
        System.out.println(head.data+"->");
        head=head.next;
    }
    System.out.print("null");
}
}

