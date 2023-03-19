import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Player1", 10);
    Player player2 = new Player(2, "Player2", 12);
    Player player3 = new Player(3, "Player3", 10);
    Player player4 = new Player(4, "Player4", 15);
    Player player5 = new Player(5, "Player5", 6);

    @BeforeEach
    public void prepare() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);
    }

    //    @Test
//    public void shouldAddPlayer() {
//        List<Player> expected = List.of(player1, player2, player3, player4, player5);
//        List<Player> actual = game.getPlayers();
//
//        Assertions.assertEquals(expected, actual);
//    }
    @Test
    public void shouldRoundPlayer1IsStronger() {
        int expected = 1;
        int actual = game.round("Player1", "Player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayer2IsStronger() {
        int expected = 2;
        int actual = game.round("Player1", "Player4");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundDraw() {
        int expected = 0;
        int actual = game.round("Player1", "Player3");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRoundPlayerNotFound() {
        Assertions.assertThrows(NotRegisteredException.class, () -> game.findByName("Player"));
    }

}
