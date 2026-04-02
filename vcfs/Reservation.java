package vcfs;

import java.time.LocalDateTime; 
/**
 * A booking linking a Candidate to an Offer at a specific time window.
 */
public class Reservation {

	Candidate candidate;
	Offer offer;
	MeetingSession session;
	ReservationState state;
	LocalDateTime scheduledStart;
	LocalDateTime scheduledEnd;

	/**
	 * Cancel the reservation (reason recorded by policy).
	 * @param reason
	 */
	void cancel(String reason) {
            if (reason == null)  {
                throw new UnsupportedOperationException("Reason required");
            }

            state = ReservationState.CANCELLED;
        }
        
	/**
	 * True if reservation is active at time now.
	 * @param now
	 */
	boolean isActive(LocalDateTime now) {
		if (now == null || scheduledStart == null || scheduledEnd == null) {
                    throw new UnsupportedOperationException();
                }
                
                if(state == null){
                    return false;
                }
                
                return state == ReservationState.CONFIRMED && now.isAfter(scheduledStart) && now.isBefore(scheduledEnd);
        }
}

        