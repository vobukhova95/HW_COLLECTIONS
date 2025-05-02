import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.qa.Game;
import ru.netology.qa.NotRegisteredException;
import ru.netology.qa.Player;

public class GameTest {
    Player player1 = new Player(1, "Вася", 79);
    Player player2 = new Player(2, "Вика", 45);
    Player player3 = new Player(3, "Саша", 31);
    Player player4 = new Player(4, "Таня", 98);
    Player player5 = new Player(5, "Игорь", 45);

    Game game = new Game();

    @Test
    public void PlayerFirstNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class,() -> {
        game.round("Игорь", "Вика");
        });
    }

    @Test
    public void PlayerSecondNotRegistered() {
        game.register(player1);
        game.register(player2);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Саша");
        });
    }

    @Test
    public void BothPlayersNotRegistered() {
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Таня");
        });
    }

    @Test

    public void FirstPlayerMoreStrength() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);

        int expected = 1;
        int actual = game.round("Таня", "Вика");

        Assertions.assertEquals(expected,actual);
    }
@Test
    public void SecondPlayerMoreStrength() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 2;
        int actual = game.round("Саша", "Вася");

        Assertions.assertEquals(expected,actual);
    }

    @Test
     public void StrengthPlayersEqual() {
        game.register(player1);
        game.register(player2);
        game.register(player3);
        game.register(player4);
        game.register(player5);

        int expected = 0;
        int actual = game.round("Игорь", "Вика");

        Assertions.assertEquals(expected,actual);
    }
}
