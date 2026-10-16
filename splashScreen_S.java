package ICS_ISP;

import hsa.Console;

import java.awt.*;

public class splashScreen_S extends Thread{
    Console c;
    public splashScreen_S (Console con)
    {
        c = con;
    }

    public void animation(){
        c.setFont(new Font("Arial", Font.BOLD, 30));
        for (int i = 0; i < 320; i += 4) {
            c.setColor(Color.gray);
            c.fillOval(i-45, 140, 100, 100);
            c.setColor(Color.black);
            c.drawString("S", 0 + i, 200);

            try {
                Thread.sleep(70);
            } catch (InterruptedException e) {

            }
            c.setColor(Color.black);
            c.drawString("S", 0 + i, 200);
            c.fillOval(i-45, 140, 100, 100);
        }
    }

    public void run(){
        animation();
    }
}
