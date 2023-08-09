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
public class GetExpiryPanel extends JPanel  implements DocumentListener,ActionListener
{
private GetExpiryModel getExpiryModel;
private JLabel logo,name,address,mainLabel;
private JLabel searchCaptionLabel;
private JLabel searchErrorLabel;
private JTextField searchTextField;
private JButton clearSearchTextFieldButton;
private JTable table;
private JScrollPane jsp;
GetExpiryPanel()
{
getExpiryModel=new GetExpiryModel();
initComponents();
setAppearance();
addListeners();
setViewMode();
}
private void initComponents()
{
ImageIcon imageIcon = new ImageIcon("logo.jpg");
logo=new JLabel(imageIcon);
name=new JLabel("SWASTIK  MEDICAL  STORE");
address=new JLabel("244,DAULATGANJ,UJJAIN[M.P.]");
mainLabel=new JLabel("Expiry Details");
searchCaptionLabel=new JLabel("Search");
searchErrorLabel=new JLabel("");
searchTextField=new JTextField();
clearSearchTextFieldButton=new JButton("Clear");
table=new JTable(getExpiryModel);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
setLayout(null);
int lm=5;
logo.setBounds(lm+5,5,100,100);
name.setBounds(lm+500,34,600,30);
address.setBounds(lm+625,73,400,20);
mainLabel.setBounds(lm+610,120,400,40);
searchCaptionLabel.setBounds(lm+520,180,100,20);
searchTextField.setBounds(lm+610,180,230,25);
searchErrorLabel.setBounds(lm+765,163,230,13);
clearSearchTextFieldButton.setBounds(lm+860,180,70,25);
jsp.setBounds(lm+410,220,700,580);
add(logo);
add(name);
add(address);
add(mainLabel);
add(searchCaptionLabel);
add(searchTextField);
add(clearSearchTextFieldButton);
add(searchErrorLabel);
add(jsp);
}

private void setAppearance()
{
Font nameFont=new Font("Verdana",Font.BOLD,36);
name.setFont(nameFont);
Font addressFont=new Font("Verdana",Font.BOLD,20);
address.setFont(addressFont);
Font mainLabelFont=new Font("Verdana",Font.BOLD,26);
mainLabel.setFont(mainLabelFont);
Font searchCaptionLabelFont=new Font("Verdana",Font.PLAIN,22);
searchCaptionLabel.setFont(searchCaptionLabelFont);
Font clearSearchTextFieldButtonFont=new Font("Verdana",Font.BOLD,10);
clearSearchTextFieldButton.setFont(clearSearchTextFieldButtonFont);
searchErrorLabel.setForeground(Color.red);
table.setRowHeight(30);
Font tableFont=new Font("Verdana",Font.PLAIN,16);
table.setFont(tableFont);
Font tableTitleFont=new Font("Verdana",Font.BOLD,16);
table.getTableHeader().setFont(tableTitleFont);
table.getColumnModel().getColumn(0).setPreferredWidth(150);
table.getColumnModel().getColumn(1).setPreferredWidth(100);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(200);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
table.getTableHeader().setResizingAllowed(false);
table.getTableHeader().setReorderingAllowed(false);
}

private void addListeners()
{
searchTextField.getDocument().addDocumentListener(this);
clearSearchTextFieldButton.addActionListener(this);
}
private void setViewMode()
{
if(getExpiryModel.getRowCount()==0)
{
searchTextField.setText("");
searchErrorLabel.setText("");
searchTextField.setEnabled(false);
clearSearchTextFieldButton.setEnabled(false);
table.setEnabled(false);
}
else
{
searchTextField.setEnabled(true);
clearSearchTextFieldButton.setEnabled(true);
table.setEnabled(true);
}
}

private void search()
{
searchErrorLabel.setText("");
String searchWhat=searchTextField.getText().trim();
if(searchWhat.length()==0)return;
int index=getExpiryModel.search(searchWhat);
if(index==-1)
{
searchErrorLabel.setText("Not found");
return;
}
table.setRowSelectionInterval(index,index);
table.scrollRectToVisible(new Rectangle(table.getCellRect(index,0,false)));
}

public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==clearSearchTextFieldButton)
{
searchTextField.setText("");
searchErrorLabel.setText("");
searchTextField.requestFocus();
}
}

public void insertUpdate(DocumentEvent ev)
{
search();
}
public void removeUpdate(DocumentEvent ev)
{
search();
}
public void changedUpdate(DocumentEvent ev)
{
search();
}


}