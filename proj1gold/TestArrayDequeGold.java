import static org.junit.Assert.*;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdRandom;
import org.junit.Assert;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void StudentArrayDequeRandomlyTest() {
        ArrayDequeSolution<Integer> SOL = new ArrayDequeSolution<>();
        StudentArrayDeque<Integer> SAD = new StudentArrayDeque<>();
        StringBuffer err = new StringBuffer();

//        int randn = StdRandom.uniform(7);
        int size = 0;
        //  addFirst    0
        //  addLast     1
        //  removeFirst 2
        //  removeLast  3
        //  isEmpty     4
        //  size        5
        //  get         6
        Assert.assertEquals(SAD.isEmpty(), SOL.isEmpty());
        for (int i = 0; i < 10000; i++) {
            Integer rand = StdRandom.uniform(7);
            Integer val = StdRandom.uniform(100);
            if (rand == 0) {
                size++;
                SOL.addFirst(val);
                SAD.addFirst(val);
                err.append("addFirst("+val+")\n");
            } else if (rand == 1) {
                size++;
                SOL.addLast(val);
                SAD.addLast(val);
                err.append("addLast("+val+")\n");
            } else if (rand == 2) {
                if (size > 0) {
                    Integer n = SOL.removeFirst();
                    Integer m = SAD.removeFirst();
                    size--;
                    Assert.assertEquals(err.append("removeFirst()\n").toString(), m, n);
                }
            } else if (rand == 3) {
                if (size > 0) {
                    Integer n = SOL.removeLast();
                    Integer m = SAD.removeLast();
                    size--;
                    Assert.assertEquals(err.append("removeLast()\n").toString(), n, m);


                }
            } else if (rand == 4) {
                Assert.assertEquals(err.append("isEmpty()\n").toString(), SAD.isEmpty(), SOL.isEmpty());
            } else if (rand == 5) {
                Assert.assertEquals(err.append("size()\n").toString(), SAD.size(), SOL.size());
            }
            if(size > 0){
                Integer idx = StdRandom.uniform(size);
                Assert.assertEquals(err.append("get("+SOL.get(idx)+")\n").toString(), SOL.get(idx), SAD.get(idx));
            }

        }

    }

}
