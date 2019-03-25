import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;


public class LoginGUI {
	private JLabel lblEmp_Num;
	private JTextField txtEmp_Num;
	private JButton btnLogin;
	private JButton btnHelp;
	private JPanel panel;
	private JFrame frame;
	private Runner ctrl;

	public LoginGUI(Runner ctrl){
		createForm();
		addFields();
		addButtons();
		this.ctrl=ctrl;

		frame.add(panel);
		frame.setVisible(true);
	}

	public void createForm() {
		frame = new JFrame();
		frame.setTitle("KITS Login");	
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		//		try {
		//			panel = new CoolPanel(ImageIO.read(new URL("http://smartplc.com/wp-content/uploads/2014/11/dw_730.jpg")));
		//		} catch (MalformedURLException e) {
		//			e.printStackTrace();
		//		} catch (IOException e) {
		//			e.printStackTrace();
		//		}
		panel.setBackground(Color.WHITE);
		frame.add (panel);
		panel.setLayout(null);
	}

	public void addFields() {
		lblEmp_Num = new JLabel("Employee Number");
		lblEmp_Num.setBounds(200, 130, 300, 20);
		panel.add(lblEmp_Num);

		txtEmp_Num = new JTextField("");
		txtEmp_Num.setBounds(180, 150, 150, 20);
		panel.add(txtEmp_Num);
	}

	public void addButtons(){
		btnLogin = new JButton ("Enter");
		btnLogin.setBounds(200, 205, 100, 50);
		btnLogin.addActionListener(new LoginHandler());
		panel.add (btnLogin);

		btnHelp = new JButton ("Help");
		btnHelp.setBounds(200, 255, 100, 50);
		btnHelp.addActionListener(new HelpHandler());
		panel.add (btnHelp);
	}
	class LoginHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("done");
			if(ctrl.loginInDb(txtEmp_Num.getText())){
				System.out.println("Success");
				ctrl.showMainEmpGUI();
				frame.setVisible(false);
			}
			txtEmp_Num.setText("");
		}
	}
	class HelpHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(frame, "Enter The Employee ID that was given to you on induction");
		}
	}
}