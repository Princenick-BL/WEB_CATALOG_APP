<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="fr.webcatalog.model.Categorie"%>
    
<!DOCTYPE html>
<div  class="siderMenu">
	<p>Categories</p>
	<ul>
		<% 
			ArrayList<Categorie> categories = null;
			categories = (ArrayList<Categorie>)request.getAttribute("categories");
			if(categories!=null && categories.size()!=0){
	        	for(Categorie c:categories){%>
	                <li><a href="categories?cat=<%=c.getNom()%>"><%=c.getNom()%></a></li>
	            <%}	
			}
       	%>
	</ul>

</div>
