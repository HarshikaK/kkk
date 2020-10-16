package com.villa.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.villa.Deo.FoodDeo;
import com.villa.bean.FoodBean;

/**
 * Servlet implementation class FoodServlet
 */
@WebServlet("/FoodServlet")
public class FoodServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FoodServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String FoodName = request.getParameter("FoodName");
		String Quantity = request.getParameter("Quantity");
		String Date = request.getParameter("Date");
		

		if(FoodName.isEmpty()||Quantity.isEmpty()||Date.isEmpty()) {
			if(FoodName == "") {
				request.setAttribute("errMessage","FoodName Required!!");
				request.setAttribute("FoodName",FoodName);
				request.setAttribute("Quantity",Quantity);
				request.setAttribute("Date",Date);
				getServletContext().getRequestDispatcher("/MaintainKitchenOrder.jsp").forward(request, response);
			}
			if(Quantity == "") {
				request.setAttribute("errMessage","Quantity Required!!");
				request.setAttribute("FoodName",FoodName);
				request.setAttribute("Quantity",Quantity);
				request.setAttribute("Date",Date);
				getServletContext().getRequestDispatcher("/MaintainKitchenOrder.jsp").forward(request, response);
			}
			if(Date == "") {
				request.setAttribute("errMessage","Date Required!!");
				request.setAttribute("FoodName",FoodName);
				request.setAttribute("Quantity",Quantity);
				request.setAttribute("Date",Date);
				getServletContext().getRequestDispatcher("/MaintainKitchenOrder.jsp").forward(request, response);
			}
		}
		
			else {
		
				FoodBean foo = new FoodBean();
				foo.setFoodName(FoodName);
				foo.setQuantity(Quantity);
				foo.setDate(Date);
		
				String output = FoodDeo.FooodAdd(foo);
				System.out.println(output);
				if (output == "DB connected successfully!") {
					getServletContext().getRequestDispatcher("/MaintainKitchenOrderView.jsp").forward(request, response);
					
					
					}
				
		
	}
		}
	}

	
