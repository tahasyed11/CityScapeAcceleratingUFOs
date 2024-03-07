import java.awt.*;

public class Ufo {

    private int x;
    private int y;
    private int dx = 1;
    private int dy = 1;

    public Ufo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (x + dx < 0) {
            dx = 1;
        } else if (x + dx + 30 > CityScape.width) {
            dx = -1;
        } else if (y + dy < 0) {
            dy = 1;
        } else if (y + dy + 30 > 200) {
            dy = -1;
        }
        x += dx;
        y += dy;
    }

    public void paint(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillOval(x, y, 30, 30);
    }
}
