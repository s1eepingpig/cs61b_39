import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();


    @Test
    public void test() {

        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('A', 'B'));
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', 'd'));
        assertFalse(offByOne.equalChars('a', 'A'));
        assertFalse(offByOne.equalChars('-', '='));
        assertFalse(offByOne.equalChars('A', 'A'));
        assertFalse(offByOne.equalChars('A', '?'));


    }
    // Your tests go here.



}
