import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Building {
    private int x;
    private int y;
    private int xWindows;
    private int yWindows;
    private double lights;
    private int windowWidth = 30;
    private int windowGap = 5;
    ArrayList<Integer> xvalues = new ArrayList<>();

    ArrayList<Integer> yvalues = new ArrayList<>();
    HashMap<Integer[], Boolean> lightsOn = new HashMap<>();


    public Building(int x, int y, int xWindows, int yWindows, double lights){
        this.x = x;
        this.y = y;
        this.xWindows = xWindows;
        this.yWindows = yWindows;
        this.lights = lights;

        int curr = windowGap;
        for (int i = 0; i < xWindows; i++) {
            xvalues.add(curr);
            curr += windowGap + windowWidth;
        }

        curr = windowGap;
        for (int i = 0; i < yWindows; i++) {
            yvalues.add(curr);
            curr += windowGap + windowWidth;
        }

        for (Integer i : xvalues) {
            for (Integer j : yvalues) {
                lightsOn.put(new Integer[] {i, j}, Math.random() >= lights);
            }
        }
    }


    public void paint(Graphics2D g2d){
        g2d.setColor(Color.GRAY);
        g2d.fillRect(x,y,xWindows*windowWidth + (this.xWindows+1)*windowGap, yWindows*windowWidth + (this.yWindows+1)*windowGap + 30);

        g2d.setColor(Color.YELLOW);
        for (Integer[] i : lightsOn.keySet()) {
            if (lightsOn.get(i)) {
                g2d.setColor(Color.YELLOW);
            } else {
                g2d.setColor(Color.BLACK);
            }
            g2d.fillRect(x+i[0], y+i[1], windowWidth, windowWidth);
        }

        float[] hsb = Color.RGBtoHSB(150, 75, 0, null);
        g2d.setColor(Color.getHSBColor(hsb[0], hsb[1], hsb[2]));
        g2d.fillRect(x+(this.getWidth())/2-9, CityScape.height-20, 18, 20);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(x+(this.getWidth())/2-1, CityScape.height-20, 2, 20);
    }

    public int getHeight() {
        return yWindows*windowWidth + (this.yWindows+1)*windowGap + 30;
    }

    public int getWidth() {
        return xWindows*windowWidth + (this.xWindows+1)*windowGap;
    }
}