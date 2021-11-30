import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Tile {
    private String name;
    private int row = -1, col = -1;
    private TileState state = TileState.normal;
    private BufferedImage currentImage, normalImage, floodedImage;
    private String tileTreasure = null;

    public Tile(String name) {
        this.name = name;
        try {
            normalImage = ImageIO.read(GamePanel.class.getResource("/Images/Tiles/" + name.replaceAll("\'", "") + ".png"));
            floodedImage = ImageIO.read(GamePanel.class.getResource("/Images/Tiles/" + name.replaceAll("\'", "") + "Flooded Final.png"));
            currentImage = normalImage;
        }
        catch (Exception e) {
            System.out.println("Exception in loading image for tile: " + name);
        }
    }

    public Tile(String name, String tileTreasure) {
        this.name = name;
        this.tileTreasure = tileTreasure;
        try {
            normalImage = ImageIO.read(GamePanel.class.getResource("/Images/Tiles/" + name.replaceAll("\'", "") + ".png"));
            floodedImage = ImageIO.read(GamePanel.class.getResource("/Images/Tiles/" + name.replaceAll("\'", "") + "Flooded Final.png"));
            currentImage = normalImage;
        }
        catch (Exception e) {
            System.out.println("Exception in loading image for tile: " + name);
        }
    }

    public void floodTile () {
        if (state == TileState.normal) {
            state = TileState.flooded;
            currentImage = floodedImage;
        } else {
            state = TileState.sunk;
            Map.instance.getMap()[row][col] = null;
        }
    }

    public void shoreUp() {
        if (state == TileState.flooded) {
            state = TileState.normal;
            currentImage = normalImage;
        }
    }

    public String getName() {
        return name;
    }

    public TileState getState() { return state; }

    public String getTileTreasure() { return tileTreasure; }

    public BufferedImage getCurrentImage() {
        return currentImage;
    }

    public String toString() {
        return name;
    }

    public boolean equals(Tile other) {
        return name.equals(other.getName());
    }
}
