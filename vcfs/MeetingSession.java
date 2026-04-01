package vcfs;

import java.util.*;

/**
 * Per-reservation runtime session; uses Booth's VirtualRoom and owns lobby/attendance records.
 */
public class MeetingSession {

	VirtualRoom room;
	Lobby lobby;
	Collection<AttendanceRecord> attendanceRecords;
	Reservation reservation;
	MeetingState state;

	/**
	 * Start the session (WAITING → IN_PROGRESS).
	 * @param now
	 */
	void start(LocalDateTime now) {
		// TODO - implement MeetingSession.start
		throw new UnsupportedOperationException();
	}

	/**
	 * End the session (IN_PROGRESS → ENDED) and finalise records.
	 * @param now
	 */
	void end(LocalDateTime now) {
		// TODO - implement MeetingSession.end
		throw new UnsupportedOperationException();
	}

	/**
	 * Create/update attendance record when a candidate joins.
	 * @param candidate
	 * @param now
	 */
	AttendanceRecord recordJoin(Candidate candidate, LocalDateTime now) {
		// TODO - implement MeetingSession.recordJoin
		throw new UnsupportedOperationException();
	}

	/**
	 * Update attendance record when a candidate leaves.
	 * @param candidate
	 * @param now
	 */
	void recordLeave(Candidate candidate, LocalDateTime now) {
		// TODO - implement MeetingSession.recordLeave
		throw new UnsupportedOperationException();
	}

	/**
	 * Set session outcome (attended / no-show / ended-early).
	 * @param outcome
	 */
	void setOutcome(AttendanceOutcome outcome) {
		// TODO - implement MeetingSession.setOutcome
		throw new UnsupportedOperationException();
	}

}