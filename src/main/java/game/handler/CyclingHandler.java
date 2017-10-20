package game.handler;

import game.clientgui.OlympicsGUI;
import game.clientgui.SportItemListener;
import game.item.gameimpl.Cyclist;
import game.item.gameimpl.Referee;

import javax.swing.*;
import java.awt.*;

public class CyclingHandler {

    private OlympicsGUI frame;
    private OlympicContent olympicContent;

    public CyclingHandler(OlympicsGUI frame) {

        this.frame = frame;
        this.olympicContent = new OlympicContent();
    }

    public void action() {

        JList<String> gameItem = new JList<>();

        gameItem.setBounds(270, 120, 120, 200);
        gameItem.setBackground(new Color(0.5f, 0.7f, 0.5f, 0.5f));

        CyclingSport cyclingSport = new CyclingSport();
        cyclingSport.setID("C02");

        boolean result = addReferee(cyclingSport);

        if(result){

            String[] data = new String[10];
            int CyNo = 8;
            loopData(cyclingSport,data,CyNo);
            olympicContent.setCyclingSport(cyclingSport);

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

                if (gameItem.getValueIsAdjusting()) {

                    gameItem.validate();
                }
            });
            gameItem.setVisible(true);



            frame.getOlympicContent().add(olympicContent);


            gameItem.addListSelectionListener(new SportItemListener(gameItem, frame));
            frame.add(gameItem, FlowLayout.LEFT);
            frame.validate();

            frame.repaint();
        }


    }

    private void loopData(CyclingSport cyclingSport, String[] data, int j) {

        for (int i = 0; i < j; i++) {
            if (i > j) {
                JOptionPane.showMessageDialog(null,
                        "cyclist Number is above 8 ",
                        "INFO COLLECTION",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                if (i < 4) {
                    setCompetitor(cyclingSport, data, i);

                } else if (i > 4) {

                    String result = JOptionPane.showInputDialog("the  cyclists already " + i + "YES/NO");
                    if (result == "YES") {
                        setCompetitor(cyclingSport, data, i);

                    }
                    {
                        break;
                    }

                }
            }

        }
    }

    private void setCompetitor(CyclingSport cyclingSport, String[] data, int i) {

        String id = "C_No." + String.valueOf(i);
        String name = JOptionPane.showInputDialog("Add the " + id + " cyclist's name");
        String state = JOptionPane.showInputDialog("Add the " + id + " cyclist's Country");
        String age = JOptionPane.showInputDialog("Add the " + id + " cyclist's age");

        if ("".equals(name) || name == null || "".equals(state) || state == null || Integer.valueOf(age) < 0) {

            JOptionPane.showMessageDialog(null,
                    "some field were not correct",
                    "INFO COLLECTION",
                    JOptionPane.ERROR_MESSAGE);

        } else {

            Cyclist cyclist = new Cyclist(id, name, state, Integer.valueOf(age));

            cyclist.getResult();

            cyclingSport.AddCyclist(cyclist);

            data[i] = cyclist.toString();
        }
    }

    private boolean addReferee(CyclingSport cyclingSport){

        String referee_id = JOptionPane.showInputDialog("Add referee's Id");
        String referee_name = JOptionPane.showInputDialog("Add referee's name");
        String referee_state = JOptionPane.showInputDialog("Add referee's Country");
        String referee_age = JOptionPane.showInputDialog("Add referee's age");

        if (" ".equals(referee_id) || referee_id == null || "".equals(referee_name) || referee_name == null || "".equals(referee_state) || referee_state == null || Integer.valueOf(referee_age) <= 0) {

            JOptionPane.showMessageDialog(null,
                    "some field is not collect",
                    "INFO COLLECTION",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        } else {

            Referee referee = new Referee(referee_id, referee_name, referee_state, Integer.valueOf(referee_age));
            cyclingSport.setReferee(referee);
            return true;
        }
    }
}
