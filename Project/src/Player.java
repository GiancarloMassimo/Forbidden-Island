import java.util.ArrayList;

public class Player {

    //generic attributes each player will have
    AdventurerCard adventurerCard;
    Pawn pawn;
    ArrayList<TreasureCard> treasureCardHand = new ArrayList<TreasureCard>();

    //player specific attributes that are only instantiated if ha

    public Player() {}

    //constructs new Player given String parameter adventurer
    public Player(String adventurer) {
        adventurerCard = new AdventurerCard(adventurer);
        pawn = new Pawn(adventurer);
    }

    //moves player Pawn to given tile coordinates
    public void move(int row, int col) {
        pawn.setRow(row);
        pawn.setCol(col);
    }

    //checks if a tile can be moved to considering current position, returns boolean
    public boolean canMove(int row, int col) {
        if ((Math.abs(row - pawn.getRow()) == 1) || (Math.abs(col - pawn.getCol()) == 1)) {
            return true;
        }
        return false;
    }

    //shores up tile with given coordinates
    public void shoreUp(int row, int col) {
        map.getTile(row, col).shoreUp();
    }

    //checks if tile can be shored up
    public boolean canShoreUp(int row, int col) {
        if ((Math.abs(row - pawn.getRow()) == 1) || (Math.abs(col - pawn.getCol()) == 1) && map.getTile(row, col).getState() != sunk) {
            return true;
        }
        return false;
    }

    public void captureTreasure(String treasure) {
    }

    public void giveCard() {

    }

    public boolean canGiveCard() {
        return false;
    }

    public void discard() {

    }

}
