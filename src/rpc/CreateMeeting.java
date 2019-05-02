package rpc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;

import java.sql.*;


/**
 * Servlet implementation class Meeting
 */
@WebServlet("/createMeeting")
public class CreateMeeting extends HttpServlet {
	// private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateMeeting() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String eventName = request.getParameter("eventName");
        System.out.println("event name: " + eventName);
        String eventDescription = request.getParameter("eventDescription");
        if (eventDescription != null) {
            eventDescription = "None";
            System.out.println("description: " + eventDescription);
        }
        String[] days = request.getParameterValues("daysOfTheWeek");
        String daysOfTheWeek = "";
        if (days != null) {
        	for (int i = 0; i < days.length; i++) {
                daysOfTheWeek += days[i];
                System.out.println(days[i]);
            }
        }
        String startTime = request.getParameter("startTime");
        System.out.println("start time: " + startTime);
        String endTime = request.getParameter("endTime");
        System.out.println("end time: " + endTime);
        // TODO: validation, add to database
        
        
        // get new sql connection
        DBConnection connection = DBConnectionFactory.getConnection();
		connection.addEvent("1", daysOfTheWeek, eventName, eventDescription, startTime, endTime);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
}
