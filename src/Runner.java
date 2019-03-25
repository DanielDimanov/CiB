import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Runner {
	protected AccessDB connection;
	private ArrayList<String> empIds;
	private String loggedID;
	LoginGUI loginScreen;
	MainEmpGUI empMainGui;
	SubmitFormGUI timesheetGUI;
	StageGUI stageGUI;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	Runner mainRun=new Runner();
				mainRun.makeConnection();
				mainRun.createLoginGUI();
				mainRun.createMainEmpGUI();
				mainRun.CreateSubmitFormGUI();
				mainRun.createStageGUI();
		    }}
		);
	}
	public Runner(){
		empIds=new ArrayList<String>();
	}
	public void createStageGUI(){
		stageGUI=new StageGUI(this);
	}
	public void showStageGUI(){
		stageGUI.setVisible(true);
	}
	public void createLoginGUI(){
    	loginScreen=new LoginGUI(this);
	}
	public void createMainEmpGUI(){
    	empMainGui=new MainEmpGUI(this);
	}
	public void CreateSubmitFormGUI(){
		timesheetGUI=new SubmitFormGUI(this);
	}
	public void showMainEmpGUI(){
		empMainGui.setVisible(true);
	}
	public void makeConnection(){
		connection=new AccessDB();
	}
	public boolean loginInDb(String empId){
		empIds=executeCommand("Select emp_ID From tbl_EMP");
		for(String a:empIds){
			if(empId.equals(a)){
				loggedID=a;
				System.out.println(loggedID);
				return true;
			}
		}
		return false;
	}
	public ArrayList<String> executeCommand(String command){
		
		return connection.getResult(connection.executeQ(command));
	}
	public void showTimeSheetFormGUI() {
		timesheetGUI.setVisible(true);
	}
	public boolean changeStage(String proj,String state) {
		System.out.println(executeCommand("Select Project_stage From tbl_Project"));
		return updateRecord("Update tbl_Project SET Project_stage='"+state+"' Where Project_ID='"+proj+"'");
	}
	private boolean updateRecord(String string) {
			return connection.updateRecord(string);
	}
	public void hideStageGUI() {
		stageGUI.setVisible(false);	
	}
	public ArrayList<String> addAllPMIDs() {
		return executeCommand("Select PM_ID From tbl_PM");
	}
	public ArrayList<String> addAllTaskIDs() {
		return executeCommand("Select Task_ID From tbl_task");
	}
	public void hideTimesheet() {
		timesheetGUI.setVisible(false);	
	}
	public boolean insertTimesheet(String PMID, String TaskID, String timeSubmitted, String hoursWorked, String comments) {
		ArrayList<String>PROJID=executeCommand("Select Project_ID FROM tbl_task WHERE Task_ID='"+TaskID+"'");
		int hours;
		int tsID;
		try{
			tsID=Integer.parseInt(executeCommand("Select COUNT(TS_ID) FROM tbl_TimeSheet").get(0))+1;
			hours=Integer.parseInt(hoursWorked);
		}
		catch(Exception e){
			return false;
		}
		System.out.println(executeCommand("Select Task_ID From tbl_task"));
		return updateRecord("INSERT INTO tbl_TimeSheet (TS_ID,Emp_ID,PM_ID,Project_ID,Hours_Worked,Date_Submit,"
				+ "notes,approved) VALUES('"+tsID+"','"+TaskID+"','"+loggedID+"','"+PMID+"','"+PROJID.get(0)+"','"+hours+"','"+comments+"','"+"'true"+"')");
	}
	public void hideForm() {
		timesheetGUI.setVisible(false);
	}

}
