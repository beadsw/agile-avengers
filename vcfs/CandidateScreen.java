package vcfs;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CandidateScreen extends JFrame implements ActionListener {

    //private CareerFairSystem system;
    
   JTextField nameField, emailField;
   JButton registerBtn, bookBtn;
   
   DefaultListModel<String> offersModel = new DefaultListModel<>();
   JList<String> offersList = new JList<>(offersModel);
   
   JTextArea output;
    
    
    private CandidateController candidateController;
    
    public CandidateScreen(CandidateController candidateController) {
        this.candidateController = candidateController;
        
        setTitle("Candidate Screen");
        setSize(500, 400);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //TOP
        JPanel top = new JPanel();
        nameField = new JTextField(10);
        emailField = new JTextField(10);
        
        registerBtn = new JButton("Register");
        registerBtn.addActionListener(this);
        
        top.add(new JLabel("Name:"));
        top.add(nameField);
        top.add(new JLabel("Email:"));
        top.add(emailField);
        top.add(registerBtn);
        
        add(top, BorderLayout.NORTH);
        
        //CENTER
        add(new JScrollPane(offersList), BorderLayout.CENTER);
        
        //BOTTOM
        JPanel bottom = new JPanel();
        
        bookBtn = new JButton("Book");
        bookBtn.addActionListener(this);
        
        output = new JTextArea(5, 20);
        
        bottom.add(bookBtn);
        bottom.add(new JScrollPane(output));
        
        add(bottom, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)     {
        
        if (e.getSource() == registerBtn)  {
            //candidateController.registerCandidate(
            //        nameField.getText(),
            //        emailField.getText());
            
            output.append("Register\n");
        }
        
        if (e.getSource() == bookBtn)    {
            String offer = offersList.getSelectedValue();
            
            //candidateController.bookAppointment(offer);
            
            output.append("Booked: " + offer + "\n");
        }
    }
    
    public static void main(String[] args) {
        CareerFairSystem system = new CareerFairSystem();
        CandidateController controller = new CandidateController(system);
        new CandidateScreen(controller);
    }
}3