package game.clientgui;

import game.handler.OlympicContent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PointsListener implements ActionListener{

    private OlympicsGUI frame;
    public PointsListener( OlympicsGUI frame){

        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        String [] data ;

        JList<String> gameItem = new JList<String>();

        gameItem.invalidate();
        gameItem.setBounds(430,100,100,200);
        gameItem.setBackground(new Color(0.3f, 0.2f, 0.7f, 0.8f));

        data =  displayPoints();

        gameItem.setListData(data);

        gameItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        frame.add(gameItem,FlowLayout.LEFT);

        frame.repaint();

    }

    String[] displayPoints(){

        String [] data = new String[100] ;

        ArrayList<OlympicContent> olympicContents = frame.getOlympicContent();
        int i = 0;
        for (OlympicContent content:olympicContents){

            ArrayList<String> points = content.getPoints();
            for (String string: points)
            {
                if(string !=null){
                    data[i++]= string;
                }
            }
        }
        return  data;
    }
}
