package original;

public class Swimmers extends Participants {

    public Swimmers(String id, String name, String state, int age) {
        super(id, name, state, age);
    }

    @Override
    double compete(Games g) {
        int x = 100 + (int) (Math.random() * 100);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }
}
