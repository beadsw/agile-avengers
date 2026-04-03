package vcfs;
import java.time.LocalDateTime;
import static vcfs.FairPhase.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ellen
 */
public class AdminController {
    private CareerFairSystem system;
    private AdminScreen adminScreen;
    FairPhase State;
    
    public AdminController(CareerFairSystem system) {
        this.system = system;
    }
    	/**
	 * Admin: validate and set the fair timeline.
	 * @param openTime
	 * @param closeTime
	 * @param startTime
	 * @param endTime
	 */
    public void configureTimes(LocalDateTime openTime, LocalDateTime closeTime, LocalDateTime startTime, LocalDateTime endTime)
    {
       //validate and set the fair routine, using state changes?
       LocalDateTime time;
       time = system.getCurrentTime();
       
       if (time == openTime)
       {
           State = BOOKINGS_OPEN;
       }
       if (time == closeTime)
       {
           State = BOOKINGS_CLOSED;
       }
       if (time == startTime)
       {
           State = FAIR_LIVE;
       }
       if (time == endTime)
       {
           State = DORMANT;
       }
            
    }
    
    public void resetFairData()
    {
        //implement method, resetting to default the fair data
        //removes old reservation records, meeting session records and notifications
        //change states?
        attendanceRecords.clear();
        sessionRecords.clear(); //assuming these would be stored as arrayLists of objects, Ill fix this when the arrayLists are implemented :)
        notifications.clear();
        
        if (State != DORMANT){//set the state to closed
           State = DORMANT;
        }
        
    }
    
    public Organization addOrganization(String title)
    {
        Organization Org;
        Org = new Organization();
        Org.name = title;
        
        return Org;
    }
    
}
