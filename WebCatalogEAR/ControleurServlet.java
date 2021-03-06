package fr.webcatalog.info;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.webcatalog.ejb.AccesCatalogueBeanLocal;
import fr.webcatalog.model.Categorie;

/**
 * Servlet implementation class ControleurServlet
 */
@WebServlet("/ControleurServlet")
public class ControleurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	@EJB
	private AccesCatalogueBeanLocal metier;
	
    public ControleurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String requri = request.getRequestURI().substring(request.getContextPath().length());
		//String requri  = request.getServletPath(); //get requested url
		String page = "";
				
		if(requri.equals("/categories/") || requri.equals("/categories")) {
			
			List<Categorie> categories = metier.getAllCategories();		
			page = "pages/categories.jsp";
			request.setAttribute("categories", categories);
			request.getRequestDispatcher(page).forward(request, response);
			
		}else if(requri.equals("/about/") || requri.equals("/about")) {
			page = "about.jsp";			
		}
		System.out.println(page);
		request.getRequestDispatcher(page).forward(request, response);
		//return;
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
