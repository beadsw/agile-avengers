package vcfs;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ben
 */
public class Main {
   public static void main(String[] args){
       CareerFairSystem system = new CareerFairSystem();
       //SystemTimer systemTimer = new SystemTimer(system);
       //new SystemTimerScreen(systemTimer);
       
       AdminController adminController = new AdminController(system);
       RecruiterController recruiterController = new RecruiterController(system);
       CandidateController candidateController = new CandidateController(system);
       SystemTimer systemTimer = new SystemTimer(system);
       
       AdminScreen adminScreen = new AdminScreen(adminController);
       RecruiterScreen recruiterScreen = new RecruiterScreen(recruiterController);
       CandidateScreen candidateScreen = new CandidateScreen(candidateController);
       SystemTimerScreen systemTimerScreen = new SystemTimerScreen(systemTimer);
   }
}
