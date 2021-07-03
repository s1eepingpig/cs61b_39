import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    OffByOne obo = new OffByOne(2);

    @Test
    public void test() {

        assertTrue(obo.equalChars('a', 'c'));
        assertFalse(obo.equalChars('a', 'd'));
    }
    // Your tests go here.
    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class. *


}
