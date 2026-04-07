/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vcfs;

import java.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author megda
 */
public class ReservationTest {
    
    public ReservationTest() {
    }

    @Test
    public void cancelWithValidReasonSetsStateToCancelled() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;

        reservation.cancel("Recruiter unavailable");

        assertEquals(ReservationState.CANCELLED, reservation.state);
    }

    @Test
    public void cancelWithNullReasonThrowsException() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;

        try {
            reservation.cancel(null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Reason required", e.getMessage());
        }
    }

    @Test
    public void isActiveReturnsTrueWhenConfirmedAndInsideTimeWindow() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 10, 30));

        assertTrue(result);
    }

    @Test
    public void isActiveReturnsFalseBeforeStart() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 9, 59));

        assertFalse(result);
    }

    @Test
    public void isActiveReturnsFalseAfterEnd() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 11, 1));

        assertFalse(result);
    }

    @Test
    public void isActiveReturnsFalseAtExactStartBoundary() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 10, 0));

        assertFalse(result);
    }

    @Test
    public void isActiveReturnsFalseAtExactEndBoundary() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 11, 0));

        assertFalse(result);
    }

    @Test
    public void isActiveReturnsFalseWhenStateIsNull() {
        Reservation reservation = new Reservation();
        reservation.state = null;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 10, 30));

        assertFalse(result);
    }

    @Test
    public void isActiveReturnsFalseWhenStateIsCancelled() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CANCELLED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        boolean result = reservation.isActive(LocalDateTime.of(2026, 4, 7, 10, 30));

        assertFalse(result);
    }

    @Test
    public void isActiveThrowsWhenNowIsNull() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        try {
            reservation.isActive(null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void isActiveThrowsWhenScheduledStartIsNull() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = null;
        reservation.scheduledEnd = LocalDateTime.of(2026, 4, 7, 11, 0);

        try {
            reservation.isActive(LocalDateTime.of(2026, 4, 7, 10, 30));
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void isActiveThrowsWhenScheduledEndIsNull() {
        Reservation reservation = new Reservation();
        reservation.state = ReservationState.CONFIRMED;
        reservation.scheduledStart = LocalDateTime.of(2026, 4, 7, 10, 0);
        reservation.scheduledEnd = null;

        try {
            reservation.isActive(LocalDateTime.of(2026, 4, 7, 10, 30));
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertNotNull(e);
        }
    }
}
