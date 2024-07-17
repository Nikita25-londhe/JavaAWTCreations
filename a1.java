
package assignment12 ;
import java.awt.*;
import java.awt.event.*;
class MyFrame extends Frame
{
    int count=0;
    
    MyFrame()
    {
        setTitle("Question1");
        setSize(800,600);
        setBackground(Color.yellow);
        setLocationRelativeTo(null);
        this.addWindowListener(new MyWinddowListener());
        addMouseListener(new MouseAdapter()
        {
            public void mouseClicked(MouseEvent e)
            {
                count++;
      
                repaint();
            }
        });
        setVisible(true);
    }
    public void paint(Graphics g)
    {
        int x=100;
        g.drawString("Just Started",20,50);
        for(int i=0;i<=count;i++)
        {
            g.drawString("Anonymous Inner class",x,50);   
            x+=150;
        }

    }
}
public class a1
{
    public static void main(String[] args)
    {
        new MyFrame();
    }
}
