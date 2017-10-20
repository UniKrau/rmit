package game.clientgui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameSelectListener implements ActionListener {

    private OlympicsGUI frame;
    GameSelectListener(OlympicsGUI frame){

        this.frame = frame;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        JList<String> gameItem = new JList<>();

        gameItem.setBounds(50,120,100,200);
        gameItem.setBackground(new Color(0.5f, 0.7f, 0.5f, 0.5f));

        String [] data = {"Running","Cycling","Swimming",};

        gameItem.setListData(data);
        gameItem.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        gameItem.setName("Game");

        gameItem.setVisible(true);

        gameItem.addListSelectionListener(new SportItemListener(gameItem,frame));
        frame.add(gameItem,FlowLayout.LEFT);

        frame.repaint();

    }
}
