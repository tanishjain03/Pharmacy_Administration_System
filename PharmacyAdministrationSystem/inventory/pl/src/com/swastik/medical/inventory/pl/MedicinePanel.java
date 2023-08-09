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
public class MedicinePanel extends JPanel implements DocumentListener,ListSelectionListener,ActionListener
{
private MedicineFrame mf;
public enum MODE{VIEW_MODE,ADD_MODE,EDIT_MODE,DELETE_MODE};
public MODE ADD_MODE=MODE.ADD_MODE;
public MODE EDIT_MODE=MODE.EDIT_MODE;
public MODE DELETE_MODE=MODE.DELETE_MODE;
public MODE VIEW_MODE=MODE.VIEW_MODE;
public MODE mode;
private UserSettingsFrame userSettingsFrame;
//private SellFrame sellFrame;
private GetExpiryFrame getExpiryFrame;
private ViewReportFrame viewReportFrame;
private MedicineModel medicineModel;
private SellModel sellModel;
private JLabel logo,name,address;
private JLabel detailCaptionLabel;
private JLabel sellLabel;
private JLabel searchCaptionLabel;
private JLabel searchErrorLabel;
private JTextField searchTextField;
private JButton clearSearchTextFieldButton;
private JButton logoutButton;
private JButton userSettingButton;
private JButton sellButton;
private JButton getExpiryButton;
private JButton viewReportButton;
private JTable table;
private JScrollPane jsp;
private MedicineDetailsPanel medicineDetailsPanel;
private SellPanel sellPanel;
MedicinePanel(MedicineFrame mf)
{
this.mf=mf;
medicineModel=new MedicineModel();
sellModel=new SellModel();
initComponents();
setAppearance();
addListeners();
setViewMode();
medicineDetailsPanel.setViewMode();
}

private void initComponents()
{
ImageIcon imageIcon = new ImageIcon("logo.jpg");
logo=new JLabel(imageIcon);
name=new JLabel("SWASTIK  MEDICAL  STORE");
address=new JLabel("244,DAULATGANJ,UJJAIN[M.P.]");
detailCaptionLabel=new JLabel("Medicine Details");
sellLabel=new JLabel("Sell Window");
searchCaptionLabel=new JLabel("Search");
searchErrorLabel=new JLabel("");
searchTextField=new JTextField();
clearSearchTextFieldButton=new JButton("Clear");
logoutButton=new JButton("Logout");
userSettingButton=new JButton("User Settings");
sellButton=new JButton("Sell");
getExpiryButton=new JButton("Get Expiry");
viewReportButton=new JButton("View Reports");
table=new JTable(medicineModel);
jsp=new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
medicineDetailsPanel=new MedicineDetailsPanel();
sellPanel=new SellPanel();
setLayout(null);
int lm=5;
logo.setBounds(lm+5,5,100,100);
name.setBounds(lm+500,34,600,30);
address.setBounds(lm+625,73,400,20);
detailCaptionLabel.setBounds(lm+1000,155,300,20);
sellLabel.setBounds(lm+1050,155,300,20);
searchCaptionLabel.setBounds(lm+140,155,100,20);
searchTextField.setBounds(lm+235,150,230,25);
searchErrorLabel.setBounds(lm+385,133,230,13);
clearSearchTextFieldButton.setBounds(lm+480,150,70,25);
jsp.setBounds(lm+20,220,665,580);
medicineDetailsPanel.setBounds(lm+800,220,665,580);
sellPanel.setBounds(lm+800,220,665,580);
logoutButton.setBounds(lm+1420,10,75,25);
userSettingButton.setBounds(lm+1385,40,110,25);
sellButton.setBounds(lm+1420,70,75,25);
getExpiryButton.setBounds(lm+1385,100,110,25);
viewReportButton.setBounds(lm+1385,130,110,25);
add(logo);
add(name);
add(address);
add(detailCaptionLabel);
add(sellLabel);
add(searchCaptionLabel);
add(searchTextField);
add(clearSearchTextFieldButton);
add(searchErrorLabel);
add(jsp);
add(medicineDetailsPanel);
add(sellPanel);
//add(logoutButton);
add(userSettingButton);
add(sellButton);
add(getExpiryButton);
add(viewReportButton);
sellPanel.setVisible(false);
sellLabel.setVisible(false);
}

private void setAppearance()
{
Font nameFont=new Font("Verdana",Font.BOLD,36);
name.setFont(nameFont);
Font addressFont=new Font("Verdana",Font.BOLD,20);
address.setFont(addressFont);
Font detailCaptionLabelFont=new Font("Verdana",Font.BOLD,22);
detailCaptionLabel.setFont(detailCaptionLabelFont);
sellLabel.setFont(detailCaptionLabelFont);
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
table.getColumnModel().getColumn(0).setPreferredWidth(100);
table.getColumnModel().getColumn(1).setPreferredWidth(100);
table.getColumnModel().getColumn(2).setPreferredWidth(100);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
table.getTableHeader().setResizingAllowed(false);
table.getTableHeader().setReorderingAllowed(false);
}

private void addListeners()
{
searchTextField.getDocument().addDocumentListener(this);
table.getSelectionModel().addListSelectionListener(this);
clearSearchTextFieldButton.addActionListener(this);
//logoutButton.addActionListener(this);
userSettingButton.addActionListener(this);
sellButton.addActionListener(this);
getExpiryButton.addActionListener(this);
viewReportButton.addActionListener(this);
}

private void setAddMode()
{
mode=ADD_MODE;
clearSearchTextFieldButton.setEnabled(false);
table.setEnabled(false);
searchTextField.setEnabled(false);
}

private void setEditMode()
{
mode=EDIT_MODE;
clearSearchTextFieldButton.setEnabled(false);
table.setEnabled(false);
searchTextField.setEnabled(false);
}

private void setDeleteMode()
{
mode=DELETE_MODE;
clearSearchTextFieldButton.setEnabled(false);
table.setEnabled(false);
searchTextField.setEnabled(false);
}

private void setViewMode()
{
mode=VIEW_MODE;
if(medicineModel.getRowCount()==0)
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
int index=medicineModel.search(searchWhat);
if(index==-1)
{
searchErrorLabel.setText("Not found");
return;
}
table.setRowSelectionInterval(index,index);
table.scrollRectToVisible(new Rectangle(table.getCellRect(index,0,false)));
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

public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==clearSearchTextFieldButton)
{
searchTextField.setText("");
searchErrorLabel.setText("");
searchTextField.requestFocus();
}
if(ev.getSource()==userSettingButton)
{
userSettingsFrame=new UserSettingsFrame();
}
if(ev.getSource()==sellButton)
{
detailCaptionLabel.setVisible(false);
sellLabel.setVisible(true);
medicineDetailsPanel.setVisible(false);
sellPanel.setVisible(true);
}
if(ev.getSource()==getExpiryButton)
{
getExpiryFrame=new GetExpiryFrame();
}
if(ev.getSource()==viewReportButton)
{
viewReportFrame=new ViewReportFrame();
}
}

