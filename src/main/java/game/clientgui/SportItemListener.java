package game.clientgui;

import game.handler.CyclingHandler;
import game.handler.RunningHandler;
import game.handler.SwimmingHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SportItemListener implements ListSelectionListener {

    private JList<String> gameItem ;
    private OlympicsGUI frame;
    public SportItemListener(JList<String> gameItem, OlympicsGUI frame){

        this.gameItem = gameItem;
        this.frame = frame;

    }
    @Override
    public void valueChanged(ListSelectionEvent e) {

        if(gameItem.getValueIsAdjusting()){
            String index = gameItem.getSelectedValue();

            if(index !=null){
                switch (index){
                    case "Running":
                        new RunningHandler(frame).action();
                        break;

                    case "Cycling":
                        new CyclingHandler(frame).action();
                        break;

                    case "Swimming":
                        new SwimmingHandler(frame).action();
                        break;

                    default:
                        break;
                }
            }

        }

    }
}
