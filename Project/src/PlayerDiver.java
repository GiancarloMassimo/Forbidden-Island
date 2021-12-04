
public class PlayerDiver extends Player {

    //private variables to help track which tiles are movable by diver ability
    private boolean[][] mapOfMovableTiles = new boolean[6][6];
    private boolean[][] checkedTiles = new boolean[6][6];

    public void moveSpecial(int row, int col) {
        super.move(row, col);
    }

    //checks to see if a tile is reachable by water using the diver special move ability
    public boolean canMoveSpecial(int row, int col) {
        if (!(row - col > 2 || row + col < 3) && mapOfMovableTiles[row - 1][col]) {
            return true;
        }
        if (!(col - row > 2 || row + col > 7) && mapOfMovableTiles[row + 1][col]) {
            return true;
        }
        if (!(col - row > 2 || row + col < 3) && mapOfMovableTiles[row][col - 1]) {
            return true;
        }
        if (!(row - col > 2 || row + col > 7) && mapOfMovableTiles[row][col + 1]) {
            return true;
        }
        return false;
    }

    private void updateMapOfReachableTiles() {
        mapOfMovableTiles = new boolean[6][6];
        checkedTiles = new boolean[6][6];
        checkNeighboringTiles(pawn.getRow(), pawn.getCol());
    }

    //recursive method that finds the branch of all movable tiles starting from a given position
    private void checkNeighboringTiles(int row, int col) {
        if (!(row - col > 2 || row + col < 3) &&
                Map.instance.getTileAtPosition(row - 1, col).getState() != TileState.normal &&
                checkedTiles[row - 1][col] == false) {
            mapOfMovableTiles[row - 1][col] = true;
            checkedTiles[row - 1][col] = true;
            checkNeighboringTiles(row - 1, col);
        }
        if (!(col - row > 2 || row + col > 7) &&
                Map.instance.getTileAtPosition(row + 1, col).getState() != TileState.normal &&
                checkedTiles[row + 1][col] == false) {
            mapOfMovableTiles[row + 1][col] = true;
            checkedTiles[row + 1][col] = true;
            checkNeighboringTiles(row + 1, col);
        }
        if (!(col - row > 2 || row + col < 3) &&
                Map.instance.getTileAtPosition(row, col - 1).getState() != TileState.normal &&
                checkedTiles[row][col - 1] == false) {
            mapOfMovableTiles[row][col - 1] = true;
            checkedTiles[row][col - 1] = true;
            checkNeighboringTiles(row, col - 1);
        }
        if (!(row - col > 2 || row + col > 7) &&
                Map.instance.getTileAtPosition(row, col + 1).getState() != TileState.normal &&
                checkedTiles[row][col + 1] == false) {
            mapOfMovableTiles[row][col + 1] = true;
            checkedTiles[row][col + 1] = true;
            checkNeighboringTiles(row, col + 1);
        }
    }
}
