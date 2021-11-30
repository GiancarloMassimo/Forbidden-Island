
public class PlayerExplorer extends Player{

    public void move(int row, int col) {
        super.move(row, col);
    }

    //@Override
    public boolean canMove(int row, int col) {
        if ((Math.abs(row - pawn.getRow()) == 1) || (Math.abs(col - pawn.getCol()) == 1)) {
            if (Map.instance.getTileAtPosition(row,col).getState() == TileState.sunk) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void shoreUp(int row, int col) {
        super.shoreUp(row, col);
    }

    //@Override
    public boolean canShoreUp(int row, int col) {
        if (Math.abs(row - pawn.getRow()) <= 1 && Math.abs(col - pawn.getCol()) <= 1) {
            return true;
        }
        return false;
    }

}
