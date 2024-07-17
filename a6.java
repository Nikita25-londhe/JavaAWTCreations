/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment12;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.event.*;
class MyFrame6 extends Frame implements Runnable
{
    Thread t;
    double x;
    double y;
    MyFrame6()
    {
       t=new Thread(this);
        setLayout(null);
        setTitle("Clock");
        setSize(800,600);
        setBackground(Color.red);
        setLocationRelativeTo(null);
        this.addWindowListener(new MyWinddowListener());
        setVisible(true);
        startThread();
    }
    void startThread()
    {
        t.start();
    }
   
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(7f));
        g2.setColor(Color.blue);
        g2.drawOval(200,100,400,400);
        g2.fillOval(380,280,40,40);
        g2.draw(new Line2D.Double(400, 300, x, y));
        //System.out.println(x+" "+y);
    }
    public void run()
    {
        int theta =90;

        while(true)
        {
             double a=Math.toRadians(theta);
            x=(200*Math.cos(a))+400;
            y=300-(200*Math.sin(a));
            System.out.println(x+" "+y);
            repaint();
          
            try
            {
                Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
            theta-=6;
        }
    }
}
public class a6
{
    public static void main(String[] args)
    {
        new MyFrame6();
  
    }
}
