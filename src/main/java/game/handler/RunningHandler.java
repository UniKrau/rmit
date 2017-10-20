package game.handler;

import game.clientgui.OlympicsGUI;
import game.item.gameimpl.Referee;
import game.item.gameimpl.Sprinter;

import javax.swing.*;
import java.awt.*;

public class RunningHandler {

    private OlympicsGUI frame;

    private OlympicContent olympicContent;

    public RunningHandler(OlympicsGUI frame){

        this.frame = frame;
        this.olympicContent = new OlympicContent();
    }

    public void action() {

        JList<String> gameItem = new JList<>();

        gameItem.invalidate();
        gameItem.setBounds(250,120,150,200);
        gameItem.setBackground(new Color(0.5f, 0.7f, 0.5f, 0.5f));

        RunningSport runningSport = new RunningSport();

        runningSport.setID("R03");

        boolean result = addReferee(runningSport);
        if(result)
        {

            String [] data = new String[10] ;

            int runnerN = 8;

            loopData(runningSport,data,runnerN);
            olympicContent.setRunningSport(runningSport);

            if(olympicContent.getRunningSport().getSprinters().size() <0 )
            {
                JOptionPane.showMessageDialog(null,
                        "competitors' number smaller than 4 ",
                        "INFO COLLECTION",
                        JOptionPane.ERROR_MESSAGE);
            }{

            olympicContent.setData(data);
            gameItem.setListData(data);
            }


            gameItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            gameItem.setVisible(true);

            frame.getOlympicContent().add(olympicContent);

            frame.add(gameItem,FlowLayout.LEFT);

            frame.repaint();}

    }


    private void loopData(RunningSport runningSport, String[] data, int j) {

        for (int i = 0; i < j; i++) {
            if (i > j) {
                JOptionPane.showMessageDialog(null,
                        "sprinter Number is above 8 ",
                        "INFO COLLECTION",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                if (i < 4) {
                    setCompetitor(runningSport, data, i);

                } else if (i > 4) {

                    String result = JOptionPane.showInputDialog("the  sprinter already " + i + "YES/NO");
                    if (result == "YES") {

                        setCompetitor(runningSport, data, i);

                    }
                    {
                        break;
                    }

                }
            }

        }
    }

    private void setCompetitor(RunningSport runningSport, String[] data, int i) {

        String id = "R_No." + String.valueOf(i);
        String name = JOptionPane.showInputDialog("Add the " + id + " cyclist's name");
        String state = JOptionPane.showInputDialog("Add the " + id + " cyclist's Country");
        String age = JOptionPane.showInputDialog("Add the " + id + " cyclist's age");

        if ("".equals(name) || name == null || "".equals(state) || state == null || Integer.valueOf(age) < 0) {

            JOptionPane.showMessageDialog(null,
                    "some field were not correct",
                    "INFO COLLECTION",
                    JOptionPane.ERROR_MESSAGE);

        } else {

            Sprinter sprinter = new Sprinter(id, name, state, Integer.valueOf(age));

            sprinter.getResult_c();
            sprinter.getResult_r();
            sprinter.getResult_s();

            runningSport.addSprinter(sprinter);

            data[i] = sprinter.toString();
        }
    }


    private boolean addReferee(RunningSport runningSport){

        String referee_id = JOptionPane.showInputDialog("Add run referee's Id");
        String referee_name = JOptionPane.showInputDialog("Add run referee's name");
        String referee_state = JOptionPane.showInputDialog("Add run referee's Country");
        String referee_age = JOptionPane.showInputDialog("Add run referee's age");

        if ("".equals(referee_id) || referee_id == null || "".equals(referee_name) || referee_name == null || "".equals(referee_state) || referee_state == null || Integer.valueOf(referee_age) <= 0) {

            JOptionPane.showMessageDialog(null,
                    "some field is not collect",
                    "INFO COLLECTION",
                    JOptionPane.ERROR_MESSAGE);

            return false;
        } else {

            Referee referee = new Referee(referee_id, referee_name, referee_state, Integer.valueOf(referee_age));
            runningSport.setReferee(referee);

            return true;
        }
    }
}
