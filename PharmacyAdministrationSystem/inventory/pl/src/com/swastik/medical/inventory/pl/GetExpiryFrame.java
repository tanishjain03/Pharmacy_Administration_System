import java.awt.*;

import javax.swing.*;

class GetExpiryFrame extends JFrame

{

private GetExpiryPanel getExpiryPanel;

private Container container;

GetExpiryFrame()

{

initComponents();

setAppearance();

}

private void initComponents()

{

container=getContentPane();

container.setLayout(null);

getExpiryPanel=new GetExpiryPanel();

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

getExpiryPanel.setBounds(1,1,dimension.width,dimension.height);


container.add(getExpiryPanel);

setSize(dimension.width,dimension.height);
setLocation(0,0);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setVisible(true);

}

private void setAppearance()

{

setTitle("Pharmacy Administration System");

getExpiryPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
}

public static void main(String gg[])

{
GetExpiryFrame getExpiryFrame=new GetExpiryFrame();

getExpiryFrame.setResizable(false);

}
}
