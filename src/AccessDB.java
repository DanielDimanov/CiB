
import java.sql.*;
import java.util.ArrayList;
public class AccessDB {
	Connection conn;
	ArrayList<String> list;
	public AccessDB(){
		try {
			String dbUrl="jdbc:ucanaccess://E:/Databases/CiB/KITS_TimeSheetDatabase_be.accdb";
			conn=DriverManager.getConnection(dbUrl,"","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<String> getResult(ResultSet rs){
		try {
			list=new ArrayList<String>();
			while (rs.next()) {
				for(int i=1;i<((rs.getMetaData()).getColumnCount())+1;i++)
				{
					list.add(rs.getString(i));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public ResultSet executeQ(String query){
		Statement s;
		ResultSet rs=null;
		try {
			s = conn.createStatement();
			rs = s.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public boolean updateRecord(String query){
		try{
			Statement s=this.conn.createStatement();
			s.executeUpdate(query);
			return true;
		}
		catch(SQLException e){
			return false;
		}
	}
	public boolean importRecord(String query){
		try{
			Statement s=this.conn.createStatement();
			s.execute(query);
			return true;
		}
		catch(SQLException e){
			return false;
		}
	}
}
