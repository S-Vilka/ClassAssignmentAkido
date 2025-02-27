import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class AikidoTrainer {
    private final List<PracticeSession> trainingLog = new ArrayList<>();
    private final String name;
    private final LocalDate startDate;

    public AikidoTrainer(String name) {
        this.name = name;
        this.startDate = LocalDate.now(); // Directly using LocalDate
        System.out.println("\nWelcome to the Aikido training program, " + name);
        System.out.println("Starting date: " + startDate);
    }

    public void addSession(LocalDate date, int duration) {
        if (duration <= 0) {
            System.out.println("Invalid duration! Must be greater than 0.");
            return;
        }

        trainingLog.add(new PracticeSession(date, duration));
        System.out.println("Training session " + trainingLog.size() + " completed. Duration: " + duration + " minutes.");
    }

    public int getTotalTrainingTime() {
        return trainingLog.stream().mapToInt(PracticeSession::getDuration).sum();
    }

    public int getTotalSessions() {
        return trainingLog.size();
    }

    public boolean checkGraduation() {
        long monthsTrained = ChronoUnit.MONTHS.between(startDate, LocalDate.now());
        return monthsTrained >= 6 || trainingLog.size() >= 100;
    }
}