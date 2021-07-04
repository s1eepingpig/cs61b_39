public class OffByN implements CharacterComparator {

    private int pos;

    public OffByN(int pos) {
        this.pos = pos;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int k;
        pos = Math.abs('x' - 'y');
        k = pos;


        if (k - 1 < Math.abs(x - y) && Math.abs(x - y) <= k) {
            return true;
        }
        return false;
    }
}
