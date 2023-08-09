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
public class ViewReportPanel extends JPanel implements ActionListener
{
private ViewReportModel viewReportModel;
private JLabel logo,name,address,mainLabel;
private JLabel todayReportLabel,dayReportLabel,monthReportLabel;
private JLabel dayDLabel,dayMLabel,dayYLabel;
private JTextField dayDField,dayMField,dayYField;
private JButton dayViewReportButton,dayCancelButton; 
private JLabel monthMLabel,monthYLabel;
private JTextField monthMField,monthYField;
private JButton monthViewReportButton,monthCancelButton; 

private JButton todayReportButton,dayReportButton,monthReportButton;
private JTable table;
private JScrollPane jsp;
ViewReportPanel()
{
viewReportModel=new ViewReportModel();
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
mainLabel=new JLabel("VIEW REPORTS");
todayReportLabel=new JLabel("TODAY'S REPORT");
dayReportLabel=new JLabel("DAY WISE REPORT");
monthReportLabel=new JLabel("MONTHLY REPORT");
todayReportButton=new JButton("View Today's Report");
dayReportButton=new JButton("View Day Wise Report");
monthReportButton=new JButton("View Monthly Report");
dayDLabel=new JLabel("Enter Date");
dayMLabel=new JLabel("Enter Month");
dayYLabel=new JLabel("Enter Year");
dayDField=new JTextField(2);
dayMField=new JTextField(10);
dayYField=new JTextField(4);
dayViewReportButton=new JButton("View Report");
dayCancelButton=new JButton("Cancel");
monthMLabel=new JLabel("Enter Month");
monthYLabel=new JLabel("Enter Year");
monthMField=new JTextField(10);
monthYField=new JTextField(4);
monthViewReportButton=new JButton("View Report");
monthCancelButton=new JButton("Cancel");  
//table=new JTable(viewReportModel);
//table=new JTable();
//jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

setLayout(null);
int lm=5;
logo.setBounds(lm+5,5,100,100);
name.setBounds(lm+500,34,600,30);
address.setBounds(lm+625,73,400,20);
mainLabel.setBounds(lm+630,140,400,40);
todayReportLabel.setBounds(lm+630,140,400,40);
dayReportLabel.setBounds(lm+630,140,400,40);
monthReportLabel.setBounds(lm+630,140,400,40);
todayReportButton.setBounds(lm+500,200,500,40);
dayReportButton.setBounds(lm+500,260,500,40);
monthReportButton.setBounds(lm+500,320,500,40);

dayDLabel.setBounds(lm+500,220,200,30);
dayMLabel.setBounds(lm+500,270,200,30);
dayYLabel.setBounds(lm+500,320,200,30);
dayDField.setBounds(lm+800,220,200,30);
dayMField.setBounds(lm+800,270,200,30);
dayYField.setBounds(lm+800,320,200,30);
dayViewReportButton.setBounds(lm+500,370,200,30);
dayCancelButton.setBounds(lm+800,370,200,30);

monthMLabel.setBounds(lm+500,220,200,30);
monthYLabel.setBounds(lm+500,270,200,30);
monthMField.setBounds(lm+800,220,200,30);
monthYField.setBounds(lm+800,270,200,30);
monthViewReportButton.setBounds(lm+500,320,200,30);
monthCancelButton.setBounds(lm+800,320,200,30);

//jsp.setBounds(lm+350,190,1000,580);

add(logo);
add(name);
add(address);
add(mainLabel);
add(todayReportLabel);
add(dayReportLabel);
add(monthReportLabel);
add(todayReportButton);
add(dayReportButton);
add(monthReportButton);
add(dayDLabel); 
add(dayMLabel);
add(dayYLabel);
add(dayDField);
add(dayMField);
add(dayYField);
add(dayViewReportButton);
add(dayCancelButton);
add(monthMLabel);
add(monthYLabel);
add(monthMField);
add(monthYField);
add(monthViewReportButton);
add(monthCancelButton);
//add(jsp);

todayReportLabel.setVisible(false);
dayReportLabel.setVisible(false);
monthReportLabel.setVisible(false);
dayDLabel.setVisible(false); 
dayMLabel.setVisible(false);
dayYLabel.setVisible(false);
dayDField.setVisible(false);
dayMField.setVisible(false);
dayYField.setVisible(false);
dayViewReportButton.setVisible(false);
dayCancelButton.setVisible(false);
monthMLabel.setVisible(false);
monthYLabel.setVisible(false);
monthMField.setVisible(false);
monthYField.setVisible(false);
monthViewReportButton.setVisible(false);
monthCancelButton.setVisible(false);

//jsp.setVisible(false);
}

private void setAppearance()
{
Font nameFont=new Font("Verdana",Font.BOLD,36);
name.setFont(nameFont);
Font addressFont=new Font("Verdana",Font.BOLD,20);
address.setFont(addressFont);
Font mainLabelFont=new Font("Verdana",Font.BOLD,26);
mainLabel.setFont(mainLabelFont);
todayReportLabel.setFont(mainLabelFont);
dayReportLabel.setFont(mainLabelFont);
monthReportLabel.setFont(mainLabelFont);
Font mainButtonFont=new Font("Verdana",Font.PLAIN,22);
todayReportButton.setFont(mainButtonFont);
dayReportButton.setFont(mainButtonFont);
monthReportButton.setFont(mainButtonFont);
Font labelFont=new Font("Verdana",Font.PLAIN,20);
dayDLabel.setFont(labelFont);
dayMLabel.setFont(labelFont);
dayYLabel.setFont(labelFont);
dayDField.setFont(labelFont);
dayMField.setFont(labelFont);
dayYField.setFont(labelFont);
dayViewReportButton.setFont(labelFont);
dayCancelButton.setFont(labelFont);
monthMLabel.setFont(labelFont);
monthYLabel.setFont(labelFont);
monthMField.setFont(labelFont);
monthYField.setFont(labelFont);
monthViewReportButton.setFont(labelFont);
monthCancelButton.setFont(labelFont);
}

private void addListeners()
{
todayReportButton.addActionListener(this);
dayReportButton.addActionListener(this);
monthReportButton.addActionListener(this);
dayCancelButton.addActionListener(this);
monthCancelButton.addActionListener(this);
dayViewReportButton.addActionListener(this);
monthViewReportButton.addActionListener(this);
}

public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==todayReportButton)
{
mainLabel.setVisible(false);
todayReportButton.setVisible(false);
dayReportButton.setVisible(false);
monthReportButton.setVisible(false);
todayReportLabel.setVisible(true);
Calendar cal=Calendar.getInstance();
int date=cal.get(Calendar.DATE);
int month=cal.get(Calendar.MONTH)+1;
int year=cal.get(Calendar.YEAR);
viewReportModel.getDateReport(date,month,year);
table=new JTable(viewReportModel);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
jsp.setBounds(350,190,1000,580);
add(jsp);
table.setRowHeight(30);
Font tableFont=new Font("Verdana",Font.PLAIN,16);
table.setFont(tableFont);
Font tableTitleFont=new Font("Verdana",Font.BOLD,16);
table.getTableHeader().setFont(tableTitleFont);
table.getColumnModel().getColumn(0).setPreferredWidth(150);
table.getColumnModel().getColumn(1).setPreferredWidth(150);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(100);
table.getColumnModel().getColumn(4).setPreferredWidth(100);
table.getColumnModel().getColumn(5).setPreferredWidth(100);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
table.getTableHeader().setResizingAllowed(false);
table.getTableHeader().setReorderingAllowed(false);
}

