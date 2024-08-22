public class Queue {
    private CircularLinkedList queue;
    public Queue(){
        queue=new CircularLinkedList();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public void enque(int x){
        queue.insertAsLast(x);
    }
    public int deque(){
        int data=queue.getFirst();
        queue.deleteFirst();
        return data;
    }
}   
