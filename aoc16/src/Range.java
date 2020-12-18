public class Range {
    private int loBound1;
    private int hiBound1;
    private int loBound2;
    private int hiBound2;

    public Range(int loBound1, int hiBound1, int loBound2, int hiBound2) {
        this.loBound1 = loBound1;
        this.hiBound1 = hiBound1;
        this.loBound2 = loBound2;
        this.hiBound2 = hiBound2;
    }

    public int getLoBound1() {
        return loBound1;
    }

    public int getHiBound1() {
        return hiBound1;
    }

    public int getLoBound2() {
        return loBound2;
    }

    public int getHiBound2() {
        return hiBound2;
    }
}
