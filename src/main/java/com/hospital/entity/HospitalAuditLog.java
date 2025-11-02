package com.hospital.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "Hospitals")
public class HospitalAuditLog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name = "hospital_audit_log")
	private Integer HospitalAuditLogId;
	
	private String action;
	@Column(name = "updated_at")
	private Timestamp updatedAt;
	
	private String notes;
	
	@ManyToOne
	@JoinColumn(name = "hospitalAuditLog")
	@JsonBackReference
	private Hospital hospital;


}
