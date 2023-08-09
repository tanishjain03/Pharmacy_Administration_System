import com.swastik.medical.inventory.bl.*;
import com.swastik.medical.inventory.bl.pojo.*;
import com.swastik.medical.inventory.bl.Interfaces.*;
import com.swastik.medical.inventory.bl.Exceptions.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.*;
import java.io.*;
import java.util.*;
public class SellPanel extends JPanel implements ActionListener
{
private JLabel logo,name,address;
private JLabel mainLabel;
private JLabel patientNameLabel,medicineNameLabel,amountLabel;
private JLabel s1,s2,s3,s4,s5,s11,s22,s33,s44,s55;
private JTextField patientNameField;
private JTextField medicineNameField1,medicineNameField2,medicineNameField3,medicineNameField4,medicineNameField5;
private JTextField amountField1,amountField2,amountField3,amountField4,amountField5;
private JButton sellButton;
private SellModel sellModel;
private MedicineModel medicineModel;
SellPanel()
{
sellModel=new SellModel();
initComponents();
setAppearance();
addListeners();
}
private void initComponents()
{
ImageIcon imageIcon = new ImageIcon("logo.jpg");
logo=new JLabel(imageIcon);
name=new JLabel("SWASTIK  MEDICAL  STORE");
address=new JLabel("244,DAULATGANJ,UJJAIN[M.P.]");
mainLabel=new JLabel("SELL WINDOW");
patientNameLabel=new JLabel("Patient Name");
medicineNameLabel=new JLabel("Medicine Name");
amountLabel=new JLabel("Quantity");
patientNameField=new JTextField(30);
medicineNameField1=new JTextField(20);
medicineNameField2=new JTextField(20);
medicineNameField3=new JTextField(20);
medicineNameField4=new JTextField(20);
medicineNameField5=new JTextField(20);
amountField1=new JTextField(20);
amountField2=new JTextField(20);
amountField3=new JTextField(20);
amountField4=new JTextField(20);
amountField5=new JTextField(20);
sellButton=new JButton("SELL");
s1=new JLabel("done");
s2=new JLabel("done");
s3=new JLabel("done");
s4=new JLabel("done");
s5=new JLabel("done");
s11=new JLabel("x");
s22=new JLabel("x");
s33=new JLabel("x");
s44=new JLabel("x");
s55=new JLabel("x");
setLayout(null);
int lm=5;
logo.setBounds(lm+5,5,100,100);
name.setBounds(lm+155,30,500,30);
address.setBounds(lm+260,65,300,15);
mainLabel.setBounds(lm+245,130,250,50);
patientNameLabel.setBounds(lm+110,200,300,30);
patientNameField.setBounds(lm+270,200,300,30);
medicineNameLabel.setBounds(lm+195,265,300,30);
medicineNameField1.setBounds(lm+115,300,300,30);
medicineNameField2.setBounds(lm+115,340,300,30);
medicineNameField3.setBounds(lm+115,380,300,30);
medicineNameField4.setBounds(lm+115,420,300,30);
medicineNameField5.setBounds(lm+115,460,300,30);
amountLabel.setBounds(lm+463,265,300,30);
amountField1.setBounds(lm+465,300,80,30);
amountField2.setBounds(lm+465,340,80,30);
amountField3.setBounds(lm+465,380,80,30);
amountField4.setBounds(lm+465,420,80,30);
amountField5.setBounds(lm+465,460,80,30);
s1.setBounds(lm+548,300,50,30);
s2.setBounds(lm+548,340,50,30);
s3.setBounds(lm+548,380,50,30);
s4.setBounds(lm+548,420,50,30);
s5.setBounds(lm+548,460,50,30);
s11.setBounds(lm+548,300,50,30);
s22.setBounds(lm+548,340,50,30);
s33.setBounds(lm+548,380,50,30);
s44.setBounds(lm+548,420,50,30);
s55.setBounds(lm+548,460,50,30);
sellButton.setBounds(lm+235,530,180,40);
add(logo);
add(name);
add(address);
add(mainLabel);
add(patientNameLabel);
add(medicineNameLabel);
add(amountLabel);
add(patientNameField);
add(medicineNameField1);
add(medicineNameField2);
add(medicineNameField3);
add(medicineNameField4);
add(medicineNameField5);
add(amountField1);
add(amountField2);
add(amountField3);
add(amountField4);
add(amountField5);
add(sellButton);
add(s1);
add(s2);
add(s3);
add(s4);
add(s5);
add(s11);
add(s22);
add(s33);
add(s44);
add(s55);
s1.setVisible(false);
s2.setVisible(false);
s3.setVisible(false);
s4.setVisible(false);
s5.setVisible(false);
s11.setVisible(false);
s22.setVisible(false);
s33.setVisible(false);
s44.setVisible(false);
s55.setVisible(false);
}

private void setAppearance()
{
Font nameFont=new Font("Verdana",Font.BOLD,30);
name.setFont(nameFont);
Font addressFont=new Font("Verdana",Font.BOLD,14);
address.setFont(addressFont);
Font mainLabelFont=new Font("Verdana",Font.BOLD,21);
mainLabel.setFont(mainLabelFont);
Font labelFont=new Font("Verdana",Font.BOLD,17);
Font fieldFont=new Font("Verdana",Font.PLAIN,17);
patientNameLabel.setFont(labelFont);
medicineNameLabel.setFont(labelFont);
amountLabel.setFont(labelFont);
patientNameField.setFont(fieldFont);
medicineNameField1.setFont(fieldFont);
medicineNameField2.setFont(fieldFont);
medicineNameField3.setFont(fieldFont);
medicineNameField4.setFont(fieldFont);
medicineNameField5.setFont(fieldFont);
amountField1.setFont(fieldFont);
amountField2.setFont(fieldFont);
amountField3.setFont(fieldFont);
amountField4.setFont(fieldFont);
amountField5.setFont(fieldFont);
Font buttonFont=new Font("Verdana",Font.PLAIN,16);
sellButton.setFont(buttonFont);
}

private void addListeners()
{
sellButton.addActionListener(this);	
}


public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==sellButton)
{
int count=0;
int m1=0;
int m2=0;
int m3=0;
int m4=0;
int m5=0;
boolean success=false;
String vPatientName=patientNameField.getText().trim();
String vMedicineName1=medicineNameField1.getText().trim();
String vMedicineName2=medicineNameField2.getText().trim();
String vMedicineName3=medicineNameField3.getText().trim();
String vMedicineName4=medicineNameField4.getText().trim();
String vMedicineName5=medicineNameField5.getText().trim();
String vAmount1=amountField1.getText().trim();
String vAmount2=amountField2.getText().trim();
String vAmount3=amountField3.getText().trim();
String vAmount4=amountField4.getText().trim();
String vAmount5=amountField5.getText().trim();
if(vPatientName.length()==0 && count==0) 
{
JOptionPane.showMessageDialog(this, "Patient Name Required");
count=1;
}
if(vMedicineName1.length()!=0 && count==0 && vAmount1.length()!=0) 
{
m1=1;
}
else
{
if(vMedicineName1.length()!=0 && count==0 && vAmount1.length()==0) 
{
JOptionPane.showMessageDialog(this, "Quantity Required");
count=1;
}
if(vMedicineName1.length()==0 && count==0 && vAmount1.length()!=0) 
{
JOptionPane.showMessageDialog(this, "Medicine Name Required");
count=1;
}
}
if(vMedicineName2.length()!=0 && count==0 && vAmount2.length()!=0) 
{
m2=1;
}
else
{
if(vMedicineName2.length()!=0 && count==0 && vAmount2.length()==0) 
{
JOptionPane.showMessageDialog(this, "Quantity Required");
count=1;
}
if(vMedicineName2.length()==0 && count==0 && vAmount2.length()!=0) 
{
JOptionPane.showMessageDialog(this, "Medicine Name Required");
count=1;
}
}
if(vMedicineName3.length()!=0 && count==0 && vAmount3.length()!=0) 
{
m3=1;
}
else
{
if(vMedicineName3.length()!=0 && count==0 && vAmount3.length()==0) 
{
JOptionPane.showMessageDialog(this, "Quantity Required");
count=1;
}
if(vMedicineName3.length()==0 && count==0 && vAmount3.length()!=0) 
{
JOptionPane.showMessageDialog(this, "Medicine Name Required");
count=1;
}
}
if(vMedicineName4.length()!=0 && count==0 && vAmount4.length()!=0) 
{
m4=1;
}
else
{
if(vMedicineName4.length()!=0 && count==0 && vAmount4.length()==0) 
{
JOptionPane.showMessageDialog(this, "Quantity Required");
count=1;
}
if(vMedicineName4.length()==0 && count==0 && vAmount4.length()!=0) 
{
JOptionPane.showMessageDialog(this, "Medicine Name Required");
count=1;
}
}
if(vMedicineName5.length()!=0 && count==0 && vAmount5.length()!=0) 
{
m5=1;
}
else
{
if(vMedicineName5.length()!=0 && count==0 && vAmount5.length()==0) 
{
JOptionPane.showMessageDialog(this, "Quantity Required");
count=1;
}
if(vMedicineName5.length()==0 && count==0 && vAmount5.length()!=0) 
{
JOptionPane.showMessageDialog(this, "Medicine Name Required");
count=1;
}
}
if(m1==0 && m2==0 && m3==0 && m4==0 && m5==0 && count==0)
{
JOptionPane.showMessageDialog(this, "Atleast one Medicine Required");
}
if(count==0)
{
try
{
success=true;
if(m1==1)
{
success=sellModel.sell(vPatientName,vMedicineName1,vAmount1);
if(success) s1.setVisible(true);
else s11.setVisible(true);
}
if(m2==1)
{
success=sellModel.sell(vPatientName,vMedicineName2,vAmount2);
if(success) s2.setVisible(true);
else s22.setVisible(true);
}
if(m3==1)
{
success=sellModel.sell(vPatientName,vMedicineName3,vAmount3);
if(success) s3.setVisible(true);
else s33.setVisible(true);
}
if(m4==1)
{
success=sellModel.sell(vPatientName,vMedicineName4,vAmount4);
if(success) s4.setVisible(true);
else s44.setVisible(true);
}
if(m5==1)
{
success=sellModel.sell(vPatientName,vMedicineName5,vAmount5);
if(success) s5.setVisible(true);
else s55.setVisible(true);
}
System.out.println("fire ke pehle");
medicineModel=new MedicineModel();
medicineModel.fire();
System.out.println("fire ke bd");
}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "Some Medicine Not available");
System.out.println(e);
}
}
}
}
}