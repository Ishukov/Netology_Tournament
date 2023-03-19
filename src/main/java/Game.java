import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (name.equals(player.getName())) {
                return player;
            }
        }
        throw new NotRegisteredException("Element with name: " + name + " not found");
    }


    public int round(String playerName1, String playerName2) {
        PlayersStrengthComparator comparator = new PlayersStrengthComparator();
        int result;
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        result = comparator.compare(player1, player2);
        return result;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
