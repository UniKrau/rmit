package game.item.gameimpl;

import game.item.gameinterface.Cycling;
import game.item.gameinterface.Running;
import game.item.gameinterface.Swimming;

public class Sprinter extends Participant implements Swimming, Cycling, Running {


    double reoult_c;

    double result_r;

    double result_s;

    public Sprinter(String id, String name, String state, int age) {
        super(id, name, state, age);
    }


    @Override
    public double cycling() {
        int x = 500 + (int) (Math.random() * 300);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }

    @Override
    public double run() {

        int x = 10 + (int) (Math.random() * 10);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }

    @Override
    public double swim() {

        int x = 100 + (int) (Math.random() * 100);
        int y = (int) (Math.random() * 99);
        double z = x + ((double) y / 100);
        return z;
    }

    public double getResult_c(){

       return cycling();
    }

    public double getResult_r() {
        return run();
    }

    public double getResult_s(){

        return swim();
    }

    @Override
    public double prediction() {
        return 0;
    }

    @Override
    public String toString() {

        return getID()+" name "+getName()+" state "+
                getState()+" age "+getAge()+":"+getPoint()+" score "+run();
    }


}
