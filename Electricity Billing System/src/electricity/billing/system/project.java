package electricity.billing.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Set;

public class project extends JFrame implements ActionListener{
    
JMenuBar mb;
JMenu master;
JMenuItem customer;
    project() {
        
//        setSize(600,600);

//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(350,150,900,600);
        
        ImageIcon bgimage = new ImageIcon(ClassLoader.getSystemResource("Icons/elect1.jpg"));
        Image bgscale = bgimage.getImage().getScaledInstance(1920, 1080, Image.SCALE_DEFAULT);
        ImageIcon img0 = new ImageIcon(bgscale);
        JLabel img1 = new JLabel(img0);
        
        add(img1);
        
        
        mb = new JMenuBar();
        setJMenuBar(mb);
        
        master = new JMenu("Master");
        mb.add(master);
        
        customer = new JMenuItem("New Customer");
        customer.setFont(new Font("calibri", Font.BOLD, 12));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon1.png"));
        Image custscale = icon1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon custimage = new ImageIcon(custscale);
//        JLabel custmenu = new JLabel(custimage);
        customer.setIcon(custimage);
        customer.addActionListener(this);
        customer.setMnemonic('C');
        customer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        master.add(customer);
        
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon2.png"));
        Image img2 = icon2.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        customerdetails.setFont(new Font("calibri", Font.BOLD, 12));
        ImageIcon icon02 = new ImageIcon(img2);
        customerdetails.setIcon(icon02);
        customerdetails.setMnemonic('D');
        customerdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        master.add(customerdetails);
        
        JMenuItem depositdetails = new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("calibri", Font.BOLD, 12));
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon3.png"));
        Image i3 = icon3.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(i3));
        depositdetails.setMnemonic('T');
        depositdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
        master.add(depositdetails);
        
        JMenuItem calculatebill = new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon4.png"));
        Image i4 = icon4.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(i4));
        calculatebill.setMnemonic('B');
        calculatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        master.add(calculatebill);
        
        JMenu Information = new JMenu("Information");
        Information.setForeground(Color.RED);
        Information.setFont(new Font("",Font.BOLD,12));
        mb.add(Information);
        
        JMenuItem viewinformation = new JMenuItem("View Information");
        viewinformation.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon5.png"));
        Image i5 = icon5.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        viewinformation.setIcon(new ImageIcon(i5));
        viewinformation.setMnemonic('V');
        viewinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK));
        Information.add(viewinformation);
        
        JMenuItem updateinformation = new JMenuItem("Update Information");
        updateinformation.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon6 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon6.png"));
        Image i6 = icon6.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        updateinformation.setIcon(new ImageIcon(i6));
        updateinformation.setMnemonic('U');
        updateinformation.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,ActionEvent.CTRL_MASK));
        Information.add(updateinformation);
        
        JMenu user = new JMenu("Menu");
        user.setFont(new Font("",Font.BOLD,12));
        mb.add(user);
        
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon7.png"));
        Image i7 = icon7.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(i7));
        paybill.setMnemonic('P');
        paybill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
        user.add(paybill);
        
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon8 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon8.png"));
        Image i8 = icon8.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(i8));
        billdetails.setMnemonic('B');
        billdetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B,ActionEvent.CTRL_MASK));
        user.add(billdetails);
        
        JMenu report = new JMenu("Report");
        report.setForeground(Color.RED);
        mb.add(report);
        
        JMenuItem generatebill = new JMenuItem("Generate Bill");
        generatebill.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon9 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon12.png"));
        Image i9 = icon9.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        generatebill.setIcon(new ImageIcon(i9));
        generatebill.setMnemonic('G');
        generatebill.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G,ActionEvent.CTRL_MASK));      
        report.add(generatebill);
        
        JMenu utility = new JMenu("Utility");
        utility.setBackground(Color.red);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon10 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon10.png"));
        Image i10 = icon10.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(i10));
        notepad.setMnemonic('N');
        notepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK));      
        utility.add(notepad);
        
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("calibri",Font.BOLD,12));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon9.png"));
        Image i11 = icon11.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(i11));
        calculator.setMnemonic('C');
        calculator.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));      
        utility.add(calculator);
        
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.RED);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ImageIcon icon12 = new ImageIcon(ClassLoader.getSystemResource("Icons/icon11.png"));
        Image i12 = icon12.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(i12));
        ex.setMnemonic('E');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,ActionEvent.CTRL_MASK));
        exit.add(ex);
        
        
        

        
        setLayout(new FlowLayout());
        
        setVisible(true);
        repaint();
        revalidate();
        
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == customer) {
            new signup();
        }
    }
public static void main(String[] args) {
            new project();
}
}