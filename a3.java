
package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame3 extends Frame implements Runnable
{
    int x=100;
    Thread t;
    volatile boolean flag;
    MyFrame3()
    {
 
        setTitle("Question3");
        setSize(800,600);
        setBackground(Color.blue);
        setLocationRelativeTo(null);
        this.addWindowListener(new MyWinddowListener());
        addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(flag==true)
                {
      
                     flag=false;
                  
                }
                else
                {
                    flag=true;
                    startThread();
                }
             
            }
   
        });
        setVisible(true);
    }
    void startThread()
    {
        t=new Thread(this);

        t.start();
    }
    public void run()
    {
        while(flag)
        {
            x++;
            if(x==getWidth())
            {
                x=-200;
            }
            repaint();
             try
            {

                Thread.sleep(20);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }

        }
    }
    public void paint(Graphics g)     
    {
        g.setColor(Color.orange);
       g.fillOval(x,100,200,200);
        
    }
}
public class a3
{
    public static void main(String[] args)
    {
        new MyFrame3();
    }
}