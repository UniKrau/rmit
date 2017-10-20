package game.clientgui;

import game.handler.OlympicContent;
import game.item.gameimpl.Cyclist;
import game.item.gameimpl.Sprinter;
import game.item.gameimpl.Swimmer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class DisplayListener implements ActionListener {

    OlympicsGUI window;

    public DisplayListener(OlympicsGUI window){

        this.window = window;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<OlympicContent> olympicContents = window.getOlympicContent();

        String [] data = new String[100] ;

        int flag = 0;

        ArrayList<String> points = new ArrayList<>();

        for (OlympicContent content : olympicContents) {
            for (int i = 0; i < content.getData().length; i++) {
                flag++ ;
                if(!" ".equals(content.getData()[i]) && content.getData()[i] !=null ){

                    data[flag] = content.getData()[i];
                }

            }

            if(content.getCyclingSport()!=null){

                for (Cyclist cyc:content.getCyclingSport().getCyclists()){

                    points.add(cyc.getName()+":"+cyc.getResult());
                }
            }


            if(content.getSwimmingSport() !=null ){

                for (Swimmer swimmer:content.getSwimmingSport().getSwimmers()){

                    points.add(swimmer.getName()+":"+ swimmer.getResult());
                }
            }


            if(content.getRunningSport() !=null){

                for(Sprinter sprinter:content.getRunningSport().getSprinters()){

                    points.add(sprinter.getName()+":"+sprinter.getResult_r());
                    points.add(sprinter.getName()+":"+sprinter.getResult_s());
                    points.add(sprinter.getName()+":"+sprinter.getResult_c());
                    points.add(sprinter.getName()+":"+sprinter.getResult_r());
                }
            }
        }

        JList<String> gameItem = new JList<String>();

        gameItem.invalidate();
        gameItem.setBounds(15,320,400,200);
        gameItem.setBackground(new Color(0.5f, 0.6f, 0.3f, 0.8f));


        gameItem.setListData(data);

        gameItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        window.add(gameItem,FlowLayout.LEFT);

        window.repaint();

    }
}