public void valueChanged(ListSelectionEvent ev)
{
int selectedIndex=table.getSelectedRow();
if(selectedIndex==-1)
{
medicineDetailsPanel.setMedicine(null);
return;
}
try
{
MedicineInterface medicine=medicineModel.getMedicineAt(selectedIndex);
medicineDetailsPanel.setMedicine(medicine);
}
catch(Exception e)
{
medicineDetailsPanel.setMedicine(null);
}
}


//inner class start
class MedicineDetailsPanel extends JPanel implements ActionListener
{
private MedicineInterface medicine;
private JPanel p1,p2;
private JScrollPane scrollPane;
private JLabel  nameCaptionLabel;
private JTextField nameTextField;
private JLabel nameLabel;
private JButton clearNameTextFieldButton;

private JLabel categoryCaptionLabel;
private JLabel categoryLabel;
private ButtonGroup categoryGroup;
private JRadioButton TabletRadioButton;
private JRadioButton CapsuleRadioButton;
private JRadioButton PowderRadioButton;
private JRadioButton SyrupRadioButton;
private JRadioButton InjectionRadioButton;
private JRadioButton OtherRadioButton;

private JLabel  buyingCostCaptionLabel;
private JTextField buyingCostTextField;
private JLabel buyingCostLabel;
private JButton clearBuyingCostTextFieldButton;

private JLabel  MRPCaptionLabel;
private JTextField MRPTextField;
private JLabel MRPLabel;
private JButton clearMRPTextFieldButton;

private JLabel  traderNameCaptionLabel;
private JTextField traderNameTextField;
private JLabel traderNameLabel;
private JButton clearTraderNameTextFieldButton;

private JLabel  billNumberCaptionLabel;
private JTextField billNumberTextField;
private JLabel billNumberLabel;
private JButton clearBillNumberTextFieldButton;

private JLabel  manuMonthCaptionLabel;
private JTextField manuMonthTextField;
private JLabel manuMonthLabel;
private JButton clearManuMonthTextFieldButton;

private JLabel  manuYearCaptionLabel;
private JTextField manuYearTextField;
private JLabel manuYearLabel;
private JButton clearManuYearTextFieldButton;

private JLabel  exMonthCaptionLabel;
private JTextField exMonthTextField;
private JLabel exMonthLabel;
private JButton clearExMonthTextFieldButton;

private JLabel  exYearCaptionLabel;
private JTextField exYearTextField;
private JLabel exYearLabel;
private JButton clearExYearTextFieldButton;

private JLabel  billDateCaptionLabel;
private JTextField billDateTextField;
private JLabel billDateLabel;
private JButton clearBillDateTextFieldButton;

private JLabel  billMonthCaptionLabel;
private JTextField billMonthTextField;
private JLabel billMonthLabel;
private JButton clearBillMonthTextFieldButton;

private JLabel  billYearCaptionLabel;
private JTextField billYearTextField;
private JLabel billYearLabel;
private JButton clearBillYearTextFieldButton;

private JLabel  ammountOfMedicineCaptionLabel;
private JTextField ammountOfMedicineTextField;
private JLabel ammountOfMedicineLabel;
private JButton clearAmmountOfMedicineTextFieldButton;

private JButton addButton;
private JButton updateButton;
private JButton deleteButton;
private JButton cancelButton;

MedicineDetailsPanel()
{
initComponents();
setAppearance();
addListeners();
}
private void initComponents()
{
nameCaptionLabel=new JLabel("Name : ");
nameTextField=new JTextField();
clearNameTextFieldButton=new JButton("Clear");
nameLabel=new JLabel("");
categoryCaptionLabel=new JLabel("Category : ");
categoryLabel=new JLabel("");
categoryGroup=new ButtonGroup();
TabletRadioButton=new JRadioButton("Tablet");
CapsuleRadioButton=new JRadioButton("Capsule");
SyrupRadioButton=new JRadioButton("Syrup");
PowderRadioButton=new JRadioButton("Powder");
InjectionRadioButton=new JRadioButton("Injection");
OtherRadioButton=new JRadioButton("Other");
categoryGroup.add(TabletRadioButton);
categoryGroup.add(CapsuleRadioButton);
categoryGroup.add(SyrupRadioButton);
categoryGroup.add(PowderRadioButton);
categoryGroup.add(InjectionRadioButton);
categoryGroup.add(OtherRadioButton);

buyingCostCaptionLabel=new JLabel("Buying Cost : ");
buyingCostTextField=new JTextField();
clearBuyingCostTextFieldButton=new JButton("Clear");
buyingCostLabel=new JLabel("");

MRPCaptionLabel=new JLabel("MRP : ");
MRPTextField=new JTextField();
clearMRPTextFieldButton=new JButton("Clear");
MRPLabel=new JLabel("");

traderNameCaptionLabel=new JLabel("Trader Name : ");
traderNameTextField=new JTextField();
clearTraderNameTextFieldButton=new JButton("Clear");
traderNameLabel=new JLabel("");

billNumberCaptionLabel=new JLabel("Bill Number : ");
billNumberTextField=new JTextField();
clearBillNumberTextFieldButton=new JButton("Clear");
billNumberLabel=new JLabel("");
   
manuMonthCaptionLabel=new JLabel("Manu. Month : ");
manuMonthTextField=new JTextField();
clearManuMonthTextFieldButton=new JButton("Clear");
manuMonthLabel=new JLabel("");

manuYearCaptionLabel=new JLabel("Manu. Year : ");
manuYearTextField=new JTextField();
clearManuYearTextFieldButton=new JButton("Clear");
manuYearLabel=new JLabel("");

exMonthCaptionLabel=new JLabel("Expiry Month : ");
exMonthTextField=new JTextField();
clearExMonthTextFieldButton=new JButton("Clear");
exMonthLabel=new JLabel("");

exYearCaptionLabel=new JLabel("Expiry Year : ");
exYearTextField=new JTextField();
clearExYearTextFieldButton=new JButton("Clear");
exYearLabel=new JLabel("");

billDateCaptionLabel=new JLabel("Bill Date : ");
billDateTextField=new JTextField();
clearBillDateTextFieldButton=new JButton("Clear");
billDateLabel=new JLabel("");

billMonthCaptionLabel=new JLabel("Bill Month : ");
billMonthTextField=new JTextField();
clearBillMonthTextFieldButton=new JButton("Clear");
billMonthLabel=new JLabel("");

billYearCaptionLabel=new JLabel("Bill Year : ");
billYearTextField=new JTextField();
clearBillYearTextFieldButton=new JButton("Clear");
billYearLabel=new JLabel("");

ammountOfMedicineCaptionLabel=new JLabel("Amount Of Medicine : ");
ammountOfMedicineTextField=new JTextField();
clearAmmountOfMedicineTextFieldButton=new JButton("Clear");
ammountOfMedicineLabel=new JLabel("");

addButton=new JButton("Add");
updateButton=new JButton("Edit");
deleteButton=new JButton("Delete");
cancelButton=new JButton("Cancel");
setLayout(new BorderLayout());


int lm,tm;
lm=5;
tm=5;	
nameCaptionLabel.setBounds(lm+20,tm+10,150,20);
nameLabel.setBounds(lm+220,tm+10,300,20);
nameTextField.setBounds(lm+220,tm+10,300,20);
clearNameTextFieldButton.setBounds(lm+130+350+60,tm+10,65,20);

buyingCostCaptionLabel.setBounds(lm+20,tm+45,150,20);
buyingCostLabel.setBounds(lm+220,tm+45,300,20);
buyingCostTextField.setBounds(lm+220,tm+45,300,20);
clearBuyingCostTextFieldButton.setBounds(lm+130+350+60,tm+45,65,20);

MRPCaptionLabel.setBounds(lm+20,tm+80,150,20);
MRPLabel.setBounds(lm+220,tm+80,300,20);
MRPTextField.setBounds(lm+220,tm+80,300,20);
clearMRPTextFieldButton.setBounds(lm+130+350+60,tm+80,65,20);

traderNameCaptionLabel.setBounds(lm+20,tm+115,150,20);
traderNameLabel.setBounds(lm+220,tm+115,300,20);
traderNameTextField.setBounds(lm+220,tm+115,300,20);
clearTraderNameTextFieldButton.setBounds(lm+130+350+60,tm+115,65,20);

billNumberCaptionLabel.setBounds(lm+20,tm+150,150,20);
billNumberLabel.setBounds(lm+220,tm+150,300,20);
billNumberTextField.setBounds(lm+220,tm+150,300,20);
clearBillNumberTextFieldButton.setBounds(lm+130+350+60,tm+150,65,20);

manuMonthCaptionLabel.setBounds(lm+20,tm+185,150,20);
manuMonthLabel.setBounds(lm+220,tm+185,300,20);
manuMonthTextField.setBounds(lm+220,tm+185,300,20);
clearManuMonthTextFieldButton.setBounds(lm+130+350+60,tm+185,65,20);

manuYearCaptionLabel.setBounds(lm+20,tm+220,150,20);
manuYearLabel.setBounds(lm+220,tm+220,300,20);
manuYearTextField.setBounds(lm+220,tm+220,300,20);
clearManuYearTextFieldButton.setBounds(lm+130+350+60,tm+220,65,20);

exMonthCaptionLabel.setBounds(lm+20,tm+255,150,20);
exMonthLabel.setBounds(lm+220,tm+255,300,20);
exMonthTextField.setBounds(lm+220,tm+255,300,20);
clearExMonthTextFieldButton.setBounds(lm+130+350+60,tm+255,65,20);

exYearCaptionLabel.setBounds(lm+20,tm+290,150,20);
exYearLabel.setBounds(lm+220,tm+290,300,20);
exYearTextField.setBounds(lm+220,tm+290,300,20);
clearExYearTextFieldButton.setBounds(lm+130+350+60,tm+290,65,20);

billDateCaptionLabel.setBounds(lm+20,tm+325,150,20);
billDateLabel.setBounds(lm+220,tm+325,300,20);
billDateTextField.setBounds(lm+220,tm+325,300,20);
clearBillDateTextFieldButton.setBounds(lm+130+350+60,tm+325,65,20);

billMonthCaptionLabel.setBounds(lm+20,tm+360,150,20);
billMonthLabel.setBounds(lm+220,tm+360,300,20);
billMonthTextField.setBounds(lm+220,tm+360,300,20);
clearBillMonthTextFieldButton.setBounds(lm+130+350+60,tm+360,65,20);

billYearCaptionLabel.setBounds(lm+20,tm+395,150,20);
billYearLabel.setBounds(lm+220,tm+395,300,20);
billYearTextField.setBounds(lm+220,tm+395,300,20);
clearBillYearTextFieldButton.setBounds(lm+130+350+60,tm+395,65,20);

ammountOfMedicineCaptionLabel.setBounds(lm+20,tm+430,300,20);
ammountOfMedicineLabel.setBounds(lm+220,tm+430,300,20);
ammountOfMedicineTextField.setBounds(lm+220,tm+430,300,20);
clearAmmountOfMedicineTextFieldButton.setBounds(lm+130+350+60,tm+430,65,20);

categoryCaptionLabel.setBounds(lm+20,tm+465,150,20);
categoryLabel.setBounds(lm+220,tm+465,300,20);	
TabletRadioButton.setBounds(lm+220,tm+465,80,20);
CapsuleRadioButton.setBounds(lm+315,tm+465,100,20);
SyrupRadioButton.setBounds(lm+420,tm+465,80,20);
PowderRadioButton.setBounds(lm+220,tm+500,95,20);
InjectionRadioButton.setBounds(lm+315,tm+500,100,20);
OtherRadioButton.setBounds(lm+420,tm+500,80,20);

p1=new JPanel();
p1.setLayout(null);
p1.setBorder(BorderFactory.createLineBorder(Color.gray));
p1.setBounds(350,10,300,200);
addButton.setBounds(lm+180,540,80,35);
updateButton.setBounds(lm+260,540,80,35);
deleteButton.setBounds(lm+340,540,80,35);
cancelButton.setBounds(lm+420,540,80,35);
p1.add(addButton);
p1.add(updateButton);
p1.add(deleteButton);
p1.add(cancelButton);
add(nameCaptionLabel);
add(nameLabel);
add(nameTextField);
add(clearNameTextFieldButton);
add(categoryCaptionLabel);
add(categoryLabel);
add(TabletRadioButton);
add(CapsuleRadioButton);
add(SyrupRadioButton);
add(PowderRadioButton);
add(InjectionRadioButton);
add(OtherRadioButton);
add(buyingCostCaptionLabel);
add(buyingCostLabel);
add(buyingCostTextField);
add(clearBuyingCostTextFieldButton);
add(MRPCaptionLabel);
add(MRPLabel);
add(MRPTextField);
add(clearMRPTextFieldButton);
add(traderNameCaptionLabel);
add(traderNameLabel);
add(traderNameTextField);
add(clearTraderNameTextFieldButton);
add(billNumberCaptionLabel);
add(billNumberLabel);
add(billNumberTextField);
add(clearBillNumberTextFieldButton);
add(manuMonthCaptionLabel);
add(manuMonthLabel);
add(manuMonthTextField);
add(clearManuMonthTextFieldButton);
add(manuYearCaptionLabel);
add(manuYearLabel);
add(manuYearTextField);
add(clearManuYearTextFieldButton);
add(exMonthCaptionLabel);
add(exMonthLabel);
add(exMonthTextField);
add(clearExMonthTextFieldButton);
add(exYearCaptionLabel);
add(exYearLabel);
add(exYearTextField);
add(clearExYearTextFieldButton);
add(billDateCaptionLabel);
add(billDateLabel);
add(billDateTextField);
add(clearBillDateTextFieldButton);
add(billMonthCaptionLabel);
add(billMonthLabel);
add(billMonthTextField);
add(clearBillMonthTextFieldButton);
add(billYearCaptionLabel);
add(billYearLabel);
add(billYearTextField);
add(clearBillYearTextFieldButton);
add(ammountOfMedicineCaptionLabel);
add(ammountOfMedicineLabel);
add(ammountOfMedicineTextField);
add(clearAmmountOfMedicineTextFieldButton);
add(p1); 
}

public void setMedicine(MedicineInterface medicine)
{
this.medicine=medicine;
if(medicine==null)
{
nameLabel.setText("");
categoryLabel.setText("");
buyingCostLabel.setText("");
MRPLabel.setText("");
traderNameLabel.setText("");
billNumberLabel.setText("");
manuMonthLabel.setText("");
manuYearLabel.setText("");
exMonthLabel.setText("");
exYearLabel.setText("");
billDateLabel.setText("");
billMonthLabel.setText("");
billYearLabel.setText("");
ammountOfMedicineLabel.setText("");
}
else
{
nameLabel.setText(medicine.getName().trim());
categoryLabel.setText(medicine.getCategory().trim());
buyingCostLabel.setText((medicine.getBuyingCost().toString()).trim());
MRPLabel.setText((medicine.getMRP().toString()).trim());
traderNameLabel.setText(medicine.getTraderName().trim());
billNumberLabel.setText(medicine.getBillNumber().trim());
manuMonthLabel.setText(medicine.getManuMonth().trim());
manuYearLabel.setText(medicine.getManuYear().trim());
exMonthLabel.setText(medicine.getExMonth().trim());
exYearLabel.setText(medicine.getExYear().trim());
billDateLabel.setText(medicine.getBillDate().trim());
billMonthLabel.setText(medicine.getBillMonth().trim());
billYearLabel.setText(medicine.getBillYear().trim());
ammountOfMedicineLabel.setText((Integer.toString(medicine.getAmmountOfMedicine())).trim());
}
}



private void setAppearance()
{
setBorder(BorderFactory.createLineBorder(Color.gray));
Font font=new Font("Verdana",Font.PLAIN,16);
nameCaptionLabel.setFont(font);
nameLabel.setFont(font);
nameTextField.setFont(font);
categoryLabel.setFont(font);
categoryCaptionLabel.setFont(font);
TabletRadioButton.setFont(font);
SyrupRadioButton.setFont(font);
PowderRadioButton.setFont(font);
CapsuleRadioButton.setFont(font);
InjectionRadioButton.setFont(font);
OtherRadioButton.setFont(font);
buyingCostCaptionLabel.setFont(font);
buyingCostLabel.setFont(font);
buyingCostTextField.setFont(font);
MRPCaptionLabel.setFont(font);
MRPLabel.setFont(font);
MRPTextField.setFont(font);
traderNameCaptionLabel.setFont(font);
traderNameLabel.setFont(font);
traderNameTextField.setFont(font);
billNumberCaptionLabel.setFont(font);
billNumberLabel.setFont(font);
billNumberTextField.setFont(font);
manuMonthCaptionLabel.setFont(font);
manuMonthLabel.setFont(font);
manuMonthTextField.setFont(font);
manuYearCaptionLabel.setFont(font);
manuYearLabel.setFont(font);
manuYearTextField.setFont(font);
exMonthCaptionLabel.setFont(font);
exMonthLabel.setFont(font);
exMonthTextField.setFont(font);
exYearCaptionLabel.setFont(font);
exYearLabel.setFont(font);
exYearTextField.setFont(font);
billDateCaptionLabel.setFont(font);
billDateLabel.setFont(font);
billDateTextField.setFont(font);
billMonthCaptionLabel.setFont(font);
billMonthLabel.setFont(font);
billMonthTextField.setFont(font);
billYearCaptionLabel.setFont(font);
billYearLabel.setFont(font);
billYearTextField.setFont(font);
ammountOfMedicineCaptionLabel.setFont(font);
ammountOfMedicineLabel.setFont(font);
ammountOfMedicineTextField.setFont(font);
}

private void addListeners()
{
addButton.addActionListener(this);
updateButton.addActionListener(this);
cancelButton.addActionListener(this);
deleteButton.addActionListener(this);
clearNameTextFieldButton.addActionListener(this);
clearBuyingCostTextFieldButton.addActionListener(this);
clearMRPTextFieldButton.addActionListener(this);
clearTraderNameTextFieldButton.addActionListener(this);
clearBillNumberTextFieldButton.addActionListener(this);
clearManuMonthTextFieldButton.addActionListener(this);
clearManuYearTextFieldButton.addActionListener(this);
clearExMonthTextFieldButton.addActionListener(this);
clearExYearTextFieldButton.addActionListener(this);
clearBillDateTextFieldButton.addActionListener(this);
clearBillMonthTextFieldButton.addActionListener(this);
clearBillYearTextFieldButton.addActionListener(this);
clearAmmountOfMedicineTextFieldButton.addActionListener(this);
}

private void setViewMode()
{
mode=VIEW_MODE;
nameTextField.setVisible(false);
clearNameTextFieldButton.setVisible(false);
nameLabel.setVisible(true);
categoryLabel.setVisible(true);
TabletRadioButton.setVisible(false);
CapsuleRadioButton.setVisible(false);
SyrupRadioButton.setVisible(false);
PowderRadioButton.setVisible(false);
InjectionRadioButton.setVisible(false);
OtherRadioButton.setVisible(false);
buyingCostTextField.setVisible(false);
clearBuyingCostTextFieldButton.setVisible(false);
buyingCostLabel.setVisible(true);
MRPTextField.setVisible(false);
clearMRPTextFieldButton.setVisible(false);
MRPLabel.setVisible(true);
traderNameTextField.setVisible(false);
clearTraderNameTextFieldButton.setVisible(false);
traderNameLabel.setVisible(true);
billNumberTextField.setVisible(false);
clearBillNumberTextFieldButton.setVisible(false);
billNumberLabel.setVisible(true);
manuMonthTextField.setVisible(false);
clearManuMonthTextFieldButton.setVisible(false);
manuMonthLabel.setVisible(true);
manuYearTextField.setVisible(false);
clearManuYearTextFieldButton.setVisible(false);
manuYearLabel.setVisible(true);
exMonthTextField.setVisible(false);
clearExMonthTextFieldButton.setVisible(false);
exMonthLabel.setVisible(true);
exYearTextField.setVisible(false);
clearExYearTextFieldButton.setVisible(false);
exYearLabel.setVisible(true);
billDateTextField.setVisible(false);
clearBillDateTextFieldButton.setVisible(false);
billDateLabel.setVisible(true);
billMonthTextField.setVisible(false);
clearBillMonthTextFieldButton.setVisible(false);
billMonthLabel.setVisible(true);
billYearTextField.setVisible(false);
clearBillYearTextFieldButton.setVisible(false);
billYearLabel.setVisible(true);
ammountOfMedicineTextField.setVisible(false);
clearAmmountOfMedicineTextFieldButton.setVisible(false);
ammountOfMedicineLabel.setVisible(true);
cancelButton.setEnabled(false);
addButton.setText("Add");
updateButton.setText("Edit");
addButton.setEnabled(true);
if(medicineModel.getRowCount()==0)
{
updateButton.setEnabled(false);
deleteButton.setEnabled(false);
}
else
{
updateButton.setEnabled(true);
deleteButton.setEnabled(true);
}
}


private void setAddMode()
{
mode=ADD_MODE;
nameTextField.setText("");
TabletRadioButton.setSelected(false);
CapsuleRadioButton.setSelected(false);
SyrupRadioButton.setSelected(false);
PowderRadioButton.setSelected(false);
InjectionRadioButton.setSelected(false);
OtherRadioButton.setSelected(false);
buyingCostTextField.setText("");
MRPTextField.setText("");
traderNameTextField.setText("");
billNumberTextField.setText("");
manuMonthTextField.setText("");
manuYearTextField.setText("");
exMonthTextField.setText("");
exYearTextField.setText("");
billDateTextField.setText("");
billMonthTextField.setText("");
billYearTextField.setText("");
ammountOfMedicineTextField.setText("");
nameLabel.setVisible(false);
categoryLabel.setVisible(false);
buyingCostLabel.setVisible(false);
MRPLabel.setVisible(false);
traderNameLabel.setVisible(false);
billNumberLabel.setVisible(false);
manuMonthLabel.setVisible(false);
manuYearLabel.setVisible(false);
exMonthLabel.setVisible(false);
exYearLabel.setVisible(false);
billDateLabel.setVisible(false);
billMonthLabel.setVisible(false);
billYearLabel.setVisible(false);
ammountOfMedicineLabel.setVisible(false);
nameTextField.setVisible(true);
clearNameTextFieldButton.setVisible(true);
TabletRadioButton.setVisible(true);
CapsuleRadioButton.setVisible(true);
SyrupRadioButton.setVisible(true);
PowderRadioButton.setVisible(true);
InjectionRadioButton.setVisible(true);
OtherRadioButton.setVisible(true);
buyingCostTextField.setVisible(true);
clearBuyingCostTextFieldButton.setVisible(true);
MRPTextField.setVisible(true);
clearMRPTextFieldButton.setVisible(true);
traderNameTextField.setVisible(true);
clearTraderNameTextFieldButton.setVisible(true);
billNumberTextField.setVisible(true);
clearBillNumberTextFieldButton.setVisible(true);
manuMonthTextField.setVisible(true);
clearManuMonthTextFieldButton.setVisible(true);
manuYearTextField.setVisible(true);
clearManuYearTextFieldButton.setVisible(true);
exMonthTextField.setVisible(true);
clearExMonthTextFieldButton.setVisible(true);
exYearTextField.setVisible(true);
clearExYearTextFieldButton.setVisible(true);
billDateTextField.setVisible(true);
clearBillDateTextFieldButton.setVisible(true);
billMonthTextField.setVisible(true);
clearBillMonthTextFieldButton.setVisible(true);
billYearTextField.setVisible(true);
clearBillYearTextFieldButton.setVisible(true);
ammountOfMedicineTextField.setVisible(true);
clearAmmountOfMedicineTextFieldButton.setVisible(true);
addButton.setText("Save");
updateButton.setEnabled(false);
cancelButton.setEnabled(true);
deleteButton.setEnabled(false);
}

private void setDeleteMode()
{
mode=DELETE_MODE;
addButton.setEnabled(false);
updateButton.setEnabled(false);
cancelButton.setEnabled(false);
deleteButton.setEnabled(false);
}

private void setEditMode()
{
mode=EDIT_MODE;
nameTextField.setText(medicine.getName());
TabletRadioButton.setSelected(false);
CapsuleRadioButton.setSelected(false);
SyrupRadioButton.setSelected(false);
PowderRadioButton.setSelected(false);
InjectionRadioButton.setSelected(false);
OtherRadioButton.setSelected(false);
if(medicine.getCategory().equals("Tablet")) TabletRadioButton.setSelected(true);
if(medicine.getCategory().equals("Capsule")) CapsuleRadioButton.setSelected(true);
if(medicine.getCategory().equals("Powder")) PowderRadioButton.setSelected(true);
if(medicine.getCategory().equals("Syrup")) SyrupRadioButton.setSelected(true);
if(medicine.getCategory().equals("Injection")) InjectionRadioButton.setSelected(true);
if(medicine.getCategory().equals("Other")) OtherRadioButton.setSelected(true);
buyingCostTextField.setText((medicine.getBuyingCost().toString()).trim());
MRPTextField.setText((medicine.getMRP().toString()).trim());
traderNameTextField.setText(medicine.getTraderName());
billNumberTextField.setText(medicine.getBillNumber());
manuMonthTextField.setText(medicine.getManuMonth());
manuYearTextField.setText(medicine.getManuYear());
exMonthTextField.setText(medicine.getExMonth());
exYearTextField.setText(medicine.getExYear());
billDateTextField.setText(medicine.getBillDate());
billMonthTextField.setText(medicine.getBillMonth());
billYearTextField.setText(medicine.getBillYear());
ammountOfMedicineTextField.setText((Integer.toString(medicine.getAmmountOfMedicine())).trim());


nameLabel.setVisible(false);
categoryLabel.setVisible(false);
buyingCostLabel.setVisible(false);
MRPLabel.setVisible(false);
traderNameLabel.setVisible(false);
billNumberLabel.setVisible(false);
manuMonthLabel.setVisible(false);
manuYearLabel.setVisible(false);
exMonthLabel.setVisible(false);
exYearLabel.setVisible(false);
billDateLabel.setVisible(false);
billMonthLabel.setVisible(false);
billYearLabel.setVisible(false);
ammountOfMedicineLabel.setVisible(false);

nameTextField.setVisible(true);
TabletRadioButton.setVisible(true);
CapsuleRadioButton.setVisible(true);
SyrupRadioButton.setVisible(true);
PowderRadioButton.setVisible(true);
InjectionRadioButton.setVisible(true);
OtherRadioButton.setVisible(true);
buyingCostTextField.setVisible(true);
MRPTextField.setVisible(true);
traderNameTextField.setVisible(true);
billNumberTextField.setVisible(true);
manuMonthTextField.setVisible(true);
manuYearTextField.setVisible(true);
exMonthTextField.setVisible(true);
exYearTextField.setVisible(true);
billDateTextField.setVisible(true);
billMonthTextField.setVisible(true);
billYearTextField.setVisible(true);
ammountOfMedicineTextField.setVisible(true);
clearNameTextFieldButton.setVisible(true);
clearBuyingCostTextFieldButton.setVisible(true);
clearMRPTextFieldButton.setVisible(true);
clearTraderNameTextFieldButton.setVisible(true);
clearBillNumberTextFieldButton.setVisible(true);
clearManuMonthTextFieldButton.setVisible(true);
clearManuYearTextFieldButton.setVisible(true);
clearExMonthTextFieldButton.setVisible(true);
clearExYearTextFieldButton.setVisible(true);
clearBillDateTextFieldButton.setVisible(true);
clearBillMonthTextFieldButton.setVisible(true);
clearBillYearTextFieldButton.setVisible(true);
clearAmmountOfMedicineTextFieldButton.setVisible(true);
updateButton.setText("Save");
addButton.setEnabled(false);
cancelButton.setEnabled(true);
deleteButton.setEnabled(false);
}

public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==clearNameTextFieldButton)
{
nameTextField.setText("");
nameTextField.requestFocus();
}
if(ev.getSource()==clearBuyingCostTextFieldButton)
{
buyingCostTextField.setText("");
buyingCostTextField.requestFocus();
}
if(ev.getSource()==clearMRPTextFieldButton)
{
MRPTextField.setText("");
MRPTextField.requestFocus();
}
if(ev.getSource()==clearTraderNameTextFieldButton)
{
traderNameTextField.setText("");
traderNameTextField.requestFocus();
}
if(ev.getSource()==clearBillNumberTextFieldButton)
{
billNumberTextField.setText("");
billNumberTextField.requestFocus();
}
if(ev.getSource()==clearManuMonthTextFieldButton)
{
manuMonthTextField.setText("");
manuMonthTextField.requestFocus();
}
if(ev.getSource()==clearManuYearTextFieldButton)
{
manuYearTextField.setText("");
manuYearTextField.requestFocus();
}
if(ev.getSource()==clearExMonthTextFieldButton)
{
exMonthTextField.setText("");
exMonthTextField.requestFocus();
}
if(ev.getSource()==clearExYearTextFieldButton)
{
exYearTextField.setText("");
exYearTextField.requestFocus();
}
if(ev.getSource()==clearBillDateTextFieldButton)
{
billDateTextField.setText("");
billDateTextField.requestFocus();
}
if(ev.getSource()==clearBillMonthTextFieldButton)
{
billMonthTextField.setText("");
billMonthTextField.requestFocus();
}
if(ev.getSource()==clearBillYearTextFieldButton)
{
billYearTextField.setText("");
billYearTextField.requestFocus();
}
if(ev.getSource()==clearAmmountOfMedicineTextFieldButton)
{
ammountOfMedicineTextField.setText("");
ammountOfMedicineTextField.requestFocus();
}

