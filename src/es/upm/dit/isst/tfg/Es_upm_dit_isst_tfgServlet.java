package es.upm.dit.isst.tfg;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import es.dit.upm.isst.t4.dao.TFGDAO;
import es.dit.upm.isst.t4.dao.TFGDAOImpl;
import es.upm.dit.isst.t4.model.TFG;

@SuppressWarnings("serial")
public class Es_upm_dit_isst_tfgServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		TFGDAO dao = TFGDAOImpl.getInstance();
		dao.create("Manolo", "Primer TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Agustín", "Segundo TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Jose Luis", "Tercer TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("María Jesús", "Cuarto TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Sebastián", "Quinto TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		dao.create("Josefina", "Sexto TFG", "Mejor TFG de la historia", "Antonio", "Sergio", "doc.pdf", true);
		
		//Código para un acceso básico a una DB
		resp.setContentType("text/plain");
		String autor = "Manolo";
		List<TFG> tfg = dao.listTFGAll();
		for(TFG t: tfg) {
			resp.getWriter().println(t.toString(t));
		}
		
		

	}
}
