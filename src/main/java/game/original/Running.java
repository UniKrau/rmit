package original;

public class Running extends Games {

    public Running(String id, String type, Officials referee) {
        super(id, type, referee);
    }


    @Override
    boolean checkAthlete(Participants p) {
        if (p.getClass() == SuperAthletes.class || p.getClass() == Sprinters.class) {
            return true;
        } else {
            return false;
        }
    }
}