if(ev.getSource()==dayReportButton)
{
mainLabel.setVisible(false);
todayReportButton.setVisible(false);
dayReportButton.setVisible(false);
monthReportButton.setVisible(false);
dayReportLabel.setVisible(true);
dayDLabel.setVisible(true); 
dayMLabel.setVisible(true);
dayYLabel.setVisible(true);
dayDField.setVisible(true);
dayMField.setVisible(true);
dayYField.setVisible(true);
dayViewReportButton.setVisible(true);
dayCancelButton.setVisible(true);
}

if(ev.getSource()==dayCancelButton)
{
mainLabel.setVisible(true);
todayReportButton.setVisible(true);
dayReportButton.setVisible(true);
monthReportButton.setVisible(true);
dayReportLabel.setVisible(false);
dayDLabel.setVisible(false); 
dayMLabel.setVisible(false);
dayYLabel.setVisible(false);
dayDField.setVisible(false);
dayMField.setVisible(false);
dayYField.setVisible(false);
dayViewReportButton.setVisible(false);
dayCancelButton.setVisible(false);
}

if(ev.getSource()==monthReportButton)
{
mainLabel.setVisible(false);
todayReportButton.setVisible(false);
dayReportButton.setVisible(false);
monthReportButton.setVisible(false);
monthReportLabel.setVisible(true);
monthMLabel.setVisible(true);
monthYLabel.setVisible(true);
monthMField.setVisible(true);
monthYField.setVisible(true);
monthViewReportButton.setVisible(true);
monthCancelButton.setVisible(true);
}

