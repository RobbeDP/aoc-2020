public class Password {
    public int lower;
    public int higher;
    public char character;
    public String password;

    public Password(int loBound, int hiBound, char character, String password) {
        this.lower = loBound;
        this.higher = hiBound;
        this.character = character;
        this.password = password;
    }
}
