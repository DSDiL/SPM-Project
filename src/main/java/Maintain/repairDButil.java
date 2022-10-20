package techscope;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class repairDButil {
	
	public static boolean Success;
	private static  Connection con=null;
	private static  Statement stmt=null;
	private static ResultSet rs=null;
	
	public static boolean insertHardwareRepair(String cID,String appID, String com,  String date,String des, String cost) {

		Success=false;
		
		int cid = Integer.parseInt(cID);
		int appid= Integer.parseInt(appID);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_hardware values(0,'"+cid+"','"+com+"','"+date+"','"+des+"','"+total+"')";
			String sql2="DELETE FROM darkshop.appointment WHERE Apo_id = '"+appid+"'";
			int rs =stmt.executeUpdate(sql);
			int rs2=stmt.executeUpdate(sql2);

			if(rs>0 && rs2>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	public static boolean insertSoftRepair(String cID,String appID, String com, String date, String des, String cost) {
		
		Success=false;
		
		int cid = Integer.parseInt(cID);
		int appid= Integer.parseInt(appID);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_soft values(0,'"+cid+"','"+com+"','"+date+"','"+des+"','"+total+"')";
			String sql2="DELETE FROM darkshop.appointment WHERE Apo_id = '"+appid+"'";
			int rs =stmt.executeUpdate(sql);
			int rs2=stmt.executeUpdate(sql2);

			if(rs>0 && rs2>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	public static boolean insertOtherRepair(String cID,String appID, String com, String date, String des, String cost) {

		Success=false;
		
		int cid = Integer.parseInt(cID);
		int appid= Integer.parseInt(appID);
		float total = Float.parseFloat(cost);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_other values(0,'"+cid+"','"+com+"','"+date+"','"+des+"','"+total+"')";
			String sql2="DELETE FROM darkshop.appointment WHERE Apo_id = '"+appid+"'";
			int rs =stmt.executeUpdate(sql);
			int rs2=stmt.executeUpdate(sql2);

			if(rs>0 && rs2>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	

	
	
	public static List<onGoingSoftware> searchOngoingSoftware(String rid, String type) {
		
		ArrayList<onGoingSoftware> onGoingSoftware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_soft where raID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				float cost = rs.getFloat(6);
					
				System.out.println(cost);
				
				onGoingSoftware o = new onGoingSoftware (raID, cID, company, date, description,  cost, type);
				onGoingSoftware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingSoftware;	
	}

	public static List<onGoingHardware> searchOngoingHardware(String rid, String type) {

		ArrayList<onGoingHardware> onGoingHardware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_hardware where rcID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				
				
				float cost = rs.getFloat(6);
									
				onGoingHardware o = new onGoingHardware (rcID, cID, company,  date, description,  cost);
				onGoingHardware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingHardware;
	}

	public static List<onGoingOther> searchOngoingOther(String rid, String type) {

		ArrayList<onGoingOther> onGoingOther = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_other where roID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				
				String description = rs.getNString(5);					
				
				
				float cost = rs.getFloat(6);
									
				onGoingOther o = new onGoingOther (roID, cID, company, date,  description,  cost);
				onGoingOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingOther;
	}

	

	
	
	public static boolean updateSoftwareRepair(String raID, String cID, String com, String date, String des, String cost) {
		
		int raid = Integer.parseInt(raID);
		int cid = Integer.parseInt(cID);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql = "update repair_soft set cID='"+cid+"', company='"+com+"', date='"+date+"', description='"+des+"', cost='"+total+"' where raID='"+raid+"'";
			int rs=stmt.executeUpdate(sql);

			if(rs>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	public static boolean updateHardwareRepair(String rcID, String cID, String com, String date, String des, String cost) {

		int rcid = Integer.parseInt(rcID);
		int cid = Integer.parseInt(cID);
		
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql = "update repair_hardware set cID='"+cid+"', company='"+com+"', date='"+date+"', description='"+des+"',  cost='"+total+"' where rcID='"+rcid+"'";
			int rs=stmt.executeUpdate(sql);

			if(rs>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	public static boolean updateOtherRepair(String roID, String cID, String com, String date, String des,  String cost) {

		int roid = Integer.parseInt(roID);
		int cid = Integer.parseInt(cID);

		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql = "update repair_other set cID='"+cid+"', company='"+com+"', date='"+date+"',  description='"+des+"', cost='"+total+"' where roID='"+roid+"'";
			int rs=stmt.executeUpdate(sql);

			if(rs>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	

	
	
	public static boolean insertCompletedSoftware(String raID, String cID, String com, String date, String des,  String cost, LocalDate comDate) {

		Success=false;
		
		int raid = Integer.parseInt(raID);
		int cid = Integer.parseInt(cID);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_software_completed values('"+raid+"','"+cid+"','"+com+"','"+date+"','"+des+"','"+total+"','"+comDate+"')";
			int rs=stmt.executeUpdate(sql);

			if(rs>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	public static boolean insertCompletedHardware(String rcID, String cID, String com, String date, String des,  String cost, LocalDate comDate) {

		Success=false;
		
		int rcid = Integer.parseInt(rcID);
		int cid = Integer.parseInt(cID);
	
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_hardware_completed values('"+rcid+"','"+cid+"','"+com+"','"+date+"','"+des+"','"+total+"','"+comDate+"')";
			int rs=stmt.executeUpdate(sql);

			if(rs>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	public static boolean insertComputerOtherRepair(String roID, String cID, String com, String date,  String des, String cost, LocalDate comDate) {

		Success=false;
		
		int roid = Integer.parseInt(roID);
		int cid = Integer.parseInt(cID);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_other_completed values('"+roid+"','"+cid+"','"+com+"','"+date+"','"+des+"','"+total+"','"+comDate+"')";
			int rs=stmt.executeUpdate(sql);

			if(rs>0){
				Success=true;
			}
			else{
				Success=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Success;
	}

	

	
	
	public static boolean removeOngoingSoftware(String raID) {

		int raid = Integer.parseInt(raID);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from repair_soft where raID='"+raid+"'";
			
			int rs=stmt.executeUpdate(sql);
			
			if (rs > 0) {
				Success = true;
			}
			else {
				Success = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Success;
	}

	public static boolean removeOngoingHardware(String rcID) {

		int rcid = Integer.parseInt(rcID);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from repair_hardware where rcID='"+rcid+"'";
			
			int rs=stmt.executeUpdate(sql);
			
			if (rs > 0) {
				Success = true;
			}
			else {
				Success = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Success;
	}

	public static boolean removeOngoingOther(String roID) {

		int roid = Integer.parseInt(roID);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from repair_other where roID='"+roid+"'";
			
			int rs=stmt.executeUpdate(sql);
			
			if (rs > 0) {
				Success = true;
			}
			else {
				Success = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Success;
	}

	
	

	public static List<completedSoftware> searchCompletedSoftware(String rid, String type) {

		ArrayList<completedSoftware> completedSoftware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_software_completed where raID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				
				
				float cost = rs.getFloat(6);
				Date comDate = rs.getDate(7);
				
				completedSoftware o = new completedSoftware (raID, cID, company, date, description,  cost, comDate);
				completedSoftware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedSoftware;
	}

	public static List<completedHardware> searchCompletedHardware(String rid, String type) {

		ArrayList<completedHardware> completedHardware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_hardware_completed where rcID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				int qty = rs.getInt(6);
				float cost = rs.getFloat(7);
				Date comDate = rs.getDate(8);
									
				completedHardware o = new completedHardware (rcID, cID, company,  date, description,  qty, cost,  comDate);
				completedHardware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedHardware;
	}

	public static List<completedOther> searchCompletedOther(String rid, String type) {

		ArrayList<completedOther> completedOther = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_other_completed where roID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				
				String description = rs.getNString(5);					
				

				float cost = rs.getFloat(6);
				Date comDate = rs.getDate(7);
									
				completedOther o = new completedOther (roID, cID, company, date,  description,   cost, comDate);
				completedOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedOther;
	}

	
	
	
	public static List<onGoingSoftware> ongoingReportSoftware(String month, String type) {
		
		int mon = Integer.parseInt(month);
		type = "Air Conditions";
		
		ArrayList<onGoingSoftware> onGoingSoftware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_soft where MONTH(date)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				
				float cost = rs.getFloat(6);
				
				onGoingSoftware o = new onGoingSoftware (raID, cID, company, date, description,  cost, type);
				onGoingSoftware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingSoftware;	
	}

	public static List<onGoingHardware> ongoingReportHardware(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Computers";
		
		ArrayList<onGoingHardware> onGoingHardware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_hardware where MONTH(date)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				
			
				float cost = rs.getFloat(6);
									
				onGoingHardware o = new onGoingHardware (rcID, cID, company,  date, description,  cost);
				onGoingHardware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingHardware;
	}

	public static List<onGoingOther> ongoingReportOther(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Other Electronics";
		
		ArrayList<onGoingOther> onGoingOther = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_other where MONTH(date)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				
				String description = rs.getNString(5);					
				
				
				float cost = rs.getFloat(6);
									
				onGoingOther o = new onGoingOther (roID, cID, company, date,  description, cost);
				onGoingOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingOther;
	}

	public static List<completedSoftware> completedReportSoftware(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Air Conditions";
		
		ArrayList<completedSoftware> completedSoftware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_software_completed where MONTH(comDate)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				
				
				float cost = rs.getFloat(6);
				Date comDate = rs.getDate(7);
				
				completedSoftware o = new completedSoftware (raID, cID, company, date, description, cost, comDate);
				completedSoftware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedSoftware;
	}

	public static List<completedHardware> completedReportHardware(String month, String type) {
		
		int mon = Integer.parseInt(month);
		type = "Computers";

		ArrayList<completedHardware> completedHardware = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_hardware_completed where MONTH(comDate)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(5);
				String description = rs.getNString(6);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				Date comDate = rs.getDate(10);
									
				completedHardware o = new completedHardware (rcID, cID, company, date, description, qty, cost, comDate);
				completedHardware.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedHardware;
	}

	public static List<completedOther> completedReportOther(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Other Electronics";
		
		ArrayList<completedOther> completedOther = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_other_completed where MONTH(comDate)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				
				float cost = rs.getFloat(6);
				Date comDate = rs.getDate(7);
									
				completedOther o = new completedOther (roID, cID, company, date, description, cost, comDate);
				completedOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedOther;
	}
	
	
	
	
	
	public static List<appointment> getAppointment() {

		ArrayList<appointment> appointment = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from darkshop.appointment order by Apo_id";
				
			rs = stmt.executeQuery(sql);
				
			while (rs.next()) {
				int appID = rs.getInt(1);
				String type = rs.getNString(2);
				String description = rs.getNString(3);
				String slot = rs.getNString(4);
				Date date = rs.getDate(5);
				int cid = rs.getInt(6);
									
				appointment o = new appointment (appID, type, description, slot, date, cid);
				appointment.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return appointment;
	}

	public static boolean deleteAppointment(String id) {

		int appID = Integer.parseInt(id);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from appointment where Apo_id='"+appID+"'";
			
			int rs=stmt.executeUpdate(sql);
			
			if (rs > 0) {
				Success = true;
			}
			else {
				Success = false;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return Success;
	}
}
