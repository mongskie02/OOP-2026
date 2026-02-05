
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class TheMission {

    private String missionTarget;
    private LocalDate missionDeadline;
    private int difficulty;

    public TheMission() {
        Random random = new Random();
        String[] targets = {"Retrieve stolen data", "Infiltrate enemy base", "Rescue hostage"};

        this.missionTarget = targets[random.nextInt(targets.length)];
        this.difficulty = random.nextInt(10) + 1;

        int daysToAdd = random.nextInt(24) + 7;
        this.missionDeadline = LocalDate.now().plusDays(daysToAdd);
    }

    public String getMissionTarget() {
        return missionTarget;
    }

    public LocalDate getMissionDeadline() {
        return missionDeadline;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void displayMissionBriefing() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd, yyyy");
        System.out.println("* MISSION BRIEFING *");
        System.out.println("Target: " + this.missionTarget);
        System.out.println("Difficulty: " + this.difficulty);
        System.out.println("Deadline: " + this.missionDeadline.format(formatter));
        System.out.println();
    }
}
