

import java.util.*;

/**
 * Candidate who registers, creates Requests, books Reservations and joins sessions.
 */
public class Candidate extends User {

	CandidateProfile profile;
	Collection<Request> requests;
	Collection<Reservation> reservations;

	/**
	 * Create booking request/preferences.
	 * @param desiredTags
	 * @param preferredOrgs
	 * @param maxAppointments
	 */
	Request createRequest(String desiredTags, String preferredOrgs, int maxAppointments) {
		// TODO - implement Candidate.createRequest
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param reservationId
	 */
	void cancelMyReservation(String reservationId) {
		// TODO - implement Candidate.cancelMyReservation
		throw new UnsupportedOperationException();
	}

	String viewMySchedule() {
		// TODO - implement Candidate.viewMySchedule
		throw new UnsupportedOperationException();
	}

}