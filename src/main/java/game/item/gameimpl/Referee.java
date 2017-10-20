package game.item.gameimpl;

public class Referee extends Participant{

    public Referee(String id, String name, String state, int age) {
        super(id, name, state, age);
    }

    @Override
    public String toString() {

        return getID()+"-"+getName()+"-"+getState()+"-"+getAge();
    }
}
