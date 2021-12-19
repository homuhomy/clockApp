import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class myFrame extends JFrame {

    Calendar calendar;
    SimpleDateFormat timeFormat;
    SimpleDateFormat dayFormat;
    SimpleDateFormat dateFormat;
    JLabel timeLabel;
    JLabel dayLabel;
    JLabel dateLabel;
    String time;
    String day;
    String date;

    myFrame(){

        //'this' keyword refers to the current object in a method or constructor.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("* My Clock Program *");
        this.setLayout(new FlowLayout());
        this.setSize(350,200);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(255,252,220));

        //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html#text

        //set Time
        timeFormat = new SimpleDateFormat("hh:mm:ss a");
        //set Day
        dayFormat = new SimpleDateFormat("EEEE");
        //set date
        dateFormat = new SimpleDateFormat("MMMMM || dd/MM/yy");

        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Verdana", Font.ITALIC,50)); //change font (plain is font style)
        timeLabel.setForeground(new Color(105,152,171)); //change text color
        //timeLabel.setBackground(new Color(81,107,235));
        //setOpaque(true)

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Verdana", Font.PLAIN,25)); //change font (plain is font style)
        dayLabel.setForeground(new Color(105,152,171)); //change text color

        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Verdana", Font.ITALIC,25));
        dateLabel.setForeground(Color.BLACK);

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);


        setTime(); //to make the clock update time every second

    }

    public void setTime(){
        while(true){
            time = timeFormat.format(Calendar.getInstance().getTime()); //get current date and time
            timeLabel.setText(time);

            day = dayFormat.format(Calendar.getInstance().getTime()); //get current date and time
            dayLabel.setText(day);

            date = dateFormat.format(Calendar.getInstance().getTime()); //get current date and time
            dateLabel.setText(date);

            //only update every second
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
