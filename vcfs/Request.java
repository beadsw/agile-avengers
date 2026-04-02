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
            if (desiredTags == null || preferredOrgs == null || maxAppointments < 0)  {
                throw new UnsupportedOperationException("Invalid preferences");
            }
                
            this.desiredTags = desiredTags;
            this.preferredOrgs = preferredOrgs;
            this.maxAppointments = maxAppointments;
        }
}