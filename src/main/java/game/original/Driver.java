package original;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Driver {
    ArrayList<Games> games = new ArrayList<Games>();
    ArrayList<Participants> athletes = new ArrayList<Participants>();
    ArrayList<Officials> referees = new ArrayList<Officials>();
    Participants prediction = null;
    Games gameSelect = null;


    void menu() {
        System.out.println("------------Olympic Game------------");
        System.out.println("------------------------------------");
        if(gameSelect!=null)
        {
            System.out.println("-----Select Game information-----");
            System.out.println("Game ID: "+gameSelect.getID());
            System.out.println("Game type: "+gameSelect.getType());
            if(gameSelect.getPrediction()!=null){
                System.out.println("Prediction winner: ID "+gameSelect.getPrediction().getID()+" Name: "+gameSelect.getPrediction().getName());
            }
            if(gameSelect.getReferee()!=null)
            {
                System.out.println("Referee : ID "+gameSelect.getReferee().getID()+" Name: "+gameSelect.getReferee().getName());

            }
            System.out.println("Game run time: "+gameSelect.getRunTimes());
            System.out.println("---------------------------------");

        }
        System.out.println("1. Select a game to run");
        System.out.println("2. Predict the winner of the game");
        System.out.println("3. Start the game");
        System.out.println("4. Display the final results of all games");
        System.out.println("5. Display the final points of all athletes");
        System.out.println("6. Advanced functions");
        System.out.println("7. Exit");
        System.out.println();

    }

    void init() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String[] states = {"Australia", "Brazil", "Canada", "China", "USA", "UK", "New Zealand", "Japan", "Korea", "Russia", "German", "France", "Mars", "Moon"};
        String[] gameid = {"R", "S", "C"};
        String[] athleteid = {"RA", "SA", "CA", "SP", "RF"};
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                String id = gameid[i] + j;
                if (i == 0) {
                    games.add(new Running(id, "original.Running", null));
                }
                if (i == 1) {
                    games.add(new Swimming(id, "original.Swimming", null));
                }
                if (i == 2) {
                    games.add(new Cycling(id, "original.Cycling", null));
                }
            }
        }
        initP();
    }

    void initP() {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        String[] states = {"Australia", "Brazil", "Canada", "China", "USA", "UK", "New Zealand", "Japan", "Korea", "Russia", "German", "France", "Mars", "Moon"};
        String[] gameid = {"R", "S", "C"};
        String[] athleteid = {"RA", "SA", "CA", "SP", "RF"};
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                StringBuffer name2 = new StringBuffer();
                String id2 = new String();
                Random r2 = new Random();
                for (int p = 0; p <= 6; p++) {
                    int num2 = r2.nextInt(alphabet.length());
                    name2.append(alphabet.charAt(num2));
                }
                id2 = athleteid[i] + j;
                int k = random.nextInt(states.length - 1);
                int age = 18 + random.nextInt(12);
                if (i == 0) {
                    athletes.add(new Sprinters(id2, name2.toString(), states[k], age));
                }
                if (i == 1) {
                    athletes.add(new Swimmers(id2, name2.toString(), states[k], age));
                }
                if (i == 2) {
                    athletes.add(new Cyclists(id2, name2.toString(), states[k], age));
                }
                if (i == 3) {
                    athletes.add(new SuperAthletes(id2, name2.toString(), states[k], age));
                }
                if (i == 4) {
                    referees.add(new Officials(id2, name2.toString(), states[k], age));
                }
            }
        }
    }

    void control() {
        init();
        String cd = "begin";
        Scanner scan = new Scanner(System.in);
        while (!cd.equals("7")) {
            menu();
            System.out.print("Enter an option:");
            cd = scan.nextLine();

            if (cd.equals("1")) {
                selectGame();
            }
            if (cd.equals("2")) {
                predict();
            }
            if (cd.equals("3")) {
                runGame();
            }
            if (cd.equals("4")) {
                listResult();
            }
            if (cd.equals("5")) {
                displayPoints();
            }
        }
    }

    void selectGame() {
        Scanner scan = new Scanner(System.in);
        String slt = "";
        System.out.println("-------Game type Choose------");
        System.out.println("1 : original.Running");
        System.out.println("2 : original.Swimming");
        System.out.println("3 : original.Cycling");
        System.out.print("Please enter the number to choose the game type: ");
        slt = scan.nextLine();
        String type = new String();
        if (!slt.equals("1") && !slt.equals("2") && !slt.equals("3")) {
            System.out.println("Enter error!");
            return;
        }
        if (slt.equals("1")) {
            type = "original.Running";
        } else if (slt.equals("2")) {
            type = "original.Swimming";
        } else if (slt.equals("3")) {
            type = "original.Cycling";
        }
        System.out.println("-------Game List-------");
        for (int i = 0; i < games.size(); i++) {
            if (slt.equals("1") && games.get(i).getType().equals("original.Running")) {
                System.out.println("ID: " + games.get(i).getID() + " Game Type: " + games.get(i).getType());
            }
            if (slt.equals("2") && games.get(i).getType().equals("original.Swimming")) {
                System.out.println("ID: " + games.get(i).getID() + " Game Type: " + games.get(i).getType());
            }
            if (slt.equals("3") && games.get(i).getType().equals("original.Cycling")) {
                System.out.println("ID: " + games.get(i).getID() + " Game Type: " + games.get(i).getType());
            }
        }
        System.out.print("Please enter the ID to select a game: ");
        slt = scan.nextLine();
        if (gameCheck(slt, type) == true) {
            setRef();
            setAthletes();
        }
    }

    void setAthletes() {
        if (gameSelect.getMax_athletes() < 8) {
            System.out.println("---Do u want to add athletes into the game?---");
            Scanner scan = new Scanner(System.in);
            System.out.print("(Y/N): ");
            String slt = scan.nextLine();
            if (!slt.equals("Y") && !slt.equals("N")) {
                System.out.println("Select error! please select again!");
                setAthletes();
            } else {
                if (slt.equals("Y")) {
                    System.out.println("------Athletes List-----");
                    for (int i = 0; i < athletes.size(); i++) {
                        if (gameSelect.checkAthlete(athletes.get(i)) == true && checkIsexist(athletes.get(i)) == true) {
                            System.out.println("ID: " + athletes.get(i).getID() + " Name:" + athletes.get(i).getName()+" Age: "+athletes.get(i).getAge()+" State: "+athletes.get(i).getState());
                        }
                    }
                    System.out.print("Please enter the id to add the athlete: ");
                    slt = scan.nextLine();
                    if (checkIsWriteEnter(slt) == true) {
                        int k = 0;
                        for (int j = 0; j < athletes.size(); j++) {
                            if (athletes.get(j).getID().equals(slt)) {
                                k = j;
                            }
                        }
                        gameSelect.addAthlete(athletes.get(k));
                        System.out.println("Athlete add successfully!");
                        setAthletes();
                    } else {
                        System.out.println("Enter error!");
                        setAthletes();
                    }
                }
            }
        } else {
            System.out.println("The capacity of game is full!");
            return;
        }

    }

    boolean checkIsWriteEnter(String slt) {
        for (int i = 0; i < athletes.size(); i++) {
            if (athletes.get(i).getID().equals(slt) && gameSelect.checkAthlete(athletes.get(i)) == true && checkIsexist(athletes.get(i)) == true) {
                return true;
            }
        }
        return false;
    }

    boolean checkIsexist(Participants p) {
        if (gameSelect.getMax_athletes() == 0) {
            return true;
        } else {
            for (int i = 0; i < gameSelect.getMax_athletes(); i++) {
                if (p == gameSelect.getAthletes()[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    void setRef() {
        if (gameSelect.getReferee() == null) {
            System.out.println("-------referee list------");
            for (int i = 0; i < referees.size(); i++) {
                System.out.println("ID: " + referees.get(i).getID() + " Name: " + referees.get(i).getName()+" Age: "+referees.get(i).getAge()+" State: "+referees.get(i).getState());
            }
            System.out.print("Please enter the id choose a referee: ");
            Scanner scan = new Scanner(System.in);
            String slt = scan.nextLine();
            boolean check = false;
            int k = 0;
            for (int j = 0; j < referees.size(); j++) {
                if (referees.get(j).getID().equals(slt)) {
                    check = true;
                    k = j;
                }
            }
            if (check == true) {
                gameSelect.setReferee(referees.get(k));
                System.out.println("Referee " + referees.get(k).getName() + " set successfully!");

            } else {
                System.out.println("Select wrong id,please re-select!");
                setRef();
            }


        }
    }

    boolean gameCheck(String slt, String type) {
        boolean check = false;
        int num = 0;
        for (int j = 0; j < games.size(); j++) {
            if (slt.equals(games.get(j).getID()) && games.get(j).getType().equals(type)) {
                check = true;
                num = j;
            }
        }
        if (check == true) {
            gameSelect = games.get(num);
            System.out.println("Game select successfully!");
            return true;
        } else {
            System.out.println("Game id select error! return to the menu!");
            return false;
        }
    }

    void predict() {
        if (gameSelect == null) {
            System.out.println("You have not selected a game!");
        } else {
            Scanner scan = new Scanner(System.in);
            String slt = "";

            for (int i = 0; i < gameSelect.getMax_athletes(); i++) {
                System.out.println("ID: " + gameSelect.getAthletes()[i].getID() + " Name: " + gameSelect.getAthletes()[i].getName());
            }

            slt = scan.nextLine();
            boolean check = false;
            int num = 0;
            for (int j = 0; j < gameSelect.getMax_athletes(); j++) {
                if (slt.equals(gameSelect.getAthletes()[j].getID())) {
                    check = true;
                    num = j;
                }
            }
            if (check == true) {
                gameSelect.setPrediction(gameSelect.getAthletes()[num]);
                System.out.println("Predicted successfully!");
            } else {
                System.out.println("Athlete id select error! return to the menu!");
            }

        }
    }

    void runGame() {
        if (gameSelect == null) {
            System.out.println("You have not selected a game!!!");
        } else {
            if(gameSelect.getMax_athletes()<8)
            {
                setAthletes();
            }
            Scanner scan = new Scanner(System.in);
            if (gameSelect.getRunTimes() == 0) {
                gameSelect.runGame();

            } else {
                System.out.print("Do you want to reset your prediction?(Y/N): ");
                if (scan.nextLine().equals("Y")) {
                    predict();
                    gameSelect.runGame();
                } else {
                    gameSelect.runGame();
                }

            }
            System.out.println("---------------------------");
        }
    }


    void listResult() {
        System.out.println("------------Results List------------");
        for (int i = 0; i < games.size(); i++) {
            System.out.println();
            if (games.get(i).getRunTimes() >= 1) {
                System.out.println("------------Game Info------------");
                System.out.println("Game Type: " + games.get(i).getType());
                System.out.println("Game ID: " + games.get(i).getID());
                System.out.println("game referee: " + games.get(i).getReferee().getName());
                System.out.println("------------Athletes info------------");

                for (int j = 0; j < games.get(i).getMax_athletes(); j++) {
                    int rank = 1;
                    if (games.get(i).getRunTimes() == 0) {
                        rank = -j;
                    }
                    System.out.println("ID: " + games.get(i).getAthletes()[j].getID() + " Name: " + games.get(i).getAthletes()[j].getName() + " Rank: " + (j + rank) + "st " + "Result: " + games.get(i).getResult()[j]);
                }
            }

        }
        System.out.println();
    }

    void displayPoints() {
        System.out.println("------------Points List------------");
        for (int i = 0; i < athletes.size(); i++) {
            System.out.println("ID: " + athletes.get(i).getID() + " Name: " + athletes.get(i).getName() + " Total Points: " + athletes.get(i).getPoint());
        }


    }


}
