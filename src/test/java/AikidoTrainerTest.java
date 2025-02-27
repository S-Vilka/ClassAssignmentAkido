import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class AikidoTrainerTest {
    private AikidoTrainer aikidoTrainer;

    @BeforeEach
    void setUp() {
        aikidoTrainer = new AikidoTrainer("Sergei");
    }

    @Test
    void testAddSession() {
        aikidoTrainer.addSession(LocalDate.now(), 60);
        assertEquals(1, aikidoTrainer.getTotalSessions());
        assertEquals(60, aikidoTrainer.getTotalTrainingTime());
    }

    @Test
    void testAddMultipleSessions() {
        aikidoTrainer.addSession(LocalDate.now(), 30);
        aikidoTrainer.addSession(LocalDate.now(), 45);
        aikidoTrainer.addSession(LocalDate.now(), 60);

        assertEquals(3, aikidoTrainer.getTotalSessions());
        assertEquals(135, aikidoTrainer.getTotalTrainingTime());
    }

    @Test
    void testTotalSessions() {
        aikidoTrainer.addSession(LocalDate.now(), 50);
        aikidoTrainer.addSession(LocalDate.now(), 40);
        assertEquals(2, aikidoTrainer.getTotalSessions());
    }

    @Test
    void testTotalTrainingTime() {
        aikidoTrainer.addSession(LocalDate.now(), 90);
        aikidoTrainer.addSession(LocalDate.now(), 30);
        assertEquals(120, aikidoTrainer.getTotalTrainingTime());
    }

    @Test
    void testAddSessionWithZeroDuration() {
        aikidoTrainer.addSession(LocalDate.now(), 0);
        assertEquals(0, aikidoTrainer.getTotalSessions());
        assertEquals(0, aikidoTrainer.getTotalTrainingTime());
    }

    @Test
    void testAddSessionWithNegativeDuration() {
        aikidoTrainer.addSession(LocalDate.now(), -30);
        assertEquals(0, aikidoTrainer.getTotalSessions());
        assertEquals(0, aikidoTrainer.getTotalTrainingTime());
    }

    @Test
    void testGraduationBySessions() {
        for (int i = 0; i < 100; i++) {
            aikidoTrainer.addSession(LocalDate.now(), 60);
        }
        assertTrue(aikidoTrainer.checkGraduation());
    }

    @Test
    void testGraduationByTime() {
        AikidoTrainer trainerWithOldStart = new AikidoTrainer("Alex") {
            @Override
            public boolean checkGraduation() {
                LocalDate sixMonthsAgo = LocalDate.now().minusMonths(6);
                long monthsTrained = ChronoUnit.MONTHS.between(sixMonthsAgo, LocalDate.now());
                return monthsTrained >= 6;
            }
        };
        assertTrue(trainerWithOldStart.checkGraduation());
    }

    @Test
    void testNotEligibleForGraduation() {
        aikidoTrainer.addSession(LocalDate.now(), 60);
        assertFalse(aikidoTrainer.checkGraduation());
    }
}