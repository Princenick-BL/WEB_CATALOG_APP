<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.webcatalog.model.Produits"%>
<%@page import="fr.webcatalog.model.*"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<header >
	<%request.getParameter("pageName");%>
	<p>MA BOUTIQUE</p>
	 <nav class="navMenu">
      <a href="/WebCatalogApp">Acceuil</a>
      <a href="categories">Catégories</a>
      <%
      	String cat = request.getParameter("cat");
      	if(cat != null){
      	%>
	      	<a href="?cat=<%=request.getParameter("cat")%>&cart=true">Votre Panier</a>	
	    <%
      	}else{
      		%>
      		<a href="?cart=true">Votre Panier</a>
      		<%
      	}
      %>
      <div class="dot"></div>
    </nav>
</header>
	<% 
		String cart = request.getParameter("cart");
		if(cart!=null && cart!="" && cart!="null"){
		%>
			<div class="cart">
				<span class="dimiss"><a href="?cat=<%=cat%>">x</a></span>
				<br>
				<h1>Votre panier</h1>
				<% 
					Panier panier = null;
					panier = (Panier)session.getAttribute("panier");
					if(panier!=null ){
						List produits = panier.getProduits();
			        	for(Produit_Commande p:(ArrayList<Produit_Commande>)produits){%>
			               <h3>a</h3>
			            <%}	
					}
		       	%>
			</div>
		<%
		}
	%>
</html>