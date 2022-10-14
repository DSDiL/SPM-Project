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
	
	public static boolean insertComputerRepair(String cID, String com, String del, String date,String des, String spare, String qty, String cost) {

		Success=false;
		
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_computer values(0,'"+cid+"','"+com+"','"+del+"','"+date+"','"+des+"','"+spare+"','"+Qty+"','"+total+"')";
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

	public static boolean insertAirRepair(String cID, String com, String date, String des, String spare, String qty, String cost) {
		
		Success=false;
		
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_air values(0,'"+cid+"','"+com+"','"+date+"','"+des+"','"+spare+"','"+Qty+"','"+total+"')";
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

	public static boolean insertOtherRepair(String cID, String com, String date, String dev, String des, String spare, String qty, String cost) {

		Success=false;
		
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_other values(0,'"+cid+"','"+com+"','"+date+"','"+dev+"','"+des+"','"+spare+"','"+Qty+"','"+total+"')";
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

	public static List<onGoingAir> searchOngoingAir(String rid, String type) {
		
		ArrayList<onGoingAir> onGoingAir = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_air where raID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				String spare = rs.getNString(6);
				int qty = rs.getInt(7);
				float cost = rs.getFloat(8);
					
				System.out.println(cost);
				
				onGoingAir o = new onGoingAir (raID, cID, company, date, description, spare, qty, cost, type);
				onGoingAir.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingAir;	
	}

	public static List<onGoingComputer> searchOngoingComputer(String rid, String type) {

		ArrayList<onGoingComputer> onGoingComputer = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_computer where rcID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				String deliver = rs.getNString(4);
				Date date = rs.getDate(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
									
				onGoingComputer o = new onGoingComputer (rcID, cID, company, deliver, date, description, spare, qty, cost, type);
				onGoingComputer.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingComputer;
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
				String device = rs.getNString(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
									
				onGoingOther o = new onGoingOther (roID, cID, company, date, device, description, spare, qty, cost, type);
				onGoingOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingOther;
	}

	public static boolean updateAirRepair(String raID, String cID, String com, String date, String des, String spare, String qty, String cost) {
		
		int raid = Integer.parseInt(raID);
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql = "update repair_air set cID='"+cid+"', company='"+com+"', date='"+date+"', description='"+des+"', spare='"+spare+"', qty='"+Qty+"', cost='"+total+"' where raID='"+raid+"'";
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

	public static boolean updateComputerRepair(String rcID, String cID, String com, String deliver, String date, String des, String spare, String qty, String cost) {

		int rcid = Integer.parseInt(rcID);
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql = "update repair_computer set cID='"+cid+"', company='"+com+"', deliver='"+deliver+"', date='"+date+"', description='"+des+"', spare='"+spare+"', qty='"+Qty+"', cost='"+total+"' where rcID='"+rcid+"'";
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

	public static boolean updateOtherRepair(String roID, String cID, String com, String date, String devices, String des, String spare, String qty, String cost) {

		int roid = Integer.parseInt(roID);
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql = "update repair_other set cID='"+cid+"', company='"+com+"', date='"+date+"', devices='"+devices+"', description='"+des+"', spare='"+spare+"', qty='"+Qty+"', cost='"+total+"' where roID='"+roid+"'";
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

	public static boolean insertCompletedAirRepair(String raID, String cID, String com, String date, String des, String spare, String qty, String cost, LocalDate comDate) {

		Success=false;
		
		int raid = Integer.parseInt(raID);
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_air_completed values('"+raid+"','"+cid+"','"+com+"','"+date+"','"+des+"','"+spare+"','"+Qty+"','"+total+"','"+comDate+"')";
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

	public static boolean insertCompletedComputerRepair(String rcID, String cID, String com, String deliver, String date, String des, String spare, String qty, String cost, LocalDate comDate) {

		Success=false;
		
		int rcid = Integer.parseInt(rcID);
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_computer_completed values('"+rcid+"','"+cid+"','"+com+"','"+deliver+"','"+date+"','"+des+"','"+spare+"','"+Qty+"','"+total+"','"+comDate+"')";
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

	public static boolean insertComputerOtherRepair(String roID, String cID, String com, String date, String devices, String des, String spare, String qty, String cost, LocalDate comDate) {

		Success=false;
		
		int roid = Integer.parseInt(roID);
		int cid = Integer.parseInt(cID);
		int Qty = Integer.parseInt(qty);
		float total = Float.parseFloat(cost);

		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into repair_other_completed values('"+roid+"','"+cid+"','"+com+"','"+date+"','"+devices+"','"+des+"','"+spare+"','"+Qty+"','"+total+"','"+comDate+"')";
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

	public static boolean removeOngoingAir(String raID) {

		int raid = Integer.parseInt(raID);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from repair_air where raID='"+raid+"'";
			
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

	public static boolean removeOngoingComputer(String rcID) {

		int rcid = Integer.parseInt(rcID);
		
		try {
			con=DBconnect.getConnection();
			stmt=con.createStatement();
			
			String sql = "delete from repair_computer where rcID='"+rcid+"'";
			
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

	public static List<completedAir> searchCompletedAir(String rid, String type) {

		ArrayList<completedAir> completedAir = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_air_completed where raID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				String spare = rs.getNString(6);
				int qty = rs.getInt(7);
				float cost = rs.getFloat(8);
				Date comDate = rs.getDate(9);
				
				completedAir o = new completedAir (raID, cID, company, date, description, spare, qty, cost, type, comDate);
				completedAir.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedAir;
	}

	public static List<completedComputer> searchCompletedComputer(String rid, String type) {

		ArrayList<completedComputer> completedComputer = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "select * from repair_computer_completed where rcID='"+rid+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				String deliver = rs.getNString(4);
				Date date = rs.getDate(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				Date comDate = rs.getDate(10);
									
				completedComputer o = new completedComputer (rcID, cID, company, deliver, date, description, spare, qty, cost, type, comDate);
				completedComputer.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedComputer;
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
				String device = rs.getNString(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				Date comDate = rs.getDate(10);
									
				completedOther o = new completedOther (roID, cID, company, date, device, description, spare, qty, cost, type, comDate);
				completedOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedOther;
	}

	public static List<onGoingAir> ongoingReportAir(String month, String type) {
		
		int mon = Integer.parseInt(month);
		type = "Air Conditions";
		
		ArrayList<onGoingAir> onGoingAir = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM repair_air where MONTH(date)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				String spare = rs.getNString(6);
				int qty = rs.getInt(7);
				float cost = rs.getFloat(8);
				
				onGoingAir o = new onGoingAir (raID, cID, company, date, description, spare, qty, cost, type);
				onGoingAir.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingAir;	
	}

	public static List<onGoingComputer> ongoingReportComputer(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Computers";
		
		ArrayList<onGoingComputer> onGoingComputer = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM techscope.repair_computer where MONTH(date)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				String deliver = rs.getNString(4);
				Date date = rs.getDate(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
									
				onGoingComputer o = new onGoingComputer (rcID, cID, company, deliver, date, description, spare, qty, cost, type);
				onGoingComputer.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingComputer;
	}

	public static List<onGoingOther> ongoingReportOther(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Other Electronics";
		
		ArrayList<onGoingOther> onGoingOther = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM techscope.repair_other where MONTH(date)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String device = rs.getNString(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
									
				onGoingOther o = new onGoingOther (roID, cID, company, date, device, description, spare, qty, cost, type);
				onGoingOther.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return onGoingOther;
	}

	public static List<completedAir> completedReportAir(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Air Conditions";
		
		ArrayList<completedAir> completedAir = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM techscope.repair_air_completed where MONTH(comDate)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String description = rs.getNString(5);					
				String spare = rs.getNString(6);
				int qty = rs.getInt(7);
				float cost = rs.getFloat(8);
				Date comDate = rs.getDate(9);
				
				completedAir o = new completedAir (raID, cID, company, date, description, spare, qty, cost, type, comDate);
				completedAir.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedAir;
	}

	public static List<completedComputer> completedReportComputer(String month, String type) {
		
		int mon = Integer.parseInt(month);
		type = "Computers";

		ArrayList<completedComputer> completedComputer = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM techscope.repair_computer_completed where MONTH(comDate)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				String deliver = rs.getNString(4);
				Date date = rs.getDate(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				Date comDate = rs.getDate(10);
									
				completedComputer o = new completedComputer (rcID, cID, company, deliver, date, description, spare, qty, cost, type, comDate);
				completedComputer.add(o);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return completedComputer;
	}

	public static List<completedOther> completedReportOther(String month, String type) {

		int mon = Integer.parseInt(month);
		type = "Other Electronics";
		
		ArrayList<completedOther> completedOther = new ArrayList<>();
		
		try {
			con = DBconnect.getConnection();
			stmt = con.createStatement();
				
			String sql = "SELECT * FROM techscope.repair_other_completed where MONTH(comDate)='"+mon+"'";
				
			rs = stmt.executeQuery(sql);
				
			if (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getNString(3);
				Date date = rs.getDate(4);
				String device = rs.getNString(5);
				String description = rs.getNString(6);					
				String spare = rs.getNString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				Date comDate = rs.getDate(10);
									
				completedOther o = new completedOther (roID, cID, company, date, device, description, spare, qty, cost, type, comDate);
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
				
			String sql = "select * from techscope.appointment order by Apo_id";
				
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
