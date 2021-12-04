public class PlayerPilot extends Player{

    //Since pilot can only use special move once per turn, he has to have boolean which turns false after using in a turn
    private boolean abilityIsAvailable = false;

    public void startTurn() {
        abilityIsAvailable = true;
    }

    public void moveSpecial(int row, int col) {
        super.move(row, col);
        abilityIsAvailable = false;
    }

    public boolean canMoveSpecial(int row, int col) {
        if (abilityIsAvailable && Map.instance.getTileAtPosition(row, col).getState() != TileState.sunk)
            return true;
        return false;
    }

}