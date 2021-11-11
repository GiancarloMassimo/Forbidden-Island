import java.util.*;

public class Map {
    private GridTile[][] map;

    private GridTile[] tiles = {
        new GridTile("Breaker's Bridge"),
        new GridTile("Bronze Gate"),
        new GridTile("Cave of Embers"),
        new GridTile("Cave of Shadows"),
        new GridTile("Cliffs of Abandon"),
        new GridTile("Copper Gate"),
        new GridTile("Coral Palace"),
        new GridTile("Crimson Forest"),
        new GridTile("Dunes of Deception"),
        new GridTile("Fool's Landing"),
        new GridTile("Gold Gate"),
        new GridTile("Howling Garden"),
        new GridTile("Iron Gate"),
        new GridTile("Lost Lagoon"),
        new GridTile("Misty Marsh"),
        new GridTile("Observatory"),
        new GridTile("Phantom Rock"),
        new GridTile("Silver Gate"),
        new GridTile("Temple Moon"),
        new GridTile("Temple Sun"),
        new GridTile("Tidal Palace"),
        new GridTile("Twilight Hollow"),
        new GridTile("Watchtower"),
        new GridTile("Whispering Garden")
    };

    public Map() {
        createGrid();
    }

    public GridTile[] getTiles() {
        return tiles;
    }

    private void createGrid() {
        map = new GridTile[6][6];
        ArrayList<GridTile> tilesList = new ArrayList<>(Arrays.asList(tiles));
        Collections.shuffle(tilesList);
        Queue<GridTile> tileQueue = new LinkedList<>(tilesList);
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
}
