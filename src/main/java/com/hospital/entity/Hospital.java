package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.hospital.enums.ApprovalStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Hospitals")
public class Hospital  implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long hospitalId;

	    @Column(name = "hospital_name", nullable = false, length = 100)
	    private String hospitalName;

	    @Column(name = "registration_number", nullable = false, unique = true, length = 50)
	    private String registrationNumber;
	    
	    @Column(name = "license_no", nullable = false, unique = true)
	    private String licenseNo;   // Govt/Health Dept license
	    
	    @Column
	    private LocalDate licenseExpiry;
	    
	    @Column(nullable = false)
	    private String type;  // // PUBLIC / PRIVATE / NGO / MILITARY (Public/Private)

//	    @Column(name = "license_document_url")
//	    @Lob
//	    private String licenseDocumentUrl;  // Store in S3 or File Service or store in db 

	    @Column(name = "contact_person", nullable = false)
	    private String contactPerson;

	    @Column(name = "contact_email", nullable = false)
	    private String contactEmail;

	    @Column(name = "contact_phone", nullable = false)
	    private String contactPhone;

	    @Column(name = "alternate_phone")
	    private String alternatePhone;

	    @Column(name = "website")
	    private String website;

	    // --- Address Info ---
	    @Column(name = "address_line1", nullable = false)
	    private String addressLine1;

	    @Column(name = "address_line2")
	    private String addressLine2;

	    @Column(name = "city", nullable = false)
	    private String city;

	    @Column(name = "state", nullable = false)
	    private String state;

	    @Column(name = "pincode", nullable = false)
	    private String pincode;

	    @Column(name = "country", nullable = false)
	    private String country;

	    // --- Operational Info ---
	    @Column(name = "is_active", nullable = false)
	    private boolean isActive = true;

	    @Column(name = "approval_status", nullable = false)
	    @Enumerated(EnumType.STRING)
	    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING; // PENDING, APPROVED, REJECTED , SUSPENDED

	    @Column(name = "verified", nullable = false)
	    private boolean verified = false;

	    @Column(name = "last_login")
	    private LocalDateTime lastLogin;
	    
	    // Operational Info
	    private String registrationAuthority;  // Issued by authority
	    private Integer capacity;              // No. of beds (optional)
	    private Integer bloodBankCapacity;     // Blood units hospital can store
	    private Boolean hasInHouseBloodBank;   // Own blood bank or not
	    private Boolean isEmergency24x7;       // 24/7 emergency availability

	    // --- Audit Info ---
	    @Column(name = "created_at", updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt = LocalDateTime.now();
	    
	    @OneToMany(mappedBy = "hospital", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	    private Set<HospitalUser> hospitalUser = new HashSet<>();

	    
	    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
	    private List<HospitalRequest> hospitalRequest ;
	    
	    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
	    private Set<HospitalDonation> donations = new HashSet<>();
	    
	    @OneToMany(mappedBy = "senderHospital", fetch = FetchType.LAZY)
	    private Set<Shipment> sentShipments = new HashSet<>();

	    @OneToMany(mappedBy = "receiverHospital", fetch = FetchType.LAZY)
	    private Set<Shipment> receivedShipments = new HashSet<>();

	    public void addRequest(HospitalRequest request) {
	    	hospitalRequest.add(request);
	        request.setHospital(this);
	    }

	    public void removeRequest(HospitalRequest request) {
	    	hospitalRequest.remove(request);
	        request.setHospital(null);
	    }
	    
//	    public void addDonations(HospitalDonation donations) {
//	    	donations.add(donations);
//	    	donations.setHospital(this);
//	    }

//	    public void removeRequest(HospitalRequest request) {
//	    	hospitalRequest.remove(request);
//	        request.setHospital(null);
//	    }

	    

	


}
