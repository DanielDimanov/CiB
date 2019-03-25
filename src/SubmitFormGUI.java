import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SubmitFormGUI extends JFrame {

	private JPanel contentPane;
	private JTextField timeSubmit;
	private JTextField hoursWorkedTF;
	private Runner ctrl;
	private JButton btnSubmit;
	private JLabel lblCurrentDate;
	private JLabel lblHoursYouHave;
	private JLabel lblAnyComents;
	private JTextField comentsTF;
	private JButton btnExitWithoutSaving;
	JComboBox<String> PMCB;
	JComboBox<String> taskIdCB;

	public SubmitFormGUI(Runner ctrl) {
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(java.awt.Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[73px][31px][119px,grow][134px][50px][45px][50px][73px]", "[22px][25px][][][][][][][][][grow]"));

		lblCurrentDate = new JLabel("Current Date");
		lblCurrentDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblCurrentDate, "cell 0 2,alignx left,aligny center");

		lblHoursYouHave = new JLabel("Hours you have worked");
		lblHoursYouHave.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblHoursYouHave, "cell 6 2,alignx left,aligny center");

		timeSubmit = new JTextField();

		timeSubmit.setToolTipText("Enter the date");
		contentPane.add(timeSubmit, "cell 0 3,alignx left,aligny top");
		timeSubmit.setColumns(10);

		hoursWorkedTF = new JTextField();
		hoursWorkedTF.setToolTipText("Hours worked");
		contentPane.add(hoursWorkedTF, "cell 6 3,alignx left,aligny top");
		hoursWorkedTF.setColumns(10);

		PMCB = new JComboBox<String>();
		PMCB.addItem("PM ID");
		for(String s:ctrl.addAllPMIDs()){
			PMCB.addItem(s);
		}
		PMCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(PMCB, "cell 0 5,alignx left,aligny center");

		taskIdCB = new JComboBox<String>();
		taskIdCB.addItem("Task ID");
		for(String s:ctrl.addAllTaskIDs()){
			taskIdCB.addItem(s);
		}
		taskIdCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		taskIdCB.setToolTipText("Task ID");
		contentPane.add(taskIdCB, "cell 6 5,alignx left,aligny center");

		lblAnyComents = new JLabel("Any Coments:");
		lblAnyComents.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(lblAnyComents, "cell 0 8,alignx trailing,aligny center");

		comentsTF = new JTextField();
		contentPane.add(comentsTF, "cell 0 9 3 1,growx");
		comentsTF.setColumns(1);

		btnSubmit = new JButton("    Submit    ");
		btnSubmit.addActionListener(new SubmitHandler());
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnSubmit, "cell 6 9,alignx center,aligny center");

		btnExitWithoutSaving = new JButton("Exit Without Saving");
		btnExitWithoutSaving.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnExitWithoutSaving, "cell 3 10");
		btnExitWithoutSaving.addActionListener(new GoBack());
		setVisible(false);
		setBackground(java.awt.Color.WHITE);
	}
	class SubmitHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ctrl.insertTimesheet(PMCB.getSelectedItem().toString(),taskIdCB.getSelectedItem().toString(),timeSubmit.getText(),hoursWorkedTF.getText(),comentsTF.getText());
			ctrl.hideForm();
			PMCB.setSelectedIndex(0);
			taskIdCB.setSelectedIndex(0);
			timeSubmit.setText("");
			hoursWorkedTF.setText("");
		}

	}
	class GoBack implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			ctrl.hideTimesheet();
		}

	}

}
