//  Make sure to make this class a part of the synthesizer package
// package <package name>;
package synthesizer;

import java.util.Iterator;

//Make sure to make this class and all of its methods public
// Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        //  Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        rb = (T[]) new Object[capacity];
        this.first = 0;
        this.last = 0;
        this.fillCount = 0;
        this.capacity = capacity;


    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        //  Enqueue the item. Don't forget to increase fillCount and update last.
        if (this.isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        } else {
            rb[last] = x;
            fillCount += 1;
            if (last == this.capacity - 1) {
                last = 0;
            } else {
                last += 1;
            }
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        //  Dequeue the first item. Don't forget to decrease fillCount and update
        if (isEmpty()) {
            throw new RuntimeException("Ring Buffer Underflow");
        } else {
            int t = first;
            fillCount -= 1;
            if (fillCount > 0) {
                if (first != capacity - 1) {
                    first = first + 1;
                } else {
                    first = 0;
                }
            }
            return rb[t];
        }
    }

    @Override
    public int capacity() {
        return this.capacity;
    }

    @Override
    public int fillCount() {
        return this.fillCount;
    }


//    @Override
//    public boolean isFull() {
//        if (fillCount == capacity) {
//            return true;
//        }
//        return false;
//    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        //  Return the first item. None of your instance variables should change.
        if (fillCount > 0) {
            return rb[first];
        }
        throw new RuntimeException("Ring buffer underflow");

    }


    @Override
    public Iterator<T> iterator() {
        return new NewIterator();
    }

    //  When you get to part 5, implement the needed code to support iteration.
    private class NewIterator implements Iterator {
        int p;

        public NewIterator() {
            p = 0;
        }

        @Override
        public boolean hasNext() {
            return (p > fillCount - 1);
        }

        @Override
        public T next() {
            p += 1;
            T ret = rb[p];
            return ret;
        }
    }
}

