import java.awt.*;

import javax.swing.*;
class MedicineFrame extends JFrame

{

private MedicinePanel medicinePanel;

private Container container;
private UserFrame uf;
MedicineFrame()

{
initComponents();

setAppearance();

}
private void initComponents()

{

container=getContentPane();

container.setLayout(null);

medicinePanel=new MedicinePanel(this);

Dimension dimension=Toolkit.getDefaultToolkit().getScreenSize();

medicinePanel.setBounds(1,1,dimension.width,dimension.height);


container.add(medicinePanel);

setSize(dimension.width,dimension.height);
setLocation(0,0);
setDefaultCloseOperation(EXIT_ON_CLOSE);

setVisible(true);

}

private void setAppearance()

{

setTitle("Pharmacy Administration System");

medicinePanel.setBorder(BorderFactory.createLineBorder(new Color(255,255,255)));
}

public static void main(String gg[])

{
MedicineFrame medicineFrame=new MedicineFrame();
medicineFrame.setResizable(false);
}
}


