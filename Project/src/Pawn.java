import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Pawn {

    private Color color;
    private int row;
    private int col;

    private BufferedImage image;

    public Pawn(String str) {
        row = 1;
        col = 1;
    }

    public Pawn(int r, int c) {
        row = r; col = c;
        try {
            image = ImageIO.read(GamePanel.class.getResource("/Images/Pawns/DiverPawn.png"));
        } catch (Exception e) {
            System.out.println("Exception loading pawn image");
        }
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }

    public void setRow(int r) { row = r; }

    public void setCol(int c) { col = c; }

}
