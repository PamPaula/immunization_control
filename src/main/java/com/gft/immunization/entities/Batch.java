package com.gft.immunization.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Batch {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message="O campo não pode ser vazio.")
	private Integer identification;
	
	@NotNull(message="O campo não pode ser vazio.")
	private Integer qtyReceived;
	
	@NotNull(message="O campo não pode ser vazio.")
	private Integer qtyRemaining;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="O campo não pode ser vazio.")
	private Date deliveryDate;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message="O campo não pode ser vazio.")
	private Date expirationDate;
	
	@ManyToOne
	@NotNull(message="O campo não pode ser vazio.")
	private Vaccine vaccine;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getIdentification() {
		return identification;
	}

	public void setIdentification(Integer identification) {
		this.identification = identification;
	}

	public Integer getQtyReceived() {
		return qtyReceived;
	}

	public void setQtyReceived(Integer qtyReceived) {
		this.qtyReceived = qtyReceived;
	}

	public Integer getQtyRemaining() {
		return qtyRemaining;
	}

	public void setQtyRemaining(Integer qtyRemaining) {
		this.qtyRemaining = qtyRemaining;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Vaccine getVaccine() {
		return vaccine;
	}

	public void setVaccine(Vaccine vaccine) {
		this.vaccine = vaccine;
	}

}
