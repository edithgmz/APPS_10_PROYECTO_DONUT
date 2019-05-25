package edith.example.roltastico;

public class Dado {

    private int d;

    public Dado(int d) {
        this.d = d;
    }

    public int roll() {
        int n;
        n = (int) (Math.random() * d +1);
        return n;
    }


}
