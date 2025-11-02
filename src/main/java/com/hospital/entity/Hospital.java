package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.hospital.enums.ApprovalStatus;
import com.hospital.enums.HospitalType;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Hospitals")
public class Hospital  implements Serializable{

	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "hospital_id")
	    private Long hospitalId;

	    @Column(name = "hospital_name", nullable = false)
	    private String hospitalName;

	    @Column(name = "registration_number", nullable = false, unique = true, length = 10)
	    private String registrationNumber;
	    
	    @Column(name = "license_no", nullable = false, unique = true)
	    private String licenseNo;   // Govt/Health Dept license
	    
	    @Column
	    private LocalDate licenseExpiry;
	    
	    @Column(name = "type", nullable = false)
	    @Enumerated(EnumType.STRING)
	    private HospitalType type;  

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
	    private ApprovalStatus approvalStatus = ApprovalStatus.PENDING;

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
	    @JsonManagedReference
	    private Set<HospitalUser> hospitalUser = new HashSet<>();

	    @OneToMany(mappedBy = "hospital",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<HospitalRequest> hospitalRequest ;
	    
	    @OneToMany(mappedBy = "hospital", fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<HospitalDonation> hospitalDonations ;
	    
	    @OneToMany(mappedBy = "senderHospital", fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<Shipment> sentShipments ;

	    @OneToMany(mappedBy = "receiverHospital", fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<Shipment> receivedShipments ;
	    
	    @OneToMany(mappedBy = "hospital" , fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<HospitalAuditLog> hospitalAuditLog ;
	    
	    @OneToMany(mappedBy = "hospital" , fetch = FetchType.LAZY)
	    @JsonManagedReference
	    private List<HospitaiInventory> hospitaiInventory; 

	    public void addRequest(HospitalRequest request) {
	    	hospitalRequest.add(request);
	        request.setHospital(this);
	    }

	    public void removeRequest(HospitalRequest request) {
	    	hospitalRequest.remove(request);
	        request.setHospital(null);
	    }
	    // add or remove 
	    public void addDonation(HospitalDonation donation) {
	    	hospitalDonations.add(donation);
	    	donation.setDonationId(null);
	    }
	    public void removeDonation(HospitalDonation donation) {
	    	hospitalDonations.remove(donation);
	    	donation.setDonationId(null);
	    }
//	    add or remove sent  shipment 
	    public void addShipment(Shipment shipment) {
	    	sentShipments.add(shipment);
	    	shipment.setShipmentId(null);
	    }
	    public void removeShipment(Shipment shipment) {
	    	sentShipments.remove(shipment);
	    	shipment.setShipmentId(null);
	    }
//	     add or remove  recieved shipment 
	    public void addReeivedShipment(Shipment shipment) {
	    	receivedShipments.add(shipment);
	    	shipment.setShipmentId(null);
	    }
	    public void removeReceivedShipment(Shipment shipment) {
	    	receivedShipments.remove(shipment);
	    	shipment.setShipmentId(null);
	    }
//	    add or remove  HospitalAuditLog
	    public void addHospitalAuditLog(HospitalAuditLog auditLog) {
	    	hospitalAuditLog.add(auditLog);
	    	auditLog.setHospitalAuditLogId(null);
	    }
	    public void removeHospitalAuditLog(HospitalAuditLog auditLog) {
	    	hospitalAuditLog.remove(auditLog);
	    	auditLog.setHospitalAuditLogId(null);
	    }
//	     add or remove HospitaiInventory
	    public void addHospitaiInventory(HospitaiInventory inventory) {
	    	hospitaiInventory.add(inventory);
	    	inventory.setHospitalInventoryId(null);
	    }
	    public void removeHospitaiInventory(HospitaiInventory inventory) {
	    	hospitaiInventory.remove(inventory);
	    	inventory.setHospitalInventoryId(null);
	    }

}
