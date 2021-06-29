public class ArrayDeque<T> {

    private class Array<T> {
        int size;
        int factor = 8;
        int first = factor / 2;
        int last = (factor / 2) + 1;

        T[] aList;

        Array() {
            aList = (T[]) new Object[factor];
            size = 0;
        }


        public int getSize() {
            return this.size;
        }

        public void addLast(T e) {

            if (last == aList.length - 1) {
                factor = factor * 2;
                T[] a = (T[]) new Object[factor];
                if (size - first >= 0) {
                    System.arraycopy(aList, first, a, first, size - first);
                }
                aList = a;
                aList[last] = e;
                last += 1;
                size += 1;
                return;
            }
            aList[last] = e;
            last += 1;
            size += 1;
            return;


        }

        public T getLast() {
            return aList[size - 1];
        }

        public void remove(int index) {
            if (size - index >= 0) {
                System.arraycopy(aList, index + 1, aList, index, size - index);
            }
        }


        public void addFirst(T e) {
            if (first == 0) {
                factor = factor * 2;
                T[] a = (T[]) new Object[factor];
                if (size - first >= 0) {
                    System.arraycopy(aList, first, a, first, size - first);
                }
                aList = a;
                aList[first] = e;
                first = factor / 2;
                first -= 1;
                size += 1;
            }
            aList[first] = e;
            first -= 1;
            size += 1;
        }

        public T get(int i) {
            return aList[first + i + 1];
        }

        public void removeFirst() {
            int i = last - first;
            if (i == 0) {
                return;
            }
            if (first == aList.length - 1) {
                return;
            }
            first = first + 1;
        }

        public T getFirst() {
            if (last - first != 0) {
                return aList[first + 1];
            }
            return null;
        }

        public void removeLast() {
            if (last - first == 0) {
                return;
            }
            if (last == aList.length - 1) {
                return;
            }
            last -= 1;
        }
    }


    //define a deque from here
//    --------------------------------------------------
    private Array<T> aList = new Array<T>();

    //Adds an item of type T to the front of the deque.
    public void addFirst(T item) {
        aList.addFirst(item);
    }

    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        aList.addLast(item);
    }

    //    Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if (aList.last - aList.first == 0) {
            return true;
        }
        return false;
    }

    //Returns the number of items in the deque.
    public int size() {
        return aList.getSize();
    }


    //  Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aList.size; i++) {
            sb.append(aList.get(i));
            sb.append(" ");
        }
        System.out.println(sb);
    }

    //  Removes and returns the item at the front of the deque.
//  If no such item exists, returns null.
    public T removeFirst() {
        aList.removeFirst();
        return aList.getFirst();
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        aList.removeLast();
        return aList.getLast();

    }

    //  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//  If no such item exists, returns null.
//  Must not alter the deque!
    public T get(int index) {
        return aList.get(index);
    }

    //get But uses recursion
//    public T getRecursive(int index) {
//        if (index == 0) {
//            return aList.getFirst();
//        }
//        return getRecursive(index - 1);
//    }

    // Constructor
    public ArrayDeque() {

    }


}
