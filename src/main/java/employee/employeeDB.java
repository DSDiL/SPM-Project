package employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class employeeDB {
	private static boolean isSuccess;
	private static Connection con = null;
	private static Statement stt = null;
	private static ResultSet rs = null;
	private static Properties pro;

	//for login validation 
	public static boolean validate(String nic, String password) {

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select * from new_employee where Nic='" + nic + "' and password='" + password + "'";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return isSuccess;
	}

	public static List<employee> getEmployeeDetails(String nic, String password) {

		ArrayList<employee> emp = new ArrayList<>();

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select * from new_employee where Nic='" + nic + "' and password='" + password + "'";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				String Nic = rs.getNString(1);
				String name = rs.getNString(2);
				String email = rs.getNString(3);
				int mobile = rs.getInt(4);
				String position = rs.getNString(5);
				Date dob = rs.getDate(6);
				float basicSalary = rs.getFloat(7);
				String section = rs.getNString(8);
				String pw = rs.getString(9);

				employee e = new employee(Nic, name, email, mobile, position, dob, basicSalary, section, pw);
				emp.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	//for signUp
	
	public static boolean insertEmployeeDetails(String nic, String name, String position, String salary,
			String password, String section, String email) {

		isSuccess = false;

		float sal = Float.parseFloat(salary);

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "insert into new_employee values ('" + nic + "', '" + name + "', '" + email + "', NULL, '"
					+ position + "', NULL, '" + sal + "', '" + section + "', '" + password + "')";

			int rs = stt.executeUpdate(sql);

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

	public static List<employee> employeeProfile(String nic) {

		ArrayList<employee> emp = new ArrayList<>();

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select * from new_employee where Nic='" + nic + "'";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				String Nic = rs.getNString(1);
				String name = rs.getNString(2);
				String email = rs.getNString(3);
				int mobile = rs.getInt(4);
				String position = rs.getNString(5);
				Date dob = rs.getDate(6);
				float basicSalary = rs.getFloat(7);
				String section = rs.getString(8);
				String pw = rs.getString(9);

				employee e = new employee(Nic, name, email, mobile, position, dob, basicSalary, section, pw);
				emp.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	//for employee profile update 
	public static boolean updateProfile(String name, String mobile, String email, String dob, String nic) {

		int mob = Integer.parseInt(mobile);

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "update new_employee set name='" + name + "', email='" + email + "', mobile='" + mob
					+ "', DOB='" + dob + "' where Nic='" + nic + "'";

			int rs = stt.executeUpdate(sql);

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
	
	//for update employee profile (Employee management)

	public static boolean profileChange(String position, String basicSalary, String section, String nic) {

		float salary = Float.parseFloat(basicSalary);

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "update new_employee set position='" + position + "', Basic_salary='" + salary + "', section='"
					+ section + "' where Nic='" + nic + "'";

			int rs = stt.executeUpdate(sql);

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

	
	//delete employee profile (admin)
	public static boolean deleteProfile(String nic) {

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql1 = "delete from leaving where Nic='" + nic + "'";

			String sql3 = "delete from salaries where Nic='" + nic + "'";

			String sql4 = "delete from new_employee where Nic='" + nic + "'";

			int rs1 = stt.executeUpdate(sql1);
			int rs3 = stt.executeUpdate(sql3);
			int rs4 = stt.executeUpdate(sql4);

			if ((rs1 > 0) && (rs3 > 0) && (rs4 > 0)) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}

	//get employee details for delete his/her profile
	
	public static boolean previousEmployee(String nic, String name, String email, String mobile, String position,
			String dob, String date) {

		isSuccess = false;
		int mob = Integer.parseInt(mobile);

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "insert into pervious_employee values ('" + nic + "', '" + name + "', '" + email + "', '" + mob
					+ "', '" + position + "', '" + dob + "', '" + date + "')";

			int rs = stt.executeUpdate(sql);

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

	//for forgot password validation
	
	public static boolean forgotPasword(String nic, String email, String date) {

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select * from new_employee where Nic='" + nic + "' and email='" + email + "' and DOB='" + date
					+ "'";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return isSuccess;
	}

	//add new password
	
	public static boolean changePassword(String nic, String newpw) {

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "update new_employee set password='" + newpw + "' where Nic='" + nic + "'";

			int rs = stt.executeUpdate(sql);

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
	
	public static List<employee> newPassword(String nic, String email, String date) {

		ArrayList<employee> emp = new ArrayList<>();

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select * from new_employee where Nic='" + nic + "' and email='" + email + "' and DOB='" + date
					+ "'";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				String Nic = rs.getNString(1);
				String name = rs.getNString(2);
				String Email = rs.getNString(3);
				int mobile = rs.getInt(4);
				String position = rs.getNString(5);
				Date dob = rs.getDate(6);
				float basicSalary = rs.getFloat(7);
				String section = rs.getString(8);
				String pw = rs.getString(9);

				employee e = new employee(Nic, name, Email, mobile, position, dob, basicSalary, section, pw);
				emp.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	//add new position
	
	public static boolean addNewPosition(String newposition) {

		isSuccess = false;

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "insert into position values (0,'" + newposition + "')";

			int rs = stt.executeUpdate(sql);

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

    //add leaving details	

	public static boolean insertLeavingDetails(String nic) {

		int sick = 15;
		int casual = 15;

		isSuccess = false;

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "insert into leaving_info values ('" + nic + "','" + sick + "','" + casual + "')";

			int rs = stt.executeUpdate(sql);

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

	public static List<leave> employeeLeave(String nic) {

		ArrayList<leave> leave = new ArrayList<>();

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select * from leaving_info where nic='" + nic + "'";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				String Nic = rs.getNString(1);
				int sick = rs.getInt(2);
				int casual = rs.getInt(3);

				leave e = new leave(Nic, sick, casual);
				leave.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return leave;
	}

	public static boolean insertLeaving(String nic, String reason, String days, String date, String more,
			String status) {

		int Days = Integer.parseInt(days);

		isSuccess = false;

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "insert into leaving values (0,'" + reason + "','" + Days + "','" + date + "','" + more + "','"
					+ status + "','" + nic + "')";

			int rs = stt.executeUpdate(sql);

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

	//update leaving details
	
	public static boolean updateLeavingInfo(String nic, String reason, String days, String sick, String casual) {

		try {
			int Sick = Integer.parseInt(sick);
			int Casual = Integer.parseInt(casual);
			int Days = Integer.parseInt(days);

			String str = "MedicalLeaving";

			boolean b = reason.equals(str);

			if (b == true) {
				Sick = Sick - Days;
			} else {
				Casual = Casual - Days;
			}

			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "update leaving_info set sick='" + Sick + "', casual='" + Casual + "' where nic='" + nic + "'";

			int rs = stt.executeUpdate(sql);

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

	//apply leaving 
	
	public static List<leaveApply> leavingAppDetails(String nic) {

		ArrayList<leaveApply> app = new ArrayList<>();

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "SELECT * FROM leaving where Nic='" + nic + "' ORDER BY id  DESC LIMIT 1";

			rs = stt.executeQuery(sql);

			if (rs.next()) {
				int id = rs.getInt(1);
				String reason = rs.getString(2);
				int period = rs.getInt(3);
				String date = rs.getString(4);
				String more = rs.getString(5);
				String status = rs.getString(6);
				String Nic = rs.getString(7);

				leaveApply e = new leaveApply(id, reason, period, date, more, status, Nic);
				app.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return app;
	}
	
	//delete leaving 

	public static boolean deleteLeaveInfo(String nic) {

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "delete from leaving_info where nic='" + nic + "'";

			int rs = stt.executeUpdate(sql);

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

	public static boolean deleteLeave(String id) {
		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "delete from leaving where id='" + id + "'";

			int rs = stt.executeUpdate(sql);

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
	
	//update leaving

	public static boolean updateLeavingInfo2(String nic, String reason, String days, String sick, String casual) {
		try {
			int Sick = Integer.parseInt(sick);
			int Casual = Integer.parseInt(casual);
			int Days = Integer.parseInt(days);

			String str = "MedicalLeaving";

			boolean b = reason.equals(str);

			if (b == true) {
				Sick = Sick + Days;
			} else {
				Casual = Casual + Days;
			}

			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "update leaving_info set sick='" + Sick + "', casual='" + Casual + "' where nic='" + nic + "'";

			int rs = stt.executeUpdate(sql);

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

	//Auto generate email
	
	public static void sendEmail(String host, String port, String user, String pass, String email, String subject,
			String content) throws AddressException, MessagingException {
		pro = new Properties();
		pro.put("mail.smtp.host", host);
		pro.put("mail.smtp.port", port);
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.starttls.enable", "true");

		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		};
		Session session = Session.getInstance(pro, auth);

		Message msg = new MimeMessage(session);

		msg.setFrom(new InternetAddress(user));
		InternetAddress[] toAddresses = { new InternetAddress(email) };

		msg.setRecipients(Message.RecipientType.TO, toAddresses);
		msg.setSubject(subject);
		msg.setSentDate(new Date());
		msg.setText(content);

		Transport.send(msg);
	}

    //leaving approve
	
	public static List<leaveApply> leavingApprovalDetails() {

		ArrayList<leaveApply> app = new ArrayList<>();

		try {
			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "select leaving.id, leaving.Nic, leaving.Reason, leaving.period, leaving.date, leaving.status, leaving_info.casual, leaving_info.sick, leaving.more from leaving inner join leaving_info where leaving.Nic=leaving_info.nic and leaving.status='pending'";

			rs = stt.executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt(1);
				String Nic = rs.getString(2);
				String reason = rs.getString(3);
				int period = rs.getInt(4);
				String date = rs.getString(5);
				String status = rs.getString(6);
				int casual = rs.getInt(7);
				int sick = rs.getInt(8);
				String more = rs.getString(9);

				leaveApply e = new leaveApply(id, Nic, reason, period, date, status, casual, sick, more);
				app.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return app;
	}

	public static boolean leavingApproving(String id, String status, String more) {
		try {
			int Id = Integer.parseInt(id);

			con = dbconnect.getConnection();
			stt = con.createStatement();

			String sql = "update leaving set status='" + status + "', more='" + more + "' where id='" + Id + "'";

			int rs = stt.executeUpdate(sql);

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
	
	//Generate monthly report
	
		public static List<report> monthlyLeavingReport() {

			ArrayList<report> report = new ArrayList<>();

			try {
				con = dbconnect.getConnection();
				stt = con.createStatement();

				String sql = "select new_employee.nic, 15-leaving_info.sick, 15-leaving_info.casual, new_employee.name, 30-(leaving_info.sick+leaving_info.casual) from new_employee inner join leaving_info where new_employee.nic=leaving_info.nic";

				rs = stt.executeQuery(sql);

				while (rs.next()) {
					String id = rs.getString(1);
					int sick = rs.getInt(2);
					int casual = rs.getInt(3);
					String name = rs.getString(4);
					int total = rs.getInt(5);

					report e = new report(id, sick, casual, name, total);
					report.add(e);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return report;
		}
}