import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDate;
import java.time.LocalTime;

public class Clock {
    public static void main(String[] args) throws InterruptedException{
        JFrame frame = new JFrame("Clock");
        frame.setBounds(10, 10, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(false); //Change this to true if you want no borders on your clock
        JPanel panel = new JPanel() {
            @Override
            public void paint(Graphics g2) {
                Graphics2D graphics = (Graphics2D)g2.create();
                graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                graphics.setColor(new Color(127, 185, 166));
                graphics.fillRect(0, 0, 500, 500);
                graphics.setColor(Color.white);
                String time = String.format("%02d", LocalTime.now().getHour())+":"+String.format("%02d", LocalTime.now().getMinute())+":"+String.format("%02d", LocalTime.now().getSecond());
                graphics.setFont(new Font("Aharoni", 0, 110));
                graphics.drawString(time, 250-graphics.getFontMetrics().stringWidth(time)/2, 160);
                String date = LocalDate.now().getMonth().toString()+" "+String.format("%02d", LocalDate.now().getDayOfMonth())+" "+String.format("%02d", LocalDate.now().getYear());
                graphics.setFont(new Font("Aharoni", 0, 20));
                graphics.drawString(date, 250-graphics.getFontMetrics().stringWidth(date)/2, 200);
            };
        };
        frame.add(panel);
        frame.setVisible(true);
        while(true){
            frame.repaint();
            Thread.sleep(1000);
        }
    }
}