public class PlayerMessenger extends Player{

    public void giveCard(TreasureCard tCard, Player recipient) {
        super.giveCard(tCard, recipient);
    }

    public boolean canGiveCard(TreasureCard tCard, Player recipient) {
        if (treasureCardHand.contains(tCard)) {
            return true;
        }
        return false;
    }

}
