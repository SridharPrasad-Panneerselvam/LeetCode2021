//Doubly Linked List

class DoublyLinkedList {    
    //A node class for doubly linked list
    class Node{  
        int item;  
        Node previous;  
        Node next;  
   
        public Node(int item) {  
            this.item = item;  
        }  
    }  
    //Initially, heade and tail is set to null
    Node head, tail = null;  
   
    //add a node to the list  
    public void addNode(int item) {  
        //Create a new node  
        Node newNode = new Node(item);  
   
        //if list is empty, head and tail points to newNode  
        if(head == null) {  
            head = tail = newNode;  
            //head's previous will be null  
            head.previous = null;  
            //tail's next will be null  
            tail.next = null;  
        }  
        else {  
            //add newNode to the end of list. tail->next set to newNode  
            tail.next = newNode;  
            //newNode->previous set to tail  
            newNode.previous = tail;  
            //newNode becomes new tail  
            tail = newNode;  
            //tail's next point to null  
            tail.next = null;  
        }  
    }  
   
//print all the nodes of doubly linked list  
    public void printNodes() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
            System.out.println("Doubly linked list is empty");  
            return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Print each node and then go to next.  
            System.out.print(current.item + " ");  
            current = current.next;  
        }  
    }  
}
class Main{
    public static void main(String[] args) {  
        //create a DoublyLinkedList object
        DoublyLinkedList dl_List = new DoublyLinkedList();  
        //Add nodes to the list  
        dl_List.addNode(10);  
        dl_List.addNode(20);  
        dl_List.addNode(30);  
        dl_List.addNode(40);  
        dl_List.addNode(50);  
   
        //print the nodes of DoublyLinkedList  
        dl_List.printNodes();  
    }  
}  



_____________________________________________________________________________________________________________________
//Add Head,Tail,Size


public class Node {

    public int data;
    public Node next;
    public Node prev;

    private Node(){}

    public Node (int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class LinkList {

    public Node head;

    public LinkList(){
        head = null;
        //createCycle();
    }

    private void createCycle(){
        head = new Node(5);
        Node temp = head;
        temp.next = new Node(7);
        temp = temp.next;
        temp.next = new Node(3);
        temp = temp.next;
        Node three = temp;
        temp.next = new Node(4);
        temp = temp.next;
        temp.next = new Node(2);
        temp = temp.next;
        temp.next = new Node(-1);
        temp = temp.next;
        temp.next = new Node(6);
        temp = temp.next;
        temp.next = new Node(8);
        temp = temp.next;
        temp.next = three;




    }

    public void addHead(int data){
        Node add = new Node(data);

        add.next = head;
        head = add;
    }

    public void printList(){
        if(head == null)
            return;

        Node temp = head;
        while(temp != null){
            System.out.print(temp.data + " ->");
            temp = temp.next;

        }
        System.out.println("NULL");
    }


    public void addTail(int data){
        Node add = new Node(data);

        if(head == null)
        {
            head = add;
            return;
        }

        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = add;

    }

    public int count(){
        if(head == null)
            return  0;

        int count = 1;
        Node temp = head;

        while(temp.next != null){
            temp = temp.next;
            count++;
        }
        return  count;
    }


    public void reverse(){
        if(head == null || head.next == null){
            return;
        }

        Node back = null;
        Node mid = head;
        Node front = head.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid  = front;
            front = front.next;
        }
        mid.next = back;
        head = mid;
    }

    public Node reverse(Node node){
        if(node == null || node.next == null){
            return node;
        }

        Node back = null;
        Node mid = node;
        Node front = node.next;

        while(front != null){
            mid.next = back;
            back = mid;
            mid  = front;
            front = front.next;
        }
        mid.next = back;
        return mid;
    }


    public class Main {

        public static void main(String[] args) {
    
            LinkList<Integer> list = new LinkList<>();
    
            list.addTail(5);
            list.addTail(10);
            list.addTail(2);
            list.deleteNodesWhichHaveGreaterElementsOnRight();
            list.printList();
    
        }
    }