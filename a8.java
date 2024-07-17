package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame8 extends Frame implements Runnable
{
    int speed=1030;
    Thread t;
    volatile boolean flag;
    int hits=0;
    Label lbl;
    Button btn1,btn2;
    long start;
    MyFrame8()
    {
        setLayout(null);
        setTitle("Game");
        setSize(800,600);
        setBackground(new Color(100,100,100));
        setLocationRelativeTo(null);
        addComponents();
        this.addWindowListener(new MyWinddowListener());
        setVisible(true);
    }
    void startThread()
    {
        t=new Thread(this);
        t.start();
        start=System.currentTimeMillis();
    }
    synchronized public void run()
    {
        flag=true;
        int a,b;
        while(flag)
        {
            if(hits>=5)
            {
                long end =System.currentTimeMillis();
                int total=(int)((end-start)/1000);
                lbl.setText(total+" sec");
                try
                {
                    Thread.sleep(3000);
                }
                catch(InterruptedException e)
                {
                    System.out.println(e);
                }
                speed-=80;
                hits=0;
                lbl.setText("Hit me");
                startThread();
            }
            a=((int)(Math.random()*1000))%680;
            b=((int)(Math.random()*1000))%490;
            while(b<=35)
            {
                 b=((int)(Math.random()*1000))%500;
            }
            System.out.println(a+" "+b);
            lbl.setBounds(a,b,120,40);
            try
            {
                Thread.sleep(speed);
            }
            catch(InterruptedException e)
            {
                System.out.println("Caught" +e);
            }
        }
}
    private void addComponents()
    {
        lbl=new Label("Hit me!");
        lbl.setBounds(300,200,120,40);
        add(lbl);
        lbl.setBackground(Color.yellow);
        lbl.setFont(new Font("arial",Font.BOLD,25));
        lbl.setAlignment(lbl.CENTER);
        btn1=new Button("Start");
        btn2=new Button("Stop");
        btn1.setFont(new Font("arial",Font.BOLD,20));
        btn2.setFont(new Font("arial",Font.BOLD,20));
        add(btn1);
        add(btn2);
        btn1.setBounds(110,540,200,50);
        btn2.setBounds(390,540,200,50);
        btn1.setBackground(Color.green);
        btn2.setBackground(Color.red);
        btn1.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                startThread();
            }   
        });
        btn2.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                flag=false;
                lbl.setText("Hit me");
                lbl.setBounds(300,200,120,40);
      
            }
        });
        lbl.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                hits++;
                lbl.setText(hits+"!");
            }
        });
    }
}
public class a8
{
    public static void main(String[] args)
    {
        new MyFrame8();
    }
}
