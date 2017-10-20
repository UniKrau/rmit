package game.handler;

import game.clientgui.OlympicsGUI;
import game.clientgui.SportItemListener;
import game.item.gameimpl.Referee;
import game.item.gameimpl.Swimmer;

import javax.swing.*;
import java.awt.*;

public class SwimmingHandler {

    private OlympicsGUI frame;

    private OlympicContent olympicContent;


    public SwimmingHandler(OlympicsGUI frame){

        this.frame = frame;
        this.olympicContent = new OlympicContent();
    }

    public void action() {

        JList<String> gameItem = new JList<>();

        gameItem.setBounds(270,120,120,200);
        gameItem.setBackground(new Color(0.5f, 0.7f, 0.5f, 0.5f));
        String [] data = new String[10] ;


        SwimmingSport swimmingSport = new SwimmingSport();
        swimmingSport.setID("S01");
        boolean result = addReferee(swimmingSport);

        if(result){
            int SwinNu = 1;
            loopData(swimmingSport,data,SwinNu);
            olympicContent.setSwimmingSport(swimmingSport);

            if(olympicContent.getSwimmingSport().getSwimmers().size() <4 )
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

            gameItem.addListSelectionListener(e -> {

                if(gameItem.getValueIsAdjusting()){

                    gameItem.validate();
                }
            });

            gameItem.setVisible(true);

            gameItem.addListSelectionListener(new SportItemListener(gameItem,frame));

            frame.getOlympicContent().add(olympicContent);

            frame.add(gameItem,FlowLayout.LEFT);
            frame.validate();

            frame.repaint();
        }


    }


    private void loopData(SwimmingSport swimmingSport, String[] data, int j) {

        for (int i = 0; i < j; i++) {
            if (i > j) {
                JOptionPane.showMessageDialog(null,
                        "swimmer Number is above 8 ",
                        "INFO COLLECTION",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                if (i < 4) {
                    setInformation(swimmingSport, data, i);

                } else if (i > 4) {

                    String result = JOptionPane.showInputDialog("Swimmers  No." + i + "YES/NO");
                    if (result == "YES") {
                        setInformation(swimmingSport, data, i);

                    }
                    {
                        break;
                    }

                }
            }

        }
    }

    private void setInformation(SwimmingSport swimmingSport, String[] data, int i) {

        String id = "S_No." + String.valueOf(i);
        String name = JOptionPane.showInputDialog("Add the " + id + " Swimmer's name");
        String state = JOptionPane.showInputDialog("Add the " + id + " Swimmer's Country");
        String age = JOptionPane.showInputDialog("Add the " + id + " Swimmer's age");

        if ("".equals(name) || name == null || "".equals(state) || state == null || Integer.valueOf(age) < 0) {

            JOptionPane.showMessageDialog(null,
                    "some field were not correct",
                    "INFO COLLECTION",
                    JOptionPane.ERROR_MESSAGE);

        } else {

            Swimmer swimmer = new Swimmer(id, name, state, Integer.valueOf(age));

            swimmingSport.addSwimmers(swimmer);

            data[i] = swimmer.toString();
        }
    }

    private boolean addReferee(SwimmingSport swimmingSport){

        String referee_id = JOptionPane.showInputDialog("Add swim referee's Id");
        String referee_name = JOptionPane.showInputDialog("Add swim referee's name");
        String referee_state = JOptionPane.showInputDialog("Add swim referee's Country");
        String referee_age = JOptionPane.showInputDialog("Add swim referee's age");

        if ("".equals(referee_id) || "".equals(referee_name)|| referee_id == null || referee_name == null || "".equals(referee_state) || referee_state == null || Integer.valueOf(referee_age) <= 0) {

            JOptionPane.showMessageDialog(null,
                    "some field is not collect",
                    "INFO COLLECTION",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {

            Referee referee = new Referee(referee_id, referee_name, referee_state, Integer.valueOf(referee_age));
            swimmingSport.setReferee(referee);

            return true;
        }
    }
}
