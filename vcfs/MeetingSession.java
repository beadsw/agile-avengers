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
		if (now == null) {
                    throw new UnsupportedOperationException("Time cannot be null");
	}
                if (state == MeetingState.WAITING) {
                    state = MeetingState.IN_PROGRESS;
                }
                
        }

	/**
	 * End the session (IN_PROGRESS → ENDED) and finalise records.
	 * @param now
	 */
	void end(LocalDateTime now) {
		if (now == null) {
                    throw new UnsupportedOperationException("Time cannot be null");
	}
                if (state == MeetingState.IN_PROGRESS) {
                    state = MeetingState.ENDED;
                }
        }
	/**
	 * Create/update attendance record when a candidate joins.
	 * @param candidate
	 * @param now
	 */
	AttendanceRecord recordJoin(Candidate candidate, LocalDateTime now) {
            if (candidate == null || now == null) {
                throw new UnsupportedOperationException("Invalid Join");
            }
            
            for(AttendanceRecord record : attendanceRecords){
                if(record.leaveTime == null){
                    return record;
                }
            }
            
            
                
        AttendanceRecord record = new AttendanceRecord();
        record.session = this;
        record.joinTime = now;
        
        if (attendanceRecords == null) {
            attendanceRecords = new ArrayList<>();
        }
        
        attendanceRecords.add(record);
        return record;
        
        }

	/**
	 * Update attendance record when a candidate leaves.
	 * @param candidate
	 * @param now
	 */
	void recordLeave(Candidate candidate, LocalDateTime now) {
		if (candidate == null || now == null) {
                    throw new UnsupportedOperationException("Invalid Leave");
	}
                if (attendanceRecords == null) {
                    return;
                }

                for (AttendanceRecord record : attendanceRecords) {
                    if (record.leaveTime == null && record.session == this) {
                        record.leaveTime = now;
                        record.outcome = AttendanceOutcome.ATTENDED;
                        return;
                    }
                  }
                }
	/**
	 * Set session outcome (attended / no-show / ended-early).
	 * @param outcome
	 */
	void setOutcome(AttendanceOutcome outcome) {
            if(outcome == null){
                throw new UnsupportedOperationException();
            }
            
            if (attendanceRecords == null) {
                return;
            }
            
            for(AttendanceRecord record : attendanceRecords){
                record.outcome = outcome;
            }
	}
}