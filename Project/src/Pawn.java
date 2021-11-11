import java.awt.*;

public class Pawn {

    private Color color;
    private int row;
    private int col;

    public Pawn(String str) {
        row = 1;
        col = 1;
    }

    public int getRow() { return row; }

    public int getCol() { return col; }

    public void setRow(int r) { row = r; }

    public void setCol(int c) { col = c; }

}
