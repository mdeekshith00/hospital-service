package com.hospital.entity;

import java.io.Serializable;
import java.util.List;
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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hospital_donation")
public class HospitalDonation implements Serializable{  
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//  (hospital contributing to central inventory)
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Column(name = "hospital_donation_id")
	 private Integer donationId;

	private List<String> componentDetails;
	private String  testsAttached; // (docs/HL7/FHIR payload)
	private String status;  // (PENDING_VERIFICATION, TESTS_PASSED, TESTS_FAILED, TRANSFERRED)
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hospital_id", nullable = false)
	@JsonBackReference
	private Hospital hospital;

	
}