if(ev.getSource()==monthCancelButton)
{
mainLabel.setVisible(true);
todayReportButton.setVisible(true);
dayReportButton.setVisible(true);
monthReportButton.setVisible(true);
monthReportLabel.setVisible(false);
monthMLabel.setVisible(false);
monthYLabel.setVisible(false);
monthMField.setVisible(false);
monthYField.setVisible(false);
monthViewReportButton.setVisible(false);
monthCancelButton.setVisible(false);
}

if(ev.getSource()==dayViewReportButton)
{
dayDLabel.setVisible(false); 
dayMLabel.setVisible(false);
dayYLabel.setVisible(false);
dayDField.setVisible(false);
dayMField.setVisible(false);
dayYField.setVisible(false);
dayViewReportButton.setVisible(false);
dayCancelButton.setVisible(false);
int d=0;
int m=0;
int y=0;
String date=dayDField.getText().trim();
String month=dayMField.getText().trim();
String year=dayYField.getText().trim();
d=Integer.parseInt(date);
m=Integer.parseInt(month);
y=Integer.parseInt(year);
viewReportModel.getDateReport(d,m,y);
table=new JTable(viewReportModel);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
jsp.setBounds(350,190,1000,580);
add(jsp);
table.setRowHeight(30);
Font tableFont=new Font("Verdana",Font.PLAIN,16);
table.setFont(tableFont);
Font tableTitleFont=new Font("Verdana",Font.BOLD,16);
table.getTableHeader().setFont(tableTitleFont);
table.getColumnModel().getColumn(0).setPreferredWidth(150);
table.getColumnModel().getColumn(1).setPreferredWidth(150);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(100);
table.getColumnModel().getColumn(4).setPreferredWidth(100);
table.getColumnModel().getColumn(5).setPreferredWidth(100);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
table.getTableHeader().setResizingAllowed(false);
table.getTableHeader().setReorderingAllowed(false);
}


if(ev.getSource()==monthViewReportButton)
{
monthMLabel.setVisible(false);
monthYLabel.setVisible(false);
monthMField.setVisible(false);
monthYField.setVisible(false);
monthViewReportButton.setVisible(false);
monthCancelButton.setVisible(false);
int m;
int y;
String month=monthMField.getText().trim();
String year=monthYField.getText().trim();
m=Integer.parseInt(month);
y=Integer.parseInt(year);
viewReportModel.getMonthReport(m,y);
table=new JTable(viewReportModel);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
jsp.setBounds(350,190,1000,580);
add(jsp);
jsp.setVisible(true);
table.setRowHeight(30);
Font tableFont=new Font("Verdana",Font.PLAIN,16);
table.setFont(tableFont);
Font tableTitleFont=new Font("Verdana",Font.BOLD,16);
table.getTableHeader().setFont(tableTitleFont);
table.getColumnModel().getColumn(0).setPreferredWidth(150);
table.getColumnModel().getColumn(1).setPreferredWidth(150);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.getColumnModel().getColumn(3).setPreferredWidth(100);
table.getColumnModel().getColumn(4).setPreferredWidth(100);
table.getColumnModel().getColumn(5).setPreferredWidth(100);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
table.getTableHeader().setResizingAllowed(false);
table.getTableHeader().setReorderingAllowed(false);
}


}
}