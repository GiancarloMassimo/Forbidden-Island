import java.util.ArrayList;

import static java.lang.System.*;

public class Main {
    public static FloodDeck floodDeck;
    static TreasureDeck treasureDeck;
    public static ArrayList<Player> players = new ArrayList<>();
    public static Player currentPlayer;

    public static void main(String[] args) {
        out.println("Game Seed: " + RandomUtil.seed);
        Map map = new Map();
        Player player1 = new PlayerNavigator();
        Player player2 = new PlayerNavigator();
        Player player3 = new PlayerNavigator();
        Player player4 = new PlayerNavigator();

        currentPlayer = player1;

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        MainMenuFrame graphics = new MainMenuFrame("Main Menu");
        floodDeck = new FloodDeck();
        treasureDeck = new TreasureDeck();
    }
}
