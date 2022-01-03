package fr.webcatalog.ejb;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fr.webcatalog.model.Categorie;
import fr.webcatalog.model.Produits;

/**
 * Session Bean implementation class AccesCatalogueBean
 */
@Stateless
@LocalBean
public class AccesCatalogueBean implements AccesCatalogueBeanRemote, AccesCatalogueBeanLocal {

    /**
     * Default constructor. 
     */
    public AccesCatalogueBean() {
        // TODO Auto-generated constructor stub
    }
    @PersistenceContext(unitName="WebCatDS")
	private EntityManager em;
	
	@Override
	public List<Categorie> getAllCategories() {
		Query req=em.createQuery("select c from Categorie c");
		return req.getResultList();
	}

	@Override
	public List<Produits> getAllProduits(String nameCat) {
		Query req=em.createQuery("select p from Produits p where p.categorie.nom LIKE :nameCat");	
		req.setParameter("nameCat",nameCat);
		return req.getResultList();
	}

}
