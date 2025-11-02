package com.hospital.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.hospital.enums.ChangeType;
import com.hospital.enums.HistoryStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = " hospital_history")
public class HospitalHistory implements Serializable {

	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "hspital_history_id")
	    private Integer HospitalHistoryId;

	    // Link to Hospital
	    @Column(name = "hospital_id", nullable = false)
	    private Integer hospitalId;

	    // Optional: Track user who made the change (could be admin)
	    @Column(name = "changed_by_user_id")
	    private Long changedByUserId;

	    // What field or action was changed
	    @Column(name = "change_type", nullable = false)
	    @Enumerated(EnumType.STRING)
	    private ChangeType changeType;

	    @Column(name = "description", columnDefinition = "TEXT")
	    private String description;

	    // Before and after snapshots for audit (optional but useful)
	    @Column(name = "previous_value", columnDefinition = "TEXT")
	    private String previousValue;

	    @Column(name = "new_value", columnDefinition = "TEXT")
	    private String newValue;

	    @Column(name = "change_timestamp", nullable = false)
	    private LocalDateTime changeTimestamp;

	    // Optional: Reason for change
	    @Column(name = "reason", columnDefinition = "TEXT")
	    private String reason;

	    @Column(name = "status", nullable = false)
	    @Enumerated(EnumType.STRING)
	    private HistoryStatus status = HistoryStatus.SUCCESS; // or FAILED, PENDING

	    // Optional: Track source system or IP
	    @Column(name = "source_ip")
	    private String sourceIp;

	    @Column(name = "created_at", updatable = false)
	    private LocalDateTime createdAt = LocalDateTime.now();
	    
	    @Column(name = "updated_at", updatable = false)
	    private LocalDateTime updatedAt = LocalDateTime.now();
}
