package original;

public class Cycling extends Games {

    public Cycling(String id, String type, Officials referee) {
        super(id, type, referee);
    }


    @Override
    boolean checkAthlete(Participants p) {
        if (p.getClass() == SuperAthletes.class || p.getClass() == Cyclists.class) {
            return true;
        } else {
            return false;
        }
    }
}
