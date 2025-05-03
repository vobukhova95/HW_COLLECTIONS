package ru.netology.qa.manager;

import ru.netology.qa.domain.Player;
import ru.netology.qa.exception.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }


    public Integer findByName(String name) {
        if (players.get(name) != null) {
            return players.get(name);
        }

        return null;
    }

    public int round(String playerName1, String playerName2) {
        Integer player1 = findByName(playerName1);
        Integer player2 = findByName(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }
        if (player1 > player2) {
            return 1;
        } else if (player1 < player2) {
            return 2;
        } else {
            return 0;
        }


    }
}