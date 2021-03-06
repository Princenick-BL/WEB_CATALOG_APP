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

@Entity @Table(name = "CommandeClient")
public class Commande_Client implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int commande_client_id;
	private float  montant;
	
	private Date date_creation = new Date();
	private int no_confirmation ;
	
	@ManyToOne(cascade = CascadeType.ALL)  @JoinColumn( name="client_id" )
    private Client client; 
	
	

	public int getCommande_client_id() {
		return commande_client_id;
	}

	public void setCommande_client_id(int commande_client_id) {
		this.commande_client_id = commande_client_id;
	}

	public float getMontant() {
		return montant;
	}

	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public int getNo_confirmation() {
		return no_confirmation;
	}

	public void setNo_confirmation(int no_confirmation) {
		this.no_confirmation = no_confirmation;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	

}