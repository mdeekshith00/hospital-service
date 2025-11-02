package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = " hospital_inventory")
public class HospitaiInventory implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Integer hospitalInventoryId ;
	
	private Integer componentId; // (if linked to central Blood-Service unit) or `localUnitId)
	
	private String  bloodGroup;
	
	private String  StringcomponentType; //  (RBC, Plasma, Platelet)
	
	private String volumeMl;
	
	private LocalDate expiryDate;
	
	private String status;  // (AVAILABLE, RESERVED, ISSUED, TRANSFERRED, EXPIRED)
	
	private String source ; // (OWN, CENTRAL, DONATION)
	
	private String storageLocation ; //  (fridge id)
	
	@ManyToOne
	@JoinColumn(name = "hospitaiInventory")
	@JsonBackReference
	private Hospital hospital;

}
