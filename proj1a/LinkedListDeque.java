

public class LinkedListDeque<T> {

    //inner linkedList class (circle linked)
    private class LinkedList<T> {
        private Node senti;
        private int size;


        private class Node {
            private Node next;
            private T value;
            private Node prev;

            private Node(T value, Node next, Node prev) {
                this.next = next;
                this.value = value;
                this.prev = prev;
            }

            private Node() {

            }

        }

        //init list include args
        private LinkedList(T first0) {
            this.senti.next = this.senti;
            this.senti.prev = this.senti;
            Node node = new Node(first0, this.senti, this.senti);
            this.senti.next = node;
            this.senti.prev = node;
            size = 1;

        }

        //None args init
        LinkedList() {
            this.senti = new Node();
            this.senti.next = senti;
            this.senti.prev = senti;
            size = 0;
        }

        public T getFirst() {
            if (this.senti.next != this.senti) {
                return senti.next.value;
            }
            return null;
        }


        public void addFirst(T e) {
            if (size == 0) {
                Node node = new Node(e, this.senti, this.senti);
                this.senti.next = node;
                this.senti.prev = node;
                size += 1;
                return;
            }

            Node node = new Node(e, senti.next, senti);
            senti.next.prev = node;
            senti.next = node;
            size += 1;
        }

        public T getLast() {
            if (senti.next == senti) {
                return null;
            }
            return this.senti.prev.value;
        }

        public void addLast(T e) {
            if (size == 0) {
                senti.next = new Node(e, senti, senti);
                senti.prev = senti.next;
                size += 1;
                return;
            }
            Node prev = senti.prev;
            Node node = new Node(e, senti, prev);
            senti.prev.next = node;
            senti.prev = node;
            size += 1;
        }

        public void removeFirst() {
            if (senti.next == senti) {
                size = 0;
                return;
            }
            senti.next.next.prev = senti;
            senti.next = senti.next.next;
            if (size > 0) {
                size -= 1;
            }
        }

        public void removeLast() {
            if (size == 0) {
                return;
            }
            if (size == 1) {
                senti.next = senti;
                senti.prev = senti;
                size = 0;
                return;
            }
            if (size > 1) {
                senti.prev.prev.next = senti.next;
                senti.next.prev = senti.prev.prev;
                size -= 1;
                return;
            }
        }

        public int size() {
            return size;
        }

        public T get(int index) {
            if (index > size) {
                return null;
            }
            int t = 0;
            Node node = senti.next;
            while (t < index) {
                node = node.next;
                t++;
            }
            return node.value;
        }


    }

    //define a deque from here
//    --------------------------------------------------
    private LinkedList<T> dequeue = new LinkedList<>();

    //Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        dequeue.addFirst(item);
    }

    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        dequeue.addLast(item);
    }

    //    Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if (dequeue.size == 0) {
            return true;
        }
        return false;
    }

    //Returns the number of items in the deque.
    public int size() {
        return dequeue.size();
    }


    //  Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dequeue.size; i++) {
            sb.append(dequeue.get(i));
            sb.append(" ");
        }
        System.out.println(sb);
    }

    //  Removes and returns the item at the front of the deque.
//  If no such item exists, returns null.
    public T removeFirst() {
        dequeue.removeFirst();
        return dequeue.getFirst();
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        dequeue.removeLast();
        return dequeue.getLast();

    }

    //  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//  If no such item exists, returns null.
//  Must not alter the deque!
    public T get(int index) {
        return dequeue.get(index);
    }

    //get But uses recursion
    public T getRecursive(int index) {
        if (index == 0) {
            return dequeue.getFirst();
        }
        return getRecursive(index - 1);
    }

    // Constructor
    public LinkedListDeque() {

    }


}
