package com.Financial;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class finacialDButill {

	private static ResultSet rs = null;

	private static Connection con = null;
	private static Statement stmt = null;
	private static boolean isSuccess;

	public static boolean validate(String rid) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_computer where rcID= '" + rid + "' ";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;

			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public static List<repaircomputer> getcomputerrepair(String rid) {

		int idCust = Integer.parseInt(rid);
		ArrayList<repaircomputer> repaircomputer = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.repair_computer where rcID= '" + idCust + "' ";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int rcID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getString(3);
				String deliver = rs.getString(4);
				Date date = rs.getDate(5);
				String description = rs.getString(6);
				String spare = rs.getString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);

				repaircomputer c = new repaircomputer(rcID, cID, company, date, deliver, description, spare, qty, cost);
				repaircomputer.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return repaircomputer;

	}

	public static boolean insertrepairbill(String rcID, String company, String comdate, String deliver,
			String description, String spare, String qty, String cost, String sparepart, String date, String service) {

		isSuccess = false;

		float Qty = Float.parseFloat(qty);
		float Sparepart = Float.parseFloat(sparepart);
		float Service = Float.parseFloat(service);

		float Total;

		Total = Qty * Sparepart + Service;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "insert into repair_computer_bills values (0, '" + rcID + "', '" + company + "', '" + comdate
					+ "', '" + deliver + "','" + description + "','" + spare + "','" + qty + "','" + cost + "','" + sparepart + "','"
					+ date + "','" + service + "','" + Total + "')";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static List<billhistory> gethistory(String date) {

		ArrayList<billhistory> billhistory = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from automart.repair_bills where Date = '" + date + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int billID = rs.getInt(1);
				float sparepartprice = rs.getFloat(2);
				Date datee = rs.getDate(3);
				float serviceCharges = rs.getFloat(4);
				float total = rs.getFloat(5);
				int rid = rs.getInt(6);

				billhistory c = new billhistory(billID, sparepartprice, datee, serviceCharges, total, rid);
				billhistory.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return billhistory;

	}

	public static boolean validation(String bid) {

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_bills where B_id= '" + bid + "' ";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;

			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static List<billhistory> getbildetails(String bid) {

		int idCust = Integer.parseInt(bid);
		ArrayList<billhistory> billhistory = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_bills where B_id= '" + idCust + "' ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int billID = rs.getInt(1);
				float sparepartprice = rs.getFloat(2);
				Date datee = rs.getDate(3);
				float serviceCharges = rs.getFloat(4);
				float total = rs.getFloat(5);
				int rid = rs.getInt(6);

				billhistory e = new billhistory(billID, sparepartprice, datee, serviceCharges, total, rid);
				billhistory.add(e);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return billhistory;

	}

	public static boolean updaterepairbill(String billID, String spare, String date, String service, String total) {

		int billid = Integer.parseInt(billID);
		float Spare = Float.parseFloat(spare);
		float Service = Float.parseFloat(service);
		float Total = Float.parseFloat(total);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "update repair_bills set Sparepart_price='" + Spare + "', Date='" + date
					+ "', Service_Charges='" + Service + "',Total_Amount='" + Total + "' where B_id='" + billid + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static boolean insertToOther(String billID, String spare, String date, String service, String total) {

		isSuccess = false;

		int BillID = Integer.parseInt(billID);
		float Spare = Float.parseFloat(spare);
		float Service = Float.parseFloat(service);
		float Total = Float.parseFloat(total);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "insert into delete_repair_bills values ('" + BillID + "','" + Spare + "', '" + date + "', '"
					+ Service + "', '" + Total + "')";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static boolean deletebills(String billID) {

		int BillID = Integer.parseInt(billID);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from repair_bills where B_id='" + BillID + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static List<deliver> getdeliverdetails(String did) {

		ArrayList<deliver> deliverbills = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from deliver_order where d_order_id= '" + did + "' ";
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String deliverID = rs.getString(1);
				String adress = rs.getString(3);
				String itemNO = rs.getString(4);
				int qty = rs.getInt(5);
				float unitprice = rs.getFloat(6);
				Date date = rs.getDate(7);
				int cusid = rs.getInt(8);

				deliver e = new deliver(deliverID, adress, itemNO, qty, unitprice, date, cusid);
				deliverbills.add(e);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return deliverbills;

	}

	public static boolean insertdeliverybill(String deliverID, String cusID, String unitPrice, String qty,
			String deliverdate, String billdate, String tax, String cost) {

		isSuccess = false;

		int cusid = Integer.parseInt(cusID);
		float unitprice = Float.parseFloat(unitPrice);
		float Qty = Float.parseFloat(qty);
		float Tax = Float.parseFloat(tax);
		float Cost = Float.parseFloat(cost);

		float total;

		total = (Qty * unitprice) + Tax + Cost;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "insert into delivery_bills values (0, '" + deliverdate + "', '" + total + "', '" + deliverID
					+ "', '" + Tax + "','" + Cost + "','" + billdate + "','" + cusid + "')";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	

	public static boolean validationdelivery(String bid) {

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from delivery_bills where B_id= '" + bid + "' ";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;

			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static List<inserted_deliver_info> getdeliverybildetails(String bid) {

		int billid = Integer.parseInt(bid);

		ArrayList<inserted_deliver_info> inserted_deliver_info = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from delivery_bills where B_id = '" + billid + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int deliverbillID = rs.getInt(1);
				Date orderdate = rs.getDate(2);
				float Total = rs.getFloat(3);
				String orderID = rs.getString(4);
				float Tax = rs.getFloat(5);
				float deliverycost = rs.getFloat(6);
				Date billdate = rs.getDate(7);
				int cid = rs.getInt(8);

				inserted_deliver_info c = new inserted_deliver_info(deliverbillID, orderdate, Total, orderID, Tax,
						deliverycost, billdate, cid);
				inserted_deliver_info.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return inserted_deliver_info;

	}

	public static boolean insertToOtherdeliver(String bllID, String cusID, String orderID, String deliverdate,
			String billdate, String tax, String cost, String total) {

		isSuccess = false;

		int bill_ID = Integer.parseInt(bllID);
		int cus_ID = Integer.parseInt(cusID);
		float Tax = Float.parseFloat(tax);
		float Cost = Float.parseFloat(cost);
		float Total = Float.parseFloat(total);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "insert into delete_delivery_bills values ('" + bill_ID + "','" + deliverdate + "', '" + Total
					+ "', '" + orderID + "', '" + Tax + "','" + Cost + "','" + billdate + "','" + cus_ID + "')";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static boolean deletedeliverbills(String billID) {

		int BillID = Integer.parseInt(billID);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from delivery_bills where B_id='" + BillID + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static boolean updatdeliverbill(String diliverBillid, String billDate, String tax, String cost,
			String total) {

		int DiliverBillid = Integer.parseInt(diliverBillid);
		float Tax = Float.parseFloat(tax);
		float Cost = Float.parseFloat(cost);
		float Total = Float.parseFloat(total);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "update delivery_bills set Total_Amount='" + Total + "', bill_date='" + billDate + "', tax='"
					+ Tax + "',Delivery_Cost='" + Cost + "' where B_id='" + DiliverBillid + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static List<Empdetails> getemp() {

		ArrayList<Empdetails> Empdetails = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from new_employee";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String nic = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				String position = rs.getString(5);
				Float basicsalary = rs.getFloat(7);

				Empdetails c = new Empdetails(nic, name, email, position, basicsalary);
				Empdetails.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return Empdetails;

	}

	public static List<Empdetails> getempdetails(String nic) {

		ArrayList<Empdetails> Empdetails = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from new_employee where Nic='" + nic + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				String Nic = rs.getString(1);
				String Name = rs.getString(2);
				String Email = rs.getString(3);
				String Position = rs.getString(5);
				Float Basicsalary = rs.getFloat(7);

				Empdetails c = new Empdetails(Nic, Name, Email, Position, Basicsalary);
				Empdetails.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return Empdetails;

	}

	public static boolean insertdeliverybill(String nic, String epf, String etf, String ot, String bonus,
			String basicsalary, String date) {

		isSuccess = false;

		float EPF = Float.parseFloat(epf);
		float ETF = Float.parseFloat(etf);
		float OT = Float.parseFloat(ot);
		float Bonus = Float.parseFloat(bonus);
		float Basicsalary = Float.parseFloat(basicsalary);
		

		float total = Basicsalary + OT - (EPF + ETF )+ Bonus;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "insert into salaries values (0,'" + Basicsalary + "','" + ETF + "','" + EPF + "', '" + OT + "', '" + Bonus + "', '"
					+ nic + "','" + total + "','"+date+"')";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static List<EmpSalaryDetails> getemphistroy(String nic) {

		ArrayList<EmpSalaryDetails> EmpSalaryDetails = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.salaries where Nic='" + nic + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int SalaryID = rs.getInt(1);
				float Basicsalary = rs.getFloat(2);
				float ETF = rs.getFloat(4);
				float EPF = rs.getFloat(3);
				float OT = rs.getFloat(5);
				float Bonus = rs.getFloat(6);
				String Nic = rs.getString(7);
				float Total = rs.getFloat(8);
				Date Date = rs.getDate(9);

				EmpSalaryDetails c = new EmpSalaryDetails(SalaryID, Basicsalary, ETF, EPF, OT, Bonus, Nic, Total, Date);
				EmpSalaryDetails.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return EmpSalaryDetails;

	}

	public static List<EmpSalaryDetails> getsalaryupdate(String salid) {

		ArrayList<EmpSalaryDetails> EmpSalaryDetails = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from salaries where Sal_id='" + salid + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int SalaryID = rs.getInt(1);
				float Basicsalary = rs.getFloat(2);
				float ETF = rs.getFloat(3);
				float EPF = rs.getFloat(4);
				float OT = rs.getFloat(5);
				float Bonus = rs.getFloat(6);
				String Nic = rs.getString(7);
				float Total = rs.getFloat(8);
				Date Date = rs.getDate(9);

				EmpSalaryDetails c = new EmpSalaryDetails(SalaryID, Basicsalary, ETF, EPF, OT, Bonus, Nic, Total, Date);
				EmpSalaryDetails.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return EmpSalaryDetails;

	}

	public static boolean updatdeliverbill(String salID, String nic, String basicsalary, String etf, String epf, String ot, String bonus,
			String total, String date) {

		int SalID = Integer.parseInt(salID);
		float Basicsalary = Float.parseFloat(basicsalary);
		float Etf = Float.parseFloat(etf);
		float Epf = Float.parseFloat(epf);
		float Ot = Float.parseFloat(ot);
		float Bonus = Float.parseFloat(bonus);
//		float Total = Float.parseFloat(total);
		float Total = Basicsalary + Ot - (Etf + Epf )+ Bonus;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "update salaries set Sal_id='" + SalID + "', Nic='" + nic + "', ETF='" + Etf + "',EPF='" + Epf
					+ "',Over_time='" + Ot + "',Bonus='" + Bonus + "',total='" + Total + "',Date='"+date+"' where Sal_id='" + salID
					+ "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static boolean deletesalary(String salid) {

		int Salid = Integer.parseInt(salid);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from salaries where Sal_id='" + Salid + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static boolean repairbillreport(String date) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_computer_bills where bill_date = '" + date + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public static List<computerBillHistory> getrepairbillreport(String date) {

		ArrayList<computerBillHistory> computerBillHistory = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_computer_bills where bill_date = '" + date + "'";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int billID = rs.getInt(1);
				int rcID = rs.getInt(2);
				String name = rs.getString(3);
				Date Date = rs.getDate(4);
				String deliver = rs.getString(5);
				String spare = rs.getString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				float spareprice = rs.getFloat(10);
				Date billdate = rs.getDate(11);
				float serviceCharges = rs.getFloat(12);
				float total = rs.getFloat(13);

				computerBillHistory c = new computerBillHistory(billID, rcID, name, Date, deliver, spare, qty,cost,
						spareprice, billdate, serviceCharges, total);
				computerBillHistory.add(c);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return computerBillHistory;

	}

	

	public static List<repairAir> getAirdetails(String did) {

		int idCust = Integer.parseInt(did);
		ArrayList<repairAir> repairAir = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_air where raID= '" + idCust + "' ";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int raID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getString(3);
				Date date = rs.getDate(4);
				String description = rs.getString(5);
				String spare = rs.getString(6);
				int qty = rs.getInt(7);
				float cost = rs.getFloat(8);

				repairAir c = new repairAir(raID, cID, company, date, description, spare, qty, cost);
				repairAir.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return repairAir;

	}

	public static List<computerBillHistory> getcomputerhistory(String date) {

		ArrayList<computerBillHistory> computerBillHistory = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.repair_computer_bills where bill_date = '" + date + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int billID = rs.getInt(1);
				int rcID = rs.getInt(2);
				String name = rs.getString(3);
				Date Date = rs.getDate(4);
				String deliver = rs.getString(5);
				String spare = rs.getString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				float spareprice = rs.getFloat(10);
				Date billdate = rs.getDate(11);
				float serviceCharges = rs.getFloat(12);
				float total = rs.getFloat(13);

				computerBillHistory c = new computerBillHistory(billID, rcID, name, Date, deliver, spare, qty,cost,
						spareprice, billdate, serviceCharges, total);
				computerBillHistory.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return computerBillHistory;
	}

	public static boolean updatecomputerrepairbill(String billID, String qty, String spareprice, String service, String total, String date) {

		int billid = Integer.parseInt(billID);
		int qty1 = Integer.parseInt(qty);
		float Spare = Float.parseFloat(spareprice);
		float Service = Float.parseFloat(service);
//		float Total = Float.parseFloat(total);
		float Total = qty1 * Spare + Service;
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "update repair_computer_bills set spare_price='" + Spare + "', service_charges='" + Service
					+ "',total='" + Total + "',bill_date='"+date+"' where billID='" + billid + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;

	}

	public static boolean deletecomputerbills(String billID) {

		int BillID = Integer.parseInt(billID);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from repair_computer_bills where billID='" + BillID + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	

	

	

	public static List<otherBillHistroy> getotherbillhistory(String otherdate) {

		ArrayList<otherBillHistroy> otherBillHistroy = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.repair_other_bills where billdate = '" + otherdate + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int billID = rs.getInt(1);
				int roID = rs.getInt(2);
				String name = rs.getString(3);
				Date Date = rs.getDate(4);
				String spare = rs.getString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				float spareprice = rs.getFloat(10);
				Date billdate = rs.getDate(11);
				float serviceCharges = rs.getFloat(12);
				float total = rs.getFloat(13);

				otherBillHistroy c = new otherBillHistroy(billID, roID, name, Date, spare, qty, cost, spareprice,
						billdate, serviceCharges, total);
				otherBillHistroy.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return otherBillHistroy;
	}

	public static List<repairOther> getotherdetails(String oid) {

		int idCust = Integer.parseInt(oid);
		ArrayList<repairOther> repairOther = new ArrayList<>();
		// Validate
		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from repair_other where roID= '" + idCust + "' ";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int roID = rs.getInt(1);
				int cID = rs.getInt(2);
				String company = rs.getString(3);
				Date date = rs.getDate(4);
				String devices = rs.getString(5);
				String description = rs.getString(6);
				String spare = rs.getString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);

				repairOther c = new repairOther(roID, cID, company, date, devices, description, spare, qty, cost);
				repairOther.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return repairOther;
	}

	public static boolean insert_other_bill(String roID, String cID, String company, String date, String devices, String description,
			String spare, String qty, String cost, String sparepart, String billdate, String service) {

		isSuccess = false;

		float Qty = Float.parseFloat(qty);
		float Sparepart = Float.parseFloat(sparepart);
		float Service = Float.parseFloat(service);

		float Total;

		Total = Qty * Sparepart + Service;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "insert into repair_other_bills values (0, '" + roID + "', '" + company + "', '" + date
					+ "','" + devices + "', '" + description + "','" + spare + "','" + Qty + "','" + cost + "','" + Sparepart + "','"
					+ billdate + "','" + Service + "','" + Total + "')";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;

	}

	public static boolean updateotherrepairbill(String billID, String date, String spareprice, String service,
			String total, String qty) {
		int billid = Integer.parseInt(billID);
		float Spare = Float.parseFloat(spareprice);
		float Service = Float.parseFloat(service);
		int qty1 = Integer.parseInt(qty);
//		float Total = Float.parseFloat(total);
		float Total = qty1 * Spare + Service;

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "update repair_other_bills set sparepart='" + Spare + "', service='" + Service + "',total='"
					+ Total + "',billdate='"+date+"' where billID='" + billid + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}

	public static boolean deleteotherbills(String billID) {

		int BillID = Integer.parseInt(billID);

		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "delete from repair_other_bills where billID='" + BillID + "'";

			int rs = stmt.executeUpdate(sql);

			if (rs > 0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	

	

	public static List<otherBillHistroy> getotherbillreport(String date) {
		ArrayList<otherBillHistroy> otherBillHistroy = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.repair_other_bills where billdate = '" + date + "'";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				int billID = rs.getInt(1);
				int roID = rs.getInt(2);
				String name = rs.getString(3);
				Date Date = rs.getDate(4);
				String spare = rs.getString(7);
				int qty = rs.getInt(8);
				float cost = rs.getFloat(9);
				float spareprice = rs.getFloat(10);
				Date billdate = rs.getDate(11);
				float serviceCharges = rs.getFloat(12);
				float total = rs.getFloat(13);

				otherBillHistroy c = new otherBillHistroy(billID, roID, name, Date, spare, qty, cost, spareprice,
						billdate, serviceCharges, total);
				otherBillHistroy.add(c);

			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("rrrr");
		}

		return otherBillHistroy;
	}

	public static Boolean otherbillreport(String date) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.repair_other_bills where billdate = '" + date + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	public static boolean empreport(String nic) {
		try {
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.salaries where Nic = '" + nic + "'";
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return isSuccess;
	}
	
	public static List<EmpSalaryDetails> getempreport(String nic) {

		ArrayList<EmpSalaryDetails> EmpSalaryDetails = new ArrayList<>();

		try {

			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from darkshop.salaries where Nic = '" + nic + "'";

			rs = stmt.executeQuery(sql);
			while (rs.next()) {

				int salID = rs.getInt(1);
				float basicsalary = rs.getFloat(2);
				float etf = rs.getFloat(3);
				float epf = rs.getFloat(4);
				float ot = rs.getFloat(5);
				float bonus = rs.getFloat(6);
				String Nic = rs.getString(7);
				float total = rs.getFloat(8);
				Date date = rs.getDate(9);

				EmpSalaryDetails c = new EmpSalaryDetails(salID,basicsalary,etf,epf,ot,bonus,Nic,total,date);
				EmpSalaryDetails.add(c);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return EmpSalaryDetails;

	}

}
