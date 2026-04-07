package vcfs;

import java.util.*;

/**
 * Recruiter assigned to a Booth; publishes Offers and hosts sessions.
 */
public class Recruiter extends User {

	ArrayList<Offer> offers;
	Booth booth;

        public Recruiter(String displayName, String emailAddress, String boothName){
            super(displayName, emailAddress);
            booth = new Booth(boothName, this);
            //Should instead be assigned to existing booth object, rather than create a new one
        }
        
	/**
	 * Create a new offer owned by this recruiter (system registers it).
	 * @param title
	 * @param durationMins
	 * @param topicTags
	 * @param capacity
	 */
	public void publishOffer(String title, int durationMins, String[] topicTags, int capacity) {
            Offer offer = new Offer(title, durationMins, topicTags, capacity, this);
            offers.add(offer);
	}

	/**
	 * Request cancellation of a reservation as a recruiter (policy enforced by system).
	 * @param reservationId
	 * @param reason
	 */
	public void cancelReservation(String reservationID, String reason) {
            for(int i = 0; i < offers.size(); i++){
                if(offers.get(i).title == reservationID){
                    offers.remove(i);
                    return; //Don't keep looping if correct offer found
                }
            }
	}

	/**
	 * Return a human-readable view of the recruiter's schedule.
	 */
	public void viewSchedule() {
            //If implemented, would print to a text box in the display the start
            //And end time of each offer's meeting session, as well as their
            //Current number of awaiting candidates who have signed up
	}

}