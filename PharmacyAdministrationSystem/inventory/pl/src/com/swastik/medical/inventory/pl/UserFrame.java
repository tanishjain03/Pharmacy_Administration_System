import java.awt.*;

import javax.swing.*;

class UserFrame extends JFrame

{

private UserPanel userPanel;

private Container container;

UserFrame()

{

initComponents();

setAppearance();

}

private void initComponents()

{

container=getContentPane();

container.setLayout(null);

userPanel=new UserPanel(this);

userPanel.setBounds(1,1,682,608);


container.add(userPanel);

setSize(700,650);

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

setLocation((dimension.width/2-getWidth()/2)-50,dimension.height/2-getHeight()/2);

setDefaultCloseOperation(EXIT_ON_CLOSE);

setVisible(true);

}
private void setAppearance()

{

setTitle("Pharmacy Administration System");

userPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));

}
public static void main(String gg[])

{
UserFrame userFrame=new UserFrame();

userFrame.setResizable(false);
}

}