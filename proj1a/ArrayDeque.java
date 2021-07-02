

public class ArrayDeque<T> {

    private class Array<T> {
        int factor = 8;
        int first = 0;
        int last = 1;
        int size;
        T[] aList;

        Array() {
            this.aList = (T[]) new Object[factor];
            this.size = 0;
        }

        public int getSize() {
            return size;
        }

        //用来映射索引和数组位置
        public T map(int idx) {
            if (idx > size) {
                return null;
            }
            int k;
            if (first + 1 + idx == aList.length) {
                k = 0;
            } else {
                k = (first + 1 + idx) % aList.length;
            }

            return aList[k];
        }

        public void addFirst(T item) {
            if (size < aList.length) {
                aList[first] = item;
                if (first == 0) {
                    first = aList.length - 1;
                } else {
                    first = (first - 1 % aList.length);
                }
                size += 1;
                return;
            }
            if (size == aList.length) {
                this.factor = factor * 2;
                T[] a = (T[]) new Object[factor];
                for (int i = 0; i < size; i++) {
                    if (first + 1 + i == aList.length - 1) {
                        a[i] = aList[aList.length - 1];
                    } else {
                        a[i] = aList[(first + 1 + i) % aList.length];
                    }
                }
                aList = a;
                first = aList.length - 1;
                last = size;
                aList[first] = item;
                first = Math.abs((first - 1) % aList.length);
                size += 1;
                return;
            }
        }

        public void addLast(T item) {
            if (size < aList.length) {
                aList[last] = item;
                size += 1;
                last = (last + 1) % aList.length;
                return;
            }
            factor = factor * 2;
            T[] a = (T[]) new Object[factor];
            for (int i = 0; i < size; i++) {
                if (first + 1 + i == aList.length - 1) {
                    a[i] = aList[aList.length - 1];
                } else {
                    a[i] = aList[(first + 1 + i) % aList.length];
                }
            }
            aList = a;
            first = aList.length - 1;
            last = size;
            aList[last] = item;
            size += 1;
            last += 1;
            return;
        }

        public T get(int i) {
            if (size > 0) {
                T map = (T) aLists.map(i);
                return map;
            }
            return null;
        }

        public void removeFirst() {
            if (size > 0) {
                if (first == aList.length) {
                    first = 0;
                    return;
                }
                first += 1;
                size -= 1;
            }
            if (size == 0) {
                return;
            }
        }

        public void removeLast() {
            if (size == 0) {
                return;
            }
            if (size > 0) {
                if (last == 0) {
                    last = aList.length - 1;
                }
                last -= 1;
                size -= 1;
            }
            return;
        }
    }

    private Array<T> aLists = new Array<>();

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
        for (int i = 0; i < this.aLists.size - 1; i++) {
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
        T t = aLists.get(0);
        aLists.removeFirst();
        return t;
    }

    // Removes and returns the item at the back of the deque.
    // If no such item exists, returns null.
    public T removeLast() {
        T t = aLists.get(size() - 1);
        aLists.removeLast();
        return t;
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
