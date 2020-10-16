package com.villa.Deo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.villa.DB.DBConnection;
import com.villa.bean.FoodBean;

public class FoodDeo {

	public static String FooodAdd(FoodBean foo)
	{
		String FoodName = foo.getFoodName();
		String Quantity = foo.getQuantity();
		String Date = foo.getDate();
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
				String sql = "insert into foo(FoodName,Quantity,Date) values(?,?,?) ";
				preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1,FoodName);
				preparedStatement.setString(2,Quantity);
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

