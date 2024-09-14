
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Calendar;
import java.lang.*;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 * A class that validates user input, used as part of an input form
 */
public class ValidateForm
       {
    public ValidateForm() {
        //no variables to initialize
    }
    public boolean isAllAlpha(String str)
    {
    if(str == null)
    {
        return false;
       }
 
        for (int i = 0; i < str.length(); i++)
        {
            if (Character.isLetter(str.charAt(i))== true) {
                      
                    return true;
                
                
                  }
            
        }
        return false;
        }
    
        public boolean isNumeric(String str)
    {
    try {
          Double.parseDouble(str);
          return true;
          }
        catch (NumberFormatException ex){
            return false;
          }    
        }
       

    /** validate the user's entered name */
    public String checkName(String name) {
        //TODO
        if(name.length()>=2)
        { 
            return " ";
          }
          else
          {
              return "Invalid Name!\n";
          }
          

        
    }

    /** validate the user's entered email */
    public String checkEmail(String email) {
        //TODO
        if(email.indexOf("@") >= 1) {
            return " ";
          }
        if(email.indexOf("@") == -1)
        { 
            return "Invalid Email!\n";
          }
        if(email.indexOf(".") > email.indexOf("@")){
            return " ";
          }
        if(email.indexOf(".") < email.indexOf("@")){
            return "Invalid Email!\n";
          }
          
        return "";
    }

    /** validate the user's enter password */
    public String checkPW(String pw) {
        //TODO
        boolean Num = false;
        boolean Cap = false;
        boolean Low = false;
        boolean length = false;
               if(pw.length() >=4)
               {
                length = true;
                  }
         
                 for (int i = 0; i < pw.length(); i++) {
                  if (Character.isDigit(pw.charAt(i))== true) {
                      
                    Num = true;
                
                
                  }
                  else if(Character.isUpperCase(i))
                   {
                Cap = true;
                 }
            
                 else if(Character.isLowerCase(i))
                {  Low = true;
                 }
                 
                 
                if(Num || Cap || Low || length == true){
                return " ";
            }
            
                
        
        
        
        
        }
             return "Invalid Password!\n";
        }
          
          
        
    

    /** validate the user's entered zipcode */
    public String checkZip(String zip) {
        //TODO 
        
          
        
                
        for (int i = 0; i < zip.length(); i++){
            
            if(zip.length()>=3 && zip.length()<=5){
        
           if(zip.charAt(i) >='0' && zip.charAt(i) <= '9' ){
                return " ";
              }
                
        }
          }
        return "Invalid Zipcode!\n";
    }

    /** validate the user's entered birth year */
    public String checkBirth(String date) {
        //TODO\
        
        int Lim1 = 1920;
        int Lim2 = 2021;
        Calendar C = Calendar.getInstance();
        int year = 0;
        C.getInstance().get(C.YEAR);
        
        
        try {
            year = Integer.parseInt(date);
          }
        catch (NumberFormatException ex){
          }
          
          if(Lim1 <= year && year <= Lim2)
        {
            return "";
          }
         else
         {
             return "Invalid Date!\n";
          }
        
    }

    /** validate the user's entered phone number */
    public String checkPhone(String phone) {
        //TODO
          boolean length = false;
          boolean number = false;
          phone = phone.replace("-","");
       
        if(phone.length() ==10 )
        {
            length = true;
        }
        
        for(int i = 0; i < phone.length(); i++){
            if(Character.isDigit(phone.charAt(i))){
                number = true;
            }
        }
        
        if( number &&  length == true){
            return " ";
        }
        else{
            return "Invalid Phone Number!\n";
        }
        
        
        
     
          
}

    /** main method for testing / setting up the GUI */
    public static void main(String[] args)
    {
        /*
         * you can add other method calls here for testing
         */

        //set up the GUI, you don't need to understand this code
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                //the frame is the GUI, it uses a ValidateForm object
                TextComponentFrame frame = new TextComponentFrame(new ValidateForm());
                frame.setVisible(true);
            }
        });
    }
}










/**
 * A frame (GUI) with simple text components to simulate a web form
 */
class TextComponentFrame extends JFrame 
{
    static final int DEFAULT_WIDTH  = 300;
    static final int DEFAULT_HEIGHT = 400;

    ValidateForm validater;

    public TextComponentFrame(ValidateForm v)
    {
        validater = v;

        initGUI();
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null); //center on screen
    }
    

    /** initialize the GUI components, e.g. buttons and text fields */
    private void initGUI()
    {
        setTitle("Subscription Form");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        final JTextField personName = new JTextField();
        final JTextField emailField = new JTextField();
        final JTextField zipCode    = new JTextField();
        final JTextField birthDate  = new JTextField();

        MaskFormatter mfor = null;
        try {
            mfor = new MaskFormatter("###-###-####"); //for the phone number field
        }
        catch (ParseException e) {}

        final JFormattedTextField phoneNumber   = new JFormattedTextField(mfor);
        final JPasswordField      passwordField = new JPasswordField();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(6, 6)); //dimensions of layout
        northPanel.add(new JLabel("Name :  ", SwingConstants.RIGHT));
        northPanel.add(personName);
        northPanel.add(new JLabel("Password :  ", SwingConstants.RIGHT));
        northPanel.add(passwordField);
        northPanel.add(new JLabel("Email : ", SwingConstants.RIGHT));
        northPanel.add(emailField);
        northPanel.add(new JLabel("Zip Code (US) : ", SwingConstants.RIGHT));
        northPanel.add(zipCode);
        northPanel.add(new JLabel("Year of Birth: ", SwingConstants.RIGHT));
        northPanel.add(birthDate);
        northPanel.add(new JLabel("Phone Number: ", SwingConstants.RIGHT));
        northPanel.add(phoneNumber);

        add(northPanel, BorderLayout.NORTH);

        final JTextArea textArea = new JTextArea(8, 40);
        JScrollPane scrollPane   = new JScrollPane(textArea);

        add(scrollPane, BorderLayout.CENTER);

        // add button to listen for events, append text into the text area

        JPanel  southPanel   = new JPanel();
        JButton submitButton = new JButton("Submit");
        southPanel.add(submitButton);
        submitButton.addActionListener(new ActionListener() //make anonymous action listener
        {
            /** this method is called in response to an event, in this case the "Submit" button pressed */
            public void actionPerformed(ActionEvent event)
            {
                String name     = personName.getText() ;
                String email    = emailField.getText();
                String zip      = zipCode.getText();
                String birth    = birthDate.getText();
                String phone    = phoneNumber.getText(); 
                String password = new String(passwordField.getPassword());

                String result = ""; 

                result += validater.checkName(name);
                result += validater.checkPW(password);
                result += validater.checkEmail(email);
                result += validater.checkZip(zip);
                result += validater.checkBirth(birth);
                result += validater.checkPhone(phone);
                
                

                if(result.length() ==0)
                        result = "Input accepted!";
                    

                textArea.setText(result);
            }
        });

        add(southPanel, BorderLayout.SOUTH);
    }
}