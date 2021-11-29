import java.util.*;

public class Map {
    private Tile[][] map;
    static Map instance;

    private Tile[] tiles = {
        new Tile("Breaker's Bridge"),
        new Tile("Bronze Gate"),
        new Tile("Cave of Embers"),
        new Tile("Cave of Shadows"),
        new Tile("Cliffs of Abandon"),
        new Tile("Copper Gate"),
        new Tile("Coral Palace"),
        new Tile("Crimson Forest"),
        new Tile("Dunes of Deception"),
        new Tile("Fool's Landing"),
        new Tile("Gold Gate"),
        new Tile("Howling Garden"),
        new Tile("Iron Gate"),
        new Tile("Lost Lagoon"),
        new Tile("Misty Marsh"),
        new Tile("Observatory"),
        new Tile("Phantom Rock"),
        new Tile("Silver Gate"),
        new Tile("Temple Moon"),
        new Tile("Temple Sun"),
        new Tile("Tidal Palace"),
        new Tile("Twilight Hollow"),
        new Tile("Watchtower"),
        new Tile("Whispering Garden")
    };

    public Map() {
        if (Map.instance != null) {
            return;
        }
        createGrid();
        Map.instance = this;
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public Tile[][] getMap() {
        return map;
    }

    private void createGrid() {
        map = new Tile[6][6];
        ArrayList<Tile> tilesList = new ArrayList<>(Arrays.asList(tiles));
        Collections.shuffle(tilesList);
        Queue<Tile> tileQueue = new LinkedList<>(tilesList);
        System.out.println(tileQueue.toString());

        int margin = 2;
        for (int r = 0; r < map.length; r++) {
            for (int c = margin; c < map.length - margin; c++) {
                map[r][c] = tileQueue.poll();
            }

            if (r < map.length / 2 - 1) {
                margin--;
            } else if (r > map.length / 2 - 1) {
                margin++;
            }
        }
    }

    public Tile findTileInMapByName(String name) {
        for (Tile[] row : map) {
            for(Tile tile : row) {
                if (tile.getName().equals(name)) {
                    return tile;
                }
            }
        }

        return null;
    }

    public Tile getTileAtPosition(int row, int col) {
        return map[row][col];
    }
}
