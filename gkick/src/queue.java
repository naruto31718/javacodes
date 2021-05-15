class node {
    int val;
    node next;

    public node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class queue {
    int k;
    int size;
    node head;
    node tail;

    public queue(int k) {
        this.k = k;
        head = null;
        tail = null;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        node toadd = new node(value);
        if (head == null) {
            head = toadd;
            tail = head;
        } else {
            tail.next = toadd;
            tail = tail.next;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = head.next;
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return head.val;
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return tail.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }
}
