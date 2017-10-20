package game.handler;

import game.item.gameimpl.Referee;
import game.item.gameimpl.Sprinter;

import java.util.ArrayList;

public class RunningSport {

    public  String ID = "R";
    private ArrayList<Sprinter> sprinters;
    private Referee referee;

    public RunningSport(){

        sprinters = new ArrayList<>(8);

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID +=ID;
    }

    public ArrayList<Sprinter> getSprinters() {
        return sprinters;
    }

    public void addSprinter(Sprinter sprinter) {
        this.sprinters.add(sprinter);
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
