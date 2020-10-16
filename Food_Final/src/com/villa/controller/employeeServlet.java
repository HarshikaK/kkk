package com.villa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.villa.Deo.employeeDeo;

import com.villa.bean.employeeBean;

/**
 * Servlet implementation class employeeServlet
 */
@WebServlet("/employeeServlet")
public class employeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public employeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Name = request.getParameter("Name");
		String Venue = request.getParameter("Venue");
		String Date= request.getParameter("Date");
		
		if(Name.isEmpty()||Venue.isEmpty()||Date.isEmpty()) {
			if(Name == "") {
				request.setAttribute("errMessage","Name Required!!");
				request.setAttribute("Name",Name);
				request.setAttribute("Venue",Venue);
				request.setAttribute("Date",Date);
				getServletContext().getRequestDispatcher("/MaintainEmployeeSheduling.jsp").forward(request, response);
			}
			if(Venue == "") {
				request.setAttribute("errMessage","Venue Required!!");
				request.setAttribute("Name",Name);
				request.setAttribute("Venue",Venue);
				request.setAttribute("Date",Date);
				getServletContext().getRequestDispatcher("/MaintainEmployeeSheduling.jsp").forward(request, response);
			}
			if(Date == "") {
				request.setAttribute("errMessage","Date Required!!");
				request.setAttribute("Name",Name);
				request.setAttribute("Venue",Venue);
				request.setAttribute("Date",Date);
				getServletContext().getRequestDispatcher("/MaintainEmployeeSheduling.jsp").forward(request, response);
			}
		}
	
		else {
		
			employeeBean employee = new employeeBean();
		
			employee.setName(Name);
			employee.setVenue(Venue);
			employee.setDate(Date);
		
		
			String output =  employeeDeo.Employee(employee);
			System.out.println(output);
			if (output == "DB connected successfully!") {
				getServletContext().getRequestDispatcher("/MaintainEmployeeShedulingView.jsp").forward(request, response);

			}
		 
		}	
		
	}

	}


