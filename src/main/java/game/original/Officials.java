package original;

public class Officials extends Participants {
    public Officials(String id, String name, String state, int age) {
        super(id, name, state, age);
    }

    @Override
    double compete(Games g) {
        return 0;
    }
}
