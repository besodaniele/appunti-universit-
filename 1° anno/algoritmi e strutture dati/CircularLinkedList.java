public class CircularLinkedList {
    private class Node{
        int data;
        Node next;
    }
    private Node last;
    public CircularLinkedList(){
        last=null;
    }
    public CircularLinkedList(int x){
        last=new Node();
        last.data=x;
        last.next=last;
    }

    public int getFirst(){
        return last.next.data;
    }
    public boolean deleteFirst(){
        if(last==null)
            return false;
        if(last.next!=last)
            last.next=last.next.next;
        else
            last=null;
        return true;
    }
    public void insertAsFirst(int x){
        if(last==null){
            last=new Node();
            last.data=x;
            last.next=last;
        }

        else{
            Node n=new Node();
            n.data=x;
            n.next=last.next;
            last.next=n;
        }
    }

    private boolean exists(Node p,int x){
        if(p==last){
            return p.data==x;
        }else{
            return p.data==x || exists(p.next, x)
        }
    }
    public boolean exists(int x){
        if(last==null){
            return false;
        }else{
            return exists(last.next,x);
        }
    }
    private int size(Node p){
        if(p==last){
            return 1;
        }else{
            return 1+size(p.next);
        }
    }
    public int size(){
        if(last==null){
            return 0;
        }else{
            return size(last.next);
        }
    }
    private void print(Node p){
        if(p==last)
            System.out.println("data: "+p.data+"<---last");
        else if(p==last.next)
            System.out.println("data: "+p.data+"<---first");
        else
            System.out.println("data: "+p.data);



        if(p!=last){
            print(p.next);
        }

    }
    public void print(){
        if(last==null){
            System.out.println("empty list");

        }else{
            System.out.println("data in the list:");
            print(last.next);
        }
    }

    public void insertAsLast(int x){
        if(last==null){
            last=new Node();
            last.data=x;
        }else{
            Node first=last.next;
            Node newNode=new Node();
            newNode.data=x;
            last.next=newNode;
            newNode.next=first;
            last=newNode;
        }   
    }

    public boolean isEmpty(){
        return last==null;
    }




}
