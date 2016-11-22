import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by ScorpionOrange on 2016/08/09.
 * update again in 2016.11.23.
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args){
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        //keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program ?");
        System.exit(0);
    }
}

/**
 * A clock that prints the time in regular intervals.
 */
class TalkingClock{
    public void start(int interval, final boolean beep){
        ActionListener listener = event -> {
            Date now = new Date();
            System.out.println("At the moment, the time is " + now);
            if(beep){
                Toolkit.getDefaultToolkit().beep();
            }
        };
            /*
            * ActionListener listener = new ActionListener(){
            *     public void actionPerformed(ActionEvent event) {
            *         Date now = new Date();
            *         System.out.println("At the moment, the time is " + now);
            *         if(beep){
            *             Toolkit.getDefaultToolkit().beep();
            *         }
            *     }
            * };
            */


        Timer t = new Timer(interval, listener);
        t.start();
    }
}