if(ev.getSource()==addButton)
{
if(mode==VIEW_MODE)
{
mode=ADD_MODE;
this.setAddMode();
MedicinePanel.this.setAddMode();
}
else //1
{
boolean check=true;
JTextField firstInvalidComponent=null;
String name=nameTextField.getText().trim();
String buyingCost=buyingCostTextField.getText().trim();
String MRP=MRPTextField.getText().trim();
String traderName=traderNameTextField.getText().trim();
String billNumber=billNumberTextField.getText().trim();
String manuMonth=manuMonthTextField.getText().trim();
String manuYear=manuYearTextField.getText().trim();
String exMonth=exMonthTextField.getText().trim();
String exYear=exYearTextField.getText().trim();
String billDate=billDateTextField.getText().trim();
String billMonth=billMonthTextField.getText().trim();
String billYear=billYearTextField.getText().trim();
String ammountOfMedicine=ammountOfMedicineTextField.getText().trim();

if(name.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"Name required");
}
if(buyingCost.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"Buying Cost required");
}
if(MRP.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"MRP required");
}
if(ammountOfMedicine.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"Ammount Of Medicine required");
}
try
{
Integer.parseInt(buyingCost);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"Buying Cost should be numeric");
buyingCostTextField.requestFocus();
return;
}
try
{
Integer.parseInt(MRP);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"MRP should be numeric");
MRPTextField.requestFocus();
return;
}
if(billNumber.length()!=0)
{
try
{
Integer.parseInt(billNumber);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"Bill Number should be numeric");
billNumberTextField.requestFocus();
return;
}
}
if(manuMonth.length()!=0)
{
try
{
Integer.parseInt(manuMonth);
JOptionPane.showMessageDialog(this,"Manufacturing Month should not be enterd in Number. It should be between January to December");
manuMonthTextField.requestFocus();
return;
}
catch(NumberFormatException numberFormatException)
{
}
}
if(manuMonth.length()!=0)
{
if(!(manuMonth.equalsIgnoreCase("january") || manuMonth.equalsIgnoreCase("february") || manuMonth.equalsIgnoreCase("march") || manuMonth.equalsIgnoreCase("april") || manuMonth.equalsIgnoreCase("may") || manuMonth.equalsIgnoreCase("june") || manuMonth.equalsIgnoreCase("july") || manuMonth.equalsIgnoreCase("august") || manuMonth.equalsIgnoreCase("september") || manuMonth.equalsIgnoreCase("october") || manuMonth.equalsIgnoreCase("november") || manuMonth.equalsIgnoreCase("december")))
{
JOptionPane.showMessageDialog(this,"Manufacturing Month should be between January to December");
manuMonthTextField.requestFocus();
return ;
}
}
if(exMonth.length()!=0)
{
try
{
Integer.parseInt(exMonth);
JOptionPane.showMessageDialog(this,"Expiry Month should not be enterd in Number. It should be between January to December");
exMonthTextField.requestFocus();
return;
}
catch(NumberFormatException numberFormatException)
{
}
}
if(exMonth.length()!=0)
{
if(!(exMonth.equalsIgnoreCase("january") || exMonth.equalsIgnoreCase("february") || exMonth.equalsIgnoreCase("march") || exMonth.equalsIgnoreCase("april") || exMonth.equalsIgnoreCase("may") || exMonth.equalsIgnoreCase("june") || exMonth.equalsIgnoreCase("july") || exMonth.equalsIgnoreCase("august") || exMonth.equalsIgnoreCase("september") || exMonth.equalsIgnoreCase("october") || exMonth.equalsIgnoreCase("november") || exMonth.equalsIgnoreCase("december")))
{
JOptionPane.showMessageDialog(this,"Expiry Month should be between January to December");
exMonthTextField.requestFocus();
return ;
}
}
if(billMonth.length()!=0)
{
try
{
Integer.parseInt(billMonth);
JOptionPane.showMessageDialog(this,"Bill Month should not be enterd in Number. It should be between January to December");
billMonthTextField.requestFocus();
return;
}
catch(NumberFormatException numberFormatException)
{
}
}
if(billMonth.length()!=0)
{
if(!(billMonth.equalsIgnoreCase("january") || billMonth.equalsIgnoreCase("february") || billMonth.equalsIgnoreCase("march") || billMonth.equalsIgnoreCase("april") || billMonth.equalsIgnoreCase("may") || billMonth.equalsIgnoreCase("june") || billMonth.equalsIgnoreCase("july") || billMonth.equalsIgnoreCase("august") || billMonth.equalsIgnoreCase("september") || billMonth.equalsIgnoreCase("october") || billMonth.equalsIgnoreCase("november") || billMonth.equalsIgnoreCase("december")))
{
JOptionPane.showMessageDialog(this,"Bill Month should be between January to December");
billMonthTextField.requestFocus();
return ;
}
}
try
{
Integer.parseInt(ammountOfMedicine);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"Ammount Of Medicine should be numeric");
ammountOfMedicineTextField.requestFocus();
return;
}
if(TabletRadioButton.isSelected()==false && CapsuleRadioButton.isSelected()==false && SyrupRadioButton.isSelected()==false && PowderRadioButton.isSelected()==false && InjectionRadioButton.isSelected()==false && OtherRadioButton.isSelected()==false)
{
JOptionPane.showMessageDialog(this,"Category required");
return;
}
if(check==false)
{
firstInvalidComponent.requestFocus();
return;
}
MedicineInterface medicine=new com.swastik.medical.inventory.bl.pojo.Medicine();
medicine.setName(name);
if(TabletRadioButton.isSelected()) medicine.setCategory("Tablet");	
if(SyrupRadioButton.isSelected()) medicine.setCategory("Syrup");	
if(CapsuleRadioButton.isSelected()) medicine.setCategory("Capsule");
if(PowderRadioButton.isSelected()) medicine.setCategory("Powder");
if(InjectionRadioButton.isSelected()) medicine.setCategory("Injection");
if(OtherRadioButton.isSelected()) medicine.setCategory("Other");
medicine.setBuyingCost(new java.math.BigDecimal(buyingCost));
medicine.setMRP(new java.math.BigDecimal(MRP));
medicine.setTraderName(traderName);
medicine.setBillNumber(billNumber);
medicine.setManuMonth(manuMonth);
medicine.setManuYear(manuYear);
medicine.setExMonth(exMonth);
medicine.setExYear(exYear);
medicine.setBillDate(billDate);
medicine.setBillMonth(billMonth);
medicine.setBillYear(billYear);
medicine.setAmmountOfMedicine(Integer.parseInt(ammountOfMedicine));
boolean s=medicineModel.findName(name);
if(s)
{
JOptionPane.showMessageDialog(this,"Medicine already exists");
return;
}
else
{
medicineModel.add(medicine);
int index=medicineModel.search(name);
table.setRowSelectionInterval(0,index);
table.scrollRectToVisible(new Rectangle(table.getCellRect(index,0,false)));
this.setViewMode();
MedicinePanel.this.setViewMode();
}
} //1
}

