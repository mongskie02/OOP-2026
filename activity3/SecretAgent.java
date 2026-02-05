
import java.time.LocalDateTime;

public class SecretAgent {

    private String agentId;
    private String codeName;
    private int clearanceLevel;
    private boolean onMission;
    private LocalDateTime lastMissionCompletionTime;

    public SecretAgent(String agentId, String codeName, int clearanceLevel) {
        this.agentId = agentId;
        this.codeName = codeName;
        this.clearanceLevel = clearanceLevel;
        this.onMission = false;
        this.lastMissionCompletionTime = null;

    }

    public String getAgentId() {
        return agentId;
    }

    public String getCodename() {
        return codeName;
    }

    public int getClearanceLevel() {
        return clearanceLevel;
    }

    public boolean isOnMission() {
        return onMission;
    }

    public LocalDateTime getLastMissionCompletionTime() {
        return lastMissionCompletionTime;
    }

    public void setCodename(String newCodename) {
        this.codeName = newCodename;
    }

    public void startMission() {
        this.onMission = true;
    }

    public void completeMission() {
        this.onMission = false;
        this.lastMissionCompletionTime = LocalDateTime.now();
    }
}
