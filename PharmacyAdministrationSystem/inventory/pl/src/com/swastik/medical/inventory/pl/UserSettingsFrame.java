import java.awt.*;

import javax.swing.*;

class UserSettingsFrame extends JFrame

{
private UserSettingsPanel userSettingsPanel;

private Container container;

UserSettingsFrame()

{

initComponents();

setAppearance();

}

private void initComponents()

{
container=getContentPane();

container.setLayout(null);

userSettingsPanel=new UserSettingsPanel();
userSettingsPanel.setBounds(1,1,682,608);

container.add(userSettingsPanel);

setSize(700,650);

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

setLocation((dimension.width/2-getWidth()/2)-50,dimension.height/2-getHeight()/2);

setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setVisible(true);

}
private void setAppearance()

{

setTitle("Pharmacy Administration System");

userSettingsPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));

}
public static void main(String gg[])

{
UserSettingsFrame userSettingsFrame=new UserSettingsFrame();

userSettingsFrame.setResizable(false);
}
}