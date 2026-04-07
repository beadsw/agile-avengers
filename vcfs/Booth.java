package vcfs;

import java.util.*;

/**
 * A company's presence at the fair; owns recruiters and a single VirtualRoom.
 */
public class Booth {

	ArrayList<Recruiter> recruiters;
	VirtualRoom room;
	Organization organization;
	String title;
        
        public Booth(){ //Empty constructor
            
        }

        public Booth(String boothTitle, Recruiter recruiter){
            title = boothTitle;
            room = new VirtualRoom();
            recruiters.add(recruiter);
        }
        
	/**
	 * Assign a recruiter to this booth.
	 * @param recruiter
	 */
	public void assignRecruiter(Recruiter recruiter) {
            if(recruiter == null){
                throw new UnsupportedOperationException("Recruiter cannot be null");
            }
            
            if(recruiters == null){
                recruiters = new ArrayList<>();
            }
            recruiters.add(recruiter);
            recruiter.booth = this;
	}

	/**
	 * Unassign a recruiter from this booth.
	 * @param recruiter
	 */
	public void removeRecruiter(Recruiter recruiter) {
            if(recruiter == null){
                throw new UnsupportedOperationException("Recruiter cannot be null");
            }
            if(recruiters != null){
                recruiters.remove(recruiter);
            }
            if(recruiter.booth == this){
                recruiter.booth = null;
            }
	}

	/**
	 * Return the booth's virtual room.
	 */
	VirtualRoom getRoom() {
		return this.room;
	}

}