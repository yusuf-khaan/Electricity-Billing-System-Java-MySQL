package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class meterInfo extends JFrame implements ActionListener{
    
    JLabel meterLoc, meterType, phaseCode,billType, days, daystxt, note, notetxt, meternumb;
    Choice meterTypetxt, meterLoctxt, phaseCodetxt, billTypetxt;
    JButton next, cancel;
    String meternumber;
    
    meterInfo (String meternumber) {
        super("Meter Info");
        this.meternumber = meternumber;
        
        setBounds(350,150,900,600);
        setBackground(Color.WHITE);
        setLayout(null);
        
        JPanel panel =  new JPanel(null);
        panel.setBounds(300,0, 650, 602);
        panel.setBackground(new Color(135,206,235));
        add(panel);
        
        JLabel meter = new JLabel("Meter Number");
        meter.setBounds(50, 50, 100,20);
        meter.setFont(new Font("calibri", Font.BOLD, 14));
        panel.add(meter);
        
        meternumb = new JLabel(meternumber);
        meternumb.setBounds(250,50,300,20);
        panel.add(meternumb);
        
        
//        String name = "Zaki";
//        
//        try {
//            conn c = new conn();
//            
//            String query = "select * from customer where name = '"+name+"'";
//            
////            c.s.executeQuery(query);
//            
//            ResultSet ans = c.s.executeQuery(query);
//            
//            if(ans.next()) {
//                String val = ans.getString("meter_number");
//                meternumb.setText(val);
//                panel.add(meternumb);
//            } else {
//                JOptionPane.showMessageDialog(null, "Meter not found");
//            }
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
        
        meterLoc = new JLabel("Meter Location");
        meterLoc.setBounds(50,100, 100, 20);
        meterLoc.setFont(new Font("calibri", Font.BOLD, 14));
        panel.add(meterLoc);
        
        meterLoctxt = new Choice();
        meterLoctxt.add("Indra Nagar");
        meterLoctxt.add("Vijay Khand");
        meterLoctxt.setBounds(250,100,200,20);
        panel.add(meterLoctxt);
        
        meterType = new JLabel("Meter Type");
        meterType.setBounds(50,150,100,20);
        meterType.setFont(new Font("calibri",Font.BOLD,14));
        panel.add(meterType);
        
        meterTypetxt = new Choice();
        meterTypetxt.add("Prepaid");
        meterTypetxt.add("Postpaid");
        meterTypetxt.setBounds(250, 150, 100, 20);
        panel.add(meterTypetxt);
        
        phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50, 200, 100, 20);
        phaseCode.setFont(new Font("calibri",Font.BOLD,14));
        panel.add(phaseCode);
        
        phaseCodetxt = new Choice();
        phaseCodetxt.add("226020");
        phaseCodetxt.add("226010");
        phaseCodetxt.setBounds(250, 200, 100, 20);
        panel.add(phaseCodetxt);
        
        billType = new JLabel("Bill Type");
        billType.setBounds(50,250,100,20);
        billType.setFont(new Font("calibri",Font.BOLD,14));
        panel.add(billType);
        
        billTypetxt = new Choice();
        billTypetxt.add("Normal");
        billTypetxt.add("AbNormal");
        billTypetxt.setBounds(250,250,100,20);
        panel.add(billTypetxt);
        
        days = new JLabel("Days");
        days.setBounds(50,300,100,20);
        days.setFont(new Font("calibri",Font.BOLD,14));
        panel.add(days);
        
        daystxt = new JLabel("");
        daystxt.setBounds(250,300,100,20);
        panel.add(daystxt);
        
        note = new JLabel("NOTE: ");
        note.setBounds(50,350,100,20);
        panel.add(note);
        
        notetxt = new JLabel("BY Default Bill is Calculated Every 30 Days");
        notetxt.setBounds(250,350, 400,20);
        panel.add(notetxt);
        
        next = new JButton("Next");
        next.setBounds(50, 400, 100, 20);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        panel.add(next);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(250,400,100,20);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        panel.add(cancel);
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == next){
            
            String meternumberEx = meternumber;
            String meterTypeEx = meterTypetxt.getSelectedItem();
            String meterLocEx = meterLoctxt.getSelectedItem();
            String phaseCodeEx = phaseCodetxt.getSelectedItem();
            String billTypeEx = billType.getText();
            String dayss =  "30";
            
            String query = "Insert into meterinfo values ('"+meternumberEx+"','"+meterTypeEx+"','"+meterLocEx+"','"+phaseCodeEx+"','"+billTypeEx+"')";
            
            try {
                conn c = new conn();
                
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Successfully Updated");
                
            } 
            catch(Exception e) {
                e.printStackTrace();
            }
        
        }
    }
    
    
    
    
    public static void main(String [] args) {
        new meterInfo("");
    }
}
