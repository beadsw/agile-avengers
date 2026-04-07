package vcfs;

import java.util.*;

/**
 * Candidate who registers, creates Requests, books Reservations and joins sessions.
 */
public class Candidate extends User {

	CandidateProfile profile;
	Collection<Request> requests;
	Collection<Reservation> reservations;
        Candidate candidate;
        String cvSummary;
        String interestTags;

        
    //constructor
    public Candidate(String displayName, String emailAddress, String cvSummary, String[] interestTags) {
        super(displayName, emailAddress);
        profile = new CandidateProfile(cvSummary, interestTags);
        
        requests = new ArrayList<>();
        reservations = new ArrayList<>();
    }
	/**
	 * Create booking request/preferences.
	 * @param desiredTags
	 * @param preferredOrgs
	 * @param maxAppointments
	 */
	Request createRequest(String desiredTags, String preferredOrgs, int maxAppointments) {
		if (desiredTags == null || preferredOrgs == null || maxAppointments < 0) {
                         throw new UnsupportedOperationException("Invalid Request");
	}

                
                Request request = new Request();
                request.requester = this;
                request.updatePreferences(desiredTags, preferredOrgs, maxAppointments);
                
                requests.add(request);
                return request;
                
        }
        
        
	/**
	 * 
	 * @param reservationId
	 */
	void cancelMyReservation(String reservationId) {
            if (reservationId == null) {
                    throw new UnsupportedOperationException("Invalid ID");
	}

            for (Reservation r : reservations)  {
                if (r.offer != null && r.offer.title.equals(reservationId)) {
                    r.cancel("Cancelled by candidate");
                    return;
                }
            }
            
            throw new UnsupportedOperationException("Reservation not found");

        }
        
	String viewMySchedule() {
            String result;
            result = "";
            
            for (Reservation r : reservations) {
                result += "Offer: " + r.offer.title + " | Start: " + r.scheduledStart + "\n";
            }
            
            return result;
        }
        
        void updateCVSummary(String cvSummary){
            if(cvSummary == null){
                throw new UnsupportedOperationException("Invalid CV");
            }
            
             this.cvSummary = cvSummary;
            }
        
        
        void addInterestTags(String interestTags){
            if(interestTags == null){
                throw new UnsupportedOperationException("Invalid tags");
            }
            
            if(this.interestTags != null){
                this.interestTags = interestTags;
                }
                else{
                    this.interestTags += "," + interestTags;
                }
            }
        
        
        void removeInterestTags(String interestTagToRemove){
            if(interestTagToRemove == null || this.interestTags == null){
                throw new UnsupportedOperationException("Invalid tag");

            }
            this.interestTags = this.interestTags.replace(interestTagToRemove, "");
        }
}

                