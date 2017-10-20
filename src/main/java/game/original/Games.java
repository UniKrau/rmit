package original;

public class Games {

    private String ID = null;
    private String type = null;
    private Officials referee = null;
    private int max_athletes = 0;
    private double[] result = new double[8];
    private Participants[] athletes = new Participants[8];
    private int RunTimes = 0;
    private Participants prediction = null;

    public Games(String id, String type, Officials referee) {
        this.ID = id;
        this.type = type;
        this.referee = referee;
    }

    void sort() {
        for (int i = 0; i < max_athletes - 1; i++) {
            int k = i;
            for (int j = k + 1; j < max_athletes; j++) {
                if (result[j] < result[k]) {
                    k = j;
                }
            }
            if (i != k) {
                double temp = result[i];
                Participants patmp = athletes[i];
                result[i] = result[k];
                athletes[i] = athletes[k];
                result[k] = temp;
                athletes[k] = patmp;
            }
        }
    }

    void setReferee(Officials official) {
        this.referee = official;
    }

    public String getID() {
        return this.ID;
    }

    public String getType() {
        return this.type;
    }

    public void setPrediction(Participants prediction) {
        this.prediction = prediction;
    }

    Participants getPrediction() {
        return this.prediction;
    }

    double[] getResult() {
        return this.result;
    }

    boolean checkAthlete(Participants p) {
        if (p.getClass() == SuperAthletes.class) {
            return true;
        } else {
            return false;
        }
    }

   public Participants[] getAthletes() {
        return athletes;
    }

    public Officials getReferee() {
        return this.referee;
    }

    public int getMax_athletes() {
        return this.max_athletes;
    }

    void addAthlete(Participants p) {
        if (max_athletes == 8) {
            System.out.println("Game capacity is full, Cannot add athlete!");

        } else {

            if (max_athletes == 0) {
                athletes[max_athletes] = p;
                this.max_athletes++;
            } else {
                int tmp = 0;
                for (int i = 0; i < max_athletes; i++) {
                    if (athletes[i] == p) {
                        tmp++;
                    }
                }
                if (tmp == 0) {
                    athletes[max_athletes] = p;
                    this.max_athletes++;
                } else {
                    System.out.println("This athlete has been existed in this game!");
                }
            }
        }

    }

    void checkPrediction() {
        if (this.prediction != null) {
            if (this.prediction == this.athletes[0]) {
                System.out.println("Congratulation! Your prediction is correct!");
            } else {
                System.out.println("Oops! Your prediction is incorrect!");
            }
        } else {
            System.out.println("You have not made a prediction~");
            System.out.println("---------------------------");
        }
    }

    void runGame() {
        //test
        if (this.referee == null) {
            System.out.println("Please add a referee!");
        } else {
            if (this.getClass() == Cycling.class) {
                System.out.println("true");
            }
            if (max_athletes < 4) {
                System.out.println("The number of athlete is not enough, at least 4!");

            } else {
                for (int j = 0; j < max_athletes; j++) {

                    result[j] = athletes[j].compete(this);
                }

                this.sort();
                this.addRuntime();
                athletes[0].setPoint(5);
                athletes[1].setPoint(2);
                athletes[2].setPoint(1);
                System.out.println("Game finish!");
                checkPrediction();
                System.out.println("----------Game results----------");
                for (int k = 0; k < max_athletes; k++) {
                    System.out.println("The " + (k + 1) + "st" + " is " + athletes[k].getName() + " his result is " + result[k] + " " + ", his total score is: " + athletes[k].getPoint());
                }
            }
        }
    }

    void showSequence() {
        System.out.println("=========Game result=========");
        for (int i = 0; i < this.max_athletes; i++) {
            System.out.println((i + 1) + " Name: " + athletes[i].getName() + " Result: " + result[i] + " seconds");
        }
    }

    void addRuntime() {
        this.RunTimes++;
    }

    int getRunTimes() {
        return this.RunTimes;
    }


    Participants getFirst() {
        return athletes[0];
    }


}
