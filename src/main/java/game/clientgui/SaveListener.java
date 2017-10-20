package game.clientgui;

import game.handler.OlympicContent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class SaveListener implements ActionListener{


    private static final  String filePath = "./src/main/resources/records.log";

    OlympicsGUI window;

    public SaveListener(OlympicsGUI window){

        this.window = window;
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<OlympicContent> olympicContents = window.getOlympicContent();

        String [] data = new String[400] ;

        int flag = 0;
        for (OlympicContent content : olympicContents) {


            for (int i = 0; i < content.getData().length; i++) {
                flag++ ;
                data[flag] = content.getData()[i];
            }
        }

        File file = new File(filePath);

        JOptionPane.showInputDialog("default dir is "+filePath);

        if(!file.exists()){

            try {
                file.createNewFile();

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(file));

            for(String string : data){
                if(string != null){
                    writer.write(string.trim());
                }
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }finally {
            try {
                writer.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        JOptionPane.showConfirmDialog(window,"save as records log");

    }
}
