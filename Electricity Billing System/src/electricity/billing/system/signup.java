package electricity.billing.system;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class signup extends JFrame implements ActionListener{
    
    JButton back, create;
    Choice accountype;
    JTextField meterfield, usernamefield, namefield, passwordfield;
    
    signup() {
    
    super("Sign up");
    setBounds(450, 150, 700, 400);
    setVisible(true);
    
    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JPanel panel = new JPanel();
    panel.setBounds(19,30, 650, 300);
    panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230) ,2), "Create Account", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(172, 216,230)));
    panel.setBackground(Color.WHITE);
    panel.setLayout(null);
    panel.setForeground(Color.WHITE);
    add(panel);
    
    JLabel heading = new JLabel("Create Account");
    heading.setBounds(50,50, 100, 20);
    heading.setForeground(Color.GRAY);
    heading.setFont(new Font("Calibri", Font.BOLD, 14));
    panel.add(heading);
    
    accountype = new Choice();
    accountype.setForeground(Color.BLACK);
    accountype.add("Admin");
    accountype.add("Customer");
    accountype.setBounds(250,50, 140, 20);
    panel.add(accountype);
    
    
    
    JLabel meterbill = new JLabel("Meter Number");
    meterbill.setFont(new Font("Calibri", Font.BOLD, 14));
    meterbill.setBounds(50,80, 100, 20);
    meterbill.setForeground(Color.GRAY);
    panel.add(meterbill);
    
    meterfield = new JTextField();
    meterfield.setBounds(250, 80, 140, 20);
    panel.add(meterfield);
    
    JLabel username = new JLabel("Username");
    username.setForeground(Color.GRAY);
    username.setFont(new Font("Calibri", Font.BOLD, 14));
    username.setBounds(50, 110, 100, 20);
    panel.add(username);
    
    usernamefield = new JTextField();
    usernamefield.setBounds(250, 110, 140, 20);
    panel.add(usernamefield);
    
    JLabel name = new JLabel("Name");
    name.setForeground(Color.GRAY);
    name.setFont(new Font("Calibri", Font.BOLD, 14));
    name.setBounds(50, 140, 100, 20);
    panel.add(name);
    
    namefield = new JTextField();
    namefield.setBounds(250, 140, 140, 20);
    panel.add(namefield);
    
    JLabel password = new JLabel("Password");
    password.setForeground(Color.GRAY);
    password.setFont(new Font("Calibri", Font.BOLD, 14));
    password.setBounds(50, 170, 100, 20);
    panel.add(password);
    
    passwordfield = new JTextField();
    passwordfield.setBounds(250, 170, 140, 20);
    panel.add(passwordfield);
    
    create = new JButton("Create Account");
    create.setForeground(Color.WHITE);
    create.setFont(new Font("Calibri", Font.BOLD, 14));
    create.setBackground(Color.BLACK);
    create.setBounds(50, 210, 140, 20);
    create.addActionListener(this);
    panel.add(create);
    
    back = new JButton("Back");
    back.setBounds(250, 210, 140, 20);
    back.setBackground(Color.BLACK);
    back.setForeground(Color.WHITE);
    back.setFont(new Font("Calibri", Font.BOLD, 14));
    back.addActionListener(this);
    panel.add(back);
    
    ImageIcon signupimg = new ImageIcon(ClassLoader.getSystemResource("Icons/signupImage.png"));
    Image signupimgscale = signupimg.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
    ImageIcon s1 = new ImageIcon(signupimgscale);
    JLabel imgg = new JLabel(s1);
    imgg.setBounds(420, 30, 250, 250);
    
    panel.add(imgg);
    
    
    
    panel.revalidate();
    panel.repaint();
    setVisible(true);
}
public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == back) {
        setVisible(false);
        new Login();
    }
    else if (ae.getSource() == create) {
        String usernamef = usernamefield.getText();
        String namef = namefield.getText();
        String passwordf = passwordfield.getText();
        String actype = accountype.getSelectedItem();
        String meterf = meterfield.getText();
        
        try {
            conn c = new conn();
           
            String query = "Insert into login values ('"+meterf+"','"+usernamef+"','"+namef+"','"+passwordf+"','"+actype+"')";
            
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Account Created Succesfully");
            
            setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
    public static void main(String[] args) {
        new signup();
        
    }
}
