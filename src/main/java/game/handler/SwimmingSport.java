package game.handler;

import game.item.gameimpl.Referee;
import game.item.gameimpl.Swimmer;

import java.util.ArrayList;

public class SwimmingSport {

    public  String ID = "S";
    private ArrayList<Swimmer> swimmers;
    private Referee referee;

    public SwimmingSport(){

        swimmers = new ArrayList<>(8);

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID +=ID;
    }

    public ArrayList<Swimmer> getSwimmers() {
        return swimmers;
    }

    public void addSwimmers(Swimmer swimmers) {
        this.swimmers.add(swimmers);
    }

    public Referee getReferee() {
        return referee;
    }

    public void setReferee(Referee referee) {
        this.referee = referee;
    }
}
