package original;

public class Cyclists extends Participants {

    public Cyclists(String id, String name, String state, int age) {
        super(id, name, state, age);
    }

    @Override
    double compete(Games g) {
        int x = 500 + (int) (Math.random() * 300);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }
}
