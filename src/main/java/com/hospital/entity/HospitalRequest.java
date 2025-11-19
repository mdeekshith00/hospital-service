package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hospital.enums.HospitalRequestStatus;
import com.hospital.enums.PriorityType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Builder
@Entity
@Table(name = "hospital_requests")
public class HospitalRequest implements Serializable{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "request_id" , nullable = false)
	   private Integer requestId ;
	   
		@Column(name = "request_by")
		private String requestedBy; 
 
	    @Column(nullable = false)
	    private String bloodGroup;   // e.g. A+, O-

	    @Column(nullable = false)
	    private Integer unitsRequested;

	    @Column(name = "priority", nullable = false)
	    @Enumerated(EnumType.STRING)
	    private PriorityType priority;   
	    
	    @Column(name = "status", nullable = false)
	    @Enumerated(EnumType.STRING)
	    private HospitalRequestStatus status = HospitalRequestStatus.PENDING; 
	    
	    @Column(name = "request_date")
	    private LocalDateTime requestDate;
	    
	    @Column(name = "preferred_delivery_time")
	    private LocalDateTime preferredDeliveryTime;
       
	    private String notes;
	    
	    @Column(name = "created_at")
	    private LocalDateTime createdAt;
	    
	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	    
	    @ManyToOne(optional = false)
	    @JoinColumn(name = "hospital_id")
	    @JsonBackReference
	    private Hospital hospital;
	

}
