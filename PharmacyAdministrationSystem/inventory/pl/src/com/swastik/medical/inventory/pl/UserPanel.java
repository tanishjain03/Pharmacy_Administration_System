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
public class UserPanel extends JPanel implements ActionListener
{
private UserFrame uf;
private MedicineFrame medicineFrame;
private JLabel logo,name,address,userName,passward;
private JTextField userNameField;
private JPasswordField passwardField;
private JButton loginButton;
private UserModel userModel;
UserPanel(UserFrame uf)
{
this.uf=uf;
userModel=new UserModel();
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
userName=new JLabel("USERNAME");
passward=new JLabel("PASSWORD");
userNameField=new JTextField();
passwardField=new JPasswordField();
loginButton=new JButton("LOGIN");
setLayout(null);
int lm=5;
logo.setBounds(lm+5,5,100,100);
name.setBounds(lm+155,30,500,30);
address.setBounds(lm+260,65,300,15);
userName.setBounds(lm+220,200,120,30);
userNameField.setBounds(lm+345,200,120,30);
passward.setBounds(lm+220,240,120,30);
passwardField.setBounds(lm+345,240,120,30);
loginButton.setBounds(lm+287,290,120,30);

add(logo);
add(name);
add(address);
add(userName);
add(userNameField);
add(passward);
add(passwardField);
add(loginButton);
}    

private void setAppearance()
{
Font nameFont=new Font("Verdana",Font.BOLD,30);
name.setFont(nameFont);
Font addressFont=new Font("Verdana",Font.BOLD,14);
address.setFont(addressFont);
userName.setFont(userName.getFont().deriveFont(16.0f));
passward.setFont(passward.getFont().deriveFont(16.0f));
loginButton.setFont(loginButton.getFont().deriveFont(13.0f));
}

private void addListeners()
{
loginButton.addActionListener(this);	
}

public void actionPerformed(ActionEvent ev)
{
int count=0;
String vUserName=userNameField.getText().trim();
String vPassward=passwardField.getText().trim();
if(vUserName.length()==0 && count==0) 
{
JOptionPane.showMessageDialog(this, "Username Required");
count=1;
}
if(vPassward.length()==0 && count==0) 
{
JOptionPane.showMessageDialog(this, "Password Required");
count=1;
}
if(count==0)
{
try
{
boolean success=userModel.login(vUserName,vPassward);
if(success==true)
{
this.uf.setVisible(false);
medicineFrame=new MedicineFrame();
}
else
{
JOptionPane.showMessageDialog(this, "Incorrect Username or Passward.");
}
}catch(Exception e)
{
System.out.println(e);
}
}
}
}