import java.awt.*;
import java.lang.reflect.GenericArrayType;

public class Map {
    private GridTile[][] map;

    //TODO: Separate based on treasure
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

    private GridTile foolsLanding = new GridTile("Fool's Landing");

    public Map() {
        map = new GridTile[6][6];

        for (int r = 0; r < map.length; r++) {
            for (int c = 0; c < map.length; c++) {

            }
        }
    }
}
