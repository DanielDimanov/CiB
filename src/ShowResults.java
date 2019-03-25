import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class ShowResults extends JFrame {

	private JPanel contentPane;
	private JTable resultsTbl;

	public ShowResults() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		resultsTbl = new JTable();
		contentPane.add(resultsTbl);
	}
	public void tommorow(){
//		String n = "",e = "";      
//
//		DefaultTableModel model;
//		model = new DefaultTableModel(); 
//		jTable1 = new  JTable(model);
//
//		model.addColumn("Full Name");
//		model.addColumn("Email");
//
//		while(rs.next())  
//		{
//		    n = rs.getString("Full_Name");    
//		    e= rs.getString("Email");   
//		    model.addRow(new Object[]{n,e});
//		}
	}

}
