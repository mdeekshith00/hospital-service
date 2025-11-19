package com.hospital.entity;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "shipment")
public class Shipment implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shipment_id")
	private Integer shipmentId;
	@Column
	private String fromLocation; // (hospitalId or central)
	@Column
	private String toLocation;
	@Column
	private String components;
	@Column
	private String temperatureLog;
	@Column
	private String status; 
	@Column
	private String carrierInfo;
	
//	private Shipment shipment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_hospital_id", nullable = false)
	@JsonBackReference
	private Hospital senderHospital;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receiver_hospital_id", nullable = false)
	@JsonBackReference
	private Hospital receiverHospital;

}
