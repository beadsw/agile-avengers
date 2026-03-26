

import java.util.*;

/**
 * Recruiter assigned to a Booth; publishes Offers and hosts sessions.
 */
public class Recruiter extends User {

	Collection<Offer> offers;
	Booth booth;

	/**
	 * Create a new offer owned by this recruiter (system registers it).
	 * @param title
	 * @param durationMins
	 * @param topicTags
	 * @param capacity
	 */
	Offer publishOffer(String title, int durationMins, String topicTags, int capacity) {
		// TODO - implement Recruiter.publishOffer
		throw new UnsupportedOperationException();
	}

	/**
	 * Request cancellation of a reservation as a recruiter (policy enforced by system).
	 * @param reservationId
	 * @param reason
	 */
	void cancelReservation(String reservationId, String reason) {
		// TODO - implement Recruiter.cancelReservation
		throw new UnsupportedOperationException();
	}

	/**
	 * Return a human-readable view of the recruiter's schedule.
	 */
	String viewSchedule() {
		// TODO - implement Recruiter.viewSchedule
		throw new UnsupportedOperationException();
	}

}