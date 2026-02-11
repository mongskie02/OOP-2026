
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Push {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter commit message: ");
        String commitMessage = scanner.nextLine();

        String username = "johnverz22";
        String email = "johnny.verzola@lorma.edu";

        try {
            // 1. Set global identity
            System.out.println("Setting global credentials...");
            run("git", "config", "--global", "user.name", username);
            run("git", "config", "--global", "user.email", email);

            // 2. Git Operations
            run("git", "add", ".");
            run("git", "commit", "-m", commitMessage);
            run("git", "pull", "--rebase", "origin", "main");
            run("git", "push", "origin", "main");

            System.out.println("Push complete.");

        } catch (Exception e) {
            System.err.println("Execution failed: " + e.getMessage());
        } finally {
            // 3. Remove credentials if present
            System.out.println("\nCleaning up global credentials...");
            cleanupConfig("user.name");
            cleanupConfig("user.email");

            scanner.close();
        }
    }

    /**
     * Unsets the global git config key. Uses a try-catch to prevent the program
     * from crashing if the key wasn't there.
     */
    private static void cleanupConfig(String key) {
        try {
            // --unset removes the value; if it doesn't exist, git returns an error code
            // but we catch it here to keep the flow smooth.
            ProcessBuilder pb = new ProcessBuilder("git", "config", "--global", "--unset", key);
            Process p = pb.start();
            p.waitFor();
            System.out.println("Global " + key + " removed.");
        } catch (Exception e) {
            System.err.println("Could not unset " + key);
        }
    }

    private static void run(String... cmd) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(cmd);
        pb.redirectErrorStream(true);
        Process p = pb.start();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }

        if (p.waitFor() != 0) {
            throw new RuntimeException("Command failed: " + String.join(" ", cmd));
        }
    }
}
