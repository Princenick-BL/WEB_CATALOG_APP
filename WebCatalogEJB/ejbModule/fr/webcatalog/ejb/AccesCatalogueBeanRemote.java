package fr.webcatalog.ejb;

import java.util.List;

import javax.ejb.Remote;

import fr.webcatalog.model.Categorie;
import fr.webcatalog.model.Produits;

@Remote
public interface AccesCatalogueBeanRemote {
	public List<Categorie> getAllCategories() ;
	public List<Produits> getAllProduits(String cat) ;
}
