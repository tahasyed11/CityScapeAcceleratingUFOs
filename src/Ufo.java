import java.awt.*;

public class Ufo {

    private int x;
    private int y;
    private int dx = 1;
    private double height = 0;
    private double position = 0;

    public Ufo(int x, int y) {
//        this.x = x;
        this.position = x;
        this.height = y;
    }

    public void move() {
        height += 0.0002;
        position += 0.0004;
//        if (x + dx < 0) {
//            dx = 1;
//        } else if (x + dx + 40 > CityScape.width) {
//            dx = -1;
//        }
//        x += dx;
        x = (int) ((Math.sin(position*180/Math.PI)*((CityScape.width-40)/2)) + (CityScape.width-40)/2);
        y = (int) ((Math.sin(height*180/Math.PI)*(170/2)) + 170/2 + 5);
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.GRAY);
        g2d.fillOval(x, y+5, 40, 15);
        g2d.setColor(Util.getColor(97, 178, 184));
        g2d.fillOval(x+8, y, 23, 12);

    }
}
