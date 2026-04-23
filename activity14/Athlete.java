package activity14;

import java.util.ArrayList;

public class Athlete implements Competitor, Comparable<Athlete>, Cloneable {

    private String name;
    private int score;
    private ArrayList<String> trophies;

    public Athlete(String name, int score) {
        this.name = name;
        this.score = score;
        this.trophies = new ArrayList<>();
    }

    public void addTrophy(String trophy) {
        trophies.add(trophy);
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getTrophies() {
        return trophies;
    }

    // Implement Competitor
    public void playMatch() {
        System.out.println(name + " is playing a match!");
    }

    // Implement Comparable
    @Override
    public int compareTo(Athlete other) {
        if (this.score != other.score) {
            return Integer.compare(other.score, this.score); // descending
        }
        return this.name.compareTo(other.name); // ascending
    }

    // Deep Copy Clone
    @Override
    public Athlete clone() {
        try {
            Athlete cloned = (Athlete) super.clone();
            cloned.trophies = new ArrayList<>(this.trophies); // deep copy
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Score: " + score + ", Trophies: " + trophies;
    }
}