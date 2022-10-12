package Customer;

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

import dbconnection.DBconnect;

public class customerDButil {

	private static boolean Success;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	private static Properties pro;
	
public static boolean login(String Email, String password) {
	
	try {
		con=DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from customer where Email='"+Email+"' and password='"+password+"'";
		rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			Success = true;
		} else {
			Success = false;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return Success;
}

public static List<Customer> getCustomer(String Email) {
	
	ArrayList<Customer> customer = new ArrayList<>();
	
	try {
		
		con=DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from customer where Email='"+Email+"'";
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String fullname = rs.getString(2);
			String email= rs.getString(3);
			String phoneno = rs.getString(4);
			String address = rs.getString(5);
		    String password=rs.getString(6);
			
			//pass the values in constructor in Customer.java class
			Customer cus=new Customer(id,fullname,email,phoneno,address,password);
			//pass customer object to array list object
			customer.add(cus);
		}
		
	} catch (Exception e) {
		
	}
	//array object
	return customer;	
}


public static boolean insertCustomer(String full_Name,String email,String phone_No,String address,String pass) {
	
	try {
		con=DBconnect.getConnection();
		stmt=con.createStatement();
		String sql="INSERT INTO customer VALUES(0,'"+full_Name+"','"+email+"','"+phone_No+"','"+address+"','"+pass+"')" ;
		int rs=stmt.executeUpdate(sql);
		
		
		if(rs>0)
		{
			Success=true;
		}
		else
		{
			Success=false;
		}
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	return Success;
}


public static boolean UpdateCustomer(String id,String name,String email,String phone,String address) {
	
	try {
		
		con=DBconnect.getConnection();
		stmt=con.createStatement();
		String sql="Update customer set Full_Name='"+name+"' ,Email='"+email+"' ,Phone_No='"+phone+"', address='"+address+"' where idCustomer='"+id+"'" ;
		int rs=stmt.executeUpdate(sql);
		
		
		if(rs>0)
		{
			Success=true;
		}
		else
		{
			Success=false;
		}
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	return Success;
}

public static List<Customer> getUpdateDetails(String Email) {
	
	ArrayList<Customer> customer = new ArrayList<>();
	
	try {
		
		con=DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from customer where Email='"+Email+"'";
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String fullname = rs.getString(2);
			String email= rs.getString(3);
			String phoneno = rs.getString(4);
			String address = rs.getString(5);
		    String password=rs.getString(6);
			
			
			Customer cus=new Customer(id,fullname,email,phoneno,address,password);
			customer.add(cus);
		}
	}catch (Exception e) {	
}
return customer;	
}

public static boolean deletecustomer(String id) {
	
	try {
		
		con=DBconnect.getConnection();
		stmt=con.createStatement();
		
		String sql="delete from appointment where Cid='"+id+"'" ;
		String sql2="delete from customer where idCustomer='"+id+"'" ;
		
		int rs=stmt.executeUpdate(sql);
		int rs2=stmt.executeUpdate(sql2);
		
		if((rs>0) && (rs2>0)) {
			Success=true;
		}
		else if(rs2>0) {
			Success=true;
		}else {
			Success=false;
		}
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	return Success;
}

public static boolean validateEmail(String email) {

	try {
		con=DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from customer where Email='"+email+"'";
		rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			Success = false;
		} else {
			Success = true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return Success;
}

public static List<Verify> getVerify(String email) {
	
	ArrayList<Verify> verify = new ArrayList<>();
	
	try {
		
		con=DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from verify where email='"+email+"'";
		rs = stmt.executeQuery(sql);
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String Email= rs.getString(2);
			int code = rs.getInt(3);
			
			Verify v = new Verify(id,Email,code);
			verify.add(v);
		}
	}catch (Exception e) {	
}
return verify;	
}

public static boolean validateCode(String email, String code) {

	try {
		con=DBconnect.getConnection();
		stmt = con.createStatement();
		String sql = "select * from verify where email='"+email+"' and code='"+code+"'";
		rs = stmt.executeQuery(sql);
		
		if (rs.next()) {
			Success = true;
		} else {
			Success = false;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	return Success;
}

public static boolean updatePassword(String email, String password) {

	try {
		con=DBconnect.getConnection();
		stmt=con.createStatement();
		String sql="Update customer set password='"+password+"' where Email='"+email+"'" ;
		int rs=stmt.executeUpdate(sql);
		
		String sql1="delete from verify where email='"+email+"'";
		int rs1=stmt.executeUpdate(sql1);
		
		if(rs>0 && rs1>0)
		{
			Success=true;
		}
		else
		{
			Success=false;
		}
	}catch(Exception e) {
		
		e.printStackTrace();
	}
	return Success;
}

public static void sendEmail(String host, String port, String user, String pass, String email, String subject, String content, String code) throws AddressException, MessagingException {
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
	
	try {
		int Code = Integer.parseInt(code);
		
		con=DBconnect.getConnection();
		stmt=con.createStatement();
		String sql="INSERT INTO verify VALUES(0,'"+email+"','"+Code+"')" ;
		int rs=stmt.executeUpdate(sql);
		
	}catch(Exception e) {
		
		e.printStackTrace();
	}
}
}
