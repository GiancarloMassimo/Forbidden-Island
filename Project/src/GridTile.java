public class GridTile {
    private String name;
    private int row = -1, col = -1;
    private TileState state = TileState.normal;

    public GridTile(String name) {
        this.name = name;
    }

    public void floodTile () {
        if (state == TileState.normal) {
            state = TileState.flooded;
        } else {
            state = TileState.sunk;
        }
    }

    public String toString() {
        return name;
    }
}
