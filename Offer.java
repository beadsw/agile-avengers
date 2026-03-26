

import java.util.*;

/**
 * A bookable appointment offering published by a recruiter. Availability is intentionally not modelled here; groups design availability representation.
 */
public class Offer {

	Recruiter publisher;
	Collection<Reservation> reservations;
	String title;
	int durationMins;
	String topicTags;
	int capacity;

	/**
	 * Update offer metadata (topic/tags, duration, capacity).
	 * @param title
	 * @param durationMins
	 * @param topicTags
	 * @param capacity
	 */
	void updateDetails(String title, int durationMins, String topicTags, int capacity) {
		// TODO - implement Offer.updateDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * Return offer duration (minutes).
	 */
	int getDurationMins() {
		return this.durationMins;
	}

}