package vcfs;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SystemTimerScreen extends JFrame implements ActionListener {

    //private CareerFairSystem system;
    private SystemTimer systemTimer;
   
    JButton minsBtn, setTimeBtn, currentTimeBtn;
    JTextField minsField, setTimeField, TimeField;
    
    public SystemTimerScreen(SystemTimer systemTimer) {
      //constructor  
        this.systemTimer = systemTimer;
        
        setTitle("System Timer Screen");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //TOP
        JPanel window = new JPanel();
        
        minsField = new JTextField("No data", 15);
        
        setTimeField = new JTextField("yyyy,mm,dd,hh",13);
        
        TimeField = new JTextField("no data", 20);
        
        currentTimeBtn = new JButton("Current Time");
        currentTimeBtn.addActionListener(this);
        
        minsBtn = new JButton("Add minutes");
        minsBtn.addActionListener(this);
        
        setTimeBtn = new JButton("Skip to time");
        setTimeBtn.addActionListener(this);
        
        window.add(setTimeField);
        window.add(minsField);
        window.add(minsBtn);
        window.add(setTimeBtn);
        window.add(currentTimeBtn);
        window.add(TimeField);
        
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)     {
        
        if (e.getSource() == minsBtn)  {
            //SystemTimer.stepMinutes(mins);
        }
        if (e.getSource() == setTimeBtn){
            //SystemTimer.setTime(LocalDateTime);
        }
    }
    
    public static void main(String[] args) {
        CareerFairSystem system = new CareerFairSystem();
        SystemTimer controller = new SystemTimer(system);
        new SystemTimerScreen(controller);
    }
}

