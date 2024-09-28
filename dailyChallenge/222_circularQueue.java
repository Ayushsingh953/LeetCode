// https://leetcode.com/problems/design-circular-deque/

public class ListNode{
    int val;
    ListNode next;
    ListNode prev;

    ListNode(){}

    ListNode(int val){
        this.val = val;
    }
    ListNode(int val,ListNode next,ListNode prev){
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}

class MyCircularDeque {

    ListNode front = null;
    ListNode rear = null;
    int size = 0;
    int capacity = 0;

    public MyCircularDeque(int k) {
        this.capacity = k;
    }
    
    public boolean insertFront(int value) {
        if(size==capacity) return false;
        ListNode newNode = new ListNode(value,null,null);
        if(front==null){
            front = newNode;
            rear = newNode;
        }else{
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(size==capacity) return false;
        ListNode newNode = new ListNode(value,null,null);
        if(rear==null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            newNode.prev = rear;
            rear = rear.next;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0) return false;
        if(front==rear){
            front = null;
            rear = null;
        }else{
            front = front.next;
            front.prev = null;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0) return false;
        if(rear==front){
            rear = null;
            front = null;
        }else{
            rear = rear.prev;
            rear.next = null;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        return front==null ? -1 : front.val;
    }
    
    public int getRear() {
        return rear==null ? -1 : rear.val;
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */