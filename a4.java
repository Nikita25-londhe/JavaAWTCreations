
package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame4 extends Frame implements Runnable
{
    int x=10;
    volatile int temp=0;
    Thread t;
    volatile boolean flag=true;
    MyFrame4()
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
       while(flag==true)
       {
           if(temp==0)
           {
               x++;
                if(x==600)
                {
                    
                    temp=1;
                    flag=false;
                }
           }
           else
           {
               System.out.println("Circle should move to left");
               x--;
               if(x==0)
               {
                   temp=0;
                   flag=false;
               }
           }
       
           repaint();
           try
           {
               Thread.sleep(5);
           }
           catch(InterruptedException e )
           {
               System.out.println(e);
     
           }
       }
       while(flag==false)
       {
           if(temp==0)
           {
               x++;
               if(x==600)
               {
                   
                   x=0;
                   temp=0;
                   flag=true;
                   startThread();
             
               }
           }
           else
           {
               x--;
                if(x==0)
                {
                    temp=1;
                    x=590;
                    flag=true;
                    startThread();
               
                }
           }
           
           repaint();
           try
           {
               Thread.sleep(5);
           }
           catch(InterruptedException e )
           {
               System.out.println(e);
           }
       }

    }
    public void paint(Graphics g)     
    {
        if(flag==true)
        {
            if(temp==1)
            {
                g.setColor(Color.red);
                g.fillOval(x,100,200,200);
                g.fillOval(10,390,200,200);
            }
            else
            {
                 g.setColor(Color.red);
                g.fillOval(x,100,200,200);
                g.fillOval(590,390,200,200);
            }
           
        }
        if(flag==false)
        {
            if(temp==0)
            {
                g.setColor(Color.red);
                g.fillOval(0,100,200,200);
                g.fillOval(x,390,200,200);
            }
            else
            {
                 g.setColor(Color.red);
                g.fillOval(600,100,200,200);
                g.fillOval(x,390,200,200);
            }
           
        }
        
    }
}
public class a4
{
    public static void main(String[] args)
    {
        new MyFrame4();
    }
}