import java.awt.*;

import javax.swing.*;

class SellFrame extends JFrame

{
private SellPanel sellPanel;

private Container container;

SellFrame()

{

initComponents();

setAppearance();

}
private void initComponents()

{
container=getContentPane();

container.setLayout(null);

sellPanel=new SellPanel();
sellPanel.setBounds(1,1,682,608);

container.add(sellPanel);

setSize(700,650);

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

setLocation((dimension.width/2-getWidth()/2)-50,dimension.height/2-getHeight()/2);

setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setVisible(true);

}
private void setAppearance()

{

setTitle("Pharmacy Administration System");

sellPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));

}
public static void main(String gg[])

{
SellFrame sellFrame=new SellFrame();

sellFrame.setResizable(false);
}
}