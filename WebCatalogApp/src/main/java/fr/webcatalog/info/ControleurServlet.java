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
import javax.servlet.http.HttpSession;

import fr.webcatalog.ejb.AccesCatalogueBeanLocal;
import fr.webcatalog.model.Categorie;
import fr.webcatalog.model.Produits;
import fr.webcatalog.model.Panier;
import fr.webcatalog.model.Produit_Commande;

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
				
		if(requri.equals("/") || requri.equals("")) {
			
			page = "index.jsp";
			request.getRequestDispatcher(page).forward(request, response);

		}else if(requri.equals("/categories/") || requri.equals("/categories")) {
			
			
			//Liste des catégories
			List<Categorie> categories = metier.getAllCategories();
			request.setAttribute("categories", categories);
			
			//Liste des produits selon la catégories 
			String cat = request.getParameter("cat");
			if(cat!=null) {
				List<Produits> produits = metier.getAllProduits(cat);	
				request.setAttribute("produits", produits);
			}
			
			//Ajout au panier
			String pID = request.getParameter("pID");		
			if(pID!=null) {
				
				if(request.getSession().getAttribute("Panier")==null) {
					Panier new_panier = new Panier();
					request.getSession().setAttribute("panier", new_panier) ;
				}
				
				Panier panier = (Panier)request.getSession().getAttribute("Panier");
				List<Produit_Commande> product_list = (List<Produit_Commande>)panier.getProduits();
				
			}
			
			
			
			page = "pages/categories.jsp";	
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
