package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Hospital;

public class DBOperation {

	static Connection con =null;
	public static void connect()
	{
		String url = "jdbc:mysql://localhost:3306/hospital1";
		String uname ="root";
		String upass ="root";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con =DriverManager.getConnection(url,uname,upass);
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void insert (Hospital h) {
		connect();
		try {
	PreparedStatement ps = con.prepareStatement("insert into patient value (?,?,?,?,?,?)");
	ps.setInt(1, h.getId());
	ps.setString(2, h.getName());
	ps.setInt(3, h.getAge());
	ps.setInt(4, h.getWard());
	ps.setString(5, h.getDoctor());
	ps.setString(6, h.getAdmit_date());
	
	if(!ps.execute()) {
		System.out.println("Data inserted");
	}
	else {
		System.out.println("Data not inserted");
	}
	con.close();
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}
	
	public static void delete (int id) {
		connect();
		
		try {
			PreparedStatement ps =con.prepareStatement("delete from patient where id =?");
			ps.setInt(1, id);
			if(!ps.execute()) {
				System.out.println("Dagta deleted");
			}
			else {
				System.out.println("Data not deleted");
			}
			con.close();
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void  view() {
		connect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from patient ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4)+" "+rs.getNString(5)+" "+rs.getString(6));
			}
			con.close();		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void update(Hospital h) {
		connect();
		try {
			PreparedStatement ps = con.prepareStatement("select * from  patient where id =?");
			ps.setInt(1, h.getId());
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			Hospital h1 = new Hospital() ;
			
			h1.setName(rs.getString(2));
			h1.setAge(rs.getInt(3));
			h1.setWard(rs.getInt(4));
			h1.setDoctor(rs.getString(5));
			h1.setAdmit_date(rs.getString(6));
			
			if(!h.getName().equals("null")) {
				h1.setName(h.getName());
			}  
			if(h.getAge()!=0) {
				h1.setAge(h.getAge());
			}
			if(h.getWard()!=0) {
				h1.setWard(h.getWard());
			}
			if(!h.getDoctor().equals("null")) {
				h1.setDoctor(h.getDoctor());
			}
			if(!h.getAdmit_date().equals("null")) {
				h1.setAdmit_date(h.getAdmit_date());
			}
			ps = con.prepareStatement("update patient set name = ?, age = ?, ward = ?, doctor = ?, admit_date = ? where id = ?");
			ps.setString(1, h1.getName());
			ps.setInt(2, h1.getAge());
			ps.setInt(3, h1.getWard());
			ps.setString(4,h1.getDoctor());
			ps.setString(5, h1.getAdmit_date());
			ps.setInt(6, h.getId());
			 if(!ps.execute())
			   {
				   System.out.println("data updated ");
			   }
			   else
			   {
				   System.err.println("could not perform update data");
			   }
			   con.close();
			
			}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
