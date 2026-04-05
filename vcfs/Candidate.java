package vcfs;

import java.util.*;

/**
 * Candidate who registers, creates Requests, books Reservations and joins sessions.
 */
public class Candidate extends User {

	CandidateProfile profile;
	Collection<Request> requests;
	Collection<Reservation> reservations;

        
//constructor
public Candidate() {
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
        
}
                