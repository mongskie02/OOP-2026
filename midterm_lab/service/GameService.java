package com.rps.game.service;

import com.rps.game.model.Player;
import com.rps.game.model.Move;

public class GameService {

    public String compareMoves(Player p1, Player p2) {
        Move m1 = p1.getMove();
        Move m2 = p2.getMove();

        String result;

        if (m1 == m2) {
            result = "Draw!";
        } 
        else if (
            (m1 == Move.ROCK && m2 == Move.SCISSORS) ||
            (m1 == Move.PAPER && m2 == Move.ROCK) ||
            (m1 == Move.SCISSORS && m2 == Move.PAPER)
        ) {
            p1.addScore(); 
            result = p1.getName() + " wins!";
        } 
        else {
            p2.addScore(); 
            result = p2.getName() + " wins!";
        }

        result += " | Scores: " 
                + p1.getName() + "=" + p1.getScore() 
                + ", " 
                + p2.getName() + "=" + p2.getScore();

        return result;
    }
}