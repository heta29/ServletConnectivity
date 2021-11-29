package com.ecom;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JDBCDemo
 */
@WebServlet("/JDBCDemoServlet")
public class JDBCDemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JDBCDemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
			PrintWriter out=response.getWriter();
			out.println("<html><body>");
			InputStream fis = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
			Properties props= new Properties();
			
			props.load(fis);
			DBConnection con= new DBConnection(props.getProperty("dburl"),props.getProperty("username"),props.getProperty("password"));
			out.println("Connection is established");
			
			con.closeConection();
			out.println("Connection is closed");
			
			
		}
		catch(ClassNotFoundException | SQLException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
