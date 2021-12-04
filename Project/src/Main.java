import java.util.ArrayList;

import static java.lang.System.*;

public class Main {
    public static FloodDeck floodDeck;
    public static ArrayList<Player> players = new ArrayList<>();
    public static Player currentPlayer;

    public static void main(String[] args) {
        out.println("Game Seed: " + RandomUtil.seed);
        Map map = new Map();
        Player player1 = new Player(3, 2, "Engineer");
        Player player2 = new Player(4, 1, "Navigator");
        Player player3 = new Player(5, 3, "Pilot");
        Player player4 = new Player(3, 4, "Messenger");

        currentPlayer = player1;

        players.add(player1);
        players.add(player2);
        players.add(player3);
        players.add(player4);

        MainMenuFrame graphics = new MainMenuFrame("Main Menu");
        floodDeck = new FloodDeck();
    }
}
