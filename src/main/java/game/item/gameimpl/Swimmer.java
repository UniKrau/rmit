package game.item.gameimpl;

import game.item.gameinterface.Swimming;

public class Swimmer extends Participant implements Swimming {


    private  double result;

    public Swimmer(String id, String name, String state, int age) {
        super(id, name, state, age);
    }


    public double getResult() {

        return swim();
    }

    @Override
    public double swim() {

        int x = 100 + (int) (Math.random() * 100);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }


    @Override
    public double prediction() {
        return 0;
    }

    @Override
    public String toString() {

        return getID()+" name "+getName()+"-"+getState()+"-"+getAge()+":"+getPoint()+"_"+swim();
    }
}
