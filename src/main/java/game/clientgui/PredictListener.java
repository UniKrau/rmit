package game.clientgui;

import game.handler.CyclingSport;
import game.handler.OlympicContent;
import game.handler.RunningSport;
import game.handler.SwimmingSport;
import game.item.gameimpl.Cyclist;
import game.item.gameimpl.Sprinter;
import game.item.gameimpl.Swimmer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class PredictListener implements ActionListener {

    private OlympicsGUI frame;

    PredictListener(OlympicsGUI frame) {

        this.frame = frame;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        ArrayList<OlympicContent> olympicContents = frame.getOlympicContent();

        String C= JOptionPane.showInputDialog("Chose R|S|C please");

        if("C".equals(C)){
            String name = JOptionPane.showInputDialog("Must be competitor's name");

            if ("".equals(name) || name == null) {
                JOptionPane.showMessageDialog(null,
                        "competitor is empty",
                        "competitor is empty",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                predict_cyclist(name,olympicContents);

            }
        }else if("S".equals(C)){

            String name = JOptionPane.showInputDialog("Must be competitor's name");

            if ("".equals(name) || name == null) {
                JOptionPane.showMessageDialog(null,
                        "competitor is empty",
                        "competitor is empty",
                        JOptionPane.ERROR_MESSAGE);
            } else {

                predict_swimm(name,olympicContents);


            }
        }else if("R".equals(C)){

            String name = JOptionPane.showInputDialog("Must be competitor's name");
            if ("".equals(name) || name == null) {
                JOptionPane.showMessageDialog(null,
                        "competitor is empty",
                        "competitor is empty",
                        JOptionPane.ERROR_MESSAGE);
            } else
            {

                predict_runn(name,olympicContents);
            }

        }
    }

    private void predict_cyclist(String name, ArrayList<OlympicContent> olympicContents) {

        for (OlympicContent olympicContent:olympicContents){

            if(olympicContent.getCyclingSport() != null){

                CyclingSport cyclingSport = olympicContent.getCyclingSport();

                ArrayList<Cyclist> cyclists = cyclingSport.getCyclists();
                HashMap<String,Double> map = new HashMap<>();

                if(cyclists != null){

                    for (Cyclist cycl: cyclists) {

                        map.put(cycl.getName(),cycl.getResult());
                    }
                    Map<Double, String> sortByValues = sortByValues(map);
                    Set set = sortByValues.entrySet();
                    Iterator iterator = set.iterator();
                    int index = 5;
                    boolean fl = false;
                    while(iterator.hasNext()) {
                        Map.Entry v = (Map.Entry)iterator.next();
                        index --;
                        if (index > 0) {
                            if(name.equals(v.getKey())){
                                JOptionPane.showMessageDialog(null,"prediction,Succeed");
                                break;
                            }
                        }if(index < 0){

                            fl = true;
                        }

                    }
                    if(fl)
                    {
                        JOptionPane.showMessageDialog(null,"prediction failed");
                    }
                }
            }
        }
    }

    private void predict_runn(String name, ArrayList<OlympicContent> olympicContents) {

        for (OlympicContent olympicContent: olympicContents){

            if(olympicContent.getRunningSport()!=null);
            {

                RunningSport sports = olympicContent.getRunningSport();

                ArrayList<Sprinter> sprinters = sports.getSprinters();

                HashMap<String,Double> map = new HashMap<>();
                if (sprinters != null) {
                    for (Sprinter sprinter : sprinters) {
                        map.put(sprinter.getName(),sprinter.getResult_r());
                    }
                }

                Map<Double, String> sortByValues = sortByValues(map);
                Set set = sortByValues.entrySet();
                Iterator iterator = set.iterator();
                int index = 5;
                boolean fl = false;
                while(iterator.hasNext()) {
                    Map.Entry v = (Map.Entry)iterator.next();
                    index --;
                    if (index > 0) {
                        if(name.equals(v.getKey())){
                            JOptionPane.showMessageDialog(frame,"prediction,Succeed");
                            break;
                        }
                    }if(index < 0){

                        fl = true;
                    }

                }
                if(fl)
                {
                    JOptionPane.showMessageDialog(frame,"prediction failed");
                }
            }

        }


    }

    private void predict_swimm(String name, ArrayList<OlympicContent> olympicContents) {


        for (OlympicContent olympicContent: olympicContents){

            if(olympicContent.getSwimmingSport()!=null);
            {
                SwimmingSport swimmingSport = olympicContent.getSwimmingSport();

                ArrayList<Swimmer> swimmers = swimmingSport.getSwimmers();
                HashMap<String,Double> map = new HashMap<>();
                if(swimmers !=null){
                    for (Swimmer swimmer: swimmers) {

                        map.put(swimmer.getName(),swimmer.getResult());
                    }
                }
                Map<Double, String> sortByValues = sortByValues(map);
                Set set = sortByValues.entrySet();
                Iterator iterator = set.iterator();
                int index = 5;
                boolean fl = false;
                while(iterator.hasNext()) {
                    Map.Entry v = (Map.Entry)iterator.next();
                    index --;
                    if (index > 0) {
                        if(name.equals(v.getKey())){
                            JOptionPane.showMessageDialog(null,"prediction,Succeed");
                            break;
                        }
                    }if(index < 0){

                        fl = true;
                    }

                }
                if(fl)
                {
                    JOptionPane.showMessageDialog(null,"prediction failed");
                }
            }

        }
    }


    private static HashMap sortByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());

        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
