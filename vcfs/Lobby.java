package vcfs;

import java.util.*;

/**
 * Per-session waiting area for candidates who attempt to join early.
 */
public class Lobby {

	MeetingSession session;

        private Collection<Candidate> waitingCandidates = new ArrayList<>();
	/**
	 * Add an early-arriving candidate to the lobby.
	 * @param candidate
	 */
	void add(Candidate candidate) {
            if (candidate == null) {
		throw new UnsupportedOperationException("Candidate cannot be null");
	}

	waitingCandidates.add(candidate);
        
        }
        /**
	 * Remove a candidate from the lobby
	 * @param candidate
	 */
	void remove(Candidate candidate) {
            if (candidate == null) {
                            throw new UnsupportedOperationException("Candidate cannot be null");

        }
            waitingCandidates.remove(candidate);

	}


     /**
      * Return list of waiting candidates (as String)
      */
	String listWaiting() {
            String result = "";
            
            for (Candidate c : waitingCandidates) {
                result += c.displayName + "/n";
        }
            
            return result; 
        }
    }
	