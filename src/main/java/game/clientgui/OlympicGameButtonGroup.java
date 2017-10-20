package game.clientgui;

import javax.swing.*;
import java.awt.*;

class OlympicGameButtonGroup {

    private OlympicsGUI frame;

    public OlympicGameButtonGroup(OlympicsGUI frame) {

        this.frame = frame;
    }

    public JButton buttonGameSelect() {

        JButton gameSelect = new JButton("GameSelect");

        gameSelect.setBounds(50, 50, 100, 50);

        gameSelect.setBackground(new Color(0.5f, 0.7f, 0.5f, 0.5f));

        gameSelect.setOpaque(true);

        gameSelect.addActionListener(new GameSelectListener(frame));

        return gameSelect;

    }


    public JButton buttonDisplayResult() {

        JButton display_result = new JButton("Display Result");

        display_result.setBackground(new Color(0.1f, 0.4f, 0.7f, 0.5f));
        display_result.setBounds(160, 50, 100, 50);

        display_result.setOpaque(true);

        display_result.addActionListener(new DisplayListener(frame));

        return display_result;

    }


    public JButton buttonSaveResult() {

        JButton save = new JButton("Save");

        save.setBackground(new Color(0.9f, 0.2f, 0.3f, 0.5f));

        save.setBounds(270, 50, 100, 50);

        save.setOpaque(true);

        save.addActionListener(new SaveListener(frame));

        return save;

    }

    public JButton buttonPredict() {

        JButton predict = new JButton("Predict");

        predict.setBackground(new Color(0.8f, 0.6f, 0.3f, 0.5f));

        predict.setBounds(380, 50, 100, 50);

        predict.setOpaque(true);

        predict.addActionListener(new PredictListener(frame));

        return predict;

    }

    public JButton buttonPoint() {

        JButton predict = new JButton("Points");

        predict.setBackground(new Color(0.8f, 0.6f, 0.3f, 0.5f));

        predict.setBounds(430, 50, 100, 50);

        predict.setOpaque(true);

        predict.addActionListener(new PointsListener(frame));

        return predict;

    }

}
