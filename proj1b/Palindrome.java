public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word.equals("")) {
            return null;
        }
        Deque<Character> deque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            deque.addLast(c);
        }

        return deque;
    }

    public boolean isPalindrome(String word) {
        if (word.length() == 0 || word.length() == 1) {
            return true;
        }
        Deque<Character> charDeque = wordToDeque(word);
        if (word.length() % 2 != 0) {
            for (int i = 0; i < (word.length() / 2); i++) {
                Character character = charDeque.removeFirst();
                if (!character.equals(charDeque.removeLast())) {
                    return false;
                }
            }
        } else {
            for (int i = 0; i < word.length() / 2; i++) {
                if (!charDeque.removeFirst().equals(charDeque.removeLast())) {
                    return false;
                }
            }
        }
        return true;

    }

    public boolean isPalindrome(String word, CharacterComparator cc){

        return false;
    }

}
