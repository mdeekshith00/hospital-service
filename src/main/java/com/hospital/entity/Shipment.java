package com.hospital.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
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
public class Shipment {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID",strategy = "org.hibernate.id.UUIDGenerator")
	private UUID shipmentId;
	@Column
	private String fromLocation; // (hospitalId or central)
	@Column
	private String toLocation;
	@Column
	private String components;
	@Column
	private String temperatureLog;
	@Column
	private String status; // (IN_TRANSIT, DELIVERED, FAILED)
	@Column
	private String carrierInfo;
	
//	private Shipment shipment;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sender_hospital_id", nullable = false)
	private Hospital senderHospital;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "receiver_hospital_id", nullable = false)
	private Hospital receiverHospital;

}
