public class PlayerNavigator extends Player{


    public void moveOtherPlayer(Player p, int row, int col) {
        p.pawn.setRow(row);
        p.pawn.setCol(col);
    }

    public boolean canMoveOtherPlayer(Player p, int row, int col) {
        if (Math.abs(p.pawn.getRow() - row) + Math.abs(p.pawn.getCol() - col) <= 2) {
            if (!Map.instance.getTileAtPosition(row, col).getState().equals(TileState.sunk)) {
                return true;
            }
        }
        return false;

    }
}
