package vcfs;

/**
 * Candidate booking preferences used for manual browsing and auto-booking.
 */
public class Request {

	Candidate requester;
	String desiredTags;
	String preferredOrgs;
	int maxAppointments;

	/**
	 * 
	 * @param desiredTags
	 * @param preferredOrgs
	 * @param maxAppointments
	 */
	void updatePreferences(String desiredTags, String preferredOrgs, int maxAppointments) {
		// TODO - implement Request.updatePreferences
		throw new UnsupportedOperationException();
	}

}