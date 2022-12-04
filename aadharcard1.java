import java.util.regex.Pattern;
import java.util.regex.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class aadharcard1{
    public static void main(String args[]){
        new aadharcard1();
    }
    private JFrame frame;
    private JTextField numberField;
    private JLabel validLabel;
    private JButton verifyButton;
    public aadharcard1(){
        frame =new  JFrame("Aadharcard Number Verifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(350,400));
        numberField=new JTextField(12);
        validLabel = new JLabel("not yet verified");
        verifyButton= new JButton("Verify Aadharcard Number");
        verifyButton.addActionListener(new VerifyListener());
       frame.getContentPane().setBackground(new java.awt.Color(51,153,255));
        frame.setLayout(new FlowLayout());
        frame.add(numberField);
        frame.add(verifyButton);
        frame.add(validLabel);
        frame.setVisible(true);
    }
       public static boolean  IsValidAadharcardNumber(String number) {
      String regex="^[2-9]{1}[0-9]{3}\\s[0-9]{4}\\s[0-9]{4}$";
      Pattern p=Pattern.compile(regex);
      if(number == null){
        return false;
      }
      Matcher m = p.matcher(number);
      return m.matches();
}
    
    public class VerifyListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String number = numberField.getText();
            if ( IsValidAadharcardNumber(number)) {
                validLabel.setText("Valid number!");
            } else {
                validLabel.setText("Invalid number.");
            }
        }
        }
    }
