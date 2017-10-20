package game.item.gameimpl;

public abstract class Participant implements Comparable<Participant>{

    private String ID = null;
    private String name = null;
    private String state = null;
    private int age;
    private int point = 0;

    public Participant(String id, String name, String state, int age) {
        this.ID = id;
        this.name = name;
        this.state = state;
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    @Override
    public int compareTo(Participant o) {

       return this.point-o.point;
    }
}
