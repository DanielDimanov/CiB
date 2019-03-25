import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSplitPane;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JComboBox;

public class StageGUI extends JFrame {

	private JPanel contentPane;
	private Runner ctrl;
	private JTextField textField_1;
	private JLabel lblError;
	private JComboBox comboBox;

	public StageGUI(Runner ctrl) {
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 228, 235);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(java.awt.Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][][][grow][][][][][grow]", "[][][][][][]"));

		JLabel lblProjectId = new JLabel("Project Id");
		contentPane.add(lblProjectId, "cell 3 0");

		textField_1 = new JTextField();
		contentPane.add(textField_1, "cell 3 1,growx");
		textField_1.setColumns(10);

		JLabel lblEnterStage = new JLabel("Enter Stage");
		contentPane.add(lblEnterStage, "cell 3 2");
		
		lblError = new JLabel("ERROR");
		lblError.setForeground(Color.RED);
		lblError.setVisible(false);
		
		comboBox = new JComboBox();
		comboBox.addItem("Stage");
		comboBox.addItem("Start up");
		comboBox.addItem("Definition");
		comboBox.addItem("Delivery");
		comboBox.addItem("Warrenty");
		contentPane.add(comboBox, "cell 3 3,growx");
		contentPane.add(lblError, "cell 3 4");

		JButton btnSubmit = new JButton("Submit");
		contentPane.add(btnSubmit, "cell 3 5,alignx center,aligny center");
		btnSubmit.addActionListener(new SubmitHandler());
		setVisible(false);
		setBackground(java.awt.Color.WHITE);
	}
	class SubmitHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if(ctrl.changeStage(textField_1.getText(),comboBox.getSelectedItem().toString())){
				lblError.setVisible(false);
				comboBox.setSelectedIndex(0);
				textField_1.setText("");
				ctrl.hideStageGUI();
			}
			else{
				lblError.setVisible(true);
			}
		}
	}

}
