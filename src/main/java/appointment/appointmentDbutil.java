package appointment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class appointmentDbutil {
	
	private static ResultSet rs =null;
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static boolean isSuccess;
	
	public static boolean insertappointment(String servicetype,String des,String requiredtime,String requireddate,String cid ) {
	
		boolean isSuccess = false;
		 
		 try {
			
				
			con = DBConnect.getConnection();
			stmt =con.createStatement();
			
			String sql = "insert into appointment values (0,'"+servicetype+"','"+ des+"','"+requiredtime+"','"+requireddate+"','"+cid+"')";
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
				isSuccess = true;
			}
			else {
				
				isSuccess = false;
			}	
		 }
		catch(Exception e) {
			e.printStackTrace();
		}
	    return isSuccess;
	}




	public static List<appointment> getAppointment(String cid) {
		
		int Cid = Integer.parseInt(cid);
		ArrayList<appointment> app = new ArrayList<>();
		
		
		//Validate
		try {
			
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			
			String sql = "select * from appointment where Cid= '"+Cid+"' order by Apo_id desc limit 1;" ;
			
			 rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				int apoid = rs.getInt(1);
				String servicetype = rs.getString(2);
				String description = rs.getString(3);
				String timeslot = rs.getString(4);
				Date requireddate = rs.getDate(5);
				int CID = rs.getInt(6);
				
				appointment c = new appointment(apoid,servicetype,description,timeslot,requireddate,CID);
				 app.add(c);
		 
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}
		
		
		return app;
		
		
	}
	




public static boolean validate1(String apoid)
{
try {
	con=DBConnect.getConnection();
	stmt =con.createStatement();

	String sql = "select * from appointment where Apo_id = '"+apoid+"' " ;
	rs= stmt.executeQuery(sql);

	if(rs.next())
	{
		isSuccess=true;
	
	}
	else
	{
		isSuccess=false;
	}


	}catch(Exception e)
{
	e.printStackTrace();
}

return isSuccess;
}




	public static List<appointment> getappointment (String cid){
		
		int cid1 = Integer.parseInt(cid);
		ArrayList<appointment> apo = new ArrayList<>();
		
		
		//Validate
		try {
			
			 con = DBConnect.getConnection();
			 stmt = con.createStatement();
			
			 String sql = "select * from appointment where Cid = '"+cid1+"' " ;
			
			 rs = stmt.executeQuery(sql);
			
			
			while(rs.next()) {
				 int apo_id = rs.getInt(1);
				String  servicetype = rs.getString(2);
				String description = rs.getString(3);
				String timeslot = rs.getString(4);
				Date requireddate = rs.getDate(5);
				int CID = rs.getInt(6);
				
				 appointment c = new appointment(apo_id,servicetype,description,timeslot,requireddate,CID);
				 apo.add(c); 
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}
		return apo;
	}
	
	
//UPDATE

public static boolean update_appointment_details(String apoid, String servicetype, String description, String timeslot, String requireddate, String cid) {
	
	boolean isSuccess = false;
	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "update appointment set Service_type='"+servicetype+"',description='"+description+"',Time_slot='"+timeslot+"',Required_date='"+requireddate+"' where Apo_id='"+apoid+"'";
    		int rs = stmt.executeUpdate(sql);
    		
    		if(rs > 0) {
    			isSuccess = true;
    		}
    		else {
    			isSuccess = false;
    		}
    		
    	}
    	catch(Exception e) { 
    		e.printStackTrace();
    	}
    	
    	return isSuccess;
    }
 
    public static List<appointment> getappointment_details(String apoid1) {
    	
    	int convertedID = Integer.parseInt(apoid1);
    	
    	ArrayList<appointment> upd = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from customer where id='"+convertedID+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int apoid = rs.getInt(1);
 				String  servicetype = rs.getString(2);
 				String description = rs.getString(3);
 				String timeslot = rs.getString(4);
 				Date requireddate = rs.getDate(5);
 				int CID = rs.getInt(6);
    			
    			appointment c = new appointment(apoid,servicetype,description,timeslot ,requireddate,CID);
    			upd.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	
    	return upd;	
    }

	public static boolean delete(String apoid) {
		
    	int convertedID = Integer.parseInt(apoid);
	
		try {
			
			con = DBConnect.getConnection();
    		stmt = con.createStatement();
			String sql = "delete from appointment where Apo_id='"+convertedID+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs > 0) {
			isSuccess = true;
			}
			
			else {
			isSuccess = false;
			}
			
			}
			catch (Exception e) {
			e.printStackTrace();
			
			}
			return isSuccess;
	}




public static List<appointment> getreport(String date) {
		
		ArrayList<appointment> upd = new ArrayList<>();
    	
    	try {
    		
    		con = DBConnect.getConnection();
    		stmt = con.createStatement();
    		String sql = "select * from appointment where Required_date='"+date+"'";
    		rs = stmt.executeQuery(sql);
    		
    		while(rs.next()) {
    			int apoid = rs.getInt(1);
 				String  servicetype = rs.getString(2);
 				String description = rs.getString(3);
 				String timeslot = rs.getString(4);
 				Date requireddate = rs.getDate(5);
				int CID = rs.getInt(6);
    			
    			appointment c = new appointment(apoid,servicetype,description,timeslot ,requireddate,CID);
    			upd.add(c);
    		}
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}	
    	
    	return upd;	
		
		
	}

	}





