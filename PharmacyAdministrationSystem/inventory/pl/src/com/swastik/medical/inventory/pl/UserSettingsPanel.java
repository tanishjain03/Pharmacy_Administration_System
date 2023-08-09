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
public class UserSettingsPanel extends JPanel implements ActionListener
{
private JLabel logo,name,address;
private JLabel mainLabel,changePasswordMainLabel,addUserMainLabel;
private JButton changeButton;
private JButton addUserButton;
private JLabel userNameLabel,oldPasswordLabel,newPasswordLabel;
private JPasswordField oldPasswordField,newPasswordField;
private JTextField userNameField;
private JButton changePasswordButton,cancelButton;
private JLabel addUserNameLabel,addUserPasswardLabel;
private JTextField addUserNameField;
private JPasswordField addUserPasswardField;
private JButton addNewUserButton,addUserCancelButton;
private UserSettingsModel userSettingsModel;
UserSettingsPanel()
{
userSettingsModel=new UserSettingsModel();
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
mainLabel=new JLabel("USER SETTING");
changeButton=new JButton("Change Password");
addUserButton=new JButton("Add New User");
changePasswordMainLabel=new JLabel("Change Password Setting");
addUserMainLabel=new JLabel("Add New User Setting");
userNameLabel=new JLabel("Username");
oldPasswordLabel=new JLabel("Old Password");
newPasswordLabel=new JLabel("New Password");
userNameField=new JTextField(15);
oldPasswordField=new JPasswordField(15);
newPasswordField=new JPasswordField(15);
changePasswordButton=new JButton("Change Password");
cancelButton=new JButton("Cancel");
addUserNameLabel=new JLabel("Username");
addUserPasswardLabel=new JLabel("Password");
addUserNameField=new JTextField(15);
addUserPasswardField=new JPasswordField(15);
addNewUserButton=new JButton("Add User");
addUserCancelButton=new JButton("Cancel");

setLayout(null);
int lm=5;
logo.setBounds(lm+5,5,100,100);
name.setBounds(lm+155,30,500,30);
address.setBounds(lm+260,65,300,15);
mainLabel.setBounds(lm+245,150,250,50);
changeButton.setBounds(lm+210,250,250,45);
addUserButton.setBounds(lm+210,320,250,45);
changePasswordMainLabel.setBounds(lm+180,150,300,50);
userNameLabel.setBounds(lm+110,250,300,30);
userNameField.setBounds(lm+270,250,300,30);
oldPasswordLabel.setBounds(lm+110,300,300,30);
oldPasswordField.setBounds(lm+270,300,300,30);
newPasswordLabel.setBounds(lm+110,350,300,30);
newPasswordField.setBounds(lm+270,350,300,30);
changePasswordButton.setBounds(lm+125,450,180,40);
cancelButton.setBounds(lm+375,450,180,40);


addUserMainLabel.setBounds(lm+200,150,300,50);
addUserNameLabel.setBounds(lm+110,250,300,30);
addUserNameField.setBounds(lm+270,250,300,30);
addUserPasswardLabel.setBounds(lm+110,300,300,30);
addUserPasswardField.setBounds(lm+270,300,300,30);
addNewUserButton.setBounds(lm+125,380,180,40);
addUserCancelButton.setBounds(lm+375,380,180,40);

add(logo);
add(name);
add(address);
add(mainLabel);
add(changeButton);
add(addUserButton);
add(changePasswordMainLabel);
add(addUserMainLabel);
add(userNameLabel);
add(userNameField);
add(oldPasswordLabel);
add(oldPasswordField);
add(newPasswordLabel);
add(newPasswordField);
add(changePasswordButton);
add(cancelButton);
add(addUserNameLabel);
add(addUserNameField);
add(addUserPasswardLabel);
add(addUserPasswardField);
add(addNewUserButton);
add(addUserCancelButton);

changePasswordMainLabel.setVisible(false);
userNameLabel.setVisible(false);
userNameField.setVisible(false);
oldPasswordLabel.setVisible(false);
oldPasswordField.setVisible(false);
newPasswordLabel.setVisible(false);
newPasswordField.setVisible(false);
changePasswordButton.setVisible(false);
cancelButton.setVisible(false);

addUserMainLabel.setVisible(false);
addUserNameLabel.setVisible(false);
addUserNameField.setVisible(false);
addUserPasswardLabel.setVisible(false);
addUserPasswardField.setVisible(false);
addNewUserButton.setVisible(false);
addUserCancelButton.setVisible(false);


}

private void setAppearance()
{
Font nameFont=new Font("Verdana",Font.BOLD,30);
name.setFont(nameFont);
Font addressFont=new Font("Verdana",Font.BOLD,14);
address.setFont(addressFont);
Font mainLabelFont=new Font("Verdana",Font.BOLD,21);
mainLabel.setFont(mainLabelFont);
Font buttonFont=new Font("Verdana",Font.PLAIN,16);
changeButton.setFont(buttonFont);
addUserButton.setFont(buttonFont);
changePasswordButton.setFont(buttonFont);
cancelButton.setFont(buttonFont);
changePasswordMainLabel.setFont(mainLabelFont);
Font labelFont=new Font("Verdana",Font.BOLD,17);
Font fieldFont=new Font("Verdana",Font.PLAIN,17);
userNameLabel.setFont(labelFont);
oldPasswordLabel.setFont(labelFont);
newPasswordLabel.setFont(labelFont);
addUserMainLabel.setFont(mainLabelFont);
userNameField.setFont(fieldFont);
oldPasswordField.setFont(fieldFont);
newPasswordField.setFont(fieldFont);
addUserNameLabel.setFont(labelFont);
addUserNameField.setFont(fieldFont);
addUserPasswardLabel.setFont(labelFont);
addUserPasswardField.setFont(fieldFont);
}

private void addListeners()
{
changeButton.addActionListener(this);	
addUserButton.addActionListener(this);
changePasswordButton.addActionListener(this);	
cancelButton.addActionListener(this);	
addNewUserButton.addActionListener(this);	
addUserCancelButton.addActionListener(this);		
}

public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==changeButton)
{
mainLabel.setVisible(false);
changeButton.setVisible(false);
addUserButton.setVisible(false);
changePasswordMainLabel.setVisible(true);
userNameLabel.setVisible(true);
userNameField.setVisible(true);
oldPasswordLabel.setVisible(true);
oldPasswordField.setVisible(true);
newPasswordLabel.setVisible(true);
newPasswordField.setVisible(true);
changePasswordButton.setVisible(true);
cancelButton.setVisible(true);
}

