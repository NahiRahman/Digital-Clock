import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Clock extends JFrame {
    //timeFormat is a SimpleDateFormat object that formats the time in the format of hh:mm:ss a
        SimpleDateFormat timeFormat; 
        SimpleDateFormat dayFormat; 
        SimpleDateFormat dateFormat; 
        JLabel timeLabel;
        JLabel dayLabel; 
        JLabel dateLabel; 
        String time; 
        String day;
        String date;

    Clock() { // Constructor
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Digital Clock");
        this.setSize(350,220);
        this.setLayout(new FlowLayout());//Setting the layout to be FlowLayout
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        //this.getContentPane().setBackground(Color.gray);

        timeFormat = new SimpleDateFormat("hh:mm:ss a");//Setting the time format
        dayFormat = new SimpleDateFormat("EEEE");//Setting the day format
        dateFormat = new SimpleDateFormat("MMMMM dd, yyyy");//Setting the date format

        timeLabel = new JLabel(); 
        timeLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
        timeLabel.setForeground(new Color(0x00FF00));
        timeLabel.setBackground(Color.black);
        timeLabel.setOpaque(true);

        dayLabel = new JLabel();
        dayLabel.setFont(new Font("Serif", Font.BOLD, 35));
        
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Serif", Font.BOLD, 35));

        this.add(timeLabel);
        this.add(dayLabel);
        this.add(dateLabel);
        this.setVisible(true);

        setTime();
        }   
        public void setTime() {
            while(true) {//Creating an infinite loop
            time = timeFormat.format(Calendar.getInstance().getTime());//Getting the current time
            timeLabel.setText(time);//Setting the time to the label

            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);

                try {
                    Thread.sleep(1000);//Pausing the thread for 1 second
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    public static void main(String[] args) {
    new Clock(); //Creating an instance of the clock class
    }
}