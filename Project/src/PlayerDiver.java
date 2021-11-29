
public class PlayerDiver extends Player {

    public void move(int row, int col) {
        super.move(row, col);
    }

    //@Override
    public boolean canMove(int row, int col) {
        /*if (map.getTile(row, col).getState() == sunk) {
            return false;
        }*/
        if ((Math.abs(row - pawn.getRow()) == 1) || (Math.abs(col - pawn.getCol()) == 1)) {
            return true;
        }
        if (canMoveSpecial(row, col)) {
            return true;
        }
        return false;
    }

    private boolean canMoveSpecial(int row, int col) {
        /*if (map.getTile(pawn.getRow())) {

        }*/
        return false;
    }

}
