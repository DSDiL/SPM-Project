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

	//for login
	
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

	//for SignUp
	
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

	//for new password
	
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

	//for new position
	
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


	//generate email 
	
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

}