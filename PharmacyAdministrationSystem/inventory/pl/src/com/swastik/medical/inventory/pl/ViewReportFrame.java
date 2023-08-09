import java.awt.*;

import javax.swing.*;

class ViewReportFrame extends JFrame

{

private ViewReportPanel viewReportPanel;

private Container container;

ViewReportFrame()

{

initComponents();

setAppearance();

}

private void initComponents()

{

container=getContentPane();

container.setLayout(null);

viewReportPanel=new ViewReportPanel();

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

viewReportPanel.setBounds(1,1,dimension.width,dimension.height);


container.add(viewReportPanel);

setSize(dimension.width,dimension.height);
setLocation(0,0);
setDefaultCloseOperation(DISPOSE_ON_CLOSE);

setVisible(true);

}

private void setAppearance()

{

setTitle("Pharmacy Administration System");

viewReportPanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
}

public static void main(String gg[])

{
ViewReportFrame viewReportFrame=new ViewReportFrame();

viewReportFrame.setResizable(false);
}
}
