package original;

public class Swimming extends Games {

    public Swimming(String id, String type, Officials referee) {
        super(id, type, referee);
    }


    @Override
    boolean checkAthlete(Participants p) {
        if (p.getClass() == SuperAthletes.class || p.getClass() == Swimmers.class) {
            return true;
        } else {
            return false;
        }
    }
}