if(ev.getSource()==addUserButton)
{
mainLabel.setVisible(false);
changeButton.setVisible(false);
addUserButton.setVisible(false);
addUserMainLabel.setVisible(true);
addUserNameLabel.setVisible(true);
addUserNameField.setVisible(true);
addUserPasswardLabel.setVisible(true);
addUserPasswardField.setVisible(true);
addNewUserButton.setVisible(true);
addUserCancelButton.setVisible(true);
}

if(ev.getSource()==changePasswordButton)
{
int count=0;
boolean success=false;
String vUserName=userNameField.getText().trim();
String vOldPassword=oldPasswordField.getText().trim();
String vNewPassword=newPasswordField.getText().trim();
if(vUserName.length()==0 && count==0) 
{
JOptionPane.showMessageDialog(this, "Username Required");
count=1;
}
if(vOldPassword.length()==0 && count==0) 
{
JOptionPane.showMessageDialog(this, "Password Required");
count=1;
}
if(vNewPassword.length()==0 && count==0) 
{
JOptionPane.showMessageDialog(this, "Password Required");
count=1;
}
if(count==0)
{
try
{
success=userSettingsModel.changePassword(vUserName,vOldPassword,vNewPassword);
if(success) JOptionPane.showMessageDialog(this, "Password Changed Successfully");
else JOptionPane.showMessageDialog(this, "Password not Changed");
}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "Username not available");
System.out.println(e);
}
}

}

if(ev.getSource()==cancelButton)
{
mainLabel.setVisible(true);
changeButton.setVisible(true);
addUserButton.setVisible(true);
changePasswordMainLabel.setVisible(false);
userNameLabel.setVisible(false);
userNameField.setVisible(false);
oldPasswordLabel.setVisible(false);
oldPasswordField.setVisible(false);
newPasswordLabel.setVisible(false);
newPasswordField.setVisible(false);
changePasswordButton.setVisible(false);
cancelButton.setVisible(false);
}

if(ev.getSource()==addNewUserButton)
{
int count=0;
boolean success=false;
String vUserName=addUserNameField.getText().trim();
String vPassward=addUserPasswardField.getText().trim();
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
success=userSettingsModel.add(vUserName,vPassward);
if(success) JOptionPane.showMessageDialog(this, "User Added");
else JOptionPane.showMessageDialog(this, "User not available");
}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "Username not available");
System.out.println(e);
}
}
}

if(ev.getSource()==addUserCancelButton)
{
mainLabel.setVisible(true);
changeButton.setVisible(true);
addUserButton.setVisible(true);
addUserMainLabel.setVisible(false);
addUserNameLabel.setVisible(false);
addUserNameField.setVisible(false);
addUserPasswardLabel.setVisible(false);
addUserPasswardField.setVisible(false);
addNewUserButton.setVisible(false);
addUserCancelButton.setVisible(false);
}

}



}