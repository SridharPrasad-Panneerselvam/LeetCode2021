// https://leetcode.com/problems/insert-into-a-sorted-circular-linked-list/

public Node insert(Node head, int v) {
    Node cur = new Node(v);
    if(head==null){
        cur.next = cur;
        return cur;
    }
    
    Node rear = getMax(head);
    Node front = rear.next;
    
    if(rear.val==front.val || front.val>=v || rear.val<=v){
        //v is min or max
        rear.next = cur;
        cur.next = front;
    }else{
        //v is mid
        Node prev = front;
        Node next = prev.next;
        while(next!=front){
            if(prev.val<=v && next.val>v){
                prev.next = cur;
                cur.next = next;
                break;
            }  
            prev = next;
            next = prev.next;
        }            
    }
    return head;
}

private Node getMax(Node head){
    Node max = head;
    Node cur = head.next;
    while(cur!= head && cur.val>=max.val){
        max = cur;
        cur = cur.next;
    }
    return max;
}