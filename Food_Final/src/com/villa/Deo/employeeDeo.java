package com.villa.Deo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.villa.DB.DBConnection;
import com.villa.bean.employeeBean;

public class employeeDeo {

	public  static String Employee(employeeBean employee) {
		
		String Name =employee .getName();
		String Venue = employee.getVenue();
		String Date = employee.getDate();
		/*
		 * SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 * java.util.Date dateStr = null; try { dateStr = formatter.parse(Date); } catch
		 * (ParseException e1) {
		 * 
		 * e1.printStackTrace(); } java.sql.Date dateDB = new
		 * java.sql.Date(dateStr.getTime());
		 * 
		 */
		
		
		 Connection con = null;
			PreparedStatement preparedStatement = null;
			
			try {
				con = DBConnection.createConnection();
				String sql = "insert into employee(Name,Venue,Date ) values(?,?,?) ";
				preparedStatement = con.prepareStatement(sql);
				
				
				preparedStatement.setString(1,Name);
				preparedStatement.setString(2,Venue);
				preparedStatement.setString(3,Date);
				
				

				int i = preparedStatement.executeUpdate();
				
				if(i != 0)
					return "DB connected successfully!";
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "Something went wrong!";
				
			 
	}
}
			

