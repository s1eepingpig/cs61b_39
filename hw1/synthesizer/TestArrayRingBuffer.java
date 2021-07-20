package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;

/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer arb = new ArrayRingBuffer(10);
    }

    @Test
    public void testPeek(){
        ArrayRingBuffer<Integer> ar = new ArrayRingBuffer<>(5);
        ar.enqueue(3);
        ar.enqueue(4);
        ar.enqueue(7);
        ar.enqueue(7);
        Integer peek = ar.peek();
        System.out.println(peek);
        int i = ar.fillCount();
        System.out.println(i);


    }

    /** Calls tests for ArrayRingBuffer. */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