if(ev.getSource()==cancelButton)
{
this.setViewMode();
MedicinePanel.this.setViewMode();
}

if(ev.getSource()==deleteButton)
{
int selectedIndex=table.getSelectedRow();
if(selectedIndex<0)
{
JOptionPane.showMessageDialog(this,"Select a Medicine to delete");
return;
}          
this.setDeleteMode();
MedicinePanel.this.setDeleteMode();
int selectedOption;
this.medicine=medicineModel.getMedicineAt(selectedIndex);
selectedOption=JOptionPane.showConfirmDialog(this,"Delete : "+this.medicine.getName(),"Delete Confirmation",JOptionPane.YES_NO_OPTION);
if(selectedOption==JOptionPane.YES_OPTION)
{
String name=this.medicine.getName();
medicineModel.delete(name);
this.setMedicine(null);
JOptionPane.showMessageDialog(this,"Medicine : "+name+" deleted");
this.setViewMode();
MedicinePanel.this.setViewMode();
}
}

if(ev.getSource()==updateButton)
{
if(mode==VIEW_MODE)
{
int selectedRowIndex=table.getSelectedRow();
if(selectedRowIndex<0)
{
JOptionPane.showMessageDialog(this,"Select an medicine to edit");
return;
}
this.setEditMode();
MedicinePanel.this.setEditMode();
}
else
{
boolean check=true;
JTextField firstInvalidComponent=null;
String name=nameTextField.getText().trim();
String buyingCost=buyingCostTextField.getText().trim();
String MRP=MRPTextField.getText().trim();
String traderName=traderNameTextField.getText().trim();
String billNumber=billNumberTextField.getText().trim();
String manuMonth=manuMonthTextField.getText().trim();
String manuYear=manuYearTextField.getText().trim();
String exMonth=exMonthTextField.getText().trim();
String exYear=exYearTextField.getText().trim();
String billDate=billDateTextField.getText().trim();
String billMonth=billMonthTextField.getText().trim();
String billYear=billYearTextField.getText().trim();
String ammountOfMedicine=ammountOfMedicineTextField.getText().trim();

if(name.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"Name required");
}
if(buyingCost.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"Buying Cost required");
}
if(MRP.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"MRP required");
}
if(ammountOfMedicine.length()==0)
{
check=false;
firstInvalidComponent=nameTextField;
JOptionPane.showMessageDialog(this,"Ammount Of Medicine required");
}
try
{
Integer.parseInt(buyingCost);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"Buying Cost should be numeric");
buyingCostTextField.requestFocus();
return;
}
try
{
Integer.parseInt(MRP);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"MRP should be numeric");
MRPTextField.requestFocus();
return;
}
if(billNumber.length()!=0)
{
try
{
Integer.parseInt(billNumber);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"Bill Number should be numeric");
billNumberTextField.requestFocus();
return;
}
}
if(manuMonth.length()!=0)
{
try
{
Integer.parseInt(manuMonth);
JOptionPane.showMessageDialog(this,"Manufacturing Month should not be enterd in Number. It should be between January to December");
manuMonthTextField.requestFocus();
return;
}
catch(NumberFormatException numberFormatException)
{
}
}
if(manuMonth.length()!=0)
{
if(!(manuMonth.equalsIgnoreCase("january") || manuMonth.equalsIgnoreCase("february") || manuMonth.equalsIgnoreCase("march") || manuMonth.equalsIgnoreCase("april") || manuMonth.equalsIgnoreCase("may") || manuMonth.equalsIgnoreCase("june") || manuMonth.equalsIgnoreCase("july") || manuMonth.equalsIgnoreCase("august") || manuMonth.equalsIgnoreCase("september") || manuMonth.equalsIgnoreCase("october") || manuMonth.equalsIgnoreCase("november") || manuMonth.equalsIgnoreCase("december")))
{
JOptionPane.showMessageDialog(this,"Manufacturing Month should be between January to December");
manuMonthTextField.requestFocus();
return ;
}
}
if(exMonth.length()!=0)
{
try
{
Integer.parseInt(exMonth);
JOptionPane.showMessageDialog(this,"Expiry Month should not be enterd in Number. It should be between January to December");
exMonthTextField.requestFocus();
return;
}
catch(NumberFormatException numberFormatException)
{
}
}
if(exMonth.length()!=0)
{
if(!(exMonth.equalsIgnoreCase("january") || exMonth.equalsIgnoreCase("february") || exMonth.equalsIgnoreCase("march") || exMonth.equalsIgnoreCase("april") || exMonth.equalsIgnoreCase("may") || exMonth.equalsIgnoreCase("june") || exMonth.equalsIgnoreCase("july") || exMonth.equalsIgnoreCase("august") || exMonth.equalsIgnoreCase("september") || exMonth.equalsIgnoreCase("october") || exMonth.equalsIgnoreCase("november") || exMonth.equalsIgnoreCase("december")))
{
JOptionPane.showMessageDialog(this,"Expiry Month should be between January to December");
exMonthTextField.requestFocus();
return ;
}
}
if(billMonth.length()!=0)
{
try
{
Integer.parseInt(billMonth);
JOptionPane.showMessageDialog(this,"Bill Month should not be enterd in Number. It should be between January to December");
billMonthTextField.requestFocus();
return;
}
catch(NumberFormatException numberFormatException)
{
}
}
if(billMonth.length()!=0)
{
if(!(billMonth.equalsIgnoreCase("january") || billMonth.equalsIgnoreCase("february") || billMonth.equalsIgnoreCase("march") || billMonth.equalsIgnoreCase("april") || billMonth.equalsIgnoreCase("may") || billMonth.equalsIgnoreCase("june") || billMonth.equalsIgnoreCase("july") || billMonth.equalsIgnoreCase("august") || billMonth.equalsIgnoreCase("september") || billMonth.equalsIgnoreCase("october") || billMonth.equalsIgnoreCase("november") || billMonth.equalsIgnoreCase("december")))
{
JOptionPane.showMessageDialog(this,"Bill Month should be between January to December");
billMonthTextField.requestFocus();
return ;
}
}


