package vcfs;

import java.util.ArrayList;
import java.time.LocalDateTime;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ben
 */
public class CandidateController {
    private CareerFairSystem system;
    
    Candidate candidate;
    String cvSummary;
    String interestTags;
    
    LocalDateTime now = LocalDateTime.now();
    
    public CandidateController(CareerFairSystem system) {
        this.system = system;
    }
    
    Candidate registerCandidate(String displayName, String email, String cvSummary, String interestTags){
        if(displayName == null || email == null){
            throw new UnsupportedOperationException("Invalid candidate details");
        }
        Candidate candidate = new Candidate();
        candidate.displayName = displayName;
        candidate.email = email;
        candidate.cvSummary = cvSummary;
        candidate.interestTags = interestTags;
        
        return candidate;
        
    }
    
    Request createRequest(Candidate candidate, String desiredTags, String preferredOrgs, int maxAppointments){
        
        if(candidate == null){
            throw new UnsupportedOperationException("Candidate is null");
        }
        return candidate.createRequest(desiredTags, preferredOrgs, maxAppointments);
        
    }
    
    void cancelAsCandidate(Candidate candidate, String reservationId){
        if(candidate == null){
            throw new UnsupportedOperationException("Candidate is null");
        }
        candidate.cancelMyReservation(reservationId);
    }
    
    void joinSession(Candidate candidate, String reservationId){
        if(candidate == null || reservationId == null){
            throw new UnsupportedOperationException("Invalid request to join");
        }
        
        for(Reservation r : candidate.reservations){
            if(r.offer != null && r.offer.title.equals(reservationId)){
                if(r.session != null){
                    throw new UnsupportedOperationException("No session scheduled for this reservation");
                }
                
                if(r.session.attendanceRecords == null){
                    r.session.attendanceRecords = new ArrayList<>();
                   
            }
                AttendanceRecord record = new AttendanceRecord();
                record.session = r.session;
                if(r.session.attendanceRecords == null){
                    r.session.attendanceRecords = new ArrayList<>();
                }
                
                r.session.attendanceRecords.add(record);
                return;
        }
      
    }
        throw new UnsupportedOperationException("Session not found");

    }

    /**
     * Update the candidate's profile fields.
     * @param cvSummary
     * @param interestTags
     */
    void updateProfile(String cvSummary, String interestTags) {
	if(cvSummary == null || interestTags == null){
            throw new UnsupportedOperationException("Invalid profile data");
            
        }
        this.cvSummary = cvSummary;
        this.interestTags = interestTags;
    }
}
