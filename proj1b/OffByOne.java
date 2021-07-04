public class OffByOne implements CharacterComparator {
    private int pos;


    public OffByOne() {

    }

    @Override
    public boolean equalChars(char x, char y) {
        int k = 1;
        if (pos != 0) {
            k = pos;
        }
        if (k - 1 < Math.abs(x - y) && Math.abs(x - y) <= k) {
            return true;
        }
        return false;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        if (word.length() % 2 != 0) {
            for (int i = 0; i < word.length() / 2; i++) {
                if (!equalChars(word.charAt(i),
                        word.charAt(word.length() - 1 - i))) {
                    return false;
                }
            }
            return true;
        } else {
            for (int i = 0; i < word.length() / 2; i++) {
                if (!equalChars(word.charAt(i),
                        word.charAt(word.length() - 1 - i))) {
                    return false;
                }
            }
            return true;
        }
    }
}
