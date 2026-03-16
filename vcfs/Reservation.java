package vcfs;

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
		// TODO - implement Reservation.cancel
		throw new UnsupportedOperationException();
	}

	/**
	 * True iff reservation is active at time now.
	 * @param now
	 */
	boolean isActive(LocalDateTime now) {
		// TODO - implement Reservation.isActive
		throw new UnsupportedOperationException();
	}

}