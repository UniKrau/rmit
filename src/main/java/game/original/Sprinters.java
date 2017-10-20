package original;

public class Sprinters extends Participants {

    public Sprinters(String id, String name, String state, int age) {
        super(id, name, state, age);
    }

    @Override
    double compete(Games g) {
        int x = 10 + (int) (Math.random() * 10);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }
}
