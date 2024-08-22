public class Stack {
    private LinkedList stack ;
    public Stack(){
        stack=new LinkedList();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
    public void push(int x){
        stack.insertAsFirst(x);
    }
    public int pop(){
        int data=stack.getAt(1);
        stack.deleteFirst();
        return data;
    }
}
