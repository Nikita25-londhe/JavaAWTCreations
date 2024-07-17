
package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame2 extends Frame implements Runnable
{
    int x=50;
    Thread t;
    volatile private  int time=25;
    MyFrame2()
    {
 
        setTitle("Question2");
        setSize(800,600);
        setBackground(Color.yellow);
        setLocationRelativeTo(null);
        this.addWindowListener(new MyWinddowListener());
        addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                time-=4;
                startThread();
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
        while(true)
        {
              x++;
              if(x==getWidth())
              {
                  x=-10;
                  time=40   ;
                  startThread();
   
      
              }
               repaint();
                  try
            {
               
                Thread.sleep(time);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }

        }
    }
    public void paint(Graphics g)     
    {
        g.setFont(new Font("arial",Font.BOLD,20));
        g.drawString("Hello",x,100);
    }
}
public class a2
{
    public static void main(String[] args)
    {
        new MyFrame2();
    }
}
