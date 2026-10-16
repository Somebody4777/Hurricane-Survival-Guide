package ICS_ISP;

import hsa.Console;

import java.awt.*;

public class splashScreen_P extends Thread{
    Console c;
    public splashScreen_P (Console con)
    {
        c = con;
    }

    public void animation(){
        c.setFont(new Font("Arial", Font.BOLD, 30));
        for (int i = 0; i < 320; i += 4) {
            c.setColor(Color.gray);
            c.fillOval(595-i, 240, 100, 100);
            c.setColor(Color.black);
            c.drawString("P", 640 - i, 300);

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {

            }
            c.setColor(Color.black);
            c.drawString("P", 640 - i, 300);
            c.fillOval(595-i, 240, 100, 100);
        }
    }

    public void run(){
        animation();
    }
}
