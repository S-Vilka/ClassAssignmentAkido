import java.time.LocalDate;

public class PracticeSession {
    private final LocalDate date;
    private final int duration;

    public PracticeSession(LocalDate date, int duration) {
        this.date = date;
        this.duration = duration;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDuration() {
        return duration;
    }
}