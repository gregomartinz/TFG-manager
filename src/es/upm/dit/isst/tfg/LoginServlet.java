package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.t4.dao.TFGDAO;
import es.dit.upm.isst.t4.dao.TFGDAOImpl;
import es.upm.dit.isst.t4.model.TFG;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		
		//Código para un servlet de login sencillo
//		UserService userService = UserServiceFactory.getUserService();
//		String url = userService.createLoginURL(req.getRequestURI());
//		String urlLinktext = "Login";
//		resp.setContentType("text/html");            
//		if (req.getUserPrincipal() != null){
//		    url = userService.createLogoutURL(req.getRequestURI());
//		    urlLinktext = "Logout";
//	        	    resp.getWriter().println("<p>Hola " + req.getUserPrincipal().getName() + "</p>");
//		}
//		resp.sendRedirect("/MostrarTFGView");
//		//resp.getWriter().println("<p>Pulsa <a href=\"" + url + "\">" + urlLinktext + "“</a>.</p>");
		
		
		TFGDAO dao = TFGDAOImpl.getInstance();
		
		dao.create("Manolo", "Primer TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Agustín", "Segundo TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Jose Luis", "Tercer TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("María Jesús", "Cuarto TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Sebastián", "Quinto TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Josefina", "Sexto TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);

		//Código para un servlet de login guardando users
		UserService userService = UserServiceFactory.getUserService();
		String url = userService.createLoginURL(req.getRequestURI());
		String urlLinktext = "Login";
		String user = "";
		List<TFG> tfgs = dao.listTFGAll();
		
		if (req.getUserPrincipal() != null){
			user = req.getUserPrincipal().getName();
			url = userService.createLogoutURL(req.getRequestURI());
			urlLinktext = "Logout";
		}
		req.getSession().setAttribute("user", user);
		req.getSession().setAttribute("url", url);
		req.getSession().setAttribute("urlLinktext", urlLinktext);
		req.getSession().setAttribute("tfgs", new ArrayList<TFG>(tfgs));
		//req.getSession().setAttribute("tfgs", dao.listTFGAll());
		RequestDispatcher	view =	req.getRequestDispatcher("MostrarTFGView.jsp");
		view.forward(req,	resp);
	}

}
