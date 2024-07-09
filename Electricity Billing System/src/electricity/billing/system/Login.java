package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton loginbutton, cancelbutton, signup;
    JTextField usernameEntry, passwordEntry;
    Choice logininn;
    Login() {
        super("Login Page");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel username = new JLabel("Username");
        username.setBounds(250, 20, 100 , 20);
        add(username);
        
        JLabel password = new JLabel("Password");
        password.setBounds(250, 60, 100, 20);
        add(password);
        
        JLabel loginas = new JLabel("Login as");
        loginas.setBounds(250, 100, 100, 20);
        add(loginas);
                
        usernameEntry = new JTextField();
        usernameEntry.setBounds(350, 20, 120, 20);
        add(usernameEntry);
        
        passwordEntry = new JTextField();
        passwordEntry.setBounds(350, 60, 120, 20);
        add(passwordEntry);
        
//        JTextField loginasEntry = new JTextField();
//        loginasEntry.setBounds(350, 100, 120, 20);
//        add(loginasEntry);
        
        logininn = new Choice();
        logininn.add("Admin");
        logininn.add("Client");
        logininn.setBounds(350, 100, 120, 20);
        add(logininn);
        
        ImageIcon loginicon = new ImageIcon(ClassLoader.getSystemResource("Icons/login.png"));
        Image loginiconscale = loginicon.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT );
        loginbutton = new JButton("Login",new ImageIcon(loginiconscale));
        loginbutton.setBounds(250, 140, 90, 20);
        loginbutton.addActionListener(this);
        add(loginbutton);
        
        
        ImageIcon cancelicon = new ImageIcon(ClassLoader.getSystemResource("Icons/cancel.jpg"));
        Image canceliconscale = cancelicon.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT );
        cancelbutton = new JButton("Cancel", new ImageIcon(canceliconscale));
        cancelbutton.setBounds(350, 140, 100, 20);
        cancelbutton.addActionListener(this);
        add(cancelbutton);
        
        ImageIcon signupicon = new ImageIcon(ClassLoader.getSystemResource("Icons/signup.png"));
        Image signupiconscale = signupicon.getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT);
        signup = new JButton("signup", new ImageIcon(signupiconscale));
        signup.setBounds(250, 170, 200, 20);
        signup.addActionListener(this);
        add(signup);
        
        ImageIcon persona = new ImageIcon(ClassLoader.getSystemResource("Icons/second.jpg"));
        Image personascale = persona.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon wraap = new ImageIcon(personascale);
        JLabel person = new JLabel(wraap);
        person.setBounds(0,0,250,250);
        add(person);
        
        setSize(500,400);
        setLocation(400,200);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == loginbutton) {
            String userex = usernameEntry.getText();
            String passex = passwordEntry.getText();
            String actype = logininn.getSelectedItem();
            
            try {
                conn c = new conn();
                
                String query = "Select * from login where username = '"+userex+"' and password = '"+passex+"' and user = '"+actype+"'";
                
                 ResultSet rs = c.s.executeQuery(query);
                 
                 if (rs.next()) { 
                     setVisible(false);
                     new project();
                     
                 } else {
                     usernameEntry.setText("");
                     passwordEntry.setText("");
                     JOptionPane.showMessageDialog(null, "Invalid Credential");
                 }
                
                
            } catch(Exception e) {
                e.printStackTrace();
            }
            
        }
        else if (ae.getSource() == cancelbutton) {
            setVisible(false);
        }
        else if (ae.getSource() == signup) {
            setVisible(false);
            
            new signup();
        }   
    }
    
    public static void main(String[] args) {
        new Login();
    }
}
