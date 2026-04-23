package activity14;

import java.util.Collections;

public class TournamentDemo {

    public static void main(String[] args) {

        // Create tournament
        Tournament<Athlete> tournament = new Tournament<>();

        // Add athletes
        Athlete a1 = new Athlete("KAKI", 85);
        Athlete a2 = new Athlete("BOSANG", 92);
        Athlete a3 = new Athlete("LILA", 85);

        tournament.addParticipant(a1);
        tournament.addParticipant(a2);
        tournament.addParticipant(a3);

        System.out.println("=== Before Sorting ===");
        tournament.showAll();

        // Sort athletes
        Collections.sort(tournament.getParticipants());

        System.out.println("\n=== After Sorting ===");
        tournament.showAll();

        // Deep Copy Demo
        System.out.println("\n=== Cloning Demo ===");
        Athlete clonedAthlete = a1.clone();
        clonedAthlete.addTrophy("Gold Medal");

        System.out.println("Original: " + a1);
        System.out.println("Clone: " + clonedAthlete);

        // Interface methods test
        System.out.println("\n=== Interface Methods ===");
        a1.playMatch();
        a1.reportStatus();

        System.out.println("Is score 95 valid? " + Competitor.isValidScore(95));
        System.out.println("Is score 120 valid? " + Competitor.isValidScore(120));
    }
}
