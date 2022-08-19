package dk.tec.example1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import dk.tec.AnalyseRequest;
import dk.tec.DBTools;
import dk.tec.Elev;


@WebServlet("/TheServlet")
public class TheServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		//out.println("Context Path: " + request.getContextPath());
		//out.println("Servlet Path: " + request.getServletPath());
		//out.println("PathInfo: " + request.getPathInfo());
		//out.println("Request URL: " + request.getRequestURL() + "<br/>");
		//out.println("\n");
		
		List<Elev> elever = new ArrayList<Elev>();
		elever.add(new Elev(1, "Berk", "Træner"));
		elever.add(new Elev(2, "Kasper", "Tagfejer"));
		elever.add(new Elev(3, "Nikolaj", "Gamer"));
		elever.add(new Elev(4, "Nirakash", "Programmer"));
		elever.add(new Elev(5, "Mie", "Storsindet"));
		
		AnalyseRequest analyse = new AnalyseRequest(request.getPathInfo());
		ObjectMapper mapper = new ObjectMapper();
		
		DBTools db = new DBTools();
		//Elev e = db.getElevById(3);
		
		switch(analyse.getLevel())
		{
		case MatchElevId:
			int id = analyse.getId();
			//out.println("Match på Elev og Id = " + id);
			// Uden database:
			out.println(mapper.writeValueAsString(elever.get(id)));
			// Med database:
			//Elev elev = db.getElevById(id);
			//out.println(mapper.writeValueAsString(elev));
			break;
			
		case MatchElev:
			//out.println("Match på Elev");
			//out.println(mapper.writeValueAsString(elever));
			break;
			
		case MatchNo:
			//out.println("Ingen match");
			break;
		}
	}
}
