
public class Main {

    public static void main(String[] args) {

        SecretAgent agent = new SecretAgent("007", "James Bond", 5);

        System.out.println(agent.getAgentId());
        System.out.println(agent.getCodename());
        System.out.println(agent.getClearanceLevel());
        System.out.println(agent.isOnMission());

        TheMission mission = new TheMission();

        mission.displayMissionBriefing();

        if (agent.getClearanceLevel() >= mission.getDifficulty()) {
            agent.startMission();
            System.out.println("Agent 007 is cleared for mission.");

            System.out.println(agent.isOnMission());

            agent.completeMission();

            System.out.println(agent.getLastMissionCompletionTime());
        } else {
            System.out.println("Agent 007's failed the mission.");
        }
    }
}
