package game.item.gameimpl;

import game.item.gameinterface.Cycling;

public class Cyclist extends Participant implements Cycling {


    private double result ;

    public Cyclist(String id, String name, String state, int age) {
        super(id, name, state, age);
    }

    public double getResult() {
        return cycling();
    }

    @Override
    public double cycling() {

        int x = 500 + (int) (Math.random() * 300);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }

    @Override
    public String toString() {

        return getID()+" name "+getName()+" State "+
                getState()+" Age "+getAge()+":"+getPoint()+" score "+cycling();
    }
}
