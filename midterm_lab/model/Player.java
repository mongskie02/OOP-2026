package com.rps.game.model;

public class Player {
    private String name;
    private int score;
    private Move move;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.move = null;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Move getMove() {
        return move;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public void resetMove() {
        this.move = null;
    }

    public void addScore() {
        score++;
    }
}