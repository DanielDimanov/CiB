import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

public class timeOffGUI extends JFrame {

	private JPanel contentPane;
	private JTextField reasonTF;
	private JTextField hoursOffTF;
	private JTextField descriptionTF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timeOffGUI frame = new timeOffGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public timeOffGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(java.awt.Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[][grow][grow][]", "[][][][][][][][]"));
		
		JLabel lblProjectId = new JLabel("Project ID");
		contentPane.add(lblProjectId, "cell 1 0");
		
		JComboBox ProjectsCB = new JComboBox();
		contentPane.add(ProjectsCB, "cell 1 1,growx");
		
		reasonTF = new JTextField();
		contentPane.add(reasonTF, "cell 2 1,growx");
		reasonTF.setColumns(10);
		
		JLabel label = new JLabel("");
		contentPane.add(label, "cell 3 1");
		
		JLabel lblHoursOff = new JLabel("Hours Off");
		contentPane.add(lblHoursOff, "cell 1 4");
		
		JLabel lblDescription = new JLabel("Description:");
		contentPane.add(lblDescription, "cell 2 4");
		
		hoursOffTF = new JTextField();
		contentPane.add(hoursOffTF, "cell 1 5,growx");
		hoursOffTF.setColumns(10);
		
		descriptionTF = new JTextField();
		contentPane.add(descriptionTF, "cell 2 5,growx");
		descriptionTF.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		contentPane.add(btnSubmit, "cell 1 7");
		setBackground(java.awt.Color.WHITE);
	}

}
