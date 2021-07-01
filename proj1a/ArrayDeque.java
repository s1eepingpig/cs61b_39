

public class ArrayDeque<T> {

    private class Array<T> {
        int factor = 8;
        int first = 4;
        int last = 5;
        int size;
        T[] aList;

        Array() {
            this.aList = (T[]) new Object[factor];
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        public void addFirst(T item) {
            if (first == 0) {
                aList[first] = item;
                size += 1;
                factor = factor * 2;
                T[] a = (T[]) new Object[factor];
                System.arraycopy(aList, 0, a, (factor / 2) + 0, factor / 2);
                first = (factor / 2) - 1;
                last = last + (factor / 2);
                return;
            }
            aList[first] = item;
            first -= 1;
            size += 1;
        }

        public void addLast(T item) {
            if (last == aList.length) {
                aList[last] = item;
                size += 1;
                factor = factor * 2;
                T[] a = (T[]) new Object[factor];
                for (int i = 0; i < aList.length; i++) {
                    a[i] = aList[i];
                }
                last = (factor / 2) + 1;
                first = last - size;
                return;
            }
            aList[last] = item;
            last += 1;
            size += 1;
        }

        public T get(int i) {
            if (size > 0) {
                return aList[first + i];
            }
            return null;
        }

        public void removeFirst() {
            if (size > 0) {
                first += 1;
                size -= 1;
            }
            if (size == 0) {
                return;
            }
        }

        public void removeLast() {
            if (size > 0) {
                last -= 1;
                size -= 1;
            }
            return;
        }
    }

    Array<T> aLists = new Array<>();

    public void addFirst(T item) {
        aLists.addFirst(item);
    }

    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        aLists.addLast(item);
    }

    //    Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        if (aLists.getSize() == 0) {
            return true;
        }
        return false;
    }

    //Returns the number of items in the deque.
    public int size() {
        return aLists.getSize();
    }


    //  Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < aLists.size; i++) {
            sb.append(aLists.get(i));
            if (i != aLists.size - 1) {
                sb.append(" ");
            }

        }
        System.out.println(sb);
    }

    //  Removes and returns the item at the front of the deque.
//  If no such item exists, returns null.
    public T removeFirst() {
        aLists.removeFirst();
        return aLists.get(0);
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        aLists.removeLast();
        return aLists.get(size() - 1);
    }

    //  Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth.
//  If no such item exists, returns null.
//  Must not alter the deque!
    public T get(int index) {
        return aLists.get(index);
    }

    //get But uses recursion
//    public T getRecursive(int index) {
//
//    }
}
