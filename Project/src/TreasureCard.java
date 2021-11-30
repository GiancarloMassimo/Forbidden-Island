public class TreasureCard implements Card{

    private String type;

    public TreasureCard(String t) {
        type = t;
    }

    @Override
    public void onDraw() {

    }

    public String getType() {
        return type;
    }


}
