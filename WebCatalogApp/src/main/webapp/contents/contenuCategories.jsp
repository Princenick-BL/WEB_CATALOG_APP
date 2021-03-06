<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.webcatalog.model.Produits"%>
<%@page import="fr.webcatalog.model.Produit_Commande"%>
<%@page import="fr.webcatalog.model.Panier"%>
<%@page import="java.util.List" %>

<!DOCTYPE html>
<div class="content">
	<%
	    String cat = request.getParameter("cat");
		if(cat != null){
		%>
			<div>
				<h2><%= cat %></h2>
				<div class="produits">
				<% 
					ArrayList<Produits> produits = null;
					produits = (ArrayList<Produits>)request.getAttribute("produits");
					if(produits!=null && produits.size()!=0){
			        	for(Produits p:produits){%>
			                <form class="produit">
			                	<img class="produit_img" src="<%=p.getImage()%>" alt="image"/>
			                	<div class="produit_footer">
			                		
				                	<a href="categories?cat=<%=p.getNom()%>"><%=p.getNom()%></a>
				                	<br>
				                	<div class="quantite_zone">
				                		<label>Quantité : </label>
					                	<input type="number" id="quantity" name="quantity" min="1" value = "1">
				                	</div>
				                	<a id="submit_produit" href="?cat=<%=request.getParameter("cat")%>&cart=true&pID=<%=p.getId() %>" 
				                	onClick="addToCart(<%=p%>)">
				                	<div>Ajouter au panier</div></a>
			                	</div>
			                </form>
			            <%}	
					}
		       	%>
				</div>
			</div>
		<%
		}else{
		%>
			<div class="center">
				<h1>Choisissez une catégorie</h1>
			</div>
		<%
		}
		
	%>
	
</div>