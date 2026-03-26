

/**
 * Application façade..
 */
public class CareerFairSystem {

	CareerFair fair;

	/**
	 * Admin: validate and set the fair timeline.
	 * @param openTime
	 * @param closeTime
	 * @param startTime
	 * @param endTime
	 */
	void configureTimes(LocalDateTime openTime, LocalDateTime closeTime, LocalDateTime startTime, LocalDateTime endTime) {
		// TODO - implement CareerFairSystem.configureTimes
		throw new UnsupportedOperationException();
	}

	/**
	 * Admin: clear in-memory fair data for a fresh run.
	 */
	void resetFairData() {
		// TODO - implement CareerFairSystem.resetFairData
		throw new UnsupportedOperationException();
	}

	/**
	 * Admin: create/register a participating organization.
	 * @param name
	 */
	Organization addOrganization(String name) {
		// TODO - implement CareerFairSystem.addOrganization
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param org
	 * @param title
	 */
	Booth addBooth(Organization org, String title) {
		// TODO - implement CareerFairSystem.addBooth
		throw new UnsupportedOperationException();
	}

	/**
	 * Create recruiter and assign to booth (unique email enforced).
	 * @param displayName
	 * @param email
	 * @param booth
	 */
	Recruiter registerRecruiter(String displayName, String email, Booth booth) {
		// TODO - implement CareerFairSystem.registerRecruiter
		throw new UnsupportedOperationException();
	}

	/**
	 * Create candidate and profile (unique email enforced).
	 * @param displayName
	 * @param email
	 * @param cvSummary
	 * @param interestTags
	 */
	Candidate registerCandidate(String displayName, String email, String cvSummary, String interestTags) {
		// TODO - implement CareerFairSystem.registerCandidate
		throw new UnsupportedOperationException();
	}

	/**
	 * Register a recruiter-owned offer; check phase/policy.
	 * @param recruiter
	 * @param title
	 * @param durationMins
	 * @param topicTags
	 * @param capacity
	 */
	Offer publishOffer(Recruiter recruiter, String title, int durationMins, String topicTags, int capacity) {
		// TODO - implement CareerFairSystem.publishOffer
		throw new UnsupportedOperationException();
	}

	/**
	 * Register a candidate request; check phase/policy.
	 * @param candidate
	 * @param desiredTags
	 * @param preferredOrgs
	 * @param maxAppointments
	 */
	Request createRequest(Candidate candidate, String desiredTags, String preferredOrgs, int maxAppointments) {
		// TODO - implement CareerFairSystem.createRequest
		throw new UnsupportedOperationException();
	}

	/**
	 * Create a CONFIRMED reservation at selected time (availability+validation mechanisms to be designed by groups).
	 * @param candidate
	 * @param offer
	 * @param start
	 */
	Reservation manualBook(Candidate candidate, Offer offer, LocalDateTime start) {
		// TODO - implement CareerFairSystem.manualBook
		throw new UnsupportedOperationException();
	}

	/**
	 * Automatically find and book a CONFIRMED reservation (matching+availability mechanisms to be designed by groups).
	 * @param candidate
	 * @param request
	 */
	Reservation autoBook(Candidate candidate, Request request) {
		// TODO - implement CareerFairSystem.autoBook
		throw new UnsupportedOperationException();
	}

	/**
	 * Cancel as recruiter; record audit and publish events.
	 * @param recruiter
	 * @param reservationId
	 * @param reason
	 */
	void cancelAsRecruiter(Recruiter recruiter, String reservationId, String reason) {
		// TODO - implement CareerFairSystem.cancelAsRecruiter
		throw new UnsupportedOperationException();
	}

	/**
	 * Cancel as candidate; record audit and publish events.
	 * @param candidate
	 * @param reservationId
	 */
	void cancelAsCandidate(Candidate candidate, String reservationId) {
		// TODO - implement CareerFairSystem.cancelAsCandidate
		throw new UnsupportedOperationException();
	}

	/**
	 * Join logic: lobby vs room; ensure MeetingSession exists; record attendance.
	 * @param candidate
	 * @param reservationId
	 */
	void joinSession(Candidate candidate, String reservationId) {
		// TODO - implement CareerFairSystem.joinSession
		throw new UnsupportedOperationException();
	}

	/**
	 * Advance time-based behaviour: phase transitions and session start/end.
	 */
	void tick() {
		// TODO - implement CareerFairSystem.tick
		throw new UnsupportedOperationException();
	}

	/**
	 * Query for UI to display system status.
	 */
	FairPhase getCurrentPhase() {
		// TODO - implement CareerFairSystem.getCurrentPhase
		throw new UnsupportedOperationException();
	}

}