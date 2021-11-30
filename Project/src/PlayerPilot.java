public class PlayerPilot extends Player{

    private boolean abilityIsAvailable = false;

    public void moveSpecial(int row, int col) {
        super.move(row, col);
    }

    public boolean canMoveSpecial(int row, int col) {
        if (abilityIsAvailable && Map.instance.getTileAtPosition(row, col) != null)
            return true;
        return false;
    }

}