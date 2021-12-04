public class PlayerMessenger extends Player{

    //@Override
    public void giveCard(TreasureCard tCard, Player recipient) {
        super.giveCard(tCard, recipient);
    }

    //@Override
    public boolean canGiveCard(TreasureCard tCard, Player recipient) {
        if (treasureCardHand.contains(tCard)) {
            return true;
        }
        return false;
    }

}
