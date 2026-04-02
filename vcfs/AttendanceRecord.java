package vcfs;

/**
 * Attendance log for a single participant in a MeetingSession.
 */
public class AttendanceRecord {

	MeetingSession session;
	LocalDateTime joinTime;
	LocalDateTime leaveTime;
	AttendanceOutcome outcome;

	/**
	 * Finalise the record with leave time and outcome.
	 * @param leaveTime
	 * @param outcome
	 */
	void close(LocalDateTime leaveTime, AttendanceOutcome outcome) {
		if (leaveTime == null || outcome == null) {
                    throw new UnsupportedOperationException();
                }
                
                this.leaveTime = leaveTime;
                this.outcome = outcome;
        }

}