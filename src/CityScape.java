import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
public class CityScape extends JPanel {

    public static int width = 1020;
    private static int height = 640;
    private Building[] b = new Building[8];
    private Ufo[] ufos = new Ufo[5];

    private ArrayList<Integer[]> stars = new ArrayList<>();

    public CityScape() {
        int[] xWindows = {3, 2, 3, 5, 4, 4, 1, 3};
        int[] yWindows = {4, 6, 2, 5, 9, 6, 8, 3};
        double[] lights = {0.5, 0.3, 0.74, 0.6, 0.5, 0.3, 0.7, 0.5};
        int curr = 10;
        for (int i = 0; i < b.length; i++) {
            b[i] = new Building(curr, height-(yWindows[i]*30 + (yWindows[i]+1)*5 + 30), xWindows[i], yWindows[i], lights[i]);
            curr += 10 + xWindows[i]*30 + (xWindows[i]+1)*5;
        }

        for (int i = 0; i < 150; i++) {
            stars.add(new Integer[]{(int) Math.floor(Math.random() * width), (int) Math.floor(Math.random() * height)});
        }

        ufos[0] = new Ufo(0, 0);
        ufos[1] = new Ufo(300, 20);
        ufos[2] = new Ufo(5, 300);
        ufos[3] = new Ufo(250, 250);
        ufos[4] = new Ufo(70, 2);
    }

    public void move() {
        for (Ufo u : ufos) {
            u.move();
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 0, width, height);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //stars
        g2d.setColor(Color.WHITE);
        for (Integer[] arr : stars) {
            g2d.fillOval(arr[0], arr[1], 5, 5);
        }

        //moon
        g2d.setColor(Color.WHITE);
        g2d.fillOval(60, 60, 110, 110);
        g2d.setColor(Color.BLACK);
        g2d.fillOval(80, 50, 110, 110);


        //buildings
        g2d.setColor(Color.GRAY);
        for (Building k : b) {
            k.paint(g2d);
        }

        for (Ufo u : ufos) {
            u.paint(g2d);
        }

    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("My Drawing");

        CityScape cityScape = new CityScape();

        frame.add(cityScape);
        frame.setSize(width, height);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true)
        {
            cityScape.move();
            cityScape.repaint();
            Thread.sleep(10);
        }
    }
}