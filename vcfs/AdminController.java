package vcfs;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ben
 */
public class AdminController {
    private CareerFairSystem system;
    private AdminScreen adminScreen;
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
        //implement configureTimes method - not sure what it actually does yet //i have no fucking clue what to do with this
        //validate and set the fair routine
        //change states?
    }
    
    public void resetFairData()
    {
        //implement method, resetting to default the fair data
        //removes old reservation records, meeting session records and notifications
        //change states?
        
        
        
    }
    
    public Organization addOrganization(String title)
    {
        Organization Org;
        Org = new Organization();
        Org.name = title;
        
        return Org;
    }
    
    public Booth addBooth(String title)
    {
        Booth booth;
        booth = new Booth();
        booth.title = title;
        
        return booth;
    }
}
