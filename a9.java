/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment12;
import java.awt.*;
import java.awt.event.*;
class MyFrame9 extends Frame implements Runnable
{
    Thread t;
    volatile boolean flag=true;
    int hits=0;
    Label lbl;
    int count=0;
    Button btn1,btn2;
    MyFrame9()
    {
        setLayout(null);
        setTitle("Game2");
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
        count=0;
        hits=0;
     
    }
    public void run()
    {
       while(flag)
       {
           int a=((int)((Math.random())*1000))%680;
           int b=((int)((Math.random())*1000))%490;
           while(b<=35)
           {
               b=((int)((Math.random())*1000))%560;
           }
           count++;
           lbl.setBounds(a,b,120,40);
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
        
        //Registration
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
                String score="Total Score= "+ hits+"/"+count;
                Label res=new Label(score);
                res.setFont(new Font("arial",Font.BOLD,30));
                res.setForeground(Color.cyan);
                res.setBounds(200,500,400,40);
                add(res);
            }
        });
        lbl.addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                hits++;
            }
        });
            }
}
public class a9
{
    public static void main(String[] args)
    {
        new MyFrame9();
    }
}
