package game.handler;

import java.util.ArrayList;

public class OlympicContent {

    private String[] data;

    private  CyclingSport cyclingSport;
    private  SwimmingSport swimmingSport;
    private  RunningSport  runningSport;


    private ArrayList<String> points;
    public OlympicContent() {

       this.data = new String[10];

       points = new ArrayList<>();
    }

    public String[] getData() {

        return data;
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public CyclingSport getCyclingSport() {
        return cyclingSport;
    }

    public void setCyclingSport(CyclingSport cyclingSport) {
        this.cyclingSport = cyclingSport;
    }

    public void setSwimmingSport(SwimmingSport swimmingSport){

        this.swimmingSport = swimmingSport;
    }

    public void setRunningSport(RunningSport runningSport) {
        this.runningSport = runningSport;
    }

    public SwimmingSport getSwimmingSport() {
        return swimmingSport;
    }

    public RunningSport getRunningSport() {
        return runningSport;
    }


    public ArrayList<String> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<String> points) {
        this.points = points;
    }
}
