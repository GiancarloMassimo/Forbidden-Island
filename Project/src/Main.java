import static java.lang.System.*;

public class Main {
    public static FloodDeck floodDeck;
    public static Player player;

    public static void main(String[] args) {
        out.println("Game Seed: " + RandomUtil.seed);
        Map map = new Map();
        player = new Player(3, 2);
        MainMenuFrame graphics = new MainMenuFrame("Main Menu");
        floodDeck = new FloodDeck();
    }
}
