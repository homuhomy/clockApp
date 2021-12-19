import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class myFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    JLabel timeLabel;
    String time;

    myFrame(){

        //'this' keyword refers to the current object in a method or constructor.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("* My Clock Program *");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255,252,220));

        //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text
        timeFormat = new SimpleDateFormat("hh:mm:ss a");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.PLAIN,50)); //change font (plain is font style)
        timeLabel.setForeground(new Color(105,152,171)); //change text color
        //timeLabel.setBackground(new Color(81,107,235));
        //setOpaque(true)

        time = timeFormat.format(Calendar.getInstance().getTime()); //get current date and time
        timeLabel.setText(time);

        this.add(timeLabel);
        this.setVisible(true);

        setTime(); //to make the clock update time every second

    }

    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime()); //get current date and time
            timeLabel.setText(time);

            //only update every second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
