package fr.webcatalog.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name = "ProduitCommande")
public class Produit_Commande implements Serializable {
	
	private int quantite = 1;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)  @JoinColumn( name="commande_client_id" )
    private Panier panier; 

	@ManyToOne(cascade = CascadeType.ALL)  @JoinColumn( name="id" )
    private Produits produit; 
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public Panier getPanier() {
		return panier;
	}

	public void setPanier(Panier panier) {
		this.panier = panier;
	}

	public Produits getProduit() {
		return produit;
	}

	public void setProduit(Produits produit) {
		this.produit = produit;
	}


	
	

}