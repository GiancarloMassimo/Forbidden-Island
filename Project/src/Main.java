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
        Player player1 = new PlayerPilot();
        Player player2 = new PlayerPilot();
        Player player3 = new PlayerPilot();
        Player player4 = new PlayerPilot();

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
