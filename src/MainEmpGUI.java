import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.prism.paint.Color;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;

public class MainEmpGUI extends JFrame {

	private JPanel contentPane;
	private Runner ctrl;
	
	public MainEmpGUI(Runner ctrl) {
		this.ctrl=ctrl;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 453);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(java.awt.Color.WHITE);
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[83px][][][][][][][][][][][][][153px][][][][][][][][][]", "[25px][25px][25px][25px][][][][][][][][][]"));
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(java.awt.Color.WHITE);
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSubmit.addActionListener(new TimesheetHandler());
		contentPane.add(btnSubmit, "cell 0 2 14 2,alignx center,aligny center");
		
		JButton btnStage = new JButton("Stage");
		btnStage.setBackground(java.awt.Color.WHITE);
		btnStage.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStage.addActionListener(new StageHandler());
		
		JButton btnShowActiveProjects = new JButton("Show Active projects");
		btnShowActiveProjects.setBackground(java.awt.Color.WHITE);
		btnShowActiveProjects.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShowActiveProjects.addActionListener(new ShowActiveProjectsHandler());
		contentPane.add(btnShowActiveProjects, "cell 19 2 2 3,alignx center,aligny center");
		btnShowActiveProjects.addActionListener(new ShowAllProjectsHandler());
		btnShowActiveProjects.addActionListener(new TimeOffHandler());
		contentPane.add(btnStage, "cell 0 6 14 2,alignx center,aligny center");
		
		JButton btnShowAllProjects = new JButton("Show All Projects");
		btnShowAllProjects.setBackground(java.awt.Color.WHITE);
		btnShowAllProjects.setFont(new Font("Tahoma", Font.PLAIN, 20));
		contentPane.add(btnShowAllProjects, "cell 19 6 2 3,alignx center,aligny center");
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(java.awt.Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		contentPane.add(btnExit, "cell 19 11 2 2,alignx center");
		
		JButton btnTimeoff = new JButton("Time-Off");
		btnTimeoff.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnTimeoff.setBackground(java.awt.Color.WHITE);
		contentPane.add(btnTimeoff, "cell 11 12,alignx center,aligny center");
		setVisible(false);
		setBackground(java.awt.Color.WHITE);
	}
	class TimesheetHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			ctrl.showTimeSheetFormGUI();
		}
	}
	class StageHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			ctrl.showStageGUI();
		}
	}
	class ShowActiveProjectsHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("done");
		}
	}
	class ShowAllProjectsHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("done");
		}
	}
	class TimeOffHandler implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			System.out.println("done");
		}
	}

}
