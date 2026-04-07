package vcfs;

import java.util.*;

/**
 * A bookable appointment offering published by a recruiter. Availability is intentionally not modelled here; groups design availability representation.
 */
public class Offer {

	Recruiter publisher;
	Collection<Reservation> reservations;
	String title;
	int durationMins;
	String[] topicTags;
	int capacity;

        public Offer(String title, int durationMins, String[] topicTags, int capacity, Recruiter recruiter){
            this.title = title;
            this.durationMins = durationMins;
            this.topicTags = topicTags;
            this.capacity = capacity;
            publisher = recruiter;
        }
        
	/**
	 * Update offer metadata (topic/tags, duration, capacity).
	 * @param title
	 * @param durationMins
	 * @param topicTags
	 * @param capacity
	 */
	public void updateDetails(String title, int durationMins, String topicTags, int capacity) {
		// TODO - implement Offer.updateDetails
		throw new UnsupportedOperationException();
	}

	/**
	 * Return offer duration (minutes).
	 */
	public int getDurationMins() {
		return this.durationMins;
	}
        
        public ArrayList<String> getTopicTags(){
            ArrayList<String> tags = new ArrayList<String>();
            for(int i = 0; i < topicTags.length; i++){
                tags.add(topicTags[i]);
            }
            return tags;
        }

}