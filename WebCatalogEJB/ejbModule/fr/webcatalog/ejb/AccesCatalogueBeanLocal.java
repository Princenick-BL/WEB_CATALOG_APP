package fr.webcatalog.ejb;

import java.util.List;

import javax.ejb.Local;

import fr.webcatalog.model.Categorie;
import fr.webcatalog.model.Produits;

@Local
public interface AccesCatalogueBeanLocal {
	public List<Categorie> getAllCategories() ;
	public List<Produits> getAllProduits(String cat) ;
}
