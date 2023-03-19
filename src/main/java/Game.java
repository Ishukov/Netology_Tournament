import java.util.HashMap;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player);
    }

    public Player findByName(String name) {
        Player result = null;
        for (String key : players.keySet()) {
            result = players.get(name);
        }
        if (result != null) {
            return result;
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

    public HashMap<String, Player> getPlayers() {
        return players;
    }
}
