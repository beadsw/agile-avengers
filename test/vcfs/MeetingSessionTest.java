/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package vcfs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author megda
 */
public class MeetingSessionTest {
    
    public MeetingSessionTest() {
    }

@Test
    public void startChangesWaitingStateToInProgress() {
        MeetingSession session = new MeetingSession();
        session.state = MeetingState.WAITING;

        session.start(LocalDateTime.of(2026, 4, 7, 10, 0));

        assertEquals(MeetingState.IN_PROGRESS, session.state);
    }

    @Test
    public void startWithNullTimeThrowsException() {
        MeetingSession session = new MeetingSession();
        session.state = MeetingState.WAITING;

        try {
            session.start(null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Time cannot be null", e.getMessage());
        }
    }

    @Test
    public void startDoesNotChangeStateWhenNotWaiting() {
        MeetingSession session = new MeetingSession();
        session.state = MeetingState.ENDED;

        session.start(LocalDateTime.of(2026, 4, 7, 10, 0));

        assertEquals(MeetingState.ENDED, session.state);
    }

    @Test
    public void endChangesInProgressStateToEnded() {
        MeetingSession session = new MeetingSession();
        session.state = MeetingState.IN_PROGRESS;

        session.end(LocalDateTime.of(2026, 4, 7, 11, 0));

        assertEquals(MeetingState.ENDED, session.state);
    }

    @Test
    public void endWithNullTimeThrowsException() {
        MeetingSession session = new MeetingSession();
        session.state = MeetingState.IN_PROGRESS;

        try {
            session.end(null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Time cannot be null", e.getMessage());
        }
    }

    @Test
    public void endDoesNotChangeStateWhenNotInProgress() {
        MeetingSession session = new MeetingSession();
        session.state = MeetingState.WAITING;

        session.end(LocalDateTime.of(2026, 4, 7, 11, 0));

        assertEquals(MeetingState.WAITING, session.state);
    }

    @Test
    public void recordJoinWithNullCandidateThrowsException() {
        MeetingSession session = new MeetingSession();
        session.attendanceRecords = new ArrayList<>();

        try {
            session.recordJoin(null, LocalDateTime.of(2026, 4, 7, 10, 0));
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Invalid Join", e.getMessage());
        }
    }

    @Test
    public void recordJoinWithNullTimeThrowsException() {
        MeetingSession session = new MeetingSession();
        session.attendanceRecords = new ArrayList<>();

        try {
            session.recordJoin(new Candidate(), null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Invalid Join", e.getMessage());
        }
    }

    @Test
    public void recordJoinCreatesNewAttendanceRecordWhenNoOpenRecordExists() {
        MeetingSession session = new MeetingSession();
        session.attendanceRecords = new ArrayList<>();
        Candidate candidate = new Candidate();
        LocalDateTime joinTime = LocalDateTime.of(2026, 4, 7, 10, 5);

        AttendanceRecord record = session.recordJoin(candidate, joinTime);

        assertNotNull(record);
        assertEquals(session, record.session);
        assertEquals(joinTime, record.joinTime);
        assertNull(record.leaveTime);
        assertTrue(session.attendanceRecords.contains(record));
        assertEquals(1, session.attendanceRecords.size());
    }

    @Test
    public void recordJoinReturnsExistingOpenRecordInsteadOfCreatingNewOne() {
        MeetingSession session = new MeetingSession();
        session.attendanceRecords = new ArrayList<>();

        AttendanceRecord existingRecord = new AttendanceRecord();
        existingRecord.session = session;
        existingRecord.joinTime = LocalDateTime.of(2026, 4, 7, 10, 0);
        existingRecord.leaveTime = null;

        session.attendanceRecords.add(existingRecord);

        AttendanceRecord returnedRecord =
                session.recordJoin(new Candidate(), LocalDateTime.of(2026, 4, 7, 10, 10));

        assertSame(existingRecord, returnedRecord);
        assertEquals(1, session.attendanceRecords.size());
    }

    @Test
    public void recordLeaveWithNullCandidateThrowsException() {
        MeetingSession session = new MeetingSession();

        try {
            session.recordLeave(null, LocalDateTime.of(2026, 4, 7, 10, 30));
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Invalid Leave", e.getMessage());
        }
    }

    @Test
    public void recordLeaveWithNullTimeThrowsException() {
        MeetingSession session = new MeetingSession();

        try {
            session.recordLeave(new Candidate(), null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertEquals("Invalid Leave", e.getMessage());
        }
    }

    @Test
    public void recordLeaveDoesNothingWhenAttendanceRecordsAreNull() {
        MeetingSession session = new MeetingSession();

        session.recordLeave(new Candidate(), LocalDateTime.of(2026, 4, 7, 10, 30));
    }

    @Test
    public void recordLeaveUpdatesOpenAttendanceRecord() {
        MeetingSession session = new MeetingSession();
        session.attendanceRecords = new ArrayList<>();

        AttendanceRecord record = new AttendanceRecord();
        record.session = session;
        record.joinTime = LocalDateTime.of(2026, 4, 7, 10, 0);
        record.leaveTime = null;
        record.outcome = null;

        session.attendanceRecords.add(record);

        LocalDateTime leaveTime = LocalDateTime.of(2026, 4, 7, 10, 25);
        session.recordLeave(new Candidate(), leaveTime);

        assertEquals(leaveTime, record.leaveTime);
        assertEquals(AttendanceOutcome.ATTENDED, record.outcome);
    }

    @Test
    public void setOutcomeWithNullValueThrowsException() {
        MeetingSession session = new MeetingSession();

        try {
            session.setOutcome(null);
            fail("Expected UnsupportedOperationException to be thrown");
        } catch (UnsupportedOperationException e) {
            assertNotNull(e);
        }
    }

    @Test
    public void setOutcomeDoesNothingWhenAttendanceRecordsAreNull() {
        MeetingSession session = new MeetingSession();

        session.setOutcome(AttendanceOutcome.NO_SHOW);
    }

    @Test
    public void setOutcomeUpdatesAllAttendanceRecords() {
        MeetingSession session = new MeetingSession();
        session.attendanceRecords = new ArrayList<>();

        AttendanceRecord record1 = new AttendanceRecord();
        record1.session = session;

        AttendanceRecord record2 = new AttendanceRecord();
        record2.session = session;

        session.attendanceRecords.add(record1);
        session.attendanceRecords.add(record2);

        session.setOutcome(AttendanceOutcome.ENDED_EARLY);

        assertEquals(AttendanceOutcome.ENDED_EARLY, record1.outcome);
        assertEquals(AttendanceOutcome.ENDED_EARLY, record2.outcome);
    }  
}
