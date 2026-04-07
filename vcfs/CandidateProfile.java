package vcfs;

/**
 * Candidate profile data used for auto-booking (string data is sufficient, file uploading of CVs is not required).
 */
public class CandidateProfile {

	String cvSummary;
	String[] interestTags;
        
        public CandidateProfile(String summary, String[] tags){
            cvSummary = summary;
            interestTags = tags;
        }

	/**
	 * Update the candidate's profile fields.
	 * @param cvSummary
	 * @param interestTags
	 */
	void updateProfile(String cvSummary, String interestTags) {
		// TODO - implement CandidateProfile.updateProfile
		throw new UnsupportedOperationException();
	}

}