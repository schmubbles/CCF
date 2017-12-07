package boundaryLayer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import logicLayer.logicLayer;
import objectLayer.Player;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static  String  templateDir = "";
	static  String  resultTemplateName = "sign-up.ftl"; 
	
	private Configuration  cfg;
	
	public void init()
	{
	    // Prepare the FreeMarker configuration;
	    // - Load templates from the WEB-INF/templates directory of the Web app.
	    //
		cfg = new Configuration();
	    cfg.setServletContextForTemplateLoading(getServletContext(), "");
	}

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    	super();
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

		Template resultTemplate = null; 
		BufferedWriter toClient = null;
		
		resultTemplate = cfg.getTemplate( resultTemplateName );
		
	    toClient = new BufferedWriter(new OutputStreamWriter(response.getOutputStream(), resultTemplate.getEncoding())); 
		
	    response.setContentType("text/html; charset=" + resultTemplate.getEncoding());

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
		
		Map<String,Object> root = new HashMap<String,Object>();
		 
		 root.put("Players", players); 
		 
		 try 
		 {
			resultTemplate.process(root, toClient);
		 } 
		 catch (TemplateException e) 
		 {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
	
	

}