try
{
Integer.parseInt(ammountOfMedicine);
}
catch(NumberFormatException numberFormatException)
{
JOptionPane.showMessageDialog(this,"Ammount Of Medicine should be numeric");
ammountOfMedicineTextField.requestFocus();
return;
}
if(TabletRadioButton.isSelected()==false && CapsuleRadioButton.isSelected()==false && SyrupRadioButton.isSelected()==false && PowderRadioButton.isSelected()==false && InjectionRadioButton.isSelected()==false && OtherRadioButton.isSelected()==false)
{
JOptionPane.showMessageDialog(this,"Category required");
return;
}
if(check==false)
{
firstInvalidComponent.requestFocus();
return;
}
MedicineInterface medicine=new com.swastik.medical.inventory.bl.pojo.Medicine();
medicine.setName(name);
if(TabletRadioButton.isSelected()) medicine.setCategory("Tablet");	
if(SyrupRadioButton.isSelected()) medicine.setCategory("Syrup");	
if(CapsuleRadioButton.isSelected()) medicine.setCategory("Capsule");
if(PowderRadioButton.isSelected()) medicine.setCategory("Powder");
if(InjectionRadioButton.isSelected()) medicine.setCategory("Injection");
if(OtherRadioButton.isSelected()) medicine.setCategory("Other");
medicine.setBuyingCost(new java.math.BigDecimal(buyingCost));
medicine.setMRP(new java.math.BigDecimal(MRP));
medicine.setTraderName(traderName);
medicine.setBillNumber(billNumber);
medicine.setManuMonth(manuMonth);
medicine.setManuYear(manuYear);
medicine.setExMonth(exMonth);
medicine.setExYear(exYear);
medicine.setBillDate(billDate);
medicine.setBillMonth(billMonth);
medicine.setBillYear(billYear);
medicine.setAmmountOfMedicine(Integer.parseInt(ammountOfMedicine));
try
{
medicineModel.update(medicine);
}
catch(Exception modelException)
{
JOptionPane.showMessageDialog(this,modelException.getMessage());
return;
}
int index=medicineModel.search(name);
table.setRowSelectionInterval(index,index);
table.scrollRectToVisible(new Rectangle(table.getCellRect(index,0,false)));
this.setViewMode();
MedicinePanel.this.setViewMode();
}
}
}
}//inner class end

