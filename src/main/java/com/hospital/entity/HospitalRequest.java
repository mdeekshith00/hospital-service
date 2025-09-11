package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
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
@Builder
@Entity
@Table(name = "hospital_requests")
public class HospitalRequest implements Serializable{
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	   @Id
	    @GeneratedValue(generator = "UUID")
	    @GenericGenerator(
	        name = "UUID",
	        strategy = "org.hibernate.id.UUIDGenerator"
	    )
	    private UUID requestId ;
		
		private String requestedBy; //  (staffId)

	    @ManyToOne(fetch = FetchType.LAZY, optional = false)
	    @JoinColumn(name = "hospital_id", nullable = false)
	    private Hospital hospital;  // hospitalId

	    @Column(nullable = false)
	    private String bloodGroup;   // e.g. A+, O-

	    @Column(nullable = false)
	    private Integer unitsRequested;

	    @Column(nullable = false)
	    private String priority;     // ROUTINE, URGENT, EMERGENCY
        @Column
	    private String status;       //  (PENDING, APPROVED, PARTIAL_FULFILLED, FULFILLED, REJECTED, CANCELLED)
	    @Column
	    private LocalDateTime requestDate;
	    @Column
	    private LocalDateTime preferredDeliveryTime;
        @Column
	    private String notes;
	    @Column
	    private LocalDateTime createdAt;
	    @Column
	    private LocalDateTime updatedAt;
	

}
