public class LinkedList {
    private class Node {
        int data;
        Node next;
    }

    private Node head;

    public LinkedList() {
        head = null;
    }

    public LinkedList(int x) {
        head = new Node();
        head.data = x;
        head.next = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void insertAsFirst(int x) {
        Node n = new Node();
        n.data = x;
        n.next = head;
        head = n;
    }

    public boolean deleteFirst() {
        if (head == null) {
            return false;
        } else {
            head = head.next;
            return true;
        }
    }

    private boolean exists(Node p, int x) {
        // general purpose, is needed for another function that make it start from head
        if (p == null) {
            return false;
        } else {
            return p.data == x || exists(p.next, x);
        }
    }

    public boolean exists(int x) {
        return exists(head, x);
    }

    private void multiplyBy(Node p, int x) {
        if (p != null) {
            p.data *= x;
            multiplyBy(p.next, x);
        }
    }

    public void multiplyBy(int x) {
        multiplyBy(head, x);
    }

    private void insertAsLast(Node p, int x) {
        if (p.next == null) {
            Node n = new Node();
            p.next = n;
        } else {
            insertAsLast(p.next, x);
        }

    }

    public void insertAsLast(int x) {
        if (head == null) {
            insertAsFirst(x);
        } else {
            insertAsLast(head, x);
        }
    }

    public void print() {
        if (!this.isEmpty()) {
            System.out.println("data in the list:");
            print(head);
        } else {
            System.out.println("no data");
        }
    }

    private void print(Node n) {
        if (n != null) {
            System.out.println("data: " + n.data);
            print(n.next);
        }
    }

    private int size(Node n) {
        if (n == null) {
            return 0;
        } else {
            return 1 + size(n.next);
        }
    }

    public int size() {
        return size(head);
    }

    private int getAt(Node n, int k) {

        if (k == 0 && n != null) {
            return n.data;
        } else if (n != null && n.next == null) {
            return n.data;
        } else {
            return getAt(n.next, k - 1);
        }

    }

    public int getAt(int k) {
        if (head == null) {
            return -1;
        }
        return getAt(head, k - 1);
    }

    private void printReverse(Node n) {
        if (n.next == null) {
            System.out.println(n.data);
        } else {
            printReverse(n.next);
            System.out.println(n.data);
        }
    }

    public void printReverse() {
        if (this.isEmpty()) {
            System.out.println("no data");
        } else {
            printReverse(head);
        }
    }

    private int getLast(Node p) {
        if (p.next == null) {
            return p.data;
        } else {
            return getLast(p.next);
        }
    }

    public int getLast() {
        if (this.isEmpty()) {
            System.out.println("no data");
            return -1;
        }
        return getLast(head);
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        Node p = head;
        Node app = p;
        while (p.next != null) {
            app = p;
            p = p.next;
        }
        p = null;
        app.next = null;
        return true;
    }

    private boolean deleteData(Node n, int x) {
        Node next = n.next;
        if (next == null) {
            return false;
        }
        if (next.data == x) {
            n.next = next.next;
            deleteData(n, x);
            return true;
        }
        deleteData(n, x);
        return true;

    }

    public boolean deleteData(int x) {
        if (head == null) {
            return false;
        }
        if (head.data == x) {
            head = head.next;
            deleteData(x);
            return true;
        }
        return deleteData(head, x);
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    public LinkedList copy() {
        LinkedList theCopy = new LinkedList();
        theCopy.head = copy(head);
        return theCopy;
    }

    public Node copy(Node p) {
        Node g;
        if (p == null) {
            return null;
        }
        g = new Node();
        g.data = p.data;
        g.next = copy(p.next);
        return g;
    }

    public int middle() {
        int size = size();
        Node app = head;

        int i = 0;
        while (i < (size - 1) / 2) {
            app = app.next;
            i++;
        }
        return app.data;
    }

    public void buildLoop(int n) {
        Node app=head;
        int i = 0;
        if (n > size()) {
            while (app.next != null) {
                app = app.next;
            }
            app.next = head;
        } else {
            while(i<n){
                app=app.next;
                i++;
            }
            app.next=head;
        }

    }

    public boolean hasLoop(){
        Node app=head;
        boolean isLoop=false;
        while(app.next!=null  && !isLoop){
            if(app.next==head){
                isLoop=true;
            }
            app=app.next;
        }
        return isLoop;
    }

    //mancano metodi slide 33
    

}