//inner 2 start
class SellPanel extends JPanel implements ActionListener
{
//private JLabel logo,name,address;
//private JLabel mainLabel;
private JLabel patientNameLabel,medicineNameLabel,amountLabel;
private JLabel s1,s2,s3,s4,s5,s11,s22,s33,s44,s55;
private JTextField patientNameField;
private JTextField medicineNameField1,medicineNameField2,medicineNameField3,medicineNameField4,medicineNameField5;
private JTextField amountField1,amountField2,amountField3,amountField4,amountField5;
private JButton sellButton;
private JButton cancelSellButton;
//private SellModel sellModel;
SellPanel()
{
//sellModel=new SellModel();
initComponents();
setAppearance();
addListeners();
}
private void initComponents()
{
//ImageIcon imageIcon = new ImageIcon("logo.jpg");
//logo=new JLabel(imageIcon);
//name=new JLabel("SWASTIK  MEDICAL  STORE");
//address=new JLabel("244,DAULATGANJ,UJJAIN[M.P.]");
//mainLabel=new JLabel("SELL WINDOW");
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
cancelSellButton=new JButton("Cancel");
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
//logo.setBounds(lm+5,5,100,100);
//name.setBounds(lm+155,30,500,30);
//address.setBounds(lm+260,65,300,15);
//mainLabel.setBounds(lm+205,130,250,50);
patientNameLabel.setBounds(lm+70,20,300,30);
patientNameField.setBounds(lm+230,20,300,30);
medicineNameLabel.setBounds(lm+155,85,300,30);
medicineNameField1.setBounds(lm+75,120,300,30);
medicineNameField2.setBounds(lm+75,160,300,30);
medicineNameField3.setBounds(lm+75,200,300,30);
medicineNameField4.setBounds(lm+75,240,300,30);
medicineNameField5.setBounds(lm+75,280,300,30);
amountLabel.setBounds(lm+423,85,300,30);
amountField1.setBounds(lm+425,120,80,30);
amountField2.setBounds(lm+425,160,80,30);
amountField3.setBounds(lm+425,200,80,30);
amountField4.setBounds(lm+425,240,80,30);
amountField5.setBounds(lm+425,280,80,30);
s1.setBounds(lm+508,120,50,30);
s2.setBounds(lm+508,160,50,30);
s3.setBounds(lm+508,200,50,30);
s4.setBounds(lm+508,240,50,30);
s5.setBounds(lm+508,280,50,30);
s11.setBounds(lm+508,120,50,30);
s22.setBounds(lm+508,160,50,30);
s33.setBounds(lm+508,200,50,30);
s44.setBounds(lm+508,240,50,30);
s55.setBounds(lm+508,280,50,30);
sellButton.setBounds(lm+195,350,180,40);
cancelSellButton.setBounds(lm+195,405,180,40);
//add(logo);
//add(name);
//add(address);
//add(mainLabel);
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
add(cancelSellButton);
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
setBorder(BorderFactory.createLineBorder(Color.gray));
//Font nameFont=new Font("Verdana",Font.BOLD,30);
//name.setFont(nameFont);
//Font addressFont=new Font("Verdana",Font.BOLD,14);
//address.setFont(addressFont);
//Font mainLabelFont=new Font("Verdana",Font.BOLD,21);
//mainLabel.setFont(mainLabelFont);
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
cancelSellButton.setFont(buttonFont);
}

private void addListeners()
{
sellButton.addActionListener(this);	
cancelSellButton.addActionListener(this);
}


public void actionPerformed(ActionEvent ev)
{
if(ev.getSource()==cancelSellButton)
{
sellPanel.setVisible(false);
medicineDetailsPanel.setVisible(true);
}
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
success=medicineModel.sell(vPatientName,vMedicineName1,vAmount1);
if(success) s1.setVisible(true);
else s11.setVisible(true);
}
if(m2==1)
{
success=medicineModel.sell(vPatientName,vMedicineName2,vAmount2);
if(success) s2.setVisible(true);
else s22.setVisible(true);
}
if(m3==1)
{
success=medicineModel.sell(vPatientName,vMedicineName3,vAmount3);
if(success) s3.setVisible(true);
else s33.setVisible(true);
}
if(m4==1)
{
success=medicineModel.sell(vPatientName,vMedicineName4,vAmount4);
if(success) s4.setVisible(true);
else s44.setVisible(true);
}
if(m5==1)
{
success=medicineModel.sell(vPatientName,vMedicineName5,vAmount5);
if(success) s5.setVisible(true);
else s55.setVisible(true);
}
//System.out.println("fire ke pehle");
//medicineModel=new MedicineModel();
//medicineModel.fire();
//System.out.println("fire ke bd");
}catch(Exception e)
{
JOptionPane.showMessageDialog(this, "Some Medicine Not available");
System.out.println(e);
}
}
}
}
}


//inner 2 end

}//class userPanel end