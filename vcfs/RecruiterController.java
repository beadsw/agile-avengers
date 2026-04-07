package vcfs;

/**
 *
 * @author elm00516
 */
public class RecruiterController {
    private CareerFairSystem system;
    
    public RecruiterController(CareerFairSystem system) {
        this.system = system;
    }
    
    public Recruiter registerRecruiter(String displayName, String emailAddress, String boothName){
        Recruiter recruiter = new Recruiter(displayName, emailAddress, boothName);
        return recruiter;
    }
    
    public void publishOffer(Recruiter recruiter, String offerTitle, int sessionDuration, String[] topicTags, int sessionCapacity){
        recruiter.publishOffer(offerTitle, sessionDuration, topicTags, sessionCapacity);
    }
    
    public void cancelAsRecruiter(Recruiter recruiter, String reservationName, String cancellationReason){
        recruiter.cancelReservation(reservationName, cancellationReason);
    }
    
}
