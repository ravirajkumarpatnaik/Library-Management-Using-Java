import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

import IssueBookList.IssueBookList;
import IssueBookList.IssueBookListType;
import booklist.bookDetails;
import booklist.bookItemType;

import javax.swing.JOptionPane;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interface_2_IssueBook extends JFrame{

	private JFrame frame;
	private JTextField personNametxt,dateOfIssuetxt;
	public JComboBox<String> bookComboBox;
	
	public Interface_2_IssueBook() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.control);
		frame.setVisible(true);
		frame.setTitle("Issue Pannel");
		frame.setBounds(100, 100, 642, 409);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel NameLabel = new JLabel("Name");
		NameLabel.setBounds(10, 11, 119, 39);
		frame.getContentPane().add(NameLabel);
		
		JLabel BookNameLabel = new JLabel("Book Name");
		BookNameLabel.setBounds(10, 73, 119, 39);
		frame.getContentPane().add(BookNameLabel);
		
		JLabel lblDateOfIsuue = new JLabel("Date of Isuue");
		lblDateOfIsuue.setBounds(10, 150, 119, 39);
		frame.getContentPane().add(lblDateOfIsuue);
		
		personNametxt = new JTextField();
		personNametxt.setBounds(106, 15, 171, 30);
		frame.getContentPane().add(personNametxt);
		personNametxt.setColumns(10);
		
		bookComboBox = new JComboBox<String>();

		bookDetails obj = new bookDetails();
		
		for(int i=0;i<obj.booklist.size();i++){
			bookComboBox.addItem(obj.booklist.get(i).getbName());
		}
		
		bookComboBox.setBounds(106, 75, 171, 34);
		frame.getContentPane().add(bookComboBox);
		
		dateOfIssuetxt = new JTextField();
		dateOfIssuetxt.setBounds(106, 154, 171, 30);
		frame.getContentPane().add(dateOfIssuetxt);
		dateOfIssuetxt.setColumns(10);
		
		JButton issuebtn = new JButton("Issue");
		issuebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n1 = personNametxt.getText();
				String n2 = bookComboBox.getSelectedItem().toString();
				String n3 = dateOfIssuetxt.getText();
				String n4 = null;
				String n5 = null;
				for(bookItemType item : bookDetails.booklist){
					if(n2==item.getbName()){
						n5 = item.getPrice();
					}
				}
				
				onClickIssue(n1, n2, n3, n4, n5);
			}
		});
		issuebtn.setBounds(393, 40, 154, 39);
		frame.getContentPane().add(issuebtn);
		
		JButton clearbtn = new JButton("Clear");
		clearbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onClickClear();
			}
		});
		clearbtn.setBounds(393, 121, 154, 39);
		frame.getContentPane().add(clearbtn);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(393, 204, 154, 39);
		frame.getContentPane().add(btnNewButton_2);
	}
	
	void onClickIssue(String name, String bName,String DOI,String DOR,String Price){
		JOptionPane.showMessageDialog(null, "Book Issued\nBookname = " + bName + "\nDate of Issue = " + DOI + "\nPrice = " + Price);
		IssueBookList.issueBookListArr.add(new IssueBookListType(name ,bName, DOI,DOR, Price));
	}
	void onClickClear(){
		personNametxt.setText("");
		dateOfIssuetxt.setText("");
		bookComboBox.setSelectedIndex(0);
	}
}
