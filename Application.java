import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import LoginDetail.LoginDetail;

import javax.swing.JPasswordField;
import java.awt.Button;

public class Application {

	private JFrame frame;
	private JTextField userTextField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Application window = new Application();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error in Application file");
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Application() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 291, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 37, 61, 28);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(10, 129, 61, 28);
		frame.getContentPane().add(lblNewLabel_1);
		
		userTextField = new JTextField();
		userTextField.setBounds(109, 31, 119, 41);
		frame.getContentPane().add(userTextField);
		userTextField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(109, 123, 119, 41);
		frame.getContentPane().add(passwordField);
		
		Button loginButton = new Button("Login");
		loginButton.setBounds(58, 196, 94, 45);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String username = userTextField.getText();
				@SuppressWarnings("deprecation")
				String password = passwordField.getText();
				
				if(username.equals("")){
					JOptionPane.showMessageDialog(null,"Please enter username");
				}
				else if(password.equals("")){
					JOptionPane.showMessageDialog(null,"Please enter password");
				}
				
				else{
					LoginDetail obj = new LoginDetail();
					try {
						boolean TF = false;
						TF = obj.searchUser(username, password);
						if(TF == true){
							@SuppressWarnings("unused")
							Interface_1_ButtonOption page_1 = new Interface_1_ButtonOption();
						}
						else 
							JOptionPane.showMessageDialog(null, "Enrter a valid username/password");
						}
					catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Error in Login");
					}
				}
			}
		});
	}
}
