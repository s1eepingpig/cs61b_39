public class OffByOne implements CharacterComparator {
    private int pos;


    public OffByOne() {

    }

    @Override
    public boolean equalChars(char x, char y) {

        if (x - y == 1 || y - x == 1) {
            return true;
        }
        return false;
    }


    private boolean isPalindrome(String word) {
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
