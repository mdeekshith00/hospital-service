package com.hospital.entity;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;

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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "hospital_donation")
public class HospitalDonation { //  (hospital contributing to central inventory)
	
	   @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	    )
	private UUID donationId;
//	private Integer hospitalId;
	private List<String> componentDetails;
	private String  testsAttached; // (docs/HL7/FHIR payload)
	private String status;  // (PENDING_VERIFICATION, TESTS_PASSED, TESTS_FAILED, TRANSFERRED)
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "hospital_id", nullable = false)
	private Hospital hospital;

//	public void add(HospitalDonation donations) {
//		// TODO Auto-generated method stub
//		
//	}
	
}
