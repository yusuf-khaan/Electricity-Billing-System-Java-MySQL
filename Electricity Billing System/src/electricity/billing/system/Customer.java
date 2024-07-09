package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.util.*;

public class Customer extends JFrame implements ActionListener {

    JButton next,cancel;
    JTextField emailfield, addressfield, phonenumberfield, customerfield, statefield, cityfield;
    JLabel meternumass;
    Customer() {
        
        super("New Customer");
        setLayout(null);
        setBounds(320,150,900,600);
        getContentPane().setBackground(new Color(135,206,235));
//        setBackground(Color.WHITE);
        
        JPanel panel = new JPanel(); // Set the layout of the panel to null
        panel.setLayout(null);
        panel.setBounds(300,30, 650, 510);
        panel.setBackground(Color.WHITE);
        panel.setBorder(new TitledBorder(new LineBorder(new Color(173,216,230) ,2), "New Customer", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
        add(panel);
        
        ImageIcon hicon = new ImageIcon(ClassLoader.getSystemResource("Icons/hicon1.jpg"));
        Image i1 = hicon.getImage().getScaledInstance(290, 530, Image.SCALE_DEFAULT);
        JLabel i11 = new JLabel(new ImageIcon(i1));
        i11.setBounds(0,0,300,570);
        add(i11);
            
        JLabel newcustomer = new JLabel("New Customer");
        newcustomer.setBounds(400,10, 100,20);
        newcustomer.setFont(new Font("calibri",Font.CENTER_BASELINE,16));
        add(newcustomer);
        
        JLabel customername = new JLabel("Name");
        customername.setFont(new Font("Arial", Font.BOLD, 12));
        customername.setBounds(50,50,40,20); // Adjust the bounds to position the label within the panel
        panel.add(customername);
        
        customerfield = new JTextField();
        customerfield.setBounds(200,50,150,20);
        panel.add(customerfield);
        
        JLabel meternumb = new JLabel("Meter Number");
        meternumb.setBounds(50,100,150,20);
        panel.add(meternumb);
        
        meternumass = new JLabel("");
        meternumass.setBounds(200,100,150,20);
        panel.add(meternumass);
        
        Random generate = new Random(); // instance of random class
        Long num = generate.nextLong() % 1000000;// nextLong , nextInt , nextFloat generate random number
        num =  Math.abs(num);
        meternumass.setText(num.toString());

        JLabel address = new JLabel("Address");
        address.setFont(new Font("Ariel",Font.BOLD,12));
        address.setBounds(50,150,50,20);
        panel.add(address);
        
        addressfield = new JTextField();
        addressfield.setBounds(200,150,150,20);
        panel.add(addressfield);
        
        JLabel city = new JLabel("City");
        city.setBounds(50,200,150,20);
        panel.add(city);
        
        cityfield = new JTextField();
        cityfield.setBounds(200,200,150,20);
        panel.add(cityfield);
        
        JLabel state = new JLabel("State");
        state.setBounds(50,250,150,20);
        panel.add(state);
        
        statefield = new JTextField();
        statefield.setBounds(200,250,150,20);
        panel.add(statefield);
        
        JLabel email = new JLabel("EMAIL");
        email.setBounds(50,300,50,20);
        panel.add(email);
        
        emailfield = new JTextField();
        emailfield.setBounds(200,300,150,20);
        panel.add(emailfield);
        
        JLabel phonenumber = new JLabel("Phone Number");
        phonenumber.setBounds(50,350,150,20);
        panel.add(phonenumber);
        
        phonenumberfield = new JTextField();
        phonenumberfield.setBounds(200, 350, 150, 20);
        panel.add(phonenumberfield);
        
        next = new JButton("Next");
        next.setForeground(Color.white);
        next.setBounds(50,400,100,20);
        next.setBackground(Color.BLACK);
        next.addActionListener(this);
        panel.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(200,400,150,20);
        cancel.setBackground(Color.BLACK);
        panel.add(cancel);
        
        setVisible(true); // No need to call repaint() and revalidate() here
    }
    
    public void actionPerformed (ActionEvent ae) {
        if(ae.getSource() == next) {
            String nameEx = customerfield.getText();
            String emailex = emailfield.getText();
            String phonenumberex = phonenumberfield.getText();
            String cityex = cityfield.getText();
            String stateEx = statefield.getText();
            String meternumex = meternumass.getText();
            
            

               
               
                       
            
            
            
            
            
            
            
            
            
            
            try {
                conn c = new conn();
                
                String query1 = "Insert into customer values ('"+nameEx+"','"+emailex+"','"+phonenumberex+"','"+cityex+"','"+stateEx+"','"+meternumex+"')";
                String query2  = "Insert into login values('"+meternumex+"','','"+nameEx+"','','')";
                
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Customer Detail Loaded Successfully");
                new meterInfo(meternumex);
//                setVisible(false);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
  

    public static void main(String[] args) {
        new Customer();
    }
}