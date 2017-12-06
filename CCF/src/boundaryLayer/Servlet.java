package boundaryLayer;

import java.io.IOException;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logicLayer.logicLayer;
import objectLayer.Player;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		logicLayer logicLayer = new logicLayer();
		
		HttpSession httpSession = request.getSession();
		System.out.println(httpSession.getAttribute("ssid"));
		
		List<Player> players = null;
		
		players = logicLayer.getAllPlayers();
		Collections.sort(players, new Comparator<Player>(){
			@Override
			public int compare(Player p1, Player p2) {
				  return Double.compare(p1.getRankValue(), p2.getRankValue());
			}
		});
		
		System.out.println(players.toString());
	}
	
	

}
