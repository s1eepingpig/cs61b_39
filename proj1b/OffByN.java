public class OffByN implements CharacterComparator {

    int pos;
    OffByN(int pos) {
        this.pos = pos;
    }
    @Override
    public boolean equalChars(char x, char y) {
        int k = 0;
        if (pos != 0) {
            k = pos;
        }
        if (k - 1 < Math.abs(x - y) && Math.abs(x - y) <= k) {
            return true;
        }
        return false;
    }
}
