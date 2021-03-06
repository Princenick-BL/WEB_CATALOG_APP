package fr.webcatalog.model;


import java.io.Serializable;
import java.sql.Date;
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

@Entity @Table(name = "Produits")
public class Produits implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private float prix = 0;
	private String description;
	private Date dernier_maj ;
	private String image;
	
	
	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	@ManyToOne(cascade = CascadeType.ALL)  @JoinColumn( name="categorie_id" )
    private Categorie categorie; 
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public float getPrix() {
		return prix;
	}


	public void setPrix(float prix) {
		this.prix = prix;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDernier_maj() {
		return dernier_maj;
	}


	public void setDernier_maj(Date dernier_maj) {
		this.dernier_maj = dernier_maj;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	
}