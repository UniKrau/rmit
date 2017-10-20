package original;

public abstract class Participants {

    private String ID = null;
    private String name = null;
    private String state = null;
    private int age;

    private int point = 0;

    public Participants(String id, String name, String state, int age) {
        this.ID = id;
        this.name = name;
        this.state = state;
        this.age = age;
    }

    int getPoint() {
        return this.point;
    }

    public String getID() {
        return this.ID;
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

    public int getAge() {
        return age;
    }

    void setPoint(int point) {
        this.point += point;
    }

    abstract double compete(Games g);

}
