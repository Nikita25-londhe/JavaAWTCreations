package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame7 extends Frame implements Runnable
{
    int x=10;
    Thread t;
    Label lbl;
    volatile boolean flag=true;
     Button btn1,btn2;
    MyFrame7()
    {
        setSize(800,600);
        setTitle("String Translation");
        setBackground(Color.yellow);
        setLayout(null);
        addWindowListener(new MyWinddowListener());
        addComponents();
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
            if(x==800)
            {
                x=-170;
            }
                
            lbl.setBounds(x,50,300,40);
            try
            {
                Thread.sleep(30);
            }
            catch(InterruptedException e)
            {
                System.out.println(e);
            }
        }
    }
    private void addComponents()
    {
        lbl=new Label("I am here By Choice");
        lbl.setBounds(x,50,300,40);
        lbl.setFont(new Font("arial",Font.BOLD,25));
        add(lbl);
        btn1=new Button("Start");
        btn2=new Button("Stop");
        btn1.setBounds(40,530,200,40);
        btn2.setBounds(430,530,200,40);
        btn1.setBackground(Color.green);
        btn2.setBackground(Color.red);
        btn1.setFont(new Font("arial",Font.BOLD,24));
        btn2.setFont(new Font("arial",Font.BOLD,24));
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(btn1);
        add(btn2);
        btn1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                if(flag==false)
                {
                    flag=true;
                }
                startThread();
            }
        });
        btn2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                    flag=false;
            }
        });
    }
   
}
public class a7
{
    public static void main(String[] args)
    {
        new MyFrame7();
    }
    
}
