
public class LinkedListDeque<T> {

    //inner linkedList class (circle linked)
    private class LinkedList<T> {
        private Node senti;
        private int size;

        public void addFirst(T item) {
            Node first = new Node();
            first.data = item;
            if (size == 0) {
                first.prev = senti;
                first.next = senti;
                senti.next = first;
                senti.prev = first;
                size = 1;
                return;
            }
            first.prev = senti;
            first.next = senti.next;
            senti.next.prev = first;
            senti.next = first;
            size += 1;
            return;
        }

        public void addLast(T item) {
            Node last = new Node();
            last.data = item;
            if (size == 0) {
                last.next = senti;
                senti.next = last;
                senti.prev = last;
                last.prev = senti;
                size = 1;
                return;
            }
            last.next = senti;
            last.prev = senti.prev;
            senti.prev.next = last;
            senti.prev = last;
            size += 1;
            return;
        }

        public void removeFirst() {
            if (size == 0) {
                return;
            }
//            if (size==1){
//
//            }
            senti.next.next.prev = senti;
            senti.next = senti.next.next;
            size -= 1;
        }

        public T getFirst() {
            if (size == 0) {
                return null;
            }
            return senti.next.data;
        }

        public void removeLast() {
            if (size == 0) {
                return;
            }
            senti.prev.prev.next = senti;
            senti.prev = senti.prev.prev;
            size -= 1;
        }

        public T getLast() {
            if (size == 0) {
                return null;
            }
            return senti.prev.data;
        }

        public T getIndex(int index) {
            if (index > size - 1) {
                return null;
            }
            int tmp = 0;
            Node first = senti.next;
            while (tmp < index) {
                first = first.next;
                tmp++;
            }
            return first.data;
        }


        private class Node {
            private Node prev;
            private Node next;
            private T data;

            private Node() {

            }
        }

        LinkedList() {
            this.senti = new Node();
            senti.next = senti;
            senti.prev = senti;
            size = 0;
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
        return dequeue.size;
    }


    //  Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size(); i++) {
            T item = dequeue.getIndex(i);
            sb.append(item);
            if (i != size() - 1) {
                sb.append(" ");
            }
        }
        System.out.println(sb);
    }

    //  Removes and returns the item at the front of the deque.
    //  If no such item exists, returns null.
    public T removeFirst() {
        T first = dequeue.getFirst();
        dequeue.removeFirst();
        return first;
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
        return dequeue.getIndex(index);
    }

    //get But uses recursion
    public T getRecursive(int index) {
        T index1 = dequeue.getIndex(index);
        return index1;
    }

    // Constructor
    public LinkedListDeque() {

    }


}
