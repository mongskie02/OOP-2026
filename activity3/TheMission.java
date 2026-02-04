
import java.time.LocalDate;
import java.util.Random;

public class TheMission {

    private String missionTarget;
    private int difficulty;
    private LocalDate missionDeadline;

    public TheMission() {
        Random random = new Random();

        String[] possibleTargets = {
            "Retrieve stolen data",
            "Infiltrate enemy base",
            "Rescue hostage",
            "Sabotage fuel depot"
        };

        this.missionTarget = possibleTargets[random.nextInt(possibleTargets.length)];

        this.difficulty = random.nextInt(10) + 1;

        int daysToAdd = random.nextInt(24) + 7;
        this.missionDeadline = LocalDate.now().plusDays(daysToAdd);
    }
}
