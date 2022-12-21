import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import IssueBookList.IssueBookList;
import IssueBookList.IssueBookListType;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Interface_4_ReturnBook {

	private JFrame frame;
	private JTextField DORtxt;

	public Interface_4_ReturnBook() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 546, 361);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(21, 37, 90, 40);
		frame.getContentPane().add(lblName);
		
		JComboBox<String> comboBox_1 = new JComboBox<String>();
		
		for(int i =0;i<IssueBookList.issueBookListArr.size();i++){
			if(IssueBookList.issueBookListArr.get(i).getDOR() == null || IssueBookList.issueBookListArr.get(i).getDOR() == ""){
				comboBox_1.addItem(IssueBookList.issueBookListArr.get(i).getUserName());
			}
		}
		
		comboBox_1.setBounds(152, 37, 161, 40);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblBookName = new JLabel("Book Name");
		lblBookName.setBounds(20, 106, 91, 40);
		frame.getContentPane().add(lblBookName);
		
		
		JComboBox<String> BookcomboBox = new JComboBox<String>();
		for(IssueBookListType item:IssueBookList.issueBookListArr){
			BookcomboBox.addItem(item.getBookname());
		}
		
		BookcomboBox.setBounds(152, 106, 161, 40);
		frame.getContentPane().add(BookcomboBox);
		
		JLabel DORlable = new JLabel("Return Date");
		DORlable.setBounds(20, 184, 91, 32);
		frame.getContentPane().add(DORlable);
		
		DORtxt = new JTextField();
		DORtxt.setBounds(152, 180, 161, 40);
		frame.getContentPane().add(DORtxt);
		DORtxt.setColumns(10);
		
		JButton ReturnBookbtn = new JButton("Return Book");
		ReturnBookbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(IssueBookListType item:IssueBookList.issueBookListArr){
					if(comboBox_1.getSelectedItem().toString() == item.getUserName() && BookcomboBox.getSelectedItem().toString() == item.getBookname()){
						item.setDOR(DORtxt.getText());
					}
				}
			}
		});
		ReturnBookbtn.setBounds(82, 241, 145, 53);
		frame.getContentPane().add(ReturnBookbtn);
		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(309, 241, 145, 53);
		frame.getContentPane().add(btnBack);
	}
}
