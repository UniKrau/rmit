package game.handler;

import game.item.gameimpl.Cyclist;
import game.item.gameimpl.Referee;

import java.util.ArrayList;

public class CyclingSport {


    public  String ID = "C";
    private ArrayList<Cyclist> cyclists;
    private Referee referee;

    public CyclingSport() {

        cyclists = new ArrayList<>(8);
    }

    public ArrayList<Cyclist> getCyclists() {
        return cyclists;
    }

    public void AddCyclist(Cyclist cyclist) {

        if (cyclists.size() < 8) {
            cyclists.add(cyclist);
        }
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }

    public  String getID() {
        return ID;
    }

    public  void setID(String ID) {
        this.ID +=ID;
    }
}
