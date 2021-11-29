import java.util.*;

public class FloodDeck {
    static GamePanel gamePanel;
    Deque<Tile> deck;

    public FloodDeck () {
        ArrayList<Tile> tilesList = new ArrayList<>(Arrays.asList(Map.instance.getTiles()));
        Collections.shuffle(tilesList);

        deck = new LinkedList<>(tilesList);

        for (int i = 0; i < 6; i++) {
            deck.pop().floodTile();
        }
        gamePanel.repaint();
    }

    public void floodMap() {
        for (int i = 0; i < WaterLevel.waterLevel; i++) {
            deck.pop().floodTile();
            if (deck.isEmpty()) {
                ArrayList<Tile> tilesList = new ArrayList<>(Arrays.asList(Map.instance.getTiles()));
                Collections.shuffle(tilesList);

                deck = new LinkedList<>(tilesList);
            }
        }
        gamePanel.repaint();
    }
}
