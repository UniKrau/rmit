package game.clientgui;

import game.handler.OlympicContent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class OlympicsGUI extends JFrame {

    private static String GameName = "Olympic Game V 1.0 ";
    private static String imagePath = "./src/main/resources/olympic.jpg";

    private ArrayList<OlympicContent> olympicContents;

    private OlympicsGUI() {

        olympicContents = new ArrayList<>();

        try {
            setContentPane(
                    new JLabel(new ImageIcon(ImageIO.read(new File(imagePath)))));
        } catch (IOException e) {
        }

    }

    public static void main(String[] args) {

        OlympicsGUI olympicsGUI = new OlympicsGUI();

        olympicsGUI.add(new OlympicGameButtonGroup(olympicsGUI).buttonGameSelect());
        olympicsGUI.add(new OlympicGameButtonGroup(olympicsGUI).buttonDisplayResult());
        olympicsGUI.add(new OlympicGameButtonGroup(olympicsGUI).buttonPredict());
        olympicsGUI.add(new OlympicGameButtonGroup(olympicsGUI).buttonSaveResult());
       // olympicsGUI.add(new OlympicGameButtonGroup(olympicsGUI).buttonPoint());


        olympicsGUI.setTitle(GameName);
        Rectangle r = new Rectangle(570, 570);
        olympicsGUI.setBounds(r);
        olympicsGUI.pack();
        olympicsGUI.centreWindow(olympicsGUI);

        olympicsGUI.setResizable(false);
        olympicsGUI.setVisible(true);

        olympicsGUI.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                e.getWindow().dispose();
                System.exit(0);
            }
        });
    }

    public void centreWindow(OlympicsGUI frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public ArrayList<OlympicContent> getOlympicContent() {
        return olympicContents;
    }
}

