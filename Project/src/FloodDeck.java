import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.*;

public class FloodDeck {
    static GamePanel gamePanel;
    Deque<Tile> deck;
    BufferedImage discardPileImage;

    public FloodDeck () {
        ArrayList<Tile> tilesList = new ArrayList<>(Arrays.asList(Map.instance.getTiles()));
        Collections.shuffle(tilesList);

        deck = new LinkedList<>(tilesList);

        for (int i = 0; i < 6; i++) {
            Tile next = deck.pop();
            next.floodTile();

            if (i == 5) {
                try {
                    discardPileImage = ImageIO.read(
                            GamePanel.class.getResource("/Images/FloodCards/FloodCard" +
                                    (next.getName().replaceAll("\'", "").replaceAll(" ", ""))
                                    + ".png"
                            )
                    );
                } catch (Exception e) {
                    System.out.println("Error loading flood card");
                    System.out.println("/Images/FloodCards/FloodCard" +
                            (next.getName().replaceAll("\'", "").replaceAll(" ", ""))
                            + ".png");
                }
            }
        }
        gamePanel.repaint();
    }

    public void floodMap() {
        for (int i = 0; i < WaterLevel.waterLevel; i++) {
            Tile next = deck.pop();
            next.floodTile();
            if (deck.isEmpty()) {
                ArrayList<Tile> tilesList = new ArrayList<>(Arrays.asList(Map.instance.getTiles()));
                Collections.shuffle(tilesList);

                deck = new LinkedList<>(tilesList);
            }

            if (i == WaterLevel.waterLevel - 1) {
                try {
                    discardPileImage = ImageIO.read(
                            GamePanel.class.getResource("/Images/FloodCards/FloodCard" +
                                    (next.getName().replaceAll("\'", "").replaceAll(" ", ""))
                                    + ".png"
                            )
                    );
                } catch (Exception e) {
                    System.out.println("Error loading flood card");
                }
            }
        }
        gamePanel.repaint();
    }
}
