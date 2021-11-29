import static java.lang.System.*;

public class Main {
    public static void main(String[] args) {
        out.println("Game Seed: " + RandomUtil.seed);
        Map map = new Map();
        MainMenuFrame graphics = new MainMenuFrame("Main Menu");
        FloodDeck floodDeck = new FloodDeck();
    }
}
