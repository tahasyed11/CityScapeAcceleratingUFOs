import java.awt.Color;

public class Util {
    public static Color getColor(int r, int g, int b) {
        float[] vals = Color.RGBtoHSB(r, g, b, null);
        return Color.getHSBColor(vals[0], vals[1], vals[2]);
    }
}
