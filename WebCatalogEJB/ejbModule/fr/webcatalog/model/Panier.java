package fr.webcatalog.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

@Entity @Table(name = "Panier")
public class Panier implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int panier_id;
	private float  montant;
	
	@OneToMany( targetEntity=Produit_Commande.class, mappedBy="produit" )
	private List<Produit_Commande> produits = new ArrayList<>();

	public int getPanier_id() {
		return panier_id;
	}

	public void setPanier_id(int panier_id) {
		this.panier_id = panier_id;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public List<Produit_Commande> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit_Commande> produits) {
		this.produits = produits;
	}
	

}