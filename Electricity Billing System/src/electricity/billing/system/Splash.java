package electricity.billing.system;
import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable
{
    
    Splash() {
        ImageIcon indiamap = new ImageIcon(ClassLoader.getSystemResource("Icons/elect.jpg"));
        Image scale = indiamap.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon india = new ImageIcon(scale);
        JLabel bgimage = new JLabel(india);
        
        add(bgimage);
        setVisible(true);
        int x = 1;
        for(int i=1;i<600;i+=4,x+=1) {
            setSize(i + x, i);
            setLocation(700 - ((i+x)/2), 400 - (i/2));
            try {
                Thread.sleep(1);                
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
        Thread t = new Thread(this);
        t.start();
        setVisible(true);
    }
    public void run() {
        try { 
            Thread.sleep(7000);
            setVisible(false);
            //open login frame after 7 seconds
            new Login();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
        
    }
}