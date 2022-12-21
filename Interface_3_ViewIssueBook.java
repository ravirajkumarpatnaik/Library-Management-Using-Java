import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import IssueBookList.IssueBookList;
import IssueBookList.IssueBookListType;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Interface_3_ViewIssueBook {

	private JFrame frame;
	private JTable table;
	Object[][] data = null;
	Object[] colName = {
			"Name","Book Name","DOI","DOR","Price"
	};
	
	public Interface_3_ViewIssueBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 646, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(data,colName);
		model.setColumnIdentifiers(colName);
		
		table = new JTable(model);
		
		for(IssueBookListType item:IssueBookList.issueBookListArr){
			model.addRow(new Object[]{
					item.getUserName(),item.getBookname(),item.getDOI(),item.getDOR(),item.getPrice()
			});
		}
		
		table.setBounds(0, 0, 630, 368);
		frame.getContentPane().add(table);
		
		JButton backBtn = new JButton("Back");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		backBtn.setBounds(220, 379, 118, 48);
		frame.getContentPane().add(backBtn);
		frame.setVisible(true);
		
		
		
		
	}
}
