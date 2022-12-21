import javax.swing.JFrame;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

import IssueBookList.IssueBookListType;

public class Interface_1_ButtonOption extends JFrame{
	String name,authName,date,bookName = null;
	
	public static ArrayList<IssueBookListType> issueBookList = new ArrayList<>();
	
	public Interface_1_ButtonOption() {
		
		getContentPane().setBackground(SystemColor.control);
		setVisible(true);
		setTitle("User Interface");
		setSize(500,475);
		getContentPane().setLayout(null);
		
		Button IssueBotton = new Button("Issue Book");
		IssueBotton.setBackground(Color.LIGHT_GRAY);
		IssueBotton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickIssueButton();
			}
		});
		IssueBotton.setBounds(29, 34, 104, 51);
		getContentPane().add(IssueBotton);
		
		
		Button ViewIssuedBookButton = new Button("View Issued Books");
		ViewIssuedBookButton.setBackground(Color.LIGHT_GRAY);
		ViewIssuedBookButton.setBounds(181, 34, 104, 51);
		getContentPane().add(ViewIssuedBookButton);
		ViewIssuedBookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickViewIssuedBook();
			}
		});
		
		Button ReturnButton = new Button("Return Book");
		ReturnButton.setBackground(Color.LIGHT_GRAY);
		ReturnButton.setBounds(345, 34, 104, 51);
		getContentPane().add(ReturnButton);
		ReturnButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				onClickReturnBook();
			}
		});
	}
	
	void onClickIssueButton(){
		Interface_2_IssueBook page2 = new Interface_2_IssueBook();
	}
	
	void onClickViewIssuedBook(){
		Interface_3_ViewIssueBook page3 = new Interface_3_ViewIssueBook();
	}
	void onClickReturnBook(){
		Interface_4_ReturnBook page4 = new Interface_4_ReturnBook();
	}
}

