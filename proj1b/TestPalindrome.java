import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static OffByOne OFFBYONE = new OffByOne();
    static OffByN offByN = new OffByN(5);

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.

    @Test
    public void testPalindrome() {
        String case1 = "";
        assertEquals(true, palindrome.isPalindrome(case1));

        String case2 = "aa";
        assertEquals(true, palindrome.isPalindrome(case2));

        String case3 = "ab";
        assertEquals(false, palindrome.isPalindrome(case3));

        String case4 = "aba";
        assertEquals(true, palindrome.isPalindrome(case4));

        String case5 = "abbaa";
        assertFalse(palindrome.isPalindrome(case5));

        String case6 = "abba";
        assertTrue(palindrome.isPalindrome(case6));

    }

    @Test
    public void isPalindrome() {


    }

    @Test
    public void testOffByN() {

        palindrome.isPalindrome("aba", offByN);
        palindrome.isPalindrome("abcd", offByN);
        assertTrue(palindrome.isPalindrome("chinch", offByN));

    }

}
