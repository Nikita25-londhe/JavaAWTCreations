/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame5 extends Frame implements Runnable
{
    Thread t;
    volatile boolean flag=true;
    int hits=0;
    int x=50;
    int y=50;
    MyFrame5()
    {
         t=new Thread(this);
        setLayout(null);
        setTitle("Hit and Miss");
        setSize(800,600);
        setBackground(Color.yellow);
        setLocationRelativeTo(null);
        this.addWindowListener(new MyWinddowListener());
        setVisible(true);
    }
    public void paint(Graphics g)
    {
      
        g.setColor(Color.blue);
        g.fillOval(x,y,70,70);
    }
    void startThread() throws InterruptedException
    {
        t.start();
        hits=0;
        Thread.sleep(10000);
        flag=false;
        System.out.println("Total hits="+hits);
     
    }
    public void run()
    {
       while(flag)
       {
           x=((int)((Math.random())*1000))%680;
           y=((int)((Math.random())*1000))%490;
           while(y<=35)
           {
               y=((int)((Math.random())*1000))%560;
           }
           repaint();
           try
           {
               Thread.sleep(1000);
           }
           catch(InterruptedException e)
           {
               System.out.println(e);
           }
       }
            
    }       
}
public class a5
{
    public static void main(String[] args)throws InterruptedException 
    {
        MyFrame5 mf=new MyFrame5();
        mf.startThread();
        
    }
}